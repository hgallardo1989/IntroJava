package py.com.uaa.pooj.segundoparcial;

public class CuentaCorriente extends Cuenta {

	@Override
	public String debitar(Integer importe) {
		return "Falta implementar este metodo";
	}

	@Override
	public String acreditar(Integer importe) {
		return "Falta implementar este metodo";
	}

	CuentaCorriente(Cliente cliente, Integer nroCuenta, Integer saldo){
		super(cliente, nroCuenta, saldo);
	}
}
