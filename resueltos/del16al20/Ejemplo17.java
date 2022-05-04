import java.util.Scanner;

//Realiza un programa que pida al usuario un mes e imprima el número de días que tiene.
public class Ejemplo17 {
	public static void main(String argv[]) {
		int mes;
		Scanner miScanner = new Scanner(System.in);
		
		// Leer un carácter como int desde el teclado
		System.out.println("Introduce un mes :");
		mes = miScanner.nextInt();
		miScanner.close();
		
		//En este caso tenemos un switch que imprime lo mismo para varios casos
		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("El mes tiene 31 días");
			break;			
		case 2:
			System.out.println("El mes tiene 28 o 29 días");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("El mes tiene 30 días");
			break;
		default:
			System.out.println("Mes incorrecto");
		}

	}
}
