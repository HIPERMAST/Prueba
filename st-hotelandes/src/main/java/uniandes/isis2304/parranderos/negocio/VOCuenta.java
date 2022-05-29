package uniandes.isis2304.parranderos.negocio;


public interface VOCuenta 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	public Integer getIdCuenta(); 

	public Integer getCostoTotal();

	@Override
	public String toString(); 
}
