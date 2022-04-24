package GestorAlarmas;

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
	public static Boolean anhadirAlarma(Date fechaInicio, String tipo, String centro, String estado) {
		
		try {
			
			/*Comprobación de los parámetros*/
			
			if(tipo.equals("") || centro.equals("") || estado.equals("")) { /* en tipo, estado se podrían poner constantes */
				return false;
			}
			
			InterfazAlarma ia = (InterfazAlarma) new Alarma(contadorAlarmas++,fechaInicio,tipo,centro,estado);
			alarmas.put(ia.getIdAlarma(),ia);
			gestorEstadisticas.anhadirAlarma(ia);
		}catch(Exception e) {
			return false;
		}
		return true;
	}


	@Override
	public Boolean cerrarAlarma(Integer idAlarma) {
		try {
			return this.alarmas.get(idAlarma).cerrarAlarma();
		}catch(Exception e) {
			return false;
		}	
	}


	@Override
	public Boolean modificarEstadoAlarma(Integer idAlarma, String estado) {
		try {
			if(estado.equals("")) {
				return false;
			}
			return this.alarmas.get(idAlarma).modificarAlarma(estado);
		}catch(Exception e) {
			return false;
		}
		
	}


	@Override
	public Boolean anhadirProtocolo(String tipoAlarma, List<String> acciones) {
		
		try {
			if(tipoAlarma.equals("") || acciones.length() == 0) {
				return false;
			}
			
			for(String a: acciones) { // Las acciones no pueden ser vacías
				if(a.equals("")) {
					return false;
				}
			}
			
			//return 	this.gestorEquipos.anhadirProtocolo(new Protocolo(contadorProtocolos++,tipoAlarma,acciones));
			return this.gestorEquipos.anhadirProtocolo(tipoAlarma, acciones); // que el contador estÃ© en el gestor de equipos
			
		}catch(Exception e) {
			return false;
		}
		
		
	}


	@Override
	public Boolean anhadirCentralita(String centro) {
		
		try {
			
			if(centro.equals("")) {
				return false;
			}
			
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
