package uniandes.isis2304.parranderos.negocio;

public class AdminData_id implements VOAdminData_id
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Long id;

	//
	private String nombre;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public AdminData_id() 
	{
		this.id = 0L;
		this.nombre = "";
	}

	/**
	 * Constructor con valores
	 */
	public AdminData_id(Long id, String nombre) 
	{
		this.id = id;
		this.nombre = nombre;
	}

	//
	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	//
	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	

	@Override
	public String toString() 
	{
		return "Cliente_id [id =" + id + ", nombre =" + nombre + "]";
	}
	
}
