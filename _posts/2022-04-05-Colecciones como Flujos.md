---
typora-copy-images-to: ../assets/img/estructuras/
typora-root-url: ../../
layout: post
title: Colecciones como flujos
categories: estructuras
conToc: true
permalink: streams
---

## Flujos (Streams)

En esta parte del curso, presentamos el manejo de colecciones con flujos. Aprenderás a crear una flujo a partir de una colección, filtrar los valores de una flujo, transformar los valores de una flujo y recopilar valores de una flujo en otra colección. Presentamos el concepto **expresión lambda** y aprenderás a usarlo en tus programas. También aprenderás cómo ordenar objetos utilizando la interfaz `Comparable` de Java.

Conozcamos las colecciones, como las listas, como flujos de valores. 

> -info-`Stream` es una forma de recorrer una colección de datos de manera que el programador determina la operación que se realizará en cada valor. No se lleva registro del índice ni de la variable que se esté procesando en cada momento.

Con flujos, el programador define una secuencia de eventos que se ejecuta para cada valor en una colección. Una cadena de eventos puede incluir volcar algunos de los valores, convertir valores de una forma a otra o cálculos. Una secuencia no cambia los valores en la recopilación de datos original, sino que simplemente los procesa. Si desea conservar las transformaciones, deben compilarse en otra recopilación de datos.

Comencemos a comprender el uso de flujos a través de un ejemplo concreto. Considera el siguiente problema:

>-task-**Ejercicio**
>
> Escribe un programa que a partir de un `ArrayList` con números en formato de cadena imprima el número de enteros positivos divisibles por tres y el promedio de todos los valores.

Vamos a implementarlo de la manera tradicional:

```java
import java.util.ArrayList;
import java.util.List;
public class Statistics{
    public static void main(String[] args) {
        List<String> numeros = new ArrayList<>();
        int n;
        int suma = 0;
        int cuantos = 0;
        numeros.add("25");
        numeros.add("30");
        numeros.add("20");
        for(String numero : numeros){
            n = Integer.parseInt(numero);
            suma += n;
            if (n % 3 == 0)
                cuantos++;
        }
        System.out.printf("Hay %d números múltiplos de 3 y la media es %f%n", cuantos, (float)suma/(float)numeros.size());

    }
}
```

Es decir, hacemos un bucle por cada elemento. 

Esta es la forma usando `Streams`

```java
import java.util.ArrayList;
import java.util.List;

public class StatisticsStreams {
    public static void main(String[] args) {
        List<String> numeros = new ArrayList<>();
        
        numeros.add("25");
        numeros.add("30");
        numeros.add("20");

        // Contamos los múltiples de 3
        long cuantos = numeros.stream()
                //convertimos a Int 
                .mapToInt(s -> Integer.valueOf(s))
                //filtramos los que sean múltiplos de 3
                .filter(number -> number % 3 == 0)
                //y los contamos
                .count();

        // la media
        double media = numeros.stream()
                //Convertimos a int
                .mapToInt(s -> Integer.valueOf(s))
                //sacamos la media
                .average()
                //devolvemos el valor como double
                .getAsDouble();

        System.out.printf("Hay %d números múltiplos de 3 y la media es %f%n", cuantos, media );

    }
}
```

Vamos a ver con detalle:

```java
long cuantos = numeros.stream()
                //convertimos a Int 
                .mapToInt(s -> Integer.valueOf(s))
                //filtramos los que sean múltiplo de 3
                .filter(number -> number % 3 == 0
                //y los contamos
                .count();
```

Se puede convertir a `Stream` cualquier objeto de la implemente la interfaz `Collection` (Como `ArrayList`, `HashSet`, `HashMap`, etc)

Luego lo convertimos a entero en la línea 3 y le aplicamos un filtro. Este es del estilo `valor -> condición del filtro`. Cuando aplicamos el filtro, ya sólo nos queda 1 elemento en el `Stream`,

## Suma de positivos o negativos

Realiza un programa que mediante la conversión a `Stream` de un `ArrayList` con números enteros calcule cuántos números positivos hay y cuántos negativos.

<span style='color:green'> (ra3.b, ra3.f, ra5.c, ra6.b, ra6.e, ra6.c, ra6.d)</span>

> -hint-Pista
>
> Si queremos sumar los datos, hemos de usar un truco, ya que en algunas de las operaciones finales como `sum` o `average` se tiene que mapear a `Integer` aunque ya sea un entero.
>
> ```java
> int suma = numeros.stream()
>	.mapToInt(Integer::valueOf)
>	.sum();
> ```

Hay que usar `mapToInt(Integer::valueOf)` . Más info [aquí](https://chatgpt.com/share/6926ea73-2250-8007-b9e8-02bfcf27e758)

## Funciones *lambda*

Si os habéis fijado hemos usado una notación nueva en el método `.filter(numero -> numero > 0)`

Traducido a código estándar sería algo parecido a:

```java
public static boolean positivos(numero){
    return (numero > 0);
}
```

De hecho, podemos poner métodos creado por nosotros.

```java
public static boolean mayorDeCinco(int numero) {
        return numero > 5;
}
```

Y luego usarlo como una condición en el filtro:

```java
Long mayoresDeCinco = numeros.stream()
                    .filter(numero -> mayorDeCinco(numero))
                    .count();
```

## Más ejemplos

* Realizar alguna operación a los valores de un `ArrayList`

  ```java
  // Vamos a duplicar el valor de los elementos positivos de un `ArrayList`
  List<Integer> numeros = new ArrayList<>(List.of(25, 2, 20, -1, -5));
  
  List<Integer> duplicada = numeros.stream()
          .filter(n -> n > 0) // Sólo los positivos
          .map(n -> 2 * n) // map es para transformar los valores del stream
          .toList(); // Es una forma abreviada de .collect(Collectors.toList())
  
  System.out.println(duplicada.toString());
  ```
* Obtener los nombres únicos en mayúsculas

  ```java
  List<String> names = new ArrayList<>(List.of("Ana", "luis", "ANA", "María"));
  
  List<String> unicos = names.stream()
          .map(String::toUpperCase)        // Transforma en mayúsculas
          .distinct()                      // Extrae elementos únicos
          .toList();                       // Devolvemos la lista
  ```

* Media de una lista de valores pares

  ```java
  List<Integer> numeros2 = new ArrayList<>(List.of(25, 2, 20, 23));
  
  double media = numeros.stream()
          .filter(n -> n % 2 == 0)    // Sólo los pares.
          .mapToInt(Integer::valueOf) // Se debe convertir a un IntStream para que tenga el método average
          .average().getAsDouble(); // Sacamos la media y obtenemos el valor
  
  System.out.printf("La media es: %f%n", media);
  ```

## Métodos de `Stream`

Los métodos de flujo se pueden dividir aproximadamente en dos categorías: 

1. operaciones **intermedias** destinadas a procesar elementos. Los métodos `filter` y `mapToInt` que se muestran en el ejemplo anterior son operaciones intermedias. Las operaciones intermedias devuelven un valor que puede procesarse aún más; en la práctica, podría tener un número infinito de operaciones intermedias encadenadas secuencialmente (y separadas por un punto).
2. operaciones **terminales** que finalizan el procesamiento de elementos. Por otro lado, el método promedio visto en el ejemplo anterior es una operación terminal. Una operación de terminal devuelve un valor para ser procesado, que se forma, por ejemplo, a partir de elementos de flujo.

La siguiente figura ilustra cómo funciona una secuencia. El punto de partida **(1)** es una lista con valores. Cuando se llama al método `stream()` en una lista, **(2)** se crea una secuencia de valores de lista. Los valores luego se tratan individualmente. Los valores de flujo se pueden **(3)** filtrar mediante el método de filtrado, que elimina los valores que no cumplen la condición del flujo. El método de mapa de flujo **(4)** se puede usar para mapear valores en un flujo de una forma a otra. El método de recopilación **(5)** recopila los valores de un flujo en una colección que se le proporciona, como una lista.

![](/programacion-java/assets/img/estructuras/part10.1-stream.webp)

### Operaciones terminales

Echemos un vistazo a cuatro operaciones terminales: el método `count` para contar el número de valores en una lista, el método `forEach` para recorrer los valores de la lista, el método de recopilación para reunir los valores de la lista en una estructura de datos y el método `reduce` para combinar los elementos de la lista.

El método `count` nos informa del número de valores en el flujo como una variable de tipo `Long`.

```java
List<Integer> values = new ArrayList<>();
values.add(3);
values.add(2);
values.add(17);
values.add(6);
values.add(8);

System.out.println("Cuántos: " + values.stream()
                   					.filter(n -> n > 5) // Sólo los mayores de 5
                   					.count()); // Y ahora contarlos
```

Cuyo resultado es:

```
Cuántos: 3
```

El método `forEach` define lo que se hace con cada valor de la lista y **finaliza** el procesamiento de flujo. En el siguiente ejemplo, primero creamos una lista de números, después de lo cual solo imprimimos los números que son divisibles por dos.

```java
List<Integer> values = new ArrayList<>();
values.add(3);
values.add(2);
values.add(17);
values.add(6);
values.add(8);

values.stream()
    .filter(value -> value % 2 == 0) // Siempre debe devolver un booleano
    .forEach(System.out::println);
	// Cuando el método sólo recibe un parámetro, se puede escribir como arriba. Se escribe la clase luego : y el 
	// nombre del método sin paréntesis
    //.forEach(value -> System.out.println(value));
```

Cuyo resultado es:

```
2
6
8
```

Puedes usar el método `collect` para recopilar valores de flujo en otra colección. El siguiente ejemplo crea una nueva lista que contiene el doble de los valores mayores de 5.

```java
List<Integer> list = new ArrayList<>();
list.add(3);
list.add(7);
list.add(4);
list.add(2);
list.add(6);

List<Integer> values = list.stream()
	.filter(value -> value > 5)
	.map(value -> value * 2)
	.collect(Collectors.toList());

System.out.println(values);
```

Cuya salida es:

```
[14, 12]
```
El método de `reduce` es útil cuando deseas combinar elementos de flujo en alguna otra forma. Los parámetros aceptados por el método tienen el siguiente formato: `reduce(*estadoinicial*, (*anterior*, *objeto*) -> *acciones sobre el objeto*)`.

Como ejemplo, puedes calcular la suma de una lista de enteros utilizando el método de reducción de la siguiente manera.

```java
ArrayList<Integer> values = new ArrayList<>();
values.add(7);
values.add(3);
values.add(2);
values.add(1);

int sum = values.stream()
    .reduce(0, (previousSum, value) -> previousSum + value);
System.out.println(sum);
```

Cuya salida es:

```
13
```

De la misma manera, podemos formar una cadena combinada separada por filas a partir de una lista de cadenas.

```java
ArrayList<String> words = new ArrayList<>();
words.add("First");
words.add("Second");
words.add("Third");
words.add("Fourth");

String combined = words.stream()
    .reduce("", (previousString, word) -> previousString + word + "\n");
System.out.println(combined);
```

Cuya salida es:

```
First
Second
Third
Fourth
```

## Objetos y Streams

El manejo de objetos usando métodos de `stream` es natural.  Las clases `Person` y `Book` se proporcionan a continuación.

```java
public class Person {
    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return this.name;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public String toString() {
        return this.name + " (" + this.birthYear + ")";
    }
}
```
Por ejemplo, vamos a obtener la media del año de nacimiento:
```java
public static void main(String[] args) {
        Person persona = new Person("Juan", "Pérez", 1980);
        List<Person> personas = new ArrayList<>();
        personas.add(persona);
        persona = new Person("María", "Pacheo", 1950);
        personas.add(persona);
        double media;
        media = personas.stream()
            	// Queremos sacar la media del año de nacimiento.
            	// Por eso, hemos de mapear (convertir) este atributo de Persona a Integer
                .mapToInt(Person::getBirthYear)
            	// Sacamos la media
                .average()
            	// Y la devolvemos como Double
            	.getAsDouble();
    
        System.out.println(media);
    }
```
Hemos elegido `Person::getBirthYear` como valor para calcular la media y devuelto la media mediante `.average().getAsDouble()`.

>-task-**Problema 1** 
>
><span style='color:green'> (ra2.d, ra2.h, ra3.b, ra3.f, ra5.c, ra6.b, ra6.e, ra6.c, ra6.d)</span>
>
>Recibes una lista de Personas. Imprime cuántas son las personas que nacieron antes de 1970:

>-task-**Ejercicio 2 (F)**  
>
><span style='color:green'> (ra2.d, ra2.h, ra3.b, ra3.f, ra5.c, ra6.b, ra6.e, ra6.c, ra6.d)</span>
>
>Recibes una lista de Personas. Imprime cuántas personas tienen un nombre que empiece por **A** 

>-task-**Ejercicio 3 (F)**
>
><span style='color:green'> (ra2.d, ra2.h, ra3.b, ra3.f, ra5.c, ra6.b, ra6.e, ra6.c, ra6.d)</span>
>
>Recibes una lista de Personas. Imprime los nombres que son únicos en orden alfabético

```java
public class Book {
    private Person author;
    private String name;
    private int pages;

    public Book(Person author, String name, int pages) {
        this.author = author;
        this.name = name;
        this.pages = pages;
    }

    public Person getAuthor() {
        return this.author;
    }

    public String getName() {
        return this.name;
    }

    public int getPages() {
        return this.pages;
    }
}
```

Digamos que tenemos una lista de libros. El cálculo del promedio de los años de nacimiento de los autores se puede hacer usando métodos de flujo de una manera que se sienta natural. Primero, convertimos el `stream` de libros en un `stream` de personas, y luego convertimos el `stream` de personas en una `stream` de años de nacimiento. Finalmente, le pedimos al `stream` (entero) un promedio.

```java
// Supongamos que tenemos una lista de libros
// List<Book> books = new ArrayList<>();
double average = books.stream()
    // Queremos trabajar con el Autor del libro
    .map(book -> book.getAuthor())
    // Y de él, el año de nacimiento
    .mapToInt(author -> author.getBirthYear())
    // Sacar la media
    .average()
    // Y devolverlo como Double
    .getAsDouble();

System.out.println("Media del año de nacimiento: " + average);

// El mapeo se podría resumir como sigue
// double average = books.stream()
//     .mapToInt(book -> book.getAuthor().getBirthYear())
//     ...
```

De manera similar, los nombres de los autores de libros con la palabra "Potter" en sus títulos se muestran de la siguiente manera.

```java
// let's assume that we have a list of books
// List<Book> books = new ArrayList<>();

books.stream()
    .filter(book -> book.getName().contains("Potter"))
    .map(book -> book.getAuthor())
    .forEach(author -> System.out.println(author));
```

----
Adaptado del siguiente material

* [https://java-programming.mooc.fi/part-10/1-handling-collections-as-streams](https://java-programming.mooc.fi/part-10/1-handling-collections-as-streams) 

