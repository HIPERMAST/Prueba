package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Usuario;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLUsuario
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Usuario de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLUsuario (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroUsuario - El numero de documento del Usuario
	 * @param UsuarioDocumento - El Usuario de documento
	 * @param correo - El correo del Usuario
	 * @param idUsuario - El id del Usuario
	 * @param idUsuario - El id del Usuario
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarRolUsuarioPorId (PersistenceManager pm, Integer idUsuario, Integer rolUsuario, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darUsuario () + "(idUsuario, rolUsuario, idHotel) values (?, ?, ?)");
        q.setParameters(idUsuario, rolUsuario, idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroUsuario - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarRolUsuarioPorId (PersistenceManager pm, Integer idUsuario)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darUsuario () + " WHERE id = ?");
        q.setParameters(idUsuario);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Usuario de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroUsuario - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Usuario darRolUsuarioPorId (PersistenceManager pm, Integer idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darUsuario () + " WHERE id = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(idUsuario);
		return (Usuario) q.executeUnique();
	}

	//
	public List<Usuario> darRolUsuarios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darUsuario ());
		q.setResultClass(Usuario.class);
		return (List<Usuario>) q.executeList();
	}
	
}
