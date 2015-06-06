package py.com.uaa.pooj.segundoparcial;

public class Main {
	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Juan");
		cliente1.setApellido("Perez");
		cliente1.setDireccion("Jejui 995");
		cliente1.setNroCedula(344477);
		cliente1.setTelefono(612167);
		
		CuentaAhorro cuenta1 = new CuentaAhorro(cliente1, new Integer(123456789), 300000, 0.9f);
		
		CuentaAhorro cuenta2 = new CuentaAhorro(cliente1, 123456788, 1000000, 0.9f);

		CuentaAhorro cuenta3 = new CuentaAhorro(cliente1, 12345678, 300000, 0.9f);
 
		//De la cuenta1, que se creo con saldo 300.000 se quiere 
		//realizar una operacion de debito de 400.000
		System.out.println(cuenta1.debitar(400000));
		
		//De la cuenta2, que se creo con saldo 1.000.000 se quiere
		//realizar una operación de debito de 400.000
		System.out.println(cuenta2.debitar(400000));
		
		//Git 
		System.out.println(cuenta1.acreditar(300000));

	}

}
