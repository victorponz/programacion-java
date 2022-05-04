package del6al10;

import java.util.Scanner;

//Un programa que pida el precio real de un producto, el precio rebajado y muestre el descuento realizado
public class Ejemplo7 {
	public static void main(String argv[]) {
		float precio;
		float precioRebajado;
		float descuento;

		System.out.println("Introduce el precio:");

		// Leer un carácter como float desde el teclado
		Scanner miScanner;
		miScanner = new Scanner(System.in);
		precio = miScanner.nextFloat();

		System.out.println("Introduce el precio rebajado:");
		precioRebajado = miScanner.nextFloat();

		// Calcular el descuento
		descuento = (precio - precioRebajado) / precio * 100;

		// El resultado es un número Float o Double
		System.out.printf("El descuento es de: %f %n", descuento);

		miScanner.close();
	}
}