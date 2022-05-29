package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Cuenta;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 */
class SQLCuenta
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el Cuenta de consulta que se va a realizar en las sentencias de acceso a la base de datos
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
	public SQLCuenta (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param numeroCuenta - El numero de documento del Cuenta
	 * @param CuentaDocumento - El Cuenta de documento
	 * @param correo - El correo del Cuenta
	 * @param idCuenta - El id del Cuenta
	 * @param idCuenta - El id del Cuenta
	 * @return El número de tuplas insertadas
	 */
	public Integer adicionarCuentaPorId (PersistenceManager pm, Integer idCuenta, Integer costoTotal) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darCuenta() + "(idCuenta, costoTotal) values (?, ?)");
        q.setParameters(idCuenta, costoTotal);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param numeroCuenta - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public Integer eliminarCuentaPorId (PersistenceManager pm, Integer idCuenta)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darCuenta () + " WHERE idCuenta = ?");
        q.setParameters(idCuenta);
        return (Integer) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN Cuenta de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param numeroCuenta - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
	public Cuenta darCuentaPorId (PersistenceManager pm, Integer idCuenta) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darCuenta () + " WHERE idCuenta = ?");
		q.setResultClass(Cuenta.class);
		q.setParameters(idCuenta);
		return (Cuenta) q.executeUnique();
	}

	//
	public List<Cuenta> darCuentas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darCuenta ());
		q.setResultClass(Cuenta.class);
		return (List<Cuenta>) q.executeList();
	}
	
}
