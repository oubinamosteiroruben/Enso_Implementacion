package GestorUsuarios;

import GestorAlarmas.InterfazGestorAlarmas;
import GestorEstadisticas.InterfazGestorEstadisticas;

public class Administrador {
	private InterfazGestorEstadisticas IGEstadisticas;
	private InterfazGestorAlarmas IGAlarmas;
	
	public Administrador() {
		IGAlarmas = InterfazGestorAlarmas.getInstance();
		IGEstadisticas = InterfazGestorEstadisticas.getInstance();
	}

	public InterfazGestorEstadisticas getIGEstadisticas() {
		return IGEstadisticas;
	}

	public void setIGEstadisticas(InterfazGestorEstadisticas iGEstadisticas) {
		IGEstadisticas = iGEstadisticas;
	}

	public InterfazGestorAlarmas getIGAlarmas() {
		return IGAlarmas;
	}

	public void setIGAlarmas(InterfazGestorAlarmas iGAlarmas) {
		IGAlarmas = iGAlarmas;
	}

	
	
	
	
}
