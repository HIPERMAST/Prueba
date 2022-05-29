
package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los métodos get de CLIENTE.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOOrganizadorEventos
{
	public Long getIdOE();

	public String getTipoDocumento();

	public String getCorreoOE();

	public String getPwOE();

	@Override
	public String toString();

}
