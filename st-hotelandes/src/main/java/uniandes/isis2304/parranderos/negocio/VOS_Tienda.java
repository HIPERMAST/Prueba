package uniandes.isis2304.parranderos.negocio;

public interface VOS_Tienda
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	//
	public Integer getIdTienda();
	
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
