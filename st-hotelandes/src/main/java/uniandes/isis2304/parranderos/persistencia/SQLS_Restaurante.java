package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Restaurante;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Restaurante de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Restaurante
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Restaurante de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLS_Restaurante (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Restaurante a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
     * @param idRestaurante - El id del Restaurante
	 * @param estiloRestaurante - El estilo del Restaurante
	 * @param capacidad - La capacidad del Restaurante
	 * @param pagoCuenta - Un Boolean que dice si la cuenta se paga o se carga a la habitacion
	 * @param costoServicio - El costo de servicio
	 * @param idHotel - El id del Hotel
     * @param idCliente - El id del Cliente
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarRestaurantePorId (PersistenceManager pm, Integer idRestaurante, String estiloRestaurante, Integer capacidad, Boolean pagoCuenta, Integer costoServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Restaurante () + "(idRestaurante, estiloRestaurante, capacidad, pagoCuenta, costoServicio, idHotel) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idRestaurante, estiloRestaurante, capacidad, pagoCuenta, costoServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar RestauranteES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idRestaurante - El id del Restaurante
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarRestaurantePorId (PersistenceManager pm, Integer idRestaurante)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Restaurante () + " WHERE id = ?");
        q.setParameters(idRestaurante);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Restaurante de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idRestaurante - El id del Restaurante
	 * @return El objeto Restaurante que tiene el identificador dado
	 */
	public S_Restaurante darRestaurantePorId (PersistenceManager pm, Integer idRestaurante) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Restaurante () + " WHERE id = ?");
		q.setResultClass(S_Restaurante.class);
		q.setParameters(idRestaurante);
		return (S_Restaurante) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS RestauranteES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Restaurante
	 */
	public List<S_Restaurante> darRestaurantes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Restaurante ());
		q.setResultClass(S_Restaurante.class);
		return (List<S_Restaurante>) q.executeList();
	}

	//
	public Long updateRestauranteIdCliente (PersistenceManager pm, Long idRestaurante, Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darS_Restaurante () + " SET cliente = ? WHERE id = ?");
	     q.setParameters(idRestaurante, idCliente);
	     return (Long) q.executeUnique();            
	}
	
}
