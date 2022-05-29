package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

public interface VOA_ServiciosSpa
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	//
	public Integer getIdSpa();
	
	//
	public String getNombre();

	//
	public Timestamp getDuracion();

	//
	public Integer getCosto();

	@Override
	public String toString();

}
