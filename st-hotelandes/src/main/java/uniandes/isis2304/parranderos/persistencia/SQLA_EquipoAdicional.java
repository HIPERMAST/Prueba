package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.A_EquipoAdicional;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLA_EquipoAdicional
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el A_EquipoAdicional de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLA_EquipoAdicional (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	//
	public String adicionarA_EquipoAdicionalPorId (PersistenceManager pm, String tipoEquipo, Integer costo, Integer idGYM) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darA_equipoadicional() + "(tipoEquipo, costo , idGYM) values (?, ?, ?, ?, ?)");
        q.setParameters(tipoEquipo, costo , idGYM);
        return (String) q.executeUnique();
	}

	//
	public String eliminarA_EquipoAdicionalPorId (PersistenceManager pm, Integer tipoEquipo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darA_equipoadicional () + " WHERE tipoequipo = ?");
        q.setParameters(tipoEquipo);
        return (String) q.executeUnique();
	}

	//
	public A_EquipoAdicional darA_EquipoAdicionalPorId (PersistenceManager pm, Integer tipoEquipo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darA_equipoadicional () + " WHERE tipoequipo = ?");
		q.setResultClass(A_EquipoAdicional.class);
		q.setParameters(tipoEquipo);
		return (A_EquipoAdicional) q.executeUnique();
	}

	//
	public List<A_EquipoAdicional> darA_EquipoAdicionals (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darA_equipoadicional ());
		q.setResultClass(A_EquipoAdicional.class);
		return (List<A_EquipoAdicional>) q.executeList();
	}
	
}
