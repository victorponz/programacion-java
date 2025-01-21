---
typora-copy-images-to: ../assets/img/poo/
typora-root-url: ../../
layout: post
title: Ejercicios POO
categories: poo
conToc: true
permalink: poo-ejercicios
---

## Person

Crea una clase `Person`, que debe comportarse de la siguiente manera:

```java
Person ada = new Person("Ada Lovelace", "24 Maddox St. London W1S 2QN");
Person javier = new Person("Javier García", "Calle Mayor 15 12002 Castellón");
System.out.println(ada);
System.out.println(javier);
```

```
Ada Lovelace
  24 Maddox St. London W1S 2QN
Javier García
  Calle Mayor 15 12002 Castellón
```

Esta clase sólo tiene dos **campos o atributos**: `name` y `address`

Es por ello que debemos crear dos variables con el modificador `private` para que no se pueda acceder a ellas desde fuera de la clase.

```java
public class Person{
	private String name;
	private String address;
}
```

Ahora nos hemos de plantear qué datos son obligatorios para crear un objeto `Person`. Como mínimo se debe proporcionar el `name` al crear una instancia de la misma. Es por ello que creamos un constructor que tiene como parámetro `name`

```java
public Person(String name){
    this.name = name;
}
```

En este código se introduce la palabra reservada `this` que hace referencia a la propia clase. Es decir `this.name` se refiere a la variable `name` de la clase.

Si el atributo `address` no se informa en el constructor, debe haber un `setter` que nos permita fijar el dato:

```java
public void setAddress(String address){
    this.address = address;
}
```

Por el contrario, el atributo `name` de una persona vamos a suponer que no se puede cambiar. En este caso no habría `setter`

Nos podemos plantear si es conveniente crear un constructor para los dos parámetros. De esta forma sería más fácil *instanciar* objetos de la clase:

```java
Person(String name, String address){
    this.name = name;
    this.address = address;
}
```

Para cada uno de los atributos de la clase, hemos de crear su correspondiente `getter`

```java
public String getName() {
    return name;
}
public String getAddress() {
    return address;
}
```

También queremos que los objetos de clase `Person` se impriman de una forma determinada:

```
Ada Lovelace
  24 Maddox St. London W1S 2QN
```

Para lograrlo, hemos de sobrescribir (ya lo veremos más adelante) el método `toString` que pertenece a la clase `Object` de la que todas las clases java heredan por defecto.

```java
@Override
public String toString(){
    return this.name + "\n\t" + this.address;
}
```

Vamos a crear una clase para crear varias instancias de `Person`

```java
public class Main {
    public static void main(String[] args) {
        Person ada = new Person("Ada Lovelace", "24 Maddox St. London W1S 2QN");
        Person javier = new Person("Javier García");
        javier.setAddress("Calle Mayor 15 12002 Castellón");
        System.out.println(ada);
        System.out.println(javier);
    }
}
```
>-info-En todas las clases implementa el método toString()
>En todos los ejercicios crea una clase `Main` y modela varios objetos. Después imprímelos.

> -task-**Ejercicio 1** Crea una clase que modele los distintos ordenadores de una tienda de informática. Piensa qué atributos, qué constructores debes crear y qué setters y getters.
>

> -task-**Ejercicio 2** Crea una clase que represente a un aparato de aire acondicionado. Este aparato tiene un nombre, y una temperatura máxima y mínima. Además tiene dos botones para subir y bajar el aire de grado en grado pero sin sobrepasar nunca de los límites

> -task-**Ejercicio 3** Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular y cantidad
> (puede tener decimales).
>
> El titular será obligatorio y la cantidad es opcional. Crea dos constructores que cumplan lo
> anterior.
>
> Crea sus métodos `getter`, `setter` y `toString`.
>
> Tendrá dos métodos especiales:
>
> * `ingresar(double cantidad)`: se ingresa una cantidad a la cuenta, si la cantidad introducida
>   es negativa, no se hará nada.
> * `retirar(double cantidad)`: se retira una cantidad a la cuenta, si restando la cantidad actual
>   a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0.

> -task-**Ejercicio 4** Crea una clase llamada `Autor` con los campos Nombre y Fecha de nacimiento.  Crea la entidad `Tema` con un atributo para el nombre del tema
>
> Después crea una clase `Libro` con los campos Título, Autor y Páginas. Además tendrá una lista para poder almacenar los temas de los que trata el libro.
>
> Por último crea una clase `MainLibro` en la que deberás crear varios autores, temas y libros

> -task-**Ejercicio 5** Crea las clases necesarias para poder representar el siguiente diagrama entidad-relación
>
> ![image-20230130190129052](/programacion-java/assets/img/poo/image-20230130190129052.png)

> -task-**Ejercicio 6** Crea las clases necesarias para poder representar el siguiente diagrama entidad-relación
>
> ![image-20230130190242249](/programacion-java/assets/img/poo/image-20230130190242249.png)

>-task-**Ejercicio 7** Crea las clases necesarias para poder representar el siguiente diagrama entidad-relación
>
>![image-20230130190423703](/programacion-java/assets/img/poo/image-20230130190423703.png)



## Métodos privados

Vamos a modificar la clase `Person` para añadirle un atributo `dni`. Ya sabéis que la letra del DNI se calcula mediante un algoritmo.

Debes crear un `setter` llamado `setDNI(String dni)` que a su vez llamará a un método privado que compruebe si el DNI es correcto y en otro caso que lance la excepción

```java
throw new IllegalArgumentException("El DNI no es correcto ");
```

Por ejemplo:

```java
private boolean comprobarDNI(String DNI){
    //Realiza el algoritmo

    if (está mal)
        throw new IllegalArgumentException("El DNI no es correcto ");
    else
        return  true;
}
```

Los atributos se hacen privados para que no se puedan crear objetos con datos que no sean correctos. Por ejemplo, podemos también comprobar que el nombre no sea `null`

En principio todos los métodos que no sean getters o setters deben ser privados.

> -task-Tenemos un [archivo](/programacion-java/assets/dataset_bvmc_20220325.zip) con un catálogo de libros que contienen datos de la Biblioteca Nacional
>
> Debes crear una clase `Libro`  y luego popularla a partir de dicho archivo csv. Ya hemos hecho algún ejercicio parecido.
>
> Pero en este caso hay un problema, y es que algunas de las líneas están mal formadas y salta una excepción `ArrayIndexOutOfBoundsException`. Para que no se rompa el código hemos de *capturarla*
>
> ```java
> while ((l = f.readLine()) != null){
>      datos = l.split(",");
>      try {
>            b.add(new Book(datos[5], datos[7]));
>      }catch (ArrayIndexOutOfBoundsException e){
>            System.out.println(Arrays.toString(datos));
>      }
> }
> ```
>
> Después has de hacer un método en un clase `main` que, dado un autor por teclado, imprima los datos de los libros de dicho autor.
>

> -task-**Ejercicio 8** Crea un proyecto en IntelliJ llamado Juego que contiene dos clases llamadas: `Dado` y `JuegodeDados`. La clase `Dado` tendrá un atributo que será el valor del dado y 3 métodos, el primero obtendrá el valor de una tirada del dado, el segundo imprimirá el valor de esa tirada y el tercero retorna el valor de la tirada.
> La clase `JuegodeDados` tendrá tres métodos, el primero definirá tres dados para hacer una partida, el segundo hará la tirada de los tres dados y dirá si el usuario ha ganado o ha perdido (se considera que ha ganado si el valor de la tirada de los tres dados es el mismo, ejemplo: 3 - 3 - 3). El tercer método será `main` que llamará a los otros dos métodos para realizar una partida de dados.
> ```
>    2-1-5
>    2-3-3
>    2-3-5
>    6-6-3
>    1-1-1
>    Lo conseguiste a la tirada 5
> ```
> Como el ḿetodo `main` tiene el modificador `static` todos los métodos y propiedades que uses también lo deben ser


## Student

Cree una clase `Student`, que hereda la clase `Person`.

En la creación, un estudiante tiene 0 créditos de estudio. Cada vez que un estudiante estudia, la cantidad de créditos de estudio aumenta. La clase debe actuar de la siguiente manera:

```java
Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
System.out.println(ollie);
System.out.println("Study credits " + ollie.credits());
ollie.study();
System.out.println("Study credits "+ ollie.credits());
```

```
Ollie
  6381 Hollywood Blvd. Los Angeles 90028
Study credits 0
Study credits 1
```

### Student's to String

En la tarea anterior, `Student` hereda el método `toString` de la clase `Person`. Sin embargo, también puede sobrescribir un método heredado, reemplazándolo con su propia versión. Escriba una versión del método `toString` específicamente para la clase `Student`. El método debe actuar de la siguiente manera:

```java
Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
System.out.println(ollie);
ollie.study();
System.out.println(ollie);
```

```
Ollie
  6381 Hollywood Blvd. Los Angeles 90028
  Study credits 0
Ollie
  6381 Hollywood Blvd. Los Angeles 90028
  Study credits 1
```

### Teacher

Crea la clase `Teacher` que herede de `Person`

La clase debe actuar como sigue:

```java
Teacher ada = new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN", 1200);
Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki", 5400);
System.out.println(ada);
System.out.println(esko);

Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");

int i = 0;
while (i < 25) {
  ollie.study();
  i = i + 1;
}
System.out.println(ollie);
```

```
Ada Lovelace
  24 Maddox St. London W1S 2QN
  salary 1200 euro/month
Esko Ukkonen
  Mannerheimintie 15 00100 Helsinki
  salary 5400 euro/month
Ollie
  6381 Hollywood Blvd. Los Angeles 90028
  Study credits 25
```

El tipo real de un objeto dicta qué método se ejecuta.

El tipo de un objeto decide cuáles son los métodos proporcionados por el objeto. Por ejemplo, implementamos la clase `Student` anteriormente. Si se almacena una referencia a un objeto de tipo `Student` en una variable de tipo `Person`, solo estarán disponibles los métodos definidos en la clase `Person`(y su superclase e interfaces):

```java
Person ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
ollie.credits();        // DOESN'T WORK!
ollie.study();              // DOESN'T WORK!
System.out.println(ollie);   // ollie.toString() WORKS
```

Entonces, un objeto tiene a su disposición los métodos que se relacionan con su tipo y también con sus superclases e interfaces. El objeto `Student` anterior ofrece los métodos definidos en las clases `Person` y `Object`.

En el último ejercicio, escribimos una nueva implementación de `toString` para que `Student` invalide el método que hereda de `Person`. La clase `Person` ya había anulado el método `toString` que heredó de la clase `Object`. Si manejamos un objeto por algún otro tipo que no sea su tipo real, ¿a qué versión del método del objeto se llama?

En el siguiente ejemplo, tendremos dos estudiantes a los que nos referiremos por variables de diferentes tipos. ¿Qué versión del método `toString` se ejecutará: la definida en `Object`, `Person` o `Student`?

```java
Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
System.out.println(ollie);
Person olliePerson = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
System.out.println(olliePerson);
Object ollieObject = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
System.out.println(ollieObject);

Object alice = new Student("Alice", "177 Stewart Ave. Farmington, ME 04938");
System.out.println(alice);
```

```
Ollie
  6381 Hollywood Blvd. Los Angeles 90028
  credits 0
Ollie
  6381 Hollywood Blvd. Los Angeles 90028
  credits 0
Ollie
  6381 Hollywood Blvd. Los Angeles 90028
  credits 0
Alice
  177 Stewart Ave. Farmington, ME 04938
  credits 0
```

El método a ejecutar se elige en función del tipo real del objeto, lo que significa la clase cuyo constructor se llama cuando se crea el objeto. Si el método no tiene definición en esa clase, la versión del método se elige de la clase más cercana al tipo real en la jerarquía de herencia.

> -info-**Polimorfismo**
>
> Independientemente del tipo de variable, el método que se ejecuta siempre se elige en función del tipo real del objeto. Los objetos son polimórficos, lo que significa que se pueden utilizar a través de muchos tipos de variables diferentes. El método ejecutado siempre se relaciona con el tipo real del objeto. Este fenómeno se llama polimorfismo.

## Laboratorio

Vamos a crear una clase `Lab` que implemente un laboratorio. Éste tiene un nombre, un taller, una capacidad máxima, la hora y día en que se imparte, un profesor que lo imparte y una lista de estudiantes que asisten.

> -task-Diseña la clase. Piensa en los atributos, constructores y setters y getters necesarios. Luego crea una clase llamada `MainLab` donde crees varias instancias de la clase `Lab`

## Máquina expendedora

Vamos a implementar un máquina expendedora de tiques. Los tiques tienen un precio. La máquina tiene un cajón que recoge los importes de los tiques.

El cliente va introduciendo dinero y si pulsa el botón *Sacar tique* se le expenderá el tique siempre que haya introducido una cantidad igual o mayor que el importe. Este método debe imprimir el tique y devolver en un `String` la cantidad de billetes y monedas mínimas para dicha devolución:

Por ejemplo, si el tique vale 1,20 € y el usuario introduce 5€, le debe devolver 1 moneda de 2€, 1 moneda de 1€,  1 de 0,50€, 1 de 0,20€ y 1 de 0,10€.
Además ingresará en el cajón el importe del tique.

Si no hay suficiente dinero en el cajón, le debe decir `Introduzca el importe exacto`.

> -task-Implementa la clase `MaquinaExpendora` Piensa en los constructores, setters y getters necesarios

## Sistema de subastas

Se pretende modelar un sistema de subastas que funciona de la siguiente manera:

La casa de subastas planifica la subasta en un día en concreto de una serie de artículos organizados en lotes.

De cada artículo se debe almacenar su `nombre` y el `precio`. Del lote se desea conocer su número y el precio de salida.

Llegado el día de la subasta los pujadores (Nombre) realizan pujas de dinero sobre cada uno de los lotes. Cuando se finaliza la subasta, el lote se adjudica al pujador con la puja más alta.

El sistema debe:

* poder generar una o más subastas
* añadir lotes de artículos a las subastas
* gestionar las pujas y los pujadores
* cerrar la subasta
* imprimir una relación de los lotes que se han adjudicado a los pujadores una vez cerrada la subasta. Si algún lote no tuviese puja, se debe imprimir "No adjudicado"

>-task-Implementa este sistema de subastas. Piensa en los constructores, setters y getters necesarios

---
Adaptado del siguiente material

* [http://greenteapress.com/wp/think-java/](http://greenteapress.com/wp/think-java/) Version 6 by Allen Downey and Chris Mayfield

* [https://java-programming.mooc.fi/part-9/1-inheritance](https://java-programming.mooc.fi/part-9/1-inheritance)
