---
typora-copy-images-to: ../assets/img/strings/
typora-root-url: ../../
layout: post
title: Strings II
categories: strings
conToc: true
permalink: strings-II
---


# Funciones de cadenas (String)

En todos estos programas usaremos las funciones definidas en la clase `Utilidades`

<script src="https://gist.github.com/victorponz/93c93fb7f8d88171b4792d78b8b03259.js"></script>

## 13 Dígitos `Digitos.java`

Escribe un programa que muestre la cantidad de dígitos que aparecen en una cadena. Por ejemplo, la cadena "un 1 y un 20", tiene 3 dígitos.

> -toogle-Piensa antes de mirar
>
> ```java
> public class Digitos {
> 	public static int cuantosSonDigitos(String cadena) {
> 		int contador = 0;
> 		for(int i = 0; i < cadena.length(); i++){
> 			if (Character.isDigit(cadena.charAt(i))){
> 				contador++;
> 			}
> 		}
> 		return contador;
> 	}
> 	
> 	public static int cuantosSonDigitosDos(String cadena) {
> 		int contador = 0;
> 		
> 		//https://stackoverflow.com/questions/2451650/how-do-i-apply-the-for-each-loop-to-every-character-in-a-string
> 		for (char ch: cadena.toCharArray()) {
> 			//En el código ASCII los números van del 48 al 57
> 			if(ch >= 48 && ch <= 57){
> 				contador++;
> 			}
> 		}
> 
> 		return contador;
> 	}
> 	
> 
> 	public static int cuantosSonDigitosTres(String cadena) {
> 		int contador = 0;
> 		
> 		for(char letra : cadena.toCharArray()){
> 			if (Character.isDigit(letra)){
> 				contador++;
> 			}
> 		}
> 		return contador;
> 		
> 	}
> 	
> 	public static int cuantosSonDigitosTres(char[] cadenaArray) {
> 		int contador = 0;
> 		
> 		for(char letra : cadenaArray){
> 			if (Character.isDigit(letra)){
> 				contador++;
> 			}
> 		}
> 		return contador;
> 		
> 	}
> 	public static void main(String[] args) {
> 		
> 		String cadena = Utilidades.leerCadena("Introduce cadena");
> 		
> 		System.out.println("I. La cadena '" + cadena + "' tiene " + cuantosSonDigitos(cadena) + " dígitos");
> 		
> 		System.out.println("II.- La cadena '" + cadena + "' tiene " + cuantosSonDigitosDos(cadena) + " dígitos");
> 		
> 		System.out.println("III.- La cadena '" + cadena + "' tiene " + cuantosSonDigitosTres(cadena) + " dígitos");
> 		
> 		System.out.println("IV.- La cadena '" + cadena + "' tiene " + cuantosSonDigitosTres(cadena.toCharArray()) + " dígitos");
> 	}
> }
> ```

## 14 (Opcional) Dígitos II `Digitos2.java`

Escribe un programa que muestre la cantidad de números que aparecen en una cadena. Por ejemplo, la cadena "1  20 hola 234 45a", tiene 3 números. Las palabras **deben** separarse por blancos.

> -toogle-Piensa antes de mirar
>
> ```java
> public class Digitos2 {
> 	public static int contarNumeros(String[] palabras) {
> 		int numeros = 0;
> 		boolean esNumero;
> 		// ahora recorremos cada palabra para comprobar si son todo números
> 		for (String palabra : palabras) {
>             //Suponemos que sí que lo es
> 			esNumero = true;
> 			for (int i = 0; i < palabra.length(); i++) {
> 				if (!(Character.isDigit(palabra.charAt(i)))) {
>                     //Probamos que no lo es
> 					esNumero = false;
> 					break;
> 				}
> 			}
> 			if (esNumero) {
> 				numeros++;
> 			}
> 		}
> 		return numeros;
> 	}
> 
> 	public static int contarNumeros(String cadena) {
> 		boolean posibleNumero = true;
> 		int numeros = 0;
> 		int largo = cadena.length();
> 		// Este programa es una variante de contar palabras
> 		boolean buscoBlanco = false;
> 		for (int i = 0; i < largo; i++) {
> 			if (buscoBlanco) {
> 				// Si estoy buscando un blanco y lo encuentro
> 				if (cadena.charAt(i) == ' ') {
> 					// Pasamos a buscar un carácter que no sea blanco
> 					buscoBlanco = false;
> 					if (posibleNumero) {
> 						numeros++;
> 					}
> 				}
> 				// Marcar siempre cuando no sea dígito
> 				if (!(Character.isDigit(cadena.charAt(i)))) {
> 					posibleNumero = false;
> 				}
> 			} else {
> 				// Si estoy buscando un carácter no blanco
> 				if (cadena.charAt(i) != ' ') {
> 					// y lo encuentro, significa que hay una palabra y ahora volvemos a empezar a
> 					// buscar un blanco
> 					buscoBlanco = true;
> 					// Marcar siempre cuando no sea dígito
> 					if (!(Character.isDigit(cadena.charAt(i)))) {
> 						posibleNumero = false;
> 					} else
> 						posibleNumero = true;
> 				}
> 			}
> 		}
> 		// tal vez quede el último por contar
> 		if (posibleNumero) {
> 			numeros++;
> 		}
> 		return numeros;
> 	}
> 
> 	public static void main(String[] args) {
> 		String frase = Utilidades.leerCadena("Introduce una frase");
> 		String[] palabras = Utilidades.dividirEnPalabras(frase);
> 		
> 		System.out.println("I.- Hay " + contarNumeros(palabras) + " números en esta frase");
> 		System.out.println("II.- Hay " + contarNumeros(frase) + " números en esta frase");
> 	}
> }
> ```

## 15 Paréntesis `Parentesis.java`

Un texto está bien parentizado si por cada paréntesis abierto hay otro detrás que lo cierra. Por ejemplo, la cadena

> Esto \(es \(un ejemplo\) \(de\) una \(cadena bien\) parentizada\)

está bien parentizada.  
Pero la cadena

> una \)cadena \(mal \(parentizada\)

no lo está.

Diseña un programa que nos siga si una cadena está bien parentizada o no.

> -toogle-Piensa antes de mirar
>
> ```java
> public class Parentesis {
> 
> 	public static boolean esParentizada(String frase) {
> 		int par = 0;
> 
> 		for (char letra : frase.toCharArray()) {
> 			if (letra == '(') {
> 				par++;
> 			} else if (letra == ')') {
> 				par--;
> 			}
> 			//Si hay más de cierre que de apertura, acabamos
> 			if (par == -1) {
> 				return false;
> 			}
> 		}
> 		//Al final, por cada uno de apertura debe hacer uno de cierre. Es decir el
> 		//único valor correcto es que sea 0
> 
> 		return (par == 0);
> 	}
> 	public static void main(String[] args) {
> 		String frase = Utilidades.leerCadena("Introduce una frase:");
> 
> 		if (esParentizada(frase)) {
> 			System.out.println("La cadena está bien parentizada");
> 		} else {
> 			System.out.println("La cadena NO está bien parentizada");
> 		}
> 	}
> 
> }
> ```

## 16 Frase invertida `Invertida.java`

Escribe un programa que lea una frase del teclado y luego imprima las palabras que la forman de forma invertida.  

Por ejemplo:

```
"Esto es una frase" => "frase una es Esto"  
```

Debes hacer dos funciones:  

1. La primera tiene un argumento de tipo cadena y debe devolver un array de Strings con las palabras que forman la frase.

   ```java
   public static String[] palabras(String frase)
   ```

2. La segunda tiene como parámetro un array de Strings y devuelve un String con el array de forma invertida.

   ```java
   public static String invertir(String[] palabras)
   ```

> -toogle-Piensa antes de mirar
>
> ```java
> public class Invertida {
> 	public static String invertir(String[] palabras){
> 		String invertida = "";
> 		for(int i = palabras.length - 1 ; i >= 0; i--){
> 			invertida = invertida + palabras[i] +" ";
> 		}
> 		return invertida;
> 	}
> 	public static void main(String[] args) {
> 		String invertida = invertir(Utilidades.dividirEnPalabras(Utilidades.leerCadena("Introduce texto")));
> 		System.out.println(invertida);
> 	}
> }
> ```

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

> -toogle-Piensa antes de mirar
>
> ```java
> public class Siglas {
> 	/*
> 	 * Realiza un programa que lea un frase y la convierta en unas siglas. Por
> 	 * ejemplo, Escuela Oficial de Idiomas, se convierte en EOI.
> 	 */
> 	public static String siglas(String[] palabras) {
> 		String siglas = "";
> 
> 		for (String palabra : palabras) {
> 			char letra = palabra.charAt(0);
> 			if (Character.isUpperCase(letra)) {
> 				siglas = siglas + letra;
> 			}
> 		}
> 		return siglas;
> 	}
> 	public static void main(String[] args) {
>     	String solucion = siglas(Utilidades.dividirEnPalabras(Utilidades.leerCadena("Introduce texto")));
> 		System.out.println(solucion);
> 	}
> }
> ```

## 18 Alfabética `Alfabetica.java`

Una palabra es _alfabética_ si todas sus letras están ordenadas alfabéticamente. Por ejemplo, "amor", "chino" e "himno" son palabras alfabéticas. Diseña un programa que nos diga si una palabra es alfabética o no.

> -toogle-Piensa antes de mirar
>
> ```java
> public class Alfabetica {
> 	public static boolean esAlfabetica(String cadena) {
> 		//Fijáos que empieza en 1
> 		for(int i = 1; i < cadena.length(); i++){
> 			if(cadena.charAt(i) < cadena.charAt(i-1)) {
> 				return false;
> 			}
> 		}
> 		return true;
> 	}
> 	public static void main(String[] args) {
> 		String palabra = Utilidades.leerCadena("Introduce una palabra");
> 		if ( palabra.length() > 0) {
> 			if(esAlfabetica(palabra)) {
> 				System.out.println("La palabra es alfabética");
> 			}
> 			else {
> 				System.out.println("La palabra no es alfabética");
> 			}
> 		} else {
> 			System.out.println("Introduzca una palabra de más de una letra");
> 		}
> 	}
> }
> ```

## 19 Pasatiempos `Pasatiempos.java`

Hay un tipo de pasatiempos que propone descifrar un texto del que se han suprimido las vocales. Por ejemplo, el texto ".n .j.mpl. d. p.s.t..mp.s" se descrifra sustituyendo cada punto por una vocal. La solución es "un ejemplo de pasatiempos".  

Diseña un programa que ayude al creador de pasatiempos. Recibirá una cadena y mostrará otra en la que cada vocal ha sido reemplazada por un punto.

> -toogle-Piensa antes de mirar
>
> ```java
> public class Pasatiempos {
> 	public static String crearPasatiempo(String frase) {
> 		//Se puede hacer de muchas formas
> 		String pasatiempo = "";
> 		for (int i = 0; i < frase.length(); i++) {
> 			if ("aeiouAEIOUáéíóúÁÉÍÓÚàèìòùÀÈÌÒÙäëïöüÄËÏÖÜ".contains("" + frase.charAt(i))) {
> 				pasatiempo = pasatiempo + ".";
> 			} else {
> 				pasatiempo = pasatiempo + frase.charAt(i);
> 			}
> 		}
> 		return pasatiempo;
> 	}
> 
> 	public static void main(String[] args) {
> 		String cadena = Utilidades.leerCadena("Introduce cadena");
> 		String solucion = crearPasatiempo(cadena);
> 		System.out.println(solucion);
> 	}
> 
> }
> ```

## 20 Suma binaria `SumarBinario.java` (avanzado)

Haz un programa que lea dos cadenas que representen a sendos números binarios. A continuación, el programa mostrará el número binario que resulta de sumar ambos (y que será otra cadena\). Si, por ejemplo, el usuario introduce las cadenas '100' y '111', el programa mostrará como resultado la cadena '1011'

> -toogle-Piensa antes de mirar
>
> ```java
> public class SumarBinario {
> 	public static String sumaBinario(String cad1, String cad2){
> 	    String numeroLargo, numeroCorto;
>         //Los números pueden ser de distinta longitud
>         if (cad1.length() > cad2.length()) {
>             numeroLargo = cad1;
>             numeroCorto = cad2;
>         }
>         else {
>             numeroLargo = cad2;
>             numeroCorto = cad1;
>         }
>         //Caculamos en cuántos dígitos se diferencian
>         int diferenciaDigitos = numeroLargo.length() - numeroCorto.length();
>         String resultado = "";
>         int acarreo = 0;
>         int a, b;
>         
>         //Empezamos por el último dígito del número más largo
>         for (int i = numeroLargo.length() -1; i >= 0; i--) {
>             if (i - diferenciaDigitos >= 0) {
>                 //El segundo dígito a sumar es el correspondiente al número corto
>                 b = Integer.parseInt("" + numeroCorto.charAt(i - diferenciaDigitos));
>             }
>             else {
>                 //En este caso el segundo dígito es siempre 0, porque ya no quedan
>                 b = 0; 
>             }
>             
>             //El primer número a sumar siempre es el del número más largo
>             a = Integer.parseInt("" + numeroLargo.charAt(i));
>             //Sumamos y comprobamos el acarreo
>             int suma = acarreo + a + b;
> 
>             resultado = ((suma % 2 == 0) ? "0" : "1") + resultado; 
>             acarreo = (suma > 1 ? 1 : 0) ;
>             /* Lo de arriba es una forma resumida de:
>             * if (suma == 0) {
>                 acarreo = 0;
>                 resultado = 0 + resultado;
>               }
>               else if (suma == 1) {
>                 acarreo = 0;
>                 resultado = 1 + resultado;
>               }
>               else if (suma == 2) {
>                 acarreo = 1;
>                 resultado =  0 + resultado;
>               }
>               else if (suma == 3) {
>                 acarreo = 1;
>                 resultado = 1 + resultado;
>               }
>                 */
>             
>         }
> 	      //Si la última suma ha producido acarreo le añadimos un 1 al resultado
> 	      if (1 == acarreo) {
> 	    	  resultado = "1" + resultado;
> 	      }
> 	      return resultado;
> 	}
> 	
> 	public static void main(String[] args) {		
> 		String cad1 = Utilidades.leerCadena("Introduce el primer número binario");
> 		String cad2 = Utilidades.leerCadena("Introduce el segundo número binario");
> 		System.out.println("La suma es: " + sumaBinario(cad1,cad2));
> 	}
> }
> ```

## 21 Encriptar `Encriptar.java` (avanzado)

Una de las técnicas de criptografía más rudimentarias consiste en sustituir cada uno de los caracteres por otro situado _n_ posiciones más a la derecha del abecedario. Si _n = 2_, sustituiremos la "a" por la "c", la "b" por la "d", y así sucesivamente. El problema que aparece con las últimas _n_ letras del alfabeto tiene fácil solución: en el ejemplo, la letra "y" se sustituye se sustituye por la "a" y la "z" por la "b". La sustitución debe aplicarse a las letras minúsculas y mayúsculas y a los dígitos. Las letras no deben incluir caracteres no ingleses \(es decir sin "ñ, ç" ni acentos\)  
Diseña un programa que lea un texto y el valor n y muestre el texto criptografiado.  

> -toogle-Piensa antes de mirar
>
> ```java
> public class Encriptar {
> 
> 	public static String encriptar(String cad1, int cod) {
> 		String encriptada = "";
> 		char c = ' ';
> 
> 		for (int i = 0; i < cad1.length(); i++) {			
> 			if (Character.isLowerCase(cad1.charAt(i))) {
>                 //Hay 26 caracteres y empiezan en el 97
> 				c = (char) ((cad1.charAt(i) - 97 + cod) % 26 + 97);
> 			} else if (Character.isUpperCase(cad1.charAt(i))) {
>                 //Hay 26 caracteres y empiezan en el 65
> 				c = (char) ((cad1.charAt(i) - 65 + cod) % 26 + 65);				
> 			} else if (Character.isDigit(cad1.charAt(i))) {
>                 //Hay 10 caracteres y empiezan en el 48
> 				c = (char) ((cad1.charAt(i) - 48 + cod) % 10 + 48);
> 			} else {
>                 //Lo dejamos tal cual
> 				c = cad1.charAt(i);
> 			}
> 			encriptada += c;
> 		}
> 		return encriptada;
> 	}
> 	public static void main(String[] args) {
> 		String cad1 = Utilidades.leerCadena("Introduce una palabra");
> 		int cod = Utilidades.leerEntero("Introduce el código de encriptación: ");
> 		System.out.println("La cadena encriptada es: " + encriptar(cad1, cod));
> 	}
> }
> ```

## 22 Desencriptar `Desencriptar.java ` (avanzado)

Diseña un programa que lea un texto criptografiado siguiendo la técnica expuesta en el ejercicio anterior y el valor n utilizado para encriptar y que muestre el texto descodificado.  

> -toogle-Piensa antes de mirar
>
> ```java
> public class Desencriptar {
> 	
> 	public static String desencriptar(String palabra, int cod){
> 		String desencriptada="";
> 		char c=' ';
> 
> 		for (char letra : palabra.toCharArray()) {
> 			if(Character.isLowerCase(letra)){
>                 //26 caracteres a partir del 97
> 				c = (char) ((26 + ((letra - 97 - (cod % 26)))) % 26 + 97);
> 			} else if(Character.isUpperCase(letra)){
>                 //26 caracteres a partir del 65
> 				c = (char) ((26 + ((letra- 65 -(cod % 26)))) % 26 + 65);
> 			} else if(Character.isDigit(letra)){
>                 //10 caracteres a partir del 48
> 				c = (char) ((10 + (letra - 48 -(cod % 10))) % 10 + 48);
> 			} else {
> 				c = letra;
> 			}
> 			desencriptada += c;
> 		}
> 		return desencriptada;
> 	}
> 	public static void main(String[] args) {
> 		String cad1 = Utilidades.leerCadena("Introduce una palabra encriptada");
> 
> 		int cod = Utilidades.leerEntero("Introduce el código de encriptación");
> 		
> 		System.out.println(desencriptar(cad1,cod));
> 	}
> 
> }
> ```

## 23 Criptografía `Criptografia.java`

Diseña un programa que encripte y descencripte una cadena, haciendo uso de las funciones realizadas en los dos ejercicios anteriores.  
El programa pedirá una cadena, un valor n y mostrará el texto encriptado y el texto desencriptado

> -toogle-Piensa antes de mirar
>
> ```java
> public class Criptografia {
>     public static void main(String[] args) {
>         String cad1= Utilidades.leerCadena("Introduce una frase");
>         int cod = Integer.parseInt(Utilidades.leerCadena("Introduce el código de encriptación"));
>         
>         System.out.println("Encriptada:    " + Encriptar.encriptar(cad1, cod));
>         System.out.println("Desencriptada: " + Desencriptar.desencriptar(Encriptar.encriptar(cad1, cod), cod));
>     }
> }
> ```


