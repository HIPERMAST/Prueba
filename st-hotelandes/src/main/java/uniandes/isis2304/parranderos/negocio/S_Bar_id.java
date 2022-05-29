
package uniandes.isis2304.parranderos.negocio;

public class S_Bar_id implements VOS_Bar_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la pscina
	 */
	private Integer idBar;
	
	/**
	 * El nombre de el gimnasio
	 */
	private String nombreBar;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Bar_id() 
	{
		this.idBar = 0;
		this.nombreBar= "";
	}

	/**
	 * Constructor con valores
	 */
	public S_Bar_id(Integer idBar, String nombreBar) 
	{
		this.idBar = idBar;
		this.nombreBar = nombreBar;
	}

	//
	public Integer getIdBar() 
	{
		return idBar;
	}

	public void setIdBar(Integer idBar) 
	{
		this.idBar = idBar;
	}

	//
	public String getNombreBar() 
	{
		return nombreBar;
	}

	public void setNombreBar(String nombreBar) 
	{
		this.nombreBar = nombreBar;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "S_Bar_id [idBar =" + idBar + ", nombreBar =" + nombreBar + "]";
	}
}
