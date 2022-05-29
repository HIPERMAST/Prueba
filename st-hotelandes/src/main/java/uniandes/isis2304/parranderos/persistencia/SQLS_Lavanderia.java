package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_Lavanderia;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto Lavanderia de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_Lavanderia
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Lavanderia de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLS_Lavanderia (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un Lavanderia a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
     * @param idLavanderia - El id del Lavanderia
	 * @param tipoLavanderia - El estilo del Lavanderia
	 * @param capacidad - La capacidad del Lavanderia
	 * @param pagoCuenta - Un Boolean que dice si la cuenta se paga o se carga a la habitacion
	 * @param costoServicio - El costo de servicio
	 * @param idHotel - El id del Hotel
     * @param idCliente - El id del Cliente
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarLavanderiaPorId (PersistenceManager pm, Integer idLavanderia, String tipoLavanderia, Integer cantPrendas, Boolean pagoCuenta, Integer costoServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Lavanderia () + "(idLavanderia, tipoLavanderia, cantPrendas, pagoCuenta, costoServicio, idHotel) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idLavanderia, tipoLavanderia, cantPrendas, pagoCuenta, costoServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar LavanderiaES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idLavanderia - El id del Lavanderia
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarLavanderiaPorId (PersistenceManager pm, Integer idLavanderia)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Lavanderia () + " WHERE id = ?");
        q.setParameters(idLavanderia);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Lavanderia de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idLavanderia - El id del Lavanderia
	 * @return El objeto Lavanderia que tiene el identificador dado
	 */
	public S_Lavanderia darLavanderiaPorId (PersistenceManager pm, Integer idLavanderia) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Lavanderia () + " WHERE id = ?");
		q.setResultClass(S_Lavanderia.class);
		q.setParameters(idLavanderia);
		return (S_Lavanderia) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS LavanderiaES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos Lavanderia
	 */
	public List<S_Lavanderia> darLavanderias (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Lavanderia ());
		q.setResultClass(S_Lavanderia.class);
		return (List<S_Lavanderia>) q.executeList();
	}

	//
	public Long updateLavanderiaIdCliente (PersistenceManager pm, Long idLavanderia, Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darS_Lavanderia () + " SET cliente = ? WHERE id = ?");
	     q.setParameters(idLavanderia, idCliente);
	     return (Long) q.executeUnique();            
	}
	
}
