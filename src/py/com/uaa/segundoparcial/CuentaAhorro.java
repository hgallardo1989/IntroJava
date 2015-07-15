package py.com.uaa.segundoparcial;

public class CuentaAhorro extends Cuenta {
	//atributos de la clase
	int tasaInteres;
	
	//constructor de la clase padre
	CuentaAhorro(Cliente cliente, Long nroCuenta, int saldo) throws Exception {
		super(cliente, nroCuenta, saldo);
	}
	
	//constructor vacio por las dudas
	CuentaAhorro(){
		
	}

	//constructor considerando atributos de la clase
	CuentaAhorro(Cliente cliente, Long nroCuenta, int saldo, int tasaInteres) throws Exception {
		this.setCliente(cliente);
		this.setNroCuenta(nroCuenta);
		this.setSaldo(saldo);
		this.setTasaInteres(tasaInteres);
	}

	public int getTasaInteres() {
		return tasaInteres;
	}

	public void setTasaInteres(int tasaInteres) {
		this.tasaInteres = tasaInteres;
	}
	
	//metodos que obliga la clase padre a implementar
	@Override
	public String acreditar(int importe) {
		this.setSaldo(this.getSaldo()+importe);
		return "Nuevo saldo" + this.getSaldo();
	}

	@Override
	public String debitar(int importe) {
		if(this.getSaldo()>importe){
			this.setSaldo(this.getSaldo()-importe);
			return "APROBADO";
		}else{
			return "RECHAZADO";
		}
	}

}
