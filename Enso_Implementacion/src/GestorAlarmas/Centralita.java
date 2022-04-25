package GestorAlarmas;

public class Centralita implements InterfazCentralita{
	
	private final Integer idCentralita;
	private final String centro;
	private InterfazGestorAlarmas IGAlarmas;

	public Centralita(Integer idCentralita, String centro) {
		this.idCentralita = idCentralita;
		this.centro = centro;
		this.IGAlarmas = InterfazGestorAlarmas.getInstance();
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
	
	public Boolean anhadirAlarma(String tipo, String centro, String estado){
		return IGAlarmas.anhadirAlarma(tipo, centro, estado);
	}



	
}


