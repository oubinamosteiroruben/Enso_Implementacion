package GestorEquipos;

import GestorUsuarios.InterfazUsuario;
import GestorAlarmas.Protocolo;

public interface InterfazGestorEquipos{
	
	public Boolean anhadirEquipo(String centro);
	
	public Boolean modificarEquipo(Integer idEquipo, String centro);
	
	public Boolean verificarDesalojo(Integer idEquipo, String centro);
	
	public Boolean enviarProtocolo(Protocolo protocolo);
	
	public Boolean modificarEstadoAlarma(Integer idAlarma, String estado);
	
	public Boolean anhadirUsuarioEquipo(InterfazUsuario usuario, Integer idEquipo);
	
	public Boolean activarEquipo(Integer idEquipo);
	
	public static InterfazGestorEquipos getInstance() {
		return GestorEquipos.getInstance();
	}
	
}