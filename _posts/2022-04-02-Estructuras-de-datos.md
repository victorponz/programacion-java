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
System.out.prinft("Existen %d coches%n", coches.size());
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
		List<String> list = new ArrayList<String>(Arrays.asList(array));
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
		List<String> list = new ArrayList<String>(Arrays.asList(array));
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

**Más información en** [https://www.geeksforgeeks.org/stack-class-in-java/](https://www.geeksforgeeks.org/stack-class-in-java/)



https://javahungry.blogspot.com/2019/02/collection-programs-in-java-for-interview.html

https://github.com/atanu20/javacollection/blob/master/ArrayListCode.java

https://gyansetu-core-java-for-java.gitbook.io/project/untitled-1/working-with-the-collection-interface

**Streams**

https://gyansetu-core-java-for-java.gitbook.io/project/java-8/2-streams
