package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Salon;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Salon de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Salon
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Salon de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLS_Salon (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	//
	public Integer adicionarSalonPorId (PersistenceManager pm, Integer idSalon, String tipoSalon, String tiempoLimpieza, Integer capacidad, Boolean pagoCuenta, Integer costoServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Salon () + "(idSalon, tipoSalon, tiempoLimpieza, capacidad, pagoCuenta, costoServicio, idHotel) values (?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(idSalon, tipoSalon, tiempoLimpieza, capacidad, pagoCuenta, costoServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar SalonES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idSalon - El id del Salon
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarSalonPorId (PersistenceManager pm, Integer idSalon)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Salon () + " WHERE IDSALON = ?");
        q.setParameters(idSalon);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Salon de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idSalon - El id del Salon
	 * @return El objeto Salon que tiene el identificador dado
	 */
	public S_Salon darSalonPorId (PersistenceManager pm, Long idSalon) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Salon () + " WHERE IDSALON = ?");
		q.setResultClass(S_Salon.class);
		q.setParameters(idSalon);
		return (S_Salon) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS SalonES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Salon
	 */
	public List<S_Salon> darSalones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Salon ());
		q.setResultClass(S_Salon.class);
		return (List<S_Salon>) q.executeList();
	}

	//
	public Long updateSalonIdCliente (PersistenceManager pm, Long idCliente, Integer idSalon) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darS_Salon () + " SET IDCLIENTE = ? WHERE IDSALON = ?");
		q.setParameters(idCliente, idSalon);
		return (Long) q.executeUnique();
	}
	
}
