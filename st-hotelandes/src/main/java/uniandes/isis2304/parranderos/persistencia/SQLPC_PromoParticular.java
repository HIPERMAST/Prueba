package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.PC_PromoParticular;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLPC_PromoParticular
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
	public SQLPC_PromoParticular (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_PromoParticular - El numero de documento del PC_PromoParticular
	 * @param tipoDocumento - El tipo de documento
	 * @param correo - El correo del PC_PromoParticular
	 * @param idPromoPar - El id del PC_PromoParticular
	 * @param idPromoPar - El id del PC_PromoParticular
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarPC_PromoParticularPorId (PersistenceManager pm, Integer idPromoPar, Integer descuentoReserva) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darPC_PromoParticular () + "(idPromoPar, descuentoReserva) values (?, ?)");
        q.setParameters(idPromoPar, descuentoReserva);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_PromoParticular - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarPC_PromoParticularPorId (PersistenceManager pm, Integer idPromoPar)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darPC_PromoParticular () + " WHERE idPromoPar = ?");
        q.setParameters(idPromoPar);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PC_PromoParticular de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_PromoParticular - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public PC_PromoParticular darPC_PromoParticularPorId (PersistenceManager pm, Integer idPromoPar) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPC_PromoParticular () + " WHERE idPromoPar = ?");
		q.setResultClass(PC_PromoParticular.class);
		q.setParameters(idPromoPar);
		return (PC_PromoParticular) q.executeUnique();
	}

	//
	public List<PC_PromoParticular> darPC_PromoParticulares (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPC_PromoParticular ());
		q.setResultClass(PC_PromoParticular.class);
		return (List<PC_PromoParticular>) q.executeList();
	}

    //
	public Integer updatePromoParticularIdReserva (PersistenceManager pm, Integer idPromoPar, Integer idReserva) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darPC_PromoParticular () + " SET reserva = ? WHERE idPromoPar = ?");
	     q.setParameters(idPromoPar, idReserva);
	     return (Integer) q.executeUnique();           
	}

}
