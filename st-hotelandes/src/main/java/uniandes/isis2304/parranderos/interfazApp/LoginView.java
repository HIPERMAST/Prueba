package uniandes.isis2304.parranderos.interfazApp;
import uniandes.isis2304.parranderos.negocio.Parranderos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;

import javax.imageio.ImageIO;

import javax.jdo.PersistenceManagerFactory;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;


@SuppressWarnings("serial")

public class LoginView extends JFrame implements ActionListener {

    private static Logger log = Logger.getLogger(InterfazParranderosApp.class.getName());

    
    /* Atributos */
    //Asociación a parranderos
    private Parranderos parranderos;

    //Persistence manager factory
    private PersistenceManagerFactory pmf;
    
    private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json";
	

    private JsonObject tableConfig;


	public LoginView() {
		init();

	}

    //

	// Inicializa la interfaz de inicio de sesión
    public void init() {


        JFrame frame = new JFrame("Login HotelAndes");
        frame.setLayout(null);
        
        //Imagen del login
        JPanel panel = new JPanel();
        panel.setBounds(300, 40, 200, 200);

        try {
            BufferedImage image = ImageIO.read(new File("src/main/resources/config/hotel.png"));
            JLabel picLabel = new JLabel(new ImageIcon(image));
            panel.add(picLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.add(panel);
        
        //Panel de login
        JLabel nameStr = new JLabel("Correo:");
        nameStr.setBounds(271, 300, 100, 25);
        frame.add(nameStr);
        
        JLabel passwordStr = new JLabel("Contraseña:");
        passwordStr.setBounds(250, 350, 100, 25);
        frame.add(passwordStr);  
        
        JTextField userID = new JTextField();
        userID.setBounds(330, 300, 150, 25);
        frame.add(userID);
        
        JTextField password = new JTextField();
        password.setBounds(330, 350, 150, 25);
        frame.add(password);
        
        JButton buttonlogin = new JButton("Login");
        buttonlogin.setBounds(325, 400, 100, 25);
        frame.add(buttonlogin);

        frame.setBounds(400, 100, 800, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        parranderos = new Parranderos (tableConfig);

        
        LoginView ventana = this;

        // Añadir escucha para el botón de inicio de sesión
        buttonlogin.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
                String USER = new String (userID.getText());
                String PW = new String (password.getText());
                if (USER.equals("") || PW.equals("")) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese su número de cuenta y contraseña");
                }
                else {
                    Integer correo = 0;
                    try {
                        correo = parranderos.revisarCorreoAdminData(USER, PW);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                    if (correo == 1) {
                        JOptionPane.showMessageDialog(null, "Bienvenido gerente");
                        new GerenteView(ventana);
                        frame.dispose();
                    } 

                    else if (correo == 2) {
                        JOptionPane.showMessageDialog(null, "Bienvenido administrador");
                        new AdminView(ventana);
                        frame.dispose();
                    }
                    else if (correo == 3) {
                        JOptionPane.showMessageDialog(null, "Bienvenido Recepecionista");
                        new RecepcionistaView(ventana);
                        frame.dispose();
                    } 

                    else if (correo == 4) {
                        JOptionPane.showMessageDialog(null, "Bienvenido Empleado");
                        new EmpleadoView(ventana);
                        frame.dispose();
                    } 

                    else if (correo == 5) {
                        JOptionPane.showMessageDialog(null, "Bienvenido Cliente");
                        new ClienteView(ventana);
                        frame.dispose();
                    }
                    
                    else if (correo == 6) {
                        JOptionPane.showMessageDialog(null, "Bienvenido Organizador de Eventos");
                        new OEView(ventana);
                        frame.dispose();
                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número de cuenta y contraseña válidos");
                    }
                }
            }
        });

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
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }


    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = LoginView.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}


    public static void main(String []args) { 
        // Programa principal
        // Ventana de inicio de sesión
        new LoginView();
     }
}

