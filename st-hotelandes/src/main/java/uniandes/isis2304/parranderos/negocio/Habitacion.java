package uniandes.isis2304.parranderos.negocio;

public class Habitacion implements VOHabitacion
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//numero de la Habitacion
	private Long numeroHabitacion;
	
	//dosto de la habitacion
	private Integer costoHabitacion;

	//id del tipo
	private Integer idTipo;

	//idHotel
	private Integer idHotel;

	//id de la reserva
	private Integer idReserva;

	//id cuenta
	private Integer idCuenta;

	//ocupacion total
	private Integer ocupacionTotal;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public Habitacion() 
    {
    	this.numeroHabitacion = 0L;
		this.costoHabitacion = 0;
		this.idTipo = 0;
		this.idHotel = 0;
		this.idReserva = 0;
		this.idCuenta = 0;
		this.ocupacionTotal = 0;
	}

	/**
	 * Constructor con valores
	 */
    public Habitacion(Long numeroHabitacion, Integer costoHabitacion, Integer idTipo, Integer idHotel, Integer idReserva, Integer idCuenta, Integer ocupacionTotal) 
    {
    	this.numeroHabitacion = numeroHabitacion;
		this.costoHabitacion = costoHabitacion;
		this.idTipo = idTipo;
		this.idHotel = idHotel;
		this.idReserva = idReserva;
		this.idCuenta = idCuenta;
		this.ocupacionTotal = ocupacionTotal;
	}

	//NumeroHabitacion
	public Long getNumeroHabitacion() 
	{
		return numeroHabitacion;
	}
	
	
	public void setNumeroHabitacion(Long numeroHabitacion) 
	{
		this.numeroHabitacion = numeroHabitacion;
	}


	//costoHabitacion
	public Integer getCostoHabitacion() 
	{
		return costoHabitacion;
	}
	
	
	public void setCostoHabitacion(Integer costoHabitacion) 
	{
		this.costoHabitacion = costoHabitacion;
	}

    //
	public Integer getIdTipo() 
	{
		return idTipo;
	}
	
	public void setIdTipo(Integer idTipo) 
	{
		this.idTipo = idTipo;
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
	public Integer getIdReserva() 
	{
		return idReserva;
	}
	
	public void setIdReserva(Integer idReserva) 
	{
		this.idReserva = idReserva;
	}
	
	//
	public Integer getIdCuenta() 
	{
		return idCuenta;
	}
	
	public void setIdCuenta(Integer idCuenta) 
	{
		this.idCuenta = idCuenta;
	}

	//
	public Integer getOcupacionTotal() 
	{
		return ocupacionTotal;
	}

	public void setOcupacionTotal(Integer ocupacionTotal) 
	{
		this.ocupacionTotal = ocupacionTotal;
	}




	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos
	 */
	public String toString() 
	{
		return "Habitación [numeroHabitacion =" + numeroHabitacion + ", costoHabitacion =" + costoHabitacion + ", idTipo=" + idTipo + ", idHotel = " + idHotel + ", idReserva = " + idReserva + ", idCuenta = " + idCuenta + "]";
	}
	

}
