package uniandes.isis2304.parranderos.negocio;

public class Recepcionista implements VORecepcionista
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	//Numero del documento del Recepcionista
	private Long idRecepcionista;
	
	 // Tipo de documento
	private String tipoDocumento;
	
	//numero de documento
	private String correoRecepcionista;

	//idCuenta fk
	private Integer idReserva;

	//idCuenta fk
	private Integer idCliente;

	//idHotel
	private Integer idHotel;



	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Recepcionista() 
	{
        this.idRecepcionista = 0L;
		this.tipoDocumento = "";
		this.correoRecepcionista = "";
		this.idReserva = 0;
		this.idCliente = 0;
		this.idHotel = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Recepcionista(Long idRecepcionista, String tipoDocumento, String correoRecepcionista, Integer idReserva, Integer idCliente, Integer idHotel) 
	{
        this.idRecepcionista = idRecepcionista;
		this.tipoDocumento = tipoDocumento;
		this.correoRecepcionista = correoRecepcionista;
		this.idReserva = idReserva;
		this.idCliente = idCliente;
		this.idHotel = idHotel;
	}

	//Numero de documento
	public Long getIdRecepcionista() 
	{
		return idRecepcionista;
	}

	public void setIdRecepcionista(Long idRecepcionista) 
	{
		this.idRecepcionista = idRecepcionista;
	}

	//Tipo de documento
	public String getTipoDocumento() 
	{
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) 
	{
		this.tipoDocumento = tipoDocumento;
	}

	//Correo
	public String getCorreoRecepcionista() 
	{
		return correoRecepcionista;
	}

	public void setCorreoRecepcionista(String correoRecepcionista) 
	{
		this.correoRecepcionista = correoRecepcionista;
	}


	//idHotel
	public Integer getIdReserva() 
	{
		return idReserva;
	}

	
	public void setIdReserva(Integer idReserva) 
	{
		this.idReserva = idReserva;
	}

	//idHotel
	public Integer getIdCliente() 
	{
		return idCliente;
	}

	
	public void setIdCliente(Integer idCliente) 
	{
		this.idCliente = idCliente;
	}

	//idHotel
	public Integer getIdHotel() 
	{
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) 
	{
		this.idHotel = idHotel;
	}

	@Override
	public String toString() 
	{
		return "Recepcionista [idRecepcionista =" + idRecepcionista + "tipoDocumentoCliente =" + tipoDocumento + ", correoRecepcionista =" + correoRecepcionista + 
		"idReserva = " + idReserva +  "idHabitacion = " + idCliente + ", idCliente = " + idHotel +"]";
	}

}