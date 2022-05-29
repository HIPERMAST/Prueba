
package uniandes.isis2304.parranderos.negocio;

public class S_Supermercado_id implements VOS_Supermercado_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del Supermercado
	 */
	private Integer idSupermercado;
	
	/**
	 * El nombre del Supermercado
	 */
	private String nombreSupermercado;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Supermercado_id() 
	{
		this.idSupermercado = 0;
		this.nombreSupermercado= "";
	}

	/**
	 * Constructor con valores
	 */
	public S_Supermercado_id(Integer idSupermercado, String nombreSupermercado) 
	{
		this.idSupermercado = idSupermercado;
		this.nombreSupermercado = nombreSupermercado;
	}

	//
	public Integer getIdSupermercado() 
	{
		return idSupermercado;
	}

	public void setIdSupermercado(Integer idSupermercado) 
	{
		this.idSupermercado = idSupermercado;
	}

	//
	public String getNombreSupermercado() 
	{
		return nombreSupermercado;
	}

	public void setNombreSupermercado(String nombreSupermercado) 
	{
		this.nombreSupermercado = nombreSupermercado;
	}

	/** 
	 * @return Una cadena con la información básica de la red de Supermercado
	 */
	@Override
	public String toString() 
	{
		return "S_Supermercado_id [idSupermercado =" + idSupermercado + ", nombreSupermercado =" + nombreSupermercado + "]";
	}
}
