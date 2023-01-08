---
typora-copy-images-to: ./programacion-java/assets/img/tecnicas/
typora-root-url: ../../
layout: post
title: Técnicas útiles
categories: varios
conToc: true
permalink: tecnicas-utiles
---

## StringBuilder

Vamos a analizar el siguiente programa:

```java
String numbers = "";
for (int i = 1; i < 5; i++) {
    numbers = numbers + i;
}
System.out.println(numbers);
```

La estructura del programa es sencilla. Se crea una cadena que contiene el número 1234 y luego se imprime la cadena.

El programa funciona, pero hay un pequeño problema invisible para el usuario. Llamar a `numbers + i` crea una nueva cadena. Inspeccionemos el programa línea por línea con el bloque de repetición desempaquetado.

```java
String numbers = ""; // creating a new string: ""
int i = 1;
numbers = numbers + i; // creating a new string: "1"
i++;
numbers = numbers + i; // creating a new string: "12"
i++;
numbers = numbers + i; // creating a new string: "123"
i++;
numbers = numbers + i; // creating a new string: "1234"
i++;

System.out.println(numbers); // printing the string
```

En el ejemplo anterior, se crean cinco cadenas en total.

Miremos el mismo programa donde se agrega una nueva línea después de cada número.

```java
String numbers = "";
for (int i = 1; i < 5; i++) {
    numbers = numbers + i + "\n";
}
System.out.println(numbers);
```

Cada operación `+` forma una nueva cadena. En las líneas `numbers + i + "\n"`; primero se crea una cadena, después de lo cual se crea otra cadena que une una nueva línea a la cadena anterior. Escribamos esto también.

```java
String numbers = ""; // creating a new string: ""
int i = 1;
// first creating the string "1" and then the string "1\n"
numbers = numbers + i + "\n";
i++;
// first creating the string "1\n2" and then the string "1\n2\n"
numbers = numbers + i + "\n"
i++;
// first creating the string "1\n2\n3" and then the string "1\n2\n3\n"
numbers = numbers + i + "\n"
i++;
// and so on
numbers = numbers + i + "\n"
i++;

System.out.println(numbers); // outputting the string
```

En el ejemplo anterior, se crean un total de **nueve cadenas**.

La creación de cadenas, aunque imperceptible a pequeña escala, no es una operación rápida. Se asigna espacio en la memoria para cada cadena donde luego se coloca la cadena. Si la cadena solo se necesita como parte de la creación de una cadena más grande, se debe mejorar el rendimiento.

La clase `StringBuilder` lista para usar de Java proporciona una forma de concatenar cadenas sin necesidad de crearlas. Se crea un nuevo objeto `StringBuilder` con una nueva llamada a `StringBuilder()` y se agrega contenido al objeto utilizando el método de `append` sobrecargado, es decir, hay variaciones del mismo para diferentes tipos de variables. Finalmente, el objeto `StringBuilder` proporciona una cadena utilizando el método `toString`.

En el siguiente ejemplo, solo se crea una cadena.

```java
StringBuilder numbers = new StringBuilder();
for (int i = 1; i < 5; i++) {
    numbers.append(i);
}
System.out.println(numbers.toString())
```

Usar `StringBuilder` es más eficiente que crear cadenas con el operador `+`.

## Expresiones regulares

Una expresión regular define un conjunto de cadenas en forma compacta. Las expresiones regulares se utilizan, entre otras cosas, para verificar la corrección de las cadenas. Podemos evaluar si una cadena está o no en la forma deseada usando una expresión regular que define las cadenas consideradas correctas.

Veamos un problema en el que necesitamos verificar si un número de estudiante ingresado por el usuario está en el formato correcto. Un número de estudiante debe comenzar con "01" seguido de 7 dígitos entre 0 y 9.

Podrías verificar el formato del número de estudiante, por ejemplo, revisando la cadena de caracteres que representa el número de estudiante usando el método `charAt`. Otra forma sería verificar que el primer carácter sea "0" y llamar al método I`nteger.valueOf` para convertir la cadena en un número. A continuación, puedes comprobar que el número devuelto por el método `Integer.valueOf` es inferior a 20000000.

La verificación de la corrección con la ayuda de expresiones regulares se realiza definiendo primero una expresión regular adecuada. Luego podemos usar el método `matches` de la clase `String`, que verifica si la cadena coincide con la expresión regular dada como parámetro. Para el número de estudiante, la expresión regular adecuada es `01[0-9]{7}`, y la verificación del número de estudiante ingresado por un usuario se realiza de la siguiente manera:

```java
System.out.print("Provide a student number: ");
String number = scanner.nextLine();

if (number.matches("01[0-9]{7}")) {
    System.out.println("Correct format.");
} else {
    System.out.println("Incorrect format.");
}
```

En este `01[0-9]{7}` hay dos partes:

* `01` que es una cadena literal
* `[0-9]{7}`  que especifica un carácter del 0 al 9 y que se repita 7 veces

Repasemos los caracteres más comunes utilizados en las expresiones regulares.

### Alternancia (Línea Vertical)

Una línea vertical indica que partes de una expresión regular son opcionales. Por ejemplo, `00|111|0000` define las cadenas `00`, `111` y `0000`. El método de respuesta devuelve verdadero si la cadena coincide con cualquiera del grupo especificado de alternativas.

```java
String string = "00";

if (string.matches("00|111|0000")) {
    System.out.println("The string contained one of the three alternatives");
} else {
    System.out.println("The string contained none of the alternatives");
}
```

La expresión regular `00|111|0000` exige que la cadena sea exactamente lo que especifica; no hay ninguna funcionalidad "contiene".

```java
String string = "1111";

if (string.matches("00|111|0000")) {
    System.out.println("The string contained one of the three alternatives");
} else {
    System.out.println("The string contained none of the three alternatives");
}
```

Cuya salida es 

```
The string contained none of the three alternatives
```

### Afectar parte de una cadena (paréntesis)

Puedes usar paréntesis para determinar qué parte de una expresión regular se ve afectada por las reglas dentro de los paréntesis. Digamos que queremos permitir las cadenas `00000` y `00001`. Podemos hacerlo colocando una barra vertical entre ellas de esta manera `00000|00001`. Los paréntesis nos permiten limitar la opción a una parte específica de la cadena. La expresión `0000(0|1)` especifica las cadenas `00000` y `00001`.

De manera similar, la expresión regular car(|s|) define las formas singular (car) y plural (cars) de la palabra car.

### Cuantificadores

Lo que a menudo se desea es que una subcadena particular se repita en una cadena. Las siguientes expresiones están disponibles en expresiones regulares:

* El cuantificador `*` repite 0... veces, por ejemplo;

  ```java
  String string = "trolololololo";
  
  if (string.matches("tro(lo)*")) {
      System.out.println("Correct form.");
  } else {
      System.out.println("Incorrect form.");
  }
  ```

  Cuya salida es:

  ```
  Correct form
  ```
  Con la entrada `trozo` devolvería `Correct form` 

* El cuantificador `+` se repite 1... veces, por ejemplo;

  ```java
  String string = "trolololololo";
  
  if (string.matches("tro(lo)+")) {
      System.out.println("Correct form.");
  } else {
      System.out.println("Incorrect form.");
  }
  ```

  Cuya salida es:

  ```
  Correct form.
  ```

  Con la entrada `trozo` devolvería `Incorrect form` 

  ```java
  String string = "nananananananana Batmaan!";
  
  if (string.matches("(na)+ Batmaan!")) {
      System.out.println("Correct form.");
  } else {
      System.out.println("Incorrect form.");
  }
  ```

   Cuya salida es:

  ```
  Correct form.
  ```

* El cuantificador `?` repite 0 o 1 veces, por ejemplo:

  ```java
  String string = "You have to accidentally the whole meme";
  
  if (string.matches("You have to accidentally (delete )?the whole meme")) {
      System.out.println("Correct form.");
  } else {
      System.out.println("Incorrect form.");
  }
  ```

  Cuya salida es:

  ```
  Correct form.
  ```

* El cuantificador `{a}` repite `a` veces, por ejemplo:

  ```java
  String string = "1010";
  
  if (string.matches("(10){2}")) {
      System.out.println("Correct form.");
  } else {
      System.out.println("Incorrect form.");
  }
  ```

  Cuya salida es:

  ```
  Correct form.
  ```

* El cuantificador `{a..b}` repite `a ... b` veces

  ```java
  String string = "1";
  
  if (string.matches("1{2,4}")) {
      System.out.println("Correct form.");
  } else {
      System.out.println("Incorrect form.");
  }
  ```

  Cuya salida es:

  ```
  Incorrect form.
  ```

* El cuantificador `{a,}` repite `a...` veces.

  ```java
  String string = "11111";
  
  if (string.matches("1{2,}")) {
      System.out.println("Correct form.");
  } else {
      System.out.println("Incorrect form.");
  }
  ```

  Cuya salida es:

  ```
  Correct form.
  ```
  

Puedes usar más de un cuantificador en una sola expresión regular. Por ejemplo, la expresión regular `5{3}(1|0)*5{3}` define cadenas que comienzan y terminan con tres cincos. Se permite un número ilimitado de unos y ceros en el medio.

### Corchetes

Una clase de caracteres se puede utilizar para especificar un conjunto de caracteres de forma compacta. Los caracteres están encerrados entre corchetes y un rango se indica con un guión. Por ejemplo, `[145]` significa `(1|4|5)` y `[2-36-9`] significa `(2|3|6|7|8|9).` De manera similar, la entrada `[a-c]*` define una expresión regular que requiere que la cadena contenga solo a, b y c.

**Ejercicio 1**

Crea un programa con un método `isDayOfWeek(String day)` que devuelva true si la cadena pasada coincide con un día de la semana (lun, mar, mier, jue, vie, sab, dom).

**Ejercicio 2**

Crea un programa con un método `allVowel(String string)` que compruebe si todos los caracteres son vocales (sólo a, e, i, o, u)

### Expresiones comunes

La siguientes expresiones se usan con regularidad:

| Regular Expression | Description                                                  | Example                                                      |
| ------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| .                  | Matches any single character                                 | (“…”, “a%”) – true<br />(“…”, “.a”) – true<br /> (“…”, “a”) – false |
| ^aaa               | Matches aaa regex at the beginning of the line               | (“^a.c.”, “abcd”) – true<br /> (“^a”, “ac”) – false          |
| aaa$               | Matches regex aaa at the end of the line                     | (“…cd\$”, “abcd”) – true(“a​\$”, “a”) – true (“a$”, “aca”) – false |
| [abc]              | Can match any of the letter a, b or c. [] are known as character classes. | (“^[abc]d.”, “ad9”) – true<br />(“[ab].d$”, “bad”) – true <br />(“[ab]x”, “cx”) – false |
| \[abc][12]         | Can match a, b or c followed by 1 or 2                       | (“\[ab][12].”, “a2#”) – true(“[ab]…[12]”, “acd2”) – true (“\[ab][12]”, “c2”) – false |
| [^abc]             | When ^ is the first character in [], it negates the pattern, matches anything except a, b or c | (“\[^ab]\[^12].”, “c3#”) – true<br />(“ab…12”, “xcd3”) – true<br />(“ab12”, “c2”) – false |
| [a-e1-8]           | Matches ranges between a to e or 1 to 8                      | (“[a-e1-3].”, “d#”) – true<br />(“[a-e1-3]”, “2”) – true <br />(“[a-e1-3]”, “f2”) – false |

### Metacaracteres

También se pueden usar metacaracteres que son como atajos para patrones comunes:

| Regular Expression | Description                                        |
| ------------------ | -------------------------------------------------- |
| \d                 | Any digits, short of [0-9]                         |
| \D                 | Any non-digit, short for \[^0-9]                   |
| \s                 | Any whitespace character, short for [\t\n\x0B\f\r] |
| \S                 | Any non-whitespace character, short for \[^\s]     |
| \w                 | Any word character, short for [a-zA-Z_0-9]         |
| \W                 | Any non-word character, short for \[^\w]           |
| \b                 | A word boundary                                    |
| \B                 | A non word boundary                                |



----

Adaptado del siguiente material

* [https://java-programming.mooc.fi/part-10/3-other-useful-techniques](https://java-programming.mooc.fi/part-10/3-other-useful-techniques)