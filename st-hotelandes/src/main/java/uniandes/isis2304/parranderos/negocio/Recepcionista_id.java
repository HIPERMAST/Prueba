package uniandes.isis2304.parranderos.negocio;

public class Recepcionista_id implements VORecepcionista_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Long idRecepcion;

	//
	private String nombreRecepcionista;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Recepcionista_id() 
	{
		this.idRecepcion = 0L;
		this.nombreRecepcionista = "";
	}

	/**
	 * Constructor con valores
	 */
	public Recepcionista_id(Long idRecepcion, String nombreRecepcionista) 
	{
		this.idRecepcion = idRecepcion;
		this.nombreRecepcionista = nombreRecepcionista;
	}

	//
	public Long getIdRecepcion() 
	{
		return idRecepcion;
	}

	public void setIdRecepcion(Long idRecepcion) 
	{
		this.idRecepcion = idRecepcion;
	}

	//
	public String getNombreRecepcionista() 
	{
		return nombreRecepcionista;
	}

	public void setNombreRecepcionista(String nombreRecepcionista) 
	{
		this.nombreRecepcionista = nombreRecepcionista;
	}
	

	@Override
	public String toString() 
	{
		return "Recepcionista_id [idRecepcion=" + idRecepcion + ", nombreRecepcionista =" + nombreRecepcionista + "]";
	}
	
}
