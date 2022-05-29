package uniandes.isis2304.parranderos.negocio;


public class S_Gym implements VOS_Gym
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Integer idGYM;
	
	//
	private Integer cantMaquinas;

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
	public S_Gym() 
	{
		this.idGYM = 0;
		this.cantMaquinas = 0;
		this.capacidad = 0;
		this.pagoCuenta = false;
		this.costoServicio = 0;
		this.idHotel = 0;
		this.idCliente = 0L;
	}

	/**
	 * Constructor con valores
	 */
	public S_Gym(Integer idGYM, Integer cantMaquinas, Integer capacidad, Boolean pagoCuenta, Integer costoServicio, Integer idHotel, Long idCliente) 
	{
		this.idGYM = idGYM;
		this.cantMaquinas = cantMaquinas;
		this.capacidad = capacidad;
		this.pagoCuenta = pagoCuenta;
		this.costoServicio = costoServicio;
		this.idHotel = idHotel;
		this.idCliente = idCliente;

	}

	//
	public Integer getIdGYM() 
	{
		return idGYM;
	}

	public void setIdGYM(Integer idGYM) 
	{
		this.idGYM = idGYM;
	}

	//
	public Integer getCantMaquinas() 
	{
		return cantMaquinas;
	}

	public void setCantMaquinas(Integer cantMaquinas) 
	{
		this.cantMaquinas = cantMaquinas;
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
		return "S_Gym [idGYM =" + idGYM + ", cantMaquinas =" + cantMaquinas + ", capacidad = " + capacidad + ", pagoCuenta = " + pagoCuenta + 
		", costoServicio = " + costoServicio + ", idHotel =" + idHotel + ", idCliente =" + idCliente +  "]";
	}
}
