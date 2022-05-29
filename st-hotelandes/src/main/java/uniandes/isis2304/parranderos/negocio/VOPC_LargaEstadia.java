package uniandes.isis2304.parranderos.negocio;

public interface VOPC_LargaEstadia
{
	public Integer getIdLargaEstadia();

	public Integer getIdReserva();

	public Integer getDescuentoAlojamiento();

	public Integer getNumeroHabitacion();

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
