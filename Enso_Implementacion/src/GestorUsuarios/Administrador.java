package GestorUsuarios;

import GestorAlarmas.InterfazGestorAlarmas;
import GestorEstadisticas.InterfazGestorEstadisticas;

public class Administrador {
	private static InterfazGestorEstadisticas IGEstadisticas;
	private static InterfazGestorAlarmas IGAlarmas;
	
	public Administrador(InterfazGestorAlarmas alarmas, InterfazGestorEstadisticas estadisticas) {
		IGAlarmas = alarmas;
		IGEstadisticas = estadisticas;
	}

	public static InterfazGestorEstadisticas getIGEstadisticas() {
		return IGEstadisticas;
	}

	public static void setIGEstadisticas(InterfazGestorEstadisticas iGEstadisticas) {
		IGEstadisticas = iGEstadisticas;
	}

	public static InterfazGestorAlarmas getIGAlarmas() {
		return IGAlarmas;
	}

	public static void setIGAlarmas(InterfazGestorAlarmas iGAlarmas) {
		IGAlarmas = iGAlarmas;
	}

	
	
	
	
}
