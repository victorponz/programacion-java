---
typora-copy-images-to: ../assets/img/java-basico/
typora-root-url: ../../
layout: post
title: Primeros pasos en Java
categories: parte1
conToc: true
permalink: primeros-pasos-en-java
---

# Primeros pasos en Java

> -info-En esta unidad aprenderemos a usar los tipos básicos de datos en java, a usar librerías para leer la entrada del teclado y la diferencia entre una variable y una constante. También se introducen los [diagramas de flujo](https://es.wikipedia.org/wiki/Diagrama_de_flujo) \(_flowcharts_\) y aprendemos las [estructuras condicionales](#Estructuras condicionales \(if\)).

## 1 Un programa que calcula una división y una suma.

El primer concepto que afrontamos el un programa es que **todos trabajan con datos de entrada, realizan un proceso y producen una salida**.

> -hint-**Variable**
>
> Cada vez que necesitamos *acordarnos* de un dato, lo hemos de almacenar en una variable.

![1536599756984](/programacion-java/assets/img/java-basico/1536599756984.png)

Os dejo un [vídeo](https://www.youtube.com/watch?v=bq6nJRJq27A) donde se explican las variables en java

<iframe width="560" height="315" src="https://www.youtube.com/embed/bq6nJRJq27A" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

## 2 Un programa que calcula una división y una suma \(enteros\).

![1536599861891](/programacion-java/assets/img/java-basico/1536599861891.png)

> -info-[Tipos de datos en java](https://www.campusmvp.es/recursos/post/variables-y-tipos-de-datos-en-java-tipos-simples-clases-y-tipos-envoltorio-o-wrapper.aspx)

## 3 Un programa que calcula y muestra el área de un cuadrado de lado 5

```flow
st=>start: Start:
e=>end: End:
op1=>operation: area = 5 * 5 
io=>inputoutput: Escribe area
st->op1->io->e
```



> -toogle-Piensa antes de ver la solución
>
> ```java
> public class Ejemplo3 {
> 
>     public static void main(String[] args) {
> 
>         int lado = 5;
>         int area = lado * lado;
> 
>         System.out.println("El área del cuadrado es: " + area);
>         // O también
>         System.out.printf("El área del cuadrado es: %d", area);
>     }
> 
> }
> ```
>
> En este caso tenemos dos tipos de variables:
>
> * <span style='color:red'>(5)</span> Dato de entrada para almacenar el lado
> * <span style='color:red'>(6)</span> Dato de salida para almacenar el área



## Leer un dato del teclado

En todos los ejercicios vamos a pedir al usuario que introduzca datos. Una forma de hacerlo es mediante la utilidad `java.util.Scanner`. Haced un **salto de fe** que ya veréis como más adelante lo entenderéis.

```java
import java.util.Scanner;
public class Ejemplo4 {
    public static void main (String argv[]) {
        float lado;
        Scanner inputValue = new Scanner(System.in);
        
        System.out.println("Introduce el lado:");        
        lado = inputValue.nextFloat();
        
        inputValue.close();
        //Aquí usamos los datos obtenidos
    }
}
```

En este código hemos introducido muchos conceptos:

1. <span style='color:red'>(1)</span> Usamos librerías de java. Una librería es como una caja de herramientas o un *objeto* que permite realizar tareas. Estas se organizan en salas y estanterías. Por ejemplo, la librería `java.util.Scanner` es un `Scanner` que se encuentra en la estantería `util` de la sala `java`.  El objecto `Scanner` puede realizar muchas tareas entre las que se encuentran la posibilidad de leer números decimales (`nextFloat`).
   En la estantería `util` hay muchos más [objetos](https://docs.oracle.com/javase/8/docs/api/java/util/package-summary.html). Por ejemplo, el objeto `Calendar` permite trabajar con datos de tipo fecha para, por ejemplo, saber qué día de la semana es una fecha.
2. <span style='color:red'>(5)</span> En esta instrucción creamos un nuevo `Scanner`. 
3. <span style='color:red'>(8)</span> Escaneamos un valor de tipo decimal
4. <span style='color:red'>(10)</span> Apagamos el `Scanner` una vez hemos dejado de usarlo

> -alert-Si en vez de introducir un número como lado introduces una letra, dará una **Exception** porque no puede *traducir* la letra a un número decimal. De momento, haz un salto de fe e introduce siempre en los ejercicios el tipo de dato que se espera. Ya lo arreglaremos cuando veamos las **excepciones**
>
> ```
> Exception in thread "main" java.util.InputMismatchException
>         at java.util.Scanner.throwFor(Scanner.java:864)
>         at java.util.Scanner.next(Scanner.java:1485)
>         at java.util.Scanner.nextFloat(Scanner.java:2345)
>         at Ejemplo4.main(Ejemplo4.java:13)
> ```

## 4 Un programa que calcula y muestra el área de un cuadrado cuyo lado se introduce por pantalla

![](/programacion-java/assets/img/java-basico//ej3.png)

> -toogle-Piensa antes de ver la solución
>
> ```java
> import java.util.Scanner;
> //Un programa que calcula y muestra el área de un cuadrado cuyo lado se introduce por pantalla
> public class Ejemplo4 {
>     public static void main (String argv[]) {
>         float lado;
>         float area;
>         
>         // 1. Obtenemos datos
>         Scanner inputValue = new Scanner(System.in);
>         System.out.println("Introduce el lado:");
>         //Leer un carácter como Float desde el teclado
>         lado = inputValue.nextFloat();
>         inputValue.close();
> 
>         // 2. Realizamos el algoritmo
>         area = lado * lado;
>         
>         // 3. Mostramos los datos
>         System.out.println("El área del cuadrado es: " + squareArea);
>         //o bien
>         System.out.printf("El área del cuadrado es: %f", squareArea);
>         
>     }
> }
> ```



> -info-**Estructura de un programa**
>
> Todos los programas informáticos tienen una estructura base:
>
> 1. Se obtienen datos de entrada: desde el teclado, desde un sensor, desde Internet, etc
> 2. Se procesan estos datos. Es decir a partir de los datos de entrada y de un algoritmo se generan los datos de salida.
> 3. Se muestran estos datos: en pantalla, en una impresora, en una página web, etc

> -info-**Cómo escribir un programa**
>
> **Nadie escribe un programa informático de un tirón**
>
> Un programa informático, al igual que un libro, está compuesto de muchas instrucciones (frases y oraciones). Cuando se escribe un libro, se van creando palabras, frases, oraciones, capítulos, etc. Es decir, se debe empezar por lo más básico e ir formando el *todo*.
>
> Pues lo mismo se aplica a un programa informático: **se hace poco a poco**.
>
> * La primera fase es *pensar*  **cómo solucionar** el problema
> * La segunda fase es *pensar* **cómo descomponer** el problema en partes más sencillas. Ya hemos visto que un libro se hace por partes, ¿no?. Pues piensa en esas partes. Seguro que sigue una estructura como hemos visto antes
> * Ahora es el momento de realizar cada una de las partes definidas e ir juntándolas
> * Y, muy importante, cada vez que realizas una parte compruebas que funciona.

## 5 Un programa que lea dos números enteros y muestre el resultado de sumarlos, restarlos, multiplicarlos y dividirlos

> -info-[Operadores en Java](https://www.w3schools.com/java/java_operators.asp)

![](/programacion-java/assets/img/java-basico//ej4-prop.png)

> -toogle-Piensa antes de ver la solución
>
> ```java
> import java.util.Scanner;
> //Un programa que lea dos números enteros y muestre el resultado de sumarlos,
> // restarlos, multiplicarlos y dividirlos
> public class Ejemplo5 {
>     public static void main (String argv[]) {
>         int n;
>         int m;
>         //Leer un carácter como Int desde el teclado
>         Scanner inputValue = new Scanner(System.in);
>         
>         System.out.println("Introduce el primer número:");
>         n = inputValue.nextInt();
>         
>         System.out.println("Introduce el segundo número:");
>         m = inputValue.nextInt();
>         inputValue.close();
>         
>         System.out.printf("El resultado de sumar %d y %d es: %d %n", n, m, n+m);
>         System.out.printf("El resultado de restar %d y %d es: %d %n", n, m, n-m);
>         System.out.printf("El resultado de multiplicar %d y %d es: %d %n", n, m, n*m);
>         System.out.printf("El resultado de dividir %d y %d es: %d %n", n, m, n/m);
>         
>     }
> }
> ```
> **Nota:** Los caracteres `%n` sirven para imprimir un salto de línea

## 6 Un programa que pida el radio de una circunferencia y muestre su área y su perímetro

![](/programacion-java/assets/img/java-basico//ej5-prop.png)

```java
//Nota. Para definir el valor de PI usad la constante PI de la librería Math
Math.PI

```

>  -info-**Definir constantes en java**
>
> [http://lineadecodigo.com/java/constantes-en-java/](http://lineadecodigo.com/java/constantes-en-java/)

> -toogle-Piensa antes de ver la solución
>
> ```java
> import java.util.Scanner;
> 
> //Un programa que pida el radio de una circunferencia y muestre su área y su perímetro
> public class Ejemplo6 {
> 	public static void main(String argv[]) {
> 		int radio;
> 
> 		System.out.println("Introduce el radio:");
> 
> 		//1- Leer un carácter como int desde el teclado
> 		Scanner miScanner = new Scanner(System.in);
> 		radio = miScanner.nextInt();
>         	miScanner.close();
>         
>         //2. Cálculos
> 		float area =  Math.PI * radio * radio;
>         	float perimetro = 2 * Math.PI * radio;
> 		
>         // 3 Imprimimos
>            System.out.printf("El área de la circunferencia es: %f %n", area);
> 		System.out.printf("El perímetro de la circunferencia es: %f %n",perimetro);
> 
> 		
> 	}
> }
> ```
>
> 

## 7 Un programa que pida el precio real de un producto, el precio rebajado y muestre el descuento realizado

![](/programacion-java/assets/img/java-basico//ej6b.png)

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> //Un programa que pida el precio real de un producto, el precio rebajado y muestre el descuento realizado
> public class Ejemplo7 {
>     public static void main(String argv[]) {
>         float precio;
>         float precioRebajado;
>         float descuento;
> 
>         System.out.println("Introduce el precio:");
> 
>         // 1. Leer un carácter como float desde el teclado
>         Scanner miScanner = new Scanner(System.in);
>         precio = miScanner.nextFloat();
> 
>         System.out.println("Introduce el precio rebajado:");
>         precioRebajado = miScanner.nextFloat();
>         miScanner.close();
>    
>         // 2. Calcular el descuento
>         descuento = (precio - precioRebajado) / precio * 100;
> 
>         // 3. El resultado es un número Float o Double
>         System.out.printf("El descuento es de: %f %n", descuento);
> 
> 
>     }
> }
> ```
>

# Estructuras condicionales \(if\)

La estructura condicional más simple es el `if`: se evalúa una condición y en caso de que se cumpla se ejecuta el contenido entre las llaves {}.

 ```java
public static void main(String[] args) {
 
  ......
  if (edad >= 18){
         System.out.println("Mayor de edad");
     }
     .....
    }
 ```

<iframe width="560" height="315" src="https://www.youtube.com/embed/b2ZtZndiT1Y" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

## 8 Realiza un programa que pida la edad al usuario y muestre un mensaje si es mayor de **edad**

![](/programacion-java/assets/img/java-basico//ej8.png)



# Estructuras condicionales \(if - else\)

En este caso, si no se cumple la condición del `if`, ejecuta el código definido en el `else`
 ```java
public static void main(String[] args) {
   ......
       if (edad >= 18){
           System.out.println("Mayor de edad");
       }else{
           System.out.println("Menor de edad");
       }
    .....
}
 ```
<iframe width="560" height="315" src="https://www.youtube.com/embed/8t5-D5dZu5Y" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

## 9 Igual que el anterior pero que también muestre un mensaje si es menor de edad

![](/programacion-java/assets/img/java-basico//ej9.png)

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> //Realiza un programa que pida la edad al usuario y muestre un mensaje si es mayor de edad
> public class Ejemplo9 {
> 	public static void main(String argv[]) {
> 		int edad;
> 		Scanner miScanner = new Scanner(System.in);
> 
> 		System.out.println("Introduce tu edad:");
> 
> 		// Leer un carácter como int desde el teclado	
> 		edad = miScanner.nextInt();
> 		miScanner.close();
> 
> 		// Si las condiciones son mutuamente excluyentes, se usa if .. else
> 		if (edad >= 18) {
> 			System.out.println("Eres mayor de edad");
> 		} else {
> 			System.out.println("Eres menor de edad");
> 		}
> 
> 		
> 	}
> }
> ```
>
> 

## 10 Diseña un algoritmo que lea un valor y muestre si es positivo o negativo \(0 es positivo\)

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> //Diseña un algoritmo que lea un valor y muestre si es positivo o negativo (0 es positivo)
> public class Ejemplo10 {
> 	public static void main(String argv[]) {
> 		int numero;
> 		Scanner miScanner = new Scanner(System.in);
> 		System.out.println("Introduce un número entero:");
> 
> 		// Leer un carácter como int desde el teclado
> 		numero = miScanner.nextInt();
>         miScanner.close();
> 		
> 		//Si las condiciones son mutuamente excluyentes, se usa if .. else
> 		if (numero >= 0) {
> 			System.out.println("El número es positivo");
> 		} else {
> 			System.out.println("El número es negativo");
> 		}	
> 	}
> }
> ```

## 11 Diseña un algoritmo que lea dos valores y los muestre en orden ascendente.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> //Diseña un algoritmo que lea dos valores y los muestre en orden ascendente.
> public class Ejemplo11 {
> 	public static void main(String argv[]) {
> 		int numero;
> 		int numero2;
> 		Scanner miScanner = new Scanner(System.in);
> 		
> 		// Leer un carácter como int desde el teclado
>        	System.out.println("Introduce un número entero:");
> 		numero = miScanner.nextInt();
> 		System.out.println("Introduce otro número entero:");
> 		numero2 = miScanner.nextInt();
> 		miScanner.close();
>         
> 		// Si las condiciones son mutuamente excluyentes, se usa if .. else
> 		if (numero > numero2) {
> 			System.out.println(numero + " - " + numero2);
> 		} else {
> 			System.out.println(numero2 + " - " + numero);
> 		}
> 		
> 		
> 	}
> }
> ```
>

## 12 Diseña un algoritmo que lea dos valores y muestre el más grande de ellos.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> //Diseña un algoritmo que lea dos valores y muestre el más grande de ellos.
> public class Ejemplo12 {
> 	public static void main(String argv[]) {
> 		int numero;
> 		int numero2;
> 		Scanner miScanner = new Scanner(System.in);
> 		
>         System.out.println("Introduce un número entero:");
> 		numero = miScanner.nextInt();
> 		
>         System.out.println("Introduce otro número entero:");
> 		numero2 = miScanner.nextInt();
> 		miScanner.close();
> 		// Si las condiciones son mutuamente excluyentes, se usa if .. else
> 		if (numero > numero2) {
> 			System.out.println("El número más grande es: " + numero);
> 		} else {
> 			System.out.println("El número más grande es: " + numero2);
> 		}
> 		
> 		//Otra forma de hacerlo es con el operador ternario
> 		//(condition ? exprTrue : exprFalse). 
> 		System.out.println("El número más grande es: " + ((numero > numero2) ? numero : numero2));
> 	}
> }
> ```

## 13 Realiza un programa que lea dos valores y los orden ascendente o descendentemente según elija el usuario.

En este caso necesitamos *acordarnos* de tres cosas:

* Los dos números a comparar
* El orden (por ejemplo: 1 para Ascendente y otro cualquiera para descendente)
* Para hacer el programa sigue estas fases:
  1. Lee los datos del teclado
  2. Ahora haz el algoritmo para cuando el orden es Ascendente
  3. Una vez te funcione, crea la sentencia `if` y ahora realiza la sentencia `else` para ordenar descendentemente.
  4. Comprueba que todo funciona bien.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> //Realiza un programa que lea dos valores y los orden ascende o descentemente según elija el usuario.
> public class Ejemplo13 {
> 	public static void main(String argv[]) {
> 		int numero;
> 		int numero2;
> 		int orden;
> 		Scanner inputValue = new Scanner(System.in);
> 		
> 		System.out.println("Introduce un número entero:");
> 		numero = inputValue.nextInt();
> 
> 		System.out.println("Introduce otro número entero:");
> 		numero2 = inputValue.nextInt();
> 		
> 		System.out.println("¿Cómo lo quieres ordenar?: 1 - Ascendente; 2 - Descendente");
> 		orden = inputValue.nextInt();
> 		inputValue.close();
>         
> 		if (1 == orden) {
> 			if (numero > numero2) {
> 				System.out.println(numero2 + " " + numero);
> 			} else {
> 				System.out.println(numero + " " + numero2);
> 			}
> 		} else {
> 			if (numero > numero2) {
> 				System.out.println(numero + " " + numero2);
> 			} else {
> 				System.out.println(numero2 + " " + numero);
> 			}
> 			
> 		}
> 	}
> }
> ```
>
> 

# La sentencia `else if`

 Puede ser que haya más de una condición. En este caso se usan tantos bloques `else if` como condiciones haya:

```java
int time = 22;
if (time < 10) {
  System.out.println("Good morning.");
} else if (time < 20) {
  System.out.println("Good day.");
} else {
  System.out.println("Good evening.");
}
// Outputs "Good evening."
```



> -info-Más info en [https://www.w3schools.com/java/java_conditions.asp](https://www.w3schools.com/java/java_conditions.asp)

## 14 Diseña un algoritmo que lea un valor numérico entero correspondiente a la nota de un examen y muestre su valor en letra:

de 0 a 3 Muy Deficiente.

de 3 a 5 Insuficiente.

de 5 a 6 Suficiente.

de 6 a 7 Bien

de 7 a 9 Notable

de 9 a 10 Sobresaliente

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> //Diseña un algoritmo que lea un valor numérico 
> //entero correspondiente a la nota de un examen y muestre su valor en letra
> public class Ejemplo14 {
> 	public static void main(String argv[]) {
> 		int nota;
> 		Scanner miScanner = new Scanner(System.in);
> 		
> 		System.out.println("Introduce el valor de la nota entera:");
> 		nota = miScanner.nextInt();
> 		miScanner.close();
>         
> 		// Si las condiciones son mutuamente excluyentes, se usa if .. else if ...
> 		if ((nota < 0) || (nota > 10)) {
> 			System.out.println("Nota inválida");
> 		}else if (nota < 3) {
> 			System.out.println("Muy deficiente");
> 		}else if (nota < 5 ) {
> 			// No hace falta que comprobemos que es mayor que 3, porque si lo fuera
> 			// habría entrado por el if (nota < 3) {
> 			System.out.println("Insuficiente");
> 		}else if (nota < 6 ) {
> 			System.out.println("Suficiente");
> 		}else if (nota < 7 ) {
> 			System.out.println("bien");
> 		}else if (nota < 9 ) {
> 			System.out.println("Notable");
> 		}else {
> 			System.out.println("Sobresaliente");
> 		}
> 	}
> }
> ```
>

> -info-Fíjate en la condición
>
> ```java
> if ((nota < 0) || (nota > 10)) {
> ```
>
> `||` es un operador de comparación que significa **O**. En este caso si la nota es menor que 0 **O** mayor que 10, se trata de un error
>
> Más info sobre operadores en [https://www.w3schools.com/java/java_operators.asp](https://www.w3schools.com/java/java_operators.asp)

# Estructuras de decisión múltiple

Hay momentos en los que desea comprobar una serie de condiciones y ejecutar código diferente dependiendo de la condición.

Una forma de hacerlo es con la lógica `if / else`, como el siguiente ejemplo:

```java
int x = 1;

int y = 2;

if (UN_ENTERO == x){

//HACER ALGO

}else if (UN_ENTERO == y){

//HACER OTRA COSA

}else{

//CONDICIÓN POR DEFECTO

}
```

Esto funciona, sin embargo existe otra estructura que nos permite hacer lo mismo. Las sentencias `switch` permiten al programador ejecutar ciertos bloques de código dependiendo de condiciones exclusivas. El siguiente ejemplo muestra cómo se puede usar una sentencia `switch`:

```java
int x = 1;
int y = 2;

switch (UN_ENTERO o un String o un char)
{
   case x:
      //HACER ALGO;
      break;

   case y: 
      //HACER OTRA COSA 
      break;

   default:
      //CONDICIÓN POR DEFECTO
      break;
}
```

Hay que hacer notar que la condición swith sólo admite un char o un entero  
![](/programacion-java/assets/img/java-basico//switch.png)

Os dejo un vídeo del canal de [Píldoras Informáticas](https://www.youtube.com/channel/UCdulIs-x_xrRd1ezwJZR9ww)
<iframe width="560" height="315" src="https://www.youtube.com/embed/b2ZtZndiT1Y" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

## 15 Realiza un programa que lea un número entero del 1 al 10 y que muestre su valor en letra.

En este programa sólo nos hemos de *acordar* de un dato: la nota. Dependiendo de la nota imprimiremos una cadena u otra. Como hay 10 opciones mutuamente excluyentes es más sencillo usar un `switch` que un conjunto de `if-else if-...` 

> -alert-**Cuidado**
>
> En la condición `case` **sólo** se permiten valores escalares, es decir, no se puede escribir:
>
> ```java
> case <= 3:
> ```
>
> Para simular este caso (que es un tema más avanzado) se haría así:
>
> ```java
> case 1:
> case 2:
> case 3:
> 	System.out.println("Entre uno y tres");
> 	break:
> case 4:
> 	....
> ```

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> //realiza un programa que lea un número entero del 1 al 10 y que muestre su valor en letra:
> public class Ejemplo15 {
> 	public static void main(String argv[]) {
> 		int numero;
> 		Scanner miScanner = new Scanner(System.in);
> 		
> 		System.out.println("Introduce un número del 1 al 10:");
> 		numero = miScanner.nextInt();
> 		miScanner.close();
> 		
> 		switch (numero) {
> 		case 1:
> 			System.out.println("Uno");
> 			//Importante usar break para que no continúe ejecuntando la siguiente instrucción 
> 			break;
> 		case 2:
> 			System.out.println("Dos");
> 			break;
> 		case 3:
> 			System.out.println("Tres");
> 			break;
> 		case 4:
> 			System.out.println("Cuatro");
> 			break;
> 		case 5:
> 			System.out.println("Cinco");
> 			break;
> 		case 6:
> 			System.out.println("Seis");
> 			break;
> 		case 7:
> 			System.out.println("Siete");
> 			break;
> 		case 8:
> 			System.out.println("Ocho");
> 			break;
> 		case 9:
> 			System.out.println("Nueve");
> 			break;
> 		case 10:
> 			System.out.println("Diez");
> 			break;
> 		default:
> 			System.out.println("El número debe estar comprendido entre 0 y 10");
> 		}
> 	}
> }
> ```
>
> 

## 16 Realiza un programa que lea dos números enteros y dependiendo de la operación que indique el usuario \(+, -, \* , /\) muestre el resultado

En este caso nos hemos de *acordar* de tres cosas:

* Dos números (por ejemplo, de tipo `int`)

* Una operación (en este caso usaremos el tipo `string`). Para leer un dato de tipo `String` usamos el método `inputValue.next()` 

  > -hint-Aquí va el código para la operación `+`
  >
  > ```java
  > System.out.println("Introduce la operación a realizar (+, -, *, /):");
  > operacion = inputValue.next();
  > switch (operacion) {
  >     /* Fíjate que usamos dobles comillas " porque es de tipo String */
  >     case "+":			
  >         System.out.printf("El resultado de sumar %d y %d es: %d %n", n, m, n+m);
  >         break;
  >     case "-":
  >         ....
  > ```

Como la operación a realizar es **mutuamente excluyente** usaremos un bloque `if-else if` o un bloque `switch`, el que más rabia te dé.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> //Realiza un programa que lea dos números enteros y 
> // dependiendo de la operación que indique el usuario (+, -, * , /) muestre el resultado
> public class Ejemplo16 {
> 	public static void main(String argv[]) {
> 		int n;
> 		int m;
> 		String operacion;
> 		String cadena; 
> 		Scanner inputValue  = new Scanner(System.in);
> 
> 
> 		// Leer un carácter como int desde el teclado
> 		System.out.println("Introduce un número entero:");
> 		n = inputValue.nextInt();
> 
> 		System.out.println("Introduce otro número entero:");
> 		m = inputValue.nextInt();
> 		
> 		System.out.println("Introduce la operación a realizar (+, -, *, /):");
> 		operacion = inputValue.next();
> 		switch (operacion) {
> 			/* Fíjate que usamos dobles comillas " porque es de tipo String */
> 		case "+":			
> 			System.out.printf("El resultado de sumar %d y %d es: %d %n", n, m, n+m);
> 			break;
> 		case "-":
> 			System.out.printf("El resultado de restar %d y %d es: %d %n", n, m, n-m);
> 			break;
> 		case "*":
> 			System.out.printf("El resultado de multiplicar %d y %d es: %d %n", n, m, n*m);
> 			break;
> 		case "/":
> 			System.out.printf("El resultado de dividir %d y %d es: %d %n", n, m, n/m);
> 			break;
> 		default:
> 			System.out.println("Operación incorrecta");
> 		}
> 		//También se puede hacer así. Leyendo sólo el primer carácter de la cadena
> 		char op;
> 		
> 		System.out.println("Introduce la operación a realizar (+, -, *, /):");
> 		//Leemos toda una cadena
> 		cadena = inputValue.next();
> 		// y nos quedamos con el carácter 0 (el primero)
> 		op = cadena.charAt(0);
> 		 
> 		switch (op) {
> 			/* Fíjate que usamos comilla simple ` porque es de tipo char */
> 		case '+':
> 			System.out.printf("El resultado de sumar %d y %d es: %d %n", n, m, n+m);
> 			break;
> 		case '-':
> 			System.out.printf("El resultado de restar %d y %d es: %d %n", n, m, n-m);
> 			break;
> 		case '*':
> 			System.out.printf("El resultado de multiplicar %d y %d es: %d %n", n, m, n*m);
> 			break;
> 		case '/':
> 			System.out.printf("El resultado de dividir %d y %d es: %d %n", n, m, n/m);
> 			break;
> 		default:
> 			System.out.println("Operación incorrecta");
> 		}
> 
> 		// Y también se puede hacer con un bloque if-else-if
> 		if ('+' == op)
> 			System.out.printf("El resultado de sumar %d y %d es: %d %n", n, m, n+m);
> 		else if ('-' == op)
> 			System.out.printf("El resultado de restar %d y %d es: %d %n", n, m, n-m);
> 		else if ('*' == op)
> 			System.out.printf("El resultado de multiplicar %d y %d es: %d %n", n, m, n*m);
> 		else if ('/' == op)
> 			System.out.printf("El resultado de dividir %d y %d es: %d %n", n, m, n/m);
> 		else 
> 			System.out.println("Operación incorrecta");
> 
> 		inputValue.close();
> 	}
> }
> ```

## 17 Realiza un programa que pida al usuario un mes e imprima el número de días que tiene.

En este caso es más sencillo usar un bloque `switch`, por ejemplo:

```java
switch (mes){
    case 1:
    case 3:
    ....
        System.out.print("Tiene 31 días : ");
        break;
    case 2:
            .....
```

Y, de momento, vamos a suponer que no hay años bisiestos!

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> //Realiza un programa que pida al usuario un mes e imprima el número de días que tiene.
> public class Ejemplo17 {
> 	public static void main(String argv[]) {
> 		int mes;
> 		Scanner miScanner = new Scanner(System.in);
> 		
> 		// Leer un carácter como int desde el teclado
> 		System.out.println("Introduce un mes :");
> 		mes = miScanner.nextInt();
> 		miScanner.close();
> 		
> 		//En este caso tenemos un switch que imprime lo mismo para varios casos
> 		switch (mes) {
> 		case 1:
> 		case 3:
> 		case 5:
> 		case 7:
> 		case 8:
> 		case 10:
> 		case 12:
> 			System.out.println("El mes tiene 31 días");
> 			break;			
> 		case 2:
> 			System.out.println("El mes tiene 28 o 29 días");
> 			break;
> 		case 4:
> 		case 6:
> 		case 9:
> 		case 11:
> 			System.out.println("El mes tiene 30 días");
> 			break;
> 		default:
> 			System.out.println("Mes incorrecto");
> 		}
> 
> 	}
> }
> ```

## 18 Diseña un algoritmo que recibe horas, minutos y segundos y muestra horas, minutos y segundos resultantes de la adición de un segundo.

Este problema parece trivial, ¿no?. Cojo una horas, minutos, segundos y el sumo 1. Y si resulta que ahora tengo 60 segundos? ¿Y si ahora tengo 60 minutos? Ya no parece tan simple. Pero seguro que en tu cabeza lo ves claro. El problema es que todavía no tienes práctica en traducir tus pensamientos a código. Poco a poco. Al memos haz el algoritmo para sumar un minuto si los segundos suman 60 ahora.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> //Diseña un algoritmo que recibe horas, minutos y segundos y 
> // muestra horas, minutos y segundos resultantes de la adición de un segundo.
> public class Ejemplo18 {
> 	public static void main(String argv[]) {
> 		int horas;
> 		int minutos;
> 		int segundos;
> 		Scanner miScanner = new Scanner(System.in);
> 		
> 		System.out.println("Introduce las horas:");
> 		horas = miScanner.nextInt();
> 		
> 		System.out.println("Introduce los minutos:");
> 		minutos = miScanner.nextInt();
> 		
> 		System.out.println("Introduce los segundos:");
> 		segundos = miScanner.nextInt();
> 		miScanner.close();
> 		
> 		//Añadimos un segundo
> 		segundos = segundos + 1; // o segundos++
> 		
> 		//Si al sumar un segundo, llegamos a 60 significa que hemos de aumentar un minuto
> 		if (60 == segundos) {
> 			minutos++;
> 			segundos = 0;
> 			//Si ahora los minutos son 60, hemos de aumentar una hora		
> 			if (60 == minutos) {
> 				horas++;
> 				minutos = 0;
> 				//Si ahora las horas son 24, la ponemos a 0 (ha pasado un día)
> 				if (24 == horas) {
> 					horas = 0;
> 				}
> 			}
> 		}
> 		
> 		System.out.printf("Ahora son %d:%d:%d %n", horas, minutos, segundos);
> 	}
> }
> 
> ```

## 19 Diseña un algoritmo que calcule el salario neto de un trabajador en función del número de horas de trabajo y los impuestos según las siguientes reglas:

* Las primeras 35 horas se pagan al precio normal por hora
* Las horas que exceden esas 35 horas se pagan 1,5 veces el precio normal.

  Las tasas impositivas son:

* Los primeros 500 € son libres de impuestos.

* los próximos 400 € tienen un impuesto del 25%

* Y el resto una tasa de impuestos del 45%.

Los datos de entrada son:

* € precio por hora
* número de horas.

Datos resultantes:

* Pago bruto
* Salario neto
* Impuestos

> -info-Ya hemos visto que un programa hay que descomponerlo en partes. Fíjate que se calculan tres datos que son dependientes. ( y cada cálculo individual es relativamente sencillo, ¿no?). Pues hacer todo el programa es la suma de hacer tres pequeños programas. Parece sencillo
>
> Primero piensa bien el problema. A continuación haz cálculos en una hoja de cálculo. Parece mentira pero cuando programas echas mano de papel, calculadora, ... ¡No lo haces todo en la cabeza!
>
> Ahora calcula el salario bruto. Una vez funcione, calcula el salario neto. Y, por último, los impuestos

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> public class Ejemplo19 {
> 	public static void main(String argv[]) {
> 		int horas;
> 		float precio;
> 		float bruto;
> 		float impuestos;
> 		Scanner miScanner = new Scanner(System.in);
> 		/* Habitualmente, los programas se dividen en 3 partes:
> 		 * 1.- Recoger datos
> 		 * 2.- Procesarlos
> 		 * 3.- Imprimir resultados
> 		 * Estas 3 partes deben estar diferenciadas, es decir, en la parte de proceso no
> 		 * imprimimos nada, sólo hacemos cálculos
> 		 */
> 		
> 		/*
> 		 * 1.- RECOGER DATOS 
> 		 */
> 		//Suponemos que el usuario introduce datos correctos
> 		System.out.println("Introduce las horas:");
> 		horas = miScanner.nextInt();
> 		
> 		System.out.println("Introduce el precio por hora:");
> 		precio = miScanner.nextFloat();
> 		miScanner.close();
> 	
> 		/*
> 		 * 2.- PROCESAR DATOS 
> 		 */
> 		
> 		/*
> 		 *  Primero calculamos el pago bruto.
> 		 *  Las primeras 35 horas se pagan al precio normal por hora
> 		 *  Las horas que exceden esas 35 horas se pagan 1,5 veces el precio normal.
> 		 */
> 		if (horas <= 35) {
> 			bruto = horas * precio;
> 		}else {
> 			//Las primeras 35 se pagan normal
> 			bruto = 35 * precio;
> 			//Las siguientes se pagan a 1,5 veces el precio normal
> 			bruto += (horas - 35) * precio * 1.5;
> 		}
> 		/*
> 		 * Ahora calculamos los impuestos:
> 		 *   Los primeros 500 € son libres de impuestos.
> 		 *   los próximos 400 € tienen un impuesto del 25%
> 		 *   Y el resto una tasa de impuestos del 45%.
> 		 */
> 		if (bruto <= 500) {
> 			impuestos = 0;
> 		}else if (bruto <= 900){
> 			//Cobra entre 500 y 900, de los primeros 500 no paga nada
> 			impuestos = (bruto - 500) * 0.25f;
> 		}else {
> 			//Si cobra más de 900
> 			impuestos = (400 * 0.25f) + (bruto - 500 - 400) * 0.45f;
> 		}
> 		
> 		/*
> 		 * 3.- IMPRIMIR RESULTADOS
> 		 */
> 		
> 		System.out.println("Pago bruto: " + bruto);
> 		System.out.println("Salario neto: " + (bruto - impuestos));
> 		System.out.println("Impuestos: " + impuestos);
> 		
> 	}
> }
> ```

## 20 Precio final

Un cierto comercio hace un descuento dependiendo del precio de cada producto. Si el precio es inferior a 6 euros no hay descuento. Si es mayor o igual a 6 euros  y menos de 60 €, se aplica un 5% de descuento, y si es mayor o igual a 60 € se aplica  un 10% de descuento. Diseña el algoritmo para calcular el precio final.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> public class Ejemplo20 {
> 	/*
> 	 * Un cierto comercio hace un descuento dependiendo del precio de cada producto.
> 	Si el precio es inferior a 6 euros no hay descuento. Si es mayor o igual a 6 euros
> 	y menos de 60 €, se aplica un 5% de descuento, y si es mayor o igual a 60 € se aplica
> 	un 10% de descuento. Diseña el algoritmo para calcular el precio final.
> 	 */
> 	public static void main(String[] args) {
> 		float precio;
> 		float descuento;
> 		Scanner miScanner = new Scanner(System.in);
> 
> 		/*
> 		 * 1.- RECOGER DATOS 
> 		 */
> 		System.out.println("Introduce el precio:");
> 		precio = miScanner.nextFloat();
> 		miScanner.close();
> 
> 		/*
> 		 * 2.- PROCESAR DATOS 
> 		 */
> 		if (precio < 6) {
> 			descuento = 0;
> 		}else if(precio < 60) {
> 			descuento = precio * 0.05f;
> 		}else {
> 			descuento = precio * 0.10f;
> 		}
> 		
> 		/*
> 		 * 3.- IMPRIMIR RESULTADOS
> 		 */
> 		System.out.println("El precio final es: " + (precio - descuento) + " €");
> 	}
> }
> ```
>
> 

## 21 Año bisiesto

Diseña un algoritmo que lea un año como dato de entrada y que muestre si es un año bisiesto o no. Todos los múltiplos de 400 o los que son múltiples de 4 pero no de 100 son bisiestos.

(Ej. Años bisiestos: 1600, 2000, 2400, 2024. No años bisiestos: 1700, 1800, 1900, 2021..\)

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> public class Ejemplo21 {
> 	public static void main(String[] args) {
> 		int anyo;
> 		/*
> 		 * Este tipo de variables se llaman banderas o flags, y sirven para marcar situaciones
> 		 * En este caso, queremos probar que un año es bisiesto, por lo que en principio suponemos
> 		 * que no lo es
> 		 */
> 		boolean esBisiesto = false;
> 		Scanner miScanner = new Scanner(System.in);
> 		/*
> 		 * 1.- RECOGER DATOS 
> 		 */
> 		System.out.println("Introduce un año:");
> 		anyo = miScanner.nextInt();
> 		miScanner.close();
> 
> 		/*
> 		 * 2.- PROCESAR DATOS 
> 		 * Resumiendo: Si el año es múltiplo de 400 (que entonces también lo es de 100 y 4), es bisiesto
> 		 * 				O el año es múltiplo de 4 pero no de 100
> 		 */
> 		if ((anyo % 400 == 0 ) || ((anyo % 4 == 0 ) && (anyo % 100 != 0 ))) {
> 			//Cambiamos la bandera
> 			esBisiesto = true;
> 		}
> 	
> 		/*
> 		 * 3.- IMPRIMIR RESULTADOS
> 		 */
> 		if (esBisiesto) {
> 			 System.out.println("Es bisiesto");
> 		}else {
> 			 System.out.println("No es bisiesto");
> 		}
> 
> 	}
> }
> ```

> -info-En este programa hemos usado un tipo de variable llamada **bandera (flag)**, que se fija a false y luego a true si se cumple alguna condición.
>
> Es este caso hemos supuesto que el año **no es bisiesto** y luego comprobamos si lo es.

# Estructuras Iterativas \(loops\)

Las estructuras iterativas alteran el flujo normal de ejecución de un algoritmo, haciendo posible que un bloque de acciones o instrucciones se ejecuten un cierto número de veces, dependiendo del cumplimiento de una condición. Veremos 3 tipos de iteraciones:

* While
* Until
* For 

## While

Un bloque de acciones se ejecuta mientras una condición se evalúa como verdadera. La condición se evalúa siempre antes de entrar en el bucle, lo que hace posible que el bloque de acciones nunca se ejecutan si la condición se evalúa como falsa al principio.  
A veces, no sabemos de antemano el número de veces que se ejecutará el bucle.  
![](/programacion-java/assets/img/java-basico/while.png)

```java
i = 0;
while (i < 10) {
    num = miScanner.nextInt();
    if (num >= 0) {
        positives = positives + 1;
    }
    i = i + 1;
}
```

## Until

Se ejecuta un bloque de acciones hasta que una condición se evalúa como verdadera. La condición se evalúa siempre al final del bucle, lo que hace que el bloque de acciones se ejecutan al menos una vez.  
A veces, no sabemos de antemano el número de veces que se ejecutará el bucle.  
![](/programacion-java/assets/img/java-basico/until.png)

```java
i = 0;
do  {
    num = miScanner.nextInt();
    if (num >= 0) {
        positives = positives + 1;
    }
    i = i + 1;
}while (i < 10)
```

## For

En este tipo de bucle el número de veces que el bloque de instrucciones será ejecutado se conoce de antemano. Es un caso particular de una estructura de While.

* A una variable llamada contador se le asigna un valor inicial.
* La condición se evalúa utilizando ese contador como: contador &lt;= valor\_final
* En cada iteración la variable del contador se incrementa por un valor fijo \(incremento\).
  ![](/programacion-java/assets/img/java-basico//for.png)

```java
for (int i = 0; i < 10; i++) {
    num = miScanner.nextInt();
    if (num >= 0) {
        positives = positives + 1;
    }
}
```

Os dejo el vídeo de [Píldoras Informáticas](https://www.youtube.com/watch?v=HQz8xwAjCsI&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=18) donde explica los bucles. Mirad además los otros vídeos de la colección a partir de este, donde explica el resto de bucles. Si algo no lo entendéis, haced un *salto de fe*

<iframe width="560" height="315" src="https://www.youtube.com/embed/HQz8xwAjCsI" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

## 22 Números positivos

Escribe un programa que pida al usuario 10 números y que muestre cuántos son positivos.

> -info-En este caso como sabemos cuántas veces lo hacemos (10) usamos un bucle `for`
>
> Además, necesitamos *guardar* el valor del número de positivos

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> /*
>  * Escribe un programa que pida al usuario 10 números y que muestre cuántos son positivos
>  */
> public class Ejemplo22 {
>     public static void main(String[] args)
>     {	
> 		int numero;
> 		/*
> 		 * La variable "positivos" es un "contador" que se inicializa a 0
> 		 */
> 		int positivos = 0;
> 		Scanner miScanner = new Scanner(System.in);
> 		
> 		System.out.println("Introduce 10 números enteros");
> 		
> 		for (int i = 0; i < 10; i++) {
> 			numero = miScanner.nextInt();
> 			if (numero >= 0){
> 				//Cuando encuentro un positivo, se aumenta la variable de tipo "contador"
> 				positivos++;
> 			}
> 		
> 		}
> 		miScanner.close();
> 		
> 		System.out.println("Ha introducido " + positivos + " números positivos");
> 		System.out.println("Ha introducido " + (10 - positivos) + " números negativos");	
>     }
> }
> ```

>-info-En este programa hemos usado un tipo de variable llamada **contador (counter)**, que se fija a 0 y se va incrementando si se cumple una condición

## 23 Números positivos II

Escribe un programa que pida al usuario n números y que muestre cuántos son positivos \(para acabar el programa, el usuario debe introducir el número 0)

> -info-Como de entrada no sabemos cuántas veces se va a hacer el bucle, usamos un `do ... while`

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> /*
>  * Escribe un programa que pida al usuario n números y que muestre cuántos son 
>  * positivos (para acabar el programa, el usuario debe introducir el número 0)
>  * 
>  */
> public class Ejemplo23 {
>     public static void main(String[] args)
>     {	
> 		int dato;
> 		/*
> 		 * Las dos variables siguientes son de tipo "contador"
> 		 */
> 		int positivos = 0;
> 		int cuantos = 0;
> 		Scanner miScanner = new Scanner(System.in);
> 		
> 		System.out.println("Introduce números enteros (para acabar introduce un 0)");
> 		//Como de entrada no sabemos cuántas veces se va a hacer el bucle, usamos un do ... while
> 		do{
> 			dato = miScanner.nextInt();
> 			if (dato != 0){
> 				if (dato > 0){
> 					positivos++;
> 				}
> 				cuantos++;
> 			}
> 		}while ( dato != 0);
> 		miScanner.close();
> 
> 		System.out.println("Ha introducido " + positivos + " números positivos");
> 		System.out.println("Ha introducido " + (cuantos - positivos) + " números negativos");
>     }
> }
> ```
>
> 

## 24 Nota media 

Diseña un algoritmo que lea un conjunto de notas del teclado hasta que se introduzca  -1 y muestre la nota media y si había un 10 o no.

> -info-Al igual que antes, como no conocemos cuántas veces se va a realizar (pero al menos se va a realizar una vez) usamos un `do...while`
>
> Para calcular la media, hemos de saber la suma de todas las notas y cuántas notas hay.
>
> Primero calcula la media y luego si hay un 10 o no

```java
import java.util.Scanner;
/*
 * Diseña un algoritmo que lea un conjunto de notas del teclado hasta 
 * que se introduzca -1 y muestre la nota media y si había un 10 o no. 
 */
public class Ejemplo24 {
    public static void main(String[] args)
    {	
		int nota;
		/* Esta variable es un contador */
		int cuantasNotas = 0;
		/* sumaNotas es un acumulador, que se inicializa a 0 para la suma, a 1 para la multiplicación
		 */
		int sumaNotas = 0;
		/*
		 * hayUnDiez es una variable de tipo bandera
		 */
		boolean hayUnDiez = false;
		Scanner miScanner = new Scanner(System.in);
		
		System.out.println("Introduce las notas (enteros) (para acabar introduce un -1)");
		//Como de entrada no sabemos cuántas veces se va a hacer el bucle, usamos un do ... while
		do{
			nota = miScanner.nextInt();
			if (nota != -1){
				sumaNotas += nota; //Equivale a sumaNotas = sumaNotas + nota;
				cuantasNotas++;
				if (10 == nota) {
					//cambiamos el valor de la bandera
					hayUnDiez = true;
				}
			}
		}while ( nota != -1);
		miScanner.close();
		
		System.out.println("La nota media es " + ((float)sumaNotas / (float)cuantasNotas));
		
		if (hayUnDiez) {
			System.out.println("Había al menos un 10 en las notas");
		}
    }
}
```



## 25 Factorial

Diseña un programa que calcule el factorial de un número

> -info-En este caso usamos un bucle `for` porque conocemos de antemano cuántas veces se debe realizar el algoritmo: el número que introduzca el usuario

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> /*
>  * Diseña un programa que calcule el factorial de un número
>  */
> public class Ejemplo25 {
> 
> 	
>     public static void main(String[] args)
>     {	
> 		int numero;
> 		// factorial es un acumulador, que se inicializa a 1 para la multiplicación 
> 		int factorial = 1;
> 		
> 		Scanner inputValue = new Scanner(System.in);
> 		
> 		System.out.println("Introduce un número entero:");
> 		numero = inputValue.nextInt();
> 		inputValue.close();
> 		
> 		//No hace falta empezar en 1, pues 1 * 1 = 1!!
> 		for (int i = 2; i <= numero; i++) {
> 			//Vamos acumulando el resultado
> 			factorial *= i;
> 		}
> 		
> 		System.out.printf("El factorial de %d es %d", numero, factorial);
>     }
> }
> ```
>
> 

## 26 Tabla de multiplicar

Escribe un programa que lea un número y escriba su tabla de multiplicación

```
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
5 x 4 = 20
5 x 5 = 25
5 x 6 = 30
5 x 7 = 35
5 x 8 = 40
5 x 9 = 45
5 x 10 = 50
```

> -info-Aquí también usaremos un bucle `for` porque sabemos cuántas veces se va a ejecutar el bucle

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> public class Ejemplo26 {
>     public static void main(String[] args)
>     {	
> 		int numero;		
> 		Scanner inputValue = new Scanner(System.in);
> 		
> 		System.out.println("Introduce un número entero entre el 1 y el 9:");
> 		numero = inputValue.nextInt();
> 		inputValue.close();
> 		
> 		for (int i = 1; i <= 10; i++) {
> 			System.out.printf("%d x %d = %d %n", numero, i, (numero * i));
> 		}
>     }
> }
> ```
>
> 

## 27 Impresión de números I

Diseña un algoritmo que lea un número ***n*** e imprima esto:  

```
1  
1 2  
1 2 3  
...  
1 2 3 4 5 ... n
```

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> public class Ejemplo27 {
>     public static void main(String[] args)
>     {	
> 		int numero;
> 		// resultado es un acumulador, que se inicializa a "" para las cadenas
> 		String resultado = "";
> 		Scanner miScanner = new Scanner(System.in);
> 		
> 		System.out.println("Introduce un número entero:");		
> 		numero = miScanner.nextInt();
> 		miScanner.close();
> 		
> 		for (int i = 1; i <= numero; i++) {
> 			//Vamos acumulando el resultado:
> 			// 1 
> 			// 1 2
> 			// 1 2 3 
> 			// ...
> 			resultado += i + " ";
> 			System.out.println(resultado);
> 		}		
>     }
> }
> ```



## 28 Números primos

Escribe un programa que muestre si un número es primo o no.  

Los números primos tienen la siguiente característica: un número primo es solamente divisible por sí mismo y por la unidad, por tanto, un número primo no puede ser par excepto el 2. 

Para saber si un número impar es primo, dividimos dicho número por todos los números impares comprendidos entre 3 y la mitad de dicho número. 

Por ejemplo, para saber si 13 es un número primo basta dividirlo por 3, y 5. Para saber si 25 es número primo se divide entre 3, 5, 7, 9, y 11. Si el resto de la división \(operación módulo %\) es cero, el número no es primo.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> public class Ejemplo28 {
>     public static void main(String[] args)
>     {	
> 		int numero;
> 		boolean esPrimo = true;
> 		Scanner inputValue = new Scanner(System.in);
> 		
> 		System.out.println("Introduce un número entero positivo:");
> 		numero = inputValue.nextInt();
> 		inputValue.close();
> 
> 		if ((numero == 1) || ((numero != 2 ) && (numero % 2 == 0))) {
> 			esPrimo = false;
> 		}else{
> 			//Sólo lo dividimos por los impares, hasta la mitad del número
> 		    for(int i=3; i <= (numero / 2); i+=2) {
> 				//Si el resto de la multiplicación es 0 es divisible
> 		        if(numero %i ==0){ 
> 		        	esPrimo = false;
> 					//Una vez sabemos que no es primo ya podemos salir del bucle
> 		        	break;
> 		        }
> 		    }
> 		}
> 	    if (esPrimo) {
> 	    	System.out.println("El número " + numero + " es primo");
> 	    }else {
> 	    	System.out.println("El número " + numero + " NO es primo");
> 	    }
>     }
> }
> ```

> -info-En este programa hemos usado la palabra reservada `break` que permite finalizar un bucle. En este caso, cuando sabemos que un número es divisible ya no hace falta continuar el bucle pues ya sabemos la solución:  no es primo.

## 29 Números primos II

Realiza un programa que imprima todos los números primos entre 3 y 100.

Este caso es una unión del algoritmo anterior pero repetido un número determinado de veces. Por tanto, usamos un bucle `for` 

> -toogle-Piensa antes de mirar
>
> 

## 30 Palíndromo (avanzado)

Realiza un programa que averigüe si una palabra o frase es palíndroma. Para averiguar el número de caracteres de una cadena se usa el método `length()` y para acceder al carácter iésimo usa la función `chartAt()`

> -toogle-Piensa antes de mirar
>
> ```java
> 
> import java.util.Scanner;
> public class Ejemplo30 {
>     public static void main(String[] args)
>     {
>     	boolean esPalindromo = true;
>     	Scanner miScanner = new Scanner(System.in);
>     	
>     	System.out.println("Introduzca una cadena:");
>     	   	
>         String cadena = miScanner.nextLine();
>         miScanner.close();
>         
> 	    for (int i = 0; i < (cadena.length() / 2); i++) {
> 	    	//Recorremos la mitad de la cadena y comparamos el valor primer valor con el último
> 	    	//el segundo con el penúltimo, etc
> 	    	//En el momento que alguno no coincida ya podemos parar porque la palabra no es palíndroma
> 	    	if (cadena.charAt(i) != cadena.charAt(cadena.length() - i - 1)) {
> 	    		esPalindromo = false;
> 	    		break;
> 	    	}
> 	    }
> 	    if (esPalindromo) {
> 	    	System.out.println("La cadena es palíndroma");
> 	    }else {
> 	    	System.out.println("La cadena NO es palíndroma");
> 	    }
>     }
> }
> ```
>Fíjate en `cadena.charAt(cadena.length() - i - 1)` Es el iésimo carácter empezando por el final. Recuerda que el primer carácter es 0 

## 31 Divisores

Realiza un programa que pida un número natural y escriba sus divisores

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> public class Ejemplo31 {
> 
> 	public static void main(String[] args){	
> 		Scanner miScanner = new Scanner(System.in);
> 		System.out.println("Introduce un número entero:");
> 
> 		int numero = miScanner.nextInt();
> 		miScanner.close();
> 			
> 		//Hacemos un bucle hasta la mitad del número (un divisor no puede ser mayor que la mitad!)
> 		System.out.println("Divisores de " + numero);
> 		//Hay que revisar siempre los límites de los bucles!!
> 		for (int i = 1; i <= numero / 2; i++) {
> 			if ((numero % i) == 0) {
>                 //"\t" imprime un tabulador
> 				System.out.println("\t" + i);
> 			}
> 		}
> 	}
> 
> }
> ```

## 32 Fibonacci

<iframe width="560" height="315" src="https://www.youtube.com/embed/Pp6D-xhJr4A" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

![](/programacion-java/assets/img/java-basico//fibonacci.png)

Diseña un programa que muestre los primeros 40 términos de la serie de [Fibonacci](https://es.wikipedia.org/wiki/Sucesión_de_Fibonacci)

> -toogle-Piensa antes de mirar
>
> ```java
> public class Ejemplo32 {
> 	public static void main(String[] args) {
> 		int fibonacci= 0;
> 		
> 		int n1 = 1;
> 		int n2 = 1;
> 		System.out.printf("1 %n1 %n");
> 		for (int i = 0; i < 40; i++) {
> 			fibonacci = n1 + n2;
> 			System.out.println(fibonacci);
>             //Ahora intercambiamos los valores, proceso que se llama swap para 
>             //la siguiente iteración
> 			n1 = n2;
> 			n2 = fibonacci;
> 		}
> 	}
> }
> ```

> -info-Este programa utiliza una técnica usada mucho en programación que se denomina **_swap_** y que consiste en intercambiar el valor de dos variables usando una variable auxiliar.  

## 33 Número Áureo

Modifica el programa anterior para que muestre la relación \(división\) entre el valor n y el \(n - 1\) de la serie de Fibonacci (40 veces). Esta es una manera de obtener una aproximación al [Número Áureo](https://es.wikipedia.org/wiki/Número_áureo).

> -toogle-Piensa antes de mirar
>
> ```java
> 
> public class Ejemplo33 {
> 	public static void main(String[] args) {
> 		
> 		int n1 = 1;
> 		int n2= 1;
> 		int fibonacci;
> 		
> 		for (int i = 0; i < 40; i++) {
> 			fibonacci = n1 + n2;
>             //Como queremos realizar una operación con decimales,
>             //hacemos un cast a double
> 			System.out.println((double)fibonacci / (double)n2);
> 			n1 = n2;
> 			n2 = fibonacci;
> 		}
> 
> 	}
> 
> }
> ```

> -info-En este ejercicio hemos usado una técnica llamada `cast` que consiste en convertir o promocionar un tipo de dato en otro. En este caso estamos convirtiendo un dato de tipo `int` en otro de tipo `double`. Si no lo hiciéramos así, sólo devolvería un número entero



## 34 Sumas sucesivas 

Realiza un programa que calcule la multiplicación de dos números usando el método de las sumas sucesivas

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> public class Ejemplo34 {
>     public static void main(String[] args)
>     {	
>     	Scanner miScanner = new Scanner(System.in);
> 		int x;
> 		int y;
> 		
> 		System.out.println("Introduce un número");
> 		x = miScanner.nextInt();
> 		
> 		System.out.println("Introduce otro número");
> 		y = miScanner.nextInt();
> 		
> 		miScanner.close();
> 
> 		// La variable `mul` es un acumulador, 
>         // inicializada en este caso al primer número `x`
> 		int mul = x;
> 		
> 		for (int i = 1; i < y; i++) {
> 			//Vamos sumando tantas veces como indique `y` 
>             //(es decir, multiplicando)
> 			mul += x;
> 		}
> 		System.out.printf("%d x %d = %d", x, y, mul);
> 	}
> 
> }
> ```



## 35 Restas sucesivas

Realiza un programa que calcule el resto de una división usando el método de las restas sucesivas.

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> public class Ejemplo35 {
>     public static void main(String[] args)
>     {	
>     	Scanner miScanner = new Scanner(System.in);
>     	
>     	int dividendo;
> 		int divisor;
> 		
> 		System.out.println("Introduce el dividendo");
> 		dividendo = miScanner.nextInt();
> 		
> 		System.out.println("Introduce el divisor");
> 		divisor = miScanner.nextInt();
> 		
> 		miScanner.close();
> 		
> 		//Resto también es un acumulador, aunque vamos restando
> 		int resto = dividendo;
> 		while(resto >= divisor){
> 			resto -= divisor;
> 		}
> 		System.out.printf("El resto de dividir %d entre %d es %d", dividendo, divisor, resto);
> 	}
> 
> }
> ```

## 36 Decimal a binario (avanzado)

Realiza un programa que lea un número entero decimal (máximo 255) e imprima su valor en binario

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> public class Ejemplo36 {
> 
> 	public static void main(String[] args) {
> 		Scanner miScanner = new Scanner(System.in);
> 		int numero, digito;
> 		//binario es de tipo acumulador
> 		String binario = "";
> 		System.out.println("Introduce un número entero >= 0: ");
> 		numero = miScanner.nextInt();
>         miScanner.close();
> 
> 		while (numero != 0) {
>             //Cogemos el resto de la división para saber si 
>             //el resultado es el bit 0 o 1
> 			digito = numero % 2;
> 			binario = digito + binario;
>             //El siguiente número será el cociente
>             //de la división entera
> 			numero = numero / 2;
> 		}
> 		System.out.printf("Binario: %s", binario);
> 	}
> }
> ```

## 37 Binario a decimal (avanzado)

Realiza un programa que lea una cadena de números binarios y calcule su valor en decimal

> -toogle-Piensa antes de mirar
>
> ```java
> import java.util.Scanner;
> 
> public class Ejemplo37 {
> 	 public static void main(String[] args){
> 		 	Scanner miScanner = new Scanner(System.in);
> 		   	int decimal = 0;
> 		    int potencia = 0;
> 		    
> 		    /*
> 		     * En este primera versión deñ algoritmo 
>              * vamos a leer en número como una cadena
> 		     */
> 		    System.out.println("Introduce un número binario ");
> 		    
> 		   	String binario = miScanner.next();
> 		   	miScanner.close();
> 		   	
> 		   	char bit;
>             //Empezamos por el bit menos significativo (el último)
> 		   	for (int i = binario.length() - 1; i >= 0; i--) {
>                 /* El último bit se eleva a 0,
> 				 * el antepenúltimo a 1, ...
>                  */
> 		   		bit = binario.charAt(i);
> 		   		potencia = (binario.length() - 1) - i;
> 		   		if (bit == '1') {
> 		   			decimal += Math.pow(2, potencia);
> 		   		}
> 		   		
> 		   		//El siguiente código comentado es sin usar variables
> 		   		/*
> 		   		if (binario.charAt(i) == '1') {
> 		   			decimal += Math.pow(2, (binario.length() - 1) - i);	
> 		   		}
> 		   		*/
> 		   		
> 		   	}
> 		   	System.out.printf("Método I.- El número %s en binario es %d %n", binario, decimal);
> 		   	
> 		  
> 		   	/*
> 		   	 * En este segundo método, ahora el binario está en formato decimal (int)
> 		   	 * o con binarioEntero = miScaner.nextInt()
> 		   	 */
> 		    int binarioEntero =  Integer.parseInt(binario);
> 	       
> 	        decimal = 0;
> 	        potencia = 0;
> 	        while (binarioEntero != 0) {
> 	        	//En ultimoDigito tenemos un 0 o un 1
> 	            int ultimoDigito = binarioEntero % 10;
> 	            //Lo elevamos a la potencia actual
> 	            decimal += ultimoDigito * Math.pow(2, potencia);
> 	            //Aumentamos la potencia
> 	            potencia++;
> 	            //Dividimos el número entre 10 (división entera) por lo le quitamos el últmo dígito
> 	            binarioEntero = binarioEntero / 10;
> 	        }
> 	        System.out.printf("Método II.- El número %s en binario es %d %n", binario, decimal);
> 	 }
> }
> ```

## 38 Juego Adivina un número  (avanzado)

Diseña un algoritmo para jugar a "adivinar un número". El algoritmo generará un número _aleatorio_ entre 1 y 100, que llamaremos el número secreto, y le pedirá al jugador que introduzca un número hasta que gane o un -1 para rendirse:

* Si el número es igual al número secreto, mostrará "Has Ganado" en la pantalla y terminará
* Si el número introducido es mayor que el número secreto, mostrará "El número secreto es más pequeño" y le pedirá que introduzca otro.
* Si el número introducido es menor que el número secreto, mostrará "El número secreto es más grande" y le pedirá que introduzca otro.
* Si el número introducido es -1, mostrará "Se rinde" y terminará

Para generar un número aleatorio usa este código.

```java
import java.util.Random;
---
Random aleatorio = new Random(System.currentTimeMillis());
// Producir nuevo int aleatorio entre 0 y 99
int secreto = aleatorio.nextInt(100);
```

Como no sabemos cuántas veces se va a realizar el bucle, usamos un `do..while` 

> -toogle-Piensa antes de mirar
>
> ```java
> 
> import java.util.Random;
> import java.util.Scanner;
> 
> public class Ejemplo38 {
> 	public static void main(String[] args) {
> 		Scanner miScanner = new Scanner(System.in);
> 		
> 		int numero = -1;
> 		
> 		boolean haGanado = false;
> 		
> 		Random aleatorio = new Random(System.currentTimeMillis());
> 	    // Producir nuevo int aleatorio entre 0 y 99
> 	    int secreto = aleatorio.nextInt(100);
> 	    do {
> 			System.out.println("Introduce un número (-1 para rendirse)");
> 			numero = miScanner.nextInt();
> 
> 			if (numero != -1) {
> 				if (numero > secreto) {
> 					System.out.println("El número secreto es más pequeño");
> 				}else if (numero < secreto) {
> 					System.out.println("El número secreto es más grande");
> 				}else {
> 					System.out.println("Has Ganado");
> 					haGanado = true;
> 				}
> 			}else {
> 				System.out.println("Se rinde");
> 			}
> 	    } while (!haGanado && (numero != -1));
> 	    
> 	    miScanner.close();
> 	}
> }
> ```
> > -info-Este programa es el típico en el que se aprecia la descomposición de un algoritmo en partes más sencillas.
> >
> > Si analizas el código, verás que solo usas estructuras ya conocidas.
> >
> > El problema es que no sabéis descomponerlo en partes y esto es muy complicado de enseñar. Sólo la práctica te hará maestro.
> >
> > El primer paso sería empezar a generar un número aleatorio. Como no sé, pues busco en Internet `java random`
> >
> > El segundo paso sería generar el bucle que lee. Ya sabemos que debe ser `do..while` porque no sabemos cuántas veces se repite pero sabemos que al menos se va a realizar una vez
> >
> > ```java
> > do {
> >     System.out.println("Introduce un número (-1 para rendirse)");
> >     numero = miScanner.nextInt();
> > 
> > } while (numero != -1);
> > ```
> >
> > Y por último, completaríamos el algoritmo del bucle
> >
> > ```java
> > do {
> >     System.out.println("Introduce un número (-1 para rendirse)");
> >     numero = miScanner.nextInt();
> > 
> >     if (numero != -1) {
> >         if (numero > secreto) {
> >             System.out.println("El número secreto es más pequeño");
> >         }else if (numero < secreto) {
> >             System.out.println("El número secreto es más grande");
> >         }else {
> >             System.out.println("Has Ganado");
> >             haGanado = true;
> >         }
> >     }else {
> >         System.out.println("Se rinde");
> >     }
> > } while (!haGanado && (numero != -1));
> > ```

