package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Empleado_id;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLEmpleado_id
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
	public SQLEmpleado_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param id - El numero de documento del Empleado
	 * @param nombre - El nombre del Empleado
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarEmpleadoPorId (PersistenceManager pm, Long idEmpleado, String nombreEmpleado) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darEmpleado_id() + "(idEmpleado, nombreEmpleado) values (?, ?)");
        q.setParameters(idEmpleado, nombreEmpleado);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idEmpleado - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarEmpleadoPorId (PersistenceManager pm, Long idEmpleado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darEmpleado_id () + " WHERE idEmpleado = ?");
        q.setParameters(idEmpleado);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Empleado de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idEmpleado - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Empleado_id darEmpleadoPorId (PersistenceManager pm, Long idEmpleado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darEmpleado_id () + " WHERE idEmpleado = ?");
		q.setResultClass(Empleado_id.class);
		q.setParameters(idEmpleado);
		return (Empleado_id) q.executeUnique();
	}

	//
	public List<Empleado_id> darEmpleados (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darEmpleado_id ());
		q.setResultClass(Empleado_id.class);
		return (List<Empleado_id>) q.executeList();
	}

	
}
