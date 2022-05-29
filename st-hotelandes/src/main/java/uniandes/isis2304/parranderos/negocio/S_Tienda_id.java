
package uniandes.isis2304.parranderos.negocio;

public class S_Tienda_id implements VOS_Tienda_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del Tienda
	 */
	private Integer idTienda;
	
	/**
	 * El nombre del Tienda
	 */
	private String nombreTienda;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Tienda_id() 
	{
		this.idTienda = 0;
		this.nombreTienda= "";
	}

	/**
	 * Constructor con valores
	 */
	public S_Tienda_id(Integer idTienda, String nombreTienda) 
	{
		this.idTienda = idTienda;
		this.nombreTienda = nombreTienda;
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

	//
	public String getNombreTienda() 
	{
		return nombreTienda;
	}

	public void setNombreTienda(String nombreTienda) 
	{
		this.nombreTienda = nombreTienda;
	}

	/** 
	 * @return Una cadena con la información básica de la red de Tienda
	 */
	@Override
	public String toString() 
	{
		return "S_Tienda_id [idTienda =" + idTienda + ", nombreTienda =" + nombreTienda + "]";
	}
}
