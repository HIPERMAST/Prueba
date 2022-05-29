package uniandes.isis2304.parranderos.negocio;


public class S_Lavanderia implements VOS_Lavanderia
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Integer idLavanderia;
	
	//
	private String tipoLavanderia;

	//
	private Integer cantPrendas;

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
	public S_Lavanderia() 
	{
		this.idLavanderia = 0;
		this.tipoLavanderia = "";
		this.cantPrendas = 0;
		this.pagoCuenta = false;
		this.costoServicio = 0;
		this.idHotel = 0;
		this.idCliente = 0L;
	}

	/**
	 * Constructor con valores
	 */
	public S_Lavanderia(Integer idLavanderia, String tipoLavanderia, Integer cantPrendas, Boolean pagoCuenta, Integer costoServicio, Integer idHotel, Long idCliente) 
	{
		this.idLavanderia = idLavanderia;
		this.tipoLavanderia = tipoLavanderia;
		this.cantPrendas = cantPrendas;
		this.pagoCuenta = pagoCuenta;
		this.costoServicio = costoServicio;
		this.idHotel = idHotel;
		this.idCliente = idCliente;

	}

	//
	public Integer getIdLavanderia() 
	{
		return idLavanderia;
	}

	public void setIdLavanderia(Integer idLavanderia) 
	{
		this.idLavanderia = idLavanderia;
	}

	//
	public String getTipoLavanderia() 
	{
		return tipoLavanderia;
	}

	public void setTipoLavanderia(String tipoLavanderia) 
	{
		this.tipoLavanderia = tipoLavanderia;
	}

	//
	public Integer getCantPrendas() 
	{
		return cantPrendas;
	}

	public void setCantPrendas(Integer cantPrendas) 
	{
		this.cantPrendas = cantPrendas;
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
		return "S_Lavanderia [idLavanderia =" + idLavanderia + ", tipoLavanderia =" + tipoLavanderia + ", cantPrendas = " + cantPrendas + ", pagoCuenta = " + pagoCuenta + 
		", costoServicio = " + costoServicio + ", idHotel =" + idHotel + ", idCliente =" + idCliente +  "]";
	}
}
