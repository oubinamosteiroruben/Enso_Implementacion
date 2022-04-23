package GestorAlarmas;

public class Centralita implements InterfazCentralita{
	
	private final Integer idCentralita;
	private final String centro;
	private final InterfazGestorAlarmas gestorAlarmas;

	public Centralita(Integer idCentralita, String centro, InterfazGestorAlarmas gestorAlarmas) {
		this.idCentralita = idCentralita;
		this.centro = centro;
		this.gestorAlarmas = gestorAlarmas;
	}

	@Override
	public Boolean activaSirena() {
		// Se devuelve true por el momento
		return true;
	}

	public Integer getIdCentralita() {
		return idCentralita;
	}

	public String getCentro() {
		return centro;
	}	

	/*
	Elegir una de las dos
	*/

	public Boolean anhadirAlarma(Date fechaInicio, String tipo, String centro, String estado){
		return gestorAlarmas.anhadirAlarma(fechaInicio, tipo, centro, estado);
	}

	
	public Boolean anhadirAlarma(String tipo, String centro, String estado){
		return gestorAlarmas.anhadirAlarma(new Date(System.currentTimeMillis()), tipo, centro, estado);
	}



	
}


