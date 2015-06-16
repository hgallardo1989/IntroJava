package py.com.uaa.pooj.excepciones;

public class Main {
	public static void main(String[] args) {

		//numero 1 con valor 10
		int numero1 = 10;
		//numero 2 con valor 0
		int numero2 = 0;
		try {
			//se intenta realizar una division
			int numero3 = numero1/numero2;
			//se intenta mostrar el resultado de la division
			System.out.println("Resultado de la division: " + numero3);
		} catch (ArithmeticException e) {
			System.out.println("Se captura la excepcion");
			e.printStackTrace();
		}
		
		//Crear un array de enteros de 10 elementos
		
		//Intentar acceder a la posicion 11
		
		//Luego capturar la excepcion de ese tipo de error
			
	}
	
	public void imprimirMensaje(String mensaje) throws MyException{
		if(mensaje == null){
			throw new MyException("Se lanza una excepcion");
		}
	}
}
