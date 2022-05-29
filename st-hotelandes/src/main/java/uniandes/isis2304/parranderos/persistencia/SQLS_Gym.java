package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Gym
;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Gym de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Gym
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Gym de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLS_Gym (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Gym a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
     * @param idGym - El id del Gym 
	 * @param cantMaquinas - El estilo del Gym
	 * @param capacidad - La capacidad del Gym
	 * @param pagoCuenta - Un Boolean que dice si la cuenta se paga o se carga a la habitacion
	 * @param costoServicio - El costo de servicio
	 * @param idHotel - El id del Hotel
     * @param idCliente - El id del Cliente
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarGymPorId (PersistenceManager pm, Integer idGYM, Integer cantMaquinas, Integer capacidad, Boolean pagoCuenta, Integer costoServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Gym() + "(idGYM, cantMaquinas, capacidad, pagoCuenta, costoServicio, idHotel) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idGYM, cantMaquinas, capacidad, pagoCuenta, costoServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar Gym ES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idGYM - El id del Gym 
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarGymPorId (PersistenceManager pm, Integer idGYM)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Gym() + " WHERE id = ?");
        q.setParameters(idGYM);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Gym de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idGYM - El id del Gym 
	 * @return El objeto Gym que tiene el identificador dado
	 */
	public S_Gym darGymPorId (PersistenceManager pm, Integer idGYM) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Gym() + " WHERE id = ?");
		q.setResultClass(S_Gym.class);
		q.setParameters(idGYM);
		return (S_Gym) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS Gym ES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Gym 
	 */
	public List<S_Gym> darGyms (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Gym());
		q.setResultClass(S_Gym.class);
		return (List<S_Gym>) q.executeList();
	}
	
	//
	public Long updateGYMIdCliente (PersistenceManager pm, Long idGYM, Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darS_Gym () + " SET cliente = ? WHERE id = ?");
	     q.setParameters(idGYM, idCliente);
	     return (Long) q.executeUnique();            
	}
}
