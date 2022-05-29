package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.PlanConsumo_id;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLPlanConsumo_id
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
	public SQLPlanConsumo_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param id - El numero de documento del PlanConsumo
	 * @param nombre - El nombre del PlanConsumo
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarPlanConsumoPorId (PersistenceManager pm, Integer idPlanConsumo, String nombrePlanConsumo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darPlanConsumo_id () + "(idPlanConsumo, nombrePlanConsumo) values (?, ?)");
        q.setParameters(idPlanConsumo, nombrePlanConsumo);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idPlanConsumo - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarPlanConsumoPorId (PersistenceManager pm, Integer idPlanConsumo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darPlanConsumo_id () + " WHERE idPlanConsumo = ?");
        q.setParameters(idPlanConsumo);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PlanConsumo de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idPlanConsumo - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public PlanConsumo_id darPlanConsumoPorId (PersistenceManager pm, Integer idPlanConsumo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPlanConsumo_id () + " WHERE idPlanConsumo = ?");
		q.setResultClass(PlanConsumo_id.class);
		q.setParameters(idPlanConsumo);
		return (PlanConsumo_id) q.executeUnique();
	}

	//
	public List<PlanConsumo_id> darPlanConsumos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPlanConsumo_id ());
		q.setResultClass(PlanConsumo_id.class);
		return (List<PlanConsumo_id>) q.executeList();
	}

	
}
