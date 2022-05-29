package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Internet_id;


/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Internet_id
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
	public SQLS_Internet_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param id - El numero de documento del Internet
	 * @param nombre - El nombre del Internet
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarInternetPorId (PersistenceManager pm, Integer idInternet, String nombreInternet) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_internet_id () + "(idInternet, nombreInternet) values (?, ?)");
        q.setParameters(idInternet, nombreInternet);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idInternet - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarInternetPorId (PersistenceManager pm, Integer idInternet)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_internet_id () + " WHERE id = ?");
        q.setParameters(idInternet);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Internet de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idInternet - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public S_Internet_id darInternetPorId (PersistenceManager pm, Integer idInternet) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_internet_id () + " WHERE id = ?");
		q.setResultClass(S_Internet_id.class);
		q.setParameters(idInternet);
		return (S_Internet_id) q.executeUnique();
	}

	//
	public List<S_Internet_id> darInternets (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_internet_id ());
		q.setResultClass(S_Internet_id.class);
		return (List<S_Internet_id>) q.executeList();
	}

	
}
