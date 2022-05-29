package uniandes.isis2304.parranderos.negocio;

public class Cuenta implements VOCuenta
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Integer idCuenta;

	//
	private Integer costoTotal;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Cuenta() 
	{
		this.idCuenta = 0;
		this.costoTotal = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Cuenta(Integer idCuenta, Integer costoTotal) 
	{
		this.idCuenta = idCuenta;
		this.costoTotal = costoTotal;
	}

	//
	public Integer getIdCuenta() 
	{
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) 
	{
		this.idCuenta = idCuenta;
	}

	//
	public Integer getCostoTotal() 
	{
		return costoTotal;
	}

	public void setCostoTotal(Integer costoTotal) 
	{
		this.costoTotal = costoTotal;
	}


	/**
	 * @return Una cadena de caracteres con la información de la cuenta
	 */
	@Override
	public String toString() 
	{
		return "Cuenta [idCuenta =" + idCuenta + ", costoTotal =" + costoTotal + "]";
	}

}
