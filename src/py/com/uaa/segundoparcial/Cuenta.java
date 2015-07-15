package py.com.uaa.segundoparcial;

public abstract class Cuenta {
	private Cliente cliente;
	private Long nroCuenta;
	private int saldo;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Long getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(Long nroCuenta) throws Exception {
		if (nroCuenta.toString().length()==9){
			this.nroCuenta = nroCuenta;
		}else{
			throw new Exception("Nro de cuenta debe tener 9 digitos");
		}
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	//constructores
	Cuenta(Cliente cliente, Long nroCuenta, int saldo) throws Exception{
		this.setCliente(cliente);
		this.setNroCuenta(nroCuenta);
		this.setSaldo(saldo);
	}
	
	Cuenta(){
		
	}
	
	//metodos abstractos a ser implementados por las clases hijas
	public abstract String acreditar(int importe);
	public abstract String debitar(int importe);
	
	

}
