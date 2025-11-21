---
typora-copy-images-to: ../assets/img/strings/
typora-root-url: ../../
layout: post
title: Funciones de cadenas
categories: strings
conToc: true
permalink: strings
---

## Palabras de longitud dada `Longitud.java` (F)

Realiza un programa que lea una cadena de texto y nos diga cuántas palabras tienen una longitud de `k` caracteres.

## Palabras de longitud dada II `Longitud2.java` (F)

Realiza un programa que lea una cadena de texto y nos diga si alguna palabra tiene una longitud de `k` caracteres.


## Palabras de longitud dada III `Longitud3.java` (F)

Escribe un programa que lea una cadena y un número entero `k` y muestre el mensaje "Todas las cadenas son cortas" si todas las palabras tienen una longitud estrictamente menor que `k` y "Hay alguna palabra larga" en caso contrario.

## Dígitos `Digitos.java` (F)

Escribe un programa que muestre la cantidad de dígitos que aparecen en una cadena. Por ejemplo, la cadena "1 20 hola 234 45a", tiene 8 dígitos.

## Dígitos II `Digitos2.java` (D)

Escribe un programa que muestre la cantidad de números que aparecen en una cadena. Por ejemplo, la cadena "1 20 hola 234 45a", tiene 3 números. Las palabras **deben** separarse por blancos.

## Paréntesis `Parentesis.java` (M)

Un texto está bien parentizado si por cada paréntesis abierto hay otro detrás que lo cierra. Por ejemplo, la cadena

> Esto \(es \(un ejemplo\) \(de\) una \(cadena bien\) parentizada\)

está bien parentizada.

Pero las cadenas

> una \)cadena \(mal \(parentizada\)
>
> **y**
>
> (una)(

no lo están.

Diseña un programa que nos diga si una cadena está bien parentizada o no.

## Frase invertida `Invertida.java` (F)

Escribe un programa que lea una frase del teclado y luego imprima las palabras que la forman de forma invertida.

Por ejemplo:

```
"Esto es una frase" => "frase una es Esto"  
```
## Siglas `Siglas.java` (F)

Realiza un programa que lea un frase y la convierta en unas siglas. Por ejemplo, Escuela Oficial de Idiomas, se convierte en EOI.
Date cuenta que las palabras en minúsculas no forman parte de las siglas.

## Alfabética `Alfabetica.java` (M)

Una palabra es _alfabética_ si todas sus letras están ordenadas alfabéticamente. Por ejemplo, "amor", "chino" e "himno" son palabras alfabéticas. Diseña un programa que nos diga si una palabra es alfabética o no.

## Pasatiempos `Pasatiempos.java` (F)

Hay un tipo de pasatiempos que propone descifrar un texto del que se han suprimido las vocales. Por ejemplo, el texto ".n .j.mpl. d. p.s.t..mp.s" se descrifra sustituyendo cada punto por una vocal. La solución es "un ejemplo de pasatiempos".

Diseña un programa que ayude al creador de pasatiempos. Recibirá una cadena y mostrará otra en la que cada vocal ha sido reemplazada por un punto.

## Suma binaria `SumarBinario.java` (D)
Haz un programa que lea dos cadenas que representen a sendos números binarios. A continuación, el programa mostrará el número binario que resulta de sumar ambos (y que será otra cadena\). Si, por ejemplo, el usuario introduce las cadenas '100' y '111', el programa mostrará como resultado la cadena '1011'

## Palíndromo `Palindromo`(M)
Una palabra es palíndroma si se lee igual de derecha a izquierda como de izquierda a derecha. Haz un programa para saber si una palabra es palíndroma.

## Encadenando palabras (M)

A Samuel y a Clara les encanta jugar a encadenar palabras. Si Samuel dice *Mata*, Clara sigue diciendo *Tapa*. Samuel le sigue el juego diciendo *Papa* y Clara remata diciendo *Pato*.

Normalmente no tarda mucho en estallar la discusión cuando alguno piensa que el otro lo ha hecho mal. En realidad Samuel acaba de aprender a leer y a Clara todavía le queda un poco para empezar... así que es  normal que tengan conflictos, pero lo cierto es que sus padres acaban cansados de tantas discusiones.

¿Puedes hacer un programa que les diga a Samuel y a Clara si su lista de palabras encadenadas está bien? No te preocupes por la existencia o inexistencia de las palabras que usan, de eso seguirán ocupándose sus  sufridos padres.

Cada palabra, de un mínimo de 2 caracteres, **está  separada de la siguiente mediante un espacio**. Clara y Samuel no tienen  aún demasiado vocabulario, por lo que podemos asegurar que las palabras  que utilizan están **formadas por sílabas formadas por dos letras**.

Por ejemplo

```
gugutata -> Sí (solo tiene una sílaba)
mata tapa papa pato -> Sí
seto taco coma matute -> No
sien encima mapa patuco comida -> Sí
cata tasama malote tejaba batama -> Sí
kiosko comida -> No
```

## Boleto de lotería

Cuando se creo la lotería y se estaban redactando las bases del sorteo, omitieron la coletilla *y en el mismo orden* . Menos mal que se dieron cuenta y lo corrigieron.

El programa trata de averiguar si un boleto comprado coincide con los dígitos del boleto premiado, aunque no estén en el mismo orden.

> Por ejemplo:
>
> Premiado: 12345 Boleto: 54321 -> Ha ganado
>
> Premiado: 12345 Boleto: 12345 -> Ha ganado
>
> Premiado: 89345 Boleto: 89541 -> Ha perdido
