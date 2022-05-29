
package uniandes.isis2304.parranderos.negocio;

public class S_Spa_id implements VOS_Spa_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del SPA
	 */
	private Integer idSPA;
	
	/**
	 * El nombre del SPA
	 */
	private String nombreSPA;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Spa_id() 
	{
		this.idSPA = 0;
		this.nombreSPA= "";
	}

	/**
	 * Constructor con valores
	 */
	public S_Spa_id(Integer idSPA, String nombreSPA) 
	{
		this.idSPA = idSPA;
		this.nombreSPA = nombreSPA;
	}

	//
	public Integer getIdSPA() 
	{
		return idSPA;
	}

	public void setIdSPA(Integer idSPA) 
	{
		this.idSPA = idSPA;
	}

	//
	public String getNombreSPA() 
	{
		return nombreSPA;
	}

	public void setNombreSPA(String nombreSPA) 
	{
		this.nombreSPA = nombreSPA;
	}

	/** 
	 * @return Una cadena con la información básica de la red de SPA
	 */
	@Override
	public String toString() 
	{
		return "S_SPA_id [idSPA =" + idSPA + ", nombreSPA =" + nombreSPA + "]";
	}
}
