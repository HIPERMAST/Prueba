package uniandes.isis2304.parranderos.negocio;


public class S_Supermercado implements VOS_Supermercado
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Integer idSupermercado;

	//
	private Boolean pagoCuenta;

	//
	private Integer costoServicio;

	//Debe exixtir un hotel con dicho identificador
	private Integer idHotel;
	
	//Debe exixtir un cliente con dicho identificador
	private Long idCliente;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Supermercado() 
	{
		this.idSupermercado = 0;
		this.pagoCuenta = false;
		this.costoServicio = 0;
		this.idHotel = 0;
		this.idCliente = 0L;
	}

	/**
	 * Constructor con valores
	 */
	public S_Supermercado(Integer idSupermercado, Boolean pagoCuenta, Integer costoServicio, Integer idHotel, Long idCliente) 
	{
		this.idSupermercado = idSupermercado;
		this.pagoCuenta = pagoCuenta;
		this.costoServicio = costoServicio;
		this.idHotel = idHotel;
		this.idCliente = idCliente;

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
	public Boolean getPagoCuenta() 
	{
		return pagoCuenta;
	}

	public void setPagoCuenta(Boolean pagoCuenta) 
	{
		this.pagoCuenta = pagoCuenta;
	}

	//
	public Integer getCostoServicio() 
	{
		return costoServicio;
	}

	public void setCostoServicio(Integer costoServicio) 
	{
		this.costoServicio = costoServicio;
	}

	//
	public Integer getIdHotel() 
	{
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) 
	{
		this.idHotel = idHotel;
	}

	//
	public Long getIdCliente() 
	{
		return idCliente;
	}

	public void setIdCliente(Long idCliente) 
	{
		this.idCliente = idCliente;
	}

	/** 
	 * @return Una cadena con la información básica del servicio piscina
	 */
	@Override
	public String toString() 
	{
		return "S_Supermercado [idSupermercado =" + idSupermercado + ", pagoCuenta = " + pagoCuenta + 
		", costoServicio = " + costoServicio + ", idHotel =" + idHotel + ", idCliente =" + idCliente +  "]";
	}
}
