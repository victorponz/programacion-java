import java.util.Scanner;
public class Ejemplo21 {
	public static void main(String[] args) {
		int anyo;
		/*
		 * Este tipo de variables se llaman banderas o flags, y sirven para marcar situaciones
		 * En este caso, queremos probar que un año es bisiesto, por lo que en principio suponemos
		 * que no lo es
		 */
		boolean esBisiesto = false;
		Scanner miScanner = new Scanner(System.in);
		/*
		 * 1.- RECOGER DATOS 
		 */
		
		System.out.println("Introduce un año:");
		anyo = miScanner.nextInt();
		miScanner.close();

		/*
		 * 2.- PROCESAR DATOS 
		 * Resumiendo: Si el año es múltiplo de 400 (que entonces también lo es de 100 y 4), es bisiesto
		 * 				O el año es múltiplo de 4 pero no de 100
		 */
		
		if ((anyo % 400 == 0 ) || ((anyo % 4 == 0 ) && (anyo % 100 != 0 ))) {
			//Cambiamos la bandera
			esBisiesto = true;
		}
	
		/*
		 * 3.- IMPRIMIR RESULTADOS
		 */
		
		if (esBisiesto) {
			 System.out.println("Es bisiesto");
		}else {
			 System.out.println("No es bisiesto");
		}

	}
}
