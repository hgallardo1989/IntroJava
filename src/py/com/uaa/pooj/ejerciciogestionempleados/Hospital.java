
package py.com.uaa.pooj.ejerciciogestionempleados;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gsoria
 */
public class Hospital {
    
    private List<Persona> personas = new ArrayList<Persona>();

    public Hospital() {
    }

    public List<Persona> getPersonas() {
        return personas;
    }
    
    public String adicionarPersona(Persona p1){
    
        String mensaje = "Ya se encuentra la persona";
        if(!personas.contains(p1)){
        
            personas.remove(p1);
            mensaje = "Se agrego correctamente la persona";
        }
        
        return mensaje;
    }
    
    public String eliminarPersona( int pCI){
    
        String mensaje = "No se encuentra la persona";
        
        for(int i = 0; i<personas.size(); i++){
        
            if(personas.get(i).getCi() == pCI ){
            
                personas.remove(personas.get(i));
                mensaje = "Se elimino correctamente la persona";
            }
        }
        
        return mensaje;
    }
    
    public String grupoSanguineo(int pCI){
    
        String grupo = null;
        Paciente paciente = new Paciente();
        
        for(int i = 0; i<personas.size(); i++){
        
            if(personas.get(i) instanceof Paciente  && personas.get(i).getCi() == pCI){
            
                paciente = (Paciente) personas.get(i);
                grupo = paciente.getGrupoSanguineo();
                break;
            }
        }
        
        return grupo;
    }
    
    public double salarioEmpleado(int pCI){
    
        int pos = -1;
        for(int i = 0; i<personas.size(); i++){
        
            if(personas.get(i) instanceof Empleado  && personas.get(i).getCi() == pCI){
            
                pos = i;
                break;
            }
        }
        
        Empleado empleado = (Empleado) personas.get(pos);
        return empleado.calcularSalario();
    }
    
    public String masPacientes(){
    
        Medico mayor = new Medico();
        
        for(int i = 0; i<personas.size(); i++){
        
            if(personas.get(i) instanceof Medico){
            
                mayor = (Medico) personas.get(i);
                break;
            }
        }
        
        for(int i = 0; i<personas.size(); i++){
        
            if(personas.get(i) instanceof Medico){
            
                Medico medico = (Medico) personas.get(i);
                
                if(medico.getcantPacientes() > mayor.getcantPacientes()){
                
                    mayor = medico;
                }
            }
        }
        
        return mayor.getEspecialidad();
    }
    
    public double vacaciones(int pCI, int dias){
    
        int pos = -1;
        for(int i = 0; i<personas.size(); i++){
        
            if(personas.get(i) instanceof Medico  && personas.get(i).getCi() == pCI){
            
                pos = i;
                break;
            }
        }
        
        Medico medico = (Medico) personas.get(pos);
        return medico.pagarVacaciones(dias);
    }
    
    public String menosHoras(){
    
         Empleado menor = new Empleado();
        
        for(int i = 0; i<personas.size(); i++){
        
            if(personas.get(i) instanceof Empleado){
            
                menor = (Empleado) personas.get(i);
                break;
            }
        }
        
        for(int i = 0; i<personas.size(); i++){
        
            if(personas.get(i) instanceof Empleado){
            
               Empleado empleado = (Empleado) personas.get(i);
                
                if(empleado.getHoras_extras() < menor.getHoras_extras()){
                
                    menor = empleado;
                }
            }
        }
        
        return menor.getNombre();
        
    }
    
    public int cantPacientes(char psexo){
    
        int cant = 0;
        Paciente paciente = new Paciente();
        
        for(int i = 0; i<personas.size(); i++){
        
            if(personas.get(i) instanceof Paciente){
            
                paciente = (Paciente) personas.get(i);
                if(paciente.getSexo() == psexo){
                
                    cant++;
                }
            }
        }
        
        return cant;
    }
            
}
