package del11al15;

import java.util.Scanner;

//Realiza un programa que lea dos valores y los orden ascende o descentemente según elija el usuario.
public class Ejemplo13 {
	public static void main(String argv[]) {
		int numero;
		int numero2;
		int orden;
		Scanner inputValue;
		
		System.out.println("Introduce un número entero:");

		// Leer un carácter como int desde el teclado
		
		inputValue = new Scanner(System.in);
		numero = inputValue.nextInt();

		System.out.println("Introduce otro número entero:");
		numero2 = inputValue.nextInt();
		
		System.out.println("¿Cómo lo quieres ordenar?: 1 - Ascendente; 2 - Descendente");
		orden = inputValue.nextInt();
		
		if (orden == 1) {
			if (numero > numero2) {
				System.out.println(numero2 + " " + numero);
			} else {
				System.out.println(numero + " " + numero2);
			}

		} else {
			if (numero > numero2) {
				System.out.println(numero + " " + numero2);
			} else {
				System.out.println(numero2 + " " + numero);
			}
			
		}
		
		System.out.println(numero + " " + numero2 + " " + orden);
		inputValue.close();
	}
}