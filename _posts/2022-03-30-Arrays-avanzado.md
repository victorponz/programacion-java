---
typora-copy-images-to: ../assets/img/java-basico/
typora-root-url: ../../
layout: post
title: Arrays en Java II
categories: parte1
conToc: true
permalink: arrays-avanzado
---

> -alert-En todos los programas de esta serie usaremos la siguiente clase de utilidades

<script src="https://gist.github.com/victorponz/93c93fb7f8d88171b4792d78b8b03259.js"></script>

## 1 Eliminar

Escribid un programa Java para eliminar de un array un elemento específico (índice) introducido por el usuario  (moviéndolo al final del mismo). Si el índice es mayor que el tamaño del array, debe volver a pedírselo.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Arrays;
> 
> public class Ejemplo10 {
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
> 
> }
> ```
>



## 2 Duplicados

Escribid un programa Java para encontrar los valores duplicados de un array de valores enteros.

## 3 Comunes

Escribid un programa Java para encontrar los elementos comunes entre dos arrays de enteros.

## 4 Suma igual

Escribid un programa Java para encontrar todos los pares de elementos en un array cuya suma es igual a un número especificado por el usuario.

## 5 Iguales 

Escribir un programa Java para probar la igualdad de dos vectores \(en este caso, como será difícil que os dé dos veces el mismo array, igualad el segundo al primero, para probarlo, Esto se hace mediante el método `clone()` del array\).

## 6 Mover ceros

Escribid un programa Java para mover todos los 0 al final de un array. Mantened el orden relativo de los otros elementos de la array (distintos de cero).

