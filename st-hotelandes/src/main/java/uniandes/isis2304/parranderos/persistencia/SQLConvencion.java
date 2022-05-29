package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Convencion;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLConvencion
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
	public SQLConvencion (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	//
	public Long adicionarConvencionPorId (PersistenceManager pm, Long idConvencion, Timestamp checkIn, Timestamp checkOut, Integer cantPersonas, Integer idPlanConsumo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darConvencion () + "(idConvencion, checkIn, checkOut,cantPersonas,  idPlanConsumo) values (?, ?, ?, ?, ?)");
        q.setParameters(idConvencion, checkIn, checkOut, cantPersonas, idPlanConsumo);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroDocumento - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarConvencionPorId (PersistenceManager pm, Integer idConvencion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darConvencion () + " WHERE idConvencion = ?");
        q.setParameters(idConvencion);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN USUARIO de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroDocumento - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Convencion darConvencionPorId (PersistenceManager pm, Long idConvencion) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darConvencion () + " WHERE idConvencion = ?");
		q.setResultClass(Convencion.class);
		q.setParameters(idConvencion);
		return (Convencion) q.executeUnique();
	}

	//
	public List<Convencion> darConvencions (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darConvencion ());
		q.setResultClass(Convencion.class);
		return (List<Convencion>) q.executeList();
	}     
	

	//
    public Long updateConvencionIdPlanConsumo (PersistenceManager pm, Integer idConvencion, Integer idPlanConsumo) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darConvencion () + " SET planConsumo = ? WHERE idConvencion = ?");
	     q.setParameters(idConvencion, idPlanConsumo);
	     return (Long) q.executeUnique();            
	}
	
}
