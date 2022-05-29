
package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los métodos get de CLIENTE.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOCliente
{

	public String getTipoDocumento();

	public Long getNumeroDocumentoCliente();

	public String getCorreoCliente();

	public int getIdHotel();

	public Integer getIdHabitacion();

	@Override
	public String toString();

}
