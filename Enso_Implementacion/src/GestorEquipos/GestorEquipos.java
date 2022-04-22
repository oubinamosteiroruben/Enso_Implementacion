package GestorEquipos;

import java.util.HashMap;

import GestorAlarmas.Protocolo;
import GestorEstadisticas.InterfazGestorEstadisticas;
import GestorUsuarios.InterfazGestorUsuarios;
import GestorUsuarios.Usuario;

public class GestorEquipos implements InterfazGestorEquipos{
	
	private static int idsEquipos = 0;
	
	private HashMap<Integer,InterfazEquipo> IEquipos;
	private static InterfazGestorEstadisticas IGEstadisticas;
	private static InterfazGestorUsuarios IGUsuarios;
	
	//Constructor
	public GestorEquipos(InterfazGestorEstadisticas iGEstadisticas, InterfazGestorUsuarios iGUsuarios) {
		super();
		IGEstadisticas = iGEstadisticas;
		IGUsuarios = iGUsuarios;
		IEquipos = new HashMap<Integer,InterfazEquipo>();
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
		return null;
	}
	
	@Override
	public Boolean modificarEstadoAlarma(Integer idAlarma, String estado) {
		return true;
	}
	
	@Override
	public Boolean anhadirUsuarioEquipo(Usuario usuario, Integer idEquipo) {
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

	@Override
	public Boolean desactivarEquipo(Integer idEquipo) {
		try {
			this.IEquipos.get(idEquipo).desactivar();
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