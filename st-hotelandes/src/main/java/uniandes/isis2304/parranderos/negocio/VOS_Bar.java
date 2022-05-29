package uniandes.isis2304.parranderos.negocio;

public interface VOS_Bar
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	//
	public Integer getIdBar();
	
	//
	public String getEstiloBar();

	//
	public Integer getCapacidad();

	//
	public Boolean getPagoCuenta();

	//
	public Integer getCostoServicio();

	//
	public Integer getIdHotel();
	
	//
	public Long getIdCliente();

	@Override
	public String toString();

}
