package uniandes.isis2304.parranderos.negocio;

public class S_Piscina_id implements VOS_Piscina_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la pscina
	 */
	private Integer idPiscina;
	
	/**
	 * El nombre de la piscina
	 */
	private String nombrePiscina;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Piscina_id() 
	{
		this.idPiscina = 0;
		this.nombrePiscina= "";
	}

	/**
	 * Constructor con valores
	 */
	public S_Piscina_id(Integer idPiscina, String nombrePiscina) 
	{
		this.idPiscina = idPiscina;
		this.nombrePiscina = nombrePiscina;
	}

	//
	public Integer getIdPiscina() 
	{
		return idPiscina;
	}

	public void setIdPiscina(Integer idPiscina) 
	{
		this.idPiscina = idPiscina;
	}

	//
	public String getNombrePiscina() 
	{
		return nombrePiscina;
	}

	public void setNombrePiscina(String nombrePiscina) 
	{
		this.nombrePiscina = nombrePiscina;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "S_Piscina_id [idPiscina =" + idPiscina + ", nombrePiscina =" + nombrePiscina + "]";
	}
}
