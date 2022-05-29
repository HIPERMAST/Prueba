package uniandes.isis2304.parranderos.negocio;

public class OrganizadorEventos implements VOOrganizadorEventos
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	 
	//numero de documento
	private Long idOE;
	
	// Tipo de documento
	private String tipoDocumento;
	
	//correoOE
	private String correoOE;

	//contraseña
	private String pwOE;

	//idHotel
	private Long idHotel;

	//idConvencion
	private Long idConvencion;

	//idCuenta
	private Long idCuenta;

	//idReserva
	private Long idReserva;
	

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public OrganizadorEventos() 
	{
        this.idOE = 0L;
		this.tipoDocumento = "";
		this.correoOE = "";
		this.pwOE = "";
		this.idHotel = 0L;
		this.idConvencion = 0L;
		this.idCuenta = 0L;
		this.idReserva = 0L;
	}

	/**
	 * Constructor con valores
	 */
	public OrganizadorEventos(Long idOE, String tipoDocumento, String correoOE, String pwOE, Long idHotel, Long idConvencion, Long idCuenta, Long idReserva)
	{
        this.idOE = idOE;
		this.tipoDocumento = tipoDocumento;
		this.correoOE = correoOE;
		this.pwOE = pwOE;
		this.idHotel = idHotel;
		this.idConvencion = idConvencion;
		this.idCuenta = idCuenta;
		this.idReserva = idReserva;
	}

	//Numero de documento
	public Long getIdOE() 
	{
		return idOE;
	}

	public void setIdOE(Long idOE) 
	{
		this.idOE = idOE;
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

	//CorreoOE
	public String getCorreoOE() 
	{
		return correoOE;
	}

	public void setCorreoOE(String correoOE) 
	{
		this.correoOE = correoOE;
	}

	//Contraseña
	public String getPwOE() 
	{
		return pwOE;
	}

	public void setPwOE(String pwOE) 
	{
		this.pwOE = pwOE;
	}

	//IdHotel
	public Long getIdHotel() 
	{
		return idHotel;
	}

	public void setIdHotel(Long idHotel) 
	{
		this.idHotel = idHotel;
	}

	//IdConvencion
	public Long getIdConvencion() 
	{
		return idConvencion;
	}

	public void setIdConvencion(Long idConvencion) 
	{
		this.idConvencion = idConvencion;
	}

	//IdCuenta
	public Long getIdCuenta() 
	{
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) 
	{
		this.idCuenta = idCuenta;
	}

	//IdReserva
	public Long getIdReserva() 
	{
		return idReserva;
	}
	
	public void setIdReserva(Long idReserva) 
	{
		this.idReserva = idReserva;
	}


	@Override
	public String toString() 
	{
		return "OrganizadorEventos [idOE =" + idOE + ", tipoDocumentoCliente =" + tipoDocumento + ", correoOE =" + correoOE + ", pwOE =" + pwOE + ", idHotel =" + idHotel + ", idConvencion =" + idConvencion + ", idCuenta =" + idCuenta + ", idReserva =" + idReserva + "]";
	}

}