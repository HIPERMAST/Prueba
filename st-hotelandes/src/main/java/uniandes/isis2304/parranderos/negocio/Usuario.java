package uniandes.isis2304.parranderos.negocio;


public class Usuario implements VOUsuario
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//identificador del servicio
	private Long idUsuario;	
	
	//Nombre del servicio
	private String rolUsuario;
	
	//Debe exixtir un hotel con dicho identificador
	private Integer idHotel;

	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Usuario() 
	{
		this.idUsuario = 0L;
		this.rolUsuario = "";
		this.idHotel = 0;
	}

	/**
	 * Constructor con valores
	 */
	public Usuario(Long idUsuario, String rolUsuario, Integer idHotel) 
	{
		this.idUsuario = idUsuario;
		this.rolUsuario = rolUsuario;
		this.idHotel = idHotel;
		
	}

	//
	public Long getIdUsuario() 
	{
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) 
	{
		this.idUsuario = idUsuario;
	}

	//
	public String getRolUsuario() 
	{
		return rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) 
	{
		this.rolUsuario = rolUsuario;
	}

	//
	public Integer getIdHotel() 
	{
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) 
	{
		this.idHotel = idHotel;
	}

	/**
	 * @return Una cadena de caracteres con la información básica del servicio
	 */
	@Override
	public String toString() 
	{
		return "Usuario [idUsuario =" + idUsuario + ", rolUsuario =" + rolUsuario + ", idHotel =" + idHotel + "]";
	}
}
