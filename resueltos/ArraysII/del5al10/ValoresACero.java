import java.util.Arrays;

public class ValoresACero {

	public static int filasACero(int[][] matriz) {
		int filasConOtroValor = 0;
		int filas = matriz.length;
		int columnas = matriz[0].length;
		//Recorremos todas las filas
		for (int i = 0; i < filas; i++) {
			// y todas las columnas dentro de la fila iésima
			for (int j = 0; j < columnas; j++) {
				if (matriz[i][j] != 0) {
					filasConOtroValor++;
					break;
				}
			}
		}
		return filas - filasConOtroValor;
	}
	
	public static int columnasACero(int[][] matriz) {
		int columnasConOtroValor = 0;
		int filas = matriz.length;
		int columnas = matriz[0].length;
		//Recorremos todas las columnas
		for (int i = 0; i < columnas; i++) {
			// y todas las filae
			for (int j = 0; j < filas; j++) {
				//************** IMPORTANTE *********
				//fijaos en el orden de j e i, porque la j recorre las filas y la i recorre las columnas
				if (matriz[j][i] != 0) {
					columnasConOtroValor++;
					break;
				}
			}
		}
		return  columnas - columnasConOtroValor;
	}
	public static void main(String[] args) {
		int[][] matriz = new int[3][3];
		Utilidades.rellenaMatriz(matriz, 0, 1);

		System.out.println("matriz : " + Arrays.deepToString(matriz));
	
				
		System.out.println("Filas con todo 0 : " + filasACero(matriz));
		System.out.println("Columnas con todo 0 : " + columnasACero(matriz));

	}
}