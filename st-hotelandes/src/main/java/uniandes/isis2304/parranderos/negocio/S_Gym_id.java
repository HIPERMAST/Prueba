package uniandes.isis2304.parranderos.negocio;

public class S_Gym_id implements VOS_Gym_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la pscina
	 */
	private Integer idGYM;
	
	/**
	 * El nombre de el gimnasio
	 */
	private String nombreGYM;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Gym_id() 
	{
		this.idGYM = 0;
		this.nombreGYM= "";
	}

	/**
	 * Constructor con valores
	 */
	public S_Gym_id(Integer idGYM, String nombreGYM) 
	{
		this.idGYM = idGYM;
		this.nombreGYM = nombreGYM;
	}

	//
	public Integer getIdGYM() 
	{
		return idGYM;
	}

	public void setIdGYM(Integer idGYM) 
	{
		this.idGYM = idGYM;
	}

	//
	public String getNombreGYM() 
	{
		return nombreGYM;
	}

	public void setNombreGYM(String nombreGYM) 
	{
		this.nombreGYM = nombreGYM;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "S_Gym_id [idGYM =" + idGYM + ", nombreGYM =" + nombreGYM + "]";
	}
}
