import GestorAlarmas.InterfazGestorAlarmas;
import GestorEquipos.InterfazGestorEquipos;
import GestorEstadisticas.InterfazGestorEstadisticas;
import GestorUsuarios.InterfazGestorUsuarios;

public class MainPrueba {

	public static void main(String[] args) {
		InterfazGestorAlarmas gestorAlarmas = InterfazGestorAlarmas.getInstance();
		InterfazGestorUsuarios gestorUsuarios = InterfazGestorUsuarios.getInstance();
		InterfazGestorEstadisticas gestorEstadisticas = InterfazGestorEstadisticas.getInstance();
		InterfazGestorEquipos gestorEquipos = InterfazGestorEquipos.getInstance();

		gestorAlarmas.anhadirAlarma("incendio","ETSE","ON" );
	
	}

}
