package del11al15;

import java.util.Scanner;

//realiza un programa que lea un número entero del 1 al 10 y que muestre su valor en letra:
public class Ejemplo15 {
	public static void main(String argv[]) {
		int numero;
		Scanner miScanner;
		
		System.out.println("Introduce un número del 1 al 10:");

		// Leer un carácter como int desde el teclado
		
		miScanner = new Scanner(System.in);
		numero = miScanner.nextInt();
		
		switch (numero) {
		case 1:
			System.out.println("Uno");
			//Importane usar break para que no continúe ejecuntando la siguiente instrucción System.out.println("Dos");
			break;
		case 2:
			System.out.println("Dos");
			break;
		case 3:
			System.out.println("Tres");
			break;
		case 4:
			System.out.println("Cuatro");
			break;
		case 5:
			System.out.println("Cinco");
			break;
		case 6:
			System.out.println("Seis");
			break;
		case 7:
			System.out.println("Siete");
			break;
		case 8:
			System.out.println("Ocho");
			break;
		case 9:
			System.out.println("Nuevo");
			break;
		case 10:
			System.out.println("Diez");
			break;
		default:
			System.out.println("El número debe estar comprendido entre 0 y 10");
		}

		miScanner.close();
	}
}
