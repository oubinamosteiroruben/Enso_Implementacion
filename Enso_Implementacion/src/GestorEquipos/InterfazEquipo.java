package GestorEquipos;

import GestorUsuarios.InterfazUsuario;

public interface InterfazEquipo{
	
	public Boolean enviarOrden(String orden);
	
	Boolean modificarCentro(String centro);
	
	Boolean anhadirUsuario(InterfazUsuario usuario);
	
	Boolean activar();
	
	Boolean contieneUsuario(InterfazUsuario usuario);
	
}