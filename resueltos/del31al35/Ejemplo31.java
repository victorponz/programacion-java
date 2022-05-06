import java.util.Scanner;

public class Ejemplo31 {

	public static void main(String[] args){	
		Scanner miScanner = new Scanner(System.in);
		System.out.println("Introduce un número entero:");

		int numero = miScanner.nextInt();
		miScanner.close();
			
		//Hacemos un bucle hasta la mitad del número (un divisor no puede ser mayor que la mitad!)
		System.out.println("Divisores de " + numero);
		//Hay que revisar siempre los límites de los bucles!!
		for (int i = 1; i <= numero / 2; i++) {
			if ((numero % i) == 0) {
				System.out.println("\t" + i);
			}
		}
	}

}
