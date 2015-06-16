package py.com.uaa.pooj.ejerciciobolsa;

/**
 * 
Tema 2 
Crear la interfaz TrabajaElementos que especifica los métodos para: 
añadir un elemento, 
retirar que saca un elemento 
esVacio  que verifica si la estructura esta vacía o no 
 * @author gsoria
 *
 */
public interface TrabajaElementos {
	
	public void agregarElemento(Elemento elemento);
	public void eliminarElemento(Elemento elemento);
	public boolean esVacio();
	

}
