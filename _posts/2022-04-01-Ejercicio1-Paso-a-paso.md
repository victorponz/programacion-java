---
typora-copy-images-to: ../assets/img/ficheros/
typora-root-url: ../../
layout: post
categories: oculto
title: Listado de directorio paso a paso
conToc: true
permalink: listado-directorio
---

Este programa es muy parecido al ejemplo 4. De hecho el algoritmo que imprime el directorio es el mismo excepto que le anteponemos un número para poder seleccionar una opción.

La diferencia radica en que hemos de hacer un bucle para que el usuario pueda seleccionar una opción del menú.

A continuación os muestro en pseudocódigo, una representación del programa

```
hacer 
	obtener directorio a procesar
	imprimir el directorio
	escoger opción del meú
hasta que la opción del menú sea igual a -1
```

Podemos empezar a hacer el programa eligiendo cada una de las acciones de las que se compone. Esto depende de la experiencia y preferencias del desarrollador.

En mi caso, como ya tenemos un algoritmo que imprime un directorio, voy a empezar convirtiendo este código en un método.

**Partimos del Ejemplo 4**

<script src="https://gist.github.com/victorponz/24470d6c4f0fde539cf3a45423675690.js"></script>

## Listado del directorio

Podemos comprobar que el algoritmo que imprime el directorio empieza en la **línea** `13` y que como parámetro de entrada tiene un directorio.

Así que vamos a crear un método al que le pasamos un directorio y éste imprime el contenido.

**Eliminamos** la línea 19 del código anterior porque vamos a listar todos los directorios y ficheros aunque estén ocultos.

<script src="https://gist.github.com/victorponz/cc163b0e88a51abc0cd575a712ff7360.js"></script>

Como veis, el único cambio es que todo el código anterior lo hemos refactorizado en un método llamado `imprimeDirectorio(File f)`.

Además, en el método hemos usado un contador (**cont**) para poder imprimir un número de opción.

En este momento ya podemos probar el programa:

![1551265899424](/programacion-java/assets/img/ficheros/1551265899424.png)

Hemos conseguido ya imprimir el listado tal y como nos pedía el enunciado.

## Menú

El siguiente paso va a ser, por ejemplo, un método que nos devuelva la opción que ha elegido el usuario.

Como siempre, hacemos un prototipo que luego iremos mejorando. Los errores tampoco los tratamos en esta primera versión.

![1551271168315](/programacion-java/assets/img/ficheros/1551271168315.png)

Y ahora modificamos el método `main()`

![1551271183487](/programacion-java/assets/img/ficheros/1551271183487.png)

Y podemos probarlo. Si introducimos un -1, el programa debe acabar.

![1551267147324](/programacion-java/assets/img/ficheros/1551267147324.png)

Ya tenemos hecho también el menú.

Ahora es momento de mejorarlo para controlar los errores. Hemos incorporado un nuevo parámetro (**numberOfFiles**) que marcará el límite de las opciones que puede seleccionar el usuario.

Tiene además un bucle `do...while` porque hemos de comprobar que la opción seleccionada por el usuario es correcta.

![1551858184306](/programacion-java/assets/img/ficheros/1551858184306.png)

Modificamos `main()` para pasar el parámetro **numberOfFiles** al método `gestionMenu()`.

```diff
@@ -6,7 +6,7 @@
 	//Ya podemos incorporar un do..while
     do {
     	imprimeDirectorio(f);
-    	opcion = gestionMenu();
+    	opcion = gestionMenu(f.listFiles().length);
     } while (-1 != opcion);
 }
```

Para saber cuántos elementos tiene un directorio, usamos el método `listFiles()`. Como devuelve un array, accedemos a la propiedad **length**.

Y ahora pasamos a probar esta nueva versión. Hemos de probar tanto los casos de éxito (es decir, que la opción escogida sea correcta) como los casos incorrectos:

* que la opción sea menor que -1
* que sea mayor que la máxima opción
* que la opción sea un número correcto
* que la opción sea -1.

![1551270095992](/programacion-java/assets/img/ficheros/pruebas.gif)

Pero si la entrada por teclado no puede convertirse a un entero, saltará una excepción en la línea 

```java
opcion = Integer.parseInt(in.readLine());
```

porque no puede convertir la entrada en un entero. 

![1551857381469](/programacion-java/assets/img/ficheros/1551857381469.png)

Por tanto, hemos de capturar esta excepción para que no nos rompa el programa:

![1551858555038](/programacion-java/assets/img/ficheros/1551858555038.png)

**Antes de la instrucción** que puede lanzar una excepción **siempre** usamos un bloque `try...catch`.

> **NOTA**. Como la excepción está en el paquete `java.lang`, no hace falta anteponerlo a `NumberFormatException`

## Seleccionar directorio

Ahora podemos implementar la parte del programa que nos permita seleccionar un directorio concreto, ya que hasta hora estamos pidiendo el directorio por teclado.

Vamos a llamar a este método `obtenerDirectorio()` al que le pasamos como parámetro el directorio actual.

![1551271242787](/programacion-java/assets/img/ficheros/1551271242787.png)

Como se puede observar hay tres posibles casos:

* seleccionar el directorio raíz
* seleccionar el directorio padre
* seleccionar un directorio según el índice pasado como parámetro en **numDir**.

```diff
@@ -1,9 +1,8 @@
 public static void main(String[] args) throws IOException{
-	System.out.println("Introduce un directorio:");
-    String ent = new BufferedReader(new InputStreamReader(System.in)).readLine();
-    File f = new File(ent);
-	int opcion;
+	int opcion = -2;
+	File  f = null;
     do {
+    	f = obtenerDirectorio(f, opcion);
     	imprimeDirectorio(f);
     	opcion = gestionMenu(f.listFiles().length);
     } while (-1 != opcion);
```

Como siempre, en esta primera versión de `obtenerDirectorio()` no realizamos comprobaciones: suponemos que el usuario introduce datos correctos.
Así que vamos a probarlo:

![1551270095992](/programacion-java/assets/img/ficheros/pruebas2.gif)Pero claro, si seleccionamos el padre de `/` , una opción que no sea un directorio o un directorio que no podamos leer, se van a producir errores.

Por ejemplo, si estamos en `/` y elegimos la opción `0` se va a producir un error ya que `/` no tiene padre.

![1551269983003](/programacion-java/assets/img/ficheros/1551269983003.png)

Si elegimos un directorio sobre el que no tenemos permisos de lectura (como por ejemplo `/root`) también se produce un error)

![1551270058295](/programacion-java/assets/img/ficheros/1551270058295.png)

Y por último, si seleccionamos un archivo en lugar de un directorio también nos lanzará un error.

![1551270095992](/programacion-java/assets/img/ficheros/1551270095992.png)

**En estos casos no debemos capturar excepciones** sino impedir que se produzcan. La captura de excepciones sólo se debe hacer cuando el código que lanza la excepción no está controlado por nosotros.

Así que nuestro último paso será controlar estos casos para que no se produzcan errores:

```diff
@@ -7,10 +7,17 @@
 		return File.listRoots()[0];
 	} else if (0 == numDir) {
 		//Si queremos ir al padre
-		return currentFile.getParentFile();
+		//Ahora ya controlamos que tiene padre y, si lo tiene, que se puede leer
+		if (currentFile.getParentFile() != null && currentFile.getParentFile().canRead()) {
+			return currentFile.getParentFile();
+		}
 	} else {
 		//En otro caso, queremos ir a un directorio hijo
-		return currentFile.listFiles()[numDir - 1];
+		// Y comprobamos que es un directorio y que se puede leer
+		if ( currentFile.listFiles()[numDir - 1].isDirectory() && currentFile.listFiles()[numDir - 1].canRead()) {
+			return currentFile.listFiles()[numDir - 1];
+		}
 	}
+	//Si llega hasta aquí, devolvemos el mismo directorio
+	return currentFile;
 }
```


