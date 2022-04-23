package GestorUsuarios;

public interface InterfazUsuario {

	public boolean enviarMensajeAccion(String mensaje);
	
	public String getDni();
	
	public void setNombre(String nombre);
	
	public void setTelefono(String telefono);
	
	public void setEmail(String email);
	
	public void setCentro(String centro);
	
	public void setZona(String zona);
	
	public void setCapacitacion(String capacitacion);
	
	public void setEstado(String estado);
	
	public String getEstado();
}
