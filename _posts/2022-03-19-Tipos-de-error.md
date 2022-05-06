---
typora-copy-images-to: ../assets/img/errores/
typora-root-url: ../../
layout: post
title: Errores en Java
categories: parte1
conToc: true
permalink: errores-en-java
---



Tres tipos de errores pueden ocurrir en un programa: errores de tiempo de compilación, errores de tiempo de ejecución, y errores de lógica. Es útil distinguir entre ellos para rastrearlos más rápido.

## Errores en tiempo de compilación

Los errores en tiempo de compilación ocurren cuando violas las reglas de sintaxis del lenguaje Java.
Por ejemplo, paréntesis y llaves deben venir en parejas iguales. Por lo que  `(1 + 2)` es legal, pero `8)` no lo es. En este último caso, el programa no puede ser compilado, y el compilador muestra un error.
Los mensajes de error del compilador generalmente indican dónde en el programa el error ocurrido, y a veces pueden decirle exactamente cuál es el error.

```java
public class Errores { 
	public static void main(String[] argv) {   
		System.out.println("El resultado es : " + (1 + 2);
	}
}
```

```
Errores.java:4: error: ')' expected
		System.out.println("El resultado es : " + (1 + 2);
		                                                ^
1 error
```

Por ejemplo, si olvidamos un **;** al final de una sentencia:

```java
public class Errores { 
	public static void main(String[] argv) {   
		System.out.println("El resultado es : " + (1 + 2))
	}
}
```

```
Errores.java:4: error: ';' expected
		System.out.println("El resultado es : " + (1 + 2))
		                                                 ^
1 error
```

O si nos olvidamos de declarar una variable (o la escribimos mal):

```java
public class Errores { 
	public static void main(String[] argv) {   
		int resultado = 5 * 2;
		System.out.println("El resultado es : " + resultad);
	}
}
```

```
Errores.java:4: error: cannot find symbol
		System.out.println("El resultado es : " + resultad);
		                                          ^
  symbol:   variable resultad
  location: class Errores
1 error
```

Pero los mensajes de error no siempre son fáciles de entender. Algunas veces el compilador informa del lugar en el programa donde se detectó el error, no donde realmente ocurrió. Y a veces la descripción del problema es más confusa que servicial.
Por ejemplo, si omites alguna llave de cierre (línea 8) , es posible que recibas un mensaje como este:

```java
public class Errores { 
	public static void main(String[] argv) {   
		int resultado = 5 * 2;
		if (resultado >= 0){
			System.out.println("El resultado es positivo");
		}else{
			System.out.println("El resultado es negativo");
		
	}
}
```

```
Errores.java:10: error: reached end of file while parsing
}
 ^
1 error
```

Hay dos problemas aquí. Primero, el mensaje de error está escrito desde el punto de vista del compilador, no el tuyo. *Parsing* es el proceso de leer un programa antes de traducir; si el compilador llega al final del archivo mientras sigue analizando, eso significa que algo fue omitido. Pero el compilador no sabe qué. Tampoco sabe dónde. El compilador descubre el error al final del programa (línea 10), pero la llave faltante puede estar en cualquier línea.

## Errores en tiempo de ejecución

El segundo tipo de error es un error en tiempo de ejecución, llamado así porque no aparece hasta después de que el programa haya comenzado a funcionar. En Java, estos errores ocurren mientras el intérprete está ejecutando el código de bytes y algo sale mal. Estos errores también son llamadas "excepciones" porque generalmente indican que algo excepcional (y malo) ha sucedido.

Los errores de tiempo de ejecución son raros en los programas simples que verás en los primeros capítulos, por lo que puede pasar un tiempo antes de que encuentres uno. Cuando se produce un error de tiempo de ejecución, el el intérprete muestra un mensaje de error que explica qué sucedió y dónde.
Por ejemplo, si divide accidentalmente por cero, obtendrás un mensaje como este:

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
at Hello.main(Hello.java:5)
```

Algunas partes de esta salida son útiles para la depuración. La primera línea incluye el nombre de la excepción, `java.lang.ArithmeticException`, y un mensaje que indica más específicamente lo que sucedió, **/ by zero**. La siguiente línea muestra el método donde se produjo un error; `Hello.main` indica el método `main` en la clase `Hello`. También informa el archivo donde se define el método, `Hello.java` y el número de línea donde el error ocurrió, *5*.
Los mensajes de error a veces contienen información adicional que aún no tendrá sentido para ti. Por lo que uno de los desafíos es descubrir dónde encontrar las partes útiles sin ser abrumado por información extraña. Además, ten en cuenta que la línea donde el programa falló puede no ser la línea que debe corregirse.

## Errores de lógica

El tercer tipo de error es el error de lógica. Si tu programa tiene un error de lógica, lo hará compilar y ejecutar sin generar mensajes de error, pero no hará lo correcto.
En cambio, hará exactamente lo que le dijo que hiciera. 

Por ejemplo, un programa que calcula el perímetro de un círculo

```java
public class Perimetro {
	public static void main(String[] args) {
		int radio = 5;
        System.out.printf("El perímetro es %f%n", Math.PI * radio);
	}
}
```

Este programa compila y funciona muy bien, pero el resultado es:

```
El perímetro es 15,707963
```

Cuando el resultado debería ser **31,415927**
La identificación de errores lógicos puede ser difícil porque tienes que trabajar hacia atrás, mirando la salida del programa, tratando de descubrir por qué está haciendo lo incorrecto, y cómo hacer que haga lo correcto. Por lo general, el compilador y el intérprete no pueden ayudarte, ya que ellos no saben lo que es correcto.

------

Basado en:  

* [Think java](http://greenteapress.com/wp/think-java/)



