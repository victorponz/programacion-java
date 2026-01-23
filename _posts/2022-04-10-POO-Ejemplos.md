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

<span style='color:green'> (ra2.a, ra2.b, ra2.f, ra2.h, ra2.i, ra4.a, ra4.b, ra4.c, ra4.d, ra4.e)</span>

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
## Ejercicios

>-info-En todas las clases implementa el método toString()
>En todos los ejercicios crea una clase `Main` y modela varios objetos. Después imprímelos.

> -task-**Ejercicio 1** 
>
> <span style='color:green'> (ra2.a, ra2.b, ra2.f,  ra2.h, ra2.i, ra4.a, ra4.b, ra4.c, ra4.d, ra4.e)</span>
>
> Crea una clase que modele los distintos ordenadores de una tienda de informática. Piensa qué atributos, qué constructores debes crear y qué setters y getters.

> -task-**Ejercicio 2** 
>
> <span style='color:green'> (ra2.a, ra2.b, ra2.f, ra2.h, ra2.i, ra4.a, ra4.b, ra4.c, ra4.d, ra4.e)</span>
>
> Crea una clase que represente a un aparato de aire acondicionado. Este aparato tiene un nombre, y una temperatura máxima y mínima. Además tiene dos botones para subir y bajar el aire de grado en grado pero sin sobrepasar nunca de los límites

> -task-**Ejercicio 3** 
>
> <span style='color:green'> (ra2.a, ra2.b, ra2.f, ra2.h, ra2.i, ra4.a, ra4.b, ra4.c, ra4.d, ra4.e)</span>
>
> Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular y cantidad
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

> -task-**Ejercicio 4** 
>
> <span style='color:green'> (ra2.a, ra2.b, ra2.f, ra2.h, ra2.i, ra4.a, ra4.b, ra4.c, ra4.d, ra4.e)</span>
>
> Crea una clase llamada `Autor` con los campos Nombre y Fecha de nacimiento.  Crea la entidad `Tema` con un atributo para el nombre del tema
>
> Después crea una clase `Libro` con los campos Título, Autor y Páginas. Además tendrá una lista para poder almacenar los temas de los que trata el libro.
>
> Por último crea una clase `MainLibro` en la que deberás crear varios autores, temas y libros

> -task-**Ejercicio 5** 
>
> <span style='color:green'> (ra2.a, ra2.b, ra2.f, ra2.h, ra2.i, ra4.a, ra4.b, ra4.c, ra4.d, ra4.e)</span>
>
> Crea las clases necesarias para poder representar el siguiente diagrama entidad-relación
>
> ![image-20230130190129052](/programacion-java/assets/img/poo/image-20230130190129052.png)

> -task-**Ejercicio 6** 
>
> <span style='color:green'> (ra2.a, ra2.b, ra2.f, ra2.h, ra2.i, ra4.a, ra4.b, ra4.c, ra4.d, ra4.e)</span>
>
> Crea las clases necesarias para poder representar el siguiente diagrama entidad-relación
>
> ![image-20230130190242249](/programacion-java/assets/img/poo/image-20230130190242249.png)

>-task-**Ejercicio 7** 
>
><span style='color:green'> (ra2.a, ra2.b, ra2.f, ra2.h, ra2.i, ra4.a, ra4.b, ra4.c, ra4.d, ra4.e)</span>
>
>Crea las clases necesarias para poder representar el siguiente diagrama entidad-relación
>
>![image-20230130190423703](/programacion-java/assets/img/poo/image-20230130190423703.png)

> -task-**Ejercicio 8**
>
> <span style='color:green'>(ra2.a, ra2.b, ra2.f, ra2.h, ra2.i, ra4.a, ra4.b, ra4.c, ra4.d, ra4.e)</span>
>
> Un **centro hospitalario** está organizado en varios **departamentos médicos** (como Cardiología, Traumatología, Pediatría, etc.).
>  Cada departamento pertenece a un único hospital y puede contar con varios **médicos**. Un médico puede colaborar en uno o varios departamentos.
>
> El hospital atiende a **pacientes**, de los cuales se almacena información personal básica.
>  Cada paciente tiene asignado un **médico responsable**, que se encarga de coordinar su atención, aunque el paciente puede ser atendido por otros médicos.
>
> El hospital dispone de varias **plantas**, y cada planta contiene distintas **habitaciones**.
>  Una habitación puede alojar a varios pacientes al mismo tiempo, pero cada paciente se aloja en una única habitación.
>
> Durante la atención sanitaria se registran **intervenciones médicas**.
>  Cada intervención:
>
> - es realizada por un único médico,
> - se realiza a un único paciente,
> - tiene una fecha, un tipo, una duración y un coste asociados.
>
> En una intervención pueden prescribirse uno o varios **medicamentos**. Un mismo medicamento puede ser prescrito en distintas intervenciones.
>
> ![mermaid](/programacion-java/assets/img/poo/mermaid.png)
>
> Crea las clases necesarias para representar este mundo

>  -task-**Sistema de subastas**
>
> <span style='color:green'> (ra2.a, ra2.b, ra2.h, ra2.i, ra4.a, ra4.b, ra4.c, ra4.d, ra4.e, ra4.g)</span>
>
> Se pretende modelar un sistema de subastas que funciona de la siguiente manera:
>
> * La casa de subastas planifica la subasta en un día en concreto de una serie de artículos organizados en lotes.
>* De cada artículo se debe almacenar su `nombre` y el `precio`. Del lote se desea conocer su número y el precio de salida.
> * Llegado el día de la subasta los pujadores (`nombre`) realizan pujas de dinero sobre cada uno de los lotes. Cuando se finaliza la subasta, el lote se adjudica al pujador con la puja más alta.
>
> El sistema debe:
>
> * poder generar una o más subastas
>
> * añadir lotes de artículos a las subastas
>
> * gestionar las pujas y los pujadores
>
> * cerrar la subasta
>
> * imprimir una relación de los lotes que se han adjudicado a los pujadores una vez cerrada la subasta y el importe de la puja ganadora. Si algún lote no tuviese puja, se debe imprimir "No adjudicado".
>
> Implementa este sistema de subastas. Piensa en los constructores, setters y getters necesarios. 
>

---



