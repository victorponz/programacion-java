---
typora-copy-images-to: ../programacion-java/assets/img/valuemethods/img/valuemethods/
typora-root-url: ../../
layout: post
title: Convertir un algoritmo en método
categories: metodos
conToc: true
permalink: creating-methods
---
Vamos a ver diferentes técnicas para convertir un algoritmo en un método que devuelva un valor y lo haremos mediante ejemplos.

Los pasos son los siguientes:

1. Identificar qué datos de entrada son necesarios para que funcione el algoritmo.
2. Identificar cuáles son las instrucciones precisas que forman el algoritmo.
3. Identificar cuál es el resultado esperado del algoritmo.

Una vez identificados estos datos e instrucciones es muy fácil convertirlo en un método.

## Número más grande

Tenemos un programa `main` que lee [dos números y muestra cuál es el más grande.](https://gist.github.com/victorponz/10f53524b8528134acc0559404f6051f)

<script src="https://gist.github.com/victorponz/10f53524b8528134acc0559404f6051f.js"></script>

El algoritmo en sí, empieza en la línea 6 y acaba en la 10. Podemos comprobar que las variables **numero** y **numero2** son los datos necesarios para que funcione el algoritmo (es decir, debe conocer los dos valores a comparar) y además su tipo es **int**.

Pero hay que tener en cuenta que un método **NUNCA debe imprimir** en pantalla sino devolver un resultado. El programa que haga uso de este método ya imprimirá si es necesario (o lo enviará por correo electrónico, lo enviará a un sensor, etc).

El algoritmo realiza una comparación e imprime. Pero lo que debe hacer es devolver cuál es el más grande y este valor sigue siendo de tipo **int**.

Por tanto ya sabemos que necesita **dos argumentos** de tipo **int** y que **devuelve** un valor de tipo **int**. Y ya podemos crear la base para el algoritmo:

```java
public static int valorMasGrande(int num1, int num2) {
	return 0;
}
```

Observad que el nombre de los argumentos no tiene porqué coincidir con los que usaban en `main`

Y ahora podemos implementar el algoritmo:

```java
public static int valorMasGrande(int num1, int num2) {
	if (num1 > num2) {
		return num1;
	} else {
		return num2;
	}
}
```

Y ahora modificamos el programa `main` para que use este método:

```java
public static void main(String argv[]) {
	int numero = Utilidades.leerEntero("Introduce un número entero:");
	int numero2 = Utilidades.leerEntero("Introduce otro número entero:");

	System.out.println("El número más grande es: " + valorMasGrande(numero, numero2));
}
```
Fijaos que ahora quien imprime es `main`, no el algoritmo.

> -hint-Este tipo de condicionales se pueden resumir usando el operador ternario, por lo que quedaría de la siguiente forma.
>
> ```java
> public static int valorMasGrande(int num1, int num2) {
> 	// Otra forma de hacerlo es con el operador ternario
> 	// (condition ? exprTrue : exprFalse)
> 	return ((num1 > num2) ? num1 : num2);
> }
> ```



## Valor de la nota en texto

Tenemos un programa que [lee una nota y muestra su valor en texto](https://gist.github.com/victorponz/a2e4e06b90f723a31c6ecb009990a529):

<script src="https://gist.github.com/victorponz/a2e4e06b90f723a31c6ecb009990a529.js"></script>

El algoritmo empieza en la línea 10 y acaba en la 26. Antes de que comience el algoritmo, obtenemos una nota de tipo `int`, que es el único dato que necesita el algoritmo. Como hemos quedado que el algoritmo no imprime nada, lo que hacemos es devolver un `String`.

Por tanto, el algoritmo tendrá la siguiente signatura:

```java
public static String convertirEnLetra(int nota) {
	return "";
}
```

Y ahora implementamos el algoritmo:

```java
public static String convertirEnLetra(int nota) {
	String notaEnLetra = "";
	// Si las condiciones son mutuamente excluyentes, se usa if .. else if ...
	if ((nota < 0) || (nota > 10)) {
		notaEnLetra =  "Nota inválida";
	} else if (nota < 3) {
		notaEnLetra =  "Muy deficiente";
	} else if (nota < 5) {
		// No hace falta que comprobemos que es mayor que 3, porque si lo fuera
		// habría entrado por el if (nota < 3) {
		notaEnLetra =  "Insuficiente";
	} else if (nota < 6) {
		notaEnLetra =  "Suficiente";
	} else if (nota < 7) {
		notaEnLetra =  "Bien";
	} else if (nota < 9) {
		return "Notable";
	} else {
		notaEnLetra =  "Sobresaliente";
	}
	return notaEnLetra;
}
```

Fijaos también que realmente no hace falta la variable **notaEnLetra** si lo que hacemos es devolver la cadena en vez de almacenarla en una variable. Es decir:

```java
public static String convertirEnLetra(int nota) {
	// Si las condiciones son mutuamente excluyentes, se usa if .. else if ...
	if ((nota < 0) || (nota > 10)) {
		return "Nota inválida";
	} else if (nota < 3) {
		return "Muy deficiente";
	} else if (nota < 5) {
		// No hace falta que comprobemos que es mayor que 3, porque si lo fuera
		// habría entrado por el if (nota < 3) {
		return "Insuficiente";
	} else if (nota < 6) {
		return "Suficiente";
	} else if (nota < 7) {
		return "Bien";
	} else if (nota < 9) {
		return "Notable";
	} else {
		return "Sobresaliente";
	}
}
```

Ahora el algoritmo es más eficiente.

Ahora ya podemos modificar `main`:

```java
public static void main(String argv[]) {
	int nota = Utilidades.leerEntero("Introduce el valor de la nota entera:");
	System.out.println(convertirEnLetra(nota));
}
```

## Es positivo

Otro ejemplo es convertir algoritmos que [calculan si algo es verdadero o falso](https://gist.github.com/victorponz/c524aa76348cc754a4ff2db85b2a4e73). En este tipo de algoritmos el valor de retorno siempre es **boolean**.

<script src="https://gist.github.com/victorponz/c524aa76348cc754a4ff2db85b2a4e73.js"></script>

En este caso, el argumento para el algoritmo (que empieza en la línea 8 y acaba en la 12), es un número de tipo **int**:

```java
public static boolean esPositivo(int num) {
	if (num >= 0) {
        return true;
    } else {
        return false;
    }
}
```

Pero este tipo de algoritmos se suelen implementar devolviendo la condición. Es decir

```java
public static boolean esPositivo(int num) {
	return (num >= 0);
}
```

Porque si `(num >= 0 )` devolverá **true** y sino devolverá **false** (lo mismo que hace el `if ... else` anterior).

## Positivos

El siguiente programa calcula [cuántos números de un array son positivos](https://gist.github.com/victorponz/7a11ad0302aa1670781702db029e3fce):

<script src="https://gist.github.com/victorponz/7a11ad0302aa1670781702db029e3fce.js"></script>

El algoritmo empieza en la línea 9 y acaba en la 15. Como datos de entrada tiene un **array de números** y lo que calcula es el número (**int**) de positivos (que lo va calculando en la variable **positivos**). Es decir, la variable **positivos** es **local** al algoritmo y por tanto no es un dato de entrada sino que es el valor que produce. Por tanto, la signatura del método sería la siguiente:

```java
public static int cuantosPositivos(int[] numeros) {
	return 0;
}
```

Y el método completo sería como sigue:

```java
public static int cuantosPositivos(int[] numeros) {
	int contador = 0;
	for (int numero : numeros) {
		if (numero >= 0) {
			contador++;
        }
	}
	return contador;
}
```

Fijaos como la variable **contador** ha pasado a estar definida dentro del algoritmo, por lo que **ya no aparecerá en el programa** que le llame.

```java
public static void main(String[] args) {

	int[] array = new int[20];

	Utilidades.rellenaArray(array, -10, 10);

	System.out.println(Arrays.toString(array));

	System.out.println("Hay " + cuantosPositivos(array) + " positivos");
}
```

## Encontrar un valor

Un programa que indica si un [número está incluido en los valores de un array de enteros](https://gist.github.com/victorponz/634756bf4a17bb81ce9cb33dd3f978de):

<script src="https://gist.github.com/victorponz/634756bf4a17bb81ce9cb33dd3f978de.js"></script>

El algoritmo empieza en la línea 12 y acaba en la 17. Como dato sólo le hace falta un `array` de números y un valor a buscar de tipo entero. Por tanto tiene dos argumentos. Y el valor devuelto es un `boolean`.

Este sería el algoritmo completo:

```java
public static boolean estaEnElArray(int[] numeros, int numeroABuscar) {
	boolean encontrado = false;
	for (int num : numeros) {
		if (num == numeroABuscar) {
			encontrado = true;
			break;
		}
	}
	return encontrado;
}
```

Pero este tipo de algoritmos que devuelven un `boolean` se pueden resolver de la siguiente forma (sin usar banderas)

```java
public static boolean estaEnElArray(int[] numeros, int numeroABuscar) {
	for (int num : numeros) {
		if (num == numeroABuscar) {
			return true;
		}
	}
	return false;
}
```

Cuando en el algoritmo modificamos la bandera y hacemos `break`, aquí lo que se hace es devolver el valor de la bandera. Al hacer `return`, el algoritmo acaba. Por tanto, si encuentra el número devuelve **true** y acaba. Si no lo encuentra devolverá **false**.

Y el programa `main` será de la siguiente forma:

```java
public static void main(String[] args)
{	
	int[] numeros = new int[20];
	int numeroBuscado;;
	
	Utilidades.rellenaArray(numeros, -10, 10);
	System.out.println(Arrays.toString(numeros));
	
	numeroBuscado = Utilidades.leerEntero("Introduce un número a buscar");

	if (estaEnElArray(numeros, numeroBuscado)) {
		System.out.printf("El número %d está en el array", numeroBuscado);
	} else {
		System.out.printf("El número %d NO está en el array", numeroBuscado);
	}
}
```

Fijaos que, de nuevo, todas las variables que usa el algoritmo localmente han desaparecido de `main`.

## Nota media

Vamos a hacer un programa que [calcule la media de una serie de notas](https://gist.github.com/victorponz/0b1069abe05ce68248cfa9fc696df17b) (almacenadas en un array)  y nos diga si había un diez entre ellas:

<script src="https://gist.github.com/victorponz/0b1069abe05ce68248cfa9fc696df17b.js"></script>

En este caso vemos que el algoritmo hace dos cosas: calcular la media y comprobar si hay un diez. Pero un **método sólo debe hacer una cosa**. Por tanto hemos de hacer dos métodos:

* Uno calcula la media
* Y otro comprueba si hay un diez.

En ambos casos los datos de entrada será un `array` de enteros:

```java
public static double notaMedia(int[] notas) {
	int sumaNotas = 0;
	for (int nota : notas) {
		sumaNotas += nota;
	}
	return ((double) sumaNotas / (double) notas.length);
}
```

Pero realmente este algoritmo calcula la media de un `array` de números, no solo de notas. Por tanto vamos a refactorizar los nombres:

```java
public static double calcularMedia(int[] numeros) {
	int sumaNumeros = 0;
	for (int num : numeros) {
		sumaNumeros += num;
	}
	return ((double) sumaNumeros / (double) numeros.length);
}
```

De esta forma tenemos un algoritmo más genérico.

Y el algoritmo para comprobar si tiene un 10:

```java
public static boolean hayUnDiez(int[] notas) {
	for (int nota : notas) {
		if (nota == 10) {
			return true;
		}
	}
	return false;
}
```

Pero aquí, otra vez nos estamos limitando a comprobar sólo si tiene un 10!!. Vamos a hacerlo más genérico, de tal forma que compruebe si un valor pasado como parámetro está o no en el `array`

```java
public static boolean hayUnNumero(int[] numeros, int numeroBuscado) {
	for (int num : numeros) {
		if (num == numeroBuscado) {
			return true;
		}
	}
	return false;
}
```

Y ahora el método `main` quedaría como sigue:

```java
public static void main(String[] args) {
	int cuantasNotas = Utilidades.leerEntero("¿Cuántas notas va a introducir?");
	int[] notas;

	System.out.println("Introduce las notas (enteros)");
	notas = leerNotas(cuantasNotas);
	
	System.out.println("La nota media es " + calcularMedia(notas));

	if (hayUnNumero(notas, 10)) {
		System.out.println("Había al menos un 10");
	}
}
```

De esta forma hemos creado dos métodos que son genéricos.

**Una de las tareas de un programador es crear bloques**. Piensa en que cada un bloque (método) es como una pieza de lego: cuantas más piezas genéricas tengamos, más cosas podemos hacer. Como programador nuestra tarea es juntar *piececitas* de lego **para formar piezas más grandes**.

## Salario

Vamos a rediseñar el [programa que calculaba el salario neto de un trabajador](https://gist.github.com/victorponz/239344bf480c0390be4b0f53d38ae348). Para calcular el neto hay que saber las horas trabajadas, el precio de la hora. Con estos datos calculamos el bruto y los impuestos:

<script src="https://gist.github.com/victorponz/239344bf480c0390be4b0f53d38ae348.js"></script>

En este caso, el algoritmo empieza en la línea 12 y acaba en la línea 31. Pero realmente hace dos cálculos: salario bruto e impuestos.

Como hemos quedado que un algoritmo sólo hace una cosa, vamos a descomponerlo en dos algoritmos.

**Cálculo del salario bruto**

Para este algoritmo (líneas 12 a 20), hace falta saber las horas (**int** ) y el precio (**double**) y calcula el bruto como **double**. Por tanto:

```java
public static double calcularBruto(int horas, double precioHora) {
	double bruto;
	if (horas <= 35) {
		return horas * precioHora;
	} else {
		// Las primeras 35 se pagan normal
		bruto = 35 * precioHora;
		// Las siguientes se pagan a 1,5 veces el precio normal
		bruto += (horas - 35) * precioHora * 1.5;
	}
	return bruto;
}
```

**Cálculo de los impuestos**

Para este algoritmo (líneas 13 a 31), sólo hace falta conocer el salario bruto (**double**) y calcula los impuestos (**double**). Por tanto:

```java
public static double calcularImpuestos(double bruto) {
	double impuestos;
	if (bruto <= 500) {
		impuestos = 0.0;
	} else if (bruto <= 900) {
		// Cobra entre 500 y 900, de los primeros 500 no paga nada
		impuestos = (bruto - 500) * 0.25f;
	} else {
		// Si cobra más de 900
		impuestos = (400 * 0.25) + (bruto - 500 - 400) * 0.45;
	}
	return impuestos;
}
```

Y finalmente, `main` quedaría como sigue:

```java
public static void main(String argv[]) {
	int horas = Utilidades.leerEntero("Introduce las horas trabajadas:");
	double precio = Utilidades.leerDoble("Introduce el precio por hora:");

	double bruto = calcularBruto(horas, precio);

	double impuestos = calcularImpuestos(bruto);

	System.out.println("Pago bruto: " + bruto);
	System.out.println("Salario neto: " + (bruto - impuestos));
	System.out.println("Impuestos: " + impuestos);

}
```

## Comentarios en los métodos

Es habitual que se explique cómo funciona un algoritmo en forma de anotación en la cabecera del método.  De esta forma nos evitamos escribir comentarios dentro del código y, además, estas anotaciones pasan a formar parte de la documentación del método (ver [Javadoc](https://es.wikipedia.org/wiki/Javadoc))

Por ejemplo:

```java
/**
 * Los primeros 500 € son libres de impuestos. Los próximos 400 € tienen un
 * impuesto del 25% Y el resto una tasa de impuestos del 45%.
 * 
 * @param bruto
 * @return los impuestos
 */
public static double calcularImpuestos(double bruto) {
	double impuestos;
	if (bruto <= 500) {
		impuestos = 0.0;
	} else if (bruto <= 900) {
		impuestos = (bruto - 500) * 0.25f;
	} else {
		impuestos = (400 * 0.25) + (bruto - 500 - 400) * 0.45;
	}
	return impuestos;
}

/**
 * Las primeras 35 horas se pagan al precio normal por hora. Las horas que
 * exceden esas 35 horas se pagan 1,5 veces el precio normal.
 * 
 * @param horas
 * @param precioHora
 * @return el salario bruto
 */
public static double calcularBruto(int horas, double precioHora) {
	double bruto;
	if (horas <= 35) {
		bruto = horas * precioHora;
	} else {
		bruto = 35 * precioHora;
		bruto += (horas - 35) * precioHora * 1.5;
	}
	return bruto;
}
```



## Los programas se deben poder leer

**Recordad que sois escritores**. Y esperan que lo que escriben se pueda leer, tanto por otras personas como por ellos mismos. Ahora comparad los métodos `main` antes y después de utilizar métodos y responded a la pregunta: ¿cuál se puede leer mejor?

Por el mismo motivo, el código no debe ser complejo ni ofuscado. Cuando hagas un método hazlo de tal forma que lo pueda entender la comunidad. **Hacer un método que sólo entiendes tú no te convierte en mejor programador; justo lo contrario**.

Por último, **piensa antes de escribir un comentario**. Si el código se *puede* leer, se supone que no es necesario que expliques cómo hace lo que hace, ¿no?. Así que antes de escribir un comentario, piensa si lo que ocurre es que lo que hace es tan complejo o rebuscado que hasta has de poner un comentario para que la comunidad (y tú, cuanto tengas que revisar el código dentro de un tiempo) lo entienda. A esto también ayuda elegir nombres de variables que indiquen su propósito.

Simplemente viendo el último ejemplo del salario se puede comprobar que la versión con métodos se puede leer fácilmente. Si luego queremos indagar en cómo funciona un algoritmo, es tan sencillo como ver el código del que está compuesto (que también se debe poder leer). Evidentemente, cada vez que nos adentramos más en el código será más complejo. Todo depende de en qué nivel de abstracción nos quedemos.

Por ejemplo, cuando usamos `System.out.println()` no nos importa cómo está hecho; simplemente sabemos que llamar a este método nos permite imprimir por consola. O cuando un compañero haga un método que realice cualquier cálculo, tampoco nos interesa cómo lo hace sino qué es lo que hace. Si luego queremos investigar cómo lo hace, pues revisaremos el código fuente del algoritmo.

## Conclusión

1. Los métodos hacen una y sólo una cosa.
2. Cuanto más genéricos sean, mejor (pensad en las piezas Lego).
3. El código debe poder leerse (en castellano o inglés). Si queremos indagar en cómo lo hace, revisaremos el código fuente.
4. No hagas código enrevesado.

