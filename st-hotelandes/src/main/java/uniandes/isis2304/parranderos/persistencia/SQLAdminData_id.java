package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.AdminData_id;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLAdminData_id
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
	public SQLAdminData_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	//
	public Long adicionarUsuarioPorId (PersistenceManager pm, Long id, String nombre) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darAdmindata_id () + "(id, nombre) values (?, ?)");
        q.setParameters(id, nombre);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroDocumento - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarUsuarioPorId (PersistenceManager pm, Long numeroDocumento)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darAdmindata_id () + " WHERE id = ?");
        q.setParameters(numeroDocumento);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN USUARIO de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroDocumento - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public AdminData_id darUsuarioPorId (PersistenceManager pm, Long numeroDocumento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darAdmindata_id () + " WHERE id = ?");
		q.setResultClass(AdminData_id.class);
		q.setParameters(numeroDocumento);
		return (AdminData_id) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<AdminData_id> darUsuarios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darAdmindata_id ());
		q.setResultClass(AdminData_id.class);
		return (List<AdminData_id>) q.executeList();
	}

	
}
