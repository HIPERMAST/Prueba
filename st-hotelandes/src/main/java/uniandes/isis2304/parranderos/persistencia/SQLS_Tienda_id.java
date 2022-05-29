package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Tienda_id;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Tienda_id
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
	public SQLS_Tienda_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param id - El numero de documento del Tienda
	 * @param nombre - El nombre del Tienda
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarTiendaPorId (PersistenceManager pm, Integer idTienda, String nombreTienda) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Tienda_id () + "(idTienda, nomreTienda) values (?, ?)");
        q.setParameters(idTienda, nombreTienda);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idTienda - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarTiendaPorId (PersistenceManager pm, Integer idTienda)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Tienda_id () + " WHERE id = ?");
        q.setParameters(idTienda);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Tienda de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idTienda - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public S_Tienda_id darTiendaPorId (PersistenceManager pm, Integer idTienda) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Tienda_id () + " WHERE id = ?");
		q.setResultClass(S_Tienda_id.class);
		q.setParameters(idTienda);
		return (S_Tienda_id) q.executeUnique();
	}

	//
	public List<S_Tienda_id> darTiendas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Tienda_id ());
		q.setResultClass(S_Tienda_id.class);
		return (List<S_Tienda_id>) q.executeList();
	}

	
}
