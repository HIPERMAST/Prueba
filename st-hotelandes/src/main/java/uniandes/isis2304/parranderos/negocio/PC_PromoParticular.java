package uniandes.isis2304.parranderos.negocio;

public class PC_PromoParticular implements VOPC_PromoParticular
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la reserva
	 */
	private Integer idPromopar;
	/**
	 * El identificador de la reserva
	 */
	private Integer idReserva;
	
	/**
	 * El descuento a la reserva
	 */
	private Integer descuentoReserva;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public PC_PromoParticular() 
	{
		this.idPromopar = 0;
		this.idReserva = 0;
		this.descuentoReserva= 0;
	}

	/**
	 * Constructor con valores
	 */
	public PC_PromoParticular(Integer idPromopar,Integer idReserva, Integer descuentoReserva) 
	{
		this.idPromopar = idPromopar;
		this.idReserva = idReserva;
		this.descuentoReserva = descuentoReserva;
	}

	//
	public Integer getIdPromopar() 
	{
		return idPromopar;
	}

	public void setIdPromopar(Integer idPromopar) 
	{
		this.idPromopar = idPromopar;
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
	public Integer getDescuentoReserva() 
	{
		return descuentoReserva;
	}

	public void setDescuentoReserva(Integer descuentoReserva) 
	{
		this.descuentoReserva = descuentoReserva;
	}

	/** 
	 * @return Una cadena con la información básica de el plan consumo
	 */
	@Override
	public String toString() 
	{
		return "PC_PromocionParticular [idPromocionparticular =" + idPromopar + ", idReserva =" + idReserva + ", descuentoReserva =" + descuentoReserva + "]";
	}
}
