
package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los métodos get de 
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOOrganizadorEventos_id
{
	public Long getIdOE();

	public String getNombreOE();

	@Override
	public String toString();


}
