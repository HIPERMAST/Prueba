package uniandes.isis2304.parranderos.negocio;

public interface VOS_Lavanderia
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	//
	public Integer getIdLavanderia();
	
	//
	public String getTipoLavanderia();

	//
	public Integer getCantPrendas();

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
