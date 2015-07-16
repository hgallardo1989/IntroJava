package py.edu.uaa.finalTrabajo;

import java.util.Date;

public class Practica {
	
	private Date fecha;
	private int cantidadHoras;
	private Alumno alumno;
	private Materia materia;
	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Practica( Date Fecha, int cantidadHoras){
		
		this.fecha= fecha;
		this.cantidadHoras= cantidadHoras;
		
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
	
}
