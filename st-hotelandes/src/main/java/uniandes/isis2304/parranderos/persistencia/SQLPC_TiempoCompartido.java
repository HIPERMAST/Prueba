package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.PC_TiempoCompartido;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLPC_TiempoCompartido
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
	public SQLPC_TiempoCompartido (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_TiempoCompartido - El numero de documento del PC_TiempoCompartido
	 * @param tipoDocumento - El tipo de documento
	 * @param correo - El correo del PC_TiempoCompartido
	 * @param idTiempoCompartido - El id del PC_TiempoCompartido
	 * @param idTiempoCompartido - El id del PC_TiempoCompartido
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarPC_TiempoCompartidoPorId (PersistenceManager pm, Integer idTiempoCompartido, Integer descuentoBar, Integer descuentoRestaurante, Integer idBar, Integer idRestaurante) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darPC_TiempoCompartido () + "(idTiempoCompartido, descuentoBar, descuentoRestaurante, idBar, idRestaurante) values (?, ?, ?, ?, ?)");
        q.setParameters(idTiempoCompartido, descuentoBar, descuentoRestaurante, idBar, idRestaurante);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_TiempoCompartido - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarPC_TiempoCompartidoPorId (PersistenceManager pm, Integer idTiempoCompartido)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darPC_TiempoCompartido () + " WHERE idTiempoCompartido = ?");
        q.setParameters(idTiempoCompartido);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PC_TiempoCompartido de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_TiempoCompartido - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public PC_TiempoCompartido darPC_TiempoCompartidoPorId (PersistenceManager pm, Integer idTiempoCompartido) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPC_TiempoCompartido () + " WHERE idTiempoCompartido = ?");
		q.setResultClass(PC_TiempoCompartido.class);
		q.setParameters(idTiempoCompartido);
		return (PC_TiempoCompartido) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<PC_TiempoCompartido> darPC_TiempoCompartidoes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPC_TiempoCompartido ());
		q.setResultClass(PC_TiempoCompartido.class);
		return (List<PC_TiempoCompartido>) q.executeList();
	}

    //
	public Integer updateTiempoCompartidoIdReserva (PersistenceManager pm, Integer idTiempoCompartido, Integer idReserva) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darPC_TiempoCompartido () + " SET reserva = ? WHERE idTiempoCompartido = ?");
	     q.setParameters(idTiempoCompartido, idReserva);
	     return (Integer) q.executeUnique();           
	}


}
