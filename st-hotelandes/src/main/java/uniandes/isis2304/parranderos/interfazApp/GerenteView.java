package uniandes.isis2304.parranderos.interfazApp;
import uniandes.isis2304.parranderos.negocio.Parranderos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import javax.jdo.JDODataStoreException;

import java.io.FileReader;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;

@SuppressWarnings("serial")

public class GerenteView extends JFrame implements ActionListener {

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

    private GerenteView window;


    public GerenteView(LoginView loginn) {

        window = this;

        login = loginn;

        guiConfig = openConfig ("Interfaz", "./src/main/resources/config/interfaceGerenteView.json");
        
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
        JFrame frame = new JFrame("Gerente");
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(300, 40, 200, 200);

        int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null )
    	{
    		log.info ( "Se aplica configuración por defecto" );			
			titulo = "Gerente View Default*";
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

    
    /*Métodos para el Gerente*/

    //Mostrar el dinero recolectado por un servicio en cada habitación por parte de un cliente
    public void mostrarDineroServicio()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

	//Mostrar los 20 servicios más populares
    public void serviciosMasPopulares()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

	//Mostrar el índice de ocupación de las habitaciones
    public void indiceDeOcupacionHabitaciones()
    {
        try 
    	{
            List<Object []> ocupacion = parranderos.indiceDeOcupacionHabitaciones();
    		if (ocupacion == null)
        		{
        			throw new Exception ("No se encontró la ocupación de las habitaciones");
        		}

            String resultado = "Ocupación de las habitaciones: \n";
            resultado += "Habitación | Ocupación \n";
            resultado += "-----------------------------------------------------\n";
            for (Object [] o : ocupacion)
            {
                resultado += o[0] + " | " + o[1] + "\n";
            }
            panelDatos.actualizarInterfaz(resultado);
		} 
    	catch (Exception e) 
    	{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }

	//Mostrar los servicios que cumplen con una característica
    public void serviciosConCaracteristica()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

	//Mostrar consumo de un cliente en un rango de fechas
    public void mostrarConsumoCliente()
    {
        try 
    	{
            List<Object []> consumo = parranderos.mostrarConsumoCliente();
    		if (consumo == null)
        		{
        			throw new Exception ("No se encontró el consumo de los clientes");
        		}

            String resultado = "Consumo de los clientes: \n";
            resultado += "Cliente | Consumo \n";
            resultado += "-----------------------------------------------------\n";
            for (Object [] o : consumo)
            {
                resultado += o[0] + " | " + o[1] + "\n";
            }
            panelDatos.actualizarInterfaz(resultado);
		} 
    	catch (Exception e) 
    	{
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }

    //Analizar la operación de hotelandes
    public void analizarOperacionHotelandes()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

    //"Encontrar los buenos clientes
    public void encontrarBuenosClientes()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

    //Encontrar los servicios que no tienen mucha demanda
    public void encontrarServiciosSinDemanda()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }


    /*Método del implements*/
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = GerenteView.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
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

}