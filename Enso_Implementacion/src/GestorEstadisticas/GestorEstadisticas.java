package GestorEstadisticas;

import GestorAlarmas.InterfazAlarma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestorEstadisticas implements InterfazGestorEstadisticas{
	
	private ArrayList<Estadistica> estadisticas;
	private ArrayList<InterfazAlarma> alarmasResueltas;

	
	// Constructor
	public GestorEstadisticas() {
		this.estadisticas = new ArrayList<>();
		this.alarmasResueltas = new ArrayList<>();
	}

	
	// Getters y Setters
	public ArrayList<Estadistica> getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(ArrayList<Estadistica> estadisticas) {
		if(estadisticas != null) {
			this.estadisticas = estadisticas;
		}
	}
	
	public ArrayList<InterfazAlarma> getAlarmasResueltas() {
		return alarmasResueltas;
	}

	public void setAlarmas(ArrayList<InterfazAlarma> alarmasResueltas) {
		if(alarmasResueltas != null) {
			this.alarmasResueltas = alarmasResueltas;
		}
	}
	
	
	// Metodos
	public Boolean anhadirVerificacionDesalojo(String centro, String zona, String dniUsuario) {
		if(centro != null && zona != null && dniUsuario != null) {
			ArrayList<String> results = new ArrayList<>();
			results.add("Centro:" + centro);
			results.add("Zona:" + zona);
			results.add("Usuario:" + dniUsuario);
			
			this.estadisticas.add(new Estadistica(TIPO_ESTADISTICA.VERIFICACION, results));
			return true;
		}
		return false;
	}
	
	public Boolean anhadirAccion(String accion) {
		if(accion != null) {
			ArrayList<String> results = new ArrayList<>();
			results.add("Accion:" + accion);
			
			this.estadisticas.add(new Estadistica(TIPO_ESTADISTICA.ACCION, results));
			return true;
		}
		return false;
	}
	
	public Boolean anhadirAlarma(InterfazAlarma alarma) {
		if(alarma != null) {
			this.alarmasResueltas.add(alarma);
			return true;
		}
		return false;
	}
	
	// devuelve el tiempo en milisegundos
	public float getDuracionMediaAlarmas() {
		long resultado = 0;
		int contador = 0;
		for(InterfazAlarma alarma: this.alarmasResueltas) {
			if(alarma.getFechaInicio() != null && alarma.getFechaCierre() != null) {
				resultado += alarma.getFechaCierre().getTime() - alarma.getFechaInicio().getTime();
				contador++;
			}
		}
		return resultado/((float)contador);
	}
	
	public String getCentroMasAlarmas() {
		Map<String, Integer> repeticiones = new HashMap<>();
		for (InterfazAlarma alarma: this.alarmasResueltas) {
			String centro = alarma.getCentro();
			if(repeticiones.containsKey(centro)) {
				repeticiones.put(centro, repeticiones.get(centro)+1);
			} else {
				repeticiones.put(centro, 1);
			}
		}
		
		String resultado = "";
		int maximo = 0;
		for (Map.Entry<String, Integer> entrada : repeticiones.entrySet()) {
			if(entrada.getValue() > maximo) {
				resultado = entrada.getKey();
			}
	    }
		
		return resultado;
	}
	
	public String getCentroMenosAlarmas() {
		Map<String, Integer> repeticiones = new HashMap<>();
		for (InterfazAlarma alarma: this.alarmasResueltas) {
			String centro = alarma.getCentro();
			if(repeticiones.containsKey(centro)) {
				repeticiones.put(centro, repeticiones.get(centro)+1);
			} else {
				repeticiones.put(centro, 1);
			}
		}
		
		String resultado = "";
		int minimo = Integer.MAX_VALUE;
		for (Map.Entry<String, Integer> entrada : repeticiones.entrySet()) {
			if(entrada.getValue() < minimo) {
				resultado = entrada.getKey();
			}
	    }
		
		return resultado;
	}
	
	
	
	
}
