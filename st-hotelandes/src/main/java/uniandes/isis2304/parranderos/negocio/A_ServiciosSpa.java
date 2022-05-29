package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

public class A_ServiciosSpa implements VOA_ServiciosSpa
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	//
	private Integer idSPA;

	//
	private String nombre;

	//
	private Timestamp duracion;

	//
	private Integer costo;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public A_ServiciosSpa() 
	{
		this.idSPA = 0;
		this.nombre = "";
		this.duracion = new Timestamp (0);
		this.costo = 0;
	}

	/**
	 * Constructor con valores
	 */
	public A_ServiciosSpa(Integer idSPA, String nombre, Timestamp duracion, Integer costo) 
	{
		this.idSPA = idSPA;
		this.nombre = nombre;
		this.duracion = duracion;
		this.costo = costo;
	}

	//
	public Integer getIdSpa() 
	{
		return idSPA;
	}

	public void setIdSpa(Integer idSPA) 
	{
		this.idSPA = idSPA;
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

	//
	public Timestamp  getDuracion() 
	{
		return duracion;
	}

	public void setDuracion(Timestamp duracion) 
	{
		this.duracion = duracion;
	}


	//
	public Integer getCosto() 
	{
		return costo;
	}

	public void setCosto(Integer costo) 
	{
		this.costo = costo;
	}

	/** 
	 * @return Una cadena con la información básica del servicio piscina
	 */
	@Override
	public String toString() 
	{
		return "A_ServiciosSpa [idSPA =" + idSPA + ", duracion = " + duracion + ", nombre = " + nombre + 
		", costo = " + costo + "]";
	}
}
