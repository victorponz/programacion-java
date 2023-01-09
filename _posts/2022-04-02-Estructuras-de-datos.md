---
typora-copy-images-to: ../assets/img/estructuras/
typora-root-url: ../../
layout: post
title: Estructuras básicas
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
System.out.printf("Existen %d coches%n", coches.size());
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

Vamos a ver unos cuantos ejemplos.

```java
// Java program to Demonstrate List Interface

// Importing all utility classes
import java.util.*;

// Main class
// ListDemo class
class GFG {

	// Main driver method
	public static void main(String[] args)
	{
        //Crear un objeto de la interface List
        //Implementado por la clase ArrayList
		List<Integer> l1 = new ArrayList<Integer>();

		// Añadir elementos
		l1.add(0, 1);
		l1.add(1, 2);

		// Imprimir los elementos del array
		System.out.println(l1);

		List<Integer> l2 = new ArrayList<Integer>();

		l2.add(1);
		l2.add(2);
		l2.add(3);

        //Añadirá todos los elementos de l2 a partir del índice 1
		l1.addAll(1, l2);

		System.out.println(l1);

		// Elimina el elemento 1 del array
		l1.remove(1);

		System.out.println(l1);

		// Imprime el elemento en la posición 3 mediante get
		System.out.println(l1.get(3));

        //Reemplaza el elemento 0 por el número 5
		l1.set(0, 5);

		// Again printing the updated List 1
		System.out.println(l1);
	}
}
```

**Salida**

```
[1, 2]
[1, 1, 2, 3, 2]
[1, 2, 3, 2]
2
[5, 2, 3, 2]
```
**Añadir elementos**
```java
// Java Program to Add Elements to a List

// Importing all utility classes
import java.util.*;

// Main class
class GFG {

	// Main driver method
	public static void main(String args[])
	{
		// Creating an object of List interface,
		// implemented by ArrayList class
		List<String> al = new ArrayList<>();

		// Adding elements to object of List interface
		// Custom elements
		al.add("Geeks");
		al.add("Geeks");
		al.add(1, "For");

		// Print all the elements inside the
		// List interface object
		System.out.println(al);
	}
}
```
**Salida**

```
[Geeks, For, Geeks]
```
**Actualizar elementos**

```java
// Java Program to Update Elements in a List

// Importing utility classes
import java.util.*;

// Main class
class GFG {

	// Main driver method
	public static void main(String args[])
	{
		// Creating an object of List interface
		List<String> al = new ArrayList<>();

		// Adding elements to object of List class
		al.add("Geeks");
		al.add("Geeks");
		al.add(1, "Geeks");

		// Display theinitial elements in List
		System.out.println("Initial ArrayList " + al);

		// Setting (updating) element at 1st index
		// using set() method
		al.set(1, "For");

		// Print and display the updated List
		System.out.println("Updated ArrayList " + al);
	}
}
```

```
Initial ArrayList [Geeks, Geeks, Geeks]
Updated ArrayList [Geeks, For, Geeks]
```

**Eliminar elementos**

Para eliminar un elemento de una lista, podemos usar el método `remove()`. Este método está sobrecargado para realizar múltiples operaciones basadas en diferentes parámetros.

```java
// Java Program to Remove Elements from a List

// Importing List and ArrayList classes
// from java.util package
import java.util.ArrayList;
import java.util.List;

// Main class
class GFG {

	// Main driver method
	public static void main(String args[])
	{

		// Creating List class object
		List<String> al = new ArrayList<>();

		// Adding elements to the object
		// Custom inputs
		al.add("Geeks");
		al.add("Geeks");

		// Adding For at 1st indexes
		al.add(1, "For");

		// Print the initialArrayList
		System.out.println("Initial ArrayList " + al);

		// Now remove element from the above list
		// present at 1st index
		al.remove(1);

		// Print the List after removal of element
		System.out.println("After the Index Removal " + al);

		// Now remove the current object from the updated
		// List
		al.remove("Geeks");

		// Finally print the updated List now
		System.out.println("After the Object Removal " + al);
	}
}
```

**Salida**

```
Initial ArrayList [Geeks, For, Geeks]
After the Index Removal [Geeks, Geeks]
After the Object Removal [Geeks]
```

**Iterar por una lista**

```java
// Java program to Iterate the Elements
// in an ArrayList

// Importing java utility classes
import java.util.*;

// Main class
public class GFG {

	// main driver method
	public static void main(String args[])
	{
		// Creating an empty Arraylist of string type
		List<String> al = new ArrayList<>();

		// Adding elements to above object of ArrayList
		al.add("Geeks");
		al.add("Geeks");

		// Adding element at specified position
		// inside list object
		al.add(1, "For");

		// Using for loop for iteration
		for (int i = 0; i < al.size(); i++) {

			// Using get() method to
			// access particular element
			System.out.print(al.get(i) + " ");
		}

		// New line for better readability
		System.out.println();

		// Using for-each loop for iteration
		for (String str : al)

			// Printing all the elements
			// which was inside object
			System.out.print(str + " ");
	}
}
```

**Salida**

```
Geeks For Geeks 
Geeks For Geeks 
```

| Método                                                       | Descripción                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [add(int index, Object element)](https://www.geeksforgeeks.org/java-util-arraylist-add-method-java/) | Este método se utiliza para insertar un elemento específico en un índice de posición específico en una lista. |
| [add(Object o)](https://www.geeksforgeeks.org/java-util-arraylist-add-method-java/) | Este método se usa para agregar un elemento específico al final de una lista. |
| [addAll(Collection C)](https://www.geeksforgeeks.org/java-util-arraylist-addall-method-java/) | Este método se usa para agregar todos los elementos de una colección específica al final de la lista mencionada. |
| [addAll(int index, Collection C)](https://www.geeksforgeeks.org/java-util-arraylist-addall-method-java/) | Se utiliza para insertar todos los elementos que comienzan en la posición especificada de una colección específica en la lista mencionada. |
| [clear()](https://www.geeksforgeeks.org/arraylist-clear-java-examples/) | Este método se utiliza para eliminar todos los elementos de cualquier lista. |
| [contains(Object o)](https://www.geeksforgeeks.org/arraylist-contains-java/) | Devuelve verdadero si esta lista contiene el elemento especificado. |
| [forEach(Consumer action)](https://www.geeksforgeeks.org/arraylist-foreach-method-in-java/) | Realiza la acción dada para cada elemento del iterable hasta que se hayan procesado todos los elementos o la acción genere una excepción. |
| [get(int index)](https://www.geeksforgeeks.org/arraylist-get-method-java-examples/) | Devuelve el elemento en la posición especificada en esta lista. |
| [indexOf(Object O)](https://www.geeksforgeeks.org/java-util-arraylist-indexof-java/) | Se devuelve el índice de la primera aparición de un elemento específico, o -1 en caso de que el elemento no esté en la lista. |
| [isEmpty()](https://www.geeksforgeeks.org/arraylist-isempty-java-example/) | Devuelve verdadero si esta lista no contiene elementos.      |
| [lastIndexOf(Object O)](https://www.geeksforgeeks.org/arraylist-lastindexof-java-example/) | Se devuelve el índice de la última aparición de un elemento específico o -1 en caso de que el elemento no esté en la lista. |
| [listIterator()](https://www.geeksforgeeks.org/arraylist-listiterator-method-in-java-with-examples/) | Devuelve un iterador de lista sobre los elementos de esta lista (en la secuencia adecuada). |
| [listIterator(int index)](https://www.geeksforgeeks.org/arraylist-listiterator-method-in-java-with-examples/) | Devuelve un iterador de lista sobre los elementos de esta lista (en la secuencia adecuada), comenzando en la posición especificada en la lista. |
| [remove(int index)](https://www.geeksforgeeks.org/arraylist-linkedlist-remove-methods-java-examples/) | Elimina el elemento en la posición especificada en esta lista. |
| [remove(Object o)](https://www.geeksforgeeks.org/arraylist-linkedlist-remove-methods-java-examples/) | Elimina la primera aparición del elemento especificado de esta lista, si está presente. |
| [removeAll(Collection c)](https://www.geeksforgeeks.org/arraylist-removeall-method-in-java-with-examples/) | Elimina de esta lista todos sus elementos que están contenidos en la colección especificada. |
| [removeIf(Predicate filter)](https://www.geeksforgeeks.org/arraylist-removeif-method-in-java/) | Elimina todos los elementos de esta colección que satisfacen el predicado dado. |
| [removeRange(int fromIndex, int toIndex)](https://www.geeksforgeeks.org/arraylist-removerange-java-examples/) | Elimina de esta lista todos los elementos cuyo índice se encuentra entre `fromIndex`, inclusive, y `toIndex`, exclusivo. |
| [retainAll(Collection c)](https://www.geeksforgeeks.org/arraylist-retainall-method-in-java/) | Conserva solo los elementos de esta lista que están contenidos en la colección especificada. |
| [set(int index, E element)](https://www.geeksforgeeks.org/arraylist-set-method-in-java-with-examples/) | Reemplaza el elemento en la posición especificada en esta lista con el elemento especificado. |
| [size()](https://www.geeksforgeeks.org/arraylist-size-method-in-java-with-examples/) | Devuelve el número de elementos de esta lista.               |
| [subList(int fromIndex, int toIndex)](https://www.geeksforgeeks.org/arraylist-sublist-method-in-java-with-examples/) | Devuelve una vista de la parte de esta lista entre `fromIndex`, inclusive, y `toIndex`, exclusivo. |
| [toArray()](https://www.geeksforgeeks.org/arraylist-array-conversion-java-toarray-methods/) | Este método se utiliza para devolver una matriz que contiene todos los elementos de la lista en el orden correcto. |
| [toArray(Object O)](https://www.geeksforgeeks.org/arraylist-array-conversion-java-toarray-methods/) | También se usa para devolver una matriz que contiene todos los elementos de esta lista en el orden correcto, igual que el método anterior. |



**Fuente**
[https://www.geeksforgeeks.org/list-interface-java-examples/](https://www.geeksforgeeks.org/list-interface-java-examples/)

### Ejercicio `Coches`

Realiza un programa que permita al usuario añadir Coches mediante la consola. Si escribe una línea en blanco, se acaba de añadir coches.

Al final debe imprimirlos ordenados en líneas separadas

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
>                 coches.add(coche);
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

### Ejercicio `Altura`

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
>     public static int calcularAlumnosAlturaInferior(ArrayList<Double> alturas, Double media){
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
>         int inferior = calcularAlumnosAlturaInferior(alturas, media);
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

### Ejercicio Convertir a array

Crea un programa para convertir un ArrayList en un array:

> -toogle- Piensa antes de ver la solución
>
> ```java
> import java.util.*;
> 
> public class ConvertArrayListToArray {
>     public static void main(String args[]) {
>       // Creating and initializing ArrayList
>       ArrayList<String> fruits = new ArrayList<>();
>       fruits.add("Apple");
>       fruits.add("Banana");
>       fruits.add("Mango");
>       fruits.add("Pear");
> 
>       // ArrayList to String array conversion
>       String[] str = new String[fruits.size()];
>       for(int i=0; i < fruits.size(); i++) {
>           str[i] = fruits.get(i);
>       }
>       
>       // Print elements using for-each loop
>       for(String s : str) {
>         System.out.println(s);      
>       }
>     }
> }
> ```

### Ejercicio existe

Dado un `ArrayList`, haz un método para comprobar si un elemento existe en dicho `ArrayList`.

> -toogle- Piensa antes de mirar
>
> ```java
> import java.util.*;
> public class ArrayListContainsExample {
>     public static boolean existe(ArrayList<Integer> l, int n){
>         return l.contains(n);
>     }
>     public static void main(String args[]) {
>         // initialize ArrayList  
>         ArrayList<Integer> al = new ArrayList<Integer>();
>         // add elements to ArrayList object
>         al.add(3);
>         al.add(17);
>         al.add(6);
>         al.add(9);
>         al.add(7);
> 
>         if (al.contains(7)) {
>             System.out.println("7 was found in the list");
>         } else {
>             System.out.println("7 was not found in the list");
>         }        
>     }
> }
> ```

### Ejercicio AddAll

Haz un programa que añada todos los elementos de una lista a otra

> -toogle- Piensa antes de mirar
>
> ```java
> import java.util.*;
> public class AddAll {
>     public static void main(String[] args) {
>         List<String> l = new ArrayList<String>();
>         l.add("uno");
>         l.add("dos");
>         l.add("tres");
>         List<String> ll = new ArrayList<String>();
>         ll.add("cuatro");
>         ll.add("cinco");
>         ll.add("seis");
>         //Añadimos toda la lista l a la ll
>         ll.addAll(l);
>         System.out.println(ll);
>     }
> }
> ```

### Repartiendo regalos en tu calle

 Papá Noel quiere repartir juguetes a todos los niños de la    mejor calle del mundo: la tuya. Para ello, consulta una lista de los portales de esa calle en los que debe dejar regalos.

La forma en la que reparte los regalos es peculiar. Aterriza con su trineo en un portal determinado (que no tiene por qué ser uno en los que tiene que dar regalos), y luego sigue las siguientes reglas:

- Reparte los regalos al portal que tiene más cerca de su posición actual.
- La distancia entre dos portales es el valor absoluto de su resta. Es decir, la distancia entre el portal 10 y el portal 8 es 2 (10 − 8 = 2), lo mismo que la distancia entre el portal 8 y el portal 10 (valor absoluto de 8 − 10).
- Si dos portales están a igual distancia, siempre va hacia el que tiene el número más grande.

¿Cuál es el orden en el que visita los portales?

La entrada constará de 2 parámetros: el número de portal en el que aterriza y una lista con todos los portales que ha de visitar.

Por ejemplo, `0, 2, 4` Indica que aterriza en el portal 0 y tiene que repartir al 2 y al 4.

Y la salida será

```
2, 4
```

`3, 2, 5, 1` cuya salida será 

```
2 1 5
```

y `3, 2, 4, 7` cuya salida será

```
4 2 7
```

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.ArrayList;
> import java.util.Arrays;
> import java.util.Collections;
> import java.util.List;
> public class Portales {
> 
>     public static void main(String[] args) {
> 
>         System.out.println(repartir(0, 2, 4));
>         System.out.println(repartir(3, 2, 5, 1));
>         System.out.println(repartir(3, 2, 4, 7));
>        
>     }
> 
>     public static String repartir(int aterriza, Integer ... portales) {
>         List<Integer> portals = new ArrayList<>();
>         String result = "";
>         int  temp, index = -1;
>         int actual = aterriza;
>         int diff, min;
>         Arrays.sort(portales);
>         Collections.addAll(portals, portales);
>         while (!portals.isEmpty()) {
>             min = Integer.MAX_VALUE;
>             temp = 0;
>             for (int i = 0; i < portals.size(); i++) {
>                 //Calcular el mínimo desde el actual
>                 diff = Math.abs(portals.get(i) - actual);
>                 if (diff <= min ){
>                     min = diff;
>                     temp = portals.get(i);
>                     index = i;
>                 }
>             }
>             actual = temp;
>             result += actual + " ";
>             portals.remove(index);
> 
>         }
>         return result;
>     }
> 
> }
> ```
>

**Fuente**
[https://www.aceptaelreto.com/problem/statement.php?id=367](https://www.aceptaelreto.com/problem/statement.php?id=367)

## HashMap, TreeMap y LinkedHashMap

Esta clases: `HashMap`, `TreeMap` y `LinkedHashMap` nos permite almacenar elementos asociando a cada clave un valor.

Para cada clave tenemos un valor asociado. Podemos después buscar fácilmente un valor para una determinada clave. Las claves en el diccionario no pueden repetirse.

Algunos ejemplos donde podríamos usar un Mapa:

* Guardar en la clave un País y en el valor su Capital
* Crear una lista con NIA`s de alumnos y sus nombres

**Ejemplo**

> Almacenar un diccionario las palabras en castellano como 'clave' y las traducciones de las mismas en el 'valor'. 

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

La clase `HashMap` debe implementar la interfaz `Map`, así que se declara como;

```java
Map<String, String> mapa1 = new HashMap<String, String>();
```

La clase `HashMap` utiliza datos genéricos tanto para la clave como para el valor, en este ejemplo la clave y el valor son datos de tipo  **String**.

Mediante el método `put` agregamos un elemento a la colección de tipo `HashMap`:

```java
mapa1.put("rojo", "red");
mapa1.put("verde", "green");
mapa1.put("azul", "blue");
mapa1.put("blanco", "white");
```

Para imprimir todos los valores del mapa lo recorremos mediante un `for-each`:

```java
for (String valor : mapa1.values())
	System.out.print(valor + "-");
```

De forma similar si queremos recorrer todas las claves del mapa:

```java
for (String clave : mapa1.keySet())
    System.out.print(clave + "-");
```

Para recuperar un valor para una determinada clave llamamos al método `get` y le pasamos la clave a buscar, si dicha clave no existe en el  mapa se nos retorna el valor `null`:

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

Hemos utilizado la clase `HashMap` para resolver el problema. La clase  `TreeMap` es idéntica a `HashMap` con la salvedad que mantiene ordenado los datos por la clave.

Finalmente la clase `LinkedHashMap` mantiene ordenado los elementos del mapa según el orden de inserción.


### Ejercicio `PaisCapital.java`

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

## Teléfonos

Queremos tener un guía de teléfonos que asocie un número de teléfono a un contacto. El programa debe pedir un contacto y mostrar su número asociado

## Teléfonos II

Se trata de implementar el ejercicio anterior pero un contacto puede tener más de un teléfono:

> -toogle- Pista
>
> Utiliza un `ArrayList` como valor
>
> ```java
> HashMap<String, ArrayList<String>> phoneNumbers = new HashMap<>();
> ```

### La mejor terminación

​      En los sorteos de la lotería más mediáticos, como el del Gordo de Navidad o el del Niño, es habitual que los fetichistas  busquen números con algún tipo de significado extraño o que los matemáticos y estadísticos se entretengan informando sobre los números más habituales.    

​      Esto último es interesante si queremos maximizar la probabilidad de ganar algo. Dado que los números que terminan con el mismo dígito que el del premio principal tienen un reintegro, una buena forma de intentar, al menos, no perder dinero es jugar un número con la terminación más habitual en el histórico de sorteos.    

​      Siendo puristas, la probabilidad de que salga un número es independiente de lo que haya ocurrido en años anteriores. Pero es tan tentador ignorar esto que no puedes resistirte. 

La entrada consistirá en un array con varios boletos de lotería y la salida será cuántas veces se repite una terminación (sólo el último dígito).

Por ejemplo, `"00004", "03847", "39804"`

```
{4=2, 7=1}
```

O, `"58975", "25894", "52985", "98598"`

```
{4=1, 5=2, 8=1}
```


> -toogle-Piensa antes de mirar
> ```java
> import java.util.Map;
> import java.util.HashMap;
> 
> public class Sorteo {
> public static void main(String[] args) {
>   System.out.println(calcular("00004", "03847", "39804"));
>  System.out.println(calcular("58975", "25894", "52985", "98598"));
> }
> public static String calcular(String ... boletos){
> 
>   Map<Integer,Integer> terminaciones = new HashMap<Integer,Integer>();
>   int terminacion;
>   Integer actual;
>   for (String boleto : boletos) {
>       terminacion = Integer.parseInt("" + boleto.charAt(boleto.length()-1));
>       actual = terminaciones.get(terminacion);
>       if (actual == null)
>           terminaciones.put(terminacion, 1);
>       else
>           terminaciones.replace(terminacion, ++actual);
>   }
>   
>   return terminaciones.toString();      
> }
> }
> ```

**Fuente**
[https://www.aceptaelreto.com/problem/statement.php?id=387](https://www.aceptaelreto.com/problem/statement.php?id=387)


### Ejercicio `Botín`

Al-Colleja y sus secuaces tienen que repartir el botín de su  último golpe. No es una tarea fácil, porque todos quieren llevarse  lo máximo posible, y todos están armados… 

Para no entrar en discusiones que terminen en tragedia,  Al-Colleja  ha ideado un sencillo método en el que, en lugar de  preocuparse de ser justos repartiendo en base a quién ha trabajado más en la  consecución del golpe, se lo deja prácticamente todo al azar.  Prefiere recibir menos beneficios pero mantener la  banda intacta.

El procedimiento es sencillo. Coge todos los billetes  conseguidos y los pone en un montón tras barajarlos. Después se  coloca toda la banda en círculo y va dando un billete a cada uno,  hasta que quedan todos repartidos. Eso sí, el primero que recibe  billete es él, de esa forma se asegura de que si los billetes se  terminan a mitad de una vuelta, él siempre habrá recibido uno  adicional.

El componente de azar aparece porque los billetes están descolocados, así que puede tocar en el reparto desde el mísero  billete de 10 hasta el deseado de 500...

La entrada constará de 2 partes: la primera es el número e participantes en el golpe y la segunda un array con los billetes a repartir.

Por ejemplo: `2, 10, 20, 50, 200, 500` que producirá como salida 

```
{0=10  50 500, 1=20  200}
```

O `3, 50, 20, 100, 200, 500, 10, 50`

que resultará en

```
{0=50  200 50, 1=20  500, 2=100  10}
```

> -info-La función defínela así.
>
> ```java
>  public static String repartir(int participantes, int ... billetes){
> ```
>
> Y para llamarla, 
>
> ```java
> repartir(2, 10, 20, 50, 200, 500)
> ```
>
> Para imprimir el Map usa `toString`

> -toogle- Piensa antes de mirar
>
> ```java
> import java.util.HashMap;
> import java.util.Map;
> 
> public class Botin {
> 
>     public static void main(String[] args) {
>        System.out.println(repartir(2, 10, 20, 50, 200, 500));
>        System.out.println(repartir(3, 50, 20, 100, 200, 500, 10, 50));
>     }
>     public static String repartir(int participantes, int ... billetes){
> 
>         Map<Integer, String> reparto = new HashMap<Integer, String>();
>         for (int i = 0; i < billetes.length; i++) {
>             String botin = reparto.get(i % participantes);
>             if (botin ==  null){
>                 reparto.put(i % participantes, billetes[i] + " ");
>             }else{
>                 reparto.put(i % participantes, botin + " " + billetes[i]);
>             }
>         }
>         return reparto.toString();
>     }
> }
> ```

**Fuente**

[https://www.aceptaelreto.com/problem/statement.php?id=238](https://www.aceptaelreto.com/problem/statement.php?id=238)


### Ejercicio `Frequency`

Se trata de pedir por pantalla una serie de palabras y calcular la frecuencia de cada una de ellas, es decir, las veces que se repiten. Para finalizar el programa se debe introducir una línea en blanco
Por ejemplo:
```
uno dos dos tres tres tres
```
Daría como resultado:
```
uno - 1
dos - 2
tres - 3
```
> -toogle- Piensa antes de mirar
>
> ```java
> import java.util.*;
> 
> public class Frequency {
>     public static void main(String[] args) {
>         Scanner input = new Scanner(System.in);
>         Map<String, Integer> m = new HashMap<String, Integer>();
>         String s;
>         System.out.println("Write some words:");
>         // Initialize frequency table
>         do{
>             s = input.nextLine();
>             Integer freq = m.get(s);
>             m.put(s, (freq == null) ? 1 : freq + 1);
>         }while(!s.equals(""));
> 
>         System.out.println(m.size() + " distinct words:");
>         System.out.println(m);
>         input.close();
>     }
> }
> ```

### Ejercicio `Anagramas`

Un anagrama es un grupo de palabras que contienen las mismas letras pero en diferente orden:

Por ejemplo: alma, mala

El ejercicio consiste en leer todas las líneas de un [fichero](/programacion-java/resueltos/collections/avanzados/files/spanish-dict.txt). Por cada palabra que encuentra crea una entrada en el mapa con la palabra *alfabetizada* con las letras en orden alfabético como clave. Siguiendo el ejemplo, `aalm`

Y el valor crea un `ArrayList` con todas las palabras con las mismas letras.

Es decir, la clave `aalm` tendrá una lista con dos valores: `alma` y `mala`. 

Después se pide un número  (`minGroupSize`) que es el mínimo número de valores para que salga impreso por pantalla

Para leer un archivo línea a línea, usa el siguiente código:
```java
import java.io.*;
import java.util.*;

public class Anagramas {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("path-to-file"));
        String line;
        while (s.hasNextLine()) {
            line = s.nextLine();
            //trabajamos con  line

        }
        s.close();
    }
}
```

> -toogle- Piensa antes de mirar
>
> ```java
> import java.io.*;
> import java.util.*;
> 
> public class Anagrams {
> 
> 	public static void main(String[] args) throws IOException {
> 		int minGroupSize = 5;
> 
>         // Read words from file and put them 
> 		 // into a simulated multimap
>         Map<String, List<String>> m = new 
> 				HashMap<String, List<String>>();
>         BufferedReader reader = null;
>         try {
>             reader = new BufferedReader(new FileReader("files/spanish-dict.txt"));
>             String word;
>             while ((word=reader.readLine())!=null) {
>                 String alpha = alphabetize(word);
>                 List<String> l = m.get(alpha);
>                 if (l == null)
>                     m.put(alpha, l=new ArrayList<String>());
>                 l.add(word);
>             }
>         } catch (IOException e) {
>             System.err.println(e);
>             System.exit(1);
>         } finally {
>         	reader.close();
>         }
> 
>         // Print all permutation groups above size threshold
>         for (List<String> l : m.values())
>             if (l.size() >= minGroupSize)
>                 System.out.println(l.size() + ": " + l);
>     }
> 
>     private static String alphabetize(String s) {
>         char[] a = s.toCharArray();
>         Arrays.sort(a);
>         return new String(a);
>     }
> 
> }
> ```

### Ejemplo `CountCountries`

En el siguiente ejemplo partimos de un [fichero](/programacion-java/resueltos/collections/avanzados/files/Colfuturo-Seleccionados.csv) `csv` que almacena los datos de los alumnos, incluido el país de origen que se almacena en el campo 7 de dicho archivo.

Se trata de contar cuántos alumnos pertenecen a cada país

> -toogle- Piensa antes de mirar
>
> ```java
> import java.io.*;
> import java.util.*;
> 
> public class CountCountries {
> 
> 	/**
> 	 * @param args
> 	 * @throws IOException 
> 	 */
> 	public static void main(String[] args) throws IOException {
> 		Map<String,Integer> map = new HashMap<String, Integer>();
> 
> 		BufferedReader reader = new BufferedReader(new FileReader("files/Colfuturo-Seleccionados.csv"));
> 		String line;
> 		String[] splittedLine;
> 		
> 		line = reader.readLine();
> 		while ((line = reader.readLine())!=null) {
> 			splittedLine = line.split(",");
> 			//el 7º del csv guarda el país del alumno
> 			Integer freq = map.get(splittedLine[6]);
>             //Aumentamos en uno la frecuencia
> 			map.put(splittedLine[6],freq==null ? 1: freq+1);
> 		}
> 		reader.close();
> 		for (String s: map.keySet()) {
> 			System.out.println(s + " : " + map.get(s));
> 		}
> 	}
> }
> ```

### Ejercicio `LastNameFrequency`.

Tenemos un archivo con la frecuencia de los apellidos en España. Este [fichero](/programacion-java/resueltos/collections/avanzados/files/LastnameFrequencies.csv) es de tipo csv y almacena el Apellido y la frecuencia.

Se trata de realizar un programa que pida por pantalla un apellido y muestre la frecuencia de éste. El programa finalizará cuando el usuario introduzca una línea vacía.

> -toogle-Piensa antes de ver la solución
>
> ```java
> import java.io.BufferedReader;
> import java.io.FileReader;
> import java.io.IOException;
> import java.util.*;
> 
> 
> public class LastNameFrequency {
> 
> 	private static Map<String,Integer> generate() throws IOException {
> 		Map<String,Integer> map = new HashMap<String,Integer>();
> 		BufferedReader reader = null;
> 		
> 		reader = new BufferedReader(new FileReader("files/LastnameFrequencies.csv"));
> 		String line;
> 		String[] elements;
> 		while ((line = reader.readLine())!=null) {
> 			elements = line.split(",");
> 			if (elements.length==2) {
> 				map.put(elements[0], 
> 						Integer.parseInt(elements[1].replaceAll("\\.", "")));
> 			}
> 		}
> 		reader.close();
> 		
> 		return map;
> 	}
> 	public static void main(String[] args) throws IOException  {
> 		
> 		Map<String,Integer> map  = generate();
> 		// Read lastnames from keyboard
> 		String lastname;
> 		Scanner input = new Scanner(System.in);
> 		do {
> 			System.out.print("Enter lastname: ");
> 			lastname = input.nextLine().toUpperCase();
> 			if (!lastname.equals("")) {
> 				if (map.get(lastname) == null) {
> 					System.out.println("last name does not exist");
> 				} else {
> 					System.out.println("frequency = " + map.get(lastname));
> 				}
> 			}
> 			
> 		} while (!lastname.equals(""));
> 		
> 		input.close();
> 
> 	}
> 
> }
> ```

## HashSet

Es una colección desordenada de objetos en la que no pueden existir duplicados.

```java
// Java program Illustrating Set Interface

// Importing utility classes
import java.util.*;

// Main class
public class HashSet1 {

	// Main driver method
	public static void main(String[] args)
	{
		// Demonstrating Set using HashSet
		// Declaring object of type String
		Set<String> hash_Set = new HashSet<String>();
	
		// Adding elements to the Set
		// using add() method
		hash_Set.add("Geeks");
		hash_Set.add("For");
		hash_Set.add("Geeks");
		hash_Set.add("Example");
		hash_Set.add("Set");
	
		// Printing elements of HashSet object
		System.out.println(hash_Set);
	}
}

```

**Salida**

```
[Set, Example, Geeks, For]
```

Ejemplo de unión, intersección y diferencia de HashSet

```java
// Java Program Demonstrating Operations on the Set
// such as Union, Intersection and Difference operations

// Importing all utility classes
import java.util.*;

// Main class
public class SetExample {

	// Main driver method
	public static void main(String args[])
	{
		// Creating an object of Set class
		// Declaring object of Integer type
		Set<Integer> a = new HashSet<Integer>();
	
		// Adding all elements to List
		a.addAll(Arrays.asList(
			new Integer[] { 1, 3, 2, 4, 8, 9, 0 }));
	
	// Again declaring object of Set class
	// with reference to HashSet
		Set<Integer> b = new HashSet<Integer>();
		
	b.addAll(Arrays.asList(
			new Integer[] { 1, 3, 7, 5, 4, 0, 7, 5 }));


​		
		// To find union
		Set<Integer> union = new HashSet<Integer>(a);
		union.addAll(b);
		System.out.print("Union of the two Set");
		System.out.println(union);
	
		// To find intersection
		Set<Integer> intersection = new HashSet<Integer>(a);
		intersection.retainAll(b);
		System.out.print("Intersection of the two Set");
		System.out.println(intersection);
	
		// To find the symmetric difference
		Set<Integer> difference = new HashSet<Integer>(a);
		difference.removeAll(b);
		System.out.print("Difference of the two Set");
		System.out.println(difference);
	}
}
```

**Salida**

```
Union of the two Set[0, 1, 2, 3, 4, 5, 7, 8, 9]
Intersection of the two Set[0, 1, 3, 4]
Difference of the two Set[2, 8, 9]
```



### Ejemplo devolver entradas únicas

Se trata de encontrar los valores únicos de un array
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Unicos {
    public static void printUnique( String ... array) {
		List<String> list = Arrays.asList(array);
		Set<String> hashSet = new HashSet<String>(list);
		System.out.println(hashSet);
	}

	public static void main(String[] args) {
	
		printUnique("hola", "adios", "hola", "hola", "tres", "cuatro", "adios");
		
	}
}
```



### Ejemplo encontrar duplicados

Se trata de generar un `HashSet` con los elementos duplicados en un array:

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExample {
	public static void printDuplicates( String ... array) {
		List<String> list = Arrays.asList(array);
		Set<String> hashSet = new HashSet<String>(list);
		
		for (String s: hashSet) {
			list.remove(s);
		}
		Set<String> duplicates = new HashSet<String>(list);
		System.out.println(duplicates);
	}
	
	public static void main(String[] args) {
			printDuplicates("hola", "adios", "hola", "hola", "tres", "cuatro", "adios");
		
	}
}
```

### Ejemplo incrementar valores

Se trata de devolver un `Set` de `Integers` incrementando el valor de cada uno de los valores de otro pasado como parámetro.

```java
import java.util.HashSet;

public class Increment {
    public static HashSet<Integer> increment( HashSet<Integer> set) {
		HashSet<Integer> newSet = new HashSet<Integer>();
	    for (Integer i: set)
	         newSet.add(i+1);
	    return newSet;
	}

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<Integer>(); 
		set.add(1);
		set.add(4);
		set.add(6);
		set.add(8);
		set.add(2);
		System.out.println(set);
		set = increment(set);
	    System.out.println(set);
		
	}    
}
```

## Pilas

El marco de Java Collection proporciona una clase `Stack` que modela e implementa una estructura de datos de tipo pila. La clase se basa en el principio básico de último en entrar, primero en salir. 

<img src="/programacion-java/assets/img/estructuras/stack.png" style="zoom:67%;" />

Stack es una estructura de datos lineal que sigue un orden particular en el que se realizan las operaciones. El orden puede ser LIFO (Last In First Out) o FILO (First In Last Out).

El siguiente diagrama muestra la jerarquía de la clase Stack:

<img src="/programacion-java/assets/img/estructuras/Selection_028.png" style="zoom: 67%;" />

```java
// Java code for stack implementation

import java.io.*;
import java.util.*;

class Test
{
	// Pushing element on the top of the stack
	static void stack_push(Stack<Integer> stack)
	{
		for(int i = 0; i < 5; i++)
		{
			stack.push(i);
		}
	}
	
	// Popping element from the top of the stack
	static void stack_pop(Stack<Integer> stack)
	{
		System.out.println("Pop Operation:");
	
		for(int i = 0; i < 5; i++)
		{
			Integer y = (Integer) stack.pop();
			System.out.println(y);
		}
	}
	
	// Displaying element on the top of the stack
	static void stack_peek(Stack<Integer> stack)
	{
		Integer element = (Integer) stack.peek();
		System.out.println("Element on stack top: " + element);
	}
	
	// Searching element in the stack
	static void stack_search(Stack<Integer> stack, int element)
	{
		Integer pos = (Integer) stack.search(element);
	
		if(pos == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element is found at position: " + pos);
	}


	public static void main (String[] args)
	{
		Stack<Integer> stack = new Stack<Integer>();
	
		stack_push(stack);
		stack_pop(stack);
		stack_push(stack);
		stack_peek(stack);
		stack_search(stack, 2);
		stack_search(stack, 6);
	}
}
```

**Salida**

```
Pop Operation:
4
3
2
1
0
Element on stack top: 4
Element is found at position: 3
Element not found
```

**Añadir elementos**

```java
// Java program to add the
// elements in the stack
import java.io.*;
import java.util.*;

class StackDemo {
	
	// Main Method
	public static void main(String[] args)
	{
	
		// Default initialization of Stack
		Stack stack1 = new Stack();
	
		// Initialization of Stack
		// using Generics
		Stack<String> stack2 = new Stack<String>();
	
		// pushing the elements
		stack1.push(4);
		stack1.push("All");
		stack1.push("Geeks");
	
		stack2.push("Geeks");
		stack2.push("For");
		stack2.push("Geeks");
	
		// Printing the Stack Elements
		System.out.println(stack1);
		System.out.println(stack2);
	}
}
```

```
[4, All, Geeks]
[Geeks, For, Geeks]
```

**Acceder a un elemento**

```java
// Java program to demonstrate the accessing
// of the elements from the stack
import java.util.*;
import java.io.*;

public class StackDemo {

	// Main Method
	public static void main(String args[])
	{
		// Creating an empty Stack
		Stack<String> stack = new Stack<String>();
	
		// Use push() to add elements into the Stack
		stack.push("Welcome");
		stack.push("To");
		stack.push("Geeks");
		stack.push("For");
		stack.push("Geeks");
	
		// Displaying the Stack
		System.out.println("Initial Stack: " + stack);
	
		// Fetching the element at the head of the Stack
		System.out.println("The element at the top of the"
						+ " stack is: " + stack.peek());
	
		// Displaying the Stack after the Operation
		System.out.println("Final Stack: " + stack);
	}
}
```

**Salida**

```
Initial Stack: [Welcome, To, Geeks, For, Geeks]
The element at the top of the stack is: Geeks
Final Stack: [Welcome, To, Geeks, For, Geeks]
```

**Eliminar elementos**

```java
// Java program to demonstrate the removing
// of the elements from the stack
import java.util.*;
import java.io.*;

public class StackDemo {
	public static void main(String args[])
	{
		// Creating an empty Stack
		Stack<Integer> stack = new Stack<Integer>();

		// Use add() method to add elements
		stack.push(10);
		stack.push(15);
		stack.push(30);
		stack.push(20);
		stack.push(5);
	
		// Displaying the Stack
		System.out.println("Initial Stack: " + stack);
	
		// Removing elements using pop() method
		System.out.println("Popped element: "
						+ stack.pop());
		System.out.println("Popped element: "
						+ stack.pop());
	
		// Displaying the Stack after pop operation
		System.out.println("Stack after pop operation "
						+ stack);
	}
}
```

```
Initial Stack: [10, 15, 30, 20, 5]
Popped element: 5
Popped element: 20
Stack after pop operation [10, 15, 30]
```

### Ejercicios

Realiza los siguientes ejercicios:

* [Paréntesis](https://victorponz.github.io/programacion-java/ejercicios-ampliacion#14-par%C3%A9ntesis). 

  > -toogle-Pista
  >
  > * Cuando encuentres un símbolo de apertura, añádelo a la pila
  > * Cuando sea de cierre, saca uno de la pila y comprueba si es el correspondiente. En caso contrario está mal

* [Expresiones aritméticas](https://victorponz.github.io/programacion-java/ejercicios-ampliacion#16-expresiones-aritm%C3%A9ticas)

  > -toogle-Pista
  >
  > * ve apilando los operandos
  > * Cuando encuentres un operador, saca dos operandos y aplícale el operador

* [Trim](https://www.aceptaelreto.com/problem/statement.php?id=449)
* [Las crecidas del Nilo](https://www.aceptaelreto.com/problem/statement.php?id=662&cat=154)
-----
Adaptado del siguiente material

* [https://www.geeksforgeeks.org/stack-class-in-java/](https://www.geeksforgeeks.org/stack-class-in-java/)
* [https://www.hackerrank.com/domains/java?filters%5Bsubdomains%5D%5B%5D=java-data-structure](https://www.hackerrank.com/domains/java?filters%5Bsubdomains%5D%5B%5D=java-data-structure)


