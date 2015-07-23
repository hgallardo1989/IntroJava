package py.edu.uaa.finalTrabajo;

public class AlumnoCurso {

	private int nroCedula;
	private int codMateria;
	
public AlumnoCurso (int nroCedula, int codMateria){
		
		this.nroCedula= nroCedula;
		this.codMateria= codMateria;
	}

public AlumnoCurso() {
	// TODO Auto-generated constructor stub
}

public int getNroCedula() {
	return nroCedula;
}

public void setNroCedula(int nroCedula) {
	this.nroCedula = nroCedula;
}

public int getCodMateria() {
	return codMateria;
}

public void setCodMateria(int codMateria) {
	this.codMateria = codMateria;
}

}
