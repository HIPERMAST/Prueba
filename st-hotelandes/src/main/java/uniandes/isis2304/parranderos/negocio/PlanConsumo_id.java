package uniandes.isis2304.parranderos.negocio;

public class PlanConsumo_id implements VOPlanConsumo_id
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
	private String nombrePlanConsumo;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public PlanConsumo_id() 
	{
		this.idPlanConsumo = 0;
		this.nombrePlanConsumo = "";
	}

	/**
	 * Constructor con valores
	 */
	public PlanConsumo_id(Integer idPlanConsumo, String nombrePlanConsumo) 
	{
		this.idPlanConsumo = idPlanConsumo;
		this.nombrePlanConsumo = nombrePlanConsumo;
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
	public String getNombrePlanConsumo() 
	{
		return nombrePlanConsumo;
	}

	public void setNombrePlanConsumo(String nombrePlanConsumo) 
	{
		this.nombrePlanConsumo = nombrePlanConsumo;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "PlanConsumo_id [idPlanConsumo =" + idPlanConsumo + ", nombrePlanConsumo =" + nombrePlanConsumo + "]";
	}
}
