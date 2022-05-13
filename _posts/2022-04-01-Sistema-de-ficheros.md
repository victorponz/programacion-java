---
typora-copy-images-to: ../assets/img/ficheros/
typora-root-url: ../../
layout: post
title: Ficheros
categories: ficheros
conToc: true
permalink: ficheros
---


# Gestión del sistema de ficheros

El objetivo de este  tema es sencillamente llegar a los archivos, pero no a su contenido, que se verá en el próximo tema.

Sólo llegaremos a "ver" el archivo, con su ruta. De hecho la manera de llegar a un directorio y un archivo será idéntica. Y del archivo o directorio podremos llegar a ver y también modificar las características externas: nombre, tamaño, fecha de última modificación, permisos, ...

## Introducción

Un fichero o archivo es un conjunto de bits almacenados en un dispositivo (como podría ser por ejemplo un disco duro). Los ficheros nos garantizan la persistencia, ya que aunque apaguemos el ordenador podremos recuperar la información, lo que no ocurriría con la información guardada en memoria RAM.

Un archivo tendrá un nombre que lo identifica. Este nombre puede tener opcionalmente una extensión, generalmente de 3 caracteres que tradicionalmente ha servido para identificar el tipo de archivo. El nombre y la extensión van separados por un punto.

En los sistemas informáticos actuales, en los que un único ordenador puede llegar a tener guardados millones de ficheros, resulta imprescindible un sistema que permita una gestión eficaz de localización, de manera que los usuarios podamos movernos cómodamente entre tantos archivos. La mayor parte de sistemas de ficheros han incorporado contenedores jerarquizados que actúan a modo de directorios facilitando la clasificación, la identificación y localización de los archivos. Los directorios se han acabado popularizando bajo la versión gráfica de carpetas. Dentro de un mismo directorio, el nombre del archivo (o subdirectorio) debe ser único.

Debemos tener en cuenta, que además de los archivos guardados en el dispositivo del ordenador (el disco duro, u otro dispositivo), la necesidad desmedida de espacio de almacenamiento ha llevado los Sistemas Operativos a trabajar con una gran cantidad de dispositivos y permitir el acceso remoto a otros sistemas de archivos, distribuidos por la red.

* Para poder gestionar tanta variedad de sistemas de ficheros, algunos sistemas operativos como Linux o Unix utilizan la estrategia de unificar todos los sistemas en un único sistema de archivos, para conseguir una forma de acceso unificada y con una única jerarquía que facilite la referencia a cualquiera de sus componentes, con independencia del dispositivo en el que se encuentran realmente ubicados. En Linux, cualquiera que sea el dispositivo o el sistema remoto real donde se guardará el archivo, la ruta tendrá siempre la misma forma. Obsérvese que para recorrer la ruta jerárquica donde se encuentra el archivo se utiliza la barra de dividir:

  ```bash
   /dir_1/dir_2/dir_3/.../dir_n/fitxer.txt
  ```

* Por el contrario, la estrategia de otros Sistemas Operativos como Windows pasa por mantener bien diferenciados cada uno de los sistemas y dispositivos donde se tenga acceso. Para distinguir el sistema al que se quiere hacer referencia, Windows utiliza una denominación específica del dispositivo o servidor, que incorpora a la ruta del archivo o directorio a referenciar. Aunque Microsoft ha apostado claramente por la convención UNC (Uniform Naming Convention), la evolución de este sistema operativo, que tiene como origen el MS-DOS, ha hecho que coexistesca con otra convención también muy extendida, la que utiliza una letra del alfabeto seguida de dos puntos para identificar el dispositivo donde se encuentra el archivo. A continuación ilustramos con un ejemplo las dos convenciones. Obsérvese como en ambos casos se utiliza la contra-barra:

  ```bash
  F:\dir_1\dir_2\dir_3\...\dir_n\fitxer.txt

  \\Servidor_1\dir_1\dir_2\dir_3\...\dir_n\fitxer.txt
  ```

  

## La clase File. Generalidades

En Java, para gestionar el sistema de archivos se utiliza básicamente la clase `File`. Es una clase que debe entenderse como una referencia a la ruta o localización de archivos del sistema. NO representa el contenido de ningún fichero, sino la ruta del sistema donde se localiza el archivo. Como se trata de una ruta, la clase puede representar tanto archivos como carpetas o directorios.

Si usamos una clase para representar rutas, se consigue una total independencia respecto de la notación que utiliza cada sistema operativo para describirlas. Recordemos que Java es un lenguaje multiplataforma y, por tanto, perfectamente puede darse el caso de que tengamos que hacer una aplicación desconociendo el Sistema Operativo donde acabará ejecutándose.

La estrategia utilizada para cada SO no afecta la funcionalidad de la clase `File`, ya que ésta, en colaboración con la máquina virtual, adaptará las solicitudes al SO anfitrión de forma transparente al programador, es decir, sin necesidad de que el programador deba indicarse o configurar nada.

Los objetos creados de la clase `File` se encuentran estrechamente vinculados a la ruta con la que se han creado. Esto significa que las instancias de la clase `File` durante todo su ciclo de vida sólo representarán una única ruta, la que se les asoció en el momento de la creación. La clase `File` no dispone de ningún método ni mecanismo para modificar la ruta asociada. En caso de necesitar nuevas rutas, habrá siempre crear un nuevo objeto y no será posible reutilizar los ya creados vinculándolos a rutas diferentes.

Para crear un objeto `File` se puede utilizar cualquiera de los 3 **constructores** siguientes:

* `File(String directorio_y_fichero)`: indicamos en un único parámetro tanto el directorio como el archivo, es decir, el archivo con su ruta. Recuerde que en sistemas Linux para la ruta utilizamos la barra de dividir, mientras que en Windows la contra-barra. Como este carácter es el de escape, deberá ponerse dos veces:

  ```java
  File fichero1 = new File ( "/home/usuario/admin/T1/ejemplo1.txt");
  File fichero2 = new File ( "C:\T1\ejemplo1.txt");
  ```

  Para hacer referencia a un directorio utiliza la misma técnica:

  ```java
  File dir = new File ( "/home/usuario/admin/T1");
  ```

  En los ejemplos anteriores hemos puesto una ruta absoluta, que empieza desde la raíz. Si no la ponemos absoluta (si no comienza por /) será relativa y comenzará en el directorio activo.

  ```java
  File dir = new File ( "AD/T1");
  ```


* `File(String directorio, String archivo)`: en el primer parámetro (String) indicamos el directorio con ruta, y en el segundo el archivo (sin ruta). Hará referencia a un archivo con el nombre como el segundo parámetro colocado en el directorio referenciado en el primer parámetro. Observe como el segundo parámetro podría ser también un directorio, y por lo tanto sería una referencia a un subdirectorio del directorio referenciado en el primer parámetro.

  ```java
  File fichero2 = new File ( "/home/usuario/admin/T1", "exemple2.txt");
  ```

* `File(File directorio, String archivo)`: Ahora el directorio dir es un objeto `File` creado anteriormente

  ```java
  File fitxer_3 = new File (dir, "exemple3.txt");
  ```

En los ejemplos anteriores hemos puesto directamente las rutas. Pero los programadores de Java tienen que hacer un esfuerzo para independizar las aplicaciones implementadas de las plataformas donde se ejecutarán. Por lo tanto, tendremos que ir con cuidado, usando técnicas que evitan escribir las rutas directamente en el código. Por eso aunque ahora al principio utilizaremos los 3 constructores, en el futuro deberíamos utilizar masivamente el tercero, ya que como veis la manera de especificar la ruta de localización del fichero, es por medio de otro File. 

La clase File encapsula prácticamente toda la funcionalidad necesaria para gestionar un sistema de archivos organizado en árbol de directorios. Es una gestión completa que incluye:

* Funciones de manipulación y consulta de la propia estructura jerárquica (creación, eliminación, obtención de la ubicación, etc. de archivos o directorios)
* Funciones de manipulación y consulta de las características particulares de los elementos (nombres, tamaño o capacidad, etc.)
* Funciones de manipulación y consulta de atributos específicos de cada Sistema Operativo, como por ejemplo los permisos de escritura, de ejecución, atributos de ocultación. Sólo funcionará si el sistema operativo anfitrión soporta también la funcionalidad de estos atributos.

No nos permite, sin embargo, acceder al contenido de los archivos. Esto se resolverá en el siguiente tema.

### Ejemplo 1

Miremos un ejemplo. Vamos a hacer un programa para sacar la lista de archivos y directorios del directorio actual. Para hacer referencia al directorio actual, utilizaremos ".", que nos sirve para todos los Sistemas. Por defecto, el directorio activo es el directorio del proyecto. Para obtener la lista de elementos (archivos y directorios) utilizaremos el método `list()` de la clase `File`. Veremos este método, junto con los métodos más importantes en la siguiente pregunta.

```java
package Ejemplos;
import java.io.File;
public class Ejemplo1 {
	public static void main(String[] args) {
      	//Abre el directorio actual '.'
		File f = new File(".");
		System.out.println("Lista de ficheros y directorios del directorio actual");
		System.out.println("---------------------------------------------------");
  		//recorre la lista de ficheros (recordad que un directorio es un tipo especial de fichero)
		for (String e : f.list()){
			System.out.println(e);
		}
	}
}
```

Y este sería el resultado:

![1524652711027](/programacion-java/assets/img/ficheros/1524652711027.png)

### Ejemplo 2

Si quisiéramos sacar el contenido de un directorio concreto, lo pondríamos en el momento de definir el `File()`, en lugar de indicar el directorio actual. Otra modificación sería pedir por teclado el directorio del cual queremos mostrar el contenido:

```java
package Ejemplos;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo2 {
	public static void main(String[] args) throws IOException {
		System.out.println("Introduce un directorio:");
		String ent = new BufferedReader(new InputStreamReader(System.in)).readLine();
		File f = new File(ent);
		System.out.println("Lista de ficheros y directorios del directorio: " + ent);
		System.out.println("---------------------------------------------------");
		for (String e : f.list()) {
			System.out.println(e);
		}
	}
}
```



## Funcionalidad de la clase `File()`

La clase `File` contiene una serie de métodos que nos permiten sacar información relativa al archivo o directorio al que apunta, así como poder navegar (obteniendo el padre o accediendo a alguno de los directorios hijos). También nos permitirán manipular ambas cosas, modificando la información y la estructura de directorios (crear directorios nuevos, borrar, renombrar, ...). Veremos algunos de ellos, agrupados por categorías.

Por cierto, como nos interesa hacer las aplicaciones sin tener que depender de la plataforma, nos será muy útil poder situarnos en la raíz del dispositivo sin tener que ponerlo a mano. Esto se consigue con el método **static** de `File` llamado `listRoots()`. En sistemas Linux devolverá un único elemento, pero en sistemas Windows devolverá la raíz de cada unidad del sistema, por eso es un array. Esta es una manera de obtener un `File` que apunta a la raíz (y en el caso de Windows a la raíz de C :):

```java
File f = File.listRoots()[0];
```

Si en Windows quisiéramos ir a la raíz de D :, deberíamos poner `File.listRoots()[1]`, y así sucesivamente.

Otra cosa que puede llevar a engaño es que perfectamente puede no existir el archivo o directorio especificado en la creación del `File`. Recuerda que no estamos accediendo aún al contenido de los archivos. Y perfectamente podemos crear un `File` de un fichero o directorio que no existe, justamente para crearlo.

### Métodos para obtener el nombre o la ruta

| Método               | Descripción                              |
| -------------------- | ---------------------------------------- |
| `getName()`          | Devuelve el nombre del fichero o directorio |
| `getPath()`          | Devuelve la ruta relativa                |
| `getAbsolutePath()`  | Devuelve la ruta absoluta                |
| `getCanonicalPath()` | Devuelve la ruta absoluta sin posibles redundancias |

En el siguiente ejemplo se intenta mostrar esto de las redundancias, que `getCanonicalPath()` resuelve completamente. Observa como para ilustrar el ejemplo hacemos referencia a un archivo de una forma complicada. Supongamos que el directorio activo es `/home/usuario/eclipse-workspace/Ficheros`, y queremos hacer referencia a un archivo situado en un subdirectorio llamado `archivos`

```java
package Ejemplos;

import java.io.File;
import java.io.IOException;

public class Ejemplo3 {
	public static void main(String[] args) throws IOException {
		File f = new File("archivos/../archivos/fichero1.txt");
		System.out.println("Nombre del fichero: " + f.getName());
		System.out.println("Ruta del fichero: " + f.getPath());
		System.out.println("Ruta absoluta del fichero: " + f.getAbsolutePath());
		System.out.println("Ruta canónica del fichero: " + f.getCanonicalPath());
	}
}

```

Y esta es la salida del programa:

![1524653823464](/programacion-java/assets/img/ficheros/1524653823464.png)

>  **Nota**. Para que el programa funcione, debéis tener la siguiente estructura de directorios en vuestro proyecto Eclipse
>
>  ![1524653961483](/programacion-java/assets/img/ficheros/1524653961483.png)
>
>  

### Métodos para acceder al directorio padre o a los hijos (ficheros y directorios)

| Método            | Descripción                              |
| ----------------- | ---------------------------------------- |
| `list()`          | Devuelve un array de `Strings` con todos los elementos contenidos en el `File` |
| `listFiles()`     | Devuelve un array de `Files` con todos los elementos contenidos en el `File` |
| `getParent()`     | Devuelve el nombre (`String`) del directorio padre. Si no existe por ser la raíz, devuelve **null** |
| `getParentFile()` | Devuelve el directorio padre como un `File`. Si no existe por ser la raíz, devuelve **null** |

Ya hemos visto la utilidad de `list()`, que devuelve un **array** de `Strings`. En ocasiones nos será de muchísima utilidad `listFiles()`, ya que devuelve un **array** de `Files`. Si a esto adjuntamos los métodos `getParent()` y `getParentFile()`, vemos que podremos navegar por el sistema de ficheros.

### Métodos para comprobar la existencia y características

| Método              | Descripción                              |
| ------------------- | ---------------------------------------- |
| `exists()`          | Devuelve **true** si el fichero o directorio existe. |
| `isDirectory()`     | Devuelve **true** si es un directorio.   |
| `isFile()`          | Devuelve **true** si es un fichero       |
| `isHidden()`        | Devuelve **true** si es un archivo oculto |
| `length()`          | Devuelve el tamaño en **bytes** del archivo |
| `lastModified()`    | Devuelve la fecha de modificación del archivo |
| `setLastModified()` | Actualiza la fecha de modificación del archivo |

Como ya habíamos comentado antes, en el momento de crear el `File`, puede ser exista o no el archivo o directorio, es decir, que quizás se corresponda o no con un archivo real. Si queremos comprobar la existencia podemos utilizar el método `exists()`.

Vamos a modificar el Ejemplo 2, donde devolvíamos todos los archivos y directorios de un directorio introducido por teclado. Primero nos aseguramos que existe y es un directorio. Después lo mejoraremos volviendo el tamaño de cada archivo si es  un archivo, y especificando que es un directorio, si lo es. Nos convendrá `listFiles()` para poder mirar si es un archivo o directorio, el tamaño, ...

```java
package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo4 {
	private static String nombreDeFichero() throws IOException {
		 String fichero = new BufferedReader(new InputStreamReader(System.in)).readLine();
		 return fichero;
	}
	private static void imprimirFichero(File e) {
		 //No imprime los ficheros/directorios ocultos
        if (!e.isHidden()) {
            if (e.isFile()) {
                System.out.println(e.getName() + " " + e.length());
            }
            if (e.isDirectory()){
                System.out.println(e.getName() + " <Directorio>");
            }
        }
	}
	private static void imprimirDirectorio(File f) throws IOException {
		if (f.exists()) {
            if (f.isDirectory()) {
                System.out.println("Lista de ficheros y directorios del directorio: " + f.getCanonicalPath());

                System.out.println("---------------------------------------------------");
                for (File e : f.listFiles()){
                	imprimirFichero(e);
                }
            } else {
    			System.out.println("No es un directorio");
    		}
		} else {
			System.out.println("No existe el directorio");
		}
	}
    public static void main(String[] args) throws IOException {

        System.out.println("Introduce un directorio:");

        String ent = nombreDeFichero();

        File f = new File(ent);
        try {
        	imprimirDirectorio(f);
        } catch(IOException e) {
        	System.out.println("No existe el directorio");
        }
    }
}
```

### Métodos para permisos

Los siguientes métodos nos permiten consultar y modificar los permisos del `File`, al más puro estilo Linux

| Método                            | Descripción                              |
| --------------------------------- | ---------------------------------------- |
| `canRead()`                       | Devuelve **true** si se tiene permiso de lectura |
| `canWrite()`                      | Devuelve **true** si se tiene permiso de escritura |
| `canExecute()`                    | Devuelve **true** si se tiene permiso de ejecución |
| `setReadable(boolean, boolean)`   | Establece el permiso de acceso de lectura del propietario y de todos para este fichero. |
| `setWritable(boolean, boolean)`   | Establece el permiso de acceso de escritura del propietario y de todos para este fichero. |
| `setExecutable(boolean, boolean)` | Establece el permiso de acceso de ejecución del propietario y de todos para este fichero. |

### Métodos de creación y borrado

Nos permiten crear directorios, ficheros vacíos y borrarlos.

| Método             | Descripción                              |
| ------------------ | ---------------------------------------- |
| `createNewFile()`  | Crear un nuevo archivo vacío asociado al `File`, siempre que no exista ya uno con el mismo nombre |
| `delete()`         | Borra el archivo o directorio            |
| `mkdir()`          | Crea un directorio con el nombre indicado en la creación del `File`. Debe existir el directorio padre |
| `mkdirs()`         | Como el anterior, pero si hace falta que crea todos los directorios de la ruta necesarios |
| `renameTo(String)` | Cambia el nombre del archivo             |

### Métodos acerca del espacio en el dispositivo

También disponemos de métodos que nos dicen el espacio total y libre del dispositivo donde está situado el `File`.

| Método             | Descripción                              |
| ------------------ | ---------------------------------------- |
| `getFreeSpace()`   | Devuelve el espacio libre del dispositivo donde está situado el `File` |
| `getUsableSpace()` | Devuelve el espacio utilizable para la aplicación (menor que el espacio libre) |
| `getTotalSpace()`  | Devuelve el espacio total del dispositivo donde está situado el `File` |

## Ejercicios

### Ejercicio 1

Realiza un programa que permita navegar por los directorios de la unidad principal del sistema de archivos.

* Debe empezar por la raíz (/ en Linux; c: \ en Windows). Recuerda que el método estático `File.listRoots()[0]` nos da la raíz.
* Debe indicar el directorio que está mostrando.
* Debe poner como primera opción ir al directorio padre (opción 0).
* Debe poner un número delante de cada archivo o subdirectorio que se está mostrando. Observa que este número comienza con 1 (el 0 es para el padre). Si se ha guardado en un array la lista de archivos y directorios del directorio actual, recuerda que el primer elemento es el 0 (pero vosotros lo mostraréis con un 1 delante).
* En caso de ser un archivo debe decir el tamaño. En caso de ser un subdirectorio, debe indicarse con `<directorio>`
* Posteriormente debe dejar introducir un número. Las opciones serán:
  * **-1** para terminar
  * **0** ir al directorio padre
  * Cualquier otro número debe servir para cambiar a este directorio como el directorio activo. Si era un archivo, no tiene que hacer nada (en la imagen, no debe poder ir al 3, ya que es un archivo).
  * Se debe controlar que existe el padre (en el caso de la raíz, no tiene). Si no lo tiene, no hay que hacer nada.
  * Se debe controlar que hay permiso de lectura sobre un directorio, antes de cambiar a él, sino dará error (en la imagen, por ejemplo, seguramente no se podrá cambiar el directorio `root`, ya que no tendremos permiso de lectura sobre él)

![1524657519101](/programacion-java/assets/img/ficheros/1524657519101.png)



### Ejercicio 2

Modifica el anterior para que también muestre los datos acerca de si es un directorio, los permisos, tamaño y fecha de modificación al estilo que usa **Linux** con el comando `ls -l`

![1525279800800](/programacion-java/assets/img/ficheros/1525279800800.png)

**Nota**. Para imprimirlo tabulado he usado las siguientes instrucciones:

```java
DateFormat formatter;
formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());
//....
System.out.println(cont + ".- \t" + flags + "\t" +  String.format("%-15d", e.length()) + formatter.format(e.lastModified()) + "\t" + e.getName());
```

> -toogle-Piensa antes de mirar
>
> ```java
> import java.io.BufferedReader;
> import java.io.File;
> import java.io.IOException;
> import java.io.InputStreamReader;
> import java.text.DateFormat;
> import java.util.Locale;
> 
> public class Ejercicio2 {
> 	/**
> 	 * Devuelve los flags del archivo al estilo linux
> 	 * @param f
> 	 * @return los flags
> 	 */
> 	static String getFlags(File f) {
> 		/*String flags = "";
> 		if (f.isFile()) {
>             flags += "-";
>         }
>         if (f.isDirectory()) {
>             flags += "d";
>         }
>         if (f.canRead())
>         	flags += "r";
>         else
>         	flags += "-";
>         
>         if (f.canWrite())
>         	flags += "w";
>         else
>         	flags += "-";
>         
>         if (f.canExecute())
>         	flags += "x";
>         else
>         	flags += "-";
>         	
>         	return flags;
>         */
>         
>         return (f.isFile()? "-" : "") 
>         		+ (f.isDirectory()? "d" : "") 
>         		+ (f.canRead()? "r" : "-") 
>         		+ (f.canWrite()? "w" : "-")
>         		+ (f.canExecute()? "x" : "-");
>         
> 	}
> 	/**
> 	 * Devuelve un String con los datos del Fichero
> 	 * @param cont
> 	 * @param f
> 	 * @return la cadena formateadas
> 	 */
> 	static String imprimeLinea(int cont, File f) {
> 		DateFormat formatter;
> 		formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());
>     	return (cont + ".- \t" + getFlags(f) + "\t" +  String.format("%-15d", f.length()) + formatter.format(f.lastModified()) + "\t" + f.getName());
> 		
> 	}
> 	/**
> 	 * Imprime el contenido del directorio f. 
> 	 * 
> 	 * @param f
> 	 *            Directorio del que se desea imprimir el contenido
> 	 * @throws IOException
> 	 */
> 	public static void imprimeDirectorio(File f) throws IOException {
> 		int cont = 0;
> 		
> 		System.out.println("Lista de ficheros y directorios del directorio: " + f.getCanonicalPath());
> 		System.out.println("---------------------------------------------------");
> 		System.out.println(cont + ".- " + "Directorio padre ");
> 		for (File e : f.listFiles()) {
> 			// Aumentamos el contador para imprimirlo junto con el nombre de archivo o
> 			// directorio
> 			cont++;
> 			System.out.println(imprimeLinea(cont, e));
> 		}
> 
> 
> 	}
> 
> 	/**
> 	 * Da la opción al usuario de seleccionar una opción. Comprueba que esta opción
> 	 * está dentro del límite -1 .. número de ficheros
> 	 * 
> 	 * @param numberOfFiles
> 	 *            número de ficheros
> 	 * @return la opción seleccionada por el usuario
> 	 * @throws IOException
> 	 */
> 	public static int gestionMenu(int numberOfFiles) throws IOException {
> 		boolean ok;
> 
> 		int opcion = -1;
> 		do {
> 			// Este bucle controla que el usuario introduce un número
> 			ok = true;
> 			System.out.println("Introduce una opción (-1 para salir): ");
> 			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
> 			try {
> 				opcion = Integer.parseInt(in.readLine()); // Lee una cadena, pero tenemos que transformarla a entero
> 				// Control de opción correcta
> 				if ((opcion < -1) || (opcion > numberOfFiles)) {
> 					ok = false;
> 					System.out.printf("Opción incorrecta. Opciones válidas entre -1 y %d%n", numberOfFiles);
> 				}
> 			} catch (NumberFormatException nfe) {
> 				System.out.println("Opción incorrecta. Sólo números enteros.");
> 				ok = false;
> 			}
> 		} while (!ok);
> 
> 		return opcion;
> 	}
> 
> 	/**
> 	 * A partir de un directorio y una opción, devuelve el próximo directorio a
> 	 * procesar
> 	 * 
> 	 * @param currentFile
> 	 *            directorio actual
> 	 * @param numDir
> 	 *            opción a procesar
> 	 * @return el directorio a procesar
> 	 */
> 	public static File obtenerDirectorio(File currentFile, int numDir) {
> 		if (currentFile == null) {
> 			// La primera vez, empezamos por root
> 			return File.listRoots()[0];
> 		} else if (0 == numDir) {
> 			// Si queremos ir al padre
> 			// Ahora ya controlamos que tiene padre y, si lo tiene, que se puede leer
> 			if (currentFile.getParentFile() != null && currentFile.getParentFile().canRead()) {
> 				return currentFile.getParentFile();
> 			}
> 		} else {
> 			// En otro caso, queremos ir a un directorio hijo
> 			// Y comprobamos que es un directorio y que se puede leer
> 			if (currentFile.listFiles()[numDir - 1].isDirectory() && currentFile.listFiles()[numDir - 1].canRead()) {
> 				return currentFile.listFiles()[numDir - 1];
> 			}
> 		}
> 		// Si llega hasta aquí, devolvemos el mismo directorio
> 		return currentFile;
> 	}
>  	public static void main(String[] args) throws IOException {
> 		int opcion = -2;
> 		File f = null;
> 		do {
> 			f = obtenerDirectorio(f, opcion);
> 			imprimeDirectorio(f);
> 			opcion = gestionMenu(f.listFiles().length);
> 		} while (-1 != opcion);
> 
> 		System.out.println("Fin del programa");
> 	}
> }
> ```
>
> 

