package uniandes.isis2304.parranderos.negocio;

public class S_Salon implements VOS_Salon
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Integer idSalon;
	
	//
	private Integer reserva;
	
	//
	private String tipoSalon;
	
	//
	private String tiempoLimpieza;

	//
	private Integer capacidad;

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
	public S_Salon() 
	{
		this.idSalon = 0;
		this.reserva = 0;
		this.tipoSalon = "";
		this.tiempoLimpieza = "";
		this.capacidad = 0;
		this.pagoCuenta = false;
		this.costoServicio = 0;
		this.idHotel = 0;
		this.idCliente = 0L;
	}

	/**
	 * Constructor con valores
	 */
	public S_Salon(Integer idSalon, Integer reserva, String tipoSalon, String tiempoLimpieza, Integer capacidad, Boolean pagoCuenta, Integer costoServicio, Integer idHotel, Long idCliente) 
	{
		this.idSalon = idSalon;
		this.reserva = reserva;
		this.tipoSalon = tipoSalon;
		this.tiempoLimpieza = tiempoLimpieza;
		this.capacidad = capacidad;
		this.pagoCuenta = pagoCuenta;
		this.costoServicio = costoServicio;
		this.idHotel = idHotel;
		this.idCliente = idCliente;

	}

	//
	public Integer getIdSalon() 
	{
		return idSalon;
	}

	public void setIdSalon(Integer idSalon) 
	{
		this.idSalon = idSalon;
	}

	//
	public Integer getReserva() 
	{
		return reserva;
	}

	public void setReserva(Integer reserva) 
	{
		this.reserva = reserva;
	}

	//
	public String getTipoSalon() 
	{
		return tipoSalon;
	}

	public void setTipoSalon(String tipoSalon) 
	{
		this.tipoSalon = tipoSalon;
	}

	//
	public String getTiempoLimpieza() 
	{
		return tiempoLimpieza;
	}

	public void setTiempoLimpieza(String tiempoLimpieza) 
	{
		this.tiempoLimpieza = tiempoLimpieza;
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
		return "S_Salon [idSalon =" + idSalon + ", reserva =" + reserva + ", tipoSalon =" + tipoSalon + 
		", tiempoLimpieza =" + tiempoLimpieza + ", capacidad = " + capacidad + ", pagoCuenta = " + pagoCuenta + ", costoServicio = " + costoServicio + ", idHotel =" + idHotel + ", idCliente =" + idCliente +  "]";
	}
}
