package GestorUsuarios;

public class Administrador {
	private InterfazGestorEstadisticas IGEstadisticas;
	private InterfazGestorAlarmas IGAlarmas;
	
	public Administrador(InterfazGestorAlarmas IGAlarmas, InterfazGestorEstadisticas IGEstadisticas) {
		this.IGAlarmas = IGAlarmas;
		this.IGEstadisticas = IGEstadisticas;
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
