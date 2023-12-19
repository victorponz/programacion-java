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

En esta parte del curso, presentamos el manejo de colecciones con flujos. Aprenderás a crear una flujo a partir de una colección, filtrar los valores de una flujo, transformar los valores de una flujo y recopilar valores de una flujo en otra colección. Presentamos el concepto **expresión lambda** y aprenderás a usarlo en tus programas. También aprenderás cómo ordenar objetos utilizando la interfaz `Comparable` de Java y algunas otras técnicas útiles como expresiones regulares, tipo enumeración y los iteradores.

Conozcamos las colecciones, como las listas, como flujos de valores. 

> -info-`Stream` es una forma de recorrer una colección de datos de manera que el programador determina la operación que se realizará en cada valor. No se lleva registro del índice ni de la variable que se esté procesando en cada momento.

Con flujos, el programador define una secuencia de eventos que se ejecuta para cada valor en una colección. Una cadena de eventos puede incluir volcar algunos de los valores, convertir valores de una forma a otra o cálculos. Una secuencia no cambia los valores en la recopilación de datos original, sino que simplemente los procesa. Si desea conservar las transformaciones, deben compilarse en otra recopilación de datos.

Comencemos a comprender el uso de flujos a través de un ejemplo concreto. Considera el siguiente problema:

>-task-**Ejercicio**
>
> Escribe un programa que a partir de un `ArrayList` con  números en formato de cadena imprima el número de enteros positivos divisibles por tres y el promedio de todos los valores.

Vamos a implemertarlo de la manera tradicional:

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

Esta es la forma usando `Stream`

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
                //filtramos los que sean múltiplo de 3
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
                .filter(number -> number % 3 == 0)
                //y los contamos
                .count();
```

Se puede convertir a `Stream` cualquier objeto de la implemente la interfaz `Collection` (Como `ArrayList`, `HashSet`, `HashMap`, etc)

Luego lo convertimos a entero en la línea 3 y le aplicamos un filtro. Este es del estilo (valor -> condición del filtro). Cuando aplicamos el filtro, ya sólo nos queda 1 elemento en el `Stream`,

## Suma de positivos o negativos

Realiza un programa que mediante la conversión a `Stream` de un `ArrayList` con números enteros calcule cuántos números positivos hay y cuántos negativos.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.ArrayList;
> import java.util.List;
> 
> public class Suma {
>     public static void main(String[] args) {
>         List<Integer> numeros = new ArrayList<>();
>       
>         numeros.add(25);
>         numeros.add(-5);
>         numeros.add(20);
>         numeros.add(-10);
>         numeros.add(-5);
>         Long positivos = numeros.stream()
>                     .filter(numero -> numero > 0)
>                     .count();
>         Long negativos = numeros.stream()
>                     .filter(numero -> numero < 0)
>                     .count();
>         
>         System.out.printf("Los positivos son %d y los negativos son %d%n", positivos, negativos);
>     }
> }
> ```

Si queremos sumar los datos, hemos de usar un truco

```java
int suma = numeros.stream()
	.mapToInt(Integer::valueOf)
	.sum();
```

Hay que usar `mapToInt(Integer::valueOf)` 

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

System.out.println("Cuántos: " + values.stream().filter(n -> n > 5).count());
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
    .filter(value -> value % 2 == 0)
    .forEach(value -> System.out.println(value));
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

### Operaciones intermedias

Las operaciones de flujo intermedio son métodos que devuelven un flujo. Dado que el valor devuelto es un flujo, podemos llamar secuencialmente a las operaciones intermedias. Las operaciones intermedias típicas incluyen convertir un valor de una forma a otra utilizando `map` y su forma más específica `mapToInt` utilizada para convertir una secuencia en una secuencia de enteros. Otros incluyen filtrar valores con `filter`, identificar valores únicos con `distinct` y organizar valores con `sorted` (si es posible).

Veamos estos métodos en acción a través de algunos problemas. Digamos que tenemos la siguiente clase `Person`.

```java
public class Person {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getBirthYear() {
        return this.birthYear;
    }
}
```

>-task-**Problema 1** 
>Recibes una lista de Personas. Imprime cuántas son las personas que nacieron antes de 1970:
>
>```java
>ArrayList<Person> personsas = new ArrayList<>();
>Person persona = new Person("Pepe", "García", 1968);
>personas.add(persona);
>persona = new Person("María", "García", 1998);
>personas.add(persona);
>persona = new Person("Juan", "Martínez", 1968);
>
>long count = personss.stream()
>.filter(person -> person.getBirthYear() < 1970)
>.count();
>System.out.println("Count: " + count); //El resultado es 2
>```

>-task-**Ejercicio 2**  
> Recibes una lista de Personas. Imprime cuántas personas tienen un primer apellido que empiece por **A** 

>-task-**Ejercicio 3**
> Recibes una lista de Personas. Imprime los nombres que son únicos en orden alfabético

> -task-**Ejercicio 4** 
>Escribe un programa que lea la entrada del usuario como cadenas. Cuando el usuario ingresa una cadena vacía (solo presiona `enter`), la lectura de entrada se detendrá y el programa imprimirá todas las entradas del usuario mediante el uso de `streams`

>-task-**Ejercicio 5** 
> Escribe un programa que lea la entrada del usuario. Cuando el usuario da un número negativo como entrada, la lectura de entrada se detendrá. Después de esto, imprime todos los números que el usuario ha dado como entrada que están entre 1 y 5 con el uso de `streams`
>
> -task-**Ejercicio 6** 
> Crea un programa que vaya leyendo la entrada desde el teclado y cree objetos de la clase `Person`
>
> Para finalizar se introducirá una cadena vacía. Ahora imprime los `lastNames` únicos en orden alfabético.

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
// let's assume that we have a list of books
// List<Book> books = new ArrayList<>();
double average = books.stream()
    .map(book -> book.getAuthor())
    .mapToInt(author -> author.getBirthYear())
    .average()
    .getAsDouble();

System.out.println("Average of the authors' birth years: " + average);

// the mapping of a book to an author could also be done with a single map call
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


