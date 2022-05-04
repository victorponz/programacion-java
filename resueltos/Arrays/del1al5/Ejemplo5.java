package del31al35;

import java.util.Scanner;

/*
 * Diseña un algoritmo que lea un conjunto de notas del teclado hasta 
 * que se introduzca -1 y muestre la nota media y si había un 10 o no. 
 */
public class Ejemplo35 {

	public static void main(String[] args) {
		int cuantasNotas = 10;
		int sumaNotas = 0;
		boolean hayUnDiez = false;
		// Declara un array de enteros
		int[] anArray;

		// Reserva memoria para cuantasNotas enteros
		anArray = new int[cuantasNotas];
		Scanner inputValue = new Scanner(System.in);

		System.out.println("Introduce " + cuantasNotas + " notas (enteros)");

		for (int i = 0; i < cuantasNotas; i++) {
			anArray[i] = inputValue.nextInt();
		}

		// NOTA: Se hubiera podido calcular en el for previo
		// pero lo hago así para practicar con el for mejorado para arrays
		for (int nota : anArray) {
			sumaNotas += nota;
			if (nota == 10) {
				hayUnDiez = true;
			}
		}

		System.out.println("La nota media es " + ((float) sumaNotas / (float) cuantasNotas));
		if (hayUnDiez) {
			System.out.println("Había al menos un 10 en las notas");
		}
		inputValue.close();
	}
}
