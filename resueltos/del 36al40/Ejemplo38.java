
import java.util.Random;
import java.util.Scanner;

public class Ejemplo38 {
	public static void main(String[] args) {
		Scanner miScanner = new Scanner(System.in);
		
		int numero = -1;
		
		boolean haGanado = false;
		
		Random aleatorio = new Random(System.currentTimeMillis());
	    // Producir nuevo int aleatorio entre 0 y 99
	    int secreto = aleatorio.nextInt(100);
	    do {
			System.out.println("Introduce un número (-1 para rendirse)");
			numero = miScanner.nextInt();

			if (numero != -1) {
				if (numero > secreto) {
					System.out.println("El número secreto es más pequeño");
				}else if (numero < secreto) {
					System.out.println("El número secreto es más grande");
				}else {
					System.out.println("Has Ganado");
					haGanado = true;
				}
			}else {
				System.out.println("Se rinde");
			}
	    } while (!haGanado && (numero != -1));
	    
	    miScanner.close();
	}

}