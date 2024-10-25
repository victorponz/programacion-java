---
typora-copy-images-to: ../assets/img/strings/
typora-root-url: ../../
layout: post
title: Funciones de cadenas
categories: strings
conToc: true
permalink: strings
---
En todos estos programas usaremos las funciones definidas en la clase `Utilidades`

<script src="https://gist.github.com/victorponz/93c93fb7f8d88171b4792d78b8b03259.js"></script>

## Reemplazar (Reemplazar.java)
Realiza un programa que reemplace en una cadena de entrada el carácter de la posición pasada como parámetro por el carácter pasado como parámetro:
Por ejemplo:
cadena original = Chico
posición = 4
resultado = Chica


> -info-En los siguientes ejercicios utiliza la función 
>
> ```java
> String palabras[] = Utilidades.dividirEnPalabras(cadena);
> ```
> Para dividir la cadena en un array de cadenas


## IP 4 (Ip.java)
Escribe un programa para validar una dirección IPv4. 


## Palabras de longitud dada `Longitud.java` (F)

Realiza un programa que lea una cadena de texto y nos diga cuántas palabras tienen una longitud de `k` caracteres.

## Palabras de longitud dada II `Longitud2.java` (F)

Realiza un programa que lea una cadena de texto y nos diga si alguna palabra tiene una longitud de `k` caracteres.


## Palabras de longitud dada III `Longitud3.java` (F)

Escribe un programa que lea una cadena y un número entero `k` y muestre el mensaje "Todas las cadenas son cortas" si todas las palabras tienen una longitud estrictamente menor que `k` y "Hay alguna palabra larga" en caso contrario.

## Dígitos `Digitos.java` (F)

Escribe un programa que muestre la cantidad de dígitos que aparecen en una cadena. Por ejemplo, la cadena "un 1 y un 20", tiene 3 dígitos.

## Dígitos II `Digitos2.java` (D)

Escribe un programa que muestre la cantidad de números que aparecen en una cadena. Por ejemplo, la cadena "1  20 hola 234 45a", tiene 3 números. Las palabras **deben** separarse por blancos.

## Paréntesis `Parentesis.java` (M)

Un texto está bien parentizado si por cada paréntesis abierto hay otro detrás que lo cierra. Por ejemplo, la cadena

> Esto \(es \(un ejemplo\) \(de\) una \(cadena bien\) parentizada\)

está bien parentizada.

Pero las cadenas

> una \)cadena \(mal \(parentizada\)

(una)(

no lo están.

Diseña un programa que nos diga si una cadena está bien parentizada o no.

## Frase invertida `Invertida.java` (F)

Escribe un programa que lea una frase del teclado y luego imprima las palabras que la forman de forma invertida.

Por ejemplo:

```
"Esto es una frase" => "frase una es Esto"  
```
## Insertar `Insertar.java` (M)
Dada una cadena, la tarea es insertar otra cadena entre la cadena dada en un índice particular especificado. Usa la función `substring`
Por ejemplo:
```
cadenaOriginal=Portal de la computadora
cadena a insertar = Ciencias
índice = 9
resultado= Portal de Ciencias de la computadora
```
## Insertar II `InsertarII`
Igual que el anterior pero sólo se puede usar el método `charAt`

## Siglas `Siglas.java` (F)

Realiza un programa que lea un frase y la convierta en unas siglas. Por ejemplo, Escuela Oficial de Idiomas, se convierte en EOI.
Date cuenta que las palabras en minúsculas no forman parte de las siglas.

## Anagrama `Anagrama` (M)
Una cadena se considera anagrama de otra cuando tiene las mismas letras pero el orden no es el mismo

## Alfabética `Alfabetica.java` (M)

Una palabra es _alfabética_ si todas sus letras están ordenadas alfabéticamente. Por ejemplo, "amor", "chino" e "himno" son palabras alfabéticas. Diseña un programa que nos diga si una palabra es alfabética o no.

## Pasatiempos `Pasatiempos.java` (F)

Hay un tipo de pasatiempos que propone descifrar un texto del que se han suprimido las vocales. Por ejemplo, el texto ".n .j.mpl. d. p.s.t..mp.s" se descrifra sustituyendo cada punto por una vocal. La solución es "un ejemplo de pasatiempos".

Diseña un programa que ayude al creador de pasatiempos. Recibirá una cadena y mostrará otra en la que cada vocal ha sido reemplazada por un punto.

## Suma binaria `SumarBinario.java` (D)
Haz un programa que lea dos cadenas que representen a sendos números binarios. A continuación, el programa mostrará el número binario que resulta de sumar ambos (y que será otra cadena\). Si, por ejemplo, el usuario introduce las cadenas '100' y '111', el programa mostrará como resultado la cadena '1011'

## Encriptar `Encriptar.java` (D)

Una de las técnicas de criptografía más rudimentarias consiste en sustituir cada uno de los caracteres por otro situado _n_ posiciones más a la derecha del abecedario. Si _n = 2_, sustituiremos la "a" por la "c", la "b" por la "d", y así sucesivamente. El problema que aparece con las últimas _n_ letras del alfabeto tiene fácil solución: en el ejemplo, la letra "y" se sustituye se sustituye por la "a" y la "z" por la "b". La sustitución debe aplicarse a las letras minúsculas y mayúsculas y a los dígitos. Las letras no deben incluir caracteres no ingleses \(es decir sin "ñ, ç" ni acentos\)
Diseña un programa que lea un texto y el valor n y muestre el texto criptografiado.



