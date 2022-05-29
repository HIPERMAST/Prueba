package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Servicio;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLServicio
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Servicio de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLServicio (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	//
	public Integer adicionarServicioPorId (PersistenceManager pm, Integer idServicio, String nombreServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darServicio () + "(idServicio, nombreServicio, idHotel) values (?, ?, ?)");
        q.setParameters(idServicio, nombreServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idServicio - El id del Servicio
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarServicioPorId (PersistenceManager pm, Integer idServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darServicio () + " WHERE id = ?");
        q.setParameters(idServicio);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Servicio de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idServicio - El id del Servicio
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Servicio darServicioPorId (PersistenceManager pm, Integer idServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darServicio () + " WHERE id = ?");
		q.setResultClass(Servicio.class);
		q.setParameters(idServicio);
		return (Servicio) q.executeUnique();
	}

	//
	public List<Servicio> darServicios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darServicio ());
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}

	//
	public Integer updateServicioIdCliente (PersistenceManager pm, Integer idServicio,  Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darServicio () + " SET reserva = ? WHERE id = ?");
	     q.setParameters(idServicio, idCliente);
	     return (Integer) q.executeUnique();            
	}
	
}
