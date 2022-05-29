package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Hotel;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLHotel
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
	public SQLHotel (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroHotel - El numero de documento del Hotel
	 * @param tipoDocumento - El tipo de documento
	 * @param correo - El correo del Hotel
	 * @param idHotel - El id del Hotel
	 * @param idHotel - El id del hotel
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarHotelPorId (PersistenceManager pm, Integer idHotel, String nombreHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darHotel () + "(idHotel, nombreHotel) values (?, ?)");
        q.setParameters(idHotel, nombreHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroHotel - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarHotelPorId (PersistenceManager pm, Integer idHotel)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darHotel () + " WHERE idHotel = ?");
        q.setParameters(idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Hotel de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroHotel - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Hotel darHotelPorId (PersistenceManager pm, Integer idHotel) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darHotel () + " WHERE idHotel = ?");
		q.setResultClass(Hotel.class);
		q.setParameters(idHotel);
		return (Hotel) q.executeUnique();
	}

	//
	public List<Hotel> darHoteles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darHotel ());
		q.setResultClass(Hotel.class);
		return (List<Hotel>) q.executeList();
	}
	
}
