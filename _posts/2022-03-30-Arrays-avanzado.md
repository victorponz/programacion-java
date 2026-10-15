---
typora-copy-images-to: ../assets/img/arraysii/
typora-root-url: ../../
layout: post
title: Arrays en Java II
categories: arrays
conToc: true
permalink: arrays-avanzado
---

## `Duplicados.java (M)`

<span style='color:green'> (ra3.b, ra3.f, ra5.c, ra6.a, r3.c)</span>

Escribid un programa Java para encontrar los valores duplicados de un array de valores enteros.

## `Comunes.java` (F)

<span style='color:green'> (ra3.b, ra3.f, ra5.c, ra6.a, r3.c)</span>

Escribid un programa Java para encontrar los elementos comunes entre dos arrays de enteros.

## `SumaIgual.java` (F)

<span style='color:green'> (ra3.b, ra3.f, ra5.c, ra6.a)</span>

Escribid un programa Java para encontrar todos los pares de elementos en un array cuya suma es igual a un número especificado por el usuario.

## `Eliminar.java` (D)

<span style='color:green'> (ra3.b, ra3.f, ra5.c, ra6.a)</span>

Escribid un programa Java para eliminar de un array un elemento específico (índice) introducido por el usuario  (moviéndolo al final del mismo). Si el índice es mayor que el tamaño del array, debe volver a pedírselo.

Escribid un programa Java para mover todos los 0 al final de un array. Mantened el orden relativo de los otros elementos de la array (distintos de cero).
## `Inverso.java` (F)

<span style='color:green'> (ra3.b, ra3.f, ra5.c, ra6.a)</span>

Crea un programa que a partir de un array de enteros, cree una copia en otro array con los elementos en orden inverso

## `EstacionMeteorologica.java`

**Contexto:** Una estación registra la temperatura máxima de cada día de la semana. El programa guarda las temperaturas en un `double[7]` y los nombres de los días en un `String[7]`.

**Requisitos:**

1. Pedir las 7 temperaturas mostrando el nombre del día. Solo se aceptan valores entre -30 y 50; si el valor no es válido, se vuelve a pedir.
2. Mostrar la temperatura media de la semana con dos decimales.
3. Mostrar la temperatura máxima y la mínima indicando **en qué día** se produjeron.
4. Listar los días que superaron la media.
5. Indicar entre qué dos días consecutivos se produjo la mayor subida de temperatura y de cuántos grados fue.
6. Dibujar un gráfico de barras horizontal con asteriscos, uno por grado (los valores negativos se muestran con `-`).

**Restricciones:** cada apartado debe ser un **método independiente** que reciba el array como parámetro. El `main` solo puede 

![image-20261015101156732](/programacion-java/assets/img/arraysii/image-20261015101156732.png)

## `Ahorcado.java`

**Contexto:** El programa contiene un array con al menos 15 palabras y elige una al azar.

**Requisitos:**

1. Convertir la palabra secreta en un `char[]` y crear otro `char[]` del mismo tamaño relleno de `'_'` para mostrar el progreso.
2. Pedir letras al jugador. Se rechaza todo lo que no sea una única letra.
3. Guardar las letras ya usadas en un array y avisar si se repite una.
4. Si la letra está en la palabra, descubrir **todas** sus apariciones; si no, restar un intento (6 en total).
5. Mostrar en cada turno: progreso, letras falladas, intentos restantes y un dibujo del ahorcado que evoluciona con los fallos (los dibujos pueden guardarse en un array de `String`, uno por fase).
6. La partida acaba al adivinar la palabra o agotar los intentos, mostrando la solución.

**Ampliación opcional:** las palabras se clasifican por categorías (matriz `String[][]`, una fila por categoría) y el jugador elige la categoría antes de empezar. Las tildes deben tratarse como letras sin tilde (si el jugador escribe `a`, se descubre también la `á`).

Para dibujar el ahorcado 

![image-20261015102218778](/programacion-java/assets/img/arraysii/image-20261015102218778.png)

usa 

```java
   static final String[] DIBUJOS = {
        "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
        "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
    };
```

donde cada fila (desde 0) imprime la figura asociada al número de errores

![image-20261015102533736](/programacion-java/assets/img/arraysii/image-20261015102533736.png)
