import java.util.Arrays;
public class Iguales {

	public static boolean sonIguales(int[] original, int[] comparar) {
		// Recorremos todos los elemetos del primer array
		for (int i = 0; i < original.length; i++) {
			// Si es distinto al elemento iésimo del segundo array
			if (original[i] != comparar[i]) {
				// Como ya sabemos que no son iguales, salimos del método y devolvemos false
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[] primero = new int[10];
		int[] segundo = new int[10];

		Utilidades.rellenaArray(primero, 0, 10);
		Utilidades.rellenaArray(segundo, 0, 10);

		// ********** IMPORTANTE ********************************** 
		//Para probar que son iguales, descomenta la siguiente línea
		// segundo = primero.clone();

		// Antes de empezar a trabajar con el array lo imprimimos
		System.out.println("Array : " + Arrays.toString(primero));
		System.out.println("Array : " + Arrays.toString(segundo));

		if (sonIguales(primero, segundo)) {
			System.out.println("Los arrays son iguales");
		} else {
			System.out.println("Los arrays NO son iguales");
		}
	}
}