package GestorUsuarios;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import GestorAlarmas.GestorAlarmas;
import GestorAlarmas.InterfazGestorAlarmas;

public class GestorUsuarios implements InterfazGestorUsuarios{
	private InterfazGestorAlarmas gestorAlarmas;
	private HashMap<String, InterfazUsuario> usuarios;
	
	private static InterfazGestorUsuarios gestorUsuarios;

	
	public GestorUsuarios() {
		super();
		gestorAlarmas = InterfazGestorAlarmas.getInstance();
		usuarios = new HashMap<>();
	}
	
	public static InterfazGestorUsuarios getInstance() {
		if(gestorUsuarios == null) {
			gestorUsuarios = (InterfazGestorUsuarios) new GestorUsuarios();
		}
		return gestorUsuarios;
	}
	
	
	public boolean anhadirUsuario(String dni, String nombre, String telefono, String email, String centro, String zona, String capacitacion, String estado) {
		if(dni != null && nombre != null && telefono != null && email != null && centro != null && zona != null && capacitacion != null && estado != null) {
			if(this.validarDni(dni) && validarTlf(telefono) && validarMail(email)){
				if(estado.equals("activa") || estado.equals("activo") || estado.equals("inactiva") || estado.equals("inactivo")) {
					InterfazUsuario usuario = new Usuario(dni, nombre, telefono, email, centro, zona, capacitacion, estado, this);
					usuarios.put(usuario.getDni(), usuario);
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean modificarUsuario(String dni, String nombre, String telefono, String email, String centro, String zona, String capacitacion, String estado) {
		InterfazUsuario usuario = null;
		usuario = usuarios.get(dni);
		if (usuario != null) {
			if(nombre != null) {
				usuario.setNombre(nombre);
			}
			if(telefono != null) {
				if(validarTlf(telefono)) {
					usuario.setTelefono(telefono);
				}else {
					return false;
				}
			}
			if(email != null) {
				if(validarMail(email)) {
					usuario.setEmail(email);
				}else {
					return false;
				}
			}
			if(centro != null) {
				usuario.setCentro(centro);
			}
			if(zona != null) {
				usuario.setZona(zona);
			}
			if(capacitacion != null) {
				usuario.setCapacitacion(capacitacion);
			}
			if(estado != null) {
				if(estado.equals("activa") || estado.equals("activo") || estado.equals("inactiva") || estado.equals("inactivo")) {
					usuario.setEstado(estado);
				}else {
					return false;
				}
			}
			
			return true;
		}else {
			return false;
		}
	}
	
	public boolean eliminarUsuario(String dni) {
		return true;
	}
	
	public boolean modificarEstadoUsuario(String dni, String estado) {
		return true;
	}
	
	public boolean modificarCentroUsuario(String dni, String centro, String zona) {
		return true;
	}
	
	public boolean modificarCapacitacionUsuario(String dni, String capacitacion) {
		return true;
	}
	
	public boolean modificarZonaUsuario(String dni, String zona) {
		return true;
	}
	
	public boolean anhadirAlarma(String tipo, String centro, String estado) {
		return true;
	}
	
	public boolean enviarMensajeAccion(String dni, String accion) {
		return true;
	}
	
	private boolean validarDni(String dni) {
			String letraMayuscula = ""; 
			if(dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false ) {
				return false;
			}
	
			letraMayuscula = (dni.substring(8)).toUpperCase();
	
			if(soloNumeros(dni) == true && letraDNI(dni).equals(letraMayuscula)) {
				return true;
			}
			else {
				return false;
			}
	}

	private boolean soloNumeros(String dni) {
	
		int i, j = 0;
		String numero = ""; 
		String miDNI = "";
		String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};
	
		for(i = 0; i < dni.length() - 1; i++) {
			numero = dni.substring(i, i+1);
	
			for(j = 0; j < unoNueve.length; j++) {
				if(numero.equals(unoNueve[j])) {
					miDNI += unoNueve[j];
				}
			}
		}
	
		if(miDNI.length() != 8) {
			return false;
		}
		else {
			return true;
		}
	}

	private String letraDNI(String dni) {
	
		int miDNI = Integer.parseInt(dni.substring(0,8));
		int resto = 0;
		String miLetra = "";
		String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
	
		resto = miDNI % 23;
	
		miLetra = asignacionLetra[resto];
	
		return miLetra;
	}
    public boolean validarMail(String email) {
	    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                    + "[A-Za-z]+(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,})$");
	
	    Matcher mather = pattern.matcher(email);
	
	    return (mather.find());
	}
	
	private boolean validarTlf(String tlf){
		 
        Pattern p = Pattern.compile("^\\d{9}$");
        Matcher m = p.matcher(tlf);

        return (m.matches());
    }



	public static InterfazGestorAlarmas getAlarmas() {
		return alarmas;
	}

	public static void setAlarmas(InterfazGestorAlarmas alarmas) {
		GestorUsuarios.alarmas = alarmas;
	}



	public static HashMap<String, InterfazUsuario> getUsuarios() {
		return usuarios;
	}



	public static void setUsuarios(HashMap<String, InterfazUsuario> usuarios) {
		GestorUsuarios.usuarios = usuarios;
	}

	
		
}
