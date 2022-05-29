package uniandes.isis2304.parranderos.negocio;

public interface VOProducto
{

	public Integer getIdProducto();

	public Integer getPrecioProducto();

	public Integer getIdRestaurante();

	public Integer getIdBar();

	public Integer getIdSupermercado();

	public Integer getIdTienda();

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
