package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Tipo;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLTipo
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
	public SQLTipo (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 */
	public Integer adicionarTipoPorId (PersistenceManager pm, Integer idTipo, String nombreTipo, String dotacion, Integer capacidad) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTipo () + "(idTipo, nombreTipo, dotacion, capacidad) values (?, ?, ?, ?)");
        q.setParameters(idTipo, nombreTipo, dotacion, capacidad);
        return (Integer) q.executeUnique();
	}

	/*
	 */
	public Integer eliminarTipoPorId (PersistenceManager pm, Integer idTipo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTipo () + " WHERE id = ?");
        q.setParameters(idTipo);
        return (Integer) q.executeUnique();
	}

	/*
	 */
	public Tipo darTipoPorId (PersistenceManager pm, Integer idTipo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTipo () + " WHERE id = ?");
		q.setResultClass(Tipo.class);
		q.setParameters(idTipo);
		return (Tipo) q.executeUnique();
	}


		/*
	 */
	public Tipo darIdTipoPorNombre (PersistenceManager pm, String nombreTipo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTipo () + " WHERE nombreTipo = ?");
		q.setResultClass(Tipo.class);
		q.setParameters(nombreTipo);
		return (Tipo) q.executeUnique();
	}


	/**/
	public List<Tipo> darTipos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTipo ());
		q.setResultClass(Tipo.class);
		return (List<Tipo>) q.executeList();
	}
	
}
