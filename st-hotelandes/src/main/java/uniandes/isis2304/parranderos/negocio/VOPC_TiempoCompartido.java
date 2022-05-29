package uniandes.isis2304.parranderos.negocio;

public interface VOPC_TiempoCompartido
{

	public Integer getIdTiempoCompartido();

	public Integer getIdReserva();

	public Integer getDescuentoBar();

	public Integer getDescuentoRestaurante();

	public Integer getIdBar();

	public Integer getIdRestaurante();

	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
