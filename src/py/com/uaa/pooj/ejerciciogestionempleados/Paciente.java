
package py.com.uaa.pooj.ejerciciogestionempleados;

/**
 *
 * @author gsoria
 */
public class Paciente extends Persona{
    
    private int historiaClinica;
    private char sexo;
    private String grupoSanguineo;

    public Paciente() {
    }

    public Paciente(int historiaClinica, char sexo, String grupoSanguineo, int CI, String nombre, String direccion, int edad) {
        super(CI, nombre, direccion, edad);
        this.historiaClinica = historiaClinica;
        this.sexo = sexo;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getHistoria_clinica() {
        return historiaClinica;
    }

    public char getSexo() {
        return sexo;
    }

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}


}
