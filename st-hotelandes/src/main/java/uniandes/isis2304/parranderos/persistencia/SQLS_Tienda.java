package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Tienda;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Tienda de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Tienda
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Tienda de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLS_Tienda (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	//
	public Integer adicionarTiendaPorId (PersistenceManager pm, Integer idTienda, Boolean pagoCuenta, Integer costoServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Tienda() + "(idTienda, pagoCuenta, costoServicio, idHotel) values (?, ?, ?, ?)");
        q.setParameters(idTienda, pagoCuenta, costoServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	//
	public Integer eliminarTiendaPorId (PersistenceManager pm, Integer idTienda)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Tienda() + " WHERE id = ?");
        q.setParameters(idTienda);
        return (Integer) q.executeUnique();
	}

	//
	public S_Tienda darTiendaPorId (PersistenceManager pm, Integer idTienda) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Tienda() + " WHERE id = ?");
		q.setResultClass(S_Tienda.class);
		q.setParameters(idTienda);
		return (S_Tienda) q.executeUnique();
	}

	//
	public List<S_Tienda> darTiendas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Tienda());
		q.setResultClass(S_Tienda.class);
		return (List<S_Tienda>) q.executeList();
	}

	
	//
	public Integer updateTiendaIdCliente (PersistenceManager pm, Integer idTienda,  Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darS_Tienda () + " SET reserva = ? WHERE id = ?");
	     q.setParameters(idTienda, idCliente);
	     return (Integer) q.executeUnique();            
	}
	
}
