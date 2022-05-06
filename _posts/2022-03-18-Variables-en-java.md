---
typora-copy-images-to: ../assets/img/variables/
typora-root-url: ../../
layout: post
title: Variables en Java
categories: parte1
conToc: true
permalink: variables-en-java
---

## Introducción

Esta parte describe cómo escribir declaraciones usando variables, que almacenan valores como números y palabras, y operadores, que son símbolos que realizan un cálculo. 

Además aprenderéis cómo elegir correctamente el nombre de una variable y cuáles son sus principales roles.

## Declaración de variables
Una de las características más poderosas de un lenguaje de programación es la capacidad de definir y manipular variables Una variable es una ubicación con nombre que almacena un valor. Valores pueden ser números, texto, imágenes, sonidos y otros tipos de datos. Para almacenar un valor, primero tienes que declarar una variable.
```java
String message;
```
Esta instrucción es una declaración, porque declara que la variable llamada **message** tiene el tipo `String`. Cada variable tiene un tipo que determina qué tipo de valores puede almacenar.

Por ejemplo, el tipo `int` puede almacenar enteros, y el tipo de `char` puede almacenar caracteres.

Algunos tipos comienzan con una letra mayúscula y algunos con minúscula. Aprenderemos la importancia de esta distinción más adelante, pero por ahora debes tener cuidado de hacerlo bien.

No hay ningún tipo `Int` o `string`

Para declarar una variable entera llamada **x**, simplemente escribe:

```java
int x;
```

Ten en cuenta que **x** es un nombre arbitrario para la variable. En general, debes usar nombres que indican lo que significan las variables. Por ejemplo, si ves estas declaraciones,

```java
String firstName;
String lastName;
int hour, minute;
```

Probablemente podrás adivinar qué valores se almacenarían:

Este ejemplo declara dos variables con tipo **String** y dos con tipo **int**. Cuando un nombre de variable contiene más de una palabra, como `firstName`, es convencional poner mayúscula la primera letra de cada palabra, excepto la primera. Los nombres de las variables son sensibles a mayúsculas y minúsculas, por lo que `firstName` no es lo mismo que `firstname` o `FirstName`.

Este ejemplo también demuestra la sintaxis para declarar múltiples variables con el mismo tipo en una línea: la hora y el minuto son ambos enteros. Ten en cuenta que cada declaración declaración termina con un punto y coma.

Puedes usar cualquier nombre que desees para una variable. Pero hay alrededor de 50 palabras reservadas, llamadas **keywords**, que no está permitido usar como nombres de variables. Estas palabras incluyen **public**, **class**, **static**, **void** e **int**, que el compilador usa para analizar la estructura del programa.

Puedes encontrar la lista completa de palabras clave en http://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html, pero no tienes que memorizarlas. La mayoría de los editores de programación proporcionan "resaltado de sintaxis", que hace que las diferentes partes del programa aparece en diferentes colores.

## Asignación

Ahora que hemos declarado variables, queremos usarlas para almacenar valores. Hacemos eso
con una declaración de asignación.

```java
message = "Hello!"; // give message the value "Hello!"
hour = 11; // assign the value 11 to hour
minute = 59; // set minute to 59
```

Este ejemplo muestra tres asignaciones, y los comentarios ilustran diferentes formas utilizadas para referirse a declaraciones de asignación. 

El vocabulario puede ser confuso aquí, pero la idea es clara:
* Cuando declara una variable, crea una ubicación de almacenamiento con nombre.
* Cuando realiza una asignación a una variable, actualiza su valor.

Como regla general, una variable debe tener el mismo tipo que el valor que le asigna. Por ejemplo, no puede se almacenar una cadena en `minute` o un entero en el `message`. Veremos  algunos ejemplos que parecen romper esta regla, pero lo abordaremos más adelante.
Una fuente común de confusión es que algunas cadenas parecen enteros, pero no lo son.. Por ejemplo, `message` puede contener la cadena **"123"**, que está compuesta por los caracteres '1', '2' y '3'. Pero eso no es lo mismo que el entero 123.

```java
message = "123"; //legal
message = 123; // not legal
```

**Las variables deben inicializarse** (asignarse por primera vez) antes de que puedan ser utilizadas. Puedes declarar una variable y luego asignar un valor más tarde, como en el ejemplo anterior. O también puedes declarar e inicializar en la misma línea:

```java
String message = "Hello!";
int hour = 11;
int minute = 59;
```

## Imprimir variables

Puedes visualizar el valor de una variable usando `print` o `println`. Las siguientes declaraciones declaran una variable llamada **firstLine**, le asigna el valor *"Hello, again!"* y muestra ese valor:

``` java
String firstLine = "Hello, again!";
System.out.println(firstLine);
```

Cuando hablamos de mostrar una variable, generalmente queremos decir el valor de la variable.
Para mostrar el nombre de una variable, debes ponerlo entre comillas.

```java
System.out.print("The value of firstLine is ");
System.out.println(firstLine);
```

Para este ejemplo, la salida es:

```
The value of firstLine is Hello, again!
```

Convenientemente, la sintaxis para mostrar una variable es la misma independientemente de su tipo.
Por ejemplo:

```java
int hour = 11;
int minute = 59;
System.out.print("The current time is ");
System.out.print(hour);
System.out.print(":");
System.out.print(minute);
System.out.println(".");
```

La salida de este programa es:

```
The current time is 11:59.
```

## Operadores aritméticos

Los **operadores** son símbolos que representan cálculos simples. Por ejemplo, el operador de suma es **+**, la resta es **-**, la multiplicación es ***** y la división es **/**.
El siguiente programa convierte una hora del día en minutos:

```java
int hour = 11;
int minute = 59;
System.out.print("Number of minutes since midnight: ");
System.out.println(hour * 60 + minute);
```

En este programa, `hour * 60 + minute` es una **expresión**, que representa un solo valor a calcular. Cuando se ejecuta el programa, cada variable se reemplaza por su valor actual, y luego se aplican los **operadores**. Los valores con los que trabajan los operadores se llaman operandos.

El resultado del ejemplo anterior es:
	*Number of minutes since midnight: 719*
Las expresiones son generalmente una combinación de números, variables y operadores. Cuando se complilar y ejecutan, se convierten en un valor único.

Por ejemplo, la expresión 1 + 1 tiene el valor 2. En la expresión `hour - 1`, Java reemplaza la variable con su valor, produciendo **11 - 1**, que tiene el valor **10**. En la expresión `hour * 60 + minute`, ambas variables se reemplazan, produciendo **11 * 60 + 59**.

La multiplicación ocurre primero, produciendo 660 + 59. Luego, la suma devuelve 719.

La suma, la resta y la multiplicación hacen lo que esperas, pero podrías ser sorprendido por la división. Por ejemplo, el siguiente fragmento intenta calcular la fracción de una hora que ha transcurrido:

```java
System.out.print("Fraction of the hour that has passed: ");
System.out.println(minute / 60);
```

La salida es:
	*Fraction of the hour that has passed: 0*

Este resultado a menudo confunde a las personas. El valor de `minute` es **59** y **59** dividido por **60** debería ser **0.98333**, no **0**. El problema es que Java realiza una "división de enteros" cuando los operandos son enteros. Por diseño, la división entera siempre se redondea hacia abajo, incluso en casos como este donde el siguiente número entero está cerca.
Como alternativa, podemos calcular un porcentaje en lugar de una fracción:

```java
System.out.print("Percent of the hour that has passed: ");
System.out.println(minute * 100 / 60);
```

La nueva salida es:
	*Percent of the hour that has passed: 98*

De nuevo, el resultado se redondea hacia abajo, pero al menos ahora es aproximadamente correcto.

## Números de punto flotante
Una solución más general es usar números de coma flotante, que pueden representar tanto fracciones como números enteros. En Java, el tipo de punto flotante predeterminado se llama **double**, que es la abreviatura de doble precisión. Puedes crear variables dobles y asignarles valores usando la misma sintaxis que usamos para los otros tipos:

```java
double pi;
pi = 3.14159;
```

Java realiza una "división de coma flotante" cuando uno o más operandos son valores dobles. Entonces podemos resolver el problema que vimos en la sección anterior:

```java
double minute = 59.0;
System.out.print("Fraction of the hour that has passed: ");
System.out.println(minute / 60.0);
```

La salida es
	*Fraction of the hour that has passed: 0.9833333333333333*

Aunque los números de coma flotante son útiles, pueden ser una fuente de confusión. Por ejemplo, Java distingue el valor entero *1* del valor de coma flotante *1.0*, a pesar de que parecen ser el mismo número. Pertenecen a diferentes tipos de datos, y estrictamente hablando, no está permitido hacer asignaciones entre tipos.
Lo siguiente es ilegal porque la variable de la izquierda es un **int** y el valor del la derecha es un **double**

```java
int x = 1.1; // error del compilador
```

Es fácil olvidar esta regla porque en muchos casos Java convierte automáticamente de un tipo a otro:

```java
double y = 1; // legal, pero mal estilo
```

El ejemplo anterior debería ser ilegal, pero Java lo permite convirtiendo el valor **int** *1* al  valor **double** *1.0* automáticamente. Esta clemencia es conveniente, pero a menudo causa problemas para principiantes. Por ejemplo:

```java
double y = 1 / 3; // Error común
```

Puedes esperar que la variable y obtener el valor *0.333333*, que es un valor de punto flotante legal. Pero en cambio obtienes el valor *0.0*. La expresión de la derecha divide dos enteros, por lo que Java realiza la división entera, lo que arroja el valor **int** *0*. Convertido a doble, el valor asignado a **y** es 0.0.
Una forma de resolver este problema (una vez que descubras el error) es hacer el correcto
lado derecho una expresión de punto flotante. La siguiente asignación fija **y** a *0.333333*, como se esperaba:

```java
double y = 1.0 / 3.0; // correcto
```

Como cuestión de estilo, siempre debes asignar valores de coma flotante a variables en coma flotante. El compilador no hará que lo hagas, pero nunca se sabe cuándo un simple el error volverá y te atormentará.

## Errores de redondeo

La mayoría de los números de coma flotante solo son aproximadamente correctos. Algunos números, como enteros de un tamaño razonable, se pueden representar exactamente. Pero repitiendo fracciones, como *1/3*, y los números irracionales, como π, no pueden. Para representar estos números, las computadoras tienen que redondear al número de coma flotante más cercano.
La diferencia entre el número que queremos y el número de coma flotante que obtenemos es llamada **error de redondeo**. Por ejemplo, las siguientes dos declaraciones deberían ser equivalentes:

```java
System.out.println(0.1 * 10);
System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1  + 0.1 + 0.1 + 0.1 + 0.1 + 0.1);
```

Pero en muchas máquinas, la salida es:
	*1.0*
	*0.9999999999999999*

El problema es que *0.1*, que es una fracción de terminación en decimal, es una repetición de fracción en binario. Entonces su representación en coma flotante es solo aproximada. Cuando sumamos las aproximaciones, los errores de redondeo se acumulan.
Para muchas aplicaciones, como gráficos de computadora, encriptación, análisis estadístico y la representación multimedia, la aritmética de coma flotante tiene beneficios que superan los costos.
Pero si necesitas precisión absoluta, usa enteros en su lugar. Por ejemplo, considera la cuenta de un banco con un saldo de *123.45 €*:

```java
double balance = 123.45; // potential rounding error
```

En este ejemplo, los saldos se volverán imprecisos a lo largo del tiempo a medida que la variable se utilice en operaciones aritméticas como depósitos y retiros. El resultado sería clientes enojados y demandas potenciales. Puedes evitar el problema representando el saldo como un entero:

```java
int balance = 12345; // total number of cents
```

Esta solución funciona siempre que la cantidad de céntimos no exceda el entero más grande, que es aproximadamente 2 mil millones.

Para saber cuál es el entero más largo que se puede representar en tu versión de java, se puede usar `Integer.MAX_VALUE` 

```java
System.out.println(Integer.MAX_VALUE); // 2.147.483.647
```

## Operadores de cadenas

En general, no puedes realizar operaciones matemáticas en cadenas, incluso si las cadenas se parecen a los números. Las siguientes expresiones son ilegales:

```java
"Hello" - 1
"World" / 123
"Hello" * "World"
```

El operador **+** funciona con cadenas, pero puede no hacer lo que esperas. Para cadenas, el operador **+** realiza la concatenación, lo que significa unirse de extremo a extremo. Entonces, `"Hello," + "World!"`, produce la cadena *"Hello, World!"*.

O si tienes una variable llamada **name** que tiene tipo **String**, la expresión `"Hello " + name` agrega el valor de **name** a la cadena de saludo, que crea un saludo personalizado..
Como la adición se define para números y cadenas, Java realiza conversiones que tal vez no esperas:

```java
System.out.println(1 + 2 + "Hello");
// the output is 3Hello
System.out.println("Hello" + 1 + 2);
// the output is Hello12
```

Java ejecuta estas operaciones de izquierda a derecha. En la primera línea, *1+ 2* es *3* , y  *3 + "Hello"* es *"3Hello"* . Pero en la segunda línea,  *"Hello" + 1* es *"Hello1"* , y *"Hello1" + 2* es *"Hello12"* .

Cuando aparece más de un operador en una expresión, se evalúan de acuerdo al **orden de las operaciones**. En términos generales, Java evalúa operadores de izquierda a derecha (como vimos en la sección anterior). Pero para los operadores numéricos, Java sigue las convenciones matemáticas:

* La multiplicación y la división toman "precedencia" sobre la suma y la resta, lo que significa que suceden primero. Entonces `1 + 2 * 3` devuelve *7*, no *9*, y `2 + 4/2` produce *4*, no *3*.
* Si los operadores tienen la misma precedencia, se evalúan de izquierda a derecha.
  Entonces, en la expresión `minuto * 100/60`, la multiplicación ocurre primero; Si el el valor de minuto es *59*, obtenemos *5900/60*, lo que arroja *98*. Si estas mismas operaciones hubieran ido de derecha a izquierda, el resultado habría sido *59 \* 1*, lo cual es incorrecto.
* Cada vez que desees anular el orden de las operaciones (o no estés seguro de cuál es) puedes usar paréntesis. Las expresiones entre paréntesis se evalúan primero, por lo que (1 + 2) * 3 es 9. También puedes usar paréntesis para hacer que una expresión sea más fácil de leer, como en `(minuto * 100) / 60`, aunque no cambia el resultado.

## Composición

Hasta ahora, hemos analizado los elementos de un lenguaje de programación: variables, expresiones y declaraciones, de forma aislada, sin hablar de cómo unirlas.

Una de las características más útiles de los lenguajes de programación es su capacidad para tomar pequeños bloques de construcción y componerlos. 

Por ejemplo, sabemos cómo multiplicar números y sabemos cómo mostrar valores. Podemos combinar estas operaciones en una declaración única:

```java
System.out.println(17 * 3);
```

Cualquier expresión aritmética se puede usar dentro de una declaración de impresión. Ya hemos visto un ejemplo:

```java
System.out.println(hour * 60 + minute);
```

También puedes poner expresiones arbitrarias en el lado derecho de una asignación:

```java
int percentage;
percentage = (minute * 100) / 60;
```

**El lado izquierdo de una asignación debe ser un nombre de variable**, no una expresión. Eso es así porque el lado izquierdo indica dónde se almacenará el resultado, y las expresiones no representar ubicaciones de almacenamiento.

```java
hour = minute + 1; // correct
minute + 1 = hour; // compiler error
```

La capacidad de componer operaciones puede no parecer impresionante ahora, pero veremos ejemplos más adelante que nos permiten escribir cálculos complejos de forma clara y concisa.

Pero no te dejes llevar demasiado. Las expresiones grandes y complejas pueden ser difíciles de leer y depurar.

## Nombres de las variables

Los nombres están en todas partes en el software. Nombramos nuestras variables, nuestras funciones, nuestros argumentos, clases y paquetes. Nombramos nuestros archivos fuente y los directorios que los contienen. Nombramos y nombramos y nombramos. Debido a que hacemos tanto, será mejor que lo hagamos bien. Lo que sigue son algunas reglas simples para crear buenos nombres:

### Usar nombres que revelen la intención.

> Los  nombres de las variables deben in en camelCase, pero la primera letra siempre en minúsculas. De esta forma las distinguimos de los nombre de las Clases que se escriben en CamelCase.

Todos los nombres deben ser intencionados y descriptivos. Evita abreviaciones, prefijos, usar secuencias de números en variables y las palabras redundantes (the-, a-, -object, -info, -data). Usa nombres que se puedan buscar (evita variables a, e, l… usar i, j, k solo para bucles cuyo contexto sea muy acotado).

El nombre de una variable debe revelar para qué se usa. Si una variable necesita de un comentario para explicar para qué se usa, significa que no has elegido correctamente el nombre.

```java
int d; // tiempo pasado en días
```

El nombre **d** no revela nada. No evoca una sensación de tiempo transcurrido, ni de días. Debes elegir un nombre que especifique lo que se está midiendo y la unidad de esa medida:

```java
int tiempoPasadoEnDias;
int diasDesdeCreacion;
int diasDesdeModificacion;
```

Además, supón que deseas buscar dónde aparece la variable **d**. Si haces una búsqueda te aparecerán miles de palabras con la letra 'd', incluso otras variables llamadas **d**, pero que no tengan nada que ver con la variable **d** que estás buscando. Sin embargo, si buscas **tiempoPasadoEnDias**, seguro que lo encontrarás menos veces!

## Una introducción a los roles de las variables

Las variables y los atributos tienen en los programas algunos comportamientos típicos que se llaman **roles**. Por ejemplo, una variable cuyo valor nunca cambia después de la inicialización se llama **valor fijo** (*fixed value*). Los  roles no deben confundirse con los tipos básicos (por ejemplo, en Java int, char, float, etc.) ya que el concepto de roles es una clasificación que indica qué tipo de comportamiento tiene la variable o atributo en un determinado programa.

Los  roles que aparecen con mayor frecuencia son los de *valor fijo*, *contador* y el *most-recent holder*, que cubren aproximadamente el 70% de  todas las variables. Por otro lado, todas las variables y atributos no necesariamente tienen alguno de los roles enumerados a continuación.

###  Valor fijo (fixed value)

El rol de una variable o un atributo es un valor fijo, si su valor no se cambia después de la inicialización. 

En el siguiente ejemplo, se asigna una valor a la variable `dni` en la línea 9 y el valor nunca cambia después de eso. El valor fijo se puede usar en diferentes lugares en un programa, en la línea 17 en el ejemplo.

```java
import java.util.Scanner;

public class DNI {
	public static void main(String[] args) {
		int dni;
		Scanner miScanner = new Scanner(System.in);
    	
    	System.out.println("Introduce tu DNI (sin letra)");  	
    	dni  = miScanner.nextInt();
        
    	miScanner.close();
        
		char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };

		// Obtener a qué índice corresponde
		int res = dni % 23;
		System.out.println("La letra correspondiente es: " + letras[res]);

	}
}
```

### Contador (stepper)

Un *contador* o *stepper* atraviesa una sucesión de valores de una manera sistemática. A continuación se muestra un ejemplo de una estructura de bucle donde la variable **multiplicando** se usa como un contador. El programa de ejemplo genera una tabla de multiplicar mientras que el contador pasa por los valores del uno al diez.

```java
public class MultiplicationTable {
	public static void main(String[] args) {
		int multiplicando;
		for (multiplicando = 1; multiplicando <= 10; multiplicando++)
			System.out.println(multiplicando + " * 3 = " + multiplicando * 3);
		}
}
```

Un contador también se puede usar, por ejemplo, para contar y recorrer los índices de un array.

### Most-recent holder

El valor de un *most-recent holder* es el valor pasado más reciente de un determinado grupo o simplemente el último valor de entrada. El programa de ejemplo repetidamente (en la línea 12) le pregunta al usuario por la entrada hasta que la se rinda o gane. En este programa, las variable `numero` es el *most-recent holder*, ya que contiene el último valor de entrada en el momento.

```java
do {
    System.out.println("Introduce un número (-1 para rendirse)");
    numero = miScanner.nextInt();

    if (numero != -1) {
        if (numero > secreto) {
            System.out.println("El número secreto es más pequeño");
        }else if (numero < secreto) {
            System.out.println("El número secreto es más grande");
        }else {
            System.out.println("Has Ganado");
            haGanado = true;
        }
    }else {
        System.out.println("Se rinde");
    }
} while (!haGanado && (numero != -1));
```

### Most-wanted holder

El valor del *most-wanted holder* es el "*mejor*" o el valor más buscado de los valores que se han procesado hasta ahora. No  existe ninguna restricción para medir la *superioridad* de los valores: lo más buscado o mejor puede significar, por ejemplo, el número más pequeño o  más grande o un número más cercano a un determinado valor.

El ejemplo descubre la mayor de las temperaturas incluidas en un array. La variable  `maximo` es el *most-wanted holder* ya que se le da (en  la línea 10) el valor actual si es más grande que el más grande hasta el  momento.

```java
public class TemperaturaMaxima {
	public static void main(String[] args){	
		int[] temperaturas =  {25, 30, 19, 31, 28, 15, 20};
		int maximo;
        
		//Suponemos que el máximo es el primer número del array
		maximo = temperaturas[0]; 	
        for (int i = 1; i < temperaturas.length; i++) {
			if (temperaturas[i] > maximo) {
				maximo = temperaturas[i]; 
			}
		}
		System.out.println("La temperatura máxima es: " + maximo);
	}
}
```



### Acumulador (gatherer)

El valor de un *acumulador* acumula todos los valores que se han procesado hasta ahora. El programa de ejemplo acepta números dados como entrada uno por uno hasta que el usuario introduzca el número -999 después de lo cual el programa calcula el valor medio de las entradas. La variable `sumaNotas` es un *acumulador*: el total de las entradas se recopila (en la línea 9) en ella.

```java
public class media {

	public static void main(String[] args) {
		int sumaNotas = 0;
		// Declara un array de enteros
		int[] numeros = {5, 7, 55, 8, 90, 33, 45, 68, 21, 10};

		for (int nota : numeros) {
			sumaNotas += nota;
		}

		System.out.println("La nota media es " + ((float) sumaNotas / (float) numeros.length));
		
	}
}
```



### Bandera (one-way flag o flag)

Una bandera unidireccional tiene dos valores posibles pero no puede recuperar su valor original después de haber sido cambiado una vez. La clase de ejemplo descubre si alguna de las temperaturas incluidas en una estadística es negativa. El indicador de dirección única **tieneBajoCero** *vigila* (en la línea 7) si aparece algún número negativo entre las entradas y si se encuentra al menos un valor negativo, la variable nunca regresará al valor falso.

```java
public class BajoCero {
	public static void main(String[] args){	
		int[] temperaturas =  {25, 30, 19, 31, 28, 15, 20, -10};
		boolean tieneBajoCero = false;   	
		for (int i = 0; i < temperaturas.length; i++) {
			if (temperaturas[i] < 0) {
				tieneBajoCero = true;
				break;
			}
		}
		if (tieneBajoCero)
			System.out.println("Ha habido temperaturas bajo cero");
		else
			System.out.println("NO ha habido temperaturas bajo cero");
	}
}
```

La variable **i** es un *contador*.

### Temporal (temporary)

Una variable temporal es una variable con una vida útil corta, generalmente para contener datos que pronto serán descartados, o antes de que pueda ubicarse en una ubicación de memoria más permanente. Debido a que es de corta duración, por lo general se declara como una variable local. No  existe una definición formal de lo que hace que una variable sea temporal, pero es un término de uso frecuente en la programación.

Un ejemplo típico sería el de intercambiar el contenido de dos variables. Para intercambiar los contenidos de las variables **a** y **b**, normalmente se usaría una variable temporal de la siguiente manera, a fin de preservar los datos de **a**, ya que se sobrescribe con **b**:

```java
 int a, b, temp;
 a = 5;
 b = 6;
 temp = a;
 a = b;
 b = temp;
```

En este caso, también se le llama variable *swap*.

## Vocabulario

**variable**:
Una ubicación de almacenamiento con nombre para los valores. Todas las variables tienen un tipo, que se declara cuando la variable es creada

**valor**:
Un número, cadena u otros datos que se pueden almacenar en una variable. Cada valor pertenece a un tipo (por ejemplo, int o String).

**declaración**:
Una declaración que crea una nueva variable y especifica su tipo.

**tipo**:
Matemáticamente hablando, un conjunto de valores. El tipo de una variable determina qué valores que puede tener.

**sintaxis**:
La estructura de un programa; la disposición de las palabras y símbolos que contiene.

**palabra clave (keyword)**:
Una palabra reservada utilizada por el compilador para analizar programas. No se puede usar palabras clave (como public, class y void) como nombres de variables.

**asignación**:
Una declaración que da un valor a una variable.

**inicializar**:
Para asignar una variable por primera vez.

**estado**:
Las variables en un programa y sus valores actuales.

**diagrama de estado**:
Una representación gráfica del estado de un programa en un punto en el tiempo.

**operador**:
Un símbolo que representa un cálculo como suma, multiplicación o cadena concatenación.

**operando**:
Uno de los valores en los que opera un operador. La mayoría de los operadores en Java requieren dos operandos.

**expresión**:
Una combinación de variables, operadores y valores que representa un solo valor. Las expresiones también tienen tipos, según lo determinen sus operadores y operandos.

**punto flotante**:
Un tipo de datos que representa números con una parte entera y una parte fraccionaria. En Java, el tipo de punto flotante predeterminado es double.

**error de redondeo**:
La diferencia entre el número que queremos representar y el más cercano número de punto flotante.

**concatenar**:
Para unir dos valores, a menudo cadenas, de extremo a extremo.

**Orden de operaciones**:
Las reglas que determinan en qué orden se evalúan las operaciones.

**composición**:
La capacidad de combinar expresiones simples y declaraciones en compuesto expresiones y declaraciones

------

Basado en los siguientes documentos  

* http://www.cs.joensuu.fi/~saja/var_roles/stud_vers/stud_Java_eng.html 

* [Think java](http://greenteapress.com/wp/think-java/).  

  



