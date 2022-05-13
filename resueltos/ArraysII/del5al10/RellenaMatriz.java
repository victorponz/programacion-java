import java.util.Arrays;
public class RellenaMatriz {

	public static String imprimeMatriz(int[][] matriz) {
		String resultado = "";
		int filas = matriz.length;
		int columnas = matriz[0].length;
		//Recorremos todas las filas
		for (int i = 0; i < filas; i++) {
			// y todas las columnas dentro de la fila iésima
			for (int j = 0; j < columnas; j++) {
				resultado += matriz[i][j] + " ";
			}
			// Despúes de cada fila, imprimir un salto de línea
			resultado += "\n";
		}
		return resultado;
	}
	public static void main(String[] args) {
		int[][] matriz = new int[10][10];
		Utilidades.rellenaMatriz(matriz, 0, 1);

		System.out.println("matriz : "+Arrays.deepToString(matriz));
		
		System.out.println(imprimeMatriz(matriz));
	}

}