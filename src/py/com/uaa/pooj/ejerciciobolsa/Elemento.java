package py.com.uaa.pooj.ejerciciobolsa;

/**
 *  * Tema 1 

Crear la clase Elemento que tiene un atributo (valor) de tipo entero. 
Tiene un método esIgual que recibe como parámetro otro elemento y retorna 
true si es que los valores son iguales. 

 * @author gsoria
 *
 */
public class Elemento {
	Integer valor;

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public boolean esIgual(Elemento valor2) {
		return this.getValor().equals(valor2.getValor());
	}
}
