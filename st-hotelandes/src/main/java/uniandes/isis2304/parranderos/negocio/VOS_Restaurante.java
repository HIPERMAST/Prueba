
package uniandes.isis2304.parranderos.negocio;

public interface VOS_Restaurante
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	//
	public Integer getIdRestaurante();
	
	//
	public String getEstiloRestaurante();

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
