package GestorEquipos;

import java.util.ArrayList;
import java.util.HashMap;

import GestorAlarmas.Protocolo;
import GestorEstadisticas.InterfazGestorEstadisticas;
import GestorUsuarios.InterfazGestorUsuarios;
import GestorUsuarios.InterfazUsuario;

public class GestorEquipos implements InterfazGestorEquipos{
	
	private int idsEquipos = 0;
	
	private HashMap<Integer,InterfazEquipo> IEquipos;
	private InterfazGestorEstadisticas IGEstadisticas;
	private InterfazGestorUsuarios IGUsuarios;
	private ArrayList<Protocolo> protocolos;
	
	private static InterfazGestorEquipos gestorEquipos;
	
	//Constructor
	public GestorEquipos() {
		super();
		this.IGEstadisticas = InterfazGestorEstadisticas.getInstance();
		this.IGUsuarios = InterfazGestorUsuarios.getInstance();
		this.IEquipos = new HashMap<Integer,InterfazEquipo>();
		this.protocolos = new ArrayList<Protocolo>();
	}
	
	public static InterfazGestorEquipos getInstance() {
		if(gestorEquipos == null) {
			gestorEquipos = (InterfazGestorEquipos) new GestorEquipos();
		}
		return gestorEquipos;
	}
	
	//Metodos de la interfaz
	@Override
	public Boolean anhadirEquipo(String centro) {
		try {
			int id = idsEquipos++;
			InterfazEquipo nuevoEquipo = (InterfazEquipo) new Equipo(id,centro,this);
			this.IEquipos.put(id, nuevoEquipo);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean modificarEquipo(Integer idEquipo, String centro) {
		try {
			this.IEquipos.get(idEquipo).modificarCentro(centro);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean verificarDesalojo(Integer idEquipo, String centro) {
		return true;
	}
	
	//implementar
	@Override
	public Boolean enviarProtocolo(Protocolo protocolo) {
		try {
			this.protocolos.add(protocolo);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean modificarEstadoAlarma(Integer idAlarma, String estado) {
		return true;
	}
	
	@Override
	public Boolean anhadirUsuarioEquipo(InterfazUsuario usuario, Integer idEquipo) {
		try {
			this.IEquipos.get(idEquipo).anhadirUsuario(usuario);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean activarEquipo(Integer idEquipo) {
		try {
			this.IEquipos.get(idEquipo).activar();
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	//Getters
	public HashMap<Integer,InterfazEquipo> getIEquipos() {
		return IEquipos;
	}
	
	public InterfazGestorEstadisticas getIGEstadisticas() {
		return IGEstadisticas;
	}
	
	public InterfazGestorUsuarios getIGUsuarios() {
		return IGUsuarios;
	}
	
}