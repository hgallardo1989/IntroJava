package py.com.uaa.pooj.excepciones;

public class PruebaExcepcionArray {
	public int[] arreglo;

	public void equivocar() {
		int resultado = 0;
		resultado = this.arreglo[11];
	}

//	public static void main(String[] args) {
//		int[] numeros = new int[10];
//		for (int i = 0; i < numeros.length; i++) {
//			i = i + 10;
//			int resultado;
//			resultado = numeros[i];
//		}
//	}
	
	public static void main(String[] args) {
		
		try {
			PruebaExcepcionArray prueba = new PruebaExcepcionArray();
			prueba.equivocar();
		} catch (NullPointerException e) {
			System.out.println("Arreglo no incializado");
			e.printStackTrace();
		}

	}

}
