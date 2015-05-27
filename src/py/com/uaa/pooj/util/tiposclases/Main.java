package py.com.uaa.pooj.util.tiposclases;
/**
 * 
 * @author gsoria
 *	La finalidad de esta clase es realizar pruebas de los tipos de clases que vamos 
 *	definiendo
 */
public class Main {

	public static void main(String[] args) {
		
		//Probemos la linea siguiente que esta comentada, nos varia un error. Porque? porque la clase
		//Figura esta declarada como una clase abstracta.
		//Figura figu = new Figura();
		
		Figura figu = new Cuadrado();
		int i = 9999;
		
		
		System.out.println("Entero: " + i);
	}
}
