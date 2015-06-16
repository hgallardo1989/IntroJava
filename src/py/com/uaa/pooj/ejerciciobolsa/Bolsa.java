package py.com.uaa.pooj.ejerciciobolsa;

import java.util.ArrayList;

/**
 * Tema 3 

Bolsa: Colección de elementos no ordenados que pueden estar repetidos.
Crear una clase abstracta para representar una Bolsa, y crear las siguientes operaciones: CrearBolsa( Constructor) , 
dentro que verifica si un elemento pertenece a la bolsa, 
cuantos que determina el numero de veces que un elemento se encuentra en la Bolsa, 
unión  que a partir de 2 bolsas devuelve una bolsa con los elementos de las dos bolsas 
total que devuelve el numero de elementos en la bolsa

 * @author gsoria
 *
 */

public abstract class Bolsa {
	
	ArrayList<Elemento> elementos;
	
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}

	//constructor, inicializa la bolsa
	Bolsa(){
		elementos = new ArrayList<Elemento>();
		
	}

	Bolsa(ArrayList<Elemento> elementos){
		this.setElementos(elementos);
	}
	
	public boolean estaDentro(Elemento elemento) {
		if (this.elementos.contains(elemento)){
			return true;
		}
		return false;
	}
	
	public Integer contarPresenciaElemento(Elemento elemento){
		Integer contador=0;
		for (Elemento elemen : elementos) {
			if (elemen.esIgual(elemento)){
				contador++;
			}
		}
		return contador;
	}
	
	
	public abstract Bolsa unirBolsas(Bolsa bolsa1, Bolsa bolsa2);
	
	public Integer obtenerTotalElementosBolsa(){
		return elementos.size();
	}

}
