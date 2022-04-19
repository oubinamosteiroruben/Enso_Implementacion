package GestorEstadisticas;

import java.util.ArrayList;
import java.util.Date;

public enum TIPO_ESTADISTICA{
	VERIFICACION, ACCION
}

public class Estadistica {

	private static int contador = 0; 
	
	private int idEstadistica;
	private Date fechaEstadistica;
	private TIPO_ESTADISTICA tipo;
	private ArrayList<String> resultados;
	
	
	// Constructor
	public Estadistica(TIPO_ESTADISTICA tipo, ArrayList<String> resultados) {
		this.tipo = tipo;
		if(resultados != null) {
			this.resultados = resultados;
		}
		
		this.setIdEstadistica(contador++);
		this.fechaEstadistica = new Date(System.currentTimeMillis());;
	}


	// Getters y Setters
	public int getIdEstadistica() {
		return idEstadistica;
	}
	
	private void setIdEstadistica(int idEstadistica) {
		this.idEstadistica = idEstadistica;
	}

	public Date getFechaEstadistica() {
		return fechaEstadistica;
	}

	public void setFechaEstadistica(Date fechaEstadistica) {
		if(fechaEstadistica != null) {
			this.fechaEstadistica = fechaEstadistica;
		}
	}

	public TIPO_ESTADISTICA getTipo() {
		return tipo;
	}

	public void setTipo(TIPO_ESTADISTICA tipo) {
		this.tipo = tipo;
	}

	public ArrayList<String> getResultados() {
		return resultados;
	}

	public void setResultados(ArrayList<String> resultados) {
		if(resultados != null) {
			this.resultados = resultados;
		}
	}
	
	
	
	
	
}
