public class Ejemplo1 {
	public static void main(String[] args) {
		// Declara un array de enteros
		int[] anArray;

		// Reserva memoria para 10 enteros
		anArray = new int[10];

		// Inicializa el primer elemento (que empieza en 0);
		anArray[0] = 100;
		// y el segundo
		anArray[1] = 200;
		// y los siguientes
		anArray[2] = 300;
		anArray[3] = 400;
		anArray[4] = 500;
		anArray[5] = 600;
		anArray[6] = 700;
		anArray[7] = 800;
		anArray[8] = 900;
		anArray[9] = 1000;

		// Recorre un array mediante un for
		// Cuidado que empieza en 0 y acaba en anArray.length - 1;
		// Si intentáis acceder a la posición 10 saltará la excepción:
		// Java.lang.ArrayIndexOutOfBoundsException
		for (int i = 0; i < anArray.length; i++) {
			// Y accedemos al valor de la posición iésima
			System.out.println(anArray[i]);
		}
	}
}