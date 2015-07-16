package py.edu.uaa.finalTrabajo;

public class Materia {
	
	private int codigoMateria;
	private String nombreMateria;
	
	public Materia (int codigoMateria, String nombreMateria){
		
		this.codigoMateria= codigoMateria;
		this.nombreMateria= nombreMateria;
	}

	public Materia() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(int codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	

}
