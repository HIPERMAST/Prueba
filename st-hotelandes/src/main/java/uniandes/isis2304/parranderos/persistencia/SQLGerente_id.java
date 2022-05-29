package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Gerente_id;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLGerente_id
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
	public SQLGerente_id (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param id - El numero de documento del Gerente
	 * @param nombre - El nombre del Gerente
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarGerentePorId (PersistenceManager pm, Long idGerente, String nombreGerente) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darGerente_id () + "(idGerente, nombreGerente) values (?, ?)");
        q.setParameters(idGerente, nombreGerente);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idGerente - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarGerentePorId (PersistenceManager pm, Long idGerente)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darGerente_id () + " WHERE idGerente = ?");
        q.setParameters(idGerente);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Gerente de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idGerente - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Gerente_id darGerentePorId (PersistenceManager pm, Long idGerente) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darGerente_id () + " WHERE idGerente = ?");
		q.setResultClass(Gerente_id.class);
		q.setParameters(idGerente);
		return (Gerente_id) q.executeUnique();
	}

	//
	public List<Gerente_id> darGerentes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darGerente_id ());
		q.setResultClass(Gerente_id.class);
		return (List<Gerente_id>) q.executeList();
	}

	
}
