public class Ejemplo4 {

	public static void main(String[] args) {
		int sumaNotas = 0;
		// Declara un array de enteros
		int[] numeros = {5, 7, 55, 8, 90, 33, 45, 68, 21, 10};

		for (int nota : numeros) {
			sumaNotas += nota;
		}

		System.out.println("La nota media es " + ((float) sumaNotas / (float) numeros.length));
		
	}
}