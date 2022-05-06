import java.util.Scanner;

public class Ejemplo3 {
	public static void main(String[] args) {
		int dni;
		Scanner miScanner = new Scanner(System.in);
    	
    	System.out.println("Introduce tu DNI (sin letra)");  	
    	dni  = miScanner.nextInt();
        
    	miScanner.close();
        
		char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };

		// Obtener a qué índice corresponde
		int res = dni % 23;
		System.out.println("La letra correspondiente es: " + letras[res]);

	}
}
