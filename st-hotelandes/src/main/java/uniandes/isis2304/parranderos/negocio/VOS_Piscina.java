package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

public interface VOS_Piscina
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	//
	public Integer getIdPiscina();
	
	//
	public Integer getProfundidad();
	
	//
	public Timestamp getHorarioInicial();
	
	//
	public Timestamp getHorarioFinal();

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
