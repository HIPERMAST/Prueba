package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;


public class Convencion implements VOConvencion
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Long idConvencion;
	
	//
	private Timestamp checkIn;
	
	//
	private Timestamp checkOut;
		
	//
	private Integer cantPersonas;

	//Debe exixtir un Plan de Consumo con dicho identificador
	private Integer idPlanConsumo;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Convencion() 
	{
		this.idConvencion = 0L;
		this.checkIn = new Timestamp (0);
		this.checkOut = new Timestamp (0);
		this.cantPersonas = 0;
		this.idPlanConsumo = 0;
		
	}

	/**
	 * Constructor con valores
	 */
	public Convencion(Long idConvencion, Timestamp checkIn, Timestamp checkOut, Integer cantPersonas, Integer idPlanConsumo) 
	{
		this.idConvencion = idConvencion;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.cantPersonas = cantPersonas;
		this.idPlanConsumo = idPlanConsumo;
	}

	//
	public Long getIdConvencion() 
	{
		return idConvencion;
	}

	public void setIdConvencion(Long idConvencion) 
	{
		this.idConvencion = idConvencion;
	}

	//
	public Timestamp getCheckIn() 
	{
		return checkIn;
	}

	public void setCheckIn(Timestamp checkIn) 
	{
		this.checkIn = checkIn;
	}

	//
	public Timestamp getCheckOut() 
	{
		return checkOut;
	}

	public void setCheckOut(Timestamp checkOut) 
	{
		this.checkOut = checkOut;
	}
	
	//
	public Integer getCantPersonas() 
	{
		return cantPersonas;
	}

	public void setCantPersonas(Integer cantPersonas) 
	{
		this.cantPersonas = cantPersonas;
	}

	//
	public Integer getIdPlanConsumo() 
	{
		return idPlanConsumo;
	}

	public void setIdPlanConsumo(Integer idPlanConsumo) 
	{
		this.idPlanConsumo = idPlanConsumo;
	}

	/** 
	 * @return Una cadena con la información básica de la Convencion
	 */
	@Override
	public String toString() 
	{
		return "Convencion [idConvencion =" + idConvencion + ", cantPersonas =" + cantPersonas + ", checkIn =" + checkIn + ", checkOut ="
				+ checkOut + ", idPlanConsumo = " + idPlanConsumo + "]";
	}
}
