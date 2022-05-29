
package uniandes.isis2304.parranderos.negocio;

public class S_Internet_id implements VOS_Internet_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del internet
	 */
	private Integer idInternet;
	
	/**
	 * El nombre del internet
	 */
	private String nombreInternet;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Internet_id() 
	{
		this.idInternet = 0;
		this.nombreInternet= "";
	}

	/**
	 * Constructor con valores
	 */
	public S_Internet_id(Integer idInternet, String nombreInternet) 
	{
		this.idInternet = idInternet;
		this.nombreInternet = nombreInternet;
	}

	//
	public Integer getIdInternet() 
	{
		return idInternet;
	}

	public void setIdInternet(Integer idInternet) 
	{
		this.idInternet = idInternet;
	}

	//
	public String getNombreInternet() 
	{
		return nombreInternet;
	}

	public void setNombreInternet(String nombreInternet) 
	{
		this.nombreInternet = nombreInternet;
	}

	/** 
	 * @return Una cadena con la información básica de la red de internet
	 */
	@Override
	public String toString() 
	{
		return "S_Internet_id [idInternet =" + idInternet + ", nombreInternet =" + nombreInternet + "]";
	}
}
