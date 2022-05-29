
package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los métodos get de CLIENTE.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VORecepcionista
{

	public Long getIdRecepcionista();

	public String getTipoDocumento();

	public String getCorreoRecepcionista();

	public Integer getIdReserva();

	public Integer getIdCliente();

	public Integer getIdHotel();

	@Override
	public String toString();

}
