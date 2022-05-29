package uniandes.isis2304.parranderos.persistencia;

import java.util.List;
import java.sql.Timestamp;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Spa;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Spa de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Spa
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Spa de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLS_Spa (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	//
	public Integer adicionarSpaPorId (PersistenceManager pm, Integer idSPA, Timestamp reserva, Boolean pagoCuenta, Integer costoServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Spa() + "(idSPA, reserva, pagoCuenta, costoServicio, idHotel) values (?, ?, ?, ?, ?)");
        q.setParameters(idSPA, reserva, pagoCuenta, costoServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	//
	public Integer eliminarSpaPorId (PersistenceManager pm, Integer idSpa)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Spa() + " WHERE id = ?");
        q.setParameters(idSpa);
        return (Integer) q.executeUnique();
	}

	//
	public S_Spa darSpaPorId (PersistenceManager pm, Integer idSpa) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Spa() + " WHERE id = ?");
		q.setResultClass(S_Spa.class);
		q.setParameters(idSpa);
		return (S_Spa) q.executeUnique();
	}

	//
	public List<S_Spa> darSpas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Spa());
		q.setResultClass(S_Spa.class);
		return (List<S_Spa>) q.executeList();
	}

	//
	public Integer updateSpaReserva (PersistenceManager pm, Integer idSpa,  Integer reserva) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darS_Spa () + " SET reserva = ? WHERE id = ?");
	     q.setParameters(idSpa, reserva);
	     return (Integer) q.executeUnique();            
	}
	
}
