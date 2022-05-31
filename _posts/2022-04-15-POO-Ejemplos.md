---
typora-copy-images-to: ../assets/img/poo/
typora-root-url: ../../
layout: post
title: Ejemplos POO
categories: poo
conToc: true
permalink: poo-ejemplos
---

## Práctica clases

Vamos a crear un cuantas clases para practicar

Cree las siguientes tres clases:

* Clase `A`. La clase no debe tener variables de objeto ni debe especificar un constructor para ella. Solo tiene el método `public void a()`, que imprime una cadena "A".
* Clase `B`. La clase no debe tener variables de objeto ni debe especificar un constructor para ella. Solo tiene el método `public void b()`, que imprime una cadena "B".
* Clase `C`. La clase no debe tener variables de objeto ni debe especificar un constructor para ella. Solo tiene el método `public void c()`, que imprime una cadena "C".

```java
A a = new A();
B b = new B();
C c = new C();

a.a();
b.b();
c.c();
```

```
A
B
C
```

### Herencia

Modifique las clases para que la clase `B` herede la clase `A` y la clase `C` herede la clase `B`. En otras palabras, la clase `A` será una superclase para la clase `B` y la clase `B` será una superclase para la clase `C`.

```java
C c = new C();

c.a();
c.b();
c.c()
```

```
A
B
C
```

## Person

Crea una clase Persona, que debe comportarse de la siguiente manera:

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

El tipo real de un objeto dicta qué método se ejecuta

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

## Point

Vamos a representar un punto en el sistema de 2 coordenadas con la siguiente clase:

```java
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int manhattanDistanceFromOrigin() {
        return Math.abs(x) + Math.abs(y);
    }

    protected String location(){
        return x + ", " + y;
    }

    @Override
    public String toString() {
        return "(" + this.location() + ") distance " + this.manhattanDistanceFromOrigin();
    }
}
```

El método `location` no está diseñado para uso externo, por lo que se define como `protected`. Las subclases aún podrán acceder al método. La distancia de Manhattan significa la distancia entre dos puntos si solo puede viajar en la dirección de los ejes de coordenadas. Se utiliza en muchos algoritmos de navegación, por ejemplo.

Por lo demás, un punto coloreado es idéntico a un punto, pero también contiene un color que se expresa como una cadena. Debido a la similitud, podemos crear una nueva clase extendiendo la clase `Point`

```java
public class ColorPoint extends Point {

    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " color: " + color;
    }
}
```

> -info- La anotación `@Override` simplemente se utiliza, para forzar al compilador a comprobar en tiempo de compilación que estás sobrescribiendo correctamente un método, y de este modo evitar errores en tiempo de ejecución, los cuales serían mucho más difíciles de detectar.
>
> Por ejemplo, si fueras a sobrescribir el método `toString()` de la clase `Object` y lo haces de este modo:
>
> ```java
> public class MiClase {
> 
>     public String ToString() {
>         return "Hola, esta es MiClase";
>     }
> }
> ```
> realmente no estás sobrescribiendo el método, sino creando uno nuevo, ya que el nombre correcto comienza con minúscula y no con mayúscula. Si antepones `@Override`el compilador te indica que no hay ningún método para sobrescribir con dicha signatura

La clase define una variable de objeto en la que almacenamos el color. Las coordenadas ya están definidas en la superclase. Queremos que la representación de la cadena sea la misma que la clase `Point`, pero que también incluya información sobre el color. El método `toString` anulado llama al método `toString` de la superclase y le agrega el color del punto.

A continuación, agregaremos algunos puntos a una lista. Algunos de ellos son "normales", mientras que otros son puntos de color. Al final del ejemplo, imprimiremos los puntos en la lista. Para cada punto, el `toString` a ejecutar está determinado por el tipo real del punto, aunque la lista conoce todos los puntos por el tipo `Point`.

```java
public class Main {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(4, 8));
        points.add(new ColorPoint(1, 1, "green"));
        points.add(new ColorPoint(2, 5, "blue"));
        points.add(new Point(0, 0));

        for (Point p: points) {
            System.out.println(p);
        }
    }
}
```

Y esta es la salida

```
(4, 8) distance 12
(1, 1) distance 2 color: green
(2, 5) distance 7 color: blue
(0, 0) distance 0
```

También queremos incluir un punto tridimensional en nuestro programa. Como no tiene información de color, derivémoslo de la clase `Point`.

```java
public class Point3D extends Point {

    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    protected String location() {
        return super.location() + ", " + z;    // the resulting string has the form "x, y, z"
    }

    @Override
    public int manhattanDistanceFromOrigin() {
        // first ask the superclass for the distance based on x and y
        // and add the effect of the z coordinate to that result
        return super.manhattanDistanceFromOrigin() + Math.abs(z);
    }

    @Override
    public String toString() {
        return "(" + this.location() + ") distance " + this.manhattanDistanceFromOrigin();
    }
}
```

Entonces, un punto tridimensional define una variable de objeto que representa la tercera dimensión y anula los métodos `location`, `manhattanDistanceFromOrigin` y `toString` para que también tengan en cuenta la tercera dimensión. Ahora ampliemos el ejemplo anterior y agreguemos también puntos tridimensionales a la lista.

```java
public class Main {

    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(4, 8));
        points.add(new ColorPoint(1, 1, "green"));
        points.add(new ColorPoint(2, 5, "blue"));
        points.add(new Point3D(5, 2, 8));
        points.add(new Point(0, 0));

        for (Point p: points) {
            System.out.println(p);
        }
    }
}
```

```
(4, 8) distance 12
(1, 1) distance 2 color: green
(2, 5) distance 7 color: blue
(5, 2, 8) distance 15
(0, 0) distance 0
```

Notamos que el método `toString` en `Point3D` es exactamente igual que el método `toString` de `Point`. ¿Podríamos ahorrar un poco de esfuerzo y no anular `toString`? ¡La respuesta es sí! La clase `Point3D` se refina en esto:

```java
public class Point3D extends Point {

    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    protected String location() {
        return super.location() + ", " + z;
    }

    @Override
    public int manhattanDistanceFromOrigin() {
        return super.manhattanDistanceFromOrigin() + Math.abs(z);
    }
}
```




## Engine

Echemos un vistazo a un sistema de fabricación de automóviles que gestiona piezas de automóviles. Un componente básico de la gestión de piezas es la clase `Part`, que define el identificador, el fabricante y la descripción.

```java
public class Part {

    private String identifier;
    private String manufacturer;
    private String description;

    public Part(String identifier, String manufacturer, String description) {
        this.identifier = identifier;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
```

Una parte del coche es el motor. Como ocurre con todas las piezas, el motor también tiene un fabricante, un identificador y una descripción. Además, cada motor tiene un tipo: por ejemplo, un motor de combustión interna, un motor eléctrico o un motor híbrido.

La forma tradicional de implementar la clase `Engine`, sin usar herencia, sería esta.

```java
public class Engine {

    private String engineType;
    private String identifier;
    private String manufacturer;
    private String description;

    public Engine(String engineType, String identifier, String manufacturer, String description) {
        this.engineType = engineType;
        this.identifier = identifier;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
```

Notamos una cantidad significativa de superposición entre los contenidos de `Engine` y `Part`. Se puede decir con confianza que el `Engine` es un caso especial de `Part`. El Motor es una Parte, pero también tiene propiedades que una Parte no tiene, que en este caso significa el tipo de motor.

Recreemos la clase `Engine` y, esta vez, usemos la herencia en nuestra implementación. Crearemos la clase `Engine` que hereda la clase `Part`: un motor es un caso especial de una parte.

```java
public class Engine extends Part {

    private String engineType;

    public Engine(String engineType, String identifier, String manufacturer, String description) {
        super(identifier, manufacturer, description);
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }
}
```

La definición de clase pública `Engine` de clase extiende `Part` indica que la clase `Engine`  hereda la funcionalidad de la clase `Part`. También definimos una variable de objeto `engineType` en la clase `Engine`.

Vale la pena considerar el constructor de la clase `Engine`. En su primera línea usamos la palabra clave `super` para llamar al constructor de la superclase. La llamada `super(identifier, manufacturer, description)` llama al constructor parte pública `(String identifier, String manufacturer, String description)` que se define en la clase `Part`. A través de este proceso, las variables de objeto definidas en la superclase se inician con sus valores iniciales. Después de llamar al constructor de la superclase, también establecemos el valor adecuado para la variable de objeto `engineType`.

La llamada `super` tiene cierta semejanza con la llamada `this` en un constructor; `this` se usa para llamar a un constructor de esta clase, mientras que `super` se usa para llamar a un constructor de la superclase. Si un constructor usa el constructor de la superclase llamando a `super` en ella, la llamada a `super` debe estar en la primera línea del constructor. Esto es similar al caso de llamar a `this` (también debe ser la primera línea del constructor).

Dado que la clase `Engine` amplía la clase `Part`, tiene a su disposición todos los métodos que ofrece la clase `Part`. Puede crear instancias de la clase `Engine` de la misma manera que puede hacerlo con cualquier otra clase.

```java
Engine engine = new Engine("combustion", "hz", "volkswagen", "VW GOLF 1L 86-91");
System.out.println(engine.getEngineType());
System.out.println(engine.getManufacturer());
```

```
combustion
volkswagen
```

[https://java-programming.mooc.fi/part-9/1-inheritance](https://java-programming.mooc.fi/part-9/1-inheritance)