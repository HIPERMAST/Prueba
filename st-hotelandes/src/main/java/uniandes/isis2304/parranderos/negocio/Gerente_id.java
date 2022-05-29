package uniandes.isis2304.parranderos.negocio;

public class Gerente_id implements VOGerente_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Long idGerente;

	//
	private String nombreGerente;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Gerente_id() 
	{
		this.idGerente = 0L;
		this.nombreGerente = "";
	}

	/**
	 * Constructor con valores
	 */
	public Gerente_id(Long idGerente, String nombreGerente) 
	{
		this.idGerente = idGerente;
		this.nombreGerente = nombreGerente;
	}

	//
	public Long getIdGerente() 
	{
		return idGerente;
	}

	public void setIdGerente(Long idGerente) 
	{
		this.idGerente = idGerente;
	}

	//
	public String getNombreGerente() 
	{
		return nombreGerente;
	}

	public void setNombreGerente(String nombreGerente) 
	{
		this.nombreGerente = nombreGerente;
	}
	

	@Override
	public String toString() 
	{
		return "Gerente_id [idGerente=" + idGerente + ", nombreGerente =" + nombreGerente + "]";
	}
	
}
