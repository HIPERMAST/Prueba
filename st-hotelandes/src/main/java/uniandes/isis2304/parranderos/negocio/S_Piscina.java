package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;


public class S_Piscina implements VOS_Piscina
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Integer idPiscina;
	
	//
	private Integer profundidad;
	
	//
	private Timestamp horarioInicial;
	
	//
	private Timestamp horarioFinal;

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
	public S_Piscina() 
	{
		this.idPiscina = 0;
		this.profundidad = 0;
		this.horarioInicial = new Timestamp (0);
		this.horarioFinal = new Timestamp (0);
		this.capacidad = 0;
		this.pagoCuenta = false;
		this.costoServicio = 0;
		this.idHotel = 0;
		this.idCliente = 0L;
	}

	/**
	 * Constructor con valores
	 */
	public S_Piscina(Integer idPiscina, Integer profundidad, Timestamp horarioInicial, Timestamp horarioFinal, Integer capacidad, Boolean pagoCuenta, Integer costoServicio, Integer idHotel, Long idCliente) 
	{
		this.idPiscina = idPiscina;
		this.profundidad = profundidad;
		this.horarioInicial = horarioInicial;
		this.horarioFinal = horarioFinal;
		this.capacidad = capacidad;
		this.pagoCuenta = pagoCuenta;
		this.costoServicio = costoServicio;
		this.idHotel = idHotel;
		this.idCliente = idCliente;

	}

	//
	public Integer getIdPiscina() 
	{
		return idPiscina;
	}

	public void setIdPiscina(Integer idPiscina) 
	{
		this.idPiscina = idPiscina;
	}

	//
	public Integer getProfundidad() 
	{
		return profundidad;
	}

	public void setProfundidad(Integer profundidad) 
	{
		this.profundidad = profundidad;
	}

	//
	public Timestamp getHorarioInicial() 
	{
		return horarioInicial;
	}

	public void setHorarioInicial(Timestamp horarioInicial) 
	{
		this.horarioInicial = horarioInicial;
	}

	//
	public Timestamp getHorarioFinal() 
	{
		return horarioFinal;
	}

	public void setHorarioFinal(Timestamp horarioFinal) 
	{
		this.horarioFinal = horarioFinal;
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
		return "S_Piscina [idPiscina =" + idPiscina + ", profundidad =" + profundidad + ", horarioInicial =" + horarioInicial + 
		", horarioFinal =" + horarioFinal + ", capacidad = " + capacidad + ", pagoCuenta = " + pagoCuenta + ", costoServicio = " + costoServicio + ", idHotel =" + idHotel + ", idCliente =" + idCliente +  "]";
	}
}
