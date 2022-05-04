package del11al15;

import java.util.Scanner;

//Diseña un algoritmo que lea un valor numérico 
//entero correspondiente a la nota de un examen y muestre su valor en letra
public class Ejemplo14 {
	public static void main(String argv[]) {
		int nota;
		Scanner miScanner;
		
		System.out.println("Introduce el valor de la nota entera:");

		// Leer un carácter como int desde el teclado
		miScanner = new Scanner(System.in);
		nota = miScanner.nextInt();
		
		// Si las condiciones son mutuamente excluyentes, se usa if .. else if ...
		if ((nota < 0) || (nota > 10)) {
			System.out.println("Nota inválida");
		}else if (nota < 3) {
			System.out.println("Muy deficiente");
		}else if (nota < 5 ) {
			// No hace falta que comprobemos que es mayor que 3, porque si lo fuera
			// habría entrado por el if (nota < 3) {
			System.out.println("Insuficiente");
		}else if (nota < 6 ) {
			System.out.println("Suficiente");
		}else if (nota < 7 ) {
			System.out.println("bien");
		}else if (nota < 9 ) {
			System.out.println("Notable");
		}else {
			System.out.println("Sobresaliente");
		}
			
			
		miScanner.close();
	}
}