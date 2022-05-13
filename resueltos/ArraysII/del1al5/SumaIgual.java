import java.util.Arrays;

public class SumaIgual {
	public static String sumaIgual(int[] numeros, int suma) {
		String sumanIgual = "";
		// Recorremos el array
		for (int i = 0; i < numeros.length; i++) {
			for (int j = i + 1; j < numeros.length; j++) {
				// Recorremos el array sumando a partir del elemento iésimo
				if ((numeros[i] + numeros[j]) == suma) {
					sumanIgual += "[" + numeros[i] + " + " + numeros[j] + "] ";
					break;
				}
			}
		}
		return sumanIgual;
	}
	public static void main(String[] args) {
		int[] numeros = new int[10];
		int num;
		Utilidades.rellenaArray(numeros, 10, -10);

		// Antes de empezar a trabajar con el array lo imprimimos
		System.out.println("Array : " + Arrays.toString(numeros));

		num = Utilidades.leerEntero("Introduce un número entero para buscar");

		System.out.println("Los números siguientes: " + sumaIgual(numeros, num) + " suman " + num);
	}
}