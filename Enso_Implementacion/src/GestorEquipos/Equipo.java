package GestorEquipos;

import java.util.HashMap;
import java.util.Objects;

import GestorUsuarios.InterfazUsuario;

public class Equipo implements InterfazEquipo{
	
	private Integer idEquipo;
	private String centro;
	private InterfazGestorEquipos IGEquipos;
	private HashMap<String,InterfazUsuario> usuarios;
	
	//Constructor
	public Equipo(Integer idEquipo, String centro) {
		super();
		this.idEquipo = idEquipo;
		this.centro = centro;
		this.IGEquipos = InterfazGestorEquipos.getInstance();
		this.usuarios = new HashMap<String,InterfazUsuario>();
	}
	
	//Metodos de la interfaz
	@Override
	public Boolean enviarOrden(String orden) {
		return true;
	}
	
	@Override
	public Boolean modificarCentro(String centro) {
		try {
			this.centro = centro;
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean anhadirUsuario(InterfazUsuario usuario) {
		try {
			if(!this.usuarios.containsKey(usuario.getDni())) {
				if(usuario.getCentro().equals(this.centro)) {
					this.usuarios.put(usuario.getDni(), usuario);
					return true;
				}
			}
		}catch(Exception e) {
			return false;
		}
		return false;
	}
	
	@Override
	public Boolean activar() {
		try {
			for(InterfazUsuario u : this.usuarios.values()) {
				if(u.getEstado().equals("activa") || u.getEstado().equals("activo")) {
					return true;
				}
			}
		}catch(Exception e) {
			return false;
		}
		return false;
	}
	
	//Getters y Setters
	public Integer getIdEquipo() {
		return idEquipo;
	}
	
	public String getCentro() {
		return centro;
	}
	
	public HashMap<String,InterfazUsuario> getUsuarios() {
		return usuarios;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idEquipo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(idEquipo, other.idEquipo);
	}
	
}
