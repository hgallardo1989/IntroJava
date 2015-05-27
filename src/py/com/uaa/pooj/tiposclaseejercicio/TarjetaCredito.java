package py.com.uaa.pooj.tiposclaseejercicio;

import java.util.Date;

public class TarjetaCredito extends Tarjeta {

	private Integer saldo;
	private Date fechaVencimiento;
	
	//getters and setters de TarjetaCredito
	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	//Constructor
	TarjetaCredito(String nombreTitular, Long nroTarjeta, Integer saldo, Date fechaVencimiento){
		//se setea la propiedad nombreTitular (heredada de la clase padre)
		this.setNombreTitular(nombreTitular);
		//El seteo del numero de tarjeta puede lanzar una exception si no tiene 16 digitos
		//se setea la propiedad nroTarjeta (heredada de la clase padre)

		try {
			this.setNroTarjeta(nroTarjeta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//se setea la propiedad saldo
		this.setSaldo(saldo);
		//se setea la propiedad nombreTitular fechaVencimiento
		this.setFechaVencimiento(fechaVencimiento);
		
	}
	
	@Override
	public String comprar(Integer importe) {
		if (this.getSaldo()>importe){
			this.setSaldo(this.getSaldo()-importe);
			return "APROBADA";
		}else{
			return "RECHAZADA";			
		}
	}
}
