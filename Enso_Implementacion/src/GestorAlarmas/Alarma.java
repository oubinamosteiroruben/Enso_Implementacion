package GestorAlarmas;

import java.util.Date;

public class Alarma implements InterfazAlarma{
	
	private final Integer idAlarma;
	private final Date fechaInicio;
	private final String tipo;
	private final String centro;
	private String estado;
	private Date fechaCierre;

	public Alarma(Integer idAlarma, Date fechaInicio, String tipo, String centro, String estado){
		this.idAlarma = idAlarma;
		this.fechaInicio = fechaInicio;
		this.tipo = tipo;
		this.centro = centro;
		this.estado = estado;
		this.fechaCierre = null;
	}

	public String getTipo() {
		return tipo;
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
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return this.estado;
	}
	

	@Override
	public Boolean modificarAlarma(String estado) {
		try {
			this.setEstado(estado);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean cerrarAlarma() {
		try {
			this.setFechaCierre(new Date(System.currentTimeMillis()));
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
}
