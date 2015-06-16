
package py.com.uaa.pooj.ejerciciogestionempleados;

/**
 *
 * @author gsoria
 */
public abstract class Persona {
    
    protected int ci;
    protected String nombre;
    protected String direccion;
    protected int edad;

    public Persona() {
    }

    public Persona(int ci, String nombre, String direccion, int edad) {
        this.ci = ci;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
    }

    public int getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
}
