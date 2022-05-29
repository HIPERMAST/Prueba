package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Recepcionista_id;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLRecepcionista_id
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
	public SQLRecepcionista_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param id - El numero de documento del Recepcion
	 * @param nombre - El nombre del Recepcion
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarRecepcionPorId (PersistenceManager pm, Long idRecepcion, String nombreCliente) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darRecepcionista_id () + "(idRecepcion, nombreCliente) values (?, ?)");
        q.setParameters(idRecepcion, nombreCliente);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idRecepcion - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarRecepcionPorId (PersistenceManager pm, Long idRecepcion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darRecepcionista_id () + " WHERE id = ?");
        q.setParameters(idRecepcion);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Recepcion de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idRecepcion - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Recepcionista_id darRecepcionPorId (PersistenceManager pm, Long idRecepcion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darRecepcionista_id () + " WHERE id = ?");
		q.setResultClass(Recepcionista_id.class);
		q.setParameters(idRecepcion);
		return (Recepcionista_id) q.executeUnique();
	}

	//
	public List<Recepcionista_id> darRecepciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darRecepcionista_id ());
		q.setResultClass(Recepcionista_id.class);
		return (List<Recepcionista_id>) q.executeList();
	}

	
}
