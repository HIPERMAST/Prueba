package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Producto_id;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLProducto_id
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
	public SQLProducto_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param id - El numero de documento del Producto
	 * @param nombre - El nombre del Producto
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarProductoPorId (PersistenceManager pm, Integer idProducto, String nombreProducto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darProducto_id () + "(idProducto, nombreProducto) values (?, ?)");
        q.setParameters(idProducto, nombreProducto);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idProducto - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarProductoPorId (PersistenceManager pm, Long idProducto)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darProducto_id () + " WHERE idProducto = ?");
        q.setParameters(idProducto);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Producto de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idProducto - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Producto_id darProductoPorId (PersistenceManager pm, Long idProducto) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darProducto_id () + " WHERE idProducto = ?");
		q.setResultClass(Producto_id.class);
		q.setParameters(idProducto);
		return (Producto_id) q.executeUnique();
	}

	//
	public List<Producto_id> darProductoes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darProducto_id ());
		q.setResultClass(Producto_id.class);
		return (List<Producto_id>) q.executeList();
	}

	
}
