package uniandes.isis2304.parranderos.negocio;

public class Empleado_id implements VOEmpleado_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Long idEmpleado;

	//
	private String nombreEmpleado;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Empleado_id() 
	{
		this.idEmpleado = 0L;
		this.nombreEmpleado = "";
	}

	/**
	 * Constructor con valores
	 */
	public Empleado_id(Long idEmpleado, String nombreEmpleado) 
	{
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
	}

	//
	public Long getIdEmpleado() 
	{
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) 
	{
		this.idEmpleado = idEmpleado;
	}

	//
	public String getNombreEmpleado() 
	{
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) 
	{
		this.nombreEmpleado = nombreEmpleado;
	}
	

	@Override
	public String toString() 
	{
		return "Empleado_id [idEmpleado =" + idEmpleado + ", nombreEmpleado =" + nombreEmpleado + "]";
	}
	
}
