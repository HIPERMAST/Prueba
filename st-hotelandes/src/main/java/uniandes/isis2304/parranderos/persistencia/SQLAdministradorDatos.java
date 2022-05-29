package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.AdministradorDatos;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLAdministradorDatos
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
	public SQLAdministradorDatos (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroDocumento - El numero de documento del usuario
	 * @param tipoDocumento - El tipo de documento
	 * @param correo - El correo del usuario
	 * @param pwd - La contraseña del usuario
	 * @param idUsuario - El id del usuario
	 * @param idHotel - El id del hotel
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarUsuarioPorId (PersistenceManager pm, Long numeroDocumento, String tipoDocumento, String correo, String pw, Integer idUsuario, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darAdministradordatos() + "(numeroDocumento, tipoDocumento, correo, idUsuario, idHotel) values (?, ?, ?, ?, ?)");
        q.setParameters(numeroDocumento, tipoDocumento, correo, idUsuario, idHotel);
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
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darAdministradordatos() + " WHERE numerodocumento = ?");
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
	public AdministradorDatos darUsuarioPorId (PersistenceManager pm, Long numeroDocumento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darAdministradordatos()+ " WHERE numerodocumento = ?");
		q.setResultClass(AdministradorDatos.class);
		q.setParameters(numeroDocumento);
		return (AdministradorDatos) q.executeUnique();
	}

	//
	public List<AdministradorDatos> darUsuarios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darAdministradordatos());
		q.setResultClass(AdministradorDatos.class);
		return (List<AdministradorDatos>) q.executeList();
	}

	
}
