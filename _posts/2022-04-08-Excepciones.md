---
typora-copy-images-to: ./programacion-java/assets/img/excepciones/
typora-root-url: ../../
layout: post
title: Excepciones
categories: varios
conToc: true
permalink: excepciones
---

## Introducción 

Una excepción es un problema que surge durante la ejecución de un programa. Una excepción puede ocurrir por muchas razones diferentes, incluyendo las siguientes:

* Un usuario ha introducido datos no válidos.
* No se puede encontrar un archivo que deba abrirse.
* Se ha perdido una conexión de red en el medio de las comunicaciones o la JVM se ha quedado sin memoria.

Algunas de estas excepciones son causadas por un error del usuario, otras por un error del programador y otras por recursos físicos que han fallado de alguna manera.

En Java, una excepción es un objeto (subclase de `Exception` o `Error`) que envuelve un evento de error que ocurrió dentro de un método y contiene:

* Información sobre el error incluyendo su tipo.
* El estado del programa cuando ocurrió el error.
* Opcionalmente, otra información personalizada.

Decimos que el método lanza (**Throws**) una excepción.

Decimos que un método puede capturar una excepción (**Catch**) si se ha previsto esa excepción y hay un conjunto de operaciones listas para tratar con él para "recuperar" el programa de esa condición de error.

Después de que un método lanza una excepción, el sistema de tiempo de ejecución intenta encontrar algo para manejarlo. El conjunto de posibles "cosas" para manejar la excepción es la lista ordenada de métodos que se habían llamado para llegar al método donde ocurrió el error. La lista de métodos se conoce como la pila de llamadas.

![1556793943706](/programacion-java/assets/img/excepciones/1556793943706.png)

El sistema de tiempo de ejecución busca en la pila de llamadas un método que contenga un bloque de código que pueda manejar la excepción. Este bloque de código se llama un **controlador de excepciones**.

La búsqueda comienza con el método en el que se produjo el error y continúa a través de la pila de llamadas en el orden inverso en que se llamaron los métodos. Cuando se encuentra un controlador adecuado, el sistema de ejecución pasa la excepción al controlador. Un controlador de excepciones se considera apropiado si el tipo del objeto de excepción arrojado coincide con el tipo que puede manejar el controlador.

![1556794041898](/programacion-java/assets/img/excepciones//1556794041898.png)

Se dice que el controlador de excepciones elegido captura la excepción. Si el sistema de tiempo de ejecución busca exhaustivamente todos los métodos en la pila de llamadas sin encontrar un controlador de excepción adecuado, como se muestra en la siguiente figura, el sistema de tiempo de ejecución (y, en consecuencia, el programa) termina.

```java
public class Test {
	public static void main(String[] args) {
		method();
	}
	public static void method() {
		int x = 12/0;
	}
}
```

La salida es:

![1556794116093](/programacion-java/assets/img/excepciones/1556794116093.png)



Lo que sucedió es que la JVM ha detectado una condición de error y se ha generado y lanzado un objeto de la clase `java.lang.ArithmeticException`. Como el método en el que se ha generado la Excepción no puede lidiar con ella (catch), y el método que la llamó (main) tampoco puede lidiar con ella, entonces la JVM muestra un error y cancela el programa.

### Lanzar una excepción

Un método puede lanzar una excepción usando la instrucción **throw**.
Por ejemplo, este programa genera una condición de error si el dividendo es más pequeño que el divisor:

```java
public class ThrowMyException {
	public static void main(String[] args) {
		divide(1,2);
	}
	public static void divide(int i, int j) {
		if (i<j)
			throw new ArithmeticException();
		else
			System.out.println(i/j);
	}
}
```

### Capturar una excepción

Un controlador de excepciones consiste en un conjunto de acciones que tienen lugar cuando se lanza una excepción. La estructura mínima es un bloque de prueba y un bloque de captura con estos elementos:

```
try {
	Bloque de instrucciones try
} catch(TypeOfException variableException) {
	Bloque de instrucciones catch
}
```

El bloque de instrucciones en el bloque `try` se analiza y, cuando se genera una excepción (se genera una subclase de objeto de `Exception` o `Error`), si el tipo de `TypeOfExcetion` es la clase o una superclase de la generada, el bloque de instrucciones `catch` será ejecutado.

```java
package excepciones;
public class TestCatch {
	public static void main(String[] argv) {
		method();
		System.out.println("Pero el programa continúa.");
	}
	public static void method() {
		try {
			int x = 12/0;
		} catch (ArithmeticException ex) {
			System.out.println("Has intentando dividir entre 0.");
		}
	}
}
```

Y la salida del programa es:

```
Has intentando dividir entre 0.
Pero el programa continúa.
```

## Jerarquía de excepciones

![1556794808200](/programacion-java/assets/img/excepciones/1556794808200.png)



Todas las clases de excepción son subtipos de la clase `java.lang.Exception`. La clase de `Exception` es una subclase de la clase `Throwable`. Aparte de la clase de `Exception`, hay otra subclase llamada `Error` que se deriva de la clase `Throwable`.

Los errores normalmente no son atrapados por los programas de Java. Estas condiciones normalmente ocurren en caso de fallos graves, que no son manejadas por los programas java. Los errores se generan para indicar errores generados por el entorno de ejecución. Ejemplo: JVM está fuera de memoria. Normalmente los programas no pueden recuperarse de errores.

La clase `Exception` tiene dos subclases principales: `IOException` y `RuntimeException`.

![1556794984488](/programacion-java/assets/img/excepciones/1556794984488.png)

## Tres clases de excepciones

### Excepciones comprobadas 

El primer tipo de excepción es la excepción comprobada (**checked exception**). Estas son condiciones excepcionales que una aplicación bien escrita debe anticipar y recuperar. Por ejemplo, supongamos que una aplicación le pide a un usuario un nombre de archivo de entrada, luego abre el archivo al pasar el nombre al constructor para `java.io.FileReader`. Normalmente, el usuario proporciona el nombre de un archivo legible existente, por lo que la construcción del objeto `FileReader` se realiza correctamente y la ejecución de la aplicación se realiza normalmente. Pero a veces el usuario proporciona el nombre de un archivo inexistente, y el constructor lanza la excepción `java.io.FileNotFoundException`. Un programa bien escrito detectará esta excepción y notificará al usuario el error, posiblemente solicitando un nombre de archivo corregido.

Las excepciones comprobadas están sujetas al "Requisito de captura o especificación".

```java
import java.io.File;
import java.util.Scanner;
public class TestCatch3 {
	public static void main(String[] argv) {
		method("miFile.txt");
	}	
	public static void method(String s){
		Scanner in;
		File f = new File(s);
		in = new Scanner(f);
	}
}
```

El programa no compila. Si lo ejecutas, lanza la siguiente excepción:

```
Unhandled exception type FileNotFoundException
```

Significa que la línea `in = new Scanner(f);` puede generar una excepción que debe estar sujeta a los "Requisitos de captura o especificación".
`FileNotFoundException` es una excepción comprobada. El compilador se queja si no son tratadas.

### Excepciones no comprobadas

Los errores y las excepciones de tiempo de ejecución se conocen colectivamente como excepciones no comprobadas.

#### Errores

El segundo tipo de excepción es el error. Estas son condiciones excepcionales que son externas a la aplicación y de las cuales la aplicación generalmente no puede anticipar o recuperar. Por ejemplo, supongamos que una aplicación abre con éxito un archivo para la entrada, pero no puede leer el archivo debido a un mal funcionamiento del hardware o del sistema. La lectura incorrecta arrojará `java.io.IOError`. Una aplicación puede elegir capturar esta excepción para notificar al usuario del problema, pero también podría tener sentido que el programa imprima un seguimiento de la pila y salga.

Los errores no están sujetos a los requisitos de captura o especificación. Los errores son aquellas excepciones indicadas por la clase Error y sus subclases.

#### Excepciones en tiempo de ejecución

Una excepción de tiempo de ejecución (runtime exception) es una excepción que se produce y que probablemente el programador podría haber evitado. A diferencia de las excepciones comprobadas, las excepciones de tiempo de ejecución se ignoran en el momento de la compilación. Por ejemplo, considere la aplicación descrita anteriormente donde se produce una división por 0. La aplicación puede detectar esta excepción, pero probablemente tenga más sentido eliminar el error que causó la excepción.

Las excepciones de tiempo de ejecución no están sujetas al requisito de captura o especificación. Las excepciones de tiempo de ejecución son aquellas indicadas por `RuntimeException` y sus subclases.

### Requisito de captura o especificación

El código de lenguaje de programación Java válido debe cumplir con el requisito de captura o especificación.
Esto significa que el código que puede lanzar **excepciones comprobadas** debe estar incluido por uno de los siguientes:

* Una declaración **try** que atrapa la excepción. El intento debe proporcionar un controlador para la excepción.
* Un método que especifica que puede lanzar la excepción. El método debe proporcionar una cláusula **throws** que enumere la excepción.

El código que **no cumple** con el requisito de captura o especificación **no se compilará**.

No todas las excepciones están sujetas al requisito de captura o especificación. Solo las excepciones comprobadas están sujetas al requisito de captura o especificación.

En el ejemplo anterior, como la excepción que puede lanzar la instrucción `in = new Scanner(f);` es una excepción comprobada, nos vemos obligados a crear un bloque **try-catch** o a declarar el lanzamiento de la cláusula del método. Si sabemos cómo tratar el error podemos crear bloque try-catch.
Ejemplo:

```java
package excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestCatch4 {
	public static void main(String[] argv) {
		method("miFile.txt");
	}

	public static void method(String s) {
		Scanner in;
		File f = new File(s);
		try {
			in = new Scanner(f);
		} catch (FileNotFoundException fe) {
			System.out.println("File not found.");
		}
	}
}
```

Si el método no sabe cómo manejar el error, puede declarar que puede lanzar ese tipo de excepción y delegar el try-catch a otro método de la pila de métodos llamados.
Si hacemos esto:

```java
package excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestCatch5 {
	public static void main(String[] argv) {
		method("miFile.txt");
	}

	public static void method(String s) throws FileNotFoundException {
		Scanner in;
		File f = new File(s);
		in = new Scanner(f);
	}
}
```

Pero ahora el compilador genera un error que indica que la línea `method("miFile.txt");` puede generar una excepción `FileNotFoundException` y debe tratar con ella.

Así que debemos crear el bloque `try-catch` o declarar que `main` puede lanzar la excepción `FileNotFoundException`. Podríamos hacer esto:

```java
package excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestCatch5 {
	public static void main(String[] argv) throws FileNotFoundException {
		method("miFile.txt");
	}

	public static void method(String s) throws FileNotFoundException {
		Scanner in;
		File f = new File(s);
		in = new Scanner(f);
	}
}
```

Aunque tiene más sentido tratar el error:

```java
package excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestCatch7 {
	public static void main(String[] argv) {
		Scanner s = new Scanner(System.in);
		boolean error = true;
		System.out.println("Enter file name:");
		do {
			try {
				method(s.next());
				error = false;
			} catch (FileNotFoundException fe) {
				System.out.println("File not found. Try again");
			}
		} while (error);
		System.out.println("OK");
	}

	public static void method(String s) throws FileNotFoundException {
		Scanner in;
		File f = new File(s);
		in = new Scanner(f);
	}
}
```

## La estructura try-catch-finally

Ya hemos visto cómo funcionan los bloques **try-catch**. Esta estructura puede ser un poco más compleja con más de un bloque **catch**.

```java
try {
	...
} catch (ExceptionType name) {
	...
} catch (ExceptionType name) {
	...
} finally {
	...
}
```

Puede haber tantos bloques catch como sea necesario en la estructura. Cada bloque catch es un controlador de excepciones y maneja el tipo de excepción indicado por su argumento. El tipo de argumento, `ExceptionType`, declara el tipo de excepción que el manejador puede manejar y debe ser el nombre de una clase que hereda de la clase `Throwable`. El manejador puede referirse a la excepción con la variable **name**.

El bloque catch contiene código que se ejecuta cuando se invoca el controlador de excepciones. El sistema de tiempo de ejecución invoca el controlador de excepciones cuando el controlador es el primero en la pila de llamadas cuyo tipo de excepción coincide con el tipo de excepción lanzada.

El sistema lo considera una coincidencia si el objeto arrojado puede asignarse legalmente al argumento del controlador de excepciones.

Si la excepción no es atrapada por el primer bloque de captura, se envía al segundo bloque de captura y continúa pasando de un bloque de captura al siguiente hasta que es atrapado por uno de ellos o llega al final de la estructura.

El bloque `finally` es un conjunto de instrucciones que se ejecutarán independientemente del controlador de excepciones que haya tratado la excepción. Incluso si la excepción no fue detectada por ninguno de los controladores de excepción. Es útil para no tener que repetir el código en cada bloque catch.

Por ejemplo, lo usamos para cerrar un recurso, como por ejemplo un archivo abierto:

```java
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo10 {
	public static void main(String[] args) throws IOException {
		FileWriter f_out = null;
		String text = "Contenido para el fichero, sin miedo a los caracteres raros:á ç ñ";
		try {
			f_out = new FileWriter("./archivos/f6.txt");
			for (int i = 0; i < text.length(); i++) {
				f_out.write(text.charAt(i));
			}
		} catch (IOException ioe) {
			System.out.println("No se ha podido abrir el fichero");
		} finally {
			if (f_out != null) {
				f_out.close();
			}
		}
	}
}
```

En este ejemplo, cerramos el fichero tanto si se produce un excepción como si no se produce

## Capturar más de un tipo de excepción con sólo un manejador

En Java SE 7 y versiones posteriores, un solo bloque catch puede manejar más de un tipo de excepción.
Esta característica puede reducir la duplicación de código y disminuir la tentación de atrapar una excepción demasiado amplia.
En la cláusula catch, especifica los tipos de excepciones que el bloque puede manejar y separa cada tipo de excepción con una barra vertical (|):

```java
catch (IOException|SQLException ex) {
    System.out.println(ex.getMessage());
}
```

## Especificar las excepciones que lanza un método

Considera el siguiente programa (no compila):

```java
package excepciones;

import java.io.FileWriter;
import java.io.PrintWriter;

public class TestThrow {
	static String[] list = { "One", "Two", "Three" };

	public static void main(String[] args) {
		printList(2);
	}

	public static void printList(int size) {
		PrintWriter out = new PrintWriter(new FileWriter("File.txt"));
		for (int i = 0; i < size; i++) {
			out.println("Value " + i + " = " + list[i]);
		}
	}
}
```

El compilador da el siguiente error:

**![1556797142255](/programacion-java/assets/img/excepciones/1556797142255.png)**

Para especificar que `printList` puede generar dos excepciones, agrega una cláusula de lanzamientos a la declaración del método para el método `printList`. La cláusula **throws** comprende la palabra clave **throws** seguida de una lista separada por comas de todas las excepciones lanzadas por ese método. La cláusula va después del nombre del método y la lista de argumentos y antes de la llave que define el alcance del método; Aquí hay un ejemplo.

```java
public void printList() throws IOException, ArrayIndexOutOfBoundsException {
```

Recuerda que `ArrayIndexOutOfBoundsException` es una excepción no comprobada, por lo que incluirla en la cláusula throws no es obligatorio. Simplemente puedes escribir lo siguiente:

```java
public void printList() throws IOException {
```

## Métodos de la clase Throwable

* `public String getMessage()` Devuelve un mensaje detallado sobre la excepción que ha ocurrido. Este mensaje se inicializa en el constructor `Throwable`.
* `public Throwable getCause()`  Devuelve la causa de la excepción representada por un objeto `Throwable`.
* `public String toString()` Devuelve el nombre de la clase concatenado con el resultado de `getMessage()`
* `public void printStackTrace()` Imprime el resultado de `toString()` junto con el seguimiento de la pila en `System.err`, el stream de salida de error.

## Crear una excepción propia.

Para crear una excepción propia basta extender la clase `Exception` o la excepción más adecuada, y en el constructor de la clase llamar a la clase padre con el mensaje que se desee mostrar cuando se produzca la excepción.

Para lanzar una excepción explícitamente, utilizamos la palabra reservada **throw** e indicamos en la declaración del método que puede lanzar la excepción deseada. En el siguiente código se muestra un ejemplo.

```java
public class MiExcepcion extends Exception {
    public MiExcepcion() {
        super("Texto de la excepcion");
    }
}
 
public class LanzaExcepcion {
    public void metodo(int a, int b) throws MiExcepcion {
        //...
        if(a < b) throw new MiExcepcion();
        //...
    }
}
 
public class OtraClase {
	public static void main(String[] argv) {
        LanzaExcepcion le = new LanzaExcepcion();
        try {
            le.metodo(3, 4);
        } catch (MiExcepcion e) {
            System.err.println(e.getMessage());
        }
    }
}
```

