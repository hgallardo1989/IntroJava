package py.com.uaa.pooj.util.tiposclases;

public class Circulo {

	public String color;
	public int x;
	public int y;
	public static double pi = 3.14;
	
	//getters y setters
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
	//getters y setters para variables de clases son metodos estaticos
	public static double getPi() {
		return pi;
	}
	public static void setPi(double pi) {
		Circulo.pi = pi;
	}
	
	//metodo main para probar la clase
	public static void main(String[] args) {
		Circulo c = new Circulo();
		c.setColor("rojo");
		c.setX(3);
		c.setY(6);
		
		Circulo c2 = new Circulo();
		c2.setColor("rosado");
		c2.setX(10);
		c2.setY(20);
		
		System.out.println("Circulo c2:" + c2.getColor() + " " + c2.getX() +  " " +  c2.getY() + " " +  c2.pi);
		System.out.println("Circulo c:" + c.getColor() + " " + c.getX() + " " +  c.getY() + " " + c.pi);
		
	}
	
	
	
}
