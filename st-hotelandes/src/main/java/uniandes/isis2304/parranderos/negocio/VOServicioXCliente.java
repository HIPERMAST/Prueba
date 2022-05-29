
package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

/**
 * Interfaz para los métodos get de CLIENTE.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOServicioXCliente
{
	//Historial
	public Integer getHistorial();
	
	public Timestamp getFecha();

	public Long getIdCliente();

	public Integer getIdServicio(); 
	
	public Integer getIdEspecifico(); 
	
	public Integer getCantVisitas(); 
	
	public Integer getCosto();

	@Override
	public String toString();

}
