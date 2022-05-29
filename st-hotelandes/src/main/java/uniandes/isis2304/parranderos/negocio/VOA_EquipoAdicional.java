package uniandes.isis2304.parranderos.negocio;

public interface VOA_EquipoAdicional
{

	public String getTipoEquipo();

	public Integer getCosto();
	
	public Integer getIdGYM();
	
	
	/** 
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
