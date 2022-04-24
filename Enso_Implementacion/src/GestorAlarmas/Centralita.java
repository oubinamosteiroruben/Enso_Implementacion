package GestorAlarmas;

import java.util.Date;

public class Centralita implements InterfazCentralita{
	
	private final Integer idCentralita;
	private final String centro;
	private static InterfazGestorAlarmas IGAlarmas;

	public Centralita(Integer idCentralita, String centro, InterfazGestorAlarmas IGAlarmas) {
		this.idCentralita = idCentralita;
		this.centro = centro;
		this.IGAlarmas = IGAlarmas;
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

	/*public Boolean anhadirAlarma(Date fechaInicio, String tipo, String centro, String estado){
		return IGAlarmas.anhadirAlarma(fechaInicio, tipo, centro, estado);
	}*/

	
	public Boolean anhadirAlarma(String tipo, String centro, String estado){
		return IGAlarmas.anhadirAlarma(tipo, centro, estado);
	}



	
}


