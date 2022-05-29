package uniandes.isis2304.parranderos.negocio;

public class Tipo implements VOTipo
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Integer idTipo;
	
	//
	private String nombreTipo;
	
	//
	private String dotacion;
	
	//
	private Integer capacidad;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Tipo() 
	{
		this.idTipo = 0;
		this.nombreTipo = "";
		this.dotacion = "";
		this.capacidad = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Tipo(Integer idTipo, String nombreTipo, String dotacion, Integer capacidad) 
	{
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
		this.dotacion = dotacion;
		this.capacidad = capacidad;
	}

	//
	public Integer getIdTipo() 
	{
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) 
	{
		this.idTipo = idTipo;
	}

	//
	public String getNombreTipo() 
	{
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) 
	{
		this.nombreTipo = nombreTipo;
	}

	//
	public String getDotacion() 
	{
		return dotacion;
	}

	public void setDotacion(String dotacion) 
	{
		this.dotacion = dotacion;
	}

	//
	public Integer getCapacidad() 
	{
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) 
	{
		this.capacidad = capacidad;
	}

	/**
	 * @return Una cadena con la información básica de el tipo
	 */
	@Override
	public String toString() 
	{
		return "Tipo [idTipo=" + idTipo + ", nombreTipo =" + nombreTipo + ", dotacion =" + dotacion + ", capacidad =" + capacidad + "]";
	}

}
