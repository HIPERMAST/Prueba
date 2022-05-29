package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.OrganizadorEventos;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLOrganizadorEventos
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
	public SQLOrganizadorEventos (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idOE - El numero de documento del Organizador
	 * @param tipoDocumento - El tipo de documento
	 * @param correoOE - El correoOE del Organizador
	 * @param pwOE - La contraseña del Organizador
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarOrganizadorPorId (PersistenceManager pm, Long idOE, String tipoDocumento, String correoOE, String pwOE) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darOrganizadorEventos() + "(idOE, tipoDocumento, correoOE, pwOE) values (?, ?, ?, ?)");
        q.setParameters(idOE, tipoDocumento, correoOE, pwOE);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idOE - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarOrganizadorPorId (PersistenceManager pm, Long idOE)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darOrganizadorEventos() + " WHERE idOE = ?");
        q.setParameters(idOE);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Organizador de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idOE - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public OrganizadorEventos darOrganizadorPorId (PersistenceManager pm, Long idOE) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darOrganizadorEventos()+ " WHERE idOE = ?");
		q.setResultClass(OrganizadorEventos.class);
		q.setParameters(idOE);
		return (OrganizadorEventos) q.executeUnique();
	}

		//
		public OrganizadorEventos darOEPorConvencion (PersistenceManager pm, Long idConvencion)
		{
			Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darOrganizadorEventos()+ " WHERE idConvencion = ?");
			q.setResultClass(OrganizadorEventos.class);
			q.setParameters(idConvencion);
			return (OrganizadorEventos) q.executeUnique();
		}

	//
	public List<OrganizadorEventos> darOrganizadors (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darOrganizadorEventos());
		q.setResultClass(OrganizadorEventos.class);
		return (List<OrganizadorEventos>) q.executeList();
	}

	//
    public Long updateOEIdConvencion(PersistenceManager pm, Long idConvencion, Long idOE) 
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darOrganizadorEventos() + " SET idConvencion = ? WHERE idOE = ?");
		q.setParameters(idConvencion, idOE);
		return (Long) q.executeUnique();            
	}

	//
    public Long updateIEIdReserva(PersistenceManager pm, Long idReserva, Long idOE)
	{
		Query q = pm.newQuery(SQL, "UPDATE " + pp.darOrganizadorEventos() + " SET idReserva = ? WHERE idOE = ?");
		q.setParameters(idReserva, idOE);
		return (Long) q.executeUnique();            
   }

	
}
