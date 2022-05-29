package uniandes.isis2304.parranderos.negocio;

public class Cliente implements VOCliente
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	 
	//numero de documento
	private Long numeroDocumentoCliente;
	
	// Tipo de documento
	private String tipoDocumento;
	
	//correo
	private String correoCliente;

	//idHotel
	private Integer idHotel;

	//numero de la habitacion
	private Integer idHabitacion;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Cliente() 
	{
        this.tipoDocumento = "";
		this.numeroDocumentoCliente = 0L;
		this.correoCliente = "";
		this.idHotel = 0;
		this.idHabitacion = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Cliente(String tipoDocumento, Long numeroDocumentoCliente, String correoCliente, Integer idHotel, Integer idHabitacion) 
	{
        this.tipoDocumento = tipoDocumento;
		this.numeroDocumentoCliente = numeroDocumentoCliente;
		this.correoCliente = correoCliente;
		this.idHotel = idHotel;
		this.idHabitacion = idHabitacion;
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

	//Numero de documento
	public Long getNumeroDocumentoCliente() 
	{
		return numeroDocumentoCliente;
	}

	public void setNumeroDocumentoCliente(Long numeroDocumentoCliente) 
	{
		this.numeroDocumentoCliente = numeroDocumentoCliente;
	}

	//Correo
	public String getCorreoCliente() 
	{
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) 
	{
		this.correoCliente = correoCliente;
	}

	//idHotel
	public int getIdHotel() 
	{
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) 
	{
		this.idHotel = idHotel;
	}


	//idHabitacion
	public Integer getIdHabitacion() 
	{
		return idHabitacion;
	}

	
	public void setIdHabitacion(Integer idHabitacion) 
	{
		this.idHabitacion = idHabitacion;
	}

	@Override
	public String toString() 
	{
		return "Cliente [tipoDocumentoCliente =" + tipoDocumento + ", numeroDocumentoCliente =" + numeroDocumentoCliente + ", correoCliente=" + correoCliente + 
		", idHotel = " + idHotel + "idHabitacion = " + idHabitacion + "]";
	}

}