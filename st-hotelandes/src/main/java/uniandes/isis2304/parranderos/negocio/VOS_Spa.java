package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

public interface VOS_Spa
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	//
	public Integer getIdSPA();
	
	//
	public Timestamp getReserva();

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
