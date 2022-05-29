package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Recepcionista;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLRecepcionista
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el IdRecepcionista de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLRecepcionista (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroIdRecepcionista - El numero de documento del IdRecepcionista
	 * @param IdRecepcionistaDocumento - El IdRecepcionista de documento
	 * @param correo - El correo del IdRecepcionista
	 * @param idIdRecepcionista - El id del IdRecepcionista
	 * @param idIdRecepcionista - El id del IdRecepcionista
	 * @return El número de tuplas insertadas
	 */
	public Long adicionarIdRecepcionistaPorId (PersistenceManager pm, Long idRecepcionista, String tipoDocumento, String correoRecepcionista, Integer idHotel) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darRecepcionista () + "(idRecepcionista, tipoDocumento, correoRecepcionista, idHotel) values (?, ?, ?, ?)");
        q.setParameters(idRecepcionista, tipoDocumento, correoRecepcionista, idHotel);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroIdRecepcionista - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Long eliminarRecepcionistaPorId (PersistenceManager pm, Long idRecepcionista)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darRecepcionista () + " WHERE id = ?");
        q.setParameters(idRecepcionista);
        return (Long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN IdRecepcionista de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroIdRecepcionista - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Recepcionista darRecepcionistaPorId (PersistenceManager pm, Long idRecepcionista) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darRecepcionista () + " WHERE id = ?");
		q.setResultClass(Recepcionista.class);
		q.setParameters(idRecepcionista);
		return (Recepcionista) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<Recepcionista> darRecepcionistas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darRecepcionista ());
		q.setResultClass(Recepcionista.class);
		return (List<Recepcionista>) q.executeList();
	}

    //
	public Long updateRecepcionistaIdCliente (PersistenceManager pm, Long idRecepcionista, Long idCliente) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darRecepcionista () + " SET idCliente = ? WHERE idRecepcionista = ?");
	     q.setParameters(idCliente, idRecepcionista);
	     return (Long) q.executeUnique();            
	}

	//
	public Long updateRecepcionistaIdReserva (PersistenceManager pm, Long idRecepcionista, Long idReserva) 
	{
		 Query q = pm.newQuery(SQL, "UPDATE " + pp.darRecepcionista () + " SET idreserva = ? WHERE idRecepcionista = ?");
	     q.setParameters(idReserva, idRecepcionista);
	     return (Long) q.executeUnique();            
	}
	
}
