package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Producto;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLProducto
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el IdProducto de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLProducto (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroIdProducto - El numero de documento del IdProducto
	 * @param IdProductoDocumento - El IdProducto de documento
	 * @param correo - El correo del IdProducto
	 * @param idIdProducto - El id del IdProducto
	 * @param idIdProducto - El id del IdProducto
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarIdProductoPorId (PersistenceManager pm, Integer idProducto, Integer precioProducto) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darProducto () + "(idProducto, precioProducto) values (?, ?)");
        q.setParameters(idProducto, precioProducto);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroIdProducto - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarProductoPorId (PersistenceManager pm, Long idProducto)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darProducto () + " WHERE idProducto = ?");
        q.setParameters(idProducto);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN IdProducto de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroIdProducto - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Producto darProductoPorId (PersistenceManager pm, Long idProducto) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darProducto () + " WHERE idProducto = ?");
		q.setResultClass(Producto.class);
		q.setParameters(idProducto);
		return (Producto) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<Producto> darProductos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darProducto ());
		q.setResultClass(Producto.class);
		return (List<Producto>) q.executeList();
	}

    /**
	 * 
	 * Crea y ejecuta la sentencia SQL para cambiar la ciudad de un bebedor en la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idBebedor - El identificador del bebedor
	 * @param ciudad - La nueva ciudad del bebedor
	 * @return El número de tuplas modificadas
	 */
	public Long updateProductoIdCliente (PersistenceManager pm, Long idProducto, Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaBebedor () + " SET cliente = ? WHERE idProducto = ?");
	     q.setParameters(idProducto, idCliente);
	     return (Long) q.executeUnique();            
	}
	

    //
	public Long updateProductoIdRestaurante (PersistenceManager pm, Long idProducto, Integer idRestaurante) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaBebedor () + " SET Restaurante = ? WHERE idProducto = ?");
	     q.setParameters(idProducto, idRestaurante);
	     return (Long) q.executeUnique();            
	}

	//
	public Integer updateHabitacionIdBar (PersistenceManager pm, Integer idProducto, Integer idBar) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaBebedor () + " SET Bar = ? WHERE id = ?");
	     q.setParameters(idProducto, idBar);
	     return (Integer) q.executeUnique();            
	}
	
	//
	public Long updateProductoIdSupermercado (PersistenceManager pm, Long idProducto, Integer idSupermercado) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaBebedor () + " SET Supermercado = ? WHERE id = ?");
	     q.setParameters(idProducto, idSupermercado);
	     return (Long) q.executeUnique();            
	}

	//
	public Long updateProductoIdTienda(PersistenceManager pm, Long idProducto, Integer idTienda) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaBebedor () + " SET Tienda = ? WHERE id = ?");
	     q.setParameters(idProducto, idTienda);
	     return (Long) q.executeUnique();            
	}

}
