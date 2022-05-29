package uniandes.isis2304.parranderos.negocio;

public class Cliente_id implements VOCliente_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Long numeroDocumento;

	//
	private String nombreCliente;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Cliente_id() 
	{
		this.numeroDocumento = 0L;
		this.nombreCliente = "";
	}

	/**
	 * Constructor con valores
	 */
	public Cliente_id(Long numeroDocumento, String nombreCliente) 
	{
		this.numeroDocumento = numeroDocumento;
		this.nombreCliente = nombreCliente;
	}

	//
	public Long getNumeroDocumento() 
	{
		return numeroDocumento;
	}

	public void setNumeroDocumento(Long numeroDocumento) 
	{
		this.numeroDocumento = numeroDocumento;
	}

	//
	public String getNombreCliente() 
	{
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) 
	{
		this.nombreCliente = nombreCliente;
	}
	

	@Override
	public String toString() 
	{
		return "Cliente_id [numeroDocumento=" + numeroDocumento + ", nombreCliente=" + nombreCliente + "]";
	}
	
}
