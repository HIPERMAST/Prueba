/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.parranderos.persistencia;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import uniandes.isis2304.parranderos.negocio.Bar;
import uniandes.isis2304.parranderos.negocio.Bebedor;
import uniandes.isis2304.parranderos.negocio.Bebida;
import uniandes.isis2304.parranderos.negocio.Gustan;
import uniandes.isis2304.parranderos.negocio.Sirven;
import uniandes.isis2304.parranderos.negocio.TipoBebida;
import uniandes.isis2304.parranderos.negocio.Visitan;
import uniandes.isis2304.parranderos.negocio.Hotel;
import uniandes.isis2304.parranderos.negocio.Usuario;
import uniandes.isis2304.parranderos.negocio.AdminData_id;
import uniandes.isis2304.parranderos.negocio.AdministradorDatos;
import uniandes.isis2304.parranderos.negocio.A_EquipoAdicional;
import uniandes.isis2304.parranderos.negocio.A_ServiciosSpa;
import uniandes.isis2304.parranderos.negocio.Cliente;
import uniandes.isis2304.parranderos.negocio.Cliente_id;
import uniandes.isis2304.parranderos.negocio.Cuenta;
import uniandes.isis2304.parranderos.negocio.Empleado;
import uniandes.isis2304.parranderos.negocio.Empleado_id;
import uniandes.isis2304.parranderos.negocio.Gerente;
import uniandes.isis2304.parranderos.negocio.Gerente_id;
import uniandes.isis2304.parranderos.negocio.Habitacion;
import uniandes.isis2304.parranderos.negocio.OrganizadorEventos;
import uniandes.isis2304.parranderos.negocio.OrganizadorEventos_id;
import uniandes.isis2304.parranderos.negocio.PC_LargaEstadia;
import uniandes.isis2304.parranderos.negocio.PC_PromoParticular;
import uniandes.isis2304.parranderos.negocio.PC_TiempoCompartido;
import uniandes.isis2304.parranderos.negocio.PC_TodoIncluido;
import uniandes.isis2304.parranderos.negocio.PlanConsumo;
import uniandes.isis2304.parranderos.negocio.PlanConsumo_id;
import uniandes.isis2304.parranderos.negocio.Producto;
import uniandes.isis2304.parranderos.negocio.Producto_id;
import uniandes.isis2304.parranderos.negocio.Recepcionista;
import uniandes.isis2304.parranderos.negocio.Recepcionista_id;
import uniandes.isis2304.parranderos.negocio.Reserva;
import uniandes.isis2304.parranderos.negocio.Servicio;
import uniandes.isis2304.parranderos.negocio.ServicioXCliente;
import uniandes.isis2304.parranderos.negocio.S_Bar;
import uniandes.isis2304.parranderos.negocio.S_Bar_id;
import uniandes.isis2304.parranderos.negocio.S_Gym;
import uniandes.isis2304.parranderos.negocio.S_Gym_id;
import uniandes.isis2304.parranderos.negocio.S_Internet;
import uniandes.isis2304.parranderos.negocio.S_Internet_id;
import uniandes.isis2304.parranderos.negocio.S_Lavanderia;
import uniandes.isis2304.parranderos.negocio.S_Lavanderia_id;
import uniandes.isis2304.parranderos.negocio.S_Piscina;
import uniandes.isis2304.parranderos.negocio.S_Piscina_id;
import uniandes.isis2304.parranderos.negocio.S_PrestamoUtencilios;
import uniandes.isis2304.parranderos.negocio.S_PrestamoUtencilios_id;
import uniandes.isis2304.parranderos.negocio.S_Restaurante;
import uniandes.isis2304.parranderos.negocio.S_Restaurante_id;
import uniandes.isis2304.parranderos.negocio.S_Salon;
import uniandes.isis2304.parranderos.negocio.S_Salon_id;
import uniandes.isis2304.parranderos.negocio.S_Spa;
import uniandes.isis2304.parranderos.negocio.S_Spa_id;
import uniandes.isis2304.parranderos.negocio.S_Supermercado;
import uniandes.isis2304.parranderos.negocio.S_Supermercado_id;
import uniandes.isis2304.parranderos.negocio.S_Tienda;
import uniandes.isis2304.parranderos.negocio.S_Tienda_id;
import uniandes.isis2304.parranderos.negocio.Tipo;
import uniandes.isis2304.parranderos.negocio.Convencion;





/**
 * Clase para el manejador de persistencia del proyecto Parranderos
 * Traduce la información entre objetos Java y tuplas de la base de datos, en ambos sentidos
 * Sigue un patrón SINGLETON (Sólo puede haber UN objeto de esta clase) para comunicarse de manera correcta
 * con la base de datos
 * Se apoya en las clases SQLBar, SQLBebedor, SQLBebida, SQLGustan, SQLSirven, SQLTipoBebida y SQLVisitan, que son 
 * las que realizan el acceso a la base de datos
 * 
 * @author Germán Bravo
 */
public class PersistenciaParranderos 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaParranderos.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaParranderos instance;
	
	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;
	
	/**
	 * Atributo para el acceso a la tabla TIPOBEBIDA de la base de datos
	 */
	private SQLTipoBebida sqlTipoBebida;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLBebida sqlBebida;
	
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLBar sqlBar;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLBebedor sqlBebedor;
	
	/**
	 * Atributo para el acceso a la tabla GUSTAN de la base de datos
	 */
	private SQLGustan sqlGustan;
	
	/**
	 * Atributo para el acceso a la tabla SIRVEN de la base de datos
	 */
	private SQLSirven sqlSirven;
	
	/**
	 * Atributo para el acceso a la tabla VISITAN de la base de datos
	 */
	private SQLVisitan sqlVisitan;                            

	private SQLHotel SQLHotel;
	private SQLUsuario SQLUsuario;
	private SQLAdminData_id SQLAdmindata_id;
	private SQLAdministradorDatos SQLAdministradordatos;
	private SQLA_EquipoAdicional SQLA_equipoadicional;
	private SQLA_ServiciosSpa SQLA_serviciosspa;
	private SQLCliente SQLCliente;
	private SQLCliente_id SQLCliente_id;
	private SQLCuenta SQLCuenta;
	private SQLEmpleado SQLEmpleado;
	private SQLEmpleado_id SQLEmpleado_id;
	private SQLGerente SQLGerente;
	private SQLGerente_id SQLGerente_id;
	private SQLHabitacion SQLHabitacion;
	private SQLOrganizadorEventos SQLOrganizadorEventos;
	private SQLOrganizadorEventos_id SQLOrganizadorEventos_id;
	private SQLPC_LargaEstadia SQLPC_LargaEstadia;
	private SQLPC_PromoParticular SQLPC_PromoParticular;
	private SQLPC_TiempoCompartido SQLPC_TiempoCompartido;
	private SQLPC_TodoIncluido SQLPC_TodoIncluido;
	private SQLPlanConsumo SQLPlanConsumo;
	private SQLPlanConsumo_id SQLPlanConsumo_id;
	private SQLProducto SQLProducto;
	private SQLProducto_id SQLProducto_id;
	private SQLRecepcionista SQLRecepcionista;
	private SQLRecepcionista_id SQLRecepcionista_id;
	private SQLReserva SQLReserva;
	private SQLServicio SQLServicio;
	private SQLServicioXCliente SQLServicioXCliente;
	private SQLS_Bar SQLS_Bar;
	private SQLS_Bar_id SQLS_Bar_id;
	private SQLS_Gym SQLS_Gym;
	private SQLS_Gym_id SQLS_Gym_id;
	private SQLS_Internet SQLS_Internet;
	private SQLS_Internet_id SQLS_Internet_id;
	private SQLS_Lavanderia SQLS_Lavanderia;
	private SQLS_Lavanderia_id SQLS_Lavanderia_id;
	private SQLS_Piscina SQLS_Piscina;
	private SQLS_Piscina_id SQLS_Piscina_id;
	private SQLS_PrestamoUtencilios SQLS_Prestamoutencilios;
	private SQLS_PrestamoUtencilios_id SQLS_Prestamoutencilios_id;
	private SQLS_Restaurante SQLS_Restaurante;
	private SQLS_Restaurante_id SQLS_Restaurante_id;
	private SQLS_Salon SQLS_Salon;
	private SQLS_Salon_id SQLS_Salon_id;
	private SQLS_Spa SQLS_Spa;
	private SQLS_Spa_id SQLS_Spa_id;
	private SQLS_Supermercado SQLS_Supermercado;
	private SQLS_Supermercado_id SQLS_Supermercado_id;
	private SQLS_Tienda SQLS_Tienda;
	private SQLS_Tienda_id SQLS_Tienda_id;
	private SQLTipo SQLTipo;
	private SQLConvencion SQLConvencion;          
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaParranderos ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("Parranderos");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("Parranderos_sequence");
		tablas.add ("TIPOBEBIDA");
		tablas.add ("BEBIDA");
		tablas.add ("BAR");
		tablas.add ("BEBEDOR");
		tablas.add ("GUSTAN");
		tablas.add ("SIRVEN");
		tablas.add ("VISITAN");
		tablas.add ("proyecto_sequence");
		tablas.add ("HOTEL");
		tablas.add ("USUARIO");
		tablas.add ("ADMINDATA_ID");
		tablas.add ("ADMINISTRADORDATOS");
		tablas.add ("A_EQUIPOADICIONAL");
		tablas.add ("A_SERVICIOSSPA");
		tablas.add ("CLIENTE");
		tablas.add ("CLIENTE_ID");
		tablas.add ("CUENTA");
		tablas.add ("EMPLEADO");
		tablas.add ("EMPLEADO_ID");
		tablas.add ("GERENTE");
		tablas.add ("GERENTE_ID");
		tablas.add ("HABITACION");
		tablas.add ("PC_LARGAESTADIA");
		tablas.add ("PC_PROMOPARTICULAR");
		tablas.add ("PC_TIEMPOCOMPARTIDO");
		tablas.add ("PC_TODOINCLUIDO");
		tablas.add ("PLANCONSUMO");
		tablas.add ("PLANCONSUMO_ID");
		tablas.add ("PRODUCTO");
		tablas.add ("PRODUCTO_ID");
		tablas.add ("RECEPCIONISTA");
		tablas.add ("RECEPCIONISTA_ID");
		tablas.add ("RESERVA");
		tablas.add ("SERVICIO");
		tablas.add ("S_BAR");
		tablas.add ("S_BAR_ID");
		tablas.add ("S_GYM");
		tablas.add ("S_GYM_ID");
		tablas.add ("S_INTERNET");
		tablas.add ("S_INTERNET_ID");
		tablas.add ("S_LAVANDERIA");
		tablas.add ("S_LAVANDERIA_ID");
		tablas.add ("S_PISCINA");
		tablas.add ("S_PISCINA_ID");
		tablas.add ("S_PRESTAMOUTENCILIOS");
		tablas.add ("S_PRESTAMOUTENCILIOS_ID");
		tablas.add ("S_RESTAURANTE");
		tablas.add ("S_RESTAURANTE_ID");
		tablas.add ("S_SALON");
		tablas.add ("S_SALON_ID");
		tablas.add ("S_SPA");
		tablas.add ("S_SPA_ID");
		tablas.add ("S_SUPERMERCADO");
		tablas.add ("S_SUPERMERCADO_ID");
		tablas.add ("S_TIENDA");
		tablas.add ("S_TIENDA_ID");
		tablas.add ("TIPO");
		tablas.add ("SERVICIOXCLIENTE");
		tablas.add ("ORGANIZADOREVENTOS_ID");
		tablas.add ("ORGANIZADOREVENTOS");
		tablas.add("CONVENCION");
}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaParranderos (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaParranderos getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaParranderos ();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaParranderos getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaParranderos (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlTipoBebida = new SQLTipoBebida(this);
		sqlBebida = new SQLBebida(this);
		sqlBar = new SQLBar(this);
		sqlBebedor = new SQLBebedor(this);
		sqlGustan = new SQLGustan(this);
		sqlSirven = new SQLSirven (this);
		sqlVisitan = new SQLVisitan(this);		
		sqlUtil = new SQLUtil(this);
		SQLHotel = new SQLHotel(this);
	    SQLUsuario = new SQLUsuario(this);
	    SQLAdmindata_id = new SQLAdminData_id(this);
	    SQLAdministradordatos = new SQLAdministradorDatos(this);
	    SQLA_equipoadicional = new SQLA_EquipoAdicional(this);
	    SQLA_serviciosspa = new SQLA_ServiciosSpa(this);
	    SQLCliente = new SQLCliente(this);
	    SQLCliente_id = new SQLCliente_id(this);
	    SQLCuenta = new SQLCuenta(this);
	    SQLEmpleado = new SQLEmpleado(this);
	    SQLEmpleado_id = new SQLEmpleado_id(this);
	    SQLGerente = new SQLGerente(this);
	    SQLGerente_id = new SQLGerente_id(this);
	    SQLHabitacion = new SQLHabitacion(this);
		SQLOrganizadorEventos = new SQLOrganizadorEventos(this);
		SQLOrganizadorEventos_id = new SQLOrganizadorEventos_id(this);
	    SQLPC_LargaEstadia = new SQLPC_LargaEstadia(this);
	    SQLPC_PromoParticular = new SQLPC_PromoParticular(this);
	    SQLPC_TiempoCompartido = new SQLPC_TiempoCompartido(this);
	    SQLPC_TodoIncluido = new SQLPC_TodoIncluido(this);
	    SQLPlanConsumo = new SQLPlanConsumo(this);
	    SQLPlanConsumo_id = new SQLPlanConsumo_id(this);
	    SQLProducto = new SQLProducto(this);
	    SQLProducto_id = new SQLProducto_id(this);
	    SQLRecepcionista = new SQLRecepcionista(this);
	    SQLRecepcionista_id = new SQLRecepcionista_id(this);
	    SQLReserva = new SQLReserva(this);
	    SQLServicio = new SQLServicio(this);
		SQLServicioXCliente = new SQLServicioXCliente(this);
	    SQLS_Bar = new SQLS_Bar(this);
	    SQLS_Bar_id = new SQLS_Bar_id(this);
	    SQLS_Gym = new SQLS_Gym(this);
	    SQLS_Gym_id = new SQLS_Gym_id(this);
	    SQLS_Internet = new SQLS_Internet(this);
	    SQLS_Internet_id = new SQLS_Internet_id(this);
	    SQLS_Lavanderia = new SQLS_Lavanderia(this);
	    SQLS_Lavanderia_id = new SQLS_Lavanderia_id(this);
	    SQLS_Piscina = new SQLS_Piscina(this);
	    SQLS_Piscina_id = new SQLS_Piscina_id(this);
	    SQLS_Prestamoutencilios = new SQLS_PrestamoUtencilios(this);
	    SQLS_Prestamoutencilios_id = new SQLS_PrestamoUtencilios_id(this);
	    SQLS_Restaurante = new SQLS_Restaurante(this);
	    SQLS_Restaurante_id = new SQLS_Restaurante_id(this);
	    SQLS_Salon = new SQLS_Salon(this);
	    SQLS_Salon_id = new SQLS_Salon_id(this);
	    SQLS_Spa = new SQLS_Spa(this);
	    SQLS_Spa_id = new SQLS_Spa_id(this);
	    SQLS_Supermercado = new SQLS_Supermercado(this);
	    SQLS_Supermercado_id = new SQLS_Supermercado_id(this);
	    SQLS_Tienda = new SQLS_Tienda(this);
	    SQLS_Tienda_id = new SQLS_Tienda_id(this);
	    SQLTipo = new SQLTipo(this);
		SQLConvencion = new SQLConvencion(this);
	
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darSeqParranderos ()
	{
		return tablas.get (0);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
	 */
	public String darTablaTipoBebida ()
	{
		return tablas.get (1);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebida de parranderos
	 */
	public String darTablaBebida ()
	{
		return tablas.get (2);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de parranderos
	 */
	public String darTablaBar ()
	{
		return tablas.get (3);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebedor de parranderos
	 */
	public String darTablaBebedor ()
	{
		return tablas.get (4);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Gustan de parranderos
	 */
	public String darTablaGustan ()
	{
		return tablas.get (5);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Sirven de parranderos
	 */
	public String darTablaSirven ()
	{
		return tablas.get (6);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaVisitan ()
	{
		return tablas.get (7);
	}
	




	//
	public String darHotel ()
	{
		return tablas.get(8);
	}
	public String darUsuario ()
	{
		return tablas.get(9);
	}
	public String darAdmindata_id ()
	{
		return tablas.get(10);
	}
	public String darAdministradordatos ()
	{
		return tablas.get(11);
	}
	public String darA_equipoadicional ()
	{
		return tablas.get(12);
	}
	public String darA_serviciosspa ()
	{
		return tablas.get(13);
	}
	public String darCliente ()
	{
		return tablas.get(14);
	}
	public String darCliente_id ()
	{
		return tablas.get(15);
	}
	public String darCuenta ()
	{
		return tablas.get(16);
	}
	public String darEmpleado ()
	{
		return tablas.get(17);
	}
	public String darEmpleado_id ()
	{
		return tablas.get(18);
	}
	public String darGerente ()
	{
		return tablas.get(19);
	}
	public String darGerente_id ()
	{
		return tablas.get(20);
	}
	public String darHabitacion ()
	{
		return tablas.get(21);
	}
	public String darPC_LargaEstadia ()
	{
		return tablas.get(22);
	}
	public String darPC_PromoParticular ()
	{
		return tablas.get(23);
	}
	public String darPC_TiempoCompartido ()
	{
		return tablas.get(24);
	}
	public String darPC_TodoIncluido ()
	{
		return tablas.get(25);
	}
	public String darPlanConsumo ()
	{
		return tablas.get(26);
	}
	public String darPlanConsumo_id ()
	{
		return tablas.get(27);
	}
	public String darProducto ()
	{
		return tablas.get(28);
	}
	public String darProducto_id ()
	{
		return tablas.get(29);
	}
	public String darRecepcionista ()
	{
		return tablas.get(30);
	}
	public String darRecepcionista_id ()
	{
		return tablas.get(31);
	}
	public String darReserva ()
	{
		return tablas.get(32);
	}
	public String darServicio ()
	{
		return tablas.get(33);
	}
	public String darS_Bar ()
	{
		return tablas.get(34);
	}
	public String darS_Bar_id ()
	{
		return tablas.get(35);
	}
	public String darS_Gym ()
	{
		return tablas.get(36);
	}
	public String darS_Gym_id ()
	{
		return tablas.get(37);
	}
	public String darS_internet ()
	{
		return tablas.get(38);
	}
	public String darS_internet_id ()
	{
		return tablas.get(39);
	}
	public String darS_Lavanderia ()
	{
		return tablas.get(40);
	}
	public String darS_Lavanderia_id ()
	{
		return tablas.get(41);
	}
	public String darS_Piscina ()
	{
		return tablas.get(42);
	}
	public String darS_Piscina_id ()
	{
		return tablas.get(43);
	}
	public String darS_Prestamoutencilios ()
	{
		return tablas.get(44);
	}
	public String darS_Prestamoutencilios_id ()
	{
		return tablas.get(45);
	}
	public String darS_Restaurante ()
	{
		return tablas.get(46);
	}
	public String darS_Restaurante_id ()
	{
		return tablas.get(47);
	}
	public String darS_Salon ()
	{
		return tablas.get(48);
	}
	public String darS_Salon_id ()
	{
		return tablas.get(49);
	}
	public String darS_Spa ()
	{
		return tablas.get(50);
	}
	public String darS_Spa_id ()
	{
		return tablas.get(51);
	}
	public String darS_Supermercado ()
	{
		return tablas.get(52);
	}
	public String darS_Supermercado_id ()
	{
		return tablas.get(53);
	}
	public String darS_Tienda ()
	{
		return tablas.get(54);
	}
	public String darS_Tienda_id ()
	{
		return tablas.get(55);
	}
	public String darTipo ()
	{
		return tablas.get(56);
	}
	public String darSeqProyecto ()
	{
		return tablas.get(57);
	}
	public String darServicioXCliente ()
	{
		return tablas.get(58);
	}
	public String darOrganizadorEventos_Id ()
	{
		return tablas.get(59);
	}
	public String darOrganizadorEventos ()
	{
		return tablas.get(60);
	}
	public String darConvencion()
	{
		return tablas.get(61);
	}

	
	
	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private Long nextval ()
	{
        Long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
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

	/*************** REQUERIMIENTOS FUNCIONALES ************/

	//REQ7
	public Habitacion adicionarReservaAlojamiento(Long numeroHabitacion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {

			tx.begin();
			Long id = nextval();
			int cantPersonas = 0;
			Timestamp checkIn = new Timestamp(System.currentTimeMillis());
			Timestamp checkOut = new Timestamp(System.currentTimeMillis());

			SQLReserva.adicionarReservaPorId(pm, id, cantPersonas, checkIn, checkOut, 0);
			SQLHabitacion.updateHabitacionIdReserva(pm, id , numeroHabitacion);
			Habitacion habitacion = SQLHabitacion.darHabitacionPorId(pm, numeroHabitacion);
			tx.commit();
            return habitacion;
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}


	//REQ8
	public S_Salon agregarReservaServicio(String nombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
			tx.begin();
			
			//Long idCliente = 202000000020706;

			if (nombre.toUpperCase().equals("SALON")) 
			{
				Long idSalon = SQLS_Salon.updateSalonIdCliente(pm,  202020706L, 1);
				S_Salon salon = SQLS_Salon.darSalonPorId(pm, idSalon);
				tx.commit();
				return salon;
			}
			/*
			else if (nombre.toUpperCase() == "SPA")
			{
				Integer reserva = SQLS_Spa.updateSpaReserva(pm, idReserva, 1800);
				S_Spa spa = SQLS_Spa.darSpaPorId(pm, reserva);
				return spa;
			}
			*/
			else
			{

			}


        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		return null;
	}


	//REQ9
	public Reserva registrarCheckInCliente(Long idCliente, Long idReserva)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
			tx.begin();
			SQLRecepcionista.updateRecepcionistaIdCliente(pm,201920564L, idCliente);
			SQLRecepcionista.updateRecepcionistaIdReserva(pm,201920564L, idReserva);
			SQLReserva.updateReservaActivo(pm, 1, idReserva);
			Reserva reserva = SQLReserva.darReservaPorId(pm, idReserva);
			tx.commit();
			return reserva;


        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}


	//REQ11
	public Reserva registrarCheckOutCliente(Long idCliente, Long idReserva)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
			tx.begin();
			SQLRecepcionista.updateRecepcionistaIdCliente(pm,202120439L, idCliente);
			SQLRecepcionista.updateRecepcionistaIdReserva(pm,202120439L, idReserva);
			SQLReserva.updateReservaActivo(pm, 0, idReserva);
			Reserva reserva = SQLReserva.darReservaPorId(pm, idReserva);
			tx.commit();
			return reserva;


        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}


	//REQ12
	public Reserva registrarConvencion(Long idConvencion, Integer cantHTipo1, Integer cantHTipo2, Integer cantHTipo3) {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
			Long idReserva = nextval();
			

			tx.begin();
			SQLOrganizadorEventos.updateOEIdConvencion(pm, idConvencion, 202010592L);
			SQLOrganizadorEventos.updateIEIdReserva(pm, idReserva, 202010592L);
			Convencion convencion = SQLConvencion.darConvencionPorId(pm, idConvencion);
			SQLReserva.adicionarReservaPorId(pm, idReserva, convencion.getCantPersonas(), convencion.getCheckIn(), convencion.getCheckOut(), 0);
			Reserva reserva = SQLReserva.darReservaPorId(pm, idReserva);

			System.out.println("HOLA SIGO VIVO");

			List<Habitacion> habitacionesTipo1 = SQLHabitacion.darHabitacionesPorTipo(pm, 1);
			List<Habitacion> habitacionesTipo2 = SQLHabitacion.darHabitacionesPorTipo(pm, 2);
			List<Habitacion> habitacionesTipo3 = SQLHabitacion.darHabitacionesPorTipo(pm, 3);

			System.out.println("Habitaciones tipo 1: " + habitacionesTipo1.size());
			System.out.println("Habitaciones tipo 2: " + habitacionesTipo2.size());
			System.out.println("Habitaciones tipo 3: " + habitacionesTipo3.size());

			if (cantHTipo1 < habitacionesTipo1.size() && cantHTipo1 > 0) {
				int i = 0;
				while (i < cantHTipo1) {
					System.out.println(i);
					SQLHabitacion.updateHabitacionIdReserva(pm, idReserva, habitacionesTipo1.get(i).getNumeroHabitacion());
					System.out.println("Hola");
					SQLCliente.updateClienteIdHabitacion(pm, habitacionesTipo1.get(i).getNumeroHabitacion(), 1L);
					i++;
				}
			}

			if (cantHTipo2 < habitacionesTipo2.size() && cantHTipo2 > 0) {
				int i = 0;
				while (i < cantHTipo2) {

					SQLHabitacion.updateHabitacionIdReserva(pm, idReserva, habitacionesTipo2.get(i).getNumeroHabitacion());
					SQLCliente.updateClienteIdHabitacion(pm, habitacionesTipo2.get(i).getNumeroHabitacion(), 1L);
					i++;
				}
			}

			if (cantHTipo3 < habitacionesTipo3.size() && cantHTipo3 > 0) {
				int i = 0;
				while (i < cantHTipo3) {

					SQLHabitacion.updateHabitacionIdReserva(pm, idReserva, habitacionesTipo3.get(i).getNumeroHabitacion());
					SQLCliente.updateClienteIdHabitacion(pm, habitacionesTipo3.get(i).getNumeroHabitacion(), 1L);
					i++;
				}
			}

			tx.commit();

			log.trace ("Inserción de ReservaConvencion: " + idReserva + ", " + idConvencion + ", " + convencion.getCheckIn() + ": " + reserva + " tuplas insertadas");

			return reserva;
		
        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }


	/*************** REQUERIMIENTOS DE CONSULTA  ************/

	//RFC3
	public List<Object []> indiceDeOcupacionHabitaciones()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		List<Object []> respuesta = new LinkedList <Object []> ();
		List<Object> tuplas = SQLGerente.indiceDeOcupacionHabitaciones(pm);

		for (Object tupla : tuplas) {
			Object [] tuplaArreglo = (Object []) tupla;
			Long numeroHabitacion = ((BigDecimal) tuplaArreglo[0]).longValue ();
			Long ocupacion = ((BigDecimal) tuplaArreglo[1]).longValue ();
			
			Object [] tuplaRespuesta = new Object[2];
			tuplaRespuesta[0] = numeroHabitacion;
			tuplaRespuesta[1] = ocupacion;
			
			respuesta.add(tuplaRespuesta);
		}
		pm.close();

		return respuesta;
	}

	//RFC5
	public List<Object []> mostrarConsumoCliente()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		List<Object []> response = new LinkedList <Object []> ();
		List<Object> tuplees = SQLGerente.mostrarConsumoCliente(pm);

		for (Object tupla : tuplees) 
		{
			Object [] tuplaArreglo = (Object []) tupla;
			Long idCliente = ((BigDecimal) tuplaArreglo[0]).longValue ();
			Long costo = ((BigDecimal) tuplaArreglo[1]).longValue ();

			Object [] tuplaRespuesta = new Object[2];
			tuplaRespuesta[0] = idCliente;
			tuplaRespuesta[1] = costo;

			response.add(tuplaRespuesta);
		}
		pm.close();
		return response;
	}









	//REQ13
	public Habitacion cancelarHabitacion(Long numeroHabitacion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
			tx.begin();
			SQLHabitacion.eliminarHabitacionReservaPorId(pm, numeroHabitacion);
			Habitacion habitacion = SQLHabitacion.darHabitacionPorId(pm, numeroHabitacion);
			
			tx.commit();
			return habitacion;


        }
        catch (Exception e)
        {
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}


	//REQ14
	public Reserva checkOutConvencion(Long idConvencion)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx=pm.currentTransaction();
		try
		{
			tx.begin();
			OrganizadorEventos OE = SQLOrganizadorEventos.darOEPorConvencion(pm, idConvencion);
			Long idReserva = OE.getIdReserva();
			SQLReserva.updateReservaActivo(pm, 0, idReserva);
			Reserva reserva = SQLReserva.darReservaPorId(pm, idReserva);
			
			tx.commit();
			return reserva;


		}
		catch (Exception e)
		{
			log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			return null;
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}
	}

	/* ****************************************************************
	 * 			Métodos para el Login
	 *****************************************************************/

	public Integer revisarCorreoAdminData(String correo, String pw) throws Exception {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Integer resp = 0;
		try {
			tx.begin();
			List listaAdmins = SQLAdministradordatos.darUsuarios(pm);

			for (Object o : listaAdmins) {
				AdministradorDatos admin = (AdministradorDatos) o;
				if (admin.getCorreo().equals(correo) && admin.getIdUsuario() == 1 && admin.getPw().equals(pw)) {
					resp = 1;
				}
				if (admin.getCorreo().equals(correo) && admin.getIdUsuario() == 2 && admin.getPw().equals(pw)) {
					resp = 2;
				}
				if (admin.getCorreo().equals(correo) && admin.getIdUsuario() == 3 && admin.getPw().equals(pw)) {
					resp = 3;
				}
				if (admin.getCorreo().equals(correo) && admin.getIdUsuario() == 4 && admin.getPw().equals(pw)) {
					resp = 4;
				}
				if (admin.getCorreo().equals(correo) && admin.getIdUsuario() == 5 && admin.getPw().equals(pw)) {
					resp = 5;
				}
				if (admin.getCorreo().equals(correo) && admin.getIdUsuario() == 6 && admin.getPw().equals(pw)) {
					resp = 6;
				}
			}
			tx.commit();
			return resp;

		} 
		catch (Exception e) {
			log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
			throw new Exception(e.getMessage());
		} 
		finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}


	
	/* ****************************************************************
	 * 			Métodos para manejar los TIPOS DE BEBIDA
	 *****************************************************************/


	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla TipoBebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public TipoBebida adicionarTipoBebida(String nombre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long idTipoBebida = nextval ();
            Long tuplasInsertadas = sqlTipoBebida.adicionarTipoBebida(pm, idTipoBebida, nombre);
            tx.commit();
            
            log.trace ("Inserción de tipo de bebida: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new TipoBebida (idTipoBebida, nombre);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla TipoBebida, dado el nombre del tipo de bebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del tipo de bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarTipoBebidaPorNombre (String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlTipoBebida.eliminarTipoBebidaPorNombre(pm, nombre);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla TipoBebida, dado el identificador del tipo de bebida
	 * Adiciona entradas al log de la aplicación
	 * @param idTipoBebida - El identificador del tipo de bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarTipoBebidaPorId (Long idTipoBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlTipoBebida.eliminarTipoBebidaPorId(pm, idTipoBebida);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla TipoBebida
	 * @return La lista de objetos TipoBebida, construidos con base en las tuplas de la tabla TIPOBEBIDA
	 */
	public List<TipoBebida> darTiposBebida ()
	{
		return sqlTipoBebida.darTiposBebida (pmf.getPersistenceManager());
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla TipoBebida que tienen el nombre dado
	 * @param nombre - El nombre del tipo de bebida
	 * @return La lista de objetos TipoBebida, construidos con base en las tuplas de la tabla TIPOBEBIDA
	 */
	public List<TipoBebida> darTipoBebidaPorNombre (String nombre)
	{
		return sqlTipoBebida.darTiposBebidaPorNombre (pmf.getPersistenceManager(), nombre);
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla TipoBebida con un identificador dado
	 * @param idTipoBebida - El identificador del tipo de bebida
	 * @return El objeto TipoBebida, construido con base en las tuplas de la tabla TIPOBEBIDA con el identificador dado
	 */
	public TipoBebida darTipoBebidaPorId (Long idTipoBebida)
	{
		return sqlTipoBebida.darTipoBebidaPorId (pmf.getPersistenceManager(), idTipoBebida);
	}
 
	/* ****************************************************************
	 * 			Métodos para manejar las BEBIDAS
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Bebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre de la bebida
	 * @param idTipoBebida - El identificador del tipo de bebida (Debe existir en la tabla TipoBebida)
	 * @param gradoAlcohol - El grado de alcohol de la bebida (mayor que 0)
	 * @return El objeto Bebida adicionado. null si ocurre alguna Excepción
	 */
	public Bebida adicionarBebida(String nombre, Long idTipoBebida, Integer gradoAlcohol) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();            
            Long idBebida = nextval ();
            Long tuplasInsertadas = sqlBebida.adicionarBebida(pm, idBebida, nombre, idTipoBebida, gradoAlcohol);
            tx.commit();
            
            log.trace ("Inserción bebida: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            return new Bebida (idBebida,nombre, idTipoBebida, gradoAlcohol);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla Bebida, dado el nombre de la bebida
	 * Adiciona entradas al log de la aplicación
	 * @param nombreBebida - El nombre de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarBebidaPorNombre (String nombreBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlBebida.eliminarBebidaPorNombre(pm, nombreBebida);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla Bebida, dado el identificador de la bebida
	 * Adiciona entradas al log de la aplicación
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarBebidaPorId (Long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlBebida.eliminarBebidaPorId (pm, idBebida);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla Bebida que tienen el nombre dado
	 * @param nombreBebida - El nombre de la bebida
	 * @return La lista de objetos Bebida, construidos con base en las tuplas de la tabla BEBIDA
	 */
	public List<Bebida> darBebidasPorNombre (String nombreBebida)
	{
		return sqlBebida.darBebidasPorNombre (pmf.getPersistenceManager(), nombreBebida);
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla Bebida
	 * @return La lista de objetos Bebida, construidos con base en las tuplas de la tabla BEBIDA
	 */
	public List<Bebida> darBebidas ()
	{
		return sqlBebida.darBebidas (pmf.getPersistenceManager());
	}
 
	/**
	 * Método que elimina, de manera transaccional, las bebidas que no son referenciadas en la tabla SIRVEN de Parranderos
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarBebidasNoServidas ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlBebida.eliminarBebidasNoServidas(pm);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/* ****************************************************************
	 * 			Métodos para manejar los BEBEDORES
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla BEBEDOR
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @param ciudad - La ciudad del bebedor
	 * @param presupuesto - El presupuesto del bebedor (ALTO, MEDIO, BAJO)
	 * @return El objeto BEBEDOR adicionado. null si ocurre alguna Excepción
	 */
	public Bebedor adicionarBebedor(String nombre, String ciudad, String presupuesto) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long idBebedor = nextval ();
            Long tuplasInsertadas = sqlBebedor.adicionarBebedor(pmf.getPersistenceManager(), idBebedor, nombre, ciudad, presupuesto);
            tx.commit();

            log.trace ("Inserción de bebedor: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Bebedor (idBebedor, nombre, ciudad, presupuesto);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BEBEDOR, dado el nombre del bebedor
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bebedor
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarBebedorPorNombre(String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlBebedor.eliminarBebedorPorNombre (pm, nombre);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BEBEDOR, dado el identificador del bebedor
	 * Adiciona entradas al log de la aplicación
	 * @param idBebedor - El identificador del bebedor
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarBebedorPorId (Long idBebedor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlBebedor.eliminarBebedorPorId (pm, idBebedor);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR que tienen el nombre dado
	 * @param nombreBebedor - El nombre del bebedor
	 * @return La lista de objetos BEBEDOR, construidos con base en las tuplas de la tabla BEBEDOR
	 */
	public List<Bebedor> darBebedoresPorNombre (String nombreBebedor) 
	{
		return sqlBebedor.darBebedoresPorNombre (pmf.getPersistenceManager(), nombreBebedor);
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR que tienen el identificador dado
	 * @param idBebedor - El identificador del bebedor
	 * @return El objeto BEBEDOR, construido con base en la tuplas de la tabla BEBEDOR, que tiene el identificador dado
	 */
	public Bebedor darBebedorPorId (Long idBebedor) 
	{
		return (Bebedor) sqlBebedor.darBebedorPorId (pmf.getPersistenceManager(), idBebedor);
	}

	/**
	 * Método que consulta TODA LA INFORMACIÓN DE UN BEBEDOR con el identificador dado. Incluye la información básica del bebedor,
	 * las visitas realizadas y las bebidas que le gustan.
	 * @param idBebedor - El identificador del bebedor
	 * @return El objeto BEBEDOR, construido con base en las tuplas de la tablas BEBEDOR, VISITAN, BARES, GUSTAN, BEBIDAS y TIPOBEBIDA,
	 * relacionadas con el identificador de bebedor dado
	 */
	public Bebedor darBebedorCompleto (Long idBebedor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
		Bebedor bebedor = (Bebedor) sqlBebedor.darBebedorPorId (pm, idBebedor);
		bebedor.setVisitasRealizadas(armarVisitasBebedor (sqlBebedor.darVisitasRealizadas (pm, idBebedor)));
		bebedor.setBebidasQueLeGustan(armarGustanBebedor (sqlBebedor.darBebidasQueLeGustan (pm, idBebedor)));
		return bebedor;
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BEBEDOR
	 * @return La lista de objetos BEBEDOR, construidos con base en las tuplas de la tabla BEBEDOR
	 */
	public List<Bebedor> darBebedores ()
	{
		return sqlBebedor.darBebedores (pmf.getPersistenceManager());
	}
 
	/**
	 * Método que consulta los bebedores y el número de visitas que ha realizado
	 * @return La lista de parejas de objetos, construidos con base en las tuplas de la tabla BEBEDOR y VISITAN. 
	 * El primer elemento de la pareja es un bebedor; 
	 * el segundo elemento es el número de visitas de ese bebedor (0 en el caso que no haya realizado visitas)
	 */
	public List<Object []> darBebedoresYNumVisitasRealizadas ()
	{
		List<Object []> respuesta = new LinkedList <Object []> ();
		List<Object> tuplas = sqlBebedor.darBebedoresYNumVisitasRealizadas (pmf.getPersistenceManager());
        for ( Object tupla : tuplas)
        {
			Object [] datos = (Object []) tupla;
			Long idBebedor = ((BigDecimal) datos [0]).longValue ();
			String nombreBebedor = (String) datos [1];
			String ciudadBebedor = (String) datos [2];
			String presupuesto = (String) datos [3];
			Integer numBares = ((BigDecimal) datos [4]).intValue ();

			Object [] resp = new Object [2];
			resp [0] = new Bebedor (idBebedor, nombreBebedor, ciudadBebedor, presupuesto);
			resp [1] = numBares;	
			
			respuesta.add(resp);
        }

		return respuesta;
	}
 
	/**
	 * Método que consulta CUÁNTOS BEBEDORES DE UNA CIUDAD VISITAN BARES
	 * @param ciudad - La ciudad que se quiere consultar
	 * @return El número de bebedores de la ciudad dada que son referenciados en VISITAN
	 */
	public Long darCantidadBebedoresCiudadVisitanBares (String ciudad)
	{
		return sqlBebedor.darCantidadBebedoresCiudadVisitanBares (pmf.getPersistenceManager(), ciudad);
	}
	
	/**
	 * Método que actualiza, de manera transaccional, la ciudad de un  BEBEDOR
	 * @param idBebedor - El identificador del bebedor
	 * @param ciudad - La nueva ciudad del bebedor
	 * @return El número de tuplas modificadas. -1 si ocurre alguna Excepción
	 */
	public Long cambiarCiudadBebedor (Long idBebedor, String ciudad)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlBebedor.cambiarCiudadBebedor (pm, idBebedor, ciudad);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimima, de manera transaccional, un BEBEDOR y las VISITAS que ha realizado
	 * Si el bebedor está referenciado en alguna otra relación, no se borra ni el bebedor NI las visitas
	 * @param idBebedor - El identificador del bebedor
	 * @return Un arreglo de dos números que representan el número de bebedores eliminados y 
	 * el número de visitas eliminadas, respectivamente. [-1, -1] si ocurre alguna Excepción
	 */
	public Long []  eliminarBebedorYVisitas_v1 (Long idBebedor)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long [] resp = sqlBebedor.eliminarBebedorYVisitas_v1 (pm, idBebedor);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new Long[] {-1L, -1L};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/**
	 * Método que elimima, de manera transaccional, un BEBEDOR y las VISITAS que ha realizado
	 * Si el bebedor está referenciado en alguna otra relación, no se puede borrar, SIN EMBARGO SÍ SE BORRAN TODAS SUS VISITAS
	 * @param idBebedor - El identificador del bebedor
	 * @return Un arreglo de dos números que representan el número de bebedores eliminados y 
	 * el número de visitas eliminadas, respectivamente. [-1, -1] si ocurre alguna Excepción
	 */
	public Long [] eliminarBebedorYVisitas_v2 (Long idBebedor)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long visitasEliminadas = eliminarVisitanPorIdBebedor(idBebedor);
            Long bebedorEliminado = eliminarBebedorPorId (idBebedor);
            tx.commit();
            return new Long [] {bebedorEliminado, visitasEliminadas};
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new Long [] {-1L, -1L};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}	

	/**
	 * Método privado para generar las información completa de las visitas realizadas por un bebedor: 
	 * La información básica del bar visitado, la fecha y el horario, en el formato esperado por los objetos BEBEDOR
	 * @param tuplas - Una lista de arreglos de 7 objetos, con la información del bar y de la visita realizada, en el siguiente orden:
	 *   bar.id, bar.nombre, bar.ciudad, bar.presupuesto, bar.cantsedes, vis.fechavisita, vis.horario
	 * @return Una lista de arreglos de 3 objetos. El primero es un objeto BAR, el segundo corresponde a la fecha de la visita y
	 * el tercero corresponde al horaario de la visita
	 */
	private List<Object []> armarVisitasBebedor (List<Object []> tuplas)
	{
		List<Object []> visitas = new LinkedList <Object []> ();
		for (Object [] tupla : tuplas)
		{
			Long idBar = ((BigDecimal) tupla [0]).longValue ();
			String nombreBar = (String) tupla [1];
			String ciudadBar = (String) tupla [2];
			String presupuestoBar = (String) tupla [3];
			Integer sedesBar = ((BigDecimal) tupla [4]).intValue ();
			Timestamp fechaVisita = (Timestamp) tupla [5];
			String horarioVisita = (String) tupla [6];
			
			Object [] visita = new Object [3];
			visita [0] = new Bar (idBar, nombreBar, ciudadBar, presupuestoBar, sedesBar);
			visita [1] = fechaVisita;
			visita [2] = horarioVisita;

			visitas.add (visita);
		}
		return visitas;
	}
	
	/**
	 * Método privado para generar las información completa de las bebidas que le gustan a un bebedor: 
	 * La información básica de la bebida, especificando también el nombre de la bebida, en el formato esperado por los objetos BEBEDOR
	 * @param tuplas - Una lista de arreglos de 5 objetos, con la información de la bebida y del tipo de bebida, en el siguiente orden:
	 * 	 beb.id, beb.nombre, beb.idtipobebida, beb.gradoalcohol, tipobebida.nombre
	 * @return Una lista de arreglos de 2 objetos. El primero es un objeto BEBIDA, el segundo corresponde al nombre del tipo de bebida
	 */
	private List<Object []> armarGustanBebedor (List<Object []> tuplas)
	{
		List<Object []> gustan = new LinkedList <Object []> ();
		for (Object [] tupla : tuplas)
		{			
			Long idBebida = ((BigDecimal) tupla [0]).longValue ();
			String nombreBebida = (String) tupla [1];
			Long idTipoBebida = ((BigDecimal) tupla [2]).longValue ();
			Integer gradoAlcohol = ((BigDecimal) tupla [3]).intValue ();
			String nombreTipo = (String) tupla [4];

			Object [] gusta = new Object [2];
			gusta [0] = new Bebida (idBebida, nombreBebida, idTipoBebida, gradoAlcohol);
			gusta [1] = nombreTipo;	
			
			gustan.add(gusta);
		}
		return gustan;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los BARES
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla BAR
	 * Adiciona entradas al log de la aplicación
	 * @param nombre - El nombre del bar
	 * @param ciudad - La ciudad del bar
	 * @param presupuesto - El presupuesto del bar (ALTO, MEDIO, BAJO)
	 * @param sedes - El número de sedes del bar en la ciudad (Mayor que 0)
	 * @return El objeto Bar adicionado. null si ocurre alguna Excepción
	 */
	public Bar adicionarBar(String nombre, String ciudad, String presupuesto, Integer sedes) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long idBar = nextval ();
            Long tuplasInsertadas = sqlBar.adicionarBar(pm, idBar, nombre, ciudad, presupuesto, sedes);
            tx.commit();

            log.trace ("Inserción de Bar: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");

            return new Bar (idBar, nombre, ciudad, presupuesto, sedes);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BAR, dado el nombre del bar
	 * Adiciona entradas al log de la aplicación
	 * @param nombreBar - El nombre del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarBarPorNombre (String nombreBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlBar.eliminarBaresPorNombre(pm, nombreBar);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla BAR, dado el identificador del bar
	 * Adiciona entradas al log de la aplicación
	 * @param idBar - El identificador del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarBarPorId (Long idBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlBar.eliminarBarPorId (pm, idBar);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla BAR
	 * @return La lista de objetos BAR, construidos con base en las tuplas de la tabla BAR
	 */
	public List<Bar> darBares ()
	{
		return sqlBar.darBares (pmf.getPersistenceManager());
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla BAR que tienen el nombre dado
	 * @param nombreBar - El nombre del bar
	 * @return La lista de objetos BAR, construidos con base en las tuplas de la tabla BAR
	 */
	public List<Bar> darBaresPorNombre (String nombreBar)
	{
		return sqlBar.darBaresPorNombre (pmf.getPersistenceManager(), nombreBar);
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla BAR que tienen el identificador dado
	 * @param idBar - El identificador del bar
	 * @return El objeto BAR, construido con base en la tuplas de la tabla BAR, que tiene el identificador dado
	 */
	public Bar darBarPorId (Long idBar)
	{
		return sqlBar.darBarPorId (pmf.getPersistenceManager(), idBar);
	}
 
	/**
	 * Método que actualiza, de manera transaccional, aumentando en 1 el número de sedes de todos los bares de una ciudad
	 * @param ciudad - La ciudad que se quiere modificar
	 * @return El número de tuplas modificadas. -1 si ocurre alguna Excepción
	 */
	public Long aumentarSedesBaresCiudad (String ciudad)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlBar.aumentarSedesBaresCiudad(pm, ciudad);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar la relación GUSTAN
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla GUSTAN
	 * Adiciona entradas al log de la aplicación
	 * @param idBebedor - El identificador del bebedor - Debe haber un bebedor con ese identificador
	 * @param idBebida - El identificador de la bebida - Debe haber una bebida con ese identificador
	 * @return Un objeto GUSTAN con la información dada. Null si ocurre alguna Excepción
	 */
	public Gustan adicionarGustan(Long idBebedor, Long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long tuplasInsertadas = sqlGustan.adicionarGustan (pm, idBebedor, idBebida);
            tx.commit();

            log.trace ("Inserción de gustan: [" + idBebedor + ", " + idBebida + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new Gustan (idBebedor, idBebida);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla GUSTAN, dados los identificadores de bebedor y bebida
	 * @param idBebedor - El identificador del bebedor
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarGustan(Long idBebedor, Long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlGustan.eliminarGustan(pm, idBebedor, idBebida);           
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla GUSTAN
	 * @return La lista de objetos GUSTAN, construidos con base en las tuplas de la tabla GUSTAN
	 */
	public List<Gustan> darGustan ()
	{
		return sqlGustan.darGustan (pmf.getPersistenceManager());
	}
 
 
	/* ****************************************************************
	 * 			Métodos para manejar la relación SIRVEN
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla SIRVEN
	 * Adiciona entradas al log de la aplicación
	 * @param idBar - El identificador del bar - Debe haber un bar con ese identificador
	 * @param idBebida - El identificador de la bebida - Debe haber una bebida con ese identificador
	 * @param horario - El hororio en que se sirve (DIURNO, NOCTURNO, TODOS)
	 * @return Un objeto SIRVEN con la información dada. Null si ocurre alguna Excepción
	 */
	public Sirven adicionarSirven (Long idBar, Long idBebida, String horario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long tuplasInsertadas = sqlSirven.adicionarSirven (pmf.getPersistenceManager(), idBar, idBebida, horario);
    		tx.commit();

            log.trace ("Inserción de gustan: [" + idBar + ", " + idBebida + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new Sirven (idBar, idBebida, horario);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
 
	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla SIRVEN, dados los identificadores de bar y bebida
	 * @param idBar - El identificador del bar
	 * @param idBebida - El identificador de la bebida
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarSirven (Long idBar, Long idBebida) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
	        Transaction tx=pm.currentTransaction();
	        try
	        {
	            tx.begin();
	            Long resp = sqlSirven.eliminarSirven (pm, idBar, idBebida);	            
	            tx.commit();

	            return resp;
	        }
	        catch (Exception e)
	        {
//	        	e.printStackTrace();
	        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
	        	return -1L;
	        }
	        finally
	        {
	            if (tx.isActive())
	            {
	                tx.rollback();
	            }
	            pm.close();
	        }
	}
 
	/**
	 * Método que consulta todas las tuplas en la tabla SIRVEN
	 * @return La lista de objetos SIRVEN, construidos con base en las tuplas de la tabla SIRVEN
	 */
	public List<Sirven> darSirven ()
	{
		return sqlSirven.darSirven (pmf.getPersistenceManager());
	}
 
	/**
	 * Método que encuentra el identificador de los bares y cuántas bebidas sirve cada uno de ellos. Si una bebida se sirve en diferentes horarios,
	 * cuenta múltiples veces
	 * @return Una lista de arreglos de 2 números. El primero corresponde al identificador del bar, el segundo corresponde al nombre del tipo de bebida
	 */
	public List<Long []> darBaresYCantidadBebidasSirven ()
	{
		List<Long []> resp = new LinkedList<Long []> ();
		List<Object []> tuplas =  sqlSirven.darBaresYCantidadBebidasSirven (pmf.getPersistenceManager());
        for ( Object [] tupla : tuplas)
        {
			Long [] datosResp = new Long [2];
			
			datosResp [0] = ((BigDecimal) tupla [0]).longValue ();
			datosResp [1] = ((BigDecimal) tupla [1]).longValue ();
			resp.add (datosResp);
        }
        return resp;
	}
 
	/* ****************************************************************
	 * 			Métodos para manejar la relación VISITAN
	 *****************************************************************/

	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla VISITAN
	 * Adiciona entradas al log de la aplicación
	 * @param idBebedor - El identificador del bebedor - Debe haber un bebedor con ese identificador
	 * @param idBar - El identificador del bar - Debe haber un bar con ese identificador
	 * @param fecha - La fecha en que se realizó la visita
	 * @param horario - El hororio en que se sirve (DIURNO, NOCTURNO, TODOS)
	 * @return Un objeto VISITAN con la información dada. Null si ocurre alguna Excepción
	 */	
	public Visitan adicionarVisitan (Long idBebedor, Long idBar, Timestamp fecha, String horario) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long tuplasInsertadas = sqlVisitan.adicionarVisitan(pm, idBebedor, idBar, fecha, horario);
            tx.commit();

            log.trace ("Inserción de gustan: [" + idBebedor + ", " + idBar + "]. " + tuplasInsertadas + " tuplas insertadas");

            return new Visitan (idBebedor, idBar, fecha, horario);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}


	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla VISITAN, dados los identificadores de bebedor y bar
	 * @param idBebedor - El identificador del bebedor
	 * @param idBar - El identificador del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarVisitan (Long idBebedor, Long idBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long resp = sqlVisitan.eliminarVisitan(pm, idBebedor, idBar);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla VISITAN, dados el identificador del bebedor
	 * @param idBebedor - El identificador del bebedor
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarVisitanPorIdBebedor (Long idBebedor) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long visitasEliminadas = sqlVisitan.eliminarVisitanPorIdBebedor (pm, idBebedor);
            tx.commit();

            return visitasEliminadas;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	

	/**
	 * Método que elimina, de manera transaccional, una tupla en la tabla VISITAN, dados el identificador del bar
	 * @param idBar - El identificador del bar
	 * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
	 */
	public Long eliminarVisitanPorIdBar (Long idBar) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long visitasEliminadas = sqlVisitan.eliminarVisitanPorIdBar (pm, idBar);
            tx.commit();

            return visitasEliminadas;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1L;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * Método que consulta todas las tuplas en la tabla VISITAN
	 * @return La lista de objetos VISITAN, construidos con base en las tuplas de la tabla VISITAN
	 */
	public List<Visitan> darVisitan ()
	{
		return sqlVisitan.darVisitan (pmf.getPersistenceManager());
	}	

	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public Long [] limpiarParranderos ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            Long [] resp = sqlUtil.limpiarParranderos (pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new Long[] {-1L, -1L, -1L, -1L, -1L, -1L, -1L};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	

 }
