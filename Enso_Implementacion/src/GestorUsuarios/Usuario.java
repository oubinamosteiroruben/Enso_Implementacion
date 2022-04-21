package GestorUsuarios;

import java.util.Objects;

public class Usuario implements InterfazUsuario{
	private String dni;
	private String nombre;
	private String telefono;
	private String email;
	private String centro;
	private String zona;
	private String capacitacion;
	private String estado;
	private static InterfazGestorUsuarios IGUsuarios;
	
		
	public Usuario(String dni, String nombre, String telefono, String email, String centro, String zona,
			String capacitacion, String estado, InterfazGestorUsuarios iGUsuarios) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.centro = centro;
		this.zona = zona;
		this.capacitacion = capacitacion;
		this.estado = estado;
		IGUsuarios = iGUsuarios;
	}
	
	public boolean enviarMensajeAccion(String mensaje) {
		return true;
	}
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getCapacitacion() {
		return capacitacion;
	}
	public void setCapacitacion(String capacitacion) {
		this.capacitacion = capacitacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static InterfazGestorUsuarios getIGUsuarios() {
		return IGUsuarios;
	}

	public static void setIGUsuarios(InterfazGestorUsuarios iGUsuarios) {
		IGUsuarios = iGUsuarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
	
}
