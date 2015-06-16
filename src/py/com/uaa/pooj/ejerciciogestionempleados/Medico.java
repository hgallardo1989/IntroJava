
package py.com.uaa.pooj.ejerciciogestionempleados;

/**
 *
 * @author gsoria
 */
public class Medico extends Persona implements IEmpleado{
    
    private String especialidad;
    private float salarioBase;
    private float horasExtras;
    private int cantPacientes;

    public Medico() {
    }

    public Medico(String especialidad, float salarioBase, float horasExtras, int cantPacientes, int CI, String nombre, String direccion, int edad) {
        super(CI, nombre, direccion, edad);
        this.especialidad = especialidad;
        this.salarioBase = salarioBase;
        this.horasExtras = horasExtras;
        this.cantPacientes = cantPacientes;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public float getsalarioBase() {
        return salarioBase;
    }

    public void setsalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float gethorasExtras() {
        return horasExtras;
    }

    public void sethorasExtras(float horasExtras) {
        this.horasExtras = horasExtras;
    }

    public int getcantPacientes() {
        return cantPacientes;
    }

    public void setcantPacientes(int cantPacientes) {
        this.cantPacientes = cantPacientes;
    }

    @Override
    public double calcularSalario() {
        return this.salarioBase + 0.9*this.horasExtras;
    }

    @Override
    public double pagarVacaciones(int dias) {
        return this.salarioBase/24 * dias + 0.3* this.cantPacientes;
    }
}
