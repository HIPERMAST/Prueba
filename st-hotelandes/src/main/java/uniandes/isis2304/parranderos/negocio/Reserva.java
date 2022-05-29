package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;


public class Reserva implements VOReserva
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Long idReserva;
	
	//
	private Integer cantPersonas;
	
	//
	private Timestamp checkIn;
	
	//
	private Timestamp checkOut;

	//Debe exixtir un Plan de Consumo con dicho identificador
	private Integer idPlanConsumo;

	//Activo
	private Integer activo;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Reserva() 
	{
		this.idReserva = 0L;
		this.cantPersonas = 0;
		this.checkIn = new Timestamp (0);
		this.checkOut = new Timestamp (0);
		this.idPlanConsumo = 0;
		this.activo = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Reserva(Long idReserva, Integer cantPersonas, Timestamp checkIn, Timestamp checkOut, Integer idPlanConsumo, Integer activo) 
	{
		this.idReserva = idReserva;
		this.cantPersonas = cantPersonas;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.idPlanConsumo = idPlanConsumo;
		this.activo = activo;
	}

	//
	public Long getIdReserva() 
	{
		return idReserva;
	}

	public void setIdReserva(Long idReserva) 
	{
		this.idReserva = idReserva;
	}

	//
	public Integer getCantPersonas() 
	{
		return cantPersonas;
	}

	public void setCantPersonas(Integer cantPersonas) 
	{
		this.cantPersonas = cantPersonas;
	}

	//
	public Timestamp getCheckIn() 
	{
		return checkIn;
	}

	public void setCheckIn(Timestamp checkIn) 
	{
		this.checkIn = checkIn;
	}

	//
	public Timestamp getCheckOut() 
	{
		return checkOut;
	}

	public void setCheckOut(Timestamp checkOut) 
	{
		this.checkOut = checkOut;
	}

	//
	public Integer getIdPlanConsumo() 
	{
		return idPlanConsumo;
	}

	public void setIdPlanConsumo(Integer idPlanConsumo) 
	{
		this.idPlanConsumo = idPlanConsumo;
	}

	//
	public Integer getActivo() 
	{
		return activo;
	}

	public void setActivo(Integer activo) 
	{
		this.activo = activo;
	}

	/** 
	 * @return Una cadena con la información básica de la reserva
	 */
	@Override
	public String toString() 
	{
		return "Reserva [idReserva =" + idReserva + ", cantPersonas =" + cantPersonas + ", checkIn =" + checkIn + ", checkOut ="
				+ checkOut + ", idPlanConsumo = " + idPlanConsumo + "]";
	}
}
