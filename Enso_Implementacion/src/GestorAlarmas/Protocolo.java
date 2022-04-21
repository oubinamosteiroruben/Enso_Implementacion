package GestorAlarmas;

import java.util.List;

public class Protocolo {
	
	private final Integer idProtocolo;
	private final String tipoAlarma;
	private List<String> acciones;

	public Protocolo(Integer idProtocolo, String tipoAlarma, List<String> acciones) {
		this.idProtocolo = idProtocolo;
		this.tipoAlarma = tipoAlarma;
		this.acciones = acciones;
	}

	public List<String> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<String> acciones) {
		this.acciones = acciones;
	}

	public Integer getIdProtocolo() {
		return idProtocolo;
	}

	public String getTipoAlarma() {
		return tipoAlarma;
	}
		
}
