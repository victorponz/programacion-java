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

## 2 Duplicados

Escribid un programa Java para encontrar los valores duplicados de un array de valores enteros.

## 3 Comunes

Escribid un programa Java para encontrar los elementos comunes entre dos arrays de enteros.

## 4 Suma igual

Escribid un programa Java para encontrar todos los pares de elementos en un array cuya suma es igual a un número especificado por el usuario.

## 5 Iguales 

Escribir un programa Java para probar la igualdad de dos vectores \(en este caso, como será difícil que os dé dos veces el mismo array, igualad el segundo al primero, para probarlo. Esto se hace mediante el método `clone()` del array\).
## 6 Mover ceros

Escribid un programa Java para mover todos los 0 al final de un array. Mantened el orden relativo de los otros elementos de la array (distintos de cero).
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
## 10 `HundirLaFlota.java`

A partir del programa anterior que imprime un tablero, escribir un programa que simule el juego Hundir la Flota sobre un tablero de 8x8. El programa colocará 10 naves al azar en él \(sólo de 1 celda\).  
El usuario introducirá una coordenada \(primera letra y luego número\) y el programa escribirá el tablero completo cada vez con los barcos hundidos \(X\) y disparos perdidos \(O\). Se mostrará el contador de tiros y el número de naves hundidas.

Para generar el tablero aleatorio, usad el siguiente código (si tiene un 1 significa que hay un barco).

<script src="https://gist.github.com/victorponz/73c2e26f005b38e34f5256ffac62abf0.js"></script>

![](/programacion-java/assets/img/arraysii//ships.png)

