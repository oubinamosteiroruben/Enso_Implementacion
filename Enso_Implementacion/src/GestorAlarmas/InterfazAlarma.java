package GestorAlarmas;

import java.util.Date;

public interface InterfazAlarma {
	
	public Boolean modificarAlarma(String estado);
	
	public Boolean cerrarAlarma();
	
	public String getTipo();

	public Date getFechaCierre();

	public Integer getIdAlarma();

	public Date getFechaInicio() ;

	public String getCentro();
	
	public void setEstado(String estado);
	
	public String getEstado();
	
}
