package uniandes.isis2304.parranderos.negocio;

public class PC_TiempoCompartido implements VOPC_TiempoCompartido
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	 /**
	 * El identificador de la reserva
	 */
	private Integer idTiempoCompartido;

	/**
	 * El identificador de la reserva
	 */
	private Integer idReserva;

	/**
	 * El descuento del bar
	 */
	private Integer descuentoBar;

	/**
	 * El descuento que se aplica al restaurante
	 */
	private Integer descuentoRestaurante;

	/**
	 * El identificador del bar al que plica el descuento
	 */
	private Integer idBar;

	/**
	 * El identificador del restaurante al que plica el descuento
	 */
	private Integer idRestaurante;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public PC_TiempoCompartido() 
	{
		this.idTiempoCompartido = 0;
		this.idReserva = 0;
		this.descuentoBar = 0;
		this.descuentoRestaurante = 0;
		this.idBar = 0;
		this.idRestaurante = 0;
	}

	/**
	 * Constructor con valores
	 */
	public PC_TiempoCompartido(Integer idTiempoCompartido, Integer idReserva, Integer descuentoBar, Integer descuentoRestaurante, Integer idBar, Integer idRestaurante) 
	{	
		this.idTiempoCompartido = idTiempoCompartido;
		this.idReserva = idReserva;
		this.descuentoBar = descuentoBar;
		this.descuentoRestaurante = descuentoRestaurante;
		this.idBar = idBar;
		this.idRestaurante = idRestaurante;
	}

	//
	public Integer getIdTiempoCompartido() 
	{
		return idTiempoCompartido;
	}

	public void setIdTiempoCompartido(Integer idTiempoCompartido) 
	{
		this.idTiempoCompartido = idTiempoCompartido;
	}

	//
	public Integer getIdReserva() 
	{
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) 
	{
		this.idReserva = idReserva;
	}

	//
	public Integer getDescuentoBar() 
	{
		return descuentoBar;
	}

	public void setDescuentoBar(Integer descuentoBar) 
	{
		this.descuentoBar = descuentoBar;
	}

	//
	public Integer getDescuentoRestaurante() 
	{
		return descuentoRestaurante;
	}

	public void setDescuentoRestaurante(Integer descuentoRestaurante) 
	{
		this.descuentoRestaurante = descuentoRestaurante;
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
	public Integer getIdRestaurante() 
	{
		return idRestaurante;
	}

	public void setIdRestaurante(Integer idRestaurante) 
	{
		this.idRestaurante = idRestaurante;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "PC_TiempoCompartido [idTiempoCompartido" + idTiempoCompartido +", idReserva =" + idReserva + ", descuentoBar =" + descuentoBar + ", descuentoRestaurante =" + descuentoRestaurante + 
		", idBar =" + idBar + ", idRestaurante =" + idRestaurante + "]";
	}
}
