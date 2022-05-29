package uniandes.isis2304.parranderos.persistencia;

import java.util.List;
import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Piscina;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Piscina de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Piscina
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Piscina de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLS_Piscina (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Piscina a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
     * @param idPiscina - El id del Piscina
	 * @param profundidad - La profundidad del Piscina
     * @param horarioInicial - El horarioInicial del Piscina
     * @param horarioFinal - El horarioFinal del Piscina
	 * @param capacidad - La capacidad del Piscina
	 * @param pagoCuenta - Un Boolean que dice si la cuenta se paga o se carga a la habitacion
	 * @param costoServicio - El costo de servicio
	 * @param idHotel - El id del Hotel
     * @param idCliente - El id del Cliente
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarPiscinaPorId (PersistenceManager pm, Integer idPiscina, Integer profundidad, Timestamp horarioInicial, Timestamp horarioFinal, Integer capacidad, Boolean pagoCuenta, Integer costoServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Piscina () + "(idPiscina, profundidad, horarioInicial, horarioFinal, capacidad, pagoCuenta, costoServicio, idHotel) values (?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(idPiscina, profundidad, horarioInicial, horarioFinal, capacidad, pagoCuenta, costoServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar PiscinaES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idPiscina - El id del Piscina
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarPiscinaPorId (PersistenceManager pm, Integer idPiscina)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Piscina () + " WHERE id = ?");
        q.setParameters(idPiscina);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Piscina de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idPiscina - El id del Piscina
	 * @return El objeto Piscina que tiene el identificador dado
	 */
	public SQLS_Piscina darPiscinaPorId (PersistenceManager pm, Integer idPiscina) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Piscina () + " WHERE id = ?");
		q.setResultClass(S_Piscina.class);
		q.setParameters(idPiscina);
		return (SQLS_Piscina) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS PiscinaES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Piscina
	 */
	public List<S_Piscina> darPiscinas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Piscina ());
		q.setResultClass(S_Piscina.class);
		return (List<S_Piscina>) q.executeList();
	}

	//
	public Long updatePiscinaIdCliente (PersistenceManager pm, Long idPiscina, Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darS_Piscina () + " SET cliente = ? WHERE id = ?");
	     q.setParameters(idPiscina, idCliente);
	     return (Long) q.executeUnique();            
	}
	
}
