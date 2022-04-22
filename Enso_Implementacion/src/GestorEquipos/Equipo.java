package GestorEquipos;

import java.util.ArrayList;
import java.util.Objects;

import GestorUsuarios.Usuario;

public class Equipo implements InterfazEquipo{
	
	private Integer idEquipo;
	private String centro;
	private Integer activo;
	private InterfazGestorEquipos IGEquipos;
	private ArrayList<Usuario> usuarios;
	
	//Constructor
	public Equipo(Integer idEquipo, String centro, InterfazGestorEquipos iGEquipos) {
		super();
		this.idEquipo = idEquipo;
		this.centro = centro;
		this.activo = 0;
		this.IGEquipos = iGEquipos;
		this.usuarios = new ArrayList<Usuario>();
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
	public Boolean anhadirUsuario(Usuario usuario) {
		try {
			this.usuarios.add(usuario);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean activar() {
		try {
			this.activo = 1;
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean desactivar() {
		try {
			this.activo = 0;
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	//Getters y Setters
	public Integer getIdEquipo() {
		return idEquipo;
	}
	
	public String getCentro() {
		return centro;
	}
	
	public Integer getActivo() {
		return activo;
	}
	
	public ArrayList<Usuario> getUsuarios() {
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