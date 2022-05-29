package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.S_PrestamoUtencilios;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto PrestamoUtencilios de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLS_PrestamoUtencilios
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el PrestamoUtencilios de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLS_PrestamoUtencilios (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un PrestamoUtencilios a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
     * @param idPrestamoUtencilios - El id del PrestamoUtencilios
	 * @param tipoUtencilios - El estilo del PrestamoUtencilios
	 * @param cantUtencilios - La capacidad del PrestamoUtencilios
	 * @param pagoCuenta - Un Boolean que dice si la cuenta se paga o se carga a la habitacion
	 * @param costoServicio - El costo de servicio
	 * @param idHotel - El id del Hotel
     * @param idCliente - El id del Cliente
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarPrestamoUtenciliosPorId (PersistenceManager pm, Integer idPrestamoUtencilios, String tipoUtencilios, Integer cantUtencilios, Boolean pagoCuenta, Integer costoServicio, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darS_Prestamoutencilios () + "(idPrestamoUtencilios, tipoUtencilios, cantUtencilios, pagoCuenta, costoServicio, idHotel) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idPrestamoUtencilios, tipoUtencilios, cantUtencilios, pagoCuenta, costoServicio, idHotel);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar PrestamoUtenciliosES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param idPrestamoUtencilios - El id del PrestamoUtencilios
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarPrestamoUtenciliosPorId (PersistenceManager pm, Integer idPrestamoUtencilios)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darS_Prestamoutencilios () + " WHERE id = ?");
        q.setParameters(idPrestamoUtencilios);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PrestamoUtencilios de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idPrestamoUtencilios - El id del PrestamoUtencilios
	 * @return El objeto PrestamoUtencilios que tiene el identificador dado
	 */
	public S_PrestamoUtencilios darPrestamoUtenciliosPorId (PersistenceManager pm, Integer idPrestamoUtencilios) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Prestamoutencilios () + " WHERE id = ?");
		q.setResultClass(S_PrestamoUtencilios.class);
		q.setParameters(idPrestamoUtencilios);
		return (S_PrestamoUtencilios) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS PrestamoUtenciliosES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos PrestamoUtencilios
	 */
	public List<S_PrestamoUtencilios> darPrestamoUtencilioss (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darS_Prestamoutencilios ());
		q.setResultClass(S_PrestamoUtencilios.class);
		return (List<S_PrestamoUtencilios>) q.executeList();
	}

	//
	public Long updatePrestamoUtenciliosIdCliente (PersistenceManager pm, Long idPrestamoUtencilios, Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darS_Prestamoutencilios () + " SET cliente = ? WHERE id = ?");
	     q.setParameters(idPrestamoUtencilios, idCliente);
	     return (Long) q.executeUnique();            
	}
	
}
