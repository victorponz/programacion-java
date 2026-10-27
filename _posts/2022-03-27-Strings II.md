---
typora-copy-images-to: ../assets/img/strings/
typora-root-url: ../../
layout: post
title: Funciones de cadenas
categories: strings
conToc: true
permalink: strings
---

# Principales métodos de `String` en Java

Un `String` es **inmutable**: ningún método modifica la cadena original, sino que devuelve una nueva. Por eso hay que guardar el resultado:

```java
s = s.toUpperCase();
```

En los ejemplos se usa:

```java
String s = "Hola Mundo";
```

------

## 1. Información básica

| Método      | Qué hace                                   | Ejemplo          | Resultado |
| ----------- | ------------------------------------------ | ---------------- | --------- |
| `length()`  | Número de caracteres                       | `s.length()`     | `10`      |
| `charAt(i)` | Carácter en la posición `i` (empieza en 0) | `s.charAt(0)`    | `'H'`     |
| `isEmpty()` | ¿Longitud 0?                               | `"".isEmpty()`   | `true`    |
| `isBlank()` | ¿Vacía o solo espacios? (Java 11+)         | `"  ".isBlank()` | `true`    |

------

## 2. Comparación

| Método                      | Qué hace                                 | Ejemplo                            | Resultado |
| --------------------------- | ---------------------------------------- | ---------------------------------- | --------- |
| `equals(otro)`              | Igualdad de contenido                    | `s.equals("Hola Mundo")`           | `true`    |
| `equalsIgnoreCase(otro)`    | Igual, sin distinguir mayúsculas         | `s.equalsIgnoreCase("HOLA MUNDO")` | `true`    |
| `compareTo(otro)`           | Orden alfabético: negativo, 0 o positivo | `"ana".compareTo("bea")`           | `< 0`     |
| `compareToIgnoreCase(otro)` | Igual, sin distinguir mayúsculas         | `"Ana".compareToIgnoreCase("ana")` | `0`       |

> ⚠️ **Error típico:** comparar cadenas con `==` compara referencias (si son el mismo objeto), no el contenido. Usa siempre `equals()`.

------

## 3. Búsqueda

| Método           | Qué hace                                | Ejemplo              | Resultado |
| ---------------- | --------------------------------------- | -------------------- | --------- |
| `indexOf(x)`     | Primera posición de `x` (-1 si no está) | `s.indexOf('o')`     | `1`       |
| `lastIndexOf(x)` | Última posición de `x`                  | `s.lastIndexOf('o')` | `9`       |
| `contains(x)`    | ¿Contiene `x`?                          | `s.contains("Mun")`  | `true`    |
| `startsWith(x)`  | ¿Empieza por `x`?                       | `s.startsWith("Ho")` | `true`    |
| `endsWith(x)`    | ¿Termina en `x`?                        | `s.endsWith("do")`   | `true`    |

------

## 4. Extracción y transformación

| Método                | Qué hace                                        | Ejemplo               | Resultado      |
| --------------------- | ----------------------------------------------- | --------------------- | -------------- |
| `substring(ini)`      | Desde `ini` hasta el final                      | `s.substring(5)`      | `"Mundo"`      |
| `substring(ini, fin)` | Desde `ini` hasta `fin` (**sin incluir** `fin`) | `s.substring(0, 4)`   | `"Hola"`       |
| `toUpperCase()`       | A mayúsculas                                    | `s.toUpperCase()`     | `"HOLA MUNDO"` |
| `toLowerCase()`       | A minúsculas                                    | `s.toLowerCase()`     | `"hola mundo"` |
| `trim()` / `strip()`  | Quita espacios al principio y al final          | `"  hola ".trim()`    | `"hola"`       |
| `replace(a, b)`       | Sustituye todas las apariciones de `a` por `b`  | `s.replace('o', '0')` | `"H0la Mund0"` |
| `concat(x)`           | Concatena (equivale a `+`)                      | `"Hola".concat("!")`  | `"Hola!"`      |
| `repeat(n)`           | Repite la cadena `n` veces (Java 11+)           | `"ab".repeat(3)`      | `"ababab"`     |

------

## 5. División, unión y conversión

| Método                  | Qué hace                                                     | Ejemplo                          | Resultado              |
| ----------------------- | ------------------------------------------------------------ | -------------------------------- | ---------------------- |
| `split(sep)`            | Divide en un array                                           | `"a,b,c".split(",")`             | `["a", "b", "c"]`      |
| `String.join(sep, ...)` | Une elementos con un separador                               | `String.join("-", "a", "b")`     | `"a-b"`                |
| `toCharArray()`         | Convierte a array de `char`                                  | `"hola".toCharArray()`           | `['h', 'o', 'l', 'a']` |
| `String.valueOf(x)`     | Convierte cualquier tipo a `String`                          | `String.valueOf(42)`             | `"42"`                 |
| `Integer.parseInt(s)`   | `String` a `int` (método de `Integer`, pero muy usado con cadenas) | `Integer.parseInt("42")`         | `42`                   |
| `String.format(...)`    | Crea una cadena con formato                                  | `String.format("%.2f", 3.14159)` | `"3.14"`               |

------

## 6. Ejemplo integrador

```java
public class EjemploString {
    public static void main(String[] args) {
        // Poner en mayúscula la primera letra
        String nombre = "  ana garcía  ";
        nombre = nombre.trim();                                  // "ana garcía"
        String inicial = nombre.substring(0, 1).toUpperCase();   // "A"
        String resto = nombre.substring(1);                      // "na garcía"
        System.out.println(inicial + resto);                     // "Ana garcía"

        // Dividir una cadena y recorrer sus partes
        String[] partes = "rojo;verde;azul".split(";");
        for (String color : partes) {
            System.out.println(color + " tiene " + color.length() + " letras");
        }

        // Contar las vocales de una frase
        String frase = "Programar en Java";
        int vocales = 0;
        for (int i = 0; i < frase.length(); i++) {
            char c = Character.toLowerCase(frase.charAt(i));
            if ("aeiou".indexOf(c) != -1) {
                vocales++;
            }
        }
        System.out.println("Vocales: " + vocales);               // 6
    }
}
```

------

## Resumen rápido

- Las posiciones empiezan en **0** y la última es `length() - 1`.
- `substring(ini, fin)` **no incluye** la posición `fin`.
- Los métodos **devuelven** una cadena nueva: guarda el resultado.
- Para comparar contenido: **`equals()`**, nunca `==`.

## Analizar una palabra

Pide al usuario una palabra y muestra:

- Su longitud.
- La primera y la última letra.
- La palabra en mayúsculas y en minúsculas.
- Cuántas veces aparece la letra `a` (sin distinguir mayúsculas).****

## ¿Es un palíndromo?

Pide una frase y muestra:

- La frase invertida.
- Si es un palíndromo, ignorando espacios y mayúsculas.

## Formatear nombre y generar usuario

Pide un nombre completo (nombre y dos apellidos) que el usuario puede escribir mal, con espacios de sobra y mayúsculas mezcladas. El programa debe:

1. Mostrar el nombre bien formateado: cada palabra con la primera letra en mayúscula y el resto en minúscula, separadas por un solo espacio.
2. Mostrar las iniciales con punto.
3. Generar un nombre de usuario: inicial del nombre + primer apellido + inicial del segundo apellido, todo en minúsculas.
4. Si no se introducen exactamente tres palabras, mostrar un mensaje de error.

## Palabras de longitud dada `Longitud.java` (F)

Realiza un programa que lea una cadena de texto y nos diga cuántas palabras tienen una longitud de `k` caracteres.

Para extraer las palabras de la frase usa `split("\\s+")` que te creará un array de Strings con cada una de ellas

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
