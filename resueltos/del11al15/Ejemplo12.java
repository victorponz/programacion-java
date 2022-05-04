package del11al15;

import java.util.Scanner;

//Diseña un algoritmo que lea dos valores y muestre el más grande de ellos.
public class Ejemplo12 {
	public static void main(String argv[]) {
		int numero;
		int numero2;
		Scanner miScanner;
		System.out.println("Introduce un número entero:");

		// Leer un carácter como int desde el teclado
		miScanner = new Scanner(System.in);
		numero = miScanner.nextInt();

		System.out.println("Introduce otro número entero:");
		numero2 = miScanner.nextInt();

		// Si las condiciones son mutuamente excluyentes, se usa if .. else
		if (numero > numero2) {
			System.out.println("El número más grande es: " + numero);
		} else {
			System.out.println("El número más grande es: " + numero2);
		}
		
		//Otra forma de hacerlo es con el operador ternario
		//(condition ? exprTrue : exprFalse)
		System.out.println("El número más grande es: " + ((numero > numero2) ? numero : numero2));
		
		miScanner.close();
	}
}