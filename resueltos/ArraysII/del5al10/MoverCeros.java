import java.util.Arrays;
public class MoverCeros {
	public static void eliminarElemento(int[] numeros, int removeIndex) {
		// Hacemos una copia del elemento a eliminar antes de empezar a mover
		int numeroAMover = numeros[removeIndex];
		for (int i = removeIndex; i < numeros.length - 1; i++) {
			// Ahora movemos una posición hacia la izquierda todos los elementos a partir de
			// removeIndex
			// Por ejemplo, si removeIndex = 3;
			// my_array[3] = my_array[4];
			// my_array[4] = my_array[5];
			// y así sucesivamente hasta llegar al penúltimo
			numeros[i] = numeros[i + 1];
		}
		// Y ahora ponemos el número a mover en la última posición
		numeros[numeros.length - 1] = numeroAMover;
	}
	public static void moverCeros(int[] numeros) {
		int max = numeros.length;
		for (int i = 0; i < max; i++) {
			if (numeros[i] == 0) {
				for (int j = i; j < numeros.length - 1; j++) {
					//Movemos hacia la izquierda todos los elementos
					numeros[j] = numeros[j + 1];
				}
				//Y en el último ponemos un 0
				numeros[numeros.length - 1] = 0;
				//Y ahora hemos de cambiar la condición del bucle porque ahora ya no llegamos a max sino a max-1
				//y debemos volver a empezar en la posición anterior, porque puede ser que ahora haya otro 0!!!
				i--;
				max--;
			}
		}
	}
	public static void moverCerosDos(int[] numeros) {
		int max = numeros.length;
		for (int i = 0; i < max; i++) {
			if (numeros[i] == 0) {
				//Usando el método que hicimos en Eliminar.java
				eliminarElemento(numeros, i);
				//Y ahora hemos de cambiar la condición del bucle porque ahora ya no llegamos a max sino a max-1
				//y debemos volver a empezar en la posición anterior, porque puede ser que ahora haya otro 0!!!
				i--;
				max--;
			}
		}
	}
	public static void main(String[] args) {
		int[] numeros = new int[20];
		int[] clon = new int[20];
		
		Utilidades.rellenaArray(numeros, 1 , 30);
		
		//Vamos a poner algún 0 a mano
		numeros[0] = 0;
		numeros[6] = 0;
		numeros[7] = 0;
		numeros[10] = 0;
		numeros[19] = 0;
		
		System.out.println("Original Array : " + Arrays.toString(numeros));
		//El método está hecho de dos formas, por eso antes de moverlos, lo clono.
		clon = numeros.clone();
		moverCeros(numeros);
	
		System.out.println("Método I: Después de mover todos los 0's al final del array");
		System.out.println(Arrays.toString(numeros));
		
		moverCerosDos(clon);
		System.out.println("Método II: Después de mover todos los 0's al final del array");
		System.out.println(Arrays.toString(clon));
	}

}