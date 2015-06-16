package py.com.uaa.pooj.ui;

//para poder utilizar los cuadros de dialogo necesitamos importar la clase JOptionPane
//que esta dentro del paquete javax.swing

import javax.swing.JOptionPane;
/**
 * 
 * @author gsoria
 * Esta es una clase que ejemplifica el uso de JOptionPane (Swing) 
 * para mostrar mensajes y para ingresar valores mediante cuadros de dialogo.
 *
 */
public class TestSwing {
	
	public static void main(String[] args) {
		testSwing();
	}


    public static void testSwing () {
        
    	//Ejemplos de mensajes con diferentes tipos de iconos
        JOptionPane.showMessageDialog(null, "Bienvenidos a JAVA!");
        JOptionPane.showMessageDialog(null, "Con icono de interrogacion", "Aviso", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Con icono de exclamacion", "Aviso", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "Con icono de error", null, JOptionPane.ERROR_MESSAGE, null);
        JOptionPane.showMessageDialog(null, "Con icono de informacion (por defecto)", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Sin icono", "Aviso", JOptionPane.PLAIN_MESSAGE);
        
        //Se muestra un cuadro de dialogo, y el valor ingresado se guarda en la variable name
        String name = JOptionPane.showInputDialog("Ingrese su nombre", JOptionPane.INFORMATION_MESSAGE);
        
        //Se muestra el valor de la variable, convirtiendo el texto a mayusculas
        JOptionPane.showMessageDialog(null, "Nombre: " + name.toUpperCase());
        
    }

}
