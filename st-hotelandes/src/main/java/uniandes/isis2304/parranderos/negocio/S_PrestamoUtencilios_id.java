
package uniandes.isis2304.parranderos.negocio;

public class S_PrestamoUtencilios_id implements VOS_PrestamoUtencilios_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la pscina
	 */
	private Integer idPrestamoUtencilios;
	
	/**
	 * El nombre de el gimnasio
	 */
	private String nombrePrestamoUtencilios;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_PrestamoUtencilios_id() 
	{
		this.idPrestamoUtencilios = 0;
		this.nombrePrestamoUtencilios= "";
	}

	/**
	 * Constructor con valores
	 */
	public S_PrestamoUtencilios_id(Integer idPrestamoUtencilios, String nombrePrestamoUtencilios) 
	{
		this.idPrestamoUtencilios = idPrestamoUtencilios;
		this.nombrePrestamoUtencilios = nombrePrestamoUtencilios;
	}

	//
	public Integer getIdPrestamoUtencilios() 
	{
		return idPrestamoUtencilios;
	}

	public void setIdPrestamoUtencilios(Integer idPrestamoUtencilios) 
	{
		this.idPrestamoUtencilios = idPrestamoUtencilios;
	}

	//
	public String getNombrePrestamoUtencilios() 
	{
		return nombrePrestamoUtencilios;
	}

	public void setNombrePrestamoUtencilios(String nombrePrestamoUtencilios) 
	{
		this.nombrePrestamoUtencilios = nombrePrestamoUtencilios;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "S_PrestamoUtencilios_id [idPrestamoUtencilios =" + idPrestamoUtencilios + ", nombrePrestamoUtencilios =" + nombrePrestamoUtencilios + "]";
	}
}
