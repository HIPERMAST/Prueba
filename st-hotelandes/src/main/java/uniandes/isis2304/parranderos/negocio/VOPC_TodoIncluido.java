package uniandes.isis2304.parranderos.negocio;

public interface VOPC_TodoIncluido
{

	public Integer getIdProducto();
	
	public Integer getIdReserva();

	public Integer getIdRestaurante();

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
