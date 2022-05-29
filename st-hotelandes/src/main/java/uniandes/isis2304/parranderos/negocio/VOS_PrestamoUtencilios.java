package uniandes.isis2304.parranderos.negocio;

public interface VOS_PrestamoUtencilios
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	//
	public Integer getIdPrestamoUtencilios();
	
	//
	public String getTipoUtencilios();

	//
	public Integer getCantUtencilios();

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
