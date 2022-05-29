package uniandes.isis2304.parranderos.negocio;

public class PC_LargaEstadia implements VOPC_LargaEstadia
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la reserva
	 */
	private Integer idLargaEstadia;
	/**
	 * El identificador de la reserva
	 */
	private Integer idReserva;
	
	/**
	 * El descuento a el alojamiento
	 */
	private Integer descuentoAlojamiento;

	/**
	 * El número de la habitación del alojamiento
	 */
	private Integer numeroHabitacion;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public PC_LargaEstadia() 
	{
		this.idLargaEstadia = 0;
		this.idReserva = 0;
		this.descuentoAlojamiento= 0;
		this.numeroHabitacion = 0;
	}

	/**
	 * Constructor con valores
	 */
	public PC_LargaEstadia(Integer idLargaEstadia, Integer idReserva, Integer descuentoAlojamiento, Integer numeroHabitacion) 
	{
		this.idLargaEstadia = idLargaEstadia;
		this.idReserva = idReserva;
		this.descuentoAlojamiento = descuentoAlojamiento;
		this.numeroHabitacion = numeroHabitacion;
	}

	//
	public Integer getIdLargaEstadia() 
	{
		return idLargaEstadia;
	}

	public void setIdLargaEstadia(Integer idLargaEstadia) 
	{
		this.idLargaEstadia = idLargaEstadia;
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
	public Integer getDescuentoAlojamiento() 
	{
		return descuentoAlojamiento;
	}

	public void setDescuentoAlojamiento(Integer descuentoAlojamiento) 
	{
		this.descuentoAlojamiento = descuentoAlojamiento;
	}

	//NumeroHabitacion
	public Integer getNumeroHabitacion() 
	{
		return numeroHabitacion;
	}
	
	
	public void setNumeroHabitacion(Integer numeroHabitacion) 
	{
		this.numeroHabitacion = numeroHabitacion;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "PC_LargaEstadia [idLargaEstadia =" + idLargaEstadia + ", idReserva =" + idReserva + ", descuentoAlojamiento =" + descuentoAlojamiento + "]";
	}
}
