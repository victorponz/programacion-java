
import java.util.Scanner;

public class Utilidades {
	static Scanner inputValue = new Scanner(System.in);

	public static int leerEntero(String mensaje) {
		System.out.println(mensaje);
		return inputValue.nextInt();

	}

	public static double leerDoble(String mensaje) {
		System.out.println(mensaje);
		return inputValue.nextDouble();

	}

	public static char leerCaracter(String mensaje) {
		System.out.println(mensaje);
		// Leemos toda una cadena
		String cadena = inputValue.next();
		// y nos quedamos con el carácter 0 (el primero)
		char op = cadena.charAt(0);
		return op;

	}

	public static String leerCadena(String mensaje) {
		System.out.println(mensaje);
		return inputValue.nextLine();

	}

	public static void rellenaArray(int[] array, int min, int max) {
		for (int i = 0; i < array.length; i++) {
			int aleatorio = (int) (Math.random() * (max - min + 1) + min);
			array[i] = aleatorio;
		}
	}
	public static String[] dividirEnPalabras(String cadena){
    		// Quitar espacios en blanco al principio y al final
    		cadena=cadena.trim();
    		// Reemplazar uno o más espacios en blanco por un solo espacio
    		cadena=cadena.replaceAll(" +", " ");
    		// Dividir la cadena en partes por el carácter espacio (devuelve un array con cada una de las partes)
    		return cadena.split(" ");
	}
	public static void rellenaMatriz(int[][] matriz, int min, int max){
		// Producir nuevo int aleatorio entre 0 y (max-1)
		
		int filas = matriz.length;
		int columnas = matriz[0].length;
		for (int i = 0; i < filas; i++){
			for (int j = 0; j < columnas; j++){
			    matriz[i][j] = (int) (Math.random() * (max - min + 1) + min);
			}
		}
	}

	public static void 	mostrarMatriz(int matriz[][]) {
		int i,j; 
		int filas = matriz.length;
		int columnas = matriz[0].length;
		// Recorrido de las filas de la matriz
		for (i=0; i < filas; i++) {
			  // Recorrido de las celdas de una fila
			  for (j=0; j<columnas; j++) {
				  System.out.println("matriz[" + i + "][" + j + "]=" + matriz[i][j] );
			}
		}
	}
}