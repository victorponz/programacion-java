import java.util.Scanner;

//Un programa que pida el radio de una circunferencia y muestre su área y su perímetro
public class Ejemplo6 {
	public static void main(String argv[]) {
		int radio;

		System.out.println("Introduce el radio:");

		// Leer un carácter como int desde el teclado
		Scanner miScanner;
		miScanner = new Scanner(System.in);
		radio = miScanner.nextInt();

		// El resultado es un número Float o Double
		System.out.printf("El área de la circunferencia es: %f %n", Math.PI * radio * radio);
		System.out.printf("El perímetro de la circunferencia es: %f %n", 2 * Math.PI * radio);

		miScanner.close();
	}
}
