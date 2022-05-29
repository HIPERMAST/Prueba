package uniandes.isis2304.parranderos.negocio;

public interface VOTipo
{
	public Integer getIdTipo();

	public String getNombreTipo();

	public String getDotacion();

	public Integer getCapacidad();

	@Override
	public String toString();

}
