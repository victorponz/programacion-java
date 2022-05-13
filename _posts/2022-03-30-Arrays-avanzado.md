---
typora-copy-images-to: ../assets/img/java-basico/
typora-root-url: ../../
layout: post
title: Arrays en Java II
categories: parte1
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

