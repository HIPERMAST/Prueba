package uniandes.isis2304.parranderos.negocio;

public class Producto implements VOProducto
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	/**
	 * El identificador del producto
	 */
	private Integer idProducto;

	/**
	 * El precio del producto
	 */
	private Integer precioProducto;

	/**
	 * El identificador del restaurante
	 */
	private Integer idRestaurante;

	/**
	 * El identifcador del bar
	 */
	private Integer idBar;

	/**
	 * El identificador del supermercado 
	 */
	private Integer idSupermercado;

		/**
	 * El identificador de la tienda
	 */
	private Integer idTienda;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Producto() 
	{
		this.idProducto = 0;
		this.precioProducto = 0;
		this.idRestaurante = 0;
		this.idBar = 0;
		this.idSupermercado = 0;
		this.idTienda = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Producto(Integer idProducto, Integer precioProducto, Integer idRestaurante, Integer idBar, Integer idSupermercado, Integer idTienda) 
	{	
		this.idProducto = idProducto;
		this.precioProducto = precioProducto;
		this.idRestaurante = idRestaurante;
		this.idBar = idBar;
		this.idSupermercado = idSupermercado;
		this.idTienda = idTienda;
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
	public Integer getPrecioProducto() 
	{
		return precioProducto;
	}

	public void setPrecioProducto(Integer precioProducto) 
	{
		this.precioProducto = precioProducto;
	}

	//
	public Integer getIdRestaurante() 
	{
		return idRestaurante;
	}

	public void setIdRestaurante(Integer idRestaurante) 
	{
		this.idRestaurante = idRestaurante;
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
	public Integer getIdSupermercado() 
	{
		return idSupermercado;
	}

	public void setIdSupermercado(Integer idSupermercado) 
	{
		this.idSupermercado = idSupermercado;
	}

	//
	public Integer getIdTienda() 
	{
		return idTienda;
	}

	public void setIdTienda(Integer idTienda) 
	{
		this.idTienda = idTienda;
	}


	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "Producto [idProducto =" + idProducto + ", precioProducto =" + precioProducto + ", idRestaurante =" + idRestaurante +
		", idBar =" + idBar + ", idSupermercado =" + idSupermercado + ", idTienda =" + idTienda +"]";
	}
}
