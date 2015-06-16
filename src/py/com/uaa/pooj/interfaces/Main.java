package py.com.uaa.pooj.interfaces;

public class Main {

	public static void main(String[] args) {

		Mascota mascota1 = new Perro();
		System.out.println(mascota1.desplegarNombre());

		Mascota mascota2 = new Gato();
		System.out.println(mascota2.desplegarNombre());

	}
}
