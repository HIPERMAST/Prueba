package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.OrganizadorEventos_id;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLOrganizadorEventos_id
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
	public SQLOrganizadorEventos_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idOE - El numero de documento del usuario
	 * @param tipoDocumento - El tipo de documento
	 * @param correo - El correo del usuario
	 * @param pwd - La contraseña del usuario
	 * @param idUsuario - El id del usuario
	 * @param idHotel - El id del hotel
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarOEporId(PersistenceManager pm, Long idOE, String nombreOE) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darOrganizadorEventos_Id() + "(idOE, nombreOE) values (?, ?)");
        q.setParameters(idOE, nombreOE);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idOE - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarUsuarioPorId (PersistenceManager pm, Long idOE)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darOrganizadorEventos_Id() + " WHERE idOE = ?");
        q.setParameters(idOE);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN USUARIO de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idOE - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public OrganizadorEventos_id darUsuarioPorId (PersistenceManager pm, Long idOE) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darOrganizadorEventos_Id()+ " WHERE idOE = ?");
		q.setResultClass(OrganizadorEventos_id.class);
		q.setParameters(idOE);
		return (OrganizadorEventos_id) q.executeUnique();
	}

	//
	public List<OrganizadorEventos_id> darUsuarios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darOrganizadorEventos_Id());
		q.setResultClass(OrganizadorEventos_id.class);
		return (List<OrganizadorEventos_id>) q.executeList();
	}

	
}
