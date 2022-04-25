package GestorAlarmas;

import java.util.Date;
import java.util.List;

public interface InterfazGestorAlarmas {
	
	public static final String ACTIVA = "ACTIVA";
	public static final String APAGADA = "APAGADA";

	public Boolean anhadirAlarma(String tipo, String centro, String estado);
	
	public Boolean cerrarAlarma(Integer idAlarma);
	
	public Boolean modificarEstadoAlarma(Integer idAlarma, String estado);
	
	public Boolean anhadirProtocolo(String tipoAlarma, List<String> acciones);

	public Boolean anhadirCentralita(String centro);
	
	public static InterfazGestorAlarmas getInstance() {
		return GestorAlarmas.getInstance();
	}

}
