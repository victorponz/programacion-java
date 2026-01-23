---
typora-copy-images-to: ../assets/img/herencia/
typora-root-url: ../../
layout: post
title: Variables y métodos estáticos
categories: poo
conToc: true
permalink: variables-metodos-estaticos
---



## Variables estáticas

Vamos a ver un tipo especial de variable que son las **variables de clase (`static`)**

```java
public class Articulo{
    private static int numSerie = 0;
    private int ID;
    private String nombre;
    Articulo(String nombre){
        this.nombre = nombre;
        this.ID = numSerie++; // A esta variable NO se le antepone `this` porque no es de un objeto
    }
    //Se omiten setters y getters
}
```

Estas variables se definen anteponiendo la palabra reservada `static` e implica que esta variable **va a ser común para todos los elementos de la clase**.

Fijaos que en el constructor se asigna e incrementa el valor de esta variable al atributo `ID`

```java
this.ID = numSerie++;
```

Por ejemplo, el código siguiente:

```java
public class MainArticulo {
    public static void main(String[] args) {
        Articulo a = new Articulo("Ordenador");
        System.out.println(a.getID());
        Articulo b = new Articulo("Impresora");
        System.out.println(b.getID());
    }   
}
```

Produce la siguiente salida:

```
0
1
```

Es decir, cuando se ha creado el objeto `b` la variable `numSerie` ya tenía el valor 1.

En general, se usan este tipo de variables cuando deseamos conservar su estado para todos los objetos de la misma.

## Métodos estáticos

Al igual que las variables estáticas, los métodos estáticos se usan para crear métodos que no accedan al estado de los objetos.

Supón que queremos tener una entidad `Persona` que almacene el campo `DNI` y nos debemos asegurar que este DNI es correcto.

```java
public class Persona {
    private String nombre;
    private String DNI;
    private final char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };

    public Persona(String nombre, String DNI) {
        this.nombre = nombre;
        if (checkDNI(DNI))  this.DNI = DNI;
        else  this.DNI = "";

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDNI() {
        return DNI;
    }

    private boolean checkDNI(String DNIAComprobar){
        if (DNIAComprobar.length() != 9) return false;
        else{
            int numero = Integer.parseInt(DNIAComprobar.substring(0, 8));
            char letra = DNIAComprobar.charAt(8);
            if ( letra != this.letras[numero % 23]) return false;
        }
        return true;
    }
    
}

```

El método `checkDNI(String DNIAComprobar)` **no accede** a ningún atributo del objeto al igual que la variable `private char[] letras`. Estos son candidatos para convertir el método en `static`

```java
public class Persona {
    private String nombre;
    private String DNI;
    private static final char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

    public Persona(String nombre, String DNI) {
        this.nombre = nombre;
        if (checkDNI(DNI))  this.DNI = DNI;
        else  this.DNI = "";

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDNI() {
        return DNI;
    }

    // Como no usa ninguna variable no estática de la clase, se puede o debe hacer estático
    private static boolean checkDNI(String DNIAComprobar){
        if (DNIAComprobar.length() != 9) return false;
        else{
            int numero = Integer.parseInt(DNIAComprobar.substring(0, 8));
            char letra = DNIAComprobar.charAt(8);
            if ( letra != letras[numero % 23]) return false;
        }
        return true;
    }
    
}
```

¿Qué ventaja ofrece este tipo de métodos y variables estáticos? La ventaja se produce en el consumo de memoria. Si tenemos 1.000.000 de objetos `Persona` cada uno de ellos con su copia de la variable `letras` ocuparán `1.000.000 * 24 * 1 byte por carácter = 24.000.000 Bytes`, es decir, más o menos 24 MB sólo para almacenar las letras mientras que con `static` sólo ocupan 24 Bytes.

> -hint-**¿Cuándo usarlo?** En general, si un método no accede a ningún atributo del objeto, se debe declarar como `static`. Todas las variables que use un método `static` también deben ser declaradas como `static`. Cualquier otra variable que deseemos compartir entre todos los objetos de la clase también será `static`

Desde un método **no estático** se puede acceder a una variable o método **estático** pero no al revés.

> -warning-Piensa que es como una relación `1:N` entre la clase y el objeto. Desde la parte `N` (objeto) se puede acceder a la parte `1` (clase) porque sólo hay una, pero ¿desde la parte `1` a qué objeto de la parte `N` accedo?

**Comparación rápida (estático vs no estático)**

| Aspecto        | `static`        | No `static`      |
| -------------- | --------------- | ---------------- |
| Pertenece a    | Clase           | Objeto           |
| Necesita `new` | ❌ No            | ✔ Sí             |
| Copias         | 1 sola          | Una por objeto   |
| Acceso         | `Clase.miembro` | `objeto.miembro` |