package py.com.uaa.pooj.util.tiposclases;

public class Circulo extends Figura {

	public String color;
	public int x;
	public int y;

	/**
	 * La variable pi, esta declarada como una variable de clase (es una
	 * variable que no se setea por cada instancia de la clase (objeto), sino
	 * que es global para todos los objetos de la clase
	 */
	public static double pi = 3.14;

	// constructor
	Circulo(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	// getters y setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// getters y setters para variables de clases son metodos estaticos
	public static double getPi() {
		return pi;
	}

	public static void setPi(double pi) {
		Circulo.pi = pi;
	}

	// metodo main para probar la clase
	public static void main(String[] args) {
		// Creacion de objetos
		Circulo c = new Circulo(3, 6);
		c.setColor("rojo");

		Circulo c2 = new Circulo(3, 6);
		c2.setColor("rosado");

		System.out.println("Circulo c2:" + c2.getColor() + " " + c2.getX()
				+ " " + c2.getY() + " " + c2.pi);
		System.out.println("Circulo c:" + c.getColor() + " " + c.getX() + " "
				+ c.getY() + " " + c.pi);

	}

	@Override
	public void size() {
		// TODO Auto-generated method stub

	}

}
