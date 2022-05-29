package uniandes.isis2304.parranderos.negocio;

public class AdministradorDatos implements VOAdministradorDatos
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	 
	//numero de documento
	private Long numeroDocumento;
	
	// Tipo de documento
	private String tipoDocumento;
	
	//correo
	private String correo;

	//contraseña
	private String pw;

	//identificador del servicio
	private Long idUsuario;

	//idHotel
	private Integer idHotel;

	

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public AdministradorDatos() 
	{
        this.numeroDocumento = 0L;
		this.tipoDocumento = "";
		this.correo = "";
		this.pw = "";
		this.idUsuario = 0L;
		this.idHotel = 0;
	}

	/**
	 * Constructor con valores
	 */
	public AdministradorDatos(String tipoDocumento, Long numeroDocumento, String correo, String pw, Long idUsuario, Integer idHotel)
	{
        this.numeroDocumento = numeroDocumento;
		this.tipoDocumento = tipoDocumento;
		this.correo = correo;
		this.pw = pw;
		this.idUsuario = idUsuario;
		this.idHotel = idHotel;
	}

	//Numero de documento
	public Long getNumeroDocumento() 
	{
		return numeroDocumento;
	}

	public void setNumeroDocumento(Long numeroDocumento) 
	{
		this.numeroDocumento = numeroDocumento;
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
	public String getCorreo() 
	{
		return correo;
	}

	public void setCorreo(String correo) 
	{
		this.correo = correo;
	}

	//Contraseña
	public String getPw() 
	{
		return pw;
	}

	public void setPw(String pw) 
	{
		this.pw = pw;
	}

	//IdUsuario
	public Long getIdUsuario() 
	{
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) 
	{
		this.idUsuario = idUsuario;
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
		return "AministradorDatos [tipoDocumentoCliente =" + tipoDocumento + ", numeroDocumento =" + numeroDocumento +
			   ", correo =" + correo + ", pw =" + pw + ", idUsuario =" + idUsuario + ", idHotel =" + idHotel + "]";
	}

}