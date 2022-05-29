package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Reserva;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLReserva
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
	public SQLReserva (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	//
	public Long adicionarReservaPorId (PersistenceManager pm, Long id, Integer cantPersonas, Timestamp checkIn, Timestamp checkOut, Integer activo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darReserva () + "(idReserva, cantPersonas, checkIn, checkOut, activo) values (?, ?, ?, ?, ?)");
        q.setParameters(id, cantPersonas, checkIn, checkOut, activo);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroDocumento - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarReservaPorId (PersistenceManager pm, Integer idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darReserva () + " WHERE id = ?");
        q.setParameters(idReserva);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN USUARIO de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroDocumento - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Reserva darReservaPorId (PersistenceManager pm, Long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darReserva () + " WHERE idReserva = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(idReserva);
		return (Reserva) q.executeUnique();
	}

	//
	public List<Reserva> darReservas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darReserva ());
		q.setResultClass(Reserva.class);
		return (List<Reserva>) q.executeList();
	}

	//
	public Long updateReservaActivo (PersistenceManager pm, int i , Long idReserva)
	{
			Query q = pm.newQuery(SQL, "UPDATE " + pp.darReserva () + " SET Activo = ? WHERE idreserva = ?");
			q.setParameters(i , idReserva);
			return (Long) q.executeUnique();            
	}

	//
    public Long updateReservaIdPlanConsumo (PersistenceManager pm, Integer idReserva, Integer idPlanConsumo) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darReserva () + " SET planConsumo = ? WHERE id = ?");
	     q.setParameters(idReserva, idPlanConsumo);
	     return (Long) q.executeUnique();            
	}
	
}
