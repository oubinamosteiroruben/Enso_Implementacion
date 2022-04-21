package GestorAlarmas;

import java.util.Date;

public class Alarma implements InterfazAlarma{
	
	private final Integer idAlarma;
	private final Date fechaInicio;
	private String tipo;
	private final String centro;
	private Date fechaCierre;

	public Alarma(Integer idAlarma, Date fechaInicio, String tipo, String centro, String estado, String fechaCierre){
		this.idAlarma = idAlarma;
		this.fechaInicio = fechaInicio;
		this.tipo = tipo;
		this.centro = centro;
		this.fechaCierre = null;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Integer getIdAlarma() {
		return idAlarma;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public String getCentro() {
		return centro;
	}

	@Override
	public Boolean modificarAlarma(String estado) {
		this.estado = estado;
		return null;
	}

	@Override
	public Boolean cerrarAlarma() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
