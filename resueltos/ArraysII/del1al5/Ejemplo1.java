import java.util.Arrays;

/**
 * Escribid un programa Java para encontrar los valores duplicados de un array
 * de valores enteros.
 * 
 * @author victor
 *
 */
public class Ejemplo1 {
	public static String duplicados(int[] numeros) {
		String duplicados = "";
		// Recorremos el array buscando el elemento iésimo
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