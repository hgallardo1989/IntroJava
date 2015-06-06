package py.com.uaa.pooj.segundoparcial;

public abstract class Cuenta {

	//Atributos
	private Cliente cliente;
	private Integer nroCuenta;
	private Integer saldo;

	//Constructor vacio
	Cuenta(){
		
	}
	
	//Constructor que recibe todos los atributos de la clase
	Cuenta(Cliente cliente, Integer nroCuenta, Integer saldo){
		this.setCliente(cliente);
		try {
			this.setNroCuenta(nroCuenta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSaldo(saldo);
	}
	
	
	//getters y setters
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(Integer nroCuenta) throws Exception {
		if (this.getNroCuenta().toString().length() == 9) {
			this.nroCuenta = nroCuenta;
		} else {
			throw new Exception("Numero de cuenta debe tener 9 digitos");
		}
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	//Metodos absractos (que van a ser implementados en las clases que hereden de Cuenta
	public abstract String debitar(Integer importe);

	public abstract String acreditar(Integer importe);

}
