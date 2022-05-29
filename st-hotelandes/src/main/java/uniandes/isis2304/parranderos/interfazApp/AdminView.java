package uniandes.isis2304.parranderos.interfazApp;
import uniandes.isis2304.parranderos.negocio.Parranderos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;

@SuppressWarnings("serial")


public class AdminView extends JFrame implements ActionListener {

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

    private JFrame window;


    public AdminView(LoginView loginnn) {
        window = this;

		login = loginnn;

        guiConfig = openConfig ("Interfaz", "./src/main/resources/config/interfaceAdminView.json");
        
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
        JFrame frame = new JFrame("Admin");
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(300, 40, 200, 200);

        int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null )
    	{
    		log.info ( "Se aplica configuración por defecto" );			
			titulo = "Administradow View Default";
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

    /*Métodos para el Aministrador de datos*/

    //Registrar un rol de usuario
    public void registrarRolUsuario()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }
    //Registrar un usuario
    public void registrarUsuario()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

    //Registrar un Tipo de habitación
    public void registrarTipoHabitacion()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

    //Registrar una habitación
    public void registrarHabitacion()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

    //Registrar un servicio del Hotel
    public void registrarServicio()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

    //Registrar un plan de consumo
    public void registrarPlanConsumo()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

	//Registrar la entrada a mantenimiento de alojamientos o servicios del hotel
    public void registrarEntradaMantenimiento()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

	//Registrar el fin del mantenimiento de alojamientos o servicios del hotel
    public void registrarFinMantenimiento()
    {
        String resultado = "Falta Implementar";
        panelDatos.actualizarInterfaz(resultado);

    }

    /*Métodos del Json*/

    /**
	 * Muestra el log de Parranderos
	 */
	public void mostrarLogParranderos ()
	{
		mostrarArchivo ("parranderos.log");
	}
	
	/**
	 * Muestra el log de datanucleus
	 */
	public void mostrarLogDatanuecleus ()
	{
		mostrarArchivo ("datanucleus.log");
	}

    public void limpiarLogParranderos ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("parranderos.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de parranderos ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}

    public void limpiarLogDatanucleus ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("datanucleus.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}









    //PREGUNTAR: INCLUYO EL METODO DE LIMPIAR BD? 











    /**
	 * Muestra el modelo conceptual de Parranderos
	 */
	public void mostrarModeloConceptual ()
	{
		mostrarArchivo ("doc/MODELO_UML.svg");
	}
	
	/**
	 * Muestra el esquema de la base de datos de Parranderos
	 */
	public void mostrarEsquemaBD ()
	{
		mostrarArchivo ("doc/ModelRelacionalHOTELANDES.svg");
	}
	
	/**
	 * Muestra el script de creación de la base de datos
	 */
	public void mostrarScriptBD ()
	{
		mostrarArchivo ("data/HotelAndes.sql");
	}

    
	
	
    /*Muestra la información acerca del desarrollo de esta apicación
     */
    public void acercaDe ()
    {
		String resultado = "\n\n ************************************\n\n";
		resultado += " * Universidad	de	los	Andes	(Bogotá	- Colombia)\n";
		resultado += " * Departamento	de	Ingeniería	de	Sistemas	y	Computación\n";
		resultado += " * \n";		
		resultado += " * Curso: isis2304 - Sistemas Transaccionales\n";
		resultado += " * Proyecto: HotelAndes \n";
		resultado += " * @author Daniel Andrés Bernal\n";
        resultado += " * @author Ana Sofía Padilla Daza\n";
		resultado += " * Mayo de 2020\n";
		resultado += " * \n";
		resultado += "\n ************************************\n\n";

		panelDatos.actualizarInterfaz(resultado);		
    }

    /*Métodos de ayuda con archivos, BD, etc.*/

    private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
//			e.printStackTrace();
			return false;
		}
	}


    private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}


    /*Método del implements*/
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = AdminView.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}


    

    
}
