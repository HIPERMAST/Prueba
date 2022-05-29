package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Habitacion;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLHabitacion
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
	public SQLHabitacion (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroHabitacion - El numero de documento del Habitacion
	 * @param tipoDocumento - El tipo de documento
	 * @param correo - El correo del Habitacion
	 * @param idHabitacion - El id del Habitacion
	 * @param idHotel - El id del hotel
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarHabitacionPorId (PersistenceManager pm, Integer numeroHabitacion, Integer costoHabitacion, Integer idTipo, Integer idHotel, Integer idCuenta) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darHabitacion () + "(numeroHabitacion, costoHabitacion, idTipo, idHotel, idCuenta) values (?, ?, ?, ?, ?)");
        q.setParameters(numeroHabitacion, costoHabitacion, idTipo, idHotel, idCuenta);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroHabitacion - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarHabitacionPorId (PersistenceManager pm, Long numeroHabitacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darHabitacion () + " WHERE numerohabitacion = ?");
        q.setParameters(numeroHabitacion);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Habitacion de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idHabitacion - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Habitacion darHabitacionPorId (PersistenceManager pm, Long idHabitacion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darHabitacion () + " WHERE numerohabitacion = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(idHabitacion);
		return (Habitacion) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Habitacion de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idHabitacion - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public List<Habitacion> darHabitacionesPorTipo (PersistenceManager pm, Integer tipo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darHabitacion () + " WHERE idTipo = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(tipo);
		return (List<Habitacion>) q.executeList();
	}


	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<Habitacion> darHabitaciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darHabitacion());
		q.setResultClass(Habitacion.class);
		return (List<Habitacion>) q.executeList();
	}


    //
	public Long updateHabitacionIdReserva (PersistenceManager pm, Long id, Long numeroHabitacion) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darHabitacion () + " SET idreserva = ? WHERE numerohabitacion = ?");
	     q.setParameters(id, numeroHabitacion);
	     return (Long) q.executeUnique(); 
	}


	//
	public Long eliminarHabitacionReservaPorId (PersistenceManager pm,Long numeroHabitacion) 
	{
			Query q = pm.newQuery(SQL, "UPDATE " + pp.darHabitacion () + " SET idreserva = ? WHERE numerohabitacion = ?");
			q.setParameters(null, numeroHabitacion);
			return (Long) q.executeUnique(); 
	}
	
}
