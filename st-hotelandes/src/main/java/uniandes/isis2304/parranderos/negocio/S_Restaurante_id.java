
package uniandes.isis2304.parranderos.negocio;

public class S_Restaurante_id implements VOS_Restaurante_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la pscina
	 */
	private Integer idRestaurante;
	
	/**
	 * El nombre de el gimnasio
	 */
	private String nombreRestaurante;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Restaurante_id() 
	{
		this.idRestaurante = 0;
		this.nombreRestaurante= "";
	}

	/**
	 * Constructor con valores
	 */
	public S_Restaurante_id(Integer idRestaurante, String nombreRestaurante) 
	{
		this.idRestaurante = idRestaurante;
		this.nombreRestaurante = nombreRestaurante;
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
	public String getNombreRestaurante() 
	{
		return nombreRestaurante;
	}

	public void setNombreRestaurante(String nombreRestaurante) 
	{
		this.nombreRestaurante = nombreRestaurante;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "S_Restaurante_id [idRestaurante =" + idRestaurante + ", nombreRestaurante =" + nombreRestaurante + "]";
	}
}
