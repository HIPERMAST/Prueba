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
 * Clase para modelar el concepto BAR del negocio de los Parranderos
 *
 * @author Germán Bravo
 */
public class Bar implements VOBar
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de los bares
	 */
	private Long id;
	
	/**
	 * El nombre del bar
	 */
	private String nombre;

	/**
	 * La ciudad donde se encuentra el bar
	 */
	private String ciudad;
	
	/**
	 * El presupuesto del bar (ALTO, MEDIO, BAJO)
	 */
	private String presupuesto;
	
	/**
	 * El número de sedes del bar en la ciudad
	 */
	private Integer cantSedes;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public Bar() 
    {
    	this.id = 0L;
		this.nombre = "";
		this.ciudad = "";
		this.presupuesto = "";
		this.cantSedes = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id del bart
	 * @param nombre - El nombre del bar
	 * @param ciudad - La ciudad del bar
	 * @param presupuesto - El presupuesto del bar (ALTO, MEDIO, BAJO)
	 * @param cantSedes - Las sedes del bar (Mayor que 0)
	 */
    public Bar(Long id, String nombre, String ciudad, String presupuesto, Integer cantSedes) 
    {
    	this.id = id;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.presupuesto = presupuesto;
		this.cantSedes = cantSedes;
	}

    /**
	 * @return El id del bar
	 */
	public Long getId() 
	{
		return id;
	}
	
	/**
	 * @param id - El nuevo id del bar
	 */
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	/**
	 * @return el nombre del bar
	 */
	public String getNombre() 
	{
		return nombre;
	}
	
	/**
	 * @param nombre El nuevo nombre del bar
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	/**
	 * @return la ciudad del bar
	 */
	public String getCiudad() 
	{
		return ciudad;
	}
	
	/**
	 * @param ciudad - La nueva ciudad del bar
	 */
	public void setCiudad(String ciudad) 
	{
		this.ciudad = ciudad;
	}
	
	/**
	 * @return El presupuesto del bar
	 */
	public String getPresupuesto() 
	{
		return presupuesto;
	}
	
	/**
	 * @param presupuesto - El nuevo presupuesto del bar (ALTO, MEDIO, BAJOO)
	 */
	public void setPresupuesto(String presupuesto) 
	{
		this.presupuesto = presupuesto;
	}
	
	/**
	 * @return la cantSedes del bar
	 */
	public Integer getCantSedes() 
	{
		return cantSedes;
	}
	
	/**
	 * @param cantSedes - la nueva cantidad de sedes del bar
	 */
	public void setCantSedes(Integer cantSedes) 
	{
		this.cantSedes = cantSedes;
	}
	
	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del bar
	 */
	public String toString() 
	{
		return "Bar [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", presupuesto=" + presupuesto
				+ ", cantSedes=" + cantSedes + "]";
	}
	

}
