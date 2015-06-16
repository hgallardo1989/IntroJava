package py.com.uaa.pooj.util.relaciones;

import java.util.Date;

public class Persona {
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Direccion direccion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccione(Direccion direccion) {
		this.direccion = direccion;
	}

}
