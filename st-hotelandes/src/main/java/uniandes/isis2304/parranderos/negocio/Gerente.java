package uniandes.isis2304.parranderos.negocio;

public class Gerente implements VOGerente
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/


	 	
	//numero de documento del gerente
	private Long idGerente;
	
	// Tipo de documento
	private String tipoDocumento;
	
	//correo del gerente
	private String correoGerente;

	//idHotel
	private Integer idHotel;


	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Gerente() 
	{
		this.idGerente = 0L;
		this.tipoDocumento = "";
		this.correoGerente = "";
		this.idHotel = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Gerente(Long idGerente, String tipoDocumento, String correoGerente, Integer idHotel) 
	{
        this.idGerente = idGerente;
		this.tipoDocumento = tipoDocumento;
		this.correoGerente = correoGerente;
		this.idHotel = idHotel;
	}

	//Numero de documento
	public Long getIdGerente() 
	{
		return idGerente;
	}

	public void setIdGerente(Long idGerente) 
	{
		this.idGerente = idGerente;
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
	public String getCorreoGerente() 
	{
		return correoGerente;
	}

	public void setCorreoGerente(String correoGerente) 
	{
		this.correoGerente = correoGerente;
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
		return "Gerente [idGerente =" + idGerente + ", tipoDocumentoCliente =" + tipoDocumento +  ", correoGerente =" + correoGerente + 
		", idHotel = " + idHotel + "]";
	}

}