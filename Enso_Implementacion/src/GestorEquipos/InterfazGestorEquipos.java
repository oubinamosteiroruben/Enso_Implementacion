package GestorEquipos;

import GestorUsuarios.Usuario;
import GestorAlarmas.Protocolo;

public interface InterfazGestorEquipos{
	
	public Boolean anhadirEquipo(String centro);
	
	public Boolean modificarEquipo(Integer idEquipo, String centro);
	
	public Boolean verificarDesalojo(Integer idEquipo, String centro);
	
	public Boolean enviarProtocolo(Protocolo protocolo);
	
	public Boolean modificarEstadoAlarma(Integer idAlarma, String estado);
	
	public Boolean anhadirUsuarioEquipo(Usuario usuario, Integer idEquipo);
	
	public Boolean activarEquipo(Integer idEquipo);
	
	public Boolean desactivarEquipo(Integer idEquipo);
	
}