package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Internet;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Internet de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Internet
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Internet de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLS_Internet (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Internet a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
     * @param idInternet - El id del Internet
	 * @param capacidad - La capacidad del Internet
	 * @param pagoCuenta - Un Boolean que dice si la cuenta se paga o se carga a la habitacion
	 * @param costoServicio - El costo de servicio
	 * @param idHotel - El id del Hotel
     * @param idCliente - El id del Cliente
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarInternetPorId (PersistenceManager pm, Integer idInternet, Integer capacidad, Boolean pagoCuenta, Integer costoServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_internet() + "(idInternet, capacidad, pagoCuenta, costoServicio, idHotel) values (?, ?, ?, ?, ?)");
        q.setParameters(idInternet, capacidad, pagoCuenta, costoServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar InternetES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idInternet - El id del Internet
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarInternetPorId (PersistenceManager pm, Integer idInternet)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_internet() + " WHERE id = ?");
        q.setParameters(idInternet);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Internet de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idInternet - El id del Internet
	 * @return El objeto Internet que tiene el identificador dado
	 */
	public S_Internet darInternetPorId (PersistenceManager pm, Integer idInternet) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_internet() + " WHERE id = ?");
		q.setResultClass(S_Internet.class);
		q.setParameters(idInternet);
		return (S_Internet) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS InternetES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Internet
	 */
	public List<S_Internet> darInternets (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_internet());
		q.setResultClass(S_Internet.class);
		return (List<S_Internet>) q.executeList();
	}

	//
	public Long updateInternetIdCliente (PersistenceManager pm, Long idInternet, Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darS_internet () + " SET cliente = ? WHERE id = ?");
	     q.setParameters(idInternet, idCliente);
	     return (Long) q.executeUnique();            
	}
	
}
