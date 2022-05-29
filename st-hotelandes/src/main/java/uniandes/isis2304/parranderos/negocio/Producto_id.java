package uniandes.isis2304.parranderos.negocio;

public class Producto_id implements VOProducto_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del plan consumo
	 */
	private Integer idProducto;
	
	/**
	 * El identificador del hotel
	 */
	private String nombreProducto;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Producto_id() 
	{
		this.idProducto = 0;
		this.nombreProducto = "";
	}

	/**
	 * Constructor con valores
	 */
	public Producto_id(Integer idProducto, String nombreProducto) 
	{
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
	}

	//
	public Integer getIdProducto() 
	{
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) 
	{
		this.idProducto = idProducto;
	}

	//
	public String getNombreProducto() 
	{
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) 
	{
		this.nombreProducto = nombreProducto;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "Producto_id 	 [idProducto =" + idProducto + ", nombreProducto =" + nombreProducto + "]";
	}
}
