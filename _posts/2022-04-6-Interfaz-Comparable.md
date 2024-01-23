---
typora-copy-images-to: ../assets/img/estructuras/
typora-root-url: ../../
layout: post
title: Interfaz Comparable
categories: estructuras
conToc: true
permalink: interfaz-comparable
---

El método `compareTo` requerido por la interfaz `Comparable` recibe como parámetro el objeto con el que se compara el objeto `this`. Si el objeto `this` viene antes que el objeto recibido como parámetro en términos de orden de clasificación, el método debería devolver un número negativo. Si, por el contrario, el objeto `this` viene después del objeto recibido como parámetro, el método debería devolver un número positivo. De lo contrario, se devuelve 0. La ordenación resultante del método `compareTo` se denomina ordenación natural.

Echemos un vistazo a esto con la ayuda de una clase de `Member` que representa a un niño o joven que pertenece a un club. Cada miembro del club tiene un nombre y una altura. Los miembros del club deben ir a comer en orden de altura, por lo que la clase `Member` debe implementar la interfaz `Comparable`. La interfaz `Comparable` toma como parámetro de tipo la clase que es objeto de la comparación. 

```java
public class Member implements Comparable<Member> {
    private String name;
    private int height;

    public Member(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        return this.getName() + " (" + this.getHeight() + ")";
    }

    @Override
    public int compareTo(Member member) {
        if (this.height == member.getHeight()) {
            return 0;
        } else if (this.height > member.getHeight()) {
            return 1;
        } else {
            return -1;
        }
    }
}
```

El método `compareTo` requerido por la interfaz devuelve un número entero que nos informa el orden de comparación.

Como devolver un número negativo de `compareTo()` es suficiente si este objeto es más pequeño que el objeto de parámetro, y devolver cero es suficiente cuando las longitudes son las mismas, el método `compareTo` descrito anteriormente también se puede implementar de la siguiente manera.

```java
@Override
public int compareTo(Member member) {
    return this.height - member.getHeight();
}
```

Dado que la clase `Member` implementa la interfaz `Comparable`, es posible ordenar la lista utilizando el método ordenado. De hecho, los objetos de cualquier clase que implementen la interfaz Comparable se pueden ordenar mediante el método de ordenación. Ten en cuenta, sin embargo, que una transmisión no ordena la lista original; solo se ordenan los elementos de la transmisión.

Si un programador quiere organizar la lista original, se debe usar el método de clasificación de la clase `Collections`. Esto, por supuesto, asume que los objetos en la lista implementan la interfaz `Comparable`.

Clasificar a los miembros del club es sencillo ahora.

```java
List<Member> members = new ArrayList<>();
members.add(new Member("mikael", 182));
members.add(new Member("matti", 187));
members.add(new Member("ada", 184));

members.stream().forEach(System.out::println);
System.out.println();
// sorting the stream that is to be printed using the sorted method
members.stream().sorted().forEach(System.out::println);
members.stream().forEach(System.out::println);
// sorting a list with the sort-method of the Collections class
Collections.sort(members);
members.stream().forEach(System.out::println);
```

Cuya salida es:

```
mikael (182)
matti (187)
ada (184)

mikael (182)
ada (184)
matti (187)

mikael (182)
matti (187)
ada (184)

mikael (182)
ada (184)
matti (187)
```

>-task-**Ejercicio (F)** 
>
>Se te proporciona la clase `Human`. Un ser humano tiene un nombre e información sobre salario. Implementa la interfaz `Comparable` de tal manera que el método `compareTo` clasifique a los humanos según el salario del más grande al más pequeño.

## Método de ordenación como una expresión lambda

Supongamos que tenemos la siguiente clase:

```java
public class Person {

    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }
}
```

Y una lista de objetos `Person`

```java
ArrayList<Person> persons = new ArrayList<>();
persons.add(new Person("Ada Lovelace", 1815));
persons.add(new Person("Irma Wyman", 1928));
persons.add(new Person("Grace Hopper", 1906));
persons.add(new Person("Mary Coombs", 1929));
```

Queremos ordenar la lista sin tener que implementar la interfaz `Comparable`.

Tanto el método `sort` de la clase `Collections` como el método `sorted` del `stream` aceptan una expresión lambda como parámetro que define los criterios de clasificación. Más específicamente, ambos métodos se pueden proporcionar con un objeto que implementa la interfaz `Comparator`, que define el orden deseado: la expresión lambda se usa para crear este objeto.

```java
ArrayList<Person> persons = new ArrayList<>();
persons.add(new Person("Ada Lovelace", 1815));
persons.add(new Person("Irma Wyman", 1928));
persons.add(new Person("Grace Hopper", 1906));
persons.add(new Person("Mary Coombs", 1929));

persons.stream().sorted((p1, p2) -> {
    return p1.getBirthYear() - p2.getBirthYear();
}).forEach(p -> System.out.println(p.getName()));

System.out.println();

persons.stream().forEach(p -> System.out.println(p.getName()));

System.out.println();

Collections.sort(persons, (p1, p2) -> p1.getBirthYear() - p2.getBirthYear());

persons.stream().forEach(p -> System.out.println(p.getName()));
```

Cuya salida es:

```
Ada Lovelace
Grace Hopper
Irma Wyman
Mary Coombs

Ada Lovelace
Irma Wyman
Grace Hopper
Mary Coombs

Ada Lovelace
Grace Hopper
Irma Wyman
Mary Coombs
```

Al comparar cadenas, podemos usar el método `compareTo` proporcionado por la clase `String`. El método devuelve un número entero que describe el orden de la cadena que se le da como parámetro y la cadena que lo llama.

```java
ArrayList<Person> persons = new ArrayList<>();
persons.add(new Person("Ada Lovelace", 1815));
persons.add(new Person("Irma Wyman", 1928));
persons.add(new Person("Grace Hopper", 1906));
persons.add(new Person("Mary Coombs", 1929));

persons.stream().sorted((p1, p2) -> {
    return p1.getName().compareTo(p2.getName());
}).forEach(p -> System.out.println(p.getName()));
```

```
Ada Lovelace
Grace Hopper
Irma Wyman
Mary Coombs
```

>-task-**Ejercicio (M)**
> 
>El siguiente [archivo](/programacion-java/assets/illiterate.csv) muestra la población analfabeta mundial en el formato:
>
>```
>"ILLPOP_AG15T24","Youth illiterate population, 15-24 years, both sexes
 (number)","40550","Small Island Developing States","2016","2016",1192378,,
>```
>
>Se trata de realizar un programa que lea este archivo y que luego muestre la información en pantalla por orden ascendente del total de personas analfabetas (en el ejemplo, 1192378)

## Clase Comparator

Otra forma de realizar la ordenación es mediante el uso de la clase `Comparator`. 

Vamos a usar la siguiente clase:

```java
public class Film {
    private String name;
    private int releaseYear;

    public Film(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return this.name;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public String toString() {
        return this.name + " (" + this.releaseYear + ")";
    }
}
```

La clase `Comparator` proporciona dos métodos esenciales para ordenar: `comparing` y `thenComparing`. Al método de comparación se le pasa primero el valor que se va a comparar, y `thenComparing` se le pasa el siguiente valor que se va a comparar. El método `thenComparing` se puede utilizar muchas veces mediante métodos de encadenamiento, lo que permite utilizar valores prácticamente ilimitados para la comparación.

En el siguiente ejemplo, imprimimos películas por año y título en orden.

```java
List<Film> films = new ArrayList<>();
films.add(new Film("A", 2000));
films.add(new Film("B", 1999));
films.add(new Film("C", 2001));
films.add(new Film("D", 2000));

for (Film e: films) {
    System.out.println(e);
}

Comparator<Film> comparator = Comparator
              .comparing(Film::getReleaseYear)
              .thenComparing(Film::getName);

Collections.sort(films, comparator);

for (Film e: films) {
    System.out.println(e);
}
```

Cuya salida es:

```
A (2000)
B (1999)
C (2001)
D (2000)

B (1999)
A (2000)
D (2000)
C (2001)
```

>-task-**Ejercicios**
>
>[Felipe y sus tareas](https://www.aceptaelreto.com/problem/statement.php?id=579) **(F)**
>
>[La justicia de la lotería](https://www.aceptaelreto.com/problem/statement.php?id=378) **(M)**
>
>[Los niños buenos](https://www.aceptaelreto.com/problem/statement.php?id=366) **(F)**
>
>[Los tesoros de Tutankamón](https://www.aceptaelreto.com/problem/statement.php?id=661&cat=154) **(F)**

----
Adaptado del siguiente material

* [https://java-programming.mooc.fi/part-10/2-interface-comparable](https://java-programming.mooc.fi/part-10/2-interface-comparable)


