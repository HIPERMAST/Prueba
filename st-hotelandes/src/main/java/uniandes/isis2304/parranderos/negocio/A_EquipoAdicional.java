package uniandes.isis2304.parranderos.negocio;

public class A_EquipoAdicional implements VOA_EquipoAdicional
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El tipo de equipo
	 */
	private String tipoEquipo;

	/**
	 * El costo del equipo
	 */
	private Integer costo;

	/**
	 * El identificador el gym. Debe exixtir un gym con dicho identificador
	 */
	private Integer idGYM;
	


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public A_EquipoAdicional() 
	{
		this.tipoEquipo= "";
		this.costo = 0;
		this.idGYM = 0;
	}

	/**
	 * Constructor con valores
	 */
	public A_EquipoAdicional(String tipoEquipo, Integer costo, Integer idGYM) 
	{
		this.tipoEquipo = tipoEquipo;
		this.costo = costo;
		this.idGYM = idGYM;
	}

	//
	public String getTipoEquipo() 
	{
		return tipoEquipo;
	}

	public void setTipoEquipo(String tipoEquipo) 
	{
		this.tipoEquipo = tipoEquipo;
	}

	//
	public Integer getCosto() 
	{
		return costo;
	}

	public void setCosto(Integer costo) 
	{
		this.idGYM = costo;
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


	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "A_EquipoAdicional [idGYM =" + idGYM + ", tipoEquipo =" + tipoEquipo + "]";
	}
}
