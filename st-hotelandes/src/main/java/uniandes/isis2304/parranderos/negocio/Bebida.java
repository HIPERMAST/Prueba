/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.parranderos.negocio;

/**
 * Clase para modelar el concepto BEBIDA del negocio de los Parranderos
 *
 * @author Germán Bravo
 */
public class Bebida implements VOBebida
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de la bebida
	 */
	private Long id;
	
	/**
	 * El nombre de la bebida
	 */
	private String nombre;
	
	/**
	 * El identificador del tipo de bebida de la bebida. Debe existir en la tabla de tipoBebida
	 */
	private Long idTipoBebida;
	
	/**
	 * El grado de alcohol de la bebida (Mayor que 0)
	 */
	private Integer gradoAlcohol;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Bebida() 
	{
		this.id = 0L;
		this.nombre = "";
		this.idTipoBebida = 0L;
		this.gradoAlcohol = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id de la bebida
	 * @param nombre - El nombre de la bebida
	 * @param tipo - El identificador del tipo de bebida
	 * @param gradoAlcohol - El graddo de alcohol de la bebida (Mayor que 0)
	 */
	public Bebida(Long id, String nombre, Long tipo, Integer gradoAlcohol) 
	{
		this.id = id;
		this.nombre = nombre;
		this.idTipoBebida = tipo;
		this.gradoAlcohol = gradoAlcohol;
	}

	/**
	 * @return El id de la bebida
	 */
	public Long getId() 
	{
		return id;
	}

	/**
	 * @param id - El nuevo id de la bebida 
	 */
	public void setId(Long id) 
	{
		this.id = id;
	}

	/**
	 * @return El nombre de la bebida
	 */
	public String getNombre() 
	{
		return nombre;
	}

	/**
	 * @param nombre - El nuevo nombre de la bebida
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	/**
	 * @return El id del Tipo de Bebida
	 */
	public Long getIdTipoBebida() 
	{
		return idTipoBebida;
	}

	/**
	 * @param tipoBebida El nuevo identificador de tipo de bebida
	 */
	public void setIdTipoBebida(Long tipoBebida) 
	{
		this.idTipoBebida = tipoBebida;
	}

	/**
	 * @return El gradoAlcohol de la bebida
	 */
	public Integer getGradoAlcohol() 
	{
		return gradoAlcohol;
	}

	/**
	 * @param gradoAlcohol El nuevo grado de alcohol de la bebida
	 */
	public void setGradoAlcohol(Integer gradoAlcohol) 
	{
		this.gradoAlcohol = gradoAlcohol;
	}

	/**
	 * @return Una cadena con la información básica de la bebida
	 */
	@Override
	public String toString() 
	{
		return "Bebida [id=" + id + ", nombre=" + nombre + ", idTipoBebida=" + idTipoBebida + ", gradoAlcohol=" + gradoAlcohol + "]";
	}

}
