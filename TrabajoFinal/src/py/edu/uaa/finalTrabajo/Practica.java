package py.edu.uaa.finalTrabajo;

import java.util.Date;

import py.edu.uaa.finalTrabajo.conexiones.Conexion;

public class Practica {
	
	private int nroCedula;
	private int codigoMateria;
	private String fecha;
	private int cantidadHoras;
	

	public Practica( Date Fecha, int cantidadHoras){
		
		this.fecha= fecha;
		this.cantidadHoras= cantidadHoras;
		this.nroCedula= nroCedula;
		this.codigoMateria= codigoMateria;
		
	}



	public Practica() {
		// TODO Auto-generated constructor stub
	}



	public int getNroCedula() {
		return nroCedula;
	}


	public void setNroCedula(int nroCedula) {
		this.nroCedula = nroCedula;
	}


	public int getCodigoMateria() {
		return codigoMateria;
	}


	public void setCodigoMateria(int codigoMateria) {
		this.codigoMateria = codigoMateria;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getCantidadHoras() {
		return cantidadHoras;
	}


	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
	

	
}
