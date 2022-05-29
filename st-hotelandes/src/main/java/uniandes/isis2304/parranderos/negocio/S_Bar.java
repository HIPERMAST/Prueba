package uniandes.isis2304.parranderos.negocio;


public class S_Bar implements VOS_Bar
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Integer idBar;
	
	//
	private String estiloBar;

	//
	private Integer capacidad;

	//
	private Boolean pagoCuenta;

	//
	private Integer costoServicio;

	//Debe exixtir un cliente con dicho identificador
	private Long idCliente;

	//Debe exixtir un hotel con dicho identificador
	private Integer idHotel;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public S_Bar() 
	{
		this.idBar = 0;
		this.estiloBar = "";
		this.capacidad = 0;
		this.pagoCuenta = false;
		this.costoServicio = 0;
		this.idHotel = 0;
		this.idCliente = 0L;
	}

	/**
	 * Constructor con valores
	 */
	public S_Bar(Integer idBar, String estiloBar, Integer capacidad, Boolean pagoCuenta, Integer costoServicio, Integer idHotel, Long idCliente) 
	{
		this.idBar = idBar;
		this.estiloBar = estiloBar;
		this.capacidad = capacidad;
		this.pagoCuenta = pagoCuenta;
		this.costoServicio = costoServicio;
		this.idHotel = idHotel;
		this.idCliente = idCliente;

	}

	//
	public Integer getIdBar() 
	{
		return idBar;
	}

	public void setIdBar(Integer idBar) 
	{
		this.idBar = idBar;
	}

	//
	public String getEstiloBar() 
	{
		return estiloBar;
	}

	public void setEstiloBar(String estiloBar) 
	{
		this.estiloBar = estiloBar;
	}

	//
	public Integer getCapacidad() 
	{
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) 
	{
		this.capacidad = capacidad;
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
		return "S_Bar [idBar =" + idBar + ", estiloBar =" + estiloBar + ", capacidad = " + capacidad + ", pagoCuenta = " + pagoCuenta + 
		", costoServicio = " + costoServicio + ", idHotel =" + idHotel + ", idCliente =" + idCliente +  "]";
	}
}
