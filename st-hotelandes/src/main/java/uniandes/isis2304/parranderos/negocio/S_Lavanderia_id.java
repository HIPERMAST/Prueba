
package uniandes.isis2304.parranderos.negocio;

public class S_Lavanderia_id implements VOS_Lavanderia_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la pscina
	 */
	private Integer idLavanderia;
	
	/**
	 * El nombre de el gimnasio
	 */
	private String nombreLavanderia;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Lavanderia_id() 
	{
		this.idLavanderia = 0;
		this.nombreLavanderia= "";
	}

	/**
	 * Constructor con valores
	 */
	public S_Lavanderia_id(Integer idLavanderia, String nombreLavanderia) 
	{
		this.idLavanderia = idLavanderia;
		this.nombreLavanderia = nombreLavanderia;
	}

	//
	public Integer getIdLavanderia() 
	{
		return idLavanderia;
	}

	public void setIdLavanderia(Integer idLavanderia) 
	{
		this.idLavanderia = idLavanderia;
	}

	//
	public String getNombreLavanderia() 
	{
		return nombreLavanderia;
	}

	public void setNombreLavanderia(String nombreLavanderia) 
	{
		this.nombreLavanderia = nombreLavanderia;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "S_Lavanderia_id [idLavanderia =" + idLavanderia + ", nombreLavanderia =" + nombreLavanderia + "]";
	}
}
