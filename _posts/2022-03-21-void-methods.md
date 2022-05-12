---
typora-copy-images-to: ../assets/img/voidmethods/
typora-root-url: ../../
layout: post
title: Métodos que no devuelven valores
categories: parte1
conToc: true
permalink: void-methods
---

# 1 Void methods

Hasta ahora solo hemos escrito programas cortos que tienen una sola clase y un solo método \(main\). En este capítulo, mostraremos cómo organizar programas más largos en múltiples métodos y clases. También presentaremos la clase `Math` que proporciona métodos para operaciones matemáticas comunes.

## 1.1 Métodos matemáticos

En matemáticas, probablemente hayáis visto funciones como `sin` y `log`, y hayáis aprendido a evaluar expresiones como sin `(π / 2)` y `log (1 / x)`. Primero se evalúa la  la expresión entre paréntesis, que se llama el argumento de la función. Entonces se puede evaluar la función en sí misma, tal vez en una calculadora.

Este proceso puede aplicarse repetidamente para evaluar expresiones más complejas como `log (1 / sin (π / 2))`. Primero evaluamos el argumento de la función más interna, luego se evalúa la función en sí, y así sucesivamente.

La biblioteca de Java incluye una clase `Math` que proporciona operaciones matemáticas comunes. `Math` está en el paquete `java.lang`, por lo que no se tiene que importar.

Se pueden utilizar o invocar métodos matemáticos como este:

```java
double root = Math.sqrt(17.0);
double angle = 1.5;
double height = Math.sin(angle);
```

La primera línea establece `root` en la raíz cuadrada de 17. La tercera línea encuentra el seno de 1.5 \(el valor del ángulo\). Los argumentos de las funciones trigonométricas - sin, cos y tan - deben ser en radianes. Para convertir de grados a radianes, se puede dividir entre 180 y multiplicar por π. Convenientemente, la clase `Math` proporciona un doble constante llamada `PI` que contiene una aproximación de π:

```java
double degrees = 90;
double angle = degrees / 180.0 * Math.PI;
```

Fijaos que `PI` está en mayúsculas. Java no reconoce Pi o pi. Además, `PI` es el nombre de una variable, no un método, por lo que no tiene paréntesis. Lo mismo es cierto para la constante `Math.E`, que se aproxima al número de Euler. Convertir a radianes y desde radianes es una operación común, por lo que la clase `Math` proporciona métodos que lo hacen por nosotros.

Otro método útil es `round`, que redondea un valor de coma flotante al entero más cercano y devuelve un `long`. Un `long` es como un int, pero más grande. Más específicamente, un `int` usa 32 bits; el mayor valor que puede contener es 2^31 - 1, que es alrededor de 2 mil millones. Un `long` usa 64 bits, por lo que el valor más grande es 2 ^63 - 1, que es alrededor de 9 quintillones.

```java
long x = Math.round(Math.PI * 20.0);
```

El resultado es 63 \(redondeado desde 62.8319\). Tómate un minuto para leer la documentación de estos y otros métodos en la clase `Math`. La forma más fácil de encontrar documentación para las clases de Java es hacer una búsqueda web para "Java" y el nombre de la clase.

## 1.2 Composición revisitada

Al igual que con las funciones matemáticas, los métodos de Java se pueden componer. Eso significa que puedes usar una expresión como parte de otra. Por ejemplo, puedes usar cualquier expresión como argumento para un método:

```java
double x = Math.cos(angle + Math.PI / 2.0);
```

Esta instrucción divide `Math.PI` por dos, agrega el resultado al ángulo y calcula el coseno de la suma. También puede tomar el resultado de un método y pasarlo como argumento a otro:

```java
double x = Math.exp(Math.log(10.0));
```

En Java, el método `log` siempre usa base `e`. Entonces esta declaración encuentra el logaritmo base e de 10, y luego lo eleva  a ese potencia. El resultado se asigna a `x`.

Algunos métodos matemáticos toman más de un argumento. Por ejemplo, `Math.pow` toma dos argumentos y eleva el primero al segundo. Esta línea del código asigna el valor 1024.0 a la variable `x`:

```java
double x = Math.pow(2.0, 10.0);
```

Al usar los métodos matemáticos, es un error común olvidar `Math`. Por ejemplo, si intentamos invocar `pow(2.0, 10.0)`, obtenemos un mensaje de error como:

```bash
File: Test.java [line: 5]
Error: cannot find symbol
symbol: method pow(double,double)
location: class Test
```

El mensaje "_cannot find symbol_" es un poco confuso, pero la última línea proporciona una sugerencia útil. El compilador está buscando `pow` en la misma clase donde se usa, que es `Test`. Si no especifica un nombre de clase, el compilador busca en la clase actual.

Probablemente ya hayas adivinado que puedes definir más de un método en una clase. Aquí hay un ejemplo:

```java
public class NuevaLinea {

    public static void nuevaLinea() {

        System.out.println();

    }

    public static void main(String[] args) {

        System.out.println("Primera línea.");

        nuevaLinea();

        System.out.println("Segunda línea.");

    }

}
```

El nombre de la clase es `NuevaLinea`. Por convención, los nombres de clase comienzan con una  letra mayúscula. NuevaLinea contiene dos métodos, `nuevaLinea` y `main`. Recuerda que Java distingue entre mayúsculas y minúsculas, por lo que `NuevaLinea` y `nuevaLinea` no son lo mismo.

Los nombres de los métodos deben comenzar con una letra minúscula y usar "camel case", que es un bonito nombre para ponerPalabrasJuntasComoEstas. Se puede usar cualquier nombre que se desee para los métodos, excepto main o cualquiera de las palabras clave de Java.

`nuevaLinea` y `main` son públicos, lo que significa que pueden invocarse desde otra clases. Ambos son estáticos, pero no podemos explicar lo que eso significa todavía.

Y ambos son nulos, lo que significa que no producen un resultado \(a diferencia los métodos matemáticos, por ejemplo\).

Los paréntesis después del nombre del método contienen una lista de variables, llamada **parámetros**, donde el método almacena sus **argumentos**. `main` tiene un solo parámetro, llamado `args`, que es de tipo `String []`. Eso significa que quien invoque main debe proporcionar una matriz de cadenas.

Como `nuevaLinea` no tiene parámetros, no requiere argumentos, como se muestra cuando se invoca en `main`. Y como `nuevaLinea` está en la misma clase que `main`, no tiene que especificar el nombre de la clase.

La salida de programa es

```bash
Primera Linea

Segunda línea
```

Fíjate en el espacio extra entre las líneas. Si queremos más espacio entre ellas, podemos invocar el mismo método repetidamente:

```java
public static void main(String[] args) {
    System.out.println("Primera línea.");
    nuevaLinea();
    nuevaLinea();
    nuevaLinea();
    nuevaLinea.out.println("Segunda línea.");
}
```

O podemos escribir un nuevo método que muestre tres líneas en blanco:

```java
public static void tresLineas() {
    nuevaLinea();
    nuevaLinea();
    nuevaLinea();
}

public static void main(String[] args) {
    System.out.println("Primera línea.");
    tresLineas();
    System.out.println("Segunda línea.");
}
```

Se puede invocar el mismo método más de una vez, y un método invocar a otro. En este ejemplo, `main` invoca `tresLineas` y `tresLineas` invoca a `nuevaLinea`.  
Los principiantes a menudo se preguntan por qué vale la pena crear nuevos métodos.  
Hay muchas razones, pero este ejemplo demuestra algunas de ellas:

* Crear un nuevo método da la oportunidad de dar un nombre a un grupo de declaraciones, lo que hace que el código sea más fácil de leer y comprender.
* La introducción de nuevos métodos puede hacer que un programa sea más pequeño al eliminar código repetitivo. Por ejemplo, para mostrar nueve líneas nuevas consecutivas, podríamos invocar a `tresLineas` tres veces.
* Una técnica común para resolver problemas es dividir las tareas en subconjuntos problemas. Los métodos permiten enfocarse en cada subproblema de forma aislada, y luego componerlos en una solución completa.

## 1.3 Flujo de ejecución

Al juntar el código de la sección anterior, el programa completo queda así:

```java
public class NuevaLinea {

    public static void nuevaLinea() {
        System.out.println();
    }

    public static void tresLineas() {
        nuevaLinea();
        nuevaLinea();
        nuevaLinea();
    }

    public static void main(String[] args) {
        System.out.println("Primera línea.");
        tresLineas();
        System.out.println("Segunda línea.");
    }
}
```

Cuando se observa una definición de clase que contiene varios métodos, es tentador leerlo de arriba a abajo. Pero eso es probable que sea confuso, porque ese no es el flujo de ejecución del programa.

**La ejecución siempre comienza en la primera instrucción de main**, independientemente de dónde esté está en el archivo fuente. Las declaraciones se ejecutan una a la vez, en orden, hasta que llegue a una invocación de método, que puede considerarse como un desvío. En lugar de ir a la siguiente declaración, salta a la primera línea del método invocado, ejecuta todas las declaraciones allí, y luego vuelve y continúa exactamente donde se quedó la ejecución.

Esto suena bastante simple, pero recuerda que un método puede invocar otro. En medio de `main`, vamos a ejecutar las declaraciones en `tresLineas`. Mientras ejecutamos `tresLineas`, nos vamos a ejecutar `nuevaLinea`. Entonces `nuevaLinea` invoca a `println`, lo que causa otro desvío.

Afortunadamente, Java es bueno para realizar un seguimiento de los métodos que se ejecutan. Entonces, cuando `println` finaliza, continúa donde lo dejó en `nuevaLinea`; cuando `nuevaLinea` acaba, vuelve a `tresLineas`, y cuando `tresLineas` acaba, vuelve a `main`.

En resumen, cuando leas un programa, no lo hagas de arriba abajo. En su lugar, sigue el flujo de ejecución.

## 1.4 Parámetros y argumentos

Algunos de los métodos que hemos usado requieren **argumentos**, que son los valores se proporcionan cuando se invoca el método. Por ejemplo, para encontrar el seno de un número, se debe proporcionar el número, entonces `sin` toma un double como argumento. Para mostrar un mensaje, se debe proporcionar el mensaje, de modo que `println` toma una cadena.  
Cuando usamos un método, proporcionamos los argumentos. Cuando escribimos un método, nombramos los `parámetros`. La lista de parámetros indica qué argumentos se requieren.  
La siguiente clase muestra un ejemplo:

```java
public class ImprimeDosVeces {
    public static void imprimeDosVeces(String s) {
        System.out.println(s);
        System.out.println(s);
    }
    public static void main(String[] args) {
        imprimeDosVeces("No me lo hagas decir dos veces!");
    }
}
```

`ImprimeDosVeces` tiene un parámetro llamado _s_ de tipo `String`. Cuando invocamos `imprimeDosVeces`, tenemos que proporcionar un argumento de tipo `String`. Antes de que se ejecute el método, el argumento se asigna al parámetro.  
En este ejemplo, el argumento "No me lo hagas decir dos veces!" se asigna al parámetro _s_.

Este proceso se denomina **paso de parámetros** porque el valor se pasa de fuera del método hacia el interior. Un argumento puede ser cualquier tipo de expresión, es decir,  si tienes una variable `String`, puedes usarla como argumento:

```java
    String argument = "Nunca digas nunca.";
    imprimeDosVeces(argument);
```

El valor que se proporcione como argumento debe tener el mismo tipo que el parámetro. Por ejemplo, si intentas:

```java
    imprimeDosVeces(17); // syntax error
```

Obtendrás un mensaje al compilar parecido a este:

```bash
File: Test.java [line: 10]
Error: method imprimeDosVeces in class ImprimeDosVeces cannot be applied to given types;
required: java.lang.String
found: int
reason: actual argument int cannot be converted to java.lang.String by method invocation conversion
```

A veces Java puede convertir un argumento de un tipo a otro automáticamente. Por ejemplo, `Math.sqrt` requiere un `double`, pero si invocas `Math.sqrt(25)`, el valor _int 25_ se convierte automáticamente al valor en coma flotante _25.0_. Pero en el caso de `imprimeDosVeces`, Java no puede \(o no quiere\) convertir el int 17 a un string.  
Los parámetros y otras variables solo existen dentro de sus propios métodos. Dentro de `main`, no existe tal cosa como la variable _s_. Si intentas usarla allí, obtendrás un error del compilador. Del mismo modo, dentro de `imprimeDosVeces` no existe `argument`. Esa variable pertenece a `main`.  
Debido a que las variables solo existen dentro de los métodos donde se definen, a menudo se llaman **variables locales**.

## 1.5 Múltiples parámetros

Aquí hay un ejemplo de un método que tiene dos argumentos:

```java
    public static void printTime(int hour, int minute) {
        System.out.print(hour);
        System.out.print(":");
        System.out.println(minute);
}
```

En la lista de parámetros puede ser tentador escribir:

```java
public static void printTime(int hour, minute) {
    . . .
```

Pero ese formato \(sin la segunda int\) es solo legal para declaraciones de variables. En las listas de parámetros, se debe especificar el tipo de cada variable por separado.

Para invocar este método, debemos proporcionar dos enteros como argumentos:

```java
int hour = 11;
int minute = 59;
printTime(hour, minute);
```

Un error común es declarar los tipos de los argumentos, como esto:

```java
int hour = 11;
int minute = 59;
printTime(int hour, int minute); // syntax error
```

Eso es un error de sintaxis; el compilador ve int hour e int minute como declaraciones de variables, no como expresiones. No declararías los tipos de argumentos si fueran simplemente enteros:

```java
printTime(int 11, int 59); // syntax error
```

## 1.6 Diagramas de pila

Al juntar los fragmentos de código de la sección anterior, tenemos un compendio de definición de clase completa:

```java
public class PrintTime {
    public static void printTime(int hour, int minute) {
        System.out.print(hour);
        System.out.print(":");
        System.out.println(minute);
    }
    public static void main(String[] args) {
        int hour = 11;
        int minute = 59;
        printTime(hour, minute);
    }
}
```

`printTime` tiene dos parámetros, llamados `hour` y `minute`. Y `main` tiene dos variables, también llamadas `hour` y `minute`. Aunque tienen los mismos nombres, **estas variables no son lo mismo**. `hour` en `printTime` y `hour` en `main` hacen referencia a diferentes ubicaciones de memoria, y pueden tener diferentes valores.  
Por ejemplo, podemos invocar `printTime` de la siguiente manera:

```java
int hour = 11;
int minute = 59;
printTime(hour + 1, 0);
```

Antes de invocar el método, Java evalúa los argumentos; en este ejemplo, los resultados son 12 y 0. Luego asigna esos valores a los parámetros. Dentro `printTime`, el valor de `hour` es 12, no 11, y el valor de minuto es 0, no 59. Además, si `printTime` modifica uno de sus parámetros, ese cambio no tiene efecto sobre las variables en `main`.

Una forma de hacer un seguimiento de todo es dibujar un [diagrama de pila](#16-diagramas-de-pila), que es un diagrama de estado que muestra las invocaciones de métodos. Para cada método hay un cuadro llamado marco que contiene los parámetros del método y de las variables. El nombre del método aparece fuera del marco; el de las variables y los parámetros aparecen adentro.

Al igual que con los diagramas de estado, los diagramas de pila muestran variables y métodos en punto particular en el tiempo. La figura siguiente es un diagrama de pila al comienzo del método `printTime`.  

![](/programacion-java/assets/img/voidmethods/stackdiagram.png)

## Vocabulario

* **argumento**: valor que proporciona cuando invoca un método. Este valor debe tener el mismo tipo que el parámetro correspondiente.
  invocar: hacer que un método se ejecute. También conocido como "llamar" a un método.
* **parámetro**: La información que requiere un método antes de que pueda ejecutarse. Los parámetros son variables: contienen valores y tienen tipos.
* **flujo de ejecución**: el orden en que Java ejecuta métodos e instrucciones. Puede no ser necesariamente de arriba a abajo, de izquierda a derecha.
* **paso de parámetros**: el proceso de asignar un valor de argumento a un variable parámetro
* **variable local**: una variable declarada dentro de un método. Las variables locales no pueden ser accedidas desde fuera de su método.
* **diagrama de pila**: una representación gráfica de las variables que pertenecen a cada método. Las llamadas al método están "apiladas" de arriba a abajo, en el flujo de ejecución
* **signatura**: la primera línea de un método que define su nombre, tipo de retorno y parámetros.

## Ejercicios

> -info-Todos los ejercicios deben estar hechos usando funciones que devuelvan `void`

**1**. `Mayor.java` Realiza un programa que pida la edad al usuario y muestre un mensaje si es mayor de edad

**2**. `Descendente.java` Realiza un programa que lea dos valores y los muestre en orden ascendente.

**3**. `Nota.java` Realiza un programa que lea un valor numérico entero correspondiente a la nota de un examen y muestre su valor en letra:

* de 0 a 3 Muy Deficiente.
* de 3 a 5 Insuficiente.
* de 5 a 6 Suficiente.
* de 6 a 7 Bien
* de 7 a 9 Notable
* de 9 a 10 Sobresaliente

**4**. `Positivos.java` Escribe un programa que pida al usuario 10 números y que muestre cuántos son positivos

**5**. `MayorDeTres.java` Escribe un programa que pida tres números e imprima el mayor de los tres

# Adaptado del siguiente material
http://greenteapress.com/wp/think-java/ Version 6 by Allen Downey and Chris Mayfield


