package del6al10;

import java.util.Scanner;

//Diseña un algoritmo que lea un valor y muestre si es positivo o negativo (0 es positivo)
public class Ejemplo10 {
	public static void main(String argv[]) {
		int numero;
		Scanner miScanner;

		System.out.println("Introduce un número entero:");

		// Leer un carácter como int desde el teclado
		miScanner = new Scanner(System.in);
		numero = miScanner.nextInt();
		
		//Si las condiciones son mutuamente excluyentes, se usa if .. else
		if (numero > 0) {
			System.out.println("El número es positivo");
		} else if (numero < 0) {
			System.out.println("El número es negativo");
		} else {
    		System.out.println("El número es CERO");
		}
		
		miScanner.close();
	}
}
