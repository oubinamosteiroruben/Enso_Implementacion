package GestorEquipos;

import GestorUsuarios.Usuario;

public interface InterfazEquipo{
	
	public Boolean enviarOrden(String orden);
	
	Boolean modificarCentro(String centro);
	
	Boolean anhadirUsuario(Usuario usuario);
	
	Boolean activar();
	
	Boolean desactivar();
	
}