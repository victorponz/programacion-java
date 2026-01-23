---
typora-copy-images-to: ../assets/img/poo/
typora-root-url: ../../
layout: post
title: Principios SOLID
categories: poo
conToc: true
permalink: principios-solid
---

**Referencias**

https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design

## Introducción

*SOLID* es un acrónimo de los primeros cinco principios de la programación orientado a objetos de Robert C. Martin (también conocido  como el [Tío Bob](http://en.wikipedia.org/wiki/Robert_Cecil_Martin)).

Estos principios establecen prácticas que se prestan al desarrollo de software con consideraciones para su **mantenimiento y expansión** a medida que el proyecto se amplía. Adoptar estas prácticas también pueden ayudar a evitar los malos aromas de código, refactorizar el código y aprender sobre el desarrollo ágil y adaptativo de software.

SOLID representa:

- **S**:  **(Single)** Principio de responsabilidad única
- **O: (Open)** Principio abierto-cerrado
- **L: (Liskov)** Principio de sustitución de Liskov
- **I: (Interface)** Principio de segregación de interfaz
- **D: (Dependency)** Principio de inversión de dependencia

En este artículo, se explica cada principio por separado para comprender la forma en que SOLID puede ayudarlo a ser un mejor  desarrollador.

## El principio de responsabilidad única (SRP) establece:

> -alert-Una clase debe tener una y una sola razón para cambiar, lo que significa que una clase debe tener solo un trabajo.

Por ejemplo, considera una aplicación que toma una colección de formas, entre círculos y cuadrados, y calcula la suma del área de todas las formas de la colección.

Primero, creamos las clases de forma y hacemos que los constructores configuren los parámetros requeridos.

Para los cuadrados, deberá saber la longitud de un `lado`:

```java
public class Cuadrado {
    private int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }
}
```

Para los círculos, deberá saber el `radio`:

```java
public class Circulo {
    private int radio;
    public Circulo(int radio) {
        this.radio = radio;
    }
}
```

A continuación, creamos la clase `AreaCalculator` y luego escribimos la lógica para sumar las áreas de todas las formas proporcionadas. 

```java
import java.util.List;
public class AreaCalculator {
    private List<Object> l;
    public AreaCalculator(List<Object> l) {
        this.l = l;
    }
    public int sum(){
        int area = 0;
        for (Object o:l) {
            if (o instanceof Cuadrado){
                area += ((Cuadrado)o).getLado() * ((Cuadrado)o).getLado();
            }else if (o instanceof Circulo){
                area += Math.PI * Math.pow(((Circulo)o).getRadio(), 2);
            }
        }
        return area;
    }

    @Override
    public String toString(){
        return "<p>Área: " + this.sum() + "</p>";
    }
}
```

Para usar la clase `AreaCalculator`, deberemos crear una instancia de la clase y pasar una matriz de formas para mostrar el  resultado en la parte inferior de la página.

A continuación, se muestra un ejemplo con una colección de tres formas:

- un círculo con un radio de 2
- un cuadrado con una longitud de 5
- un segundo cuadrado con una longitud de 6

```java
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Object> l = new ArrayList<>();
        l.add(new Circulo(2));
        l.add(new Cuadrado(5));
        l.add(new Cuadrado(6));
        System.out.println(new AreaCalculator(l));
    }
}
```

```html
<p>Área: 73</p>
```

El problema con el método de salida es que `AreaCalculator` maneja la lógica para generar los datos.

Considera un escenario en el que el resultado debe convertirse a otro formato como JSON.

La clase `AreaCalculator` manejaría toda la lógica. Esto violaría el principio de responsabilidad única. La clase `AreaCalculator` solo debe ocuparse de la suma de las áreas de las formas proporcionadas. No debería importar si el usuario desea JSON o HTML.

Para abordar esto, podemos crear una clase `SumCalculatorOutputter` por separado y usarla para manejar la lógica que necesitamos para mostrar los datos al usuario:

```java
public class SumCalculatorOutputter {
    private AreaCalculator areaCalculator;

    public SumCalculatorOutputter(AreaCalculator areaCalculator) {
        this.areaCalculator = areaCalculator;
    }
    public String toJSON(){
        return "{\"area\": \"" + this.areaCalculator.sum()+ "\"}";
    }
    public String toHTML(){
        return "<p>" + this.areaCalculator.sum()+ "</p>";
    }
}
```

La clase `SumCalculatorOutputter` funcionaría así:

```java
List<Object> l = new ArrayList<>();
l.add(new Circulo(2));
l.add(new Cuadrado(5));
l.add(new Cuadrado(6));
System.out.println(new SumCalculatorOutputter(new AreaCalculator(l)).toJSON());
System.out.println(new SumCalculatorOutputter(new AreaCalculator(l)).toHTML());
```

Ahora, la clase `SumCalculatorOutputter` maneja cualquier lógica que necesite para enviar los datos al usuario.

Eso cumple con el principio de responsabilidad única.

## Principio abierto-cerrado

Principio abierto-cerrado (S.R.P.) establece:

> -info-Los objetos o entidades deben estar abiertos para extensión, pero cerrados para modificación.

Esto significa que una clase debe ser ampliable sin modificar la clase en sí.

Volvamos a ver la clase `AreaCalculator` y enfoquémonos en el método `sum`:

```java
public int sum(){
    int area = 0;
    for (Object o:l) {
        if (o instanceof Cuadrado){
            area += ((Cuadrado)o).getLado() * ((Cuadrado)o).getLado();
        }else if (o instanceof Circulo){
            area += Math.PI * Math.pow(((Circulo)o).getRadio(), 2);
        }
    }
    return area;
}
```

Considera un escenario en el que el usuario desea la suma de formas adicionales como triángulos, pentágonos, hexágonos, etc.  Tendríamos que editar constantemente este archivo y añadir más bloques `if`/`else`. Eso violaría el principio abierto-cerrado.

Una forma de mejorar el método `sum` es eliminar la lógica para calcular el área de cada forma fuera del método de la clase `AreaCalculator` y adjuntarlo a la clase de cada forma. 

Primero crearemos una interfaz para que defina un método `area`:



A continuación, se muestra `area` definido en `Cuadrado`:

```java
public class Cuadrado {
    private int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    public int area(){
        return lado * lado;
    }
}
```

Y aquí el método para la clase `Circulo`:

```java
public class Circulo {
    private int radio;
    public Circulo(int radio) {
        this.radio = radio;
    }

    public int area(){
        return  (int) (Math.PI * Math.pow(this.radio, 2));
    }
}
```

El método `sum` para `AreaCalculator` puede reescribirse así:

