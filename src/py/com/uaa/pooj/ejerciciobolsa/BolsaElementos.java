/**
Tema 4 
Crear la clase BolsaElementos  subtipo de la clase abstracta Bolsa  y que implemente a la interfaz TrabajaElementos. 
*/

package py.com.uaa.pooj.ejerciciobolsa;

import java.util.ArrayList;

public class BolsaElementos extends Bolsa implements TrabajaElementos {

	public BolsaElementos(ArrayList<Elemento> elementos) {
		this.setElementos(elementos);
	}

	@Override
	public void agregarElemento(Elemento elemento) {
		if (this.getElementos()!= null){
			this.getElementos().add(elemento);
		}
		
	}

	@Override
	public void eliminarElemento(Elemento elemento) {
		if (this.getElementos()!= null){
			this.getElementos().remove(elemento);
		}
	}

	@Override
	public boolean esVacio() {
		if (this.getElementos().isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public Bolsa unirBolsas(Bolsa bolsa1, Bolsa bolsa2) {
		//se ponen todos los elementos de la bolsa 2 en la bolsa 1
		bolsa1.getElementos().addAll(bolsa2.getElementos());
		//se crea una tercera bolsa con los elementos de la bolsa 1
		BolsaElementos bolsaElemento = new BolsaElementos(bolsa1.getElementos());
		//se retorna la bolsa consolidada
		return bolsaElemento;
		
	}

}
