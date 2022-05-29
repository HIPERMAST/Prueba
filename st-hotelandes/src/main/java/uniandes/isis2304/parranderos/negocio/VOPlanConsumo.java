package uniandes.isis2304.parranderos.negocio;

public interface VOPlanConsumo 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	public Integer getIdPlanConsumo();
	
	/**
	 * El identificador de la bebida que es servida en el bar
	 */
	public Integer getIdHotel();
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
