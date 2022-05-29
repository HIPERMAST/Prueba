package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.PC_LargaEstadia;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLPC_LargaEstadia
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
	public SQLPC_LargaEstadia (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_LargaEstadia - El numero de documento del PC_LargaEstadia
	 * @param tipoDocumento - El tipo de documento
	 * @param correo - El correo del PC_LargaEstadia
	 * @param idLargaEstadia - El id del PC_LargaEstadia
	 * @param idLargaEstadia - El id del PC_LargaEstadia
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarPC_LargaEstadiaPorId (PersistenceManager pm, Integer idLargaEstadia, Integer descuentoAlojamiento) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darPC_LargaEstadia () + "(idLargaEstadia, descuentoAlojamiento) values (?, ?)");
        q.setParameters(idLargaEstadia, descuentoAlojamiento);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_LargaEstadia - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarPC_LargaEstadiaPorId (PersistenceManager pm, Integer idLargaEstadia)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darPC_LargaEstadia () + " WHERE idLargaEstadia = ?");
        q.setParameters(idLargaEstadia);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN PC_LargaEstadia de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroPC_LargaEstadia - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public PC_LargaEstadia darPC_LargaEstadiaPorId (PersistenceManager pm, Integer idLargaEstadia) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPC_LargaEstadia () + " WHERE idLargaEstadia = ?");
		q.setResultClass(PC_LargaEstadia.class);
		q.setParameters(idLargaEstadia);
		return (PC_LargaEstadia) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<PC_LargaEstadia> darPC_LargaEstadiaes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darPC_LargaEstadia ());
		q.setResultClass(PC_LargaEstadia.class);
		return (List<PC_LargaEstadia>) q.executeList();
	}

    //
	public Integer updateLargaEstadiaIdReserva (PersistenceManager pm, Integer idLargaEstadia, Integer idReserva) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darPC_LargaEstadia () + " SET reserva = ? WHERE idLargaEstadia = ?");
	     q.setParameters(idLargaEstadia, idReserva);
	     return (Integer) q.executeUnique();           
	}

    //
	public Integer updateLargaEstadiaNumeroHabitacion (PersistenceManager pm, Integer idLargaEstadia, Integer numeroHabitacion) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darPC_LargaEstadia () + " SET Habitacion = ? WHERE idLargaEstadia = ?");
	     q.setParameters(idLargaEstadia, numeroHabitacion);
	     return (Integer) q.executeUnique();           
	}

}
