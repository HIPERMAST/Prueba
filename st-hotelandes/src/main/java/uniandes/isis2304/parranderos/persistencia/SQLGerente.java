package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Gerente;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLGerente
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Gerente de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLGerente (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroGerente - El numero de documento del Gerente
	 * @param GerenteDocumento - El Gerente de documento
	 * @param correo - El correo del Gerente
	 * @param idGerente - El id del Gerente
	 * @param idGerente - El id del Gerente
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarGerentePorId (PersistenceManager pm, Long idGerente, String tipoDocumento, String correoGerente, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darGerente () + "(idGerente, tipoDocumento, correoGerente, idHotel) values (?, ?, ?, ?, ?)");
        q.setParameters(idGerente, tipoDocumento, correoGerente, idHotel);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroGerente - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarGerentePorId (PersistenceManager pm, Long idGerente)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darGerente () + " WHERE idGerente = ?");
        q.setParameters(idGerente);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Gerente de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroGerente - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Gerente darGerentePorId (PersistenceManager pm, Long idGerente) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darGerente () + " WHERE idGerente = ?");
		q.setResultClass(Gerente.class);
		q.setParameters(idGerente);
		return (Gerente) q.executeUnique();
	}

	//
	public List<Gerente> darGerentes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darGerente ());
		q.setResultClass(Gerente.class);
		return (List<Gerente>) q.executeList();
	}

	public List<Object> indiceDeOcupacionHabitaciones (PersistenceManager pm)
	{
		String sql = " SELECT ";
		sql += pp.darHabitacion() + ".numerohabitacion, ";
		sql += pp.darHabitacion() + ".ocupacionTotal AS ocupacion";
		sql += " FROM " + pp.darHabitacion();
		Query q = pm.newQuery(SQL, sql);
		return q.executeList();
	}


	public List<Object> mostrarConsumoCliente (PersistenceManager pm)
	{
		String sql = " SELECT " + pp.darServicioXCliente() + ".idCliente, ";
		sql += " SUM(" + pp.darServicioXCliente() + ".costo) AS costo";
		sql += " FROM " + pp.darServicioXCliente();
		sql += " WHERE " + pp.darServicioXCliente() + ".fecha >= '02-DEC-2018' ";
		sql += "AND " + pp.darServicioXCliente() + ".fecha <= '02-DEC-2023'";
		sql += " GROUP BY " + pp.darServicioXCliente() + ".idCliente";
		Query q = pm.newQuery(SQL, sql);
		return q.executeList();

	}


}
