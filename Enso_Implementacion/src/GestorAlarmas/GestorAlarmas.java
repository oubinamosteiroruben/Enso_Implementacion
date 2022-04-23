package GestorAlarmas;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import GestorEstadisticas.InterfazGestorEstadisticas;

public class GestorAlarmas implements InterfazGestorAlarmas{
	
	private static Integer contadorAlarmas = 0;
	//private static Integer contadorProtocolos = 0;
	private static Integer contadorCentralitas = 0;
	
	private HashMap<Integer,InterfazCentralita> centralitas;
	private HashMap<Integer,InterfazAlarma> alarmas;
	private InterfazGestorEstadisticas gestorEstadisticas;
	private InterfazGestorEquipos gestorEquipos;
	
	
	public GestorAlarmas() {
		this.centralitas = new HashMap<>();
		this.alarmas = new HashMap<>();
		this.protocolos = new ArrayList<>();
	}


	@Override
	public Boolean anhadirAlarma(Date fechaInicio, String tipo, String centro, String estado) {
		try {
			InterfazAlarma ia = (InterfazAlarma) new Alarma(contadorAlarmas++,fechaInicio,tipo,centro,estado);
			this.alarmas.put(ia.getIdAlarma(),ia);
			this.gestorEstadisticas.anhadirAlarma(ia);
		}catch(Exception e) {
			return false;
		}
		return true;
	}


	@Override
	public Boolean cerrarAlarma(Integer idAlarma) {
		return this.alarmas.get(idAlarma).cerrarAlarma();
	}


	@Override
	public Boolean modificarEstadoAlarma(Integer idAlarma, String estado) {
		return this.alarmas.get(idAlarma).modificarAlarma(estado);
	}


	@Override
	public Boolean anhadirProtocolo(String tipoAlarma, List<String> acciones) {
		
		//return 	this.gestorEquipos.anhadirProtocolo(new Protocolo(contadorProtocolos++,tipoAlarma,acciones));
		return this.gestorEquipos.anhadirProtocolo(tipoAlarma, acciones); // que el contador esté en el gestor de equipos
		
	}


	@Override
	public Boolean anhadirCentralita(String centro) {
		try {
			InterfazCentralita ic = (InterfazCentralita) new Centralita(contadorCentralitas++,centro,this);
			this.centralitas.put(ic.getIdCentralita(),ic);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	// Getters 

	public HashMap<Integer,InterfazCentralita> getCentralitas(){
		return this.centralitas;
	}

	public HashMap<Integer,InterfazAlarma> getAlarmas(){
		return this.alarmas;
	}

	public InterfazGestorEstadisticas getGestorEstadisticas(){
		return this.gestorEstadisticas;
	}

	public InterfazGestorEquipos getGestorEquipos(){
		return this.gestorEquipos;
	}

}
