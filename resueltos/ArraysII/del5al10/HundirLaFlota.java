public class HundirLaFlota {
	public static void crearFlota(int numeroDeBarcos, int[][] tablero) {
		int r1, r2;
		int cont = 0;

		while (cont < numeroDeBarcos) {
			r1 = (int) (Math.random() * 8);
			r2 = (int) (Math.random() * 8);
			if (tablero[r1][r2] != 1) {
				tablero[r1][r2] = 1;
				cont++;
			}
		}
	}

	public static int cuantosHundidos(int matriz[][]) {
		int cuantos = 0;
		// Con un for cuantas cuántos 2 hay
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] == 2) {
					cuantos++;
				}
			}
		}
		return cuantos;
	}

	public static void printTablero(int tablero[][]) {
		char[] nombreFilas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		
		//Imprimir la primera fila con los números
		System.out.println("  1 2 3 4 5 6 7 8");
		
		int filas = tablero.length;
		int columnas = tablero[0].length;
		for (int i = 0; i < filas; i++){
			//Para cada fila, imprimir su letra
			System.out.print(nombreFilas[i] + " ");
			//Para cada columna imprimir 0, X  dependiendo de su valor
			for (int j = 0; j < columnas; j++){
				if (tablero[i][j] == 2) {
					//Agua
					System.out.print("O" + " ");
				}else if (tablero[i][j] == 3) {
					//Hundido
					System.out.print("X" + " ");
				}else {
					//En este caso, no imprimimos nada para no dar pistas!
					System.out.print("  ");
				}

			}
			//Al final de cada fila, hacemos un salto de línea
			System.out.println("");
		}
	}
	public static void printTableroDebug(int tablero[][]) {
		char[] nombreFilas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		
		//Imprimir la primera fila con los números
		System.out.println("  1 2 3 4 5 6 7 8");
		
		int filas = tablero.length;
		int columnas = tablero[0].length;
		for (int i = 0; i < filas; i++){
			//Para cada fila, imprimir su letra
			System.out.print(nombreFilas[i] + " ");
			//Para cada columna imprimir 0, X  dependiendo de su valor
			for (int j = 0; j < columnas; j++){
				if (tablero[i][j] == 2) {
					//Agua
					System.out.print("O" + " ");
				}else if (tablero[i][j] == 3) {
					//Hundido
					System.out.print("X" + " ");
				}else if (tablero[i][j] == 1) {
					System.out.print("+" + " ");
				} else {
					System.out.print("·" + " ");

				}

			}
			//Al final de cada fila, hacemos un salto de línea
			System.out.println("");
		}
	}
	public static void main(String[] args) {
        final int NUM_BARCOS = 10;
		char fila;
		int filaNumero;
		int columna;
		int[][] tableroFlota = new int[8][8];
		int contadorHundidos = 0;
		int tiros = 0;
		
		crearFlota(NUM_BARCOS, tableroFlota);
		
		printTablero(tableroFlota);
		//Para depurar, comenta el anterior y usa este
		//printTableroDebug(tableroFlota);
		do {
			//Suponemos que el usuario introduce coordenadas correctas!!
			//La letra A tiene el valor entero 65, por eso se lo restamos
			//Es decir, cuando se pulsa la letra A corresponde al índice 0 (65 -65); la B es 1 (66 -65), etc
			fila = Utilidades.leerCaracter("Introduzca las coordenadas de fila (A - H): ");
			filaNumero = fila - 65;
			
			columna = Utilidades.leerEntero("Introduzca las coordenadas de columna (1 - 8): ");
			
			//Los arrays empiezan en el índice 0 no 1!!
			columna = columna - 1;
			
			//Aumentar el contador de tiros
			tiros++;
			
			//Si en esa celda hay un 1, es un barco hundido
			if (tableroFlota[filaNumero][columna] == 1) {
				tableroFlota[filaNumero][columna] = 3;
				//Aumentar el contador de hundidos
				contadorHundidos++;
			} else if (tableroFlota[filaNumero][columna] == 0) {
				//Si hay un 0 es que ha hecho agua
				tableroFlota[filaNumero][columna] = 2;
			}//En otro caso (2 o 3), es que ya ha repetido el tiro, por eso no se contempla
			
			printTablero(tableroFlota);
			//Para depurar, comenta el anterior y usa este
			//printTableroDebug(tableroFlota);
			
			System.out.println("Tiros realizados: " + tiros);
			System.out.println("Hundidos: " + contadorHundidos);
		} while (contadorHundidos < NUM_BARCOS);

	}
}