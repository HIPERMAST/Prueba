
package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los métodos get de CLIENTE.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOAdministradorDatos
{
	public Long getNumeroDocumento();

	public String getTipoDocumento();

	public String getCorreo();
	
	public String getPw();

	public Integer getIdHotel();

	public Long getIdUsuario();	

	@Override
	public String toString();

}
