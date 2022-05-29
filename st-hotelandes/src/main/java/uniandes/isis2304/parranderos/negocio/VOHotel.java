

package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los métodos get de HOTEL.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 */
public interface VOHotel
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	public Integer getIdHotel();

	/**
	 * @return El idHotel
	 */
	public String getNombre();
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();
	
}
