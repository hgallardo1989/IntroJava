package py.com.uaa.pooj.recursividad;

import java.util.*;

public class Elevar2aN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.print("Introduce un numero entero >=0 ");
			num = sc.nextInt();
		} while (num < 0);
		System.out.println("2 ^ " + num + " = " + potencia(num));
	}

	public static double potencia(int n) {
		System.out.println("N: " + n);
		if (n == 0) // caso base
			return 1;
		else
			return 2 * potencia(n - 1);
	}
}
