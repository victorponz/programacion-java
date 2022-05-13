import java.util.Arrays;

public class Duplicados {
	public static String duplicados(int[] numeros) {
		String duplicados = "";
		// Recorremos el array
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int j = i + 1; j < numeros.length; j++) {
				// Recorremos el array buscando a partir del elemento iésimo + 1
				if ((numeros[i] == numeros[j])) {
					duplicados += numeros[j] + " ";
					break;
				}
			}
		}
		return duplicados;
	}
	public static void main(String[] args) {
		int[] numeros = new int[20];

		Utilidades.rellenaArray(numeros, -30, 30);
		System.out.println("Array original: " + Arrays.toString(numeros));
		System.out.println("Elementos duplicados: " + duplicados(numeros));
	}
}