package GestorUsuarios;

public interface InterfazGestorUsuarios {

	
	public boolean anhadirUsuario(String dni, String nombre, String telefono, String email, String centro, String zona, String capacitacion, String estado);
	
	public boolean modificarUsuario(String dni, String nombre, String telefono, String email, String centro, String zona, String capacitacion, String estado);
	
	public boolean eliminarUsuario(String dni);
	
	public boolean modificarEstadoUsuario(String dni, String estado);
	
	public boolean modificarCentroUsuario(String dni, String centro, String zona);
	
	public boolean modificarCapacitacionUsuario(String dni, String capacitacion);
	
	public boolean modificarZonaUsuario(String dni, String zona);
	
	public boolean anhadirAlarma(String tipo, String centro, String estado);
	
	public boolean enviarMensajeAccion(String dni, String accion);
	
	public static InterfazGestorUsuarios getInstance() {
		return GestorUsuarios.getInstance();
	}
	
	
	
	
	
	
	
	
	
	
}
