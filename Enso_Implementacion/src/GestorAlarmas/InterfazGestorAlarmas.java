package GestorAlarmas;

import java.util.Date;
import java.util.List;

public interface InterfazGestorAlarmas {
	
	public Boolean anhadirAlarma(Date fechaInicio, String tipo, String centro, String estado);
	
	public Boolean cerrarAlarma(Integer idAlarma);
	
	public Boolean modificarEstadoAlarma(Integer idAlarma, String estado);
	
	public Boolean anhadirProtocolo(String tipoAlarma, List<String> acciones);

	public Boolean anhadirCentralita(String centro);

}
