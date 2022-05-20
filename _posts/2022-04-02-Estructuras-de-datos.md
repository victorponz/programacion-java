---
typora-copy-images-to: ../assets/img/estructuras/
typora-root-url: ../../
layout: post
title: Básicas
categories: estructuras
conToc: true
permalink: estructuras-basicas
---

## ArrayList

Hemos visto en el tema de Arrays que éstos tienen un tamaño definido en el momento de la creación y que este tamaño es inmutable.

Si queremos usar este tipo de estructura pero que **pueda cambiar el tamaño**, usaremos `ArrayList`

```java
import java.util.ArrayList; 
ArrayList<String> coches = new ArrayList<String>(); 
```

El método para añadir elementos es `add`

```java
coches.add("Seat")
```

Para acceder al elemento iésimo `get`

```java
coches.get(0);
```

Para conocer su tamaño, `size`

```java
System.out.prinft("Existen % coches%n", coches.size());
```

Para eliminar el elemento iésimo, `remove`

```java
coches.remove(0);
```

Para recorrerlo usamos un  `for each`

```java
for(String coche: coches){
	System.out.println(coche);
}
```

Si necesitamos ordenarlos, 

```java
import java.util.Collections;
...
Collections.sort(coches);
...
```

## Ejercicio `Coches`

Realiza un programa que permita al usuario añadir Coches. Al final debe imprimirlos ordenados en líneas separadas

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.ArrayList;
> import java.util.Collections;
> public class Coches {
>     public static void main(String[] args) {
>         ArrayList<String> coches = new ArrayList<String>(); 
>         String coche;
>         do{
>             coche = Utilidades.leerCadena("Introduzca un coche (cadena vacía para acabar)");
>             if (coche.length() != 0)
>                coches.add(coche);
>         }while (coche.length() != 0);
> 
>         Collections.sort(coches);
> 
>         for (String cocheActual: coches){
>             System.out.println(cocheActual);
>         }
>     }
> }
> ```

## Ejercicio `Altura`

Programa Java que pida por teclado las alturas de N alumnos de una clase y las guarde en un `ArrayList` de tipo **Double**. 

A continuación el programa calculará la altura media de todos los alumnos, cuántos alumnos hay más altos que la media y cuantos más bajos.
Para resolverlo vamos a utilizar 6 métodos además del método `main`:

* Método `numeroAlumnos()`: este método pide por teclado el número de alumnos de la clase y devuelve dicho número al programa principal.
* Método `leerAlturas()`: pide por teclado las alturas de los N alumnos y las almacena en el `ArrayList`. Este método recibe como parámetros el `ArrayList` inicialmente vacío y el número de alumnos a leer.
* Método `calcularMedia()`: calcula y devuelve la media de los alumnos de la clase. Este método recibe como parámetro el `ArrayList` con las alturas de todos los alumnos.
* Método `calcularAlumnosAlturaSuperior`: devuelve el número de alumnos con una altura superior a la media
* Método `calcularAlumnosAlturaInferior`: devuelve el número de alumnos con una altura inferior a la media
* Método `mostrarResultados()`: muestra por pantalla todas las alturas y calcula y muestra el número de alumnos con altura superior e inferior a la media. Recibe como parámetros el `ArrayList` con las alturas de todos los alumnos y la media calculada anteriormente.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.ArrayList;
> public class Altura {
>     public static int numeroAlumnos(){
>         return Utilidades.leerEntero("Cuántos alumnos? ");
>     }
>     public static double calcularMedia(ArrayList<Double> alturas){
>         Double suma = 0D;
>         for (Double altura: alturas){
>             suma+= altura;
>         }
>         return suma / alturas.size();
>     }
>     public static int calcularAlumnosAlturaSuperior(ArrayList<Double> alturas, Double media){
>         int total = 0;
>         for (Double altura: alturas){
>             if (altura > media)
>                 total++;
>         }
>         return total;
>     }
>     public static int calcularAlumnosAlturainferior(ArrayList<Double> alturas, Double media){
>         int total = 0;
>         for (Double altura: alturas){
>             if (altura < media)
>                 total++;
>         }
>         return total;
>     }   
>     public static void mostrarResultados(ArrayList<Double> alturas){
>         Double media = calcularMedia(alturas);
>         int superior = calcularAlumnosAlturaSuperior(alturas, media);
>         int inferior = calcularAlumnosAlturainferior(alturas, media);
>         System.out.println("Las alturas son las siguientes:");
>         for(Double altura: alturas)
>             System.out.print(altura + ", ");
>         System.out.println("");
>         System.out.printf("La altura media es %f%n", media);
>         System.out.printf("El número de alummos con una altura superior es %d%n", superior);
>         System.out.printf("El número de alummos con una altura inferior es %d%n", inferior);
>     }
>     public static ArrayList<Double> leerAlturas(int numAlumnos){
>         ArrayList<Double> alturas = new ArrayList<Double>(); 
>         System.out.printf("Introduzca las %d alturas", numAlumnos);
>         for (int i = 1; i <= numAlumnos; i++){
>             alturas.add(Utilidades.leerDoble(""));
>         }
>         return alturas;
>     }
>     public static void main(String[] args) {
>         int numAlumnos = numeroAlumnos();
>         ArrayList<Double> alturas = leerAlturas(numAlumnos);
>         mostrarResultados(alturas);
>     }
> }
> ```

## HashMap, TreeMap y LinkedHashMap

Esta clases: `HashMap`, `TreeMap` y `LinkedHashMap` nos permite almacenar elementos asociando a cada clave un valor.

Para cada clave tenemos un valor asociado. Podemos después buscar fácilmente un valor para una determinada clave. Las claves en el diccionario no pueden repetirse.

Algunos ejemplos donde podríamos usar un Mapa:

* Guardar en la clave un País y en el valor su Capital
* Crear una lista con NIA`s de alumnos y sus nombres

**Ejemplo**

> Almacenar un diccionario las palabras en castellano como 'clave' y las traducciones de las mismas en el 'valor'. Probar los métodos más  significativos de la clase `HashMap`.

```java
import java.util.HashMap;
import java.util.Map;

public class PruebaHashMap {
    public static void main(String[] args) {
        Map<String, String> mapa1 = new HashMap<String, String>();
        mapa1.put("rojo", "red");
        mapa1.put("verde", "green");
        mapa1.put("azul", "blue");
        mapa1.put("blanco", "white");
        
        System.out.println("Listado completo de valores");
        for (String valor : mapa1.values())
            System.out.print(valor + "-");
        System.out.println();
        
        System.out.println("Listado completo de claves");
        for (String clave : mapa1.keySet())
            System.out.print(clave + "-");
        System.out.println();
        
        System.out.println("La traducción de 'rojo' es:" + mapa1.get("rojo"));
        
        if (!mapa1.containsKey("negro"))
            System.out.println("No existe la clave 'negro'");
        
        System.out.println("La traducción de 'marron' es:" + mapa1.getOrDefault("marrón", "No existe la clave marrón"));
        
        mapa1.remove("rojo");
        System.out.println(mapa1);
    }
}
```

La interfaz `Map` deben implementar estas clases, luego si creamos un  objeto de la clase `HashMap` debemos hacerlo con la siguiente sintaxis:

```java
Map<String, String> mapa1 = new HashMap<String, String>();
```

La clase `HashMap` utiliza datos genéricos tanto para la clave como  para el valor, en este ejemplo la clave y el valor son datos de tipo  **String**.

Mediante el método `put` agregamos un elemento a la colección de tipo `HashMap`:

```java
mapa1.put("rojo", "red");
mapa1.put("verde", "green");
mapa1.put("azul", "blue");
mapa1.put("blanco", "white");
```

Para imprimir todos los valores del mapa lo recorremos mediante un `for`:

```java
for (String valor : mapa1.values())
	System.out.print(valor + "-");
```

De forma similar si queremos recorrer todas las claves del mapa:

```java
for (String clave : mapa1.keySet())
    System.out.print(clave + "-");
```

Para recuperar un valor para una determinada clave llamamos al método 'get' y le pasamos la clave a buscar, si dicha clave no existe en el  mapa se nos retorna el valor 'null':

```java
System.out.println("La traducción de 'rojo' es:" + mapa1.get("rojo"));
```

Si queremos verificar si una determinada clave existe en el mapa lo hacemos mediante el método `containsKey`:

```java
if (mapa1.containsKey("negro"))
    System.out.println("No existe la clave 'negro'");
```

Una variante del método `get` es `getOrDefault` que nos retorna el segundo parámetro si no encuentra la clave en el mapa:

```java
System.out.println("La traducción de 'marron' es:" +
                   mapa1.getOrDefault("marrón", "No existe la clave marrón"));
```

Para eliminar un elemento de la colección debemos hacer uso del método `remove`, pasamos una clave del mapa:

```java
mapa1.remove("rojo");
```

Para imprimir el mapa completo en la Consola podemos hacer uso del método `println`:

```java
System.out.println(mapa1);
```

Hemos utilizado la clase `HashMap` para resolver el problema. La clase  `TreeMap` es idéntica a `HashMap` con la salvedad que mantiene ordenado los  datos por la clave.

Finalmente la clase `LinkedHashMap` mantiene ordenado los elementos del mapa según el orden de inserción.

## Ejercicio `PaisCapital`

Declara un `HashMap` que almacene el país y la capital de varios países Europeos. Luego realiza un programa que pida un País al usuario y muestre su capital.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.HashMap;
> import java.util.Map;
> 
> public class PaisCapital {
>     public static void main(String[] args) {
>         String pais = "";
>         Map<String, String> capitales = new HashMap<String, String>();
>         capitales.put("España", "Madrid");
>         capitales.put("Francia", "París");
>         capitales.put("Inglaterra", "Londres");
>         capitales.put("Italia", "Roma");
>         do{
>             pais = Utilidades.leerCadena("Introduzca un país (cadena vacía para acabar)");
>             if (pais.length() != 0)
>                 System.out.println(capitales.getOrDefault(pais, "No existe ese país en la base de datos"));
>         }while (pais.length() != 0);
>     }
> }
> ```
>

