package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.PlanConsumo;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLPlanConsumo
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
	public SQLPlanConsumo (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroPlanConsumo - El numero de documento del PlanConsumo
	 * @param tipoDocumento - El tipo de documento
	 * @param correo - El correo del PlanConsumo
	 * @param idPlanConsumo - El id del PlanConsumo
	 * @param idPlanConsumo - El id del PlanConsumo
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarPlanConsumoPorId (PersistenceManager pm, Integer idPlanConsumo, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darPlanConsumo () + "(idPlanConsumo, idHotel) values (?, ?)");
        q.setParameters(idPlanConsumo, idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroPlanConsumo - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarPlanConsumoPorId (PersistenceManager pm, Integer idPlanConsumo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darPlanConsumo () + " WHERE idPlanConsumo = ?");
        q.setParameters(idPlanConsumo);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PlanConsumo de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroPlanConsumo - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public PlanConsumo darPlanConsumoPorId (PersistenceManager pm, Integer idPlanConsumo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPlanConsumo () + " WHERE idPlanConsumo = ?");
		q.setResultClass(PlanConsumo.class);
		q.setParameters(idPlanConsumo);
		return (PlanConsumo) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<PlanConsumo> darPlanConsumos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPlanConsumo ());
		q.setResultClass(PlanConsumo.class);
		return (List<PlanConsumo>) q.executeList();
	}
	
}
