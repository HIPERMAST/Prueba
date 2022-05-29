package uniandes.isis2304.parranderos.negocio;

public interface VOPC_PromoParticular
{
	public Integer getIdPromopar();

	public Integer getIdReserva();

	public Integer getDescuentoReserva();
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
