package uniandes.isis2304.parranderos.negocio;

public interface VOS_Gym
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	//
	public Integer getIdGYM();
	
	//
	public Integer getCantMaquinas();

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
