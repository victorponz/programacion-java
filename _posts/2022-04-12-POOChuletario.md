---
typora-copy-images-to: ../assets/img/poo/
typora-root-url: ../../
layout: post
title: Chuletario POO
categories: poo
conToc: true
permalink: chuletario-poo
---

<span style='color:green'> (ra2.a, ra2.b, ra2.h, ra2.i, ra4.a, ra4.b, ra4.c, ra4.d, ra4.e, ra4.f, ra4.g, ra4.h, ra4.i, ra6.c, ra7.a, ra7.b. ra7.c, ra7.d, ra7.e, ra7.f)</span>

## Crear una clase

```java
public class Persona{

}
```

> -warning-El nombre de la clase **siempre** se escribe en **C**amel**C**ase

## Definir los atributos

```java
private String nombre;
private int edad;
private char sexo;
```

> -warning-Los atributos siempre son **privados**. El nombre en camel**C**ase es decir, la primera letra en minúscula

## Constructor pana inicializar los atributos

La manera habitual de dar valor inicial a los atributos de una clase es mediante el uso de uno o varios constructores. El constructor se crea con el nombre de la clase y 0 o más parámetros. No devuelven nada, ni siquiera `void`. Suelen ser públicos.

```java
public class Persona{
	private String nombre;
	private int edad;
    private char sexo;
    //En este caso el constructor es público y tiene 3 parámetros
    public Persona(String nombre, int edad, char sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    //Este tiene dos parámetos
    public Persona(String nombre, int edad){
        //Llamamos al constructor anterior pasándole como valor por defecto para sexo el valor I
        this(nombre, edad, 'I');
    }
    //Y estee solo uno
    public Persona(String nombre){
        //Otra forma de inicializar sin llamar a un constructor ya definido
        this.nombre = nombre;
        this.edad = 0;
        this.sexo = 'I';
    }
}
```

> -info-Se pueden crear tantos constructores como sea necesario e incluso no crear ninguno, en cuyo caso Java creará uno sin parámetros. Sólo hay que tener en cuenta que el tipo y orden de los parámetros no pueden repetirse.

## Crear una instancia de la clase

```java
Persona pedro = new Persona("Pedro", 39, "M");
Persona maria = new Persona("María", 20);
Persona juan = new Persona("Juan");
```

Fijaos que **siempre** se debe usar la palabra reservada `new`. Vamos a ver un ejemplo distinto:

```java
Persona p1 = new Persona("Pedro", 39, "M");
Persona p2 = p1;
p2.setNombre("María");
```

El resultado de `p2.setNombre("María");` es que ahora tanto `p1` como `p2` tienen de nombre **María** porque la instancia `p2` es la misma que `p1`:

O este otro ejemplo en el que tenemos una lista de contactos donde cada uno de ellos tiene un nombre y una lista de teléfonos:

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> agenda = new HashMap<>();
        List<String> telefonos = new ArrayList<>();
        telefonos.add("9998899");
        telefonos.add("554488");
        agenda.put("Pepe", telefonos);

        telefonos.clear(); //Borramos la lista de teléfonos
        telefonos.add("4444444");
        agenda.put("María", telefonos);
        
        for (Map.Entry<String, List<String>> a: agenda.entrySet()) {
            System.out.println(a.getKey());
            for (String t: a.getValue()) {
                System.out.println("\t" + t);
            }
        }
    }
}
```

Resulta que ahora Pepe tiene el mismo teléfono que María ya que sólo hay una instancia de la lista de teléfonos.

```
María
	4444444
Pepe
	4444444
```

En el siguiente código hemos creado en la línea **<span style='color:red'>14</span>** una **nueva variable de instancia**.

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> agenda = new HashMap<>();
        List<String> telefonos = new ArrayList<>();
        telefonos.add("9998899");
        telefonos.add("554488");
        agenda.put("Pepe", telefonos);

        telefonos = new ArrayList<>(); //Creamos una nueva instancia
        telefonos.add("4444444");
        agenda.put("María", telefonos);
        for (Map.Entry<String, List<String>> a: agenda.entrySet()) {
            System.out.println(a.getKey());
            for (String t: a.getValue()) {
                System.out.println("\t" + t);
            }
        }
    }
}
```


```
María
	4444444
Pepe
	9998899
	554488
```

Como se ve, ahora cada uno tiene sus propios teléfonos. 

## Getters

Como los atributos son privados, se debe crear un método público que devuelva el estado del mismo. Por ejemplo:

```java
public String getNombre(){
	return this.nombre;
}
```

> -warning-El nombre del método **siempre** debe empezar por `get` y a continuación el nombre del atributo en **C**amel**C**ase
>
> Cuando el tipo del atributo es `boolean` el método se debe llamar `isNombreAtributo` o `hasNombreAtributo`, donde `NombreAtributo` es el nombre del atributo, por ejemplo, `isEven` o `hasChildren`

## Setters

Como los atributos son privados, se debe proporcionar (o no) un método para dar un valor a un atributo.

Puede ser que:

* no se cree ningún setter. Por ejemplo, supongamos que la Clase `Person` tiene un atributo DNI y que este no se puede cambiar, se inicializa en el constructor y no se proporciona ningún setter.

  ```java
  public class Persona{
  	private String nombre;
  	private int edad;
      public Persona(String nombre, int edad, char sexo, String DNI){
          this.nombre = nombre;
          this.edad = edad;
          this.sexo = sexo;
          this.DNI = DNI;
      }
  }
  ```

* se creen `n` setters. 

  ```java
  public class AirConditioned {
      private int temperature;
      private int maxTemp;
      private int minTemp;
  
      public AirConditioned(int temperature, int maxTemp, int minTemp) {
          this.temperature = temperature;
          this.maxTemp = maxTemp;
          this.minTemp = minTemp;
      }
  
      public int getTemperature() {
          return this.temperature;
      }
  	
      //Este setter es el típico ya que se le pasa el parámetro temperature
      public void setTemperature(int temperature) {
          if (temperature <= this.maxTemp && temperature >= this.minTemp)
              this.temperature = temperature;
      }
  	//Este setter aumenta la temperatura
      public void up(){
          if (this.temperature + 1 <= this.maxTemp)
              this.temperature++;
      }
      //Este setter baja la temperatura
      public void down(){
          if (this.temperature - 1 >= this.minTemp)
              this.temperature--;
      }
  
      @Override
      public String toString(){
          return "Temperature: " + this.temperature;
      }
  }
  ```

> -info-**¿Por qué se usan setters en vez de hacer públicos los atributos?**
>
> Uno puede pensar en hacer los atributos públicos para que cualquiera que tenga acceso a la clase pueda dar un valor. Pero esto hace que la clase sea propensa a errores. En el ejemplo del `AirConditioned` se comprueba en los setters que la temperatura siempre se encuentre entre los límites. Sin embargo, si hacemos la propiedad pública, se podría fijar a valores incorrectos
>
> ```java
> public class AirConditioned {
>     //Se puede acceder desde fuera de la clase
>     public int temperature;
> ```
>
> 
>
> ```java
> AirConditioned ac = new AirConditioned(20, 30, 5);
> ac.temperature = 50; //No hay ningún control si se hace público
> ```

Cuando se realizan chequeos en los setters para que el valor cumpla con alguna restricción, podemos hacer que el método se comporte de dos formas distintas:

1. Como hemos hecho antes. Es decir, si no cumplen los criterios, no se modifica o se modifica de manera que cumpla los criterios.

2. Lanzar una excepción cuando no cumple los criterios. Por ejemplo:

   ```java
   public void setEdad(int edad){
   	if ((edad < 0 ) || (edad > 150))
           throw new IllegalArgumentException("La edad debe estar comprendida entre 0 y 150");
       this.edad = edad;
   }
   ```

   Y ahora, en el programa principal debemos capturar esta excepción:

   ```java
   public class MainPersona {
       public static void main(String[] args) {
           Persona p = new Persona("Pepe", 30, 'H');
           try{
               p.setEdad(199);
           }catch (IllegalArgumentException iae){
               System.out.println(iae.getMessage());
           }
       }
   }
   ```

### Fluent setters

En este ejemplo trabajamos con los setters clásicos que no devuelven nada:

```java
class Triangulo {
    private String color;
    private int angle;
    private int x;
    private int y;
    public Triangulo setColor(String color){
        this.color = color;
        return this;
    }

    public void setAngle(int angle){
        this.angle = angle;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
}
public class MainTriangulo {
    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo();
		//Para usar un setter se debe prefijar siempre con el nombre de la instancia
        triangulo.setColor("Rojo");
        triangulo.setAngle(90);
        triangulo.setX(10);
        triangulo.setY(20);
    }
}
```

Y con fluent setters:

```java
class Triangulo {
    private String color;
    private int angle;
    private int x;
    private int y;
    public Triangulo setColor(String color){
        this.color = color;
        return this;
    }
	//Ahora los setters devuelven un objeto Triangulo que es el objeto mismo
    public Triangulo setAngle(int angle){
        this.angle = angle;
        return this;
    }

    public Triangulo setX(int x){
        this.x = x;
        return this;
    }
    public Triangulo setY(int y){
        this.y = y;
        return this;
    }
}
public class MainTriangulo {
    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo();
        // Sólo se prefija en el primer setter
        triangulo.setColor("Rojo")
                .setAngle(90)
                .setX(10)
                .setY(20);
    }
}
```

Ahora los setters devuelven un objeto de la clase `Triangulo` que es el objeto mismo. Fíjaos que ahora es más fácil crear las instancias y el código es más legible y fácil de mantener:

```java
Triangulo triangulo = new Triangulo();
triangulo.setColor("Rojo").setAngle(90).setX(10).setY(20);
//Habitualmente se escribe cada método en una línea
triangulo.setColor("Rojo")
         .setAngle(90)
         .setX(10)
         .setY(20);

```

Como `setColor` devuelve un objeto `Triangulo` puedo concatenar los métodos. Se suele usar cuando creamos objetos con muchos parámetros.

## toString

Tenemos la siguiente clase:

```java
public class Ciudad {
    private String nombre;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
```

y una clase con un método `main` que imprime un objeto de esta clase:

```java
public class MainCiudad {
    public static void main(String[] args) {
        Ciudad ciudad = new Ciudad("Castellón");
        System.out.println(ciudad);
    }
}
```

El resultado de la salida será:

```
Ciudad@6504e3b2
```

**¿Por qué?**  Java llama al método `toString` del objeto y esta cadena que vemos arriba es la que imprime la clase `Object`, de la que derivan todas las clases en java.

Si vemos el código de este método en la clase `Object`:

```java
package java.lang;

public class Object {
/// otros métodos
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
```

Aquí se ve cómo imprime el nombre de la clase, el símbolo de la arroba y una cadena hexadecimal.

Si queremos personalizar esta cadena, hemos de sobrescribir el método `toString`

```java
public class Ciudad{
    //....
    @Override
    public String toString() {
        return this.nombre;
    }
}
```

Ahora el resultado de imprimir es 

```
Castellón
```

**Y ¿qué significa `Override`?**

La anotación `@Override` simplemente se utiliza, para forzar al compilador a comprobar en tiempo de compilación que estás sobrescribiendo correctamente un método, y de este modo evitar errores en tiempo de ejecución, los cuales serían mucho más difíciles de detectar.

Por ejemplo, si fueras a sobrescribir el método `toString()` de la clase `Object` y lo haces de este modo:

```java
public class MiClase {

    public String ToString() {
         return this.nombre;
    }
}
```

realmente no estás sobrescribiendo el método, sino creando uno nuevo, ya que el nombre correcto comienza con minúscula y no con mayúscula. Si antepones `@Override` el compilador te indica que no hay ningún método para sobrescribir con dicha signatura:

![image-20240201115547833](/programacion-java/assets/img/poo/image-20240201115547833.png)

Es decir, con `@Override` te aseguras que sobrescribes el método correcto.

## La palabra reservada `this`

Cuando trabajamos dentro de una clase, para hacer referencia a atributos y métodos de la instancia se antepone la palabra reservada `this` al atributo o método:

```java
public class Libro{
    private String titulo;
    //Resto de la clase
    @Override
    public String toString(){
        return this.titulo;
    }
}
```

En este caso estamos indicado que `titulo` es un atributo de la clase y se corresponde con el objeto `Libro` actual. De hecho, también se podría hacer:

```java
public class Libro{
    private String titulo;
    //Resto de la clase
    @Override
    public String toString(){
        return titulo;
    }
}
```

Fijáos que he eliminado la palabra `this`. Y entonces, ¿para qué sirve? La respuesta es para discriminar entre un atributo de la clase y una variable de un método, como en el siguiente setter:

```java
public class Libro{
    private String titulo;
    //Resto de la clase 
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
}
```

`this.titulo = titulo;` hace que el campo `titulo` se iguale a la variable local (parámetro) `titulo` que se pasa como dato en el parámetro del método. Parece un galimatías. Lo verás más claro de la siguiente forma:

```java
public class Libro{
    private String titulo;
    //Resto de la clase 
    public void setTitulo(String dato){
        this.titulo = dato;
    }
}
```

**Pero esta forma no suele usarse**; sólo aparece a modo explicativo.

Se suele anteponer la palabra reservada `this` delante de todos los métodos y parámetros de la clase.

Usar `this` también puede mejorar la legibilidad y la autodocumentación del código al indicar explícitamente que te estás refiriendo a una variable de instancia de la clase.

## Estado de una instancia

El estado de una instancia es el **valor que tienen cada uno de los atributos en un momento dado del ciclo de vida de la misma.**

## Modificadores dentro de una clase

A la hora de definir atributos o métodos en una clase, es posible indicar un **modificador de acceso**. Veamos con más detalle cuáles están en la sintaxis de Java.

El modificador de acceso puede tomar cuatro valores:

- `public`, que da acceso a todo el mundo.
- `private`, que prohíbe el acceso a todos menos por los métodos de la propia clase.
- `protected`, que se comporta como `public` para las clases derivadas de la clase y como `private` para el resto de clases.
- Sin modificador, que se comporta como `public` para las clases del mismo paquete y como `private` para el resto de clases.

En nuestros ejemplos, vamos a declarar **todos** los atributos privados y el resto de métodos de la clase `public`  

## Variables estáticas

En algunos casos nos puede interesar usar variables estáticas. Son un tipo de variable especial cuyo valor es compartido por todas las instancias de la clase:

Por ejemplo, tenemos una clase `Person` y un atributo `id` que debe ser único para cada instancia. Creamos una variable estática `currentID` inicializada a 0 y que se vaya incrementando cada vez que se crea una instancia.

```java
class Persona{
    private String nombre;
    private int edad;
    private char sexo;
    private int ID;
    private static int nextID = 1;
    public Persona(String nombre, int edad, char sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        //Se debe prefijar con el nombre de la clase si hay coincidencia de nombres de variable o sin prefijar cuando no la hay
        this.ID = Persona.nextID++;  // o nextID++;
    }
    public int getID() {
        return ID;
    }
}
public class MainPersona {
    public static void main(String[] args) {
        Persona p = new Persona("Pepe", 30, 'H');
        Persona p2 = new Persona("María", 20, 'F');
        System.out.println(p.getID());
        System.out.println(p2.getID());
    }
}
```

El valor de esta variable es compartido por todas las instancias de esta clase

```java
private static int nextID = 1;
```

y 

```java
 this.ID = Persona.nextID++;  // o nextID++;
```

hace que se incremente este valor cada vez que se crea una instancia de la clase.

La salida es:

```
1
2
```

## Métodos estáticos

Al igual que las variables estáticas, los métodos estáticos son compartidos por todas las instancias de la clase. Esto hace que un método estático no pueda acceder a variables de estado de las instancias. Se usan cuando queremos llamar a dicho método sin necesidad de crear un objeto.

Por ejemplo, parte de las clases proporcionadas por Java, tienen métodos estáticos:

```java
package java.lang;
public final class String{
    //...
	public static String valueOf(int i){
        //...
    }
```

```java
 String c = String.valueOf(1); //Devuelve la cadena "1"
```

De los métodos `static` hay que saber:

- Se llaman utilizando la sintaxis `NombreClase.nombreMétodo()`. El lenguaje Java permite llamarles por el nombre de un objeto de la clase, pero no es lógico.
- En su código **no se puede** utilizar la palabra reservada `this`, puesto que la ejecución no se efectúa sobre ningún objeto en concreto de la clase.
- En su código sólo se puede acceder a sus propios argumentos y los datos `static` de la clase.
- No se pueden sobrescribir (sobrecargarlos en clases derivadas) para hacerlos **no** `static` en las clases derivadas.

## Packages

Las clases se suelen organizar por **paquetes**, agrupando clases relacionadas dentro de ellos. Los paquetes pueden, a su vez, contener más paquetes. Se trata de una estructura en forma de árbol parecida al sistema de directorios.

Por ejemplo, la clase `Scanner` se encuentra dentro de un paquete llamado `java.util` 

```java
//fichero: java/util/Scanner.java
package java.util;
public class Scanner{
```

Y la clase `Random` también se encuentra en el mismo paquete:

```java
//fichero: java/util/Random.java
package java.util;
public class Random{
```

Por ejemplo, si una clase reside en el directorio **cadenas/traducir** tendrá como **package** `cadenas.traducir`

```java
//fichero: cadenas/traducir/Chino.java
package cadenas.traducir;
public class Chino{
```

y otra del mismo paquete 

```java
//fichero: cadenas/traducir/Rumano.java
package cadenas.traducir;
public class Rumano{
```

Si en otro programa queremos usar estas clases, hemos de importarlas:

```java
import cadenas.traducir.Chino;
import cadenas.traducir.Rumano;
```

Si queremos importar todas las clases de un paquete usamos el `*`

```java
import cadenas.traducir.*;
```

> -info-En el desarrollo de aplicaciones en Java es necesario tener especial cuidado en utilizar nombres que sean únicos y así poder asegurar su reutilización en una gran organización y, más aún, en cualquier lugar  del mundo. Esto puede ser una tarea difícil en una gran organización y absolutamente imposible en la comunidad de Internet. Por eso se propone que toda organización utilice el nombre de su dominio, invertido, como prefijo para todas las clases. Es decir, los paquetes de clases desarrollados en el IES El Caminàs, que tiene como dominio “ieselcaminas.org”, podrían empezar por “org.ieselcaminas”.

## Wrappers

Los wrappers son clases creadas envolviendo de tipos primitivos. Si usamos wrappers, estamos trabajando con objetos y con los tipos primitivos no usamos objetos.

El uso de wrappers en lugar de tipos primitivos aporta ventajas, pero también puede darnos el problema que al pasar una variable a un método  como argumento si es de un tipo primitivo se le pasa por valor y si se pasa como wrapper (objeto) se lo pasamos por referencia.

Una de las ventajas que tienen los wrappers es la facilidad de conversión entre tipos primitivos y cadenas de caracteres en ambos sentidos. Existen wrappers de todos los tipos primitivos numéricos:

| Tipo primitivo | WRAPPER asociado |
| -------------- | ---------------- |
| byte           | Byte             |
| short          | Short            |
| int            | Integer          |
| long           | Long             |
| double         | Double           |
| char           | Character        |
| boolean        | Boolean          |

Por ejemplo, en el caso de que debamos usar el valor `int` de un `Integer`  usaremos 

```java
Integer a = new Integer(50);
int b = a.intValue();
```

Para cada wrapper existe un método para convertirlo a su tipo primitivo.

## Clases y métodos abstractos y finales

La **abstracción** es una de las características de la **POO**. Mediante la abstracción lo que se hace es extraer la esencia básica y su comportamiento para luego representarla en un lenguaje de programación. 

### Clases y métodos abstractos

Las clases abstractas han sido pensadas para ser genéricas, es decir, no va a haber objetos de esas clases, se generarán subclases de la genérica que sí tendrán objetos.

Por ejemplo, la clase `Vehiculo` es una clase genérica porque cuando implementemos un programa con esta clase no se crearán vehículos sino objetos de la clase `Coche` u objetos de la clase `Moto`, etc. Todos son  vehículos y por tanto esa clase abstracta solamente definirá atributos y métodos comunes a todos los vehículos (por ejemplo: color, peso,  matrícula, `repararMotor()`, etc.).

```java
public abstract class Vehiculo {
	private int peso;

	public void setPeso(int p){
      this.peso = p;
    }

	public abstract void repararMotor();
}
```

Como esta clase define un método como `abstract` toda la clase pasa a ser abstracta aunque no la hubiéramos definido como `abstract`.

Vamos a crear la clase `Coche`

```java
public class Coche extends Vehiculo{
    @Override
	public void repararMotor(){
		//Procedimiento para reparar el motor del coche
	}
}
```

Y `Moto`

```java
public class Moto extends Vehiculo{
	@Override
	public void repararMotor(){
		//Procedimiento para reparar el motor de la moto
	}
}
```

Ahora podemos crear objetos de las clases `Coche` y `Moto` pero no de `Vehiculo` porque esta es abstracta.

Como se ve en la clase `Vehiculo`, una clase abstracta puede implementar métodos abstractos y no abstractos.

Debemos recordar que:

- De las clases abstractas no se pueden crear objetos.
- Si una clase tiene métodos `abstract` por fuerza será una clase abstracta.
- Un método `abstract` no puede ser `static`.
- Las subclases de la clase abstracta tendrán que redefinir esos métodos o bien declararlos también como `abstract` en cuyo caso tampoco se podrá crear instancias de la misma

### Objetos, clases y métodos finales

**Objetos finales**

Cuando un objeto se declara como `final`, éste impedirá que haya otro objeto con la misma referencia. Por ejemplo cuando hagamos:

```java
final Cuadrado c1 = new Cuadrado(5);
Cuadrado c2 = new Cuadrado(15);
c1 = c2;
```

El compilador mostrará un mensaje de error en la tercera línea similar a:

```java
Exception in thread "main" java.lang.Error: Problema de compilación no resuelto:
La variable local final c1 no puede asignarse. Debe estar en blanco y no utilizar una asignación compuesta
```

**Métodos finales**

Cuando declaramos un método como `final`, le estamos diciendo al compilador que ese método no va a cambiar, no va a ser sobrescrito, con lo cual el compilador puede colocar el *bytecode* del método en el sitio del programa donde va a ser invocado con la consiguiente ganancia de eficiencia.

```java
public final void setColor (String s) { 
	color = s;
}
```

**Clases finales**

Cuando una clase se declara como `final`, esa clase no puede tener subclases. Por ejemplo, la siguiente clase `Triangulo` no podrá tener subclases que deriven de ella.

```java
public final class Triangulo {

}
```

## Interfaces

Vamos a suponer que tenemos un zoo y a los gatos y tiburones les  hemos enseñado a jugar a varias cosas: saltar por un aro, perseguir un  objeto, …. Pero los perros y los peces payaso no saben hacerlo. ¿Cómo  hacemos para que clases que comparten acciones pero están en ramas  distintas de nuestra jerarquía de clases puedan hacer una misma cosa? La respuesta son las interfaces.

Una interfaz es una especie de contrato que han de cumplir todas aquellas clases que implementen la misma.

Vamos a verlo con un ejemplo:

```java
package reinoanimal;

public interface Jugable {
    void saltarPorUnAro();
    void perseguirUnObjeto(String objeto);
}
```

Hemos definido una interfaz llamada `Jugar` que tiene dos métodos: `saltarPorUnAro()` y `perseguirUnObjeto()`. Fijaos que los métodos están vacíos, ya que cada clase que implemente la interfaz lo hará de una forma distinta.

Ahora vamos a hacer que el `Gato` *sepa* `Jugar`. Para ello hemos de modificar la cabecera de la clase para que  implemente esta interfaz e implementar los métodos definidos en ella:

```java
package reinoanimal;

public class Gato extends Mamifero implements Jugable{
	///...
    @Override
    public void saltarPorUnAro(){
        System.out.println("Sé saltar por una aro");
    }

    @Override
    public void perseguirUnObjeto(String objeto){
        System.out.println("Sé perseguir un " + objeto);
    }
}
```

Y también hacemos que los `Tiburones` *sepan* `Jugar`:

```java
package reinoanimal;

public class Tiburon extends Pez implements Jugar{
	//...
    @Override
    public void saltarPorUnAro(){
        System.out.println("Sé saltar por una aro");
    }

    @Override
    public void perseguirUnObjeto(String objeto){
        System.out.println("sé perseguir un " + objeto);
    }
}
```

Ahora vamos a contratar a un `Entrenador` para nuestro zoo. Este será el encargado de entrenar a los animales,  pero, evidentemente sólo puede hacerlo con aquellos que sepan *jugar*.

```java
package reinoanimal;

public class Entrenador extends Mamifero{

    public Entrenador(String nombre){
        super("Nombre");
    }
}
```

Y ahora implementamos un método para entrenar a un `Animal`. Pero sólo pueden entrenar a aquellos que saben *jugar*!

Para eso están las interfaces.

```java
/**
 * Permite entrenar a aquellos animales que saben jugar
 */
public void entrenar(Jugar animalQueSabeJugar){
    animalQueSabeJugar.saltarPorUnAro();
}
```

Como se puede observar, el método tiene un parámetro que es una  interfaz. De esta forma, sólo podemos invocar a este método si le pasamos un `Animal` que implemente dicha interfaz. 

Al intentar pasar como argumento al método `Entrenador.entrenar()`, da un error al pasarle un objeto de la clase `Perro` que no implementa la interfaz `Jugar`.

Sin embargo, sí que podemos entrenar al `Gato` porque sí que la implementa.

Ahora vamos a suponer que el mismo entrenador tiene otro método llamado `dejarEntrar`. Este método recibe como parámetro un `Animal`. Pero sólo va a dejarle entrar si sabe *jugar*.

En este caso usamos `instanceof` que permite saber si un clase es de un tipo concreto (o hereda) o si implementa una interfaz (o una superclase la implementa). Pero en este caso nos hemos de asegurar que implementa la interfaz ya que, de lo contrario, daría un error en tiempo de ejecución.

```java
/**
     * Solo deja entrar a aquellos animales que saben jugar
     */
public void dejarEntrar (Animal animal){
    if (!(animal instanceof Jugar))
        throw new IllegalArgumentException(animal.getClass().getName() + " no implementa la interfaz Jugar");
    System.out.println("Pasa y te entreno");
}
```

En el caso de llamar con un objeto `Perro` daría la siguiente excepción que habría que capturar:

```java
Exception in thread "main" java.lang.IllegalArgumentException: reinoAnimal.Perro no implementa la interfaz Jugar
	at reinoAnimal.Entrenador.dejarEntrar(Entrenador.java:20)
	at reinoAnimal.Zoo.main(Zoo.java:31)
```

### Acoplamiento

Otro uso que se hace de los interfaces es para evitar el **acoplamiento** entre las clases. El acoplamiento se puede definir como qué tanto están unidos los componentes que conforman una aplicación.

Por ejemplo. Supongamos que deseamos implementar un programa para fotógrafos y después del análisis surgen dos clases: `Fotografo` y `Camara`:

Y esta es la implementación:

```java
package fotografia;

public class Camara{
    private String nombre;
    public Camara(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void tomarFoto(){
        System.out.println("hago una foto con la cámara");
    }
}
```

Y esta es la clase `Fotografo`

```java
package fotografia;

public class Fotografo {
    private String nombre;
    private Camara camara;
    public Fotografo(String nombre, Camara camara) {
        this.nombre = nombre;
        this.camara = camara;
    }

    public String getNombre() {
        return nombre;
    }
    public String tomarFoto(){
        this.camara.tomarFoto();
    }
}
```

Y ahora creamos los objetos:

```java
Camara camara = new Camara("Canon");
Fotografo fotografo = new Fotografo("Miguel", camara);
fotografo.tomarFoto();
```

Hemos fijado la propiedad `Camara` en el constructor. Está claro que `Camara` y `Fotografo` están totalmente acoplados. Si ahora el fotógrafo decide tomar las fotos también con un Móvil. ¿Cómo lo hacemos?

Pues para eso están las interfaces. Primero creamos la interfaz `TomarFoto`

```java
package fotografia;

public interface TomarFoto {
    void tomarFoto();
}
```

Y ahora hacemos que `Camara` implemente dicha interfaz:

```java
package fotografia;

public class Camara implements TomarFoto{
    private String nombre;
	//...
	
	@Override
    public void tomarFoto(){
        System.out.println("hago una foto con la cámara");
    }
}
```

Y modificamos ahora la clase `Fotografo` para que se le pueda pasar como parámetro cualquier aparato que pueda `tomarFoto`

```java
package fotografia;

public class Fotografo {
    private String nombre;
    //Ahora aparato es cualquier dispositivo que pueda tomar fotos
    private TomarFoto aparato;
    public Fotografo(String nombre, TomarFoto aparato) {
        this.nombre = nombre;
        this.aparato = aparato;
    }

    public void tomarFoto(){
        this.aparato.tomarFoto();
    }
}
```

Ya podemos hacer la clase `Movil`

```java
package fotografia;

public class Movil implements TomarFoto{
    private String nombre;
    public Movil(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void tomarFoto(){
        System.out.println("hago una foto con el móvil");
    }
}

```

Y creamos los objetos:

```java
Camara camara = new Camara("Nikon");
Fotografo fotografo  = new Fotografo("Juan", camara);
fotografo.tomarFoto();
Movil movil = new Movil("Nokia");
Fotografo fotografo1 = new Fotografo("Pepe", movil);
fotografo1.tomarFoto();
```

Ahora ya no están tan acoplados.

Si ahora también se pueden hacer fotos con las gafas Apple Vision Pro, es tan sencillo como crear una clase para ello que implemente la interfaz `TomarFoto`

```java
package fotografia;

public class VisionPro implements TomarFoto{
    private String nombre;
    public VisionPro(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void tomarFoto(){
        System.out.println("hago una foto con la Vision Pro");
    }
}
```

Y creamos los objetos:

```java
VisionPro visionPro = new VisionPro("Manzana");
Fotografo fotografo  = new Fotografo("Juan", visionPro);
fotografo.tomarFoto();
```

También se puede inyectar la dependencia en un setter. Por ejemplo,

```java
package fotografia;

public class Fotografo {
    private String nombre;
    //Ahora aparato es cualquier dispositivo que pueda tomar fotos
    private TomarFoto aparato;
    public Fotografo(String nombre, TomarFoto aparato) {
        this.nombre = nombre;
        this.aparato = aparato;
    }

    public void tomarFoto(){
        this.aparato.tomarFoto();
    }
    
    // Ahora puedo cambiar el aparato
    public void setAparato(TomarFoto aparato){
        this.aparato = aparato;
    }
}
```

Por ejemplo:

```
Camara camara = new Camara("Nikon");
// Primero la hace con la cámara
Fotografo fotografo  = new Fotografo("Juan", camara);
fotografo.tomarFoto();

Movil movil = new Movil("Nokia");
// Y, a partir de ahora, con el Móvil
fotografo.setAparato(movil);
fotografo1.tomarFoto();
```

