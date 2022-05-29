package uniandes.isis2304.parranderos.interfazApp;
import uniandes.isis2304.parranderos.negocio.Parranderos;
import uniandes.isis2304.parranderos.negocio.VOReserva;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.jdo.JDODataStoreException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.FileReader;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;

@SuppressWarnings("serial")

public class RecepcionistaView extends JFrame implements ActionListener {

    //Logger °
    private static Logger log = Logger.getLogger(InterfazParranderosApp.class.getName());

    //ruta archivo config de las tablas °
    private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 
	
    //No se si hacer ruta para cada tabla o solo ponerla



    /* Atributos*/

    //Asociación a parranderos
    private Parranderos parranderos;

    //Json con las tablas de datos
    private JsonObject tableConfig;

    /* Interfaz */
    private JsonObject guiConfig;

    //menu de la barra de opciones
    private JMenuBar menuBar;

    //Panel de despliegue
    private PanelDatos panelDatos;

    private LoginView login;

    private RecepcionistaView window;


    public RecepcionistaView(LoginView ventana) {

        window = this;

        login = ventana;

        guiConfig = openConfig ("Interfaz", "./src/main/resources/config/interfaceRecepcionistaView.json");
        
        iniciarFrame();
        if (guiConfig != null) {
            crearMenu(guiConfig.getAsJsonArray("menuBar"));
        }

        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        parranderos = new Parranderos (tableConfig);

        //String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos();
        setLayout(new BorderLayout());
        //add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );
        add( panelDatos, BorderLayout.CENTER );
    }

    public void iniciarFrame() {
        JFrame frame = new JFrame("Recepcionista");
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(300, 40, 200, 200);

        int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null )
    	{
    		log.info ( "Se aplica configuración por defecto" );			
			titulo = "Recepcionista View Default*";
			alto = 300;
			ancho = 500;
    	}
    	else
    	{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
    		titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
    	}

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocation (50,50);
        setResizable( true );
        setBackground( Color.WHITE );
        setTitle( titulo );
		setSize ( ancho, alto);
        addWindowListener(new WindowAdapter() {
            @Override
                public void windowClosing(WindowEvent e) {
                    window.dispose();
                    login.setVisible(true);
                    //hotelandes.cerrarUnidadPersistencia();
            }
            });

        this.setVisible(true);

    }

    
    //Funciones importantes
    private void crearMenu(  JsonArray jsonMenu )
    {    	
    	// Creación de la barra de menús
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creación de cada uno de los menús
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get("menuTitle").getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray("options");
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creación de cada una de las opciones del menú
        		JsonObject jo = op.getAsJsonObject(); 
        		String lb =   jo.get("label").getAsString();
        		String event = jo.get("event").getAsString();
        		
        		JMenuItem mItem = new JMenuItem( lb );
        		mItem.addActionListener( this );
        		mItem.setActionCommand(event);
        		
        		menu.add(mItem);
        	}       
        	menuBar.add( menu );
        }        
        setJMenuBar ( menuBar );	
    }

    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }

    
    /*Métodos para el Recepcionista*/

    //Registrar la llegada de un cliente
    public void registrarLlegadaCliente()
    {
        try 
        {
            Long idCliente = (Long.valueOf(JOptionPane.showInputDialog (this, "Cedula del cliente que llega?", "Agregar CheckIn", JOptionPane.QUESTION_MESSAGE))) ;
            Long idReserva = (Long.valueOf(JOptionPane.showInputDialog (this, "numero de la reserva?", "Agregar CheckIn", JOptionPane.QUESTION_MESSAGE))) ;
            if (idCliente != null && idReserva != null)
            {
                VOReserva r = parranderos.registrarCheckInCliente(idCliente, idReserva);
                if (r == null)
                {
                    throw new Exception ("No se pudo registrar la llegada del cliente: " + idCliente);
                }
                String resultado = "En registrarLlegadaCliente\n\n";
                resultado += "Llegada del cliente exitosa: " + r;
                resultado += "\n Operación terminada";
                panelDatos.actualizarInterfaz(resultado);
            }
            else
            {
                panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            }
        }
        catch (Exception e) 
        {
//          e.printStackTrace();
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }

    //Registrar la salida de un cliente
    public void registrarSalidaCliente()
    {
        try 
        {
            Long idCliente = (Long.valueOf(JOptionPane.showInputDialog (this, "Ingrese la cédula del cliente", "Agregar CheckOut", JOptionPane.QUESTION_MESSAGE))) ;
            Long idReserva = (Long.valueOf(JOptionPane.showInputDialog (this, "Ingrese el número de la reserva correspondiente", "Agregar CheckOut", JOptionPane.QUESTION_MESSAGE))) ;
            if (idCliente != null && idReserva != null)
            {
                VOReserva reserv = parranderos.registrarCheckOutCliente(idCliente, idReserva);
                if (reserv == null)
                {
                    throw new Exception ("No se pudo registrar la llegada del cliente: " + idCliente);
                }
                String resultado = "En registrarSalidaCliente\n\n";
                resultado += "Salida del cliente exitosa: " + reserv;
                resultado += "\n Operación terminada";
                panelDatos.actualizarInterfaz(resultado);
            }
            else
            {
                panelDatos.actualizarInterfaz("Operación cancelada");
            }
        }
        catch (Exception e) 
        {
            String resultado = generarMensajeError(e);
            panelDatos.actualizarInterfaz(resultado);
        }
    }


    /*Método del implements*/
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = RecepcionistaView.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}


    /*Métodos adicionales */
        /**
     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
     * @param e - La excepción recibida
     * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
     */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
    
    /**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
		return resultado;
	}

    
}
