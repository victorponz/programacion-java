package del31al35;

import java.util.Scanner;

/*
 * 
    Los NIE's de extranjeros residentes en España tienen una letra (X, Y, Z), 7 números y dígito de control.

Para el cálculo del dígito de control se sustituye:

    X → 0
    Y → 1
    Z → 2

y se aplica el mismo algoritmo que para el NIF.
 */
public class Ejemplo34 {

	public static void main(String[] args) {
    	Scanner miScanner = new Scanner(System.in);
    	
    	System.out.println("Introduzca una cadena:");    	   	
        String nie = miScanner.nextLine();
        
        miScanner.close();
        
		int numero = 0;
		// Suponemos que el NIE está bien formado

		/*
		 * Sustituir la primera letra por un número: nie.substring(1) devuelve la cadena
		 * a partir del índice 1 Por ejemplo: nie = Z5742757; nie.substring(1) devuelve
		 * 5742757 Y como la primera letra es una Z, le antepongo un 2 y lo convierto a
		 * entero
		 */
		if (nie.charAt(0) == 'X') {
			numero = Integer.parseInt("0" + nie.substring(1));
		} else if (nie.charAt(0) == 'Y') {
			numero = Integer.parseInt("1" + nie.substring(1));
		} else if (nie.charAt(0) == 'Z') {
			numero = Integer.parseInt("2" + nie.substring(1));
		}
		char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };

		// Obtener a qué índice corresponde
		int res = numero % 23;
		System.out.println("La letra correspondiente es: " + letras[res]);

	}
}
