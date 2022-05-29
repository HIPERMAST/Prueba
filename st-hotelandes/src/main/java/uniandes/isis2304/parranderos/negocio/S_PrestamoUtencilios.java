package uniandes.isis2304.parranderos.negocio;


public class S_PrestamoUtencilios implements VOS_PrestamoUtencilios
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Integer idPrestamoUtencilios;
	
	//
	private String tipoUtencilios;

	//
	private Integer cantUtencilios;

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
	public S_PrestamoUtencilios() 
	{
		this.idPrestamoUtencilios = 0;
		this.tipoUtencilios = "";
		this.cantUtencilios = 0;
		this.pagoCuenta = false;
		this.costoServicio = 0;
		this.idHotel = 0;
		this.idCliente = 0L;
	}

	/**
	 * Constructor con valores
	 */
	public S_PrestamoUtencilios(Integer idPrestamoUtencilios, String tipoUtencilios, Integer cantUtencilios, Boolean pagoCuenta, Integer costoServicio, Integer idHotel, Long idCliente) 
	{
		this.idPrestamoUtencilios = idPrestamoUtencilios;
		this.tipoUtencilios = tipoUtencilios;
		this.cantUtencilios = cantUtencilios;
		this.pagoCuenta = pagoCuenta;
		this.costoServicio = costoServicio;
		this.idHotel = idHotel;
		this.idCliente = idCliente;

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
	public String getTipoUtencilios() 
	{
		return tipoUtencilios;
	}

	public void setTipoUtencilios(String tipoUtencilios) 
	{
		this.tipoUtencilios = tipoUtencilios;
	}

	//
	public Integer getCantUtencilios() 
	{
		return cantUtencilios;
	}

	public void setCantUtencilios(Integer cantUtencilios) 
	{
		this.cantUtencilios = cantUtencilios;
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
		return "S_PrestamoUtencilios [idPrestamoUtencilios =" + idPrestamoUtencilios + ", tipoUtencilios =" + tipoUtencilios + ", cantUtencilios = " + cantUtencilios + ", pagoCuenta = " + pagoCuenta + 
		", costoServicio = " + costoServicio + ", idHotel =" + idHotel + ", idCliente =" + idCliente +  "]";
	}
}
