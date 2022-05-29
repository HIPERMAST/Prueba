package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.PC_TodoIncluido;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLPC_TodoIncluido
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
	public SQLPC_TodoIncluido (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_TodoIncluido - El numero de documento del PC_TodoIncluido
	 * @param tipoDocumento - El tipo de documento
	 * @param correo - El correo del PC_TodoIncluido
	 * @param idProducto - El id del PC_TodoIncluido
	 * @param idProducto - El id del PC_TodoIncluido
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarPC_TodoIncluidoPorId (PersistenceManager pm, Integer idProducto, Integer idRestaurante) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darPC_TodoIncluido () + "(idProducto, idRestaurante) values (?, ?)");
        q.setParameters(idProducto, idRestaurante);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_TodoIncluido - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarPC_TodoIncluidoPorId (PersistenceManager pm, Integer idProducto)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darPC_TodoIncluido () + " WHERE idProducto = ?");
        q.setParameters(idProducto);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PC_TodoIncluido de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_TodoIncluido - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public PC_TodoIncluido darPC_TodoIncluidoPorId (PersistenceManager pm, Integer idProducto) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPC_TodoIncluido () + " WHERE idProducto = ?");
		q.setResultClass(PC_TodoIncluido.class);
		q.setParameters(idProducto);
		return (PC_TodoIncluido) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<PC_TodoIncluido> darPC_TodoIncluidoes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPC_TodoIncluido ());
		q.setResultClass(PC_TodoIncluido.class);
		return (List<PC_TodoIncluido>) q.executeList();
	}

    //
	public Integer updateTodoIncluidoIdReserva (PersistenceManager pm, Integer idProducto, Integer idReserva) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darPC_TodoIncluido () + " SET reserva = ? WHERE idProducto = ?");
	     q.setParameters(idProducto, idReserva);
	     return (Integer) q.executeUnique();           
	}


}
