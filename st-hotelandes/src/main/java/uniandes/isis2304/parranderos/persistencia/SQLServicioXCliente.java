package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.ServicioXCliente;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLServicioXCliente
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
	public SQLServicioXCliente (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param historial - El numero de documento del usuario
	 * @param fecha - El tipo de documento
	 * @param idCliente - El idCliente del usuario
	 * @param idServicio - La contraseña del usuario
	 * @param idEspecifico - El id del usuario
	 * @param cantVisitas - El id del hotel
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarServicioXClienteporId(PersistenceManager pm, Integer historial, Timestamp fecha, Long idCliente, Integer idServicio, Integer idEspecifico, Integer cantVisitas, Integer costo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darServicioXCliente() + "(historial, fecha, idCliente, idServicio, idEspecifico, cantVisitas, costo) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(historial, fecha, idCliente, idServicio, idEspecifico, cantVisitas, costo);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param historial - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarUsuarioPorId (PersistenceManager pm, Integer historial)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darServicioXCliente() + " WHERE historial = ?");
        q.setParameters(historial);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN USUARIO de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param historial - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public ServicioXCliente darUsuarioPorId (PersistenceManager pm, Integer historial) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darServicioXCliente()+ " WHERE historial = ?");
		q.setResultClass(ServicioXCliente.class);
		q.setParameters(historial);
		return (ServicioXCliente) q.executeUnique();
	}

	//
	public List<ServicioXCliente> darUsuarios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darServicioXCliente());
		q.setResultClass(ServicioXCliente.class);
		return (List<ServicioXCliente>) q.executeList();
	}

	
}
