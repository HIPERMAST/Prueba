package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Lavanderia_id;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Lavanderia_id
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
	public SQLS_Lavanderia_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param id - El numero de documento del Lavanderia
	 * @param nombre - El nombre del Lavanderia
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarLavanderiaPorId (PersistenceManager pm, Integer idLavanderia, String nombreLavanderia) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Lavanderia_id () + "(idLavanderia, nombreLavanderia) values (?, ?)");
        q.setParameters(idLavanderia, nombreLavanderia);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idLavanderia - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarLavanderiaPorId (PersistenceManager pm, Integer idLavanderia)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Lavanderia_id () + " WHERE id = ?");
        q.setParameters(idLavanderia);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Lavanderia de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idLavanderia - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public S_Lavanderia_id darLavanderiaPorId (PersistenceManager pm, Integer idLavanderia) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Lavanderia_id () + " WHERE id = ?");
		q.setResultClass(S_Lavanderia_id.class);
		q.setParameters(idLavanderia);
		return (S_Lavanderia_id) q.executeUnique();
	}

	//
	public List<S_Lavanderia_id> darLavanderias (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Lavanderia_id ());
		q.setResultClass(S_Lavanderia_id.class);
		return (List<S_Lavanderia_id>) q.executeList();
	}

	
}
