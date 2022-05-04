import java.util.Scanner;

public class Ejemplo20 {
	/*
	 * Un cierto comercio hace un descuento dependiendo del precio de cada producto.
	Si el precio es inferior a 6 euros no hay descuento. Si es mayor o igual a 6 euros
	y menos de 60 €, se aplica un 5% de descuento, y si es mayor o igual a 60 € se aplica
	un 10% de descuento. Diseña el algoritmo para calcular el precio final.
	 */
	public static void main(String[] args) {
		float precio;
		float descuento;
		Scanner miScanner = new Scanner(System.in);

		/*
		 * 1.- RECOGER DATOS 
		 */
		System.out.println("Introduce el precio:");
		precio = miScanner.nextFloat();
		miScanner.close();

		
		/*
		 * 2.- PROCESAR DATOS 
		 */
		if (precio < 6) {
			descuento = 0;
		}else if(precio < 60) {
			descuento = precio * 0.05f;
		}else {
			descuento = precio * 0.10f;
		}
		
		/*
		 * 3.- IMPRIMIR RESULTADOS
		 */
		System.out.println("El precio final es: " + (precio - descuento) + " €");
		
	
	}

}
