package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

public interface VOConvencion
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	public Long getIdConvencion();

	public Timestamp getCheckIn();
	
	public Timestamp getCheckOut();

	public Integer getCantPersonas();

	public Integer getIdPlanConsumo();

	@Override
	public String toString();

}
