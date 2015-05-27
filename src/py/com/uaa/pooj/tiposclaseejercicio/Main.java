package py.com.uaa.pooj.tiposclaseejercicio;

import java.util.Date;

/**
 * Crear una clase abstracta Tarjeta que tenga como atributos nombre del titular, y numero de tarjeta. 
 * Debe implementar un metodo compra que reciba un importe.Crear una clase para representar una 
 * Tarjeta de credito, subclase de la clase Tarjeta, con su nro de 16 digitos, nombre del titular, 
 * fecha de vencimiento ( mes y año ) y ademas saldo disponible y un constructor que reciba como 
 * parametros todos los atributos de la clase.
 * Deberá tener un método compra que reciba como parametro un importe y si tiene saldo disponible: 
 * actualice el saldo de la tarjeta y retorne “aprobada” y si no tiene saldo disponible retorne “rechazada”.
 * Crear una aplicación que utilice 2 tarjetas y tenga una llamada al metodo compra de forma a que una sea aprobada y otra rechazada.
 * @author gsoria
 *
 */
public class Main {
	
	
	public static void main(String[] args) {
		//Se crea una tarjeta, para titular Gabriela Soria, con numero de tarjeta 1234567891234567, con 300000, que vence el 15 de 06 de 2015
		@SuppressWarnings("deprecation")
		TarjetaCredito tc1 = new TarjetaCredito("Gabriela Soria", new Long(1234567891234567L), new Integer("300000"), new Date(2015,06,15));
		//Se intena hacer una compra por 1.000.000
		String resultado = tc1.comprar(new Integer("1000000"));
		System.out.println(resultado);
		
		//Se crea una tarjeta, para titular Juan Perez, con numero de tarjeta 9876543211234567, con 1000000, que vence el 20 de 06 de 2015
		TarjetaCredito tc2 = new TarjetaCredito("Juan Perez", new Long(9876543211111111L), new Integer(1000000), new Date(2015,06,20));

		//Se intenta hacer una compra por 900.000
		String resultado2 = tc2.comprar(new Integer(900000));
		System.out.println(resultado2 + " -Nuevo saldo: " + tc2.getSaldo());
		
		//Probar la validacion de cantidad de digitos
		//TarjetaCredito tc3 = new TarjetaCredito("Juan Perez", new Long(987654321L), new Integer(1000000), new Date(2015,06,20));

	}
}
