package uniandes.isis2304.parranderos.negocio;

public class PlanConsumo implements VOPlanConsumo
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del plan consumo
	 */
	private Integer idPlanConsumo;
	
	/**
	 * El identificador del hotel
	 */
	private Integer idHotel;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public PlanConsumo() 
	{
		this.idPlanConsumo = 0;
		this.idHotel = 0;
	}

	/**
	 * Constructor con valores
	 */
	public PlanConsumo(Integer idPlanConsumo, Integer idHotel) 
	{
		this.idPlanConsumo = idPlanConsumo;
		this.idHotel = idHotel;
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

	//
	public Integer getIdHotel() 
	{
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) 
	{
		this.idHotel = idHotel;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "PlanConsumo [idPlanConsumo =" + idPlanConsumo + ", idHotel =" + idHotel + "]";
	}
}
