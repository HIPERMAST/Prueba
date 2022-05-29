package uniandes.isis2304.parranderos.negocio;

public class PC_TodoIncluido implements VOPC_TodoIncluido
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la reserva
	 */
	private Integer idProducto;
	
	/**
	 * El identificador de la reserva
	 */
	private Integer idReserva;

	/**
	 * El identificador de la reserva
	 */
	private Integer idRestaurante;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public PC_TodoIncluido() 
	{
		this.idProducto= 0;
		this.idReserva = 0;
		this.idRestaurante = 0;
	}

	/**
	 * Constructor con valores
	 */
	public PC_TodoIncluido(Integer idProducto, Integer idReserva, Integer idRestaurante) 
	{	
		this.idProducto = idProducto;
		this.idReserva = idReserva;
		this.idRestaurante = idRestaurante;
	}

	//
	public Integer getIdProducto() 
	{
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) 
	{
		this.idProducto = idProducto;
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
		return "PC_TodoIncluido [idProducto =" + idProducto + ", idReserva =" + idReserva + "idRestaurante =" + idRestaurante + "]";
	}
}
