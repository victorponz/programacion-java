---
typora-copy-images-to: ../assets/img/arraysii/
typora-root-url: ../../
layout: post
title: Arrays en Java II
categories: arrays
conToc: true
permalink: arrays-avanzado
---

> -info-En todos los programas de esta serie usaremos la siguiente clase de utilidades

<script src="https://gist.github.com/victorponz/93c93fb7f8d88171b4792d78b8b03259.js"></script>

## 1 Eliminar

Escribid un programa Java para eliminar de un array un elemento específico (índice) introducido por el usuario  (moviéndolo al final del mismo). Si el índice es mayor que el tamaño del array, debe volver a pedírselo.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Arrays;
> 
> public class Eliminar {
> 	public static void main(String[] args) {
> 		int[] misNumeros = new int[20];
> 		Utilidades.rellenaArray(misNumeros, -30, 30);
> 
> 		System.out.println("Original Array : " + Arrays.toString(misNumeros));
> 
> 		int removeIndex = -1;
> 		do {
> 			removeIndex = Utilidades.leerEntero("Introduce un índice entre 0 y " + (misNumeros.length - 1) + ":");
> 		} while ((removeIndex < 0) || (removeIndex > misNumeros.length - 1));s
>         // Hacemos una copia del elemento a eliminar antes de empezar a mover
>         int numeroAMover = misNumeros[removeIndex];
>         for (int i = removeIndex ; i < misNumeros.length - 1; i++) {
>             // Ahora movemos una posición hacia la izquierda
>             // todos los elementos a partir de removeIndex
>             // Por ejemplo, si removeIndex = 3;
>             // my_array[3] = my_array[4];
>             // my_array[4] = my_array[5];
>             // y así sucesivamente hasta llegar al penúltimo
>             misNumeros[i] = misNumeros[i + 1];
>         }
>         // Y ahora ponemos el número a mover en la última posición
>         misNumeros[misNumeros.length - 1] = numeroAMover;
>         
> 		// No podemos alterar el tamaño del array,
> 		// por lo tanto el último y el penúltimo elementos son iguales
> 		System.out.println("Después de eliminar el " + removeIndex + " elemento: " + Arrays.toString(misNumeros));
> 
> 	}
> }
> ```
>

## 2 Duplicados

Escribid un programa Java para encontrar los valores duplicados de un array de valores enteros.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Arrays;
> 
> public class Duplicados {
> 	public static String duplicados(int[] numeros) {
> 		String duplicados = "";
> 		// Recorremos el array
> 		for (int i = 0; i < numeros.length - 1; i++) {
> 			for (int j = i + 1; j < numeros.length; j++) {
> 				// Recorremos el array buscando a partir del elemento iésimo + 1
> 				if ((numeros[i] == numeros[j])) {
> 					duplicados += numeros[j] + " ";
> 					break;
> 				}
> 			}
> 		}
> 		return duplicados;
> 	}
> 	public static void main(String[] args) {
> 		int[] numeros = new int[20];
> 
> 		Utilidades.rellenaArray(numeros, -30, 30);
> 		System.out.println("Array original: " + Arrays.toString(numeros));
> 		System.out.println("Elementos duplicados: " + duplicados(numeros));
> 	}
> }
> ```

## 3 Comunes

Escribid un programa Java para encontrar los elementos comunes entre dos arrays de enteros.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Arrays;
> 
> public class Comunes {
> 	public static String comunes(int[] original, int[] comparar) {
> 		String comunes = "";
> 		// Recorremos el original para buscar el elemento iésimo
> 		for (int i = 0; i < original.length; i++) {
> 			// Y ahora buscamos en el comparar el elemento iésimo
> 			for (int j = 0; j < comparar.length; j++) {
> 				if (original[i] == comparar[j]) {
> 					comunes += original[i] + " ";
> 					break;
> 				}
> 			}
> 		}
> 		return comunes;
> 	}
> 	public static void main(String[] args) {
> 		int[] array1 = new int[10];
> 		int[] array2 = new int[10];
> 
> 		Utilidades.rellenaArray(array1, -10, 10);
> 		Utilidades.rellenaArray(array2, -10, 10);
> 
> 		// Antes de empezar a trabajar con el array lo imprimimos
> 		System.out.println("Array : " + Arrays.toString(array1));
> 		System.out.println("Array : " + Arrays.toString(array2));
> 
> 		System.out.println("Los elementos comunes son: " + comunes(array1, array2));
> 	}
> }
> ```

## 4 Suma igual

Escribid un programa Java para encontrar todos los pares de elementos en un array cuya suma es igual a un número especificado por el usuario.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Arrays;
> 
> /*
>  * Escribir un programa Java para encontrar todos los pares de elementos en un
>  * array cuya suma es igual a un número especificado por el usuario.
>  */
> public class SumaIgual {
> 	public static String sumaIgual(int[] numeros, int suma) {
> 		String sumanIgual = "";
> 		// Recorremos el array
> 		for (int i = 0; i < numeros.length; i++) {
> 			for (int j = i + 1; j < numeros.length; j++) {
> 				// Recorremos el array sumando a partir del elemento iésimo
> 				if ((numeros[i] + numeros[j]) == suma) {
> 					sumanIgual += "[" + numeros[i] + " + " + numeros[j] + "] ";
> 					break;
> 				}
> 			}
> 		}
> 		return sumanIgual;
> 	}
> 
> 	public static void main(String[] args) {
> 		int[] numeros = new int[10];
> 		int num;
> 		Utilidades.rellenaArray(numeros, 10, -10);
> 
> 		// Antes de empezar a trabajar con el array lo imprimimos
> 		System.out.println("Array : " + Arrays.toString(numeros));
> 
> 		num = Utilidades.leerEntero("Introduce un número entero para buscar");
> 
> 		System.out.println("Los números siguientes: " + sumaIgual(numeros, num) + " suman " + num);
> 
> 	}
> }
> ```

## 5 Iguales 

Escribir un programa Java para probar la igualdad de dos vectores \(en este caso, como será difícil que os dé dos veces el mismo array, igualad el segundo al primero, para probarlo. Esto se hace mediante el método `clone()` del array\).

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Arrays;
> public class Iguales {
> 
> 	public static boolean sonIguales(int[] original, int[] comparar) {
> 		// Recorremos todos los elemetos del primer array
> 		for (int i = 0; i < original.length; i++) {
> 			// Si es distinto al elemento iésimo del segundo array
> 			if (original[i] != comparar[i]) {
> 				// Como ya sabemos que no son iguales, salimos del método y devolvemos false
> 				return false;
> 			}
> 		}
> 		return true;
> 	}
> 	public static void main(String[] args) {
> 		int[] primero = new int[10];
> 		int[] segundo = new int[10];
> 
> 		Utilidades.rellenaArray(primero, 0, 10);
> 		Utilidades.rellenaArray(segundo, 0, 10);
> 
> 		// ********** IMPORTANTE ********************************** 
> 		//Para probar que son iguales, descomenta la siguiente línea
> 		// segundo = primero.clone();
> 
> 		// Antes de empezar a trabajar con el array lo imprimimos
> 		System.out.println("Array : " + Arrays.toString(primero));
> 		System.out.println("Array : " + Arrays.toString(segundo));
> 
> 		if (sonIguales(primero, segundo)) {
> 			System.out.println("Los arrays son iguales");
> 		} else {
> 			System.out.println("Los arrays NO son iguales");
> 		}
> 	}
> }
> ```

## 6 Mover ceros

Escribid un programa Java para mover todos los 0 al final de un array. Mantened el orden relativo de los otros elementos de la array (distintos de cero).

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Arrays;
> 
> /*
>  * Escribir un programa Java para encontrar el número de enteros 
>  * pares e impares en un array dado de números enteros.
>  */
> public class MoverCeros {
> 	public static void eliminarElemento(int[] numeros, int removeIndex) {
> 		// Hacemos una copia del elemento a eliminar antes de empezar a mover
> 		int numeroAMover = numeros[removeIndex];
> 		for (int i = removeIndex; i < numeros.length - 1; i++) {
> 			// Ahora movemos una posición hacia la izquierda todos los elementos a partir de
> 			// removeIndex
> 			// Por ejemplo, si removeIndex = 3;
> 			// my_array[3] = my_array[4];
> 			// my_array[4] = my_array[5];
> 			// y así sucesivamente hasta llegar al penúltimo
> 			numeros[i] = numeros[i + 1];
> 		}
> 		// Y ahora ponemos el número a mover en la última posición
> 		numeros[numeros.length - 1] = numeroAMover;
> 	}
> 	public static void moverCeros(int[] numeros) {
> 		int max = numeros.length;
> 		for (int i = 0; i < max; i++) {
> 			if (numeros[i] == 0) {
> 				for (int j = i; j < numeros.length - 1; j++) {
> 					//Movemos hacia la izquierda todos los elementos
> 					numeros[j] = numeros[j + 1];
> 				}
> 				//Y en el último ponemos un 0
> 				numeros[numeros.length - 1] = 0;
> 				//Y ahora hemos de cambiar la condición del bucle porque ahora ya no llegamos a max sino a max-1
> 				//y debemos volver a empezar en la posición anterior, porque puede ser que ahora haya otro 0!!!
> 				i--;
> 				max--;
> 			}
> 		}
> 	}
> 	public static void moverCerosDos(int[] numeros) {
> 		int max = numeros.length;
> 		for (int i = 0; i < max; i++) {
> 			if (numeros[i] == 0) {
> 				//Usando el método que hicimos en Eliminar.java
> 				eliminarElemento(numeros, i);
> 				//Y ahora hemos de cambiar la condición del bucle porque ahora ya no llegamos a max sino a max-1
> 				//y debemos volver a empezar en la posición anterior, porque puede ser que ahora haya otro 0!!!
> 				i--;
> 				max--;
> 			}
> 		}
> 	}
> 	public static void main(String[] args) {
> 		int[] numeros = new int[20];
> 		int[] clon = new int[20];
> 		
> 		Utilidades.rellenaArray(numeros, 1 , 30);
> 		
> 		//Vamos a poner algún 0 a mano
> 		numeros[0] = 0;
> 		numeros[6] = 0;
> 		numeros[7] = 0;
> 		numeros[10] = 0;
> 		numeros[19] = 0;
> 		
> 		System.out.println("Original Array : " + Arrays.toString(numeros));
> 		//El método está hecho de dos formas, por eso antes de moverlos, lo clono.
> 		clon = numeros.clone();
> 		moverCeros(numeros);
> 	
> 		System.out.println("Método I: Después de mover todos los 0's al final del array");
> 		System.out.println(Arrays.toString(numeros));
> 		
> 		moverCerosDos(clon);
> 		System.out.println("Método II: Después de mover todos los 0's al final del array");
> 		System.out.println(Arrays.toString(clon));
> 	}
> 
> }
> ```

# Matrices

Las matrices son arrays que tienen dos dimensiones

Consultad las siguientes referencias:

* http://puntocomnoesunlenguaje.blogspot.com/2012/12/matriz-en-java.html

* https://mathbits.com/MathBits/Java/arrays/Matrices.htm

> **Nota**. Para imprimir el contenido de una matriz usad:
>
> ```java
> import java.util.Arrays;;
> //...
> System.out.println("matriz : " + Arrays.deepToString(matriz));
> ```

## 7 `RellenaMatriz.java`

Rellena una matriz de 10 x 10 con valores aleatorios \(0 o 1\) e imprímela de la siguiente forma:

![](/programacion-java/assets/img/arraysii/matriz1.png)

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Arrays;
> public class RellenaMatriz {
> 
> 	public static String imprimeMatriz(int[][] matriz) {
> 		String resultado = "";
> 		int filas = matriz.length;
> 		int columnas = matriz[0].length;
> 		//Recorremos todas las filas
> 		for (int i = 0; i < filas; i++) {
> 			// y todas las columnas dentro de la fila iésima
> 			for (int j = 0; j < columnas; j++) {
> 				resultado += matriz[i][j] + " ";
> 			}
> 			// Despúes de cada fila, imprimir un salto de línea
> 			resultado += "\n";
> 		}
> 		return resultado;
> 	}
> 	public static void main(String[] args) {
> 		int[][] matriz = new int[10][10];
> 		Utilidades.rellenaMatriz(matriz, 0, 1);
> 
> 		System.out.println("matriz : "+Arrays.deepToString(matriz));
> 		
> 		System.out.println(imprimeMatriz(matriz));
> 	}
> 
> }
> ```

## 8 `ValoresACero.java`

Modifica el programa anterior para que muestre cuántas filas tienen todos sus valores a 0 y cuántas columnas tienen todos sus valores a 0

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Arrays;
> 
> public class ValoresACero {
> 
> 	public static int filasACero(int[][] matriz) {
> 		int filasConOtroValor = 0;
> 		int filas = matriz.length;
> 		int columnas = matriz[0].length;
> 		//Recorremos todas las filas
> 		for (int i = 0; i < filas; i++) {
> 			// y todas las columnas dentro de la fila iésima
> 			for (int j = 0; j < columnas; j++) {
> 				if (matriz[i][j] != 0) {
> 					filasConOtroValor++;
> 					break;
> 				}
> 			}
> 		}
> 		return filas - filasConOtroValor;
> 	}
> 	
> 	public static int columnasACero(int[][] matriz) {
> 		int columnasConOtroValor = 0;
> 		int filas = matriz.length;
> 		int columnas = matriz[0].length;
> 		//Recorremos todas las columnas
> 		for (int i = 0; i < columnas; i++) {
> 			// y todas las filae
> 			for (int j = 0; j < filas; j++) {
> 				//************** IMPORTANTE *********
> 				//fijaos en el orden de j e i, porque la j recorre las filas y la i recorre las columnas
> 				if (matriz[j][i] != 0) {
> 					columnasConOtroValor++;
> 					break;
> 				}
> 			}
> 		}
> 		return  columnas - columnasConOtroValor;
> 	}
> 	public static void main(String[] args) {
> 		int[][] matriz = new int[3][3];
> 		Utilidades.rellenaMatriz(matriz, 0, 1);
> 
> 		System.out.println("matriz : " + Arrays.deepToString(matriz));
> 	
> 				
> 		System.out.println("Filas con todo 0 : " + filasACero(matriz));
> 		System.out.println("Columnas con todo 0 : " + columnasACero(matriz));
> 
> 	}
> }
> ```

## 9 `Tablero.java`

Escribe un programa que dada una matriz de 8x8 que puede contener los números del 0 al 3, imprima un tablero como el siguiente:

![](/programacion-java/assets/img/arraysii//matriz3.png)

Este tablero parte de la siguiente configuración:

{% raw %}

```java
int[][] tablero = 
 {{0, 0, 1, 1, 0, 1, 0, 0},
  {3, 0, 0, 0, 3, 0, 0, 1},
  {0, 0, 1, 0, 0, 3, 0, 0},
  {2, 0, 0, 0, 3, 0, 0, 0},
  {1, 0, 0, 3, 3, 2, 0, 0},
  {0, 0, 0, 1, 2, 0, 0, 0},
  {0, 0, 0, 1, 0, 0, 0, 0},
  {1, 0, 0, 0, 0, 0, 0, 0}};
```

{% endraw %}

Donde, 0 =&gt; "·", 1 =&gt; "+", 2 =&gt; "0", 3 =&gt; "X".

> -toogle-Piensa antes de mirar
>
> ```java
> public class Tablero {
> 	private static void printTablero(int tablero[][]) {
> 		char[] nombreFilas = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
> 		
> 		//Imprimir la primera fila con los números
> 		System.out.println("  1 2 3 4 5 6 7 8");
> 		
> 		int filas = tablero.length;
> 		int columnas = tablero[0].length;
> 		for (int i = 0; i < filas; i++) {
> 			// Para cada fila, imprimir su letra
> 			System.out.print(nombreFilas[i] + " ");
> 			// Para cada columna imprimir 0, X, +, -, dependiendo de su valor
> 			for (int j = 0; j < columnas; j++) {
> 				if (tablero[i][j] == 2) {
> 					System.out.print("O" + " ");
> 				} else if (tablero[i][j] == 3) {
> 					System.out.print("X" + " ");
> 				} else if (tablero[i][j] == 1) {
> 					System.out.print("+" + " ");
> 				} else {
> 					System.out.print("·" + " ");
> 
> 				}
> 			}
> 			// Al final de cada fila, hacemos un salto de línea
> 			System.out.println("");
> 		}
> 	}
> 	public static void main(String[] args) {
> 		int[][] matriz = new int[8][8];
> 		Utilidades.rellenaMatriz(matriz, 0, 3);
> 		printTablero(matriz);
> 
> 	}
> }
> ```

## 10 `HundirLaFlota.java`

A partir del programa anterior que imprime un tablero, escribir un programa que simule el juego Hundir la Flota sobre un tablero de 8x8. El programa colocará 10 naves al azar en él \(sólo de 1 celda\).  
El usuario introducirá una coordenada \(primera letra y luego número\) y el programa escribirá el tablero completo cada vez con los barcos hundidos \(X\) y disparos perdidos \(O\). Se mostrará el contador de tiros y el número de naves hundidas.

Para generar el tablero aleatorio, usad el siguiente código (si tiene un 1 significa que hay un barco).

<script src="https://gist.github.com/victorponz/73c2e26f005b38e34f5256ffac62abf0.js"></script>

![](/programacion-java/assets/img/arraysii//ships.png)

> -toogle-Piensa antes de mirar
>
> ```java
> public class HundirLaFlota {
> 	public static void crearFlota(int numeroDeBarcos, int[][] tablero) {
> 		int r1, r2;
> 		int cont = 0;
> 
> 		while (cont < numeroDeBarcos) {
> 			r1 = (int) (Math.random() * 8);
> 			r2 = (int) (Math.random() * 8);
> 			if (tablero[r1][r2] != 1) {
> 				tablero[r1][r2] = 1;
> 				cont++;
> 			}
> 		}
> 	}
> 
> 	public static int cuantosHundidos(int matriz[][]) {
> 		int cuantos = 0;
> 		// Con un for cuantas cuántos 2 hay
> 		for (int i = 0; i < matriz.length; i++) {
> 			for (int j = 0; j < matriz[0].length; j++) {
> 				if (matriz[i][j] == 2) {
> 					cuantos++;
> 				}
> 			}
> 		}
> 		return cuantos;
> 	}
> 
> 	public static void printTablero(int tablero[][]) {
> 		char[] nombreFilas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
> 		
> 		//Imprimir la primera fila con los números
> 		System.out.println("  1 2 3 4 5 6 7 8");
> 		
> 		int filas = tablero.length;
> 		int columnas = tablero[0].length;
> 		for (int i = 0; i < filas; i++){
> 			//Para cada fila, imprimir su letra
> 			System.out.print(nombreFilas[i] + " ");
> 			//Para cada columna imprimir 0, X  dependiendo de su valor
> 			for (int j = 0; j < columnas; j++){
> 				if (tablero[i][j] == 2) {
> 					//Agua
> 					System.out.print("O" + " ");
> 				}else if (tablero[i][j] == 3) {
> 					//Hundido
> 					System.out.print("X" + " ");
> 				}else {
> 					//En este caso, no imprimimos nada para no dar pistas!
> 					System.out.print("  ");
> 				}
> 
> 			}
> 			//Al final de cada fila, hacemos un salto de línea
> 			System.out.println("");
> 		}
> 	}
> 	public static void printTableroDebug(int tablero[][]) {
> 		char[] nombreFilas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
> 		
> 		//Imprimir la primera fila con los números
> 		System.out.println("  1 2 3 4 5 6 7 8");
> 		
> 		int filas = tablero.length;
> 		int columnas = tablero[0].length;
> 		for (int i = 0; i < filas; i++){
> 			//Para cada fila, imprimir su letra
> 			System.out.print(nombreFilas[i] + " ");
> 			//Para cada columna imprimir 0, X  dependiendo de su valor
> 			for (int j = 0; j < columnas; j++){
> 				if (tablero[i][j] == 2) {
> 					//Agua
> 					System.out.print("O" + " ");
> 				}else if (tablero[i][j] == 3) {
> 					//Hundido
> 					System.out.print("X" + " ");
> 				}else if (tablero[i][j] == 1) {
> 					System.out.print("+" + " ");
> 				} else {
> 					System.out.print("·" + " ");
> 
> 				}
> 
> 			}
> 			//Al final de cada fila, hacemos un salto de línea
> 			System.out.println("");
> 		}
> 	}
> 	public static void main(String[] args) {
>         final int NUM_BARCOS = 10;
> 		char fila;
> 		int filaNumero;
> 		int columna;
> 		int[][] tableroFlota = new int[8][8];
> 		int contadorHundidos = 0;
> 		int tiros = 0;
> 		
> 		crearFlota(NUM_BARCOS, tableroFlota);
> 		
> 		printTablero(tableroFlota);
> 		//Para depurar, comenta el anterior y usa este
> 		//printTableroDebug(tableroFlota);
> 		do {
> 			//Suponemos que el usuario introduce coordenadas correctas!!
> 			//La letra A tiene el valor entero 65, por eso se lo restamos
> 			//Es decir, cuando se pulsa la letra A corresponde al índice 0 (65 -65); la B es 1 (66 -65), etc
> 			fila = Utilidades.leerCaracter("Introduzca las coordenadas de fila (A - H): ");
> 			filaNumero = fila - 65;
> 			
> 			columna = Utilidades.leerEntero("Introduzca las coordenadas de columna (1 - 8): ");
> 			
> 			//Los arrays empiezan en el índice 0 no 1!!
> 			columna = columna - 1;
> 			
> 			//Aumentar el contador de tiros
> 			tiros++;
> 			
> 			//Si en esa celda hay un 1, es un barco hundido
> 			if (tableroFlota[filaNumero][columna] == 1) {
> 				tableroFlota[filaNumero][columna] = 3;
> 				//Aumentar el contador de hundidos
> 				contadorHundidos++;
> 			} else if (tableroFlota[filaNumero][columna] == 0) {
> 				//Si hay un 0 es que ha hecho agua
> 				tableroFlota[filaNumero][columna] = 2;
> 			}//En otro caso (2 o 3), es que ya ha repetido el tiro, por eso no se contempla
> 			
> 			printTablero(tableroFlota);
> 			//Para depurar, comenta el anterior y usa este
> 			//printTableroDebug(tableroFlota);
> 			
> 			System.out.println("Tiros realizados: " + tiros);
> 			System.out.println("Hundidos: " + contadorHundidos);
> 		} while (contadorHundidos < NUM_BARCOS);
> 
> 	}
> }
> ```
