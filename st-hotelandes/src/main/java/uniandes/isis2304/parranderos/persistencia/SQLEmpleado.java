package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Empleado;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLEmpleado
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el IdEmpleado de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLEmpleado (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroIdEmpleado - El numero de documento del IdEmpleado
	 * @param IdEmpleadoDocumento - El IdEmpleado de documento
	 * @param correo - El correo del IdEmpleado
	 * @param idIdEmpleado - El id del IdEmpleado
	 * @param idIdEmpleado - El id del IdEmpleado
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarIdEmpleadoPorId (PersistenceManager pm, Long idEmpleado, String tipoDocumento, String correoEmpleado, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darEmpleado() + "(idEmpleado, tipoDocumento, correoEmpleado, idHotel) values (?, ?, ?, ?)");
        q.setParameters(idEmpleado, tipoDocumento, correoEmpleado, idHotel);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroIdEmpleado - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarEmpleadoPorId (PersistenceManager pm, Long idEmpleado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darEmpleado () + " WHERE idEmpleado = ?");
        q.setParameters(idEmpleado);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN IdEmpleado de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroIdEmpleado - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Empleado darEmpleadoPorId (PersistenceManager pm, Long idEmpleado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darEmpleado () + " WHERE idEmpleado = ?");
		q.setResultClass(Empleado.class);
		q.setParameters(idEmpleado);
		return (Empleado) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<Empleado> darEmpleados (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darEmpleado ());
		q.setResultClass(Empleado.class);
		return (List<Empleado>) q.executeList();
	}

    /**
	 * 
	 * Crea y ejecuta la sentencia SQL para cambiar la ciudad de un bebedor en la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idBebedor - El identificador del bebedor
	 * @param ciudad - La nueva ciudad del bebedor
	 * @return El número de tuplas modificadas
	 */
	public Long updateEmpleadoIdCliente (PersistenceManager pm, Long idEmpleado, Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darEmpleado () + " SET cliente = ? WHERE idEmpleado = ?");
	     q.setParameters(idEmpleado, idCliente);
	     return (Long) q.executeUnique();            
	}
	

    //
	public Long updateEmpleadoNumeroHabitacion (PersistenceManager pm, Long idEmpleado, Integer numeroHabitacion) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darEmpleado () + " SET numeroHabitacion = ? WHERE idEmpleado = ?");
	     q.setParameters(idEmpleado, numeroHabitacion);
	     return (Long) q.executeUnique();            
	}

}
