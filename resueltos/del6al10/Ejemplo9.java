package del6al10;

import java.util.Scanner;

//Realiza un programa que pida la edad al usuario y muestre un mensaje si es mayor de edad
public class Ejemplo9 {
	public static void main(String argv[]) {
		int edad;
		Scanner miScanner;

		System.out.println("Introduce tu edad:");

		// Leer un carácter como int desde el teclado
		miScanner = new Scanner(System.in);
		edad = miScanner.nextInt();

		// Si las condiciones son mutuamente excluyentes, se usa if .. else
		if (edad >= 18) {
			System.out.println("Eres mayor de edad");
		} else {
			System.out.println("Eres menor de edad");
		}

		miScanner.close();
	}
}