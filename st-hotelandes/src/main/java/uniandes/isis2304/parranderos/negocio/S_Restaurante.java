package uniandes.isis2304.parranderos.negocio;


public class S_Restaurante implements VOS_Restaurante
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Integer idRestaurante;
	
	//
	private String estiloRestaurante;

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
	public S_Restaurante() 
	{
		this.idRestaurante = 0;
		this.estiloRestaurante = "";
		this.capacidad = 0;
		this.pagoCuenta = false;
		this.costoServicio = 0;
		this.idHotel = 0;
		this.idCliente = 0L;
	}

	/**
	 * Constructor con valores
	 */
	public S_Restaurante(Integer idRestaurante, String estiloRestaurante, Integer capacidad, Boolean pagoCuenta, Integer costoServicio, Integer idHotel, Long idCliente) 
	{
		this.idRestaurante = idRestaurante;
		this.estiloRestaurante = estiloRestaurante;
		this.capacidad = capacidad;
		this.pagoCuenta = pagoCuenta;
		this.costoServicio = costoServicio;
		this.idHotel = idHotel;
		this.idCliente = idCliente;

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
	public String getEstiloRestaurante() 
	{
		return estiloRestaurante;
	}

	public void setEstiloRestaurante(String estiloRestaurante) 
	{
		this.estiloRestaurante = estiloRestaurante;
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
		return "S_Restaurante [idRestaurante =" + idRestaurante + ", estiloRestaurante =" + estiloRestaurante + ", capacidad = " + capacidad + ", pagoCuenta = " + pagoCuenta + 
		", costoServicio = " + costoServicio + ", idHotel =" + idHotel + ", idCliente =" + idCliente +  "]";
	}
}
