package del6al10;

import java.util.Scanner;

//Realiza un programa que pida la edad al usuario y muestre un mensaje si es mayor de edad
public class Ejemplo8 {
	public static void main(String argv[]) {
		int edad;
		Scanner miScanner;

		System.out.println("Introduce tu edad:");

		// Leer un carácter como int desde el teclado
		miScanner = new Scanner(System.in);
		edad = miScanner.nextInt();

		if (edad >= 18) {
			System.out.println("Eres mayor de edad");
		}

		miScanner.close();
	}
}