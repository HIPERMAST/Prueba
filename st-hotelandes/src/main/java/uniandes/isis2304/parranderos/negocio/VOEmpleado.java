
package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los métodos get de CLIENTE.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOEmpleado
{

	public Long getIdEmpleado();

	public String getTipoDocumento();

	public String getCorreoEmpleado();

	public Integer getNumeroHabitacion();

	public Long getIdCliente();

	public int getIdHotel();

	@Override
	public String toString();

}
