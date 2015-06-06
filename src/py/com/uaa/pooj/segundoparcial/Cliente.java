package py.com.uaa.pooj.segundoparcial;

public class Cliente {

	//atributos
	private String nombre;
	private String apellido;
	private Integer nroCedula;
	private String direccion;
	private Integer telefono;

	//getters y setters
	public Integer getNroCedula() {
		return nroCedula;
	}

	public void setNroCedula(Integer nroCedula) {
		this.nroCedula = nroCedula;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
