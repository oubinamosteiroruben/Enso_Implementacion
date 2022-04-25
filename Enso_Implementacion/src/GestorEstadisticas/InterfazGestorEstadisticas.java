package GestorEstadisticas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import GestorAlarmas.Alarma;
import GestorAlarmas.GestorAlarmas;
import GestorAlarmas.InterfazGestorAlarmas;

public interface InterfazGestorEstadisticas {
	
	// devuelve true si se anhade correctamente, false en otro caso
	public Boolean anhadirVerificacionDesalojo(String centro, String zona, String dniUsuario);
	
	// devuelve true si se anhade correctamente, false en otro caso
	public Boolean anhadirAccion(String accion);
	
	// devuelve true si se anhade correctamente, false en otro caso
	public Boolean anhadirAlarma(Alarma alarma);
	
	// devuelve la lista de alarmas resueltas
	public ArrayList<Alarma> getAlarmasResueltas();
	
	// devuelve el tiempo en milisegundos
	public float getDuracionMediaAlarmas();
	
	// devuelve el centro con mas alarmas resueltas, o "" si no hay alarmas
	public String getCentroMasAlarmas();
	
	// devuelve el centro con menos alarmas resueltas, o "" si no hay alarmas
	public String getCentroMenosAlarmas();

	// devuelve la instancia de la interfaz de gestorEstadisticas
	public static InterfazGestorEstadisticas getInstance() {
		return GestorEstadisticas.getInstance();
	}
}
