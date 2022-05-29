package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Supermercado_id;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Supermercado_id
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
	public SQLS_Supermercado_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param id - El numero de documento del Piscina
	 * @param nombre - El nombre del Piscina
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarPiscinaPorId (PersistenceManager pm, Integer idSupermercado, String nombreSupermercado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Supermercado_id () + "(idSupermercado, nombreSupermercado) values (?, ?)");
        q.setParameters(idSupermercado, nombreSupermercado);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idSupermercado - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarPiscinaPorId (PersistenceManager pm, Integer idSupermercado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Supermercado_id () + " WHERE id = ?");
        q.setParameters(idSupermercado);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Piscina de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idSupermercado - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public S_Supermercado_id darPiscinaPorId (PersistenceManager pm, Integer idSupermercado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Supermercado_id () + " WHERE id = ?");
		q.setResultClass(S_Supermercado_id.class);
		q.setParameters(idSupermercado);
		return (S_Supermercado_id) q.executeUnique();
	}

	//
	public List<S_Supermercado_id> darPiscinas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Supermercado_id ());
		q.setResultClass(S_Supermercado_id.class);
		return (List<S_Supermercado_id>) q.executeList();
	}

	
}
