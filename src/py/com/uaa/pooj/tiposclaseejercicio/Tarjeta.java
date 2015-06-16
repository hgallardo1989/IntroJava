package py.com.uaa.pooj.tiposclaseejercicio;

public abstract class Tarjeta {
	private String nombreTitular;
	
	//Se utiliza el tipo de dato Long porque excede la capacidad de lo que se puede almacenar con int o Integer
	private Long nroTarjeta;

	
	//getters and setters
	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public Long getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(Long nroTarjeta) throws Exception {
		if (nroTarjeta.toString().length() == 16){
			this.nroTarjeta = nroTarjeta;			
		}else{
			throw new Exception("Nro de tarjeta debe tener 16 digitos");
		}
	}

	public abstract String comprar(Integer importe);
}
