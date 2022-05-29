package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

public class ServicioXCliente implements VOServicioXCliente
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/

	 
	//
	private Integer historial;
	
	//Fecha y hora de el consumo
	private Timestamp fecha;
	
	//identificador del cliente
	private Long idCliente;

	//id del servicio utilizado
	private Integer idServicio;

	//
	private Integer idEspecifico;

	//Cantidad de visitas por parte del cliente
	private Integer cantVisitas;

	//Costo del servicio
	private Integer costo;

	

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public ServicioXCliente() 
	{
        this.historial = 0;
		this.fecha = new Timestamp (0);
		this.idCliente = 0L;
		this.idServicio = 0;
		this.idEspecifico = 0;
		this.cantVisitas = 0;
		this.costo = 0;
	}

	/**
	 * Constructor con valores
	 */
	public ServicioXCliente(Integer historial, Timestamp fecha, Long idCliente, Integer idServicio, Integer idEspecifico, Integer cantVisitas, Integer costo)
	{
        this.historial = historial;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.idServicio = idServicio;
		this.idEspecifico = idEspecifico;
		this.cantVisitas = cantVisitas;
		this.costo = costo;
	}

	//Historial
	public Integer getHistorial() 
	{
		return historial;
	}

	public void setHistorial(Integer historial) 
	{
		this.historial = historial;
	}
	
	//Tipo de documento
	public Timestamp getFecha() 
	{
		return fecha;
	}


	public void setFecha(Timestamp fecha) 
	{
		this.fecha = fecha;
	}

	//idCliente
	public Long getIdCliente() 
	{
		return idCliente;
	}

	public void setIdCliente(Long idCliente) 
	{
		this.idCliente = idCliente;
	}

	//Contraseña
	public Integer getIdServicio() 
	{
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) 
	{
		this.idServicio = idServicio;
	}

	//idEspecifico
	public Integer getIdEspecifico() 
	{
		return idEspecifico;
	}

	public void setIdEespecifico(Integer idEspecifico) 
	{
		this.idEspecifico = idEspecifico;
	}

	//cantVisitas
	public Integer getCantVisitas() 
	{
		return cantVisitas;
	}

	public void setCantVisitas(Integer cantVisitas) 
	{
		this.cantVisitas = cantVisitas;
	}

	//costo
	public Integer getCosto() 
	{
		return costo;
	}

	public void setCosto(Integer costo) 
	{
		this.costo = costo;
	}


	@Override
	public String toString() 
	{
		return "AministradorDatos [historial =" + historial + ", fecha =" + fecha +
			   ", idCliente =" + idCliente + ", idServicio =" + idServicio + ", idEspecifico =" + idEspecifico + ", cantVisitas =" + cantVisitas + ", costo =" + costo + "]";
	}

}