import java.util.Arrays;

public class Comunes {
	public static String comunes(int[] original, int[] comparar) {
		String comunes = "";
		// Recorremos el original para buscar el elemento iésimo
		for (int i = 0; i < original.length; i++) {
			// Y ahora buscamos en el comparar el elemento iésimo
			for (int j = 0; j < comparar.length; j++) {
				if (original[i] == comparar[j]) {
					comunes += original[i] + " ";
					break;
				}
			}
		}
		return comunes;
	}
	public static void main(String[] args) {
		int[] array1 = new int[10];
		int[] array2 = new int[10];

		Utilidades.rellenaArray(array1, -10, 10);
		Utilidades.rellenaArray(array2, -10, 10);

		// Antes de empezar a trabajar con el array lo imprimimos
		System.out.println("Array : " + Arrays.toString(array1));
		System.out.println("Array : " + Arrays.toString(array2));

		System.out.println("Los elementos comunes son: " + comunes(array1, array2));
	}
}