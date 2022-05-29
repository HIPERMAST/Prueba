package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.A_ServiciosSpa;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLA_ServiciosSpa
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el A_ServiciosSpa de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLA_ServiciosSpa (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	//
	public String adicionarServiciosSpaPorId (PersistenceManager pm, String nombre, Integer idSpa, Integer duracion, Integer costo) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darA_serviciosspa() + "(nombre, idSpa, duracion, costo) values (?, ?, ?, ?, ?)");
        q.setParameters(nombre, idSpa, duracion, costo);
        return (String) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroA_ServiciosSpa - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public String eliminarServiciosSpaPorId (PersistenceManager pm, Integer idSpa)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darA_serviciosspa () + " WHERE idspa = ?");
        q.setParameters(idSpa);
        return (String) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN A_ServiciosSpa de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroA_ServiciosSpa - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public A_ServiciosSpa darServiciosSpaPorId (PersistenceManager pm, Integer idSpa) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darA_serviciosspa() + " WHERE idspa = ?");
		q.setResultClass(A_ServiciosSpa.class);
		q.setParameters(idSpa);
		return (A_ServiciosSpa) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<A_ServiciosSpa> darServiciosSpas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darA_serviciosspa ());
		q.setResultClass(A_ServiciosSpa.class);
		return (List<A_ServiciosSpa>) q.executeList();
	}
	
}
