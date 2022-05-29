package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

public interface VOReserva
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	public Long getIdReserva();
	
	public Integer getCantPersonas();
	
	public Timestamp getCheckIn();
	
	public Timestamp getCheckOut();

	public Integer getIdPlanConsumo();

	@Override
	public String toString();

}
