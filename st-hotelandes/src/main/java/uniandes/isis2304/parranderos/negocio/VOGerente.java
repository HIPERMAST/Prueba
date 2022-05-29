
package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los métodos get de CLIENTE.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOGerente
{
	public Long getIdGerente();

	public String getTipoDocumento();

	public String getCorreoGerente();

	public int getIdHotel();

	@Override
	public String toString();

}
