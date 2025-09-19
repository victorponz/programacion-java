---
typora-copy-images-to: ../assets/img/java-basico/
typora-root-url: ../../
layout: post
title: Primeros pasos en Java
categories: parte1
conToc: true
permalink: primeros-pasos-en-java
---
> -info-En esta unidad aprenderemos a usar los tipos básicos de datos en java, a usar librerías para leer la entrada del teclado y la diferencia entre una variable y una constante. También se introducen los [diagramas de flujo](https://es.wikipedia.org/wiki/Diagrama_de_flujo) \(_flowcharts_\) y aprendemos las [estructuras condicionales](#Estructuras condicionales \(if\)).

## 1 Un programa que calcula una división y una suma.

El primer concepto que afrontamos el un programa es que **todos trabajan con datos de entrada, realizan un proceso y producen una salida**.

> -hint-**Variable**
>
> Cada vez que necesitamos *acordarnos* de un dato, lo hemos de almacenar en una variable.

![1536599756984](/programacion-java/assets/img/java-basico/1536599756984.png)

## 2 Un programa que calcula una división y una suma \(enteros\).

![1536599861891](/programacion-java/assets/img/java-basico/1536599861891.png)

> -info-[Tipos de datos en java](https://www.campusmvp.es/recursos/post/variables-y-tipos-de-datos-en-java-tipos-simples-clases-y-tipos-envoltorio-o-wrapper.aspx)

## 3 Un programa que calcula y muestra el área de un cuadrado de lado 5 (F) 

<span style='color:green'>(ra1.a)</span>

```flow
st=>start: Start:
e=>end: End:
op1=>operation: area = 5 * 5 
io=>inputoutput: Escribe area
st->op1->io->e
```


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

## 4 Un programa que calcula y muestra el área de un cuadrado cuyo lado se introduce por pantalla (F)

 <span style='color:green'>(ra1.a, ra5.a, ra5.c)</span>

![](/programacion-java/assets/img/java-basico//ej3.png)


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

## 5 Un programa que lea dos números enteros y muestre el resultado de sumarlos, restarlos, multiplicarlos y dividirlos (F)

 <span style='color:green'>(ra1.a, ra5.a)</span>

> -info-[Operadores en Java](https://www.w3schools.com/java/java_operators.asp)

![](/programacion-java/assets/img/java-basico//ej4-prop.png)

## 6 Un programa que pida el radio de una circunferencia y muestre su área y su perímetro (F)

<span style='color:green'>(ra1.a, ra1.f, ra5.a)</span>

![](/programacion-java/assets/img/java-basico//ej5-prop.png)

> -info-
>
> **Nota**. Para definir el valor de PI usad la constante PI `Math.PI`

>  -info-**Definir constantes en java**
>
> [http://lineadecodigo.com/java/constantes-en-java/](http://lineadecodigo.com/java/constantes-en-java/)

## 7 Un programa que pida el precio real de un producto, el precio rebajado y muestre el descuento realizado (M)

 <span style='color:green'>(ra1.a, ra1.c, ra.5a)</span>

![](/programacion-java/assets/img/java-basico//ej6b.png)


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

## 8 Realiza un programa que pida la edad al usuario y muestre un mensaje si es mayor de **edad** (F)

<span style='color:green'>(ra1.a, ra1.c, ra3.a, ra3.e)</span>

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
## 9 Igual que el anterior pero que también muestre un mensaje si es menor de edad (F) 

<span style='color:green'>(ra1.a, ra1.c, ra3.a, ra3.e)</span>

![](/programacion-java/assets/img/java-basico//ej9.png)

## 10 Diseña un algoritmo que lea un valor y muestre si es positivo o negativo \(0 es positivo\) (F) 

<span style='color:green'>(ra1.a, ra1.c, ra3.a, ra3.e)</span>

## 11 Diseña un algoritmo que lea dos valores y los muestre en orden ascendente. (M)

<span style='color:green'>(ra1.a, ra1.c, ra3.a, ra3.e)</span>

## 12 Diseña un algoritmo que lea dos valores y muestre el más grande de ellos. (F)

 <span style='color:green'>(ra1.a, ra1.c, ra3.a, ra3.e)</span>

## 13 Realiza un programa que lea dos valores y los orden ascendente o descendentemente según elija el usuario. (M)

 <span style='color:green'>(ra1.a, ra1.c, ra3.a, ra3.e)</span>

En este caso necesitamos *acordarnos* de tres cosas:

* Los dos números a comparar
* El orden (por ejemplo: 1 para Ascendente y otro cualquiera para descendente)
* Para hacer el programa sigue estas fases:
  1. Lee los datos del teclado
  2. Ahora haz el algoritmo para cuando el orden es Ascendente
  3. Una vez te funcione, crea la sentencia `if` y ahora realiza la sentencia `else` para ordenar descendentemente.
  4. Comprueba que todo funciona bien.
  
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

## 14 Diseña un algoritmo que lea un valor numérico entero correspondiente a la nota de un examen y muestre su valor en letra: (M)

<span style='color:green'>(ra1.a, ra1.c, ra3.a, ra3.e)</span>

de 0 a 3 Muy Deficiente.

de 3 a 5 Insuficiente.

de 5 a 6 Suficiente.

de 6 a 7 Bien

de 7 a 9 Notable

de 9 a 10 Sobresaliente

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

## 15 Realiza un programa que lea un número entero del 1 al 10 y que muestre su valor en letra. (F)

<span style='color:green'>(ra1.a, ra1.c, ra3.a, ra3.e)</span>

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
> 	break;
> case 4:
> 	....
> ```

## 16 Realiza un programa que lea dos números enteros y dependiendo de la operación que indique el usuario \(+, -, \* , /\) muestre el resultado (M) 

<span style='color:green'>(ra1.a, ra1.c, ra3.a, ra3.e)</span>

En este caso nos hemos de *acordar* de tres cosas:

* Dos números (por ejemplo, de tipo `int`)

* Una operación (en este caso usaremos el tipo `String`). Para leer un dato de tipo `String` usamos el método `inputValue.next()` 

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

## 17 Realiza un programa que pida al usuario un mes e imprima el número de días que tiene. (F)

<span style='color:green'>(ra1.a, ra1.c, ra3.a, ra3.e)</span>

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
## 18 Diseña un algoritmo que recibe horas, minutos y segundos y muestra horas, minutos y segundos resultantes de la adición de un segundo. (M)

 <span style='color:green'>(ra1.a, ra1.c, ra3.a, ra3.e)</span>

Este problema parece trivial, ¿no?. Cojo una horas, minutos, segundos y el sumo 1. Y si resulta que ahora tengo 60 segundos? ¿Y si ahora tengo 60 minutos? Ya no parece tan simple. Pero seguro que en tu cabeza lo ves claro. El problema es que todavía no tienes práctica en traducir tus pensamientos a código. Poco a poco. Al memos haz el algoritmo para sumar un minuto si los segundos suman 60 ahora.
## 19 Diseña un algoritmo que calcule el salario neto de un trabajador en función del número de horas de trabajo y los impuestos según las siguientes reglas: (D) 

<span style='color:green'>(ra1.a, ra1.c, ra1.d, ra1.e, ra1.g, ra3.a, ra3.e)</span>

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

## 20 Precio final (M)

<span style='color:green'>(ra1.a, ra1.c, ra1.d, ra1.e, ra1.g, ra3.a, ra3.e)</span>

Un cierto comercio hace un descuento dependiendo del precio de cada producto. Si el precio es inferior a 6 euros no hay descuento. Si es mayor o igual a 6 euros  y menos de 60 €, se aplica un 5% de descuento, y si es mayor o igual a 60 € se aplica  un 10% de descuento. Diseña el algoritmo para calcular el precio final.
## 21 Año bisiesto (D)

<span style='color:green'>(ra1.a, ra1.c, ra1.d, ra1.e, ra1.g, ra3.a, ra3.e)</span>

Diseña un algoritmo que lea un año como dato de entrada y que muestre si es un año bisiesto o no. Todos los múltiplos de 400 o los que son múltiples de 4 pero no de 100 son bisiestos.

(Ej. Años bisiestos: 1600, 2000, 2400, 2024. No años bisiestos: 1700, 1800, 1900, 2021..\)
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
num = inputValue.nextInt();
while (num != 0) {
    if (num >= 0) {
        positives = positives + 1;
    }
    num = inputValue.nextInt();
}
```

## Until

Se ejecuta un bloque de acciones hasta que una condición se evalúa como verdadera. La condición se evalúa siempre al final del bucle, lo que hace que el bloque de acciones se ejecutan al menos una vez.  
A veces, no sabemos de antemano el número de veces que se ejecutará el bucle.  
![](/programacion-java/assets/img/java-basico/until.png)

```java
do {
    num = inputValue.nextInt();
    if (num >= 0) {
        positives = positives + 1;
    }
}while (num != 0);
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

## 22 Números positivos (M)

<span style='color:green'>(ra1.a, ra1.c, ra1.d, ra1.e, ra1.g, ra3.a, ra3.b, ra3.e)</span>

Escribe un programa que pida al usuario 10 números y que muestre cuántos son positivos.

> -info-En este caso como sabemos cuántas veces lo hacemos (10) usamos un bucle `for`
>
> Además, necesitamos *guardar* el valor del número de positivos

>-info-En este programa hemos usado un tipo de variable llamada **contador (counter)**, que se fija a 0 y se va incrementando si se cumple una condición

## 23 Números positivos II (M)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.b, ra3.e)</span>

Escribe un programa que pida al usuario n números y que muestre cuántos son positivos \(para acabar el programa, el usuario debe introducir el número 0)

> -info-Como de entrada no sabemos cuántas veces se va a hacer el bucle, usamos un `do ... while`

## 24 Nota media (M) 

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.b, ra3.f)</span>

Diseña un algoritmo que lea un conjunto de notas del teclado hasta que se introduzca  -1 y muestre la nota media y si había un 10 o no.

> -info-Al igual que antes, como no conocemos cuántas veces se va a realizar (pero al menos se va a realizar una vez) usamos un `do...while`
>
> Para calcular la media, hemos de saber la suma de todas las notas y cuántas notas hay.
>
> Primero calcula la media y luego si hay un 10 o no

## 25 Factorial (D)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

Diseña un programa que calcule el factorial de un número

> -info-En este caso usamos un bucle `for` porque conocemos de antemano cuántas veces se debe realizar el algoritmo: el número que introduzca el usuario

## 26 Tabla de multiplicar (M)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

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

## 27 Impresión de números I (M)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

Diseña un algoritmo que lea un número ***n*** e imprima esto:  

```
1  
1 2  
1 2 3  
...  
1 2 3 4 5 ... n
```

## 28 Números primos (D)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

Escribe un programa que muestre si un número es primo o no.  

Los números primos tienen la siguiente característica: un número primo es solamente divisible por sí mismo y por la unidad, por tanto, un número primo no puede ser par excepto el 2. 

Para saber si un número impar es primo, dividimos dicho número por todos los números impares comprendidos entre 3 y la mitad de dicho número. 

Por ejemplo, para saber si 13 es un número primo basta dividirlo por 3, y 5. Para saber si 25 es número primo se divide entre 3, 5, 7, 9, y 11. Si el resto de la división \(operación módulo %\) es cero, el número no es primo.
> -info-En este programa hemos usado la palabra reservada `break` que permite finalizar un bucle. En este caso, cuando sabemos que un número es divisible ya no hace falta continuar el bucle pues ya sabemos la solución:  no es primo.

## 29 Números primos II (D)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

Realiza un programa que imprima todos los números primos entre 3 y 100.

Este caso es una unión del algoritmo anterior pero repetido un número determinado de veces. Por tanto, usamos un bucle `for` 
## 30 Palíndromo (D)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

Realiza un programa que averigüe si una palabra o frase es palíndroma. Para averiguar el número de caracteres de una cadena se usa el método `length()` y para acceder al carácter iésimo usa la función `chartAt()`

## 31 Divisores (M) 

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

Realiza un programa que pida un número natural y escriba sus divisores

## 32 Fibonacci (M) 

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

<iframe width="560" height="315" src="https://www.youtube.com/embed/Pp6D-xhJr4A" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

![](/programacion-java/assets/img/java-basico//fibonacci.png)

Diseña un programa que muestre los primeros 40 términos de la serie de [Fibonacci](https://es.wikipedia.org/wiki/Sucesión_de_Fibonacci)

## 33 Número Áureo (M)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

Modifica el programa anterior para que muestre la relación \(división\) entre el valor n y el \(n - 1\) de la serie de Fibonacci (40 veces). Esta es una manera de obtener una aproximación al [Número Áureo](https://es.wikipedia.org/wiki/Número_áureo).

## 34 Sumas sucesivas (M) 

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

Realiza un programa que calcule la multiplicación de dos números usando el método de las sumas sucesivas

## 35 Restas sucesivas (M)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

Realiza un programa que calcule el resto de una división usando el método de las restas sucesivas.

## 36 Decimal a binario (D)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

Realiza un programa que lea un número entero decimal (máximo 255) e imprima su valor en binario

## 37 Binario a decimal (D)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

Realiza un programa que lea una cadena de números binarios y calcule su valor en decimal

## 38 Juego Adivina un número  (D)

<span style='color:green'>(ra1.a, ra1.d, ra1.e, ra1.g, ra1.c, ra3.a, ra3.e, ra3.f)</span>

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

## 39 Triángulos (M)

Los triángulos se clasifican en 3 tipos:

* Si **todos los ángulos < 90°** → acutángulo.

* Si **uno de los ángulos > 90°** → obtusángulo.

* Si **uno de los ángulos = 90°** → rectángulo. 

![](https://aceptaelreto.com/pub/problems/v001/80/st/statements/Spanish/TiposDeTriangulos.svg)

Además, dados tres lados, no siempre se puede construir un triángulo:

```
Los tres lados a,b,c deben cumplir la desigualdad triangular:
a + b > c, a + c > b, b + c > a
```
Una vez sabemoa que se puede formar un triángulo, la forma más sencilla de clasificarlos es a partir de la longitud de los lados.

```
Sea un triángulo con lados a, b, c donde c es el mayor lado:

Si c² < a² + b² → el triángulo es acutángulo.
Si c² = a² + b² → es rectángulo.
Si c² > a² + b² → es obtusángulo.
```

Haz un programa que, a partir de la longitud de 3 lados, nos diga qué tipo de triángulo es.

```
3 4 4 -> ACUTÁNGULO
5 3 4 -> RECTÁNGULO
3 4 6 -> OBTUSÁNGULO
3 4 7 -> IMPOSIBLE
```

**Fuente:** [https://aceptaelreto.com/problem/statement.php?id=180&cat=5](https://aceptaelreto.com/problem/statement.php?id=180&cat=5)
