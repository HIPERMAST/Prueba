package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Cliente;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLCliente
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Cliente de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaParranderos.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaParranderos pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLCliente (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroCliente - El numero de documento del Cliente
	 * @param ClienteDocumento - El Cliente de documento
	 * @param correo - El correo del Cliente
	 * @param numeroDocumentoCliente - El id del Cliente
	 * @param numeroDocumentoCliente - El id del Cliente
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarClientePorId (PersistenceManager pm, String tipoDocumento, Long numeroDocumentoCliente, String correoCliente, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darCliente() + "(tipoDocumento, numeroDocumentoCliente, correoCliente, idHotel) values (?, ?, ?, ?)");
        q.setParameters(tipoDocumento, numeroDocumentoCliente, correoCliente, idHotel);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroCliente - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarClientePorId (PersistenceManager pm, Integer numeroDocumentoCliente)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darCliente () + " WHERE numerodocumentocliente = ?");
        q.setParameters(numeroDocumentoCliente);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Cliente de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroCliente - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Cliente darClientePorId (PersistenceManager pm, Integer numeroDocumentoCliente) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darCliente () + " WHERE numerodocumentocliente = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(numeroDocumentoCliente);
		return (Cliente) q.executeUnique();
	}

	//
	public List<Cliente> darClientes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darCliente ());
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeList();
	}

	//
	public Long updateClienteIdHabitacion (PersistenceManager pm, Long idHabitacion, Long numerodocumentocliente) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darCliente () + " SET idHabitacion = ? WHERE numerodocumentocliente = ?");
		q.setParameters(idHabitacion, numerodocumentocliente);
		return (Long) q.executeUnique();            
	}
	
}
