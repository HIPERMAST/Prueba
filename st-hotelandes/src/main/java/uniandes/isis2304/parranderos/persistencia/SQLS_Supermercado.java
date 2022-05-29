package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Supermercado;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Supermercado de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Supermercado
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Supermercado de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLS_Supermercado (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	//
	public Integer adicionarSupermercadoPorId (PersistenceManager pm, Integer idSupermercado, Boolean pagoCuenta, Integer costoServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Supermercado() + "(idSupermercado, pagoCuenta, costoServicio, idHotel) values (?, ?, ?, ?)");
        q.setParameters(idSupermercado, pagoCuenta, costoServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	//
	public Integer eliminarSupermercadoPorId (PersistenceManager pm, Integer idSupermercado)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Supermercado() + " WHERE id = ?");
        q.setParameters(idSupermercado);
        return (Integer) q.executeUnique();
	}

	//
	public S_Supermercado darSupermercadoPorId (PersistenceManager pm, Integer idSupermercado) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Supermercado() + " WHERE id = ?");
		q.setResultClass(S_Supermercado.class);
		q.setParameters(idSupermercado);
		return (S_Supermercado) q.executeUnique();
	}

	//
	public List<S_Supermercado> darSupermercados (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Supermercado());
		q.setResultClass(S_Supermercado.class);
		return (List<S_Supermercado>) q.executeList();
	}

		
	//
	public Integer updateSupermercadoIdCliente (PersistenceManager pm, Integer idSupermercado,  Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darS_Supermercado () + " SET reserva = ? WHERE id = ?");
	     q.setParameters(idSupermercado, idCliente);
	     return (Integer) q.executeUnique();            
	}
	
}
