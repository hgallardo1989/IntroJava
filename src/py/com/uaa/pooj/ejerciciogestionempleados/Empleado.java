/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.uaa.pooj.ejerciciogestionempleados;

/**
 *
 * @author gsoria
 */
public class Empleado extends Persona implements IEmpleado{
    
    private float salario_base;
    private float horas_extras;

    public Empleado() {
    }

    public Empleado(float salario_base, float horas_extras, int CI, String nombre, String direccion, int edad) {
        super(CI, nombre, direccion, edad);
        this.salario_base = salario_base;
        this.horas_extras = horas_extras;
    }

    public float getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(float salario_base) {
        this.salario_base = salario_base;
    }

    public float getHoras_extras() {
        return horas_extras;
    }

    public void setHoras_extras(float horas_extras) {
        this.horas_extras = horas_extras;
    }

    @Override
    public double calcularSalario() {
       return this.salario_base + (0.5 * this.horas_extras);
    }

    @Override
    public double pagarVacaciones(int dias) {
        return this.salario_base/24 * dias;
    }
}
