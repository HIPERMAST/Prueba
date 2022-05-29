

package uniandes.isis2304.parranderos.negocio;

public class Hotel implements VOHotel
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	// Id
	private Integer idHotel;	
	
    //Nombre
	private String nombreHotel;
	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
     /**
	 * Constructor por defecto
	 */
	public Hotel() 
	{
		this.idHotel = 0;
		this.nombreHotel = "";
	}

	/**
	 * Constructor con valores
	 */
	public Hotel(Integer idHotel, String nombreHotel) 
	{
		this.idHotel = idHotel;
		this.nombreHotel = nombreHotel;
		
	}

    //getters y setters

    //id
	public Integer getIdHotel() 
	{
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) 
	{
		this.idHotel = idHotel;
	}

	
    //nombre
	public String getNombre() 
	{
		return nombreHotel;
	}

	public void setNombre(String nombreHotel) 
	{
		this.nombreHotel = nombreHotel;
	}

	
	@Override
	public String toString() 
	{
		return "Hotel [id=" + idHotel + ", nombre=" + nombreHotel + "]";
	}

	
}
