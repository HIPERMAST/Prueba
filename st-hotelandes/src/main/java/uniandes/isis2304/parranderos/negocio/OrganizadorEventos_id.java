package uniandes.isis2304.parranderos.negocio;

public class OrganizadorEventos_id implements VOOrganizadorEventos_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	 
	//numero de documento
	private Long idOE;
	
	// Tipo de documento
	private String nombreOE;

	

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public OrganizadorEventos_id() 
	{
        this.idOE = 0L;
		this.nombreOE = "";
	}
	/**
	 * Constructor con valores
	 */
	public OrganizadorEventos_id( Long idOE, String nombreOE)
	{
        this.idOE = idOE;
		this.nombreOE = nombreOE;
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
	public String getNombreOE() 
	{
		return nombreOE;
	}


	public void setNombreOE(String nombreOE) 
	{
		this.nombreOE = nombreOE;
	}



	@Override
	public String toString() 
	{
		return "OrganizadoEventos_id [idOE =" + idOE +", nombreOE =" + nombreOE + "]";
	}

}