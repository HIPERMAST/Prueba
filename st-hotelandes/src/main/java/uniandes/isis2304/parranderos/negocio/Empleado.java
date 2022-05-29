package uniandes.isis2304.parranderos.negocio;

public class Empleado implements VOEmpleado
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	//Numero del documento del Recepcionista
	private Long idEmpleado;
	
	 // Tipo de documento
	private String tipoDocumento;
	
	//numero de documento
	private String correoEmpleado;

	//idCuenta fk
	private Integer numeroHabitacion;

	//idCliente fk
	private Long idCliente;

	//idHotel
	private Integer idHotel;



	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Empleado() 
	{
        this.idEmpleado = 0L;
		this.tipoDocumento = "";
		this.correoEmpleado = "";
		this.numeroHabitacion = 0;
		this.idCliente = 0L;
		this.idHotel = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Empleado(Long idEmpleado, String tipoDocumento, String correoEmpleado, Integer numeroHabitacion, Long idCliente, Integer idHotel) 
	{
        this.idEmpleado = idEmpleado;
		this.tipoDocumento = tipoDocumento;
		this.correoEmpleado = correoEmpleado;
		this.numeroHabitacion = numeroHabitacion;
		this.idCliente = idCliente;
		this.idHotel = idHotel;
	}

	//Numero de documento
	public Long getIdEmpleado() 
	{
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) 
	{
		this.idEmpleado = idEmpleado;
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
	public String getCorreoEmpleado() 
	{
		return correoEmpleado;
	}

	public void setCorreoEmpleado(String correoEmpleado) 
	{
		this.correoEmpleado = correoEmpleado;
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

	//idHotel
	public Long getIdCliente() 
	{
		return idCliente;
	}

	
	public void setIdCliente(Long idCliente) 
	{
		this.idCliente = idCliente;
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

	@Override
	public String toString() 
	{
		return "Empleado [idEmpleado =" + idEmpleado + "tipoDocumentoCliente =" + tipoDocumento + ", correoEmpleado =" + correoEmpleado + 
		"numeroHabitacion =" + numeroHabitacion + "idHabitacion = " + idCliente + ", idCliente = " + idHotel +"]";
	}

}