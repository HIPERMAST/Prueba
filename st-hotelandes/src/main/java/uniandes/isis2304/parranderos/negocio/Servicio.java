package uniandes.isis2304.parranderos.negocio;


public class Servicio implements VOServicio
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//identificador del servicio
	private Integer idServicio;	
	
	//Nombre del servicio
	private String nombreServicio;
	
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
	public Servicio() 
	{
		this.idServicio = 0;
		this.nombreServicio = "";
		this.idHotel = 0;
		this.idCliente = 0L;
	}

	/**
	 * Constructor con valores
	 */
	public Servicio(Integer idServicio, String nombreServicio, Integer idHotel, Long idCliente) 
	{
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.idHotel = idHotel;
		this.idCliente = idCliente;
		
	}

	//
	public Integer getIdServicio() 
	{
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) 
	{
		this.idServicio = idServicio;
	}

	//
	public String getNombreServicio() 
	{
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) 
	{
		this.nombreServicio = nombreServicio;
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
	 * @return Una cadena de caracteres con la información básica del servicio
	 */
	@Override
	public String toString() 
	{
		return "Servicio [idServicio =" + idServicio + ", nombreServicio =" + nombreServicio + ", idHotel =" + idHotel + ", idCliente =" + idCliente + "]";
	}
}
