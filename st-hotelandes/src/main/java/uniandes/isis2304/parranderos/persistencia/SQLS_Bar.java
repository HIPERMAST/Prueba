package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Bar;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Bar
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Bar de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLS_Bar (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
     * @param idBar - El id del Bar
	 * @param estiloBar - El estilo del Bar
	 * @param capacidad - La capacidad del Bar
	 * @param pagoCuenta - Un Boolean que dice si la cuenta se paga o se carga a la habitacion
	 * @param costoServicio - El costo de servicio
	 * @param idHotel - El id del Hotel
     * @param idCliente - El id del Cliente
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarBarPorId (PersistenceManager pm, Integer idBar, String estiloBar, Integer capacidad, Boolean pagoCuenta, Integer costoServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Bar () + "(idBar, estiloBar, capacidad, pagoCuenta, costoServicio, idHotel) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idBar, estiloBar, capacidad, pagoCuenta, costoServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idBar - El id del Bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarBarPorId (PersistenceManager pm, Integer idBar)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Bar () + " WHERE id = ?");
        q.setParameters(idBar);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Bar de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idBar - El id del Bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public S_Bar darBarPorId (PersistenceManager pm, Integer idBar) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Bar () + " WHERE id = ?");
		q.setResultClass(S_Bar.class);
		q.setParameters(idBar);
		return (S_Bar) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Bar
	 */
	public List<S_Bar> darBars (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Bar ());
		q.setResultClass(S_Bar.class);
		return (List<S_Bar>) q.executeList();
	}

	//
	public Long updateBarIdCliente (PersistenceManager pm, Long idBar, Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darS_Bar () + " SET cliente = ? WHERE id = ?");
	     q.setParameters(idBar, idCliente);
	     return (Long) q.executeUnique();            
	}
	
}
