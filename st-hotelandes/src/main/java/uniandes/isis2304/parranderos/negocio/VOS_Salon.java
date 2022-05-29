package uniandes.isis2304.parranderos.negocio;

public interface VOS_Salon
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	//
	public Integer getIdSalon();
	
	//
	public Integer getReserva();
	
	//
	public String getTipoSalon();
	
	//
	public String getTiempoLimpieza();

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
