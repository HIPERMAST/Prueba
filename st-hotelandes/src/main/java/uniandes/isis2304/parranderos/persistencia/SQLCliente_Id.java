package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Cliente_id;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLCliente_id
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLCliente_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param id - El numero de documento del Cliente
	 * @param nombre - El nombre del Cliente
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarClientePorId (PersistenceManager pm, Long numeroDocumento, String nombreCliente) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darCliente_id() + "(numeroDocumento, nombreCliente) values (?, ?)");
        q.setParameters(numeroDocumento, nombreCliente);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroDocumento - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarClientePorId (PersistenceManager pm, Long numeroDocumento)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darCliente_id () + " WHERE numerodocumento = ?");
        q.setParameters(numeroDocumento);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Cliente de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroDocumento - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Cliente_id darClientePorId (PersistenceManager pm, Long numeroDocumento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darCliente_id () + " WHERE numerodocumento = ?");
		q.setResultClass(Cliente_id.class);
		q.setParameters(numeroDocumento);
		return (Cliente_id) q.executeUnique();
	}

	//
	public List<Cliente_id> darClientes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darCliente_id ());
		q.setResultClass(Cliente_id.class);
		return (List<Cliente_id>) q.executeList();
	}

	
}
