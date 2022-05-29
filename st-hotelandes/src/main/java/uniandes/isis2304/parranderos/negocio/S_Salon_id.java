package uniandes.isis2304.parranderos.negocio;

public class S_Salon_id implements VOS_Salon_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del salon
	 */
	private Integer idSalon;
	
	/**
	 * El nombre del salon
	 */
	private String nombreSalon;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Salon_id() 
	{
		this.idSalon = 0;
		this.nombreSalon= "";
	}

	/**
	 * Constructor con valores
	 */
	public S_Salon_id(Integer idSalon, String nombreSalon) 
	{
		this.idSalon = idSalon;
		this.nombreSalon = nombreSalon;
	}

	//
	public Integer getIdSalon() 
	{
		return idSalon;
	}

	public void setIdSalon(Integer idSalon) 
	{
		this.idSalon = idSalon;
	}

	//
	public String getNombreSalon() 
	{
		return nombreSalon;
	}

	public void setNombreSalon(String nombreSalon) 
	{
		this.nombreSalon = nombreSalon;
	}

	/** 
	 * @return Una cadena con la información básica de el Salon
	 */
	@Override
	public String toString() 
	{
		return "S_Piscina_id [idSalon =" + idSalon + ", nombreSalon =" + nombreSalon + "]";
	}
}
