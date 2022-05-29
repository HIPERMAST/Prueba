
package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los métodos get de HABITACION
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOHabitacion 
{
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    
	public Long getNumeroHabitacion();

	public Integer getCostoHabitacion();

	public Integer getIdTipo();

	public Integer getIdHotel(); 

	public Integer getIdReserva();

	public Integer getIdCuenta();

	@Override
	public String toString();

}
