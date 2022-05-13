---
typora-copy-images-to: ../assets/img/strings/
typora-root-url: ../../
layout: post
title: Strings II
categories: parte1
conToc: true
permalink: strings-II
---



# Funciones de cadenas (String)

En todos estos programas usaremos las funciones definidas en la clase `Utilidades`

<script src="https://gist.github.com/victorponz/93c93fb7f8d88171b4792d78b8b03259.js"></script>

## 13 Dígitos `Digitos.java`

Escribe un programa que muestre la cantidad de dígitos que aparecen en una cadena. Por ejemplo, la cadena "un 1 y un 20", tiene 3 dígitos.

## 14 (Opcional) Dígitos II `Digitos2.java`

Escribe un programa que muestre la cantidad de números que aparecen en una cadena. Por ejemplo, la cadena "un 1, un 20 y un 234", tiene 3 números.

## 15 Paréntesis `Parentesis.java`

Un texto está bien parentizado si por cada paréntesis abierto hay otro detrás que lo cierra. Por ejemplo, la cadena

> Esto \(es \(un ejemplo\) \(de\) una \(cadena bien\) parentizada\)

está bien parentizada.  
Pero la cadena

> una \)cadena \(mal \(parentizada\)

no lo está.

Diseña un programa que nos siga si una cadena está bien parentizada o no.

## 16 Frase invertida `Invertida.java`

Escribe un programa que lea una frase del teclado y luego imprima las palabras que la forman de forma invertida.  

Por ejemplo:

"Esto es una frase" =&gt; "frase una es Esto"  

Debes hacer dos funciones:  

1. La primera tiene un argumento de tipo cadena y debe devolver un array de Strings con las palabras que forman la frase.

   ```java
   public static String[] palabras(String frase)
   ```

2. La segunda tiene como parámetro un array de Strings y devuelve un String con el array de forma invertida.

   ```java
   public static String invertir(String[] palabras)
   ```

## 17 Siglas `Siglas.java`

Realiza un programa que lea un frase y la convierta en unas siglas. Por ejemplo, Escuela Oficial de Idiomas, se convierte en EOI.
Date cuenta que las palabras en minúsculas no forman parte de las siglas.
Debes hacer dos funciones:  

1. La primera tiene un argumento de tipo cadena y debe devolver un array de Strings con las palabras que forman la frase

```java
public static String[] palabras(String frase)
```

2. La segunda tiene como parámetro un array de Strings y devuelve un String con las siglas

```java
 public static String siglas(String[] palabras)
```

## 18 Alfabética `Alfabetica.java`

Una palabra es _alfabética_ si todas sus letras están ordenadas alfabéticamente. Por ejemplo, "amor", "chino" e "himno" son palabras alfabéticas. Diseña un programa que nos diga si una palabra es alfabética o no.

## 19 Pasatiempos `Pasatiempos.java`

Hay un tipo de pasatiempos que propone descifrar un texto del que se han suprimido las vocales. Por ejemplo, el texto ".n .j.mpl. d. p.s.t..mp.s" se descrifra sustituyendo cada punto por una vocal. La solución es "un ejemplo de pasatiempos".  
Diseña un programa que ayude al creador de pasatiempos. Recibirá una cadena y mostrará otra en la que cada vocal ha sido reemplazada por un punto.

## 20 (Opcional) Suma binaria `SumarBinario.java`

Haz un programa que lea dos cadenas que representen a sendos números binarios. A continuación, el programa mostrará el número binario que resulta de sumar ambos (y que será otra cadena\). Si, por ejemplo, el usuario introduce las cadenas '100' y '111', el programa mostrará como resultado la cadena '1011'

## 21 Encriptar `Encriptar.java`

Una de las técnicas de criptografía más rudimentarias consiste en sustituir cada uno de los caracteres por otro situado _n_ posiciones más a la derecha del abecedario. Si _n = 2_, sustituiremos la "a" por la "c", la "b" por la "d", y así sucesivamente. El problema que aparece con las últimas _n_ letras del alfabeto tiene fácil solución: en el ejemplo, la letra "y" se sustituye se sustituye por la "a" y la "z" por la "b". La sustitución debe aplicarse a las letras minúsculas y mayúsculas y a los dígitos. Las letras no deben incluir caracteres no ingleses \(es decir sin "ñ, ç" ni acentos\)  
Diseña un programa que lea un texto y el valor n y muestre el texto criptografiado.  

## 22 (Opcional) Desencriptar `Desencriptar.java`

Diseña un programa que lea un texto criptografiado siguiendo la técnica expuesta en el ejercicio anterior y el valor n utilizado para encriptar y que muestre el texto descodificado.  

## 23 (Opcional) Criptografía `Criptografia.java`

Diseña un programa que encripte y descencripte una cadena, haciendo uso de las funciones realizadas en los dos ejercicios anteriores.  
El programa pedirá una cadena, un valor n y mostrará el texto encriptado y el texto desencriptado

## 24 Contar palabras I `Palabras1.java`

Realiza un programa que cuente las palabras que tiene una cadena. Podéis usar las métodos `trim()`, `replaceAll()`, `split()`. Se considera que las palabras pueden estar separadas por uno o más espacios, y que también puede haber espacios al principio y al final.

## 25 (Opcional) Contar palabras II `Palabras2.java`

Realiza el mismo programa pero no se pueden usar ninguna de las funciones relacionadas con cadenas. Sólo se puede usar `charAt()`

## 26 (Opcional) Contar palabras III `Palabras3.java`

Realiza el programa Palabras1.java pero ahora en  vez de ser una cadena leída desde el teclado, va a ser un fichero de texto largo. Este fichero se debe llamar `palabras.txt` y esta en el mismo directorio que el programa . **Antes de hacerlo hablad conmigo :\)**

```java
import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.FileReader; 
import java.io.IOException;
public class Palabras {
    public static String leerFichero(){
        BufferedReader br = null;
        String everything = "";
        try {
            br = new BufferedReader(new FileReader("palabras.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
        return everything;
    }

    public static void main(String[] args) {
        String cadena = leerFichero();
        long startTime = System.currentTimeMillis();
        /*
            Escribe aquí tu programa para contar palabras
        */
        long endTime = System.currentTimeMillis();
        long tiempoPrimero = endTime - startTime;
        //Imprimimos cuántos milisegundos has tardado en procesarlo
        System.out.println(tiempoPrimero);

    }
}
```

## 27 (Opcional) Contar palabras IV `Palabras4.java`

Realiza el programa `Palabras2.java` pero ahora en  vez de ser una cadena leída desde el teclado, va a ser un fichero de texto largo. Este fichero se debe llamar `palabras.txt` y esta en el mismo directorio que el programa . **Antes de hacerlo hablad conmigo :\)**




