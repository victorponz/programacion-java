import java.util.Scanner;
public class Ejemplo2 {
	public static void main(String[] args) {
		// Declara un array de enteros de 10 elementos
		int[] anArray = new int[10];
		Scanner inputValue = new Scanner(System.in);

		System.out.println("Introduce 10 números enteros");

		for (int i = 0; i < 10; i++) {
			anArray[i] = inputValue.nextInt();
		}
		inputValue.close();

		// Recorre un array mediante un for en orden inverso
		// Empezamos el la última posición. Cuidado!!
		for (int i = anArray.length - 1; i >= 0; i--) {
			System.out.println(anArray[i]);
		}
	}
}