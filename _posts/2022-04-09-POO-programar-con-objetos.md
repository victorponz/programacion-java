---
typora-copy-images-to: ../assets/img/poo/
typora-root-url: ../../
layout: post
title: Programar con objetos
categories: poo
conToc: true
permalink: poo-programar-con-objetos
---

Hay varias formas en que los conceptos orientados a objetos se pueden aplicar al proceso de diseño y escritura de programas. El más amplio de estos es el análisis y diseño orientado a objetos, que aplica una metodología orientada a objetos a las primeras etapas del desarrollo del programa, durante las cuales se crea el diseño general de un programa. Aquí, la idea es **identificar cosas en el dominio del problema** que se pueden modelar como objetos. En otro nivel, la programación orientada a objetos alienta a los programadores a producir **componentes de software generalizados** que se pueden usar en una amplia variedad de proyectos de programación.

Por supuesto, en su mayor parte, experimentará "componentes de software generalizados" al usar las clases estándar que vienen con Java. Comenzamos esta sección mirando algunas clases integradas que se usan para crear objetos. Al final de la sección, volveremos a las generalidades.

## Algunas clases integradas

Aunque el enfoque de la programación orientada a objetos generalmente se encuentra en el diseño e implementación de nuevas clases, es importante no olvidar que los diseñadores de Java ya han proporcionado una gran cantidad de clases reutilizables. Algunas de estas clases están destinadas a ampliarse para producir nuevas clases, mientras que otras se pueden utilizar directamente para crear objetos útiles. Un verdadero dominio de Java requiere estar familiarizado con una gran cantidad de clases integradas, algo que requiere mucho tiempo y experiencia para desarrollarse. Tomemos un momento para ver algunas clases integradas que pueden resultarle útiles.

Se puede construir una cadena a partir de piezas más pequeñas usando el operador +, pero esto no siempre es eficiente. Si `str` es una cadena y `ch` es un carácter, al ejecutar el comando `str = str + ch;` implica crear una cadena completamente nueva que es una copia de `str`, con el valor de `ch` agregado al final. Copiar la cadena lleva algún tiempo. Construir una cadena larga letra por letra requeriría una sorprendente cantidad de procesamiento. La clase `StringBuilder` permite ser eficiente en la construcción de una cadena larga a partir de varias piezas más pequeñas. Para hacer esto, debe crear un objeto que pertenezca a la clase `StringBuilder`. Por ejemplo:

```java
StringBuilder builder = new StringBuilder();
```

(Esta declaración declara el `StringBuilder` y lo inicializa para hacer referencia a un objeto `StringBuilder` recién creado. La combinación de declaración con inicialización funciona para objetos igual que para tipos primitivos).

Al igual que un `String`, un `StringBuilder` contiene una secuencia de caracteres. Sin embargo, es posible agregar nuevos caracteres al final de un `StringBuilder` sin hacer copias continuas de los datos que ya contiene. Si `x` es un valor de cualquier tipo y el constructor es la variable definida anteriormente, entonces el comando `builder.append(x)` agregará `x`, convertida en una representación de cadena, al final de los datos que ya estaban en el constructor. Esto se puede hacer de manera más eficiente que copiar los datos cada vez que se agrega algo. Se puede construir una cadena larga en un `StringBuilder` usando una secuencia de comandos `append()`. Cuando la cadena esté completa, la función `builder.toString()` devolverá una copia de la cadena en el constructor como un valor ordinario de tipo `String`. La clase `StringBuilder` está en el paquete estándar `java.lang`, por lo que puedes usar su nombre simple sin importarlo.

En el paquete `java.util` se recopilan varias clases útiles. Por ejemplo, este paquete contiene clases para trabajar con colecciones de objetos. Estudiaremos extensamente tales clases de colección más adelante. Y ya hemos encontrado `java.util.Scanner`. Otra clase en este paquete, `java.util.Date`, se usa para representar tiempos. Cuando un objeto `Date` se construye sin parámetros, el resultado representa la fecha y la hora actuales, por lo que una forma fácil de mostrar esta información es:

```java
System.out.println( new Date() );
```

Por supuesto, dado que está en el paquete `java.util`, para usar la clase `Date` en tu programa, debes hacerla disponible importándola con una de las declaraciones `import java.util.Date;` o `import java.util.*;` al comienzo de tu programa.

También mencionaré la clase `java.util.Random`. Un objeto que pertenece a esta clase es una fuente de números aleatorios (o, más precisamente, números pseudoaleatorios). La función estándar `Math.random()` usa uno de estos objetos detrás de escena para generar sus números aleatorios. Un objeto de tipo `Random` puede generar enteros aleatorios, así como números reales aleatorios. Si `randGen` se crea con el comando:

```java
Random randGen = new Random();
```

y si `N` es un entero positivo, entonces `randGen.nextInt(N)` genera un entero aleatorio en el rango de **0** a **N-1**. Por ejemplo, esto hace que sea un poco más fácil lanzar un par de dados. En lugar de decir `die1 = (int)(6*Math.random())+1;`, se puede decir `die1 = randGen.nextInt(6)+1;`. (Dado que también tiene que importar la clase `java.util.Random` y crear el objeto `Random`, es posible que no esté de acuerdo en que en realidad es más fácil). Un objeto de tipo `Random` también se puede usar para generar los llamados números reales aleatorios distribuidos gaussianos. .

Algunas de las clases estándar de Java se utilizan en la programación de GUI. Aquí mencionaré solo la clase `Color`, del paquete `javafx.scene.paint`, para poder usarla en el siguiente ejemplo. Un objeto `Color` representa un color que se puede utilizar para dibujar. Hay constantes de color como `Color.RED`. Estas constantes son variables miembro estáticas finales en la clase `Color` y sus valores son objetos de tipo `Color`. También es posible crear nuevos objetos de color, la clase `Color` tiene un nuevo constructor `Color(r,g,b,a)`, que toma cuatro parámetros dobles para especificar los componentes rojo, verde y azul del color, además de un componente "alfa" que dice qué tan transparente es el color. Los parámetros deben estar en el rango de 0.0 a 1.0. Por ejemplo, un valor de 0,0 para `r` significa que el color no contiene rojo, mientras que un valor de 1,0 significa que el color contiene la máxima cantidad posible de rojo. Cuando dibuja con un color parcialmente transparente, el fondo se muestra hasta cierto punto a través del color. Un valor mayor del cuarto parámetro da un color que es menos transparente y más opaco.

Un objeto `Color` tiene solo unos pocos métodos de instancia que es probable que utilice. Principalmente, existen funciones como `getRed()` para obtener los componentes de color individuales del color. No existen métodos de "setter" para cambiar los componentes de color. De hecho, un `Color` es un objeto inmutable, lo que significa que todas sus variables de instancia son `final` y no se pueden cambiar después de crear el objeto. Las cadenas son otro ejemplo de objetos inmutables, y haremos algunos propios más adelante en este capítulo.

El punto principal de todo esto, nuevamente, es que muchos problemas ya han sido resueltos y las soluciones están disponibles en las clases estándar de Java. Si se enfrenta a una tarea que parece que debería ser bastante común, podría valer la pena revisar una referencia de Java para ver si alguien ya ha escrito una clase que pueda usar.

## La clase `Object`

Ya hemos visto que una de las principales características de la programación orientada a objetos es la capacidad de crear subclases de una clase. La subclase hereda todas las propiedades o comportamientos de la clase, pero puede modificar y agregar a lo que hereda. Más tarde aprenderás cómo crear subclases. Lo que aún no sabes es que cada clase en Java (con solo una excepción) es una subclase de alguna otra clase. Si crea una clase y no la convierte explícitamente en una subclase de alguna otra clase, automáticamente se convierte en una subclase de la clase especial denominada `Object`, en el paquete `java.lang`. (`Object` es la única clase que no es una subclase de ninguna otra clase).

La clase `Object` define varios métodos de instancia que son heredados por cualquier otra clase. Estos métodos se pueden utilizar con cualquier objeto que sea. Mencionaré dos de ellos aquí. ç

El método `equals(obj)` se define en la clase `Object`. Toma un parámetro, que puede ser cualquier objeto. Está destinado a probar si dos objetos son "iguales", pero su definición le da a obj1.equals(obj2) el mismo significado que `obj1 == obj2`. Es decir, comprueba si `obj1` y `obj2` se refieren al mismo objeto. La clase `String` anula este método para decir que dos `Strings` son iguales si contienen la misma secuencia de caracteres, y es común anular de manera similar `equals()` en una clase para decir que dos objetos que pertenecen a esa clase son iguales si tienen los mismos contenidos. Vemos nuevamente que lo que significa que los objetos sean "iguales" no siempre está claro. Tendremos más uso de este método más adelante.

El método de instancia `toString()` en la clase `Object` devuelve un valor de tipo `String` que se supone que es una representación de cadena del objeto. Ya ha utilizado este método implícitamente, cada vez que imprimió un objeto o concatenó un objeto en una cadena. Cuando usa un objeto en un contexto que requiere una cadena, el objeto se convierte automáticamente al tipo Cadena llamando a su método `toString()`.

La versión de `toString` que se define en `Object` simplemente devuelve el nombre de la clase a la que pertenece el objeto, concatenado con un número de código llamado código hash del objeto; esto no es muy útil. Cuando crea una clase, puede escribir un nuevo método `toString()` para ella, que reemplazará la versión heredada. Por ejemplo, podríamos agregar el siguiente método a cualquiera de las clases `PairOfDice` de la sección anterior:

```java
**
 * Return a String representation of a pair of dice, where die1
 * and die2 are instance variables containing the numbers that are
 * showing on the two dice.
 */
public String toString() {
   if (die1 == die2)
      return "double " + die1;
   else
      return die1 + " and " + die2;
}
```

Si `dice` hace referencia a un objeto `PairOfDice`, entonces `dice.toString()` devolverá cadenas como "3 and 6", "5 and 1" y "double 2", según los números que se muestren en los dados. Este método se usaría automáticamente para convertir los dados al tipo `String` en una declaración como

```java
System.out.println( "The dice came up " + dice );
```

por lo que esta declaración podría dar como resultado, "The dice came up 5 and 1" o "The dice came up double 2". Verás otro ejemplo de un método `toString()` en la siguiente sección.

El elemento fundamental de todo programa orientado a objetos es el **objeto**. Estos objetos se generan a partir de un archivo de código fuente, una **clase**, donde se definen sus **propiedades** y su **comportamiento** (**atributos** y **métodos**). El lenguaje Java proporciona un conjunto de clases ya creadas que pueden utilizarse directamente, pero casi siempre es necesario generar clases nuevas, de acuerdo a las necesidades de cada programa concreto. Por tanto, la clave para poder generar el código fuente de un programa orientado a objetos está en el hecho de saber cómo generar código para declarar clases correctamente.

### Codificación de clases

La codificación de una clase sigue la siguiente sintaxis, en la que se aprecian dos partes bien diferenciadas:

```
DeclaraciónDeLaClase {
  CuerpoDeLaClase
}
```

Cada una de las dos partes (declaración y cuerpo) puede ser más o menos compleja y, como suele suceder en el aprendizaje de cualquier lenguaje, empezaremos por las formas más simples para avanzar posteriormente hacia formas más complejas.

En principio, todas las clases que hemos diseñado han tenido, como declaración, la siguiente sintaxis:

```java
public class <NombreClase>
```

Esta declaración puede verse ampliada con otros modificadores (además de `public`) a la izquierda de la palabra `class` y con unos modificadores a la derecha de `NomreClase`. Pero para crear las primeras clases no los necesitamos.

El cuerpo de la clase es una secuencia de tres tipos de componentes:

1. Los relativos a los datos que contendrán los objetos de la clase (los atributos).
2. Los relativos a bloques de código sin nombre, conocidos como iniciadores.
3. Los relativos a los métodos que la clase proporciona para manejar los datos que almacena.

En principio estos tres tipos de componentes se pueden incluir dentro de la definición de la clase en cualquier orden, pero existe el convenio de empezar con los datos, continuar con los iniciadores y finalizar con los métodos.

Así pues:

```
public class <NombreClase> {
  <secuenciaDeclaracionesDeDatos>;
  <secuenciaInicializadores>;
  <secunciaDefinicionesDeMétodos>
}
```

Un archivo de código Java puede incorporar varias clases, pero normalmente lo mejor es que sólo se declare una en cada archivo. El nombre del archivo debe ser exactamente igual al de la clase (incluidas mayúsculas/minúsculas)

### Declaración de datos o atributos

La secuencia de declaraciones de datos consiste en declaraciones de variables de tipo primitivos y/o de referencias a objetos de otras clases, siguiendo la siguiente sintaxis:

```
[<modificadores>] <nombreTipo> <nombreDato> [=<valorInicial>];
```

En esta sintaxis vemos que la declaración del dato puede estar precedida por unos modificadores. Normalmente, siempre se utilizará el modificador `private`, excepto en casos especiales, como la declaración de **constantes**. En este caso, se usa `public static final`.

Vemos también que la declaración de un dato puede estar acompañada de una inicialización explícita (`=<valorInicial>)`.

> -info-Java inicializa implícitamente los datos de los objetos durante el proceso de creación, pero no inicializa las variables declaradas en métodos.

En el momento en que crea cada dato, Java realiza una inicialización implícita de todos los datos con valor cero para los tipos enteros, reales y carácter, con valor false para el tipo lógico y con valor null para las variables de referencia. Posteriormente se ejecutan las inicializaciones explícitas que haya podido indicar el programador en la declaración del dato.

### Inicializadores

Los inicializadores son bloques de código (sentencias entre claves) que se ejecutan cada vez que se crea un objeto de clase. Se definen siguiendo la siguiente sintaxis:

```
{
  <conjunto_de_sentencias>;
}
```

¿Qué sentido tiene la existencia de iniciadores si ya disponemos de constructores para indicar el código a ejecutar en la creación de objetos? La respuesta es que a veces podemos tener bloques de código a ejecutar en el proceso de creación de un objeto de la clase, sea cual sea el constructor (pueden haber varios) empleado en la creación, y la utilización de iniciadores nos permite no tener que repetir el mismo código dentro de los distintos constructores.

Además, los iniciadores también son indicados para ser utilizados en el diseño de clases anónimas, que al no tener nombre no pueden tener métodos constructores.

En caso de existir varios iniciadores se ejecutan en el orden en que se encuentren en la clase.

### Definición de las operaciones

La secuencia de definiciones de operaciones consiste en la definición (prototipo y contenido) de los diversos métodos con la sintaxis de Java. La forma más simple de definir un método en Java sigue la siguiente sintaxis:

```
[<modificadores>] <tipoRetorno> <nombreMetodo> (<listaArgumentos>) {
  <declaraciónVariablesLocales>
  <cuerpoDelMétodo>
}
```

En esta sintaxis vemos que la declaración del método puede ir precedida de unos modificadores, aunque lo habitual (pero no siempre) será `public`. Sin embargo, para crear los primeros métodos no los necesitamos. Para indicar que un método no devuelve ningún resultado, se utiliza el tipo `void`.

Respecto a la lista de argumentos, cabe comentar que el paso de parámetros en Java siempre es usando el mecanismo llamado por valor, o sea, se garantiza que todo parámetro utilizado en un llamamiento a un método mantiene el valor inicial al finalizar la ejecución sin embargo, si el parámetro es una variable que hace referencia a un objeto, el objeto sí puede ser modificado (no sustituido) dentro del método. Al terminar el llamamiento, esta modificación se mantiene.

Ya estamos en condiciones de diseñar la primera clase y realizar un pequeño programa que compruebe el funcionamiento de los diferentes métodos desarrollados.

## Primera versión de una clase para gestionar personas

Supongamos que se quiere diseñar una clase para gestionar personas, para las que interesa gestionar su dni, nombre y edad.

Tomamos las primeras decisiones de diseño y decidimos que **dni** y `nombre` deben ser objetos `String` y que **edad** debe ser un `short`. Respecto a los métodos, en un principio se nos ocurre desarrollar los métodos correspondientes a las operaciones accesoras y, quizás, un método `visualizar()` para mostrar todo el contenido de una persona.

```java
public class Persona {
    final static char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 
                        'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
    String dni;
    String nombre;
    short edad;

    void setDni(String nuevoDni) {
        if (chequeaDNI(nuevoDni))
            dni = nuevoDni;
        else
            throw new IllegalArgumentException();
    }
    void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    void setEdad(int nuevaEdad) {
        if (nuevaEdad < 0 || nuevaEdad > 150)
            throw new IllegalArgumentException();

        edad = (short)nuevaEdad;
    }
    private boolean chequeaDNI(String DNI){
        char letra;
        String numeros;
        int numero;

        if (DNI.length()<8)
            return false;
        
        letra = DNI.charAt(DNI.length()-1);
        numeros = DNI.substring(0, DNI.length()-1);   
        try{
            numero = Integer.valueOf(numeros);
        }catch(NumberFormatException nfe){
            return false;
        }
        int res = numero % 23;
        if (letra != letras[res])
            return false;

        return true;
    }
    String getDni() { return dni; }
    String getNombre() { return nombre; }
    short getEdad() { return edad; }

    @Override
    public String toString() {
        return "Dni:" + dni + "\nNombre:" + nombre + "\nEdad:" + edad;
    }

    public static void main(String args[]) {
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        p1.setDni("34748804J");
        p1.setNombre("Pepe Gotera");
        p1.setEdad(30);
        System.out.println("Visualización de persona p1:");
        System.out.println(p1);
        System.out.println("El dni de p1 es " + p1.getDni());
        System.out.println("El nombre de p1 es " + p1.getNombre());
        System.out.println("La edad de p1 es " + p1.getEdad());
        System.out.println("Visualización de persona p2:");
        System.out.println(p2);
    }
}
```

La ejecución de este programa produce la siguiente salida:

```
Visualización de persona p1:
Dni:34748804J
Nombre:Pepe Gotera
Edad:33
El dni de p1 es 34748804J
El nombre de p1 es Pepe Gotera
La edad de p1 es 33
Visualización de persona p2:
Dni:null
Nombre:null
Edad:0
```

###  Modificadores dentro de una clase

A la hora de definir atributos o métodos en una clase, es posible indicar un **modificador de acceso**. Veamos con más detalle cuáles están en la sintaxis de Java.

El modificador de acceso puede tomar cuatro valores:
* `Public`, que da acceso a todo el mundo.
* `Private`, que prohíbe el acceso a todos menos por los métodos de la propia clase.
* `Protected`, que se comporta como `public` para las clases derivadas de la clase y como `private` para el resto de clases.
* Sin modificador, que se comporta como `public` para las clases del mismo paquete y como `private` para el resto de clases.

Dada la clase `Persona`, si desarrollamos un programa que instancie objetos de la clase, ¿tenemos acceso directo a los datos **dni**, **nombre** y **edad**? Consideramos el siguiente programa en el que se crean objetos de la clase `Persona`.

```java
//Fichero LlamarPersona.java
public class LlamarPersona {
    public static void main(String args[]) {
       Persona p = new Persona();
       p.dni = "--$%#@--";
       p.nombre = "";
       p.edad = -23;
       System.out.println("Visualización de la persona p:");
       p.visualizar();
    }
 }
```

En este caso estamos en un programa externo a la clase `Persona` y se ve cómo accedemos directamente a los datos **dni**, **nombre** y **edad** de la persona creada, y podemos hacer auténticas animaladas. El compilador no se queja (hay que haber compilado también el archivo `Persona.java` en el mismo directorio) y la ejecución da el resultado:

```
Visualización de la persona p:
Dni...........:--$%#@--
Nombre...........:
Edad..........:-23
```

Acabamos de ver, pues, que la versión actual de la clase `Persona` permite el libre acceso a los valores de sus atributos, puesto que en la definición de estos datos no se ha puesto delante el modificador adecuado para evitarlo. Las clases `LlamarPersona` y `Persona`, al estar situadas en el mismo directorio, se han considerado del mismo paquete y, por tanto, al no existir ningún modificador de acceso en la definición de los datos **dni**, **nombre** y **edad**, la clase `LlamarPersona` ha tenido acceso total. Además, al no existir ningún modificador de acceso en la definición de los métodos, éstos no pueden ser llamados por clases de paquetes distintas del paquete al que pertenece la clase `Persona`.

Normalmente, al crear clases lo correcto es que los atributos no tengan acceso directo. Los motivos son:

* Proteger los datos de modificaciones impropias.

* Facilitar el mantenimiento de la clase, ya que si por algún motivo se cree que es necesario efectuar alguna reestructuración de datos o de funcionamiento interno, se podrán efectuar los cambios pertinentes sin afectar a las aplicaciones desarrolladas (siempre que no se modifiquen los prototipos de los métodos existentes) .

Así pues, parece lógico hacer evolucionar la versión actual de la clase `Persona` hacia una clase que tenga los **datos declarados como privados** y los **métodos como públicos**. Fijémonos en que el método `main` para comprobar el funcionamiento de una clase siempre ha sido declarado público.

### Versión final

A continuación presentamos una versión evolucionada de la clase `Persona` que incluye los modificadores de acceso adecuados: datos a `private` y métodos a `public`.

```java
public class Persona {
    final static char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 
                        'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
    private String dni;
    private String nombre;
    private short edad;

    public void setDni(String nuevoDni) {
        if (chequeaDNI(nuevoDni))
            dni = nuevoDni;
        else
            throw new IllegalArgumentException();
    }
    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public void setEdad(int nuevaEdad) {
        if (nuevaEdad < 0 || nuevaEdad > 150)
            throw new IllegalArgumentException();

        edad = (short)nuevaEdad;
    }
    private boolean chequeaDNI(String DNI){
        char letra;
        String numeros;
        int numero;

        if (DNI.length()<8)
            return false;
        
        letra = DNI.charAt(DNI.length()-1);
        numeros = DNI.substring(0, DNI.length()-1);   
        try{
            numero = Integer.valueOf(numeros);
        }catch(NumberFormatException nfe){
            return false;
        }
        int res = numero % 23;
        if (letra != letras[res])
            return false;

        return true;
    }
    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public short getEdad() { return edad; }

    public void visualizar() {
        System.out.println("Dni...........:" + dni);
        System.out.println("Nombre...........:" + nombre);
        System.out.println("Edad..........:" + edad);
    }

    public static void main(String args[]) {
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        p1.setDni("34748804J");
        p1.setNombre("Pepe Gotera");
        p1.setEdad(30);
        System.out.println("Visualización de persona p1:");
        p1.visualizar();
        System.out.println("El dni de p1 es " + p1.getDni());
        System.out.println("El nombre de p1 es " + p1.getNombre());
        System.out.println("La edad de p1 es " + p1.getEdad());
        System.out.println("Visualización de persona p2:");
        p2.visualizar();
    }
}
```

Con esta versión de la clase `Persona` compilada, veamos qué sucede cuando intentamos compilar la clase `LlamarPersona` que crea una persona e intenta acceder directamente a los datos:

```
LlamarPersona.java:5: error: dni has private access in Persona
       p.dni = "--$%#@--";
        ^
LlamarPersona.java:6: error: nombre has private access in Persona
       p.nombre = "";
        ^
LlamarPersona.java:7: error: edad has private access in Persona
       p.edad = -23;
        ^
3 errors
```

> -info-¿Puede tener sentido un método `private`? La respuesta es afirmativa, ya que en el diseño de una clase puede interesar desarrollar un método interno para ser llamado en el diseño de otros métodos de la clase y no quiere darse a conocer a la comunidad de programadores que utilizarán la clase. En nuestro caso hemos hecho `private` el método que comprueba el DNI

## Sobrecarga (overloading) de métodos

En ocasiones, en los programas, es necesario diseñar varias versiones de métodos que tienen un mismo significado y/u objetivo pero que se aplican en diferentes tipos y/o número de datos. Así, si necesitábamos disponer de una función que supiera sumar dos enteros y de una función que supiera dos dos reales, podríamos hacer simplemente dos métodos diferentes llamados `sumaEnteros` y `sumaReales`. Ambos tienen el mismo objetivo y significado, aunque la gestión interna puede ser bastante diferente, y desde un punto de vista lógico, como ambas permiten calcular una suma,

Java permite declarar métodos repetidos con el mismo nombre. Esto no es posible en todos los lenguajes de programación. Por ejemplo:

```java
public int suma (int n1, int n2) { ... }
public double suma (double r1, double r2) { ... }
```

> -info-La sobrecarga de métodos es la funcionalidad que permite tener métodos distintos con un mismo nombre.

Normalmente la sobrecarga de un nombre de método se utiliza en aquellos que tienen un mismo objetivo, pero es lícito utilizarla en métodos que no tengan nada que ver. Esto no suele suceder si el diseñador asigna a los métodos nombres que tengan que ver con su objetivo.

Existen dos reglas para poder aplicar la sobrecarga de métodos:

* La lista de argumentos debe ser suficientemente distinta para permitir una determinación inequívoca del método que se llama.
* Los tipos de datos que devuelven pueden ser diferentes o iguales y no es suficiente con tener los tipos de retorno diferentes para distinguir el método que se llama.

El compilador sólo puede distinguir el método que se llama a partir del número y tipos de los parámetros indicados en la llamada.

Ejemplos de métodos sobrecargados los podemos encontrar en muchas clases proporcionadas por el lenguaje Java. Así, por ejemplo, la conocida clase `String` tiene muchos métodos sobrecargados como `format()`, `getBytes()`, `indexOf()`, etc.

## La palabra reservada `this`

Java existe una palabra reservada especialmente útil para tratar la manipulación de atributos y su inicialización. Se trata de `this`, que tiene dos finalidades principales:

* Dentro de los métodos no constructores, para **referirse al objeto actual** sobre el que se está ejecutando el método. Así, cuando dentro de un método de una clase se quiere acceder a un dato del objeto actual, podemos utilizar la palabra reservada `this`, escribiendo `this.nombreDato`, y si se quiere llamar otro método sobre el objeto actual, podemos escribir `this.nombreMétodo(…)`. En estos casos, la utilización de la palabra `this` es redundante, ya que dentro de un método, para referirnos a un dato del objeto actual, podemos escribir directamente nombre, y para llamar a otro método sobre el objeto actual podemos escribir directamente `nombreMétodo`(…). A veces, sin embargo, la palabra reservada `this` **no es redundante**, como en el caso en que se quiere llamar un método en una clase y hay que pasar el objeto actual como argumento: `nombreMétodo(this)`.
* Dentro de los métodos constructores, como nombre de método para llamar a otro constructor de la propia clase. En ocasiones puede ocurrir que un método constructor tenga que ejecutar el mismo código que otro método constructor ya diseñado. En esta situación sería interesante poder llamar al constructor existente, con los parámetros adecuados, sin tener que copiar el código del constructor ya diseñado, lo que nos lo facilita la palabra reservada `this` utilizada como nombre de método: `this(<listaParámetros>)`. La palabra reservada `this` como método para llamar a un constructor en el diseño de otro constructor sólo se puede utilizar en la primera sentencia del nuevo constructor. Al finalizar la llamada de otro constructor mediante `this`, se continúa con la ejecución de las instrucciones que haya después de la llamada `this(…)`.

**Ejemplo de `this` en un setter.** 

En el código de la clase `Persona` hemos codificado `setNombre `de la siguiente forma:

```java
public void setNombre(String nuevoNombre) {
    nombre = nuevoNombre;
}
```

Sin embargo se suele hacer así

```java
public void setNombre(String nombre) {
    this.nombre = nombre;
}
```

Usando `this.nombre` nos estamos refiriendo al atributo `nombre` del objeto mientras que `nombre` hace referencia al parámetro pasado al setter.

**Ejemplo de `this` en métodos**

En primer lugar, vemos que nos puede interesar tener un constructor para crear una persona a partir de una persona ya existente, es decir, el constructor `Persona (Persona p)`.

Pero, por otro lado, ya tenemos un constructor que sabe construirnos una persona a partir de un **dni**, un **nombre** y una **edad** pasados por parámetro. Por tanto, para construir una persona a partir de una persona `p` dada, nos interesa llamar al constructor pasándole como parámetros el **dni**, el **nombre** y la **edad** de la persona `p`. Esto nos lo facilita la palabra reservada `this` como llamada de un constructor existente:

```java
public Persona (String dni, String nombre, String edad) {
  this.dni = dni;
  this.nombre = nombre;
  this.edad = edad;
}
public Persona (Persona p) {
  this (p.dni, p.nombre, p.edad);
}
```

## Sobreescritura de métodos

Supongamos la siguiente clase `Circle`

```java
public class Circle {
   // private instance variables
   private double radius;
   private String color;

   // Constructors
   public Circle() {
      this.radius = 1.0;
      this.color = "red";
      System.out.println("Constructed a Circle with Circle()");  // for debugging
   }
   public Circle(double radius) {
      this.radius = radius;
      this.color = "red";
      System.out.println("Constructed a Circle with Circle(radius)");  // for debugging
   }
   public Circle(double radius, String color) {
      this.radius = radius;
      this.color = color;
      System.out.println("Constructed a Circle with Circle(radius, color)");  // for debugging
   }

   // public getters and setters for the private variables
   public double getRadius() {
      return this.radius;
   }
   public String getColor() {
      return this.color;
   }
   public void setRadius(double radius) {
      this.radius = radius;
   }
   public void setColor(String color) {
      this.color = color;
   }

   /** Returns a self-descriptive String */
   public String toString() {
      return "Circle[radius=" + radius + ",color=" + color + "]";
   }

   /** Returns the area of this Circle */
   public double getArea() {
      return radius * radius * Math.PI;
   }
}
```



## Elementos estáticos de una clase

> -info-Los datos miembro estático, al ser comunes para todos los objetos de la clase, también se llaman variables clase.

Algunos elementos de una clase pueden declararse como “**estáticos**”. Para ello, el lenguaje Java proporciona la palabra reservada `static`, con tres finalidades:

1. **Como modificador en la declaración de datos miembros de una clase**, para conseguir que el dato afectado sea **común a todos los objetos de la clase**. Para conseguir este efecto, el dato correspondiente se declara con el modificador `static`, siguiendo la siguiente sintaxis:

   ```
   static [<otrosModificadores>] <tipoDato> <nombreDato> [=<valorInicial>];
   ```

   Los datos `static` se crean al efectuar la carga de la clase, cuando todavía no existe ninguna instancia (objeto) de la clase. Dado que un dato `static` es común para todos los objetos de la clase, se accede de manera diferente a la utilizada por los datos `no static`:
    * Para acceder desde fuera de la clase (posible según el modificador de acceso que le acompañe), no se necesita ningún objeto de la clase y se utiliza la sintaxis `NombreClasse.nomDada`. Recuerde que para que esto funcione, igualmente, el dato debe declararse como público.
    * Para acceder desde la propia clase, no es necesario indicar ningún nombre de objeto (`nombreObjeto.nombreDada`), sino directamente su nombre.

   En cualquier caso, el lenguaje Java permite acceder a un dato `static` mediante el nombre de un objeto de la clase, pero no es una nomenclatura coherente.
   
2. **Como modificador en la declaración de métodos de una clase**, para conseguir que el método afectado pueda ejecutarse sin necesidad de ser llamado sobre ningún objeto concreto de la clase.

   Si echa un vistazo a la documentación del lenguaje Java, en la mayoría de las clases se dará cuenta de la existencia de métodos que tienen una sintaxis similar a la siguiente:

   ```
   ... static <valorRetorno> <nombreMétodo> (<listaArgumentos>)
   ```

   Como ejemplo, dentro de la clase `String`, puede ver el método:

   ```java
   public static String valueOf(char[]data)
   ```

   La explicación que le acompaña nos dice que este método, a partir de una tabla de caracteres, nos proporciona un nuevo objeto `String` que contiene la secuencia de valores de la tabla de caracteres. Por tanto, está claro que la ejecución de este método no necesita ningún objeto `String` y, por tanto, es lógico que sea declarado `static`. Ante este razonamiento, ¿puede aparecer la pregunta de por qué, si no necesita de ningún objeto `String`, es declarado como un método de la clase String? La respuesta radica en que en el lenguaje Java todo método debe implementarse en alguna clase y, ya que este método permite conseguir un objeto `String`, parece lógico que resida en la clase `String`.

   Otro caso quizás más habitual y evidente es el método `main` que se usa en las clases principales. Para poder invocar un método es necesario hacerlo sobre un objeto. ¿Pero cómo es posible llamar `main`, si al iniciar la ejecución del programa todavía no existe ningún objeto? ¡Los objetos se crean precisamente dentro del `main`! Este problema sería un pez que se muerde la cola. La respuesta está en hacerlo `static`, de modo que es posible realizar la llamada sin la necesidad de que haya ningún objeto existente previamente.

   De los métodos `static` hay que saber:

    * Se llaman utilizando la sintaxis `NombreClase.nombreMétodo()`. El lenguaje Java permite llamarles por el nombre de un objeto de la clase, pero no es lógico.
   
    * En su código **no se puede** utilizar la palabra reservada this, `puesto` que la ejecución no se efectúa sobre ningún objeto en concreto de la clase.
   
    * En su código sólo se puede acceder a sus propios argumentos y los datos `static` de la clase.

    * No se pueden sobreescribir (sobrecargarlos en clases derivadas) para hacerlos **no** `static` en las clases derivadas.
   
3. **Como modificador de inicializadores (bloques de código sin nombre)**, para conseguir un iniciador que se ejecute únicamente cuando se carga la clase. La carga de una clase se produce en la primera llamada de un método de la clase, que puede ser el constructor involucrado en la creación de un objeto o método estático de la clase. La declaración de una variable para hacer referencia a objetos de clase no provoca la carga de la clase.
   
   La sintaxis a utilizar es:
   
   ```java
   static {...}
   ```
   

### Ejemplo de utilización de la palabra reservada `static` en las diversas posibilidades

La siguiente clase nos muestra una situación en la que la declaración de un dato `static` **es necesaria**, ya que se quiere llevar un contador del número de objetos creados de forma que a cada nuevo objeto se pueda asignar un número de serie a partir del número de objetos creados hasta el momento.

Asimismo parece oportuno proporcionar un método, llamado `numeroObjetosCreados()` para dar información, como su nombre indica, en lo referente al número de objetos creados de la clase en un momento dado.

Por último, se ha incluido un par de iniciadores para comprobar el funcionamiento de los iniciadores `static` y **no** `static`.

```java
//Fichero EjemploUsoStatic.java

public class EjemploUsoStatic {
   private static int contador = 0;
   private int numeroSerie;

   static { System.out.println ("Iniciador \"static\" que se ejecuta al cargar la clase"); }
   
   { System.out.println ("Iniciador que se ejecuta al crear un objeto"); }
   
   public EjemploUsoStatic () {
      contador++;
      numeroSerie = contador;
      System.out.println ("Se acaba de crear el objeto número " + numeroSerie);
   }

   public static int nombreObjectesCreats () {
      return contador;
   }
   
   public static void main(String args[]) {
    EjemploUsoStatic d1 = new EjemploUsoStatic();
    EjemploUsoStatic d2;
      d2 = new EjemploUsoStatic();
      System.out.println("Número de serie de d1 = " + d1.numeroSerie);
      System.out.println("Número de serie de d2 = " + d2.numeroSerie);
      System.out.println("Objetos creados: " + nombreObjectesCreats());
   }
}
```

Que produce la siguiente salida:

```
Iniciador "static" que se ejecuta al cargar la clase
Iniciador que se ejecuta al crear un objeto
Se acaba de crear el objeto número 1
Iniciador que se ejecuta al crear un objeto
Se acaba de crear el objeto número 2
Número de serie de d1 = 1
Número de serie de d2 = 2
Objetos Creados: 2
```

## Librerías de clases

Normalmente, a la hora de generar diferentes clases, será deseable organizarlas de forma que se pueda facilitar su gestión y saber cuáles están relacionadas entre sí, por ejemplo, formando parte de un mismo programa. El lenguaje Java proporciona un mecanismo llamado `package` para poder agrupar clases.

Antes de entrar a ver en profundidad el funcionamiento de los `packages` de Java, es importante tener claro cómo se representa una clase Java dentro del sistema de archivos cuando no intervienen los `packages` (o sea, tal y como hemos trabajado con clases hasta ahora), tanto a nivel de código fuente como una vez compilada. De este modo, es más sencillo entender su impacto en la estructura de un programa realizado en Java. Esto se debe a que, al usar un IDE, todo este proceso de gestión de los archivos de código fuente y compilados es transparente al desarrollador, pero es igualmente importante saber qué archivos están jugando algún rol en la fase de desarrollo de una aplicación en Java.

Cada clase dentro de un programa se representa normalmente dentro de un archivo con extensión `.java` y con un nombre idéntico (incluyendo mayúsculas y minúsculas) al de la propia clase tal y como se ha definido en el código fuente (`public class NombreClase {…}`). Cuando una clase se compila, se genera un archivo con extensión `.class` con el mismo nombre de la clase. Este archivo se genera en el mismo directorio que el archivo `.java` si se usa el compilador con intérprete de comandos, pero los IDE habitualmente los ordenan en carpetas diferentes dentro de sus proyectos. Por ejemplo, Netbeans ubica los archivos .java en la carpeta `src`, mientras que los archivos `.class` los ubica en la carpeta `build\classes`.

### Packages

La pertenencia de una clase a un paquete se indica con la sentencia `package` al inicio del archivo fuente en el que reside la clase y afecta a todas las clases definidas en el archivo. La sentencia `package` debe ser la primera sentencia del archivo fuente. Antes puede haber líneas en blanco y/o comentarios, pero nada más.

Hay que seguir la siguiente sintaxis:

```java
package <nombrePaquete>;
```

Los nombres de los paquetes (por convenio, con minúsculas) pueden ser palabras separadas por puntos, lo que provoca que los correspondientes `.class` se almacenen en una estructura jerárquica de directorios que coincide, en nombres, con las palabras que constituyen el nombre del paquete .

La inexistencia de la sentencia `package` implica que las clases del archivo fuente se consideran en el paquete por defecto (sin nombre) y los correspondientes `.class` se almacenan en el mismo directorio que el archivo fuente.

Un paquete está constituido por el conjunto de clases diseñadas en archivos fuente que incorporan la sentencia `package` con un nombre de paquete idéntico. 

El paquete predeterminado está constituido por todas las clases diseñadas en archivos fuente que no incorporan la sentencia `package`.

Todas las clases de un paquete llamado `xxx.yyy.zzz` residen en la subcarpeta “zzz” de la estructura de directorios “xxx/yyy/zzz”, pero podemos tener físicamente esta estructura en diferentes ubicaciones. Es decir, dadas las clases C1 y C2 del mismo paquete “xxx.yyy.zzz”, se podría dar el caso de que el archivo `.class` correspondiente a C1 residiera en path “xxx/yyy/zzz/C1” y que el archivo .class correspondiente a C2 reside en path “xxx/yyy/zzz/C2”.

Recordamos que el código incorporado en una clase (iniciadores y métodos) tiene acceso a todos los miembros sin modificador de acceso de todas las clases del mismo paquete (además del acceso a los miembros con modificador de acceso público).

En el diseño de una clase se tiene acceso a todas las clases del mismo paquete, pero para acceder a clases de diferentes paquetes es necesario utilizar uno de los dos mecanismos siguientes:

* Utilizar el nombre de la clase precedido del nombre del paquete cada vez que deba utilizarse el nombre de la clase, con la siguiente sintaxis:

  ```java
  nombrePaquete.NombreClase
  ```

* Explicitar las clases de otros paquetes a las que se hará referencia con una sentencia importe antes de la declaración de la nueva clase, siguiendo la siguiente sintaxis:

  ```java
  import <nombrePaquete>.<NombreClase>;
  ```

Es factible cargar todas las clases de un paquete con una única sentencia utilizando un asterisco:

```java
import <nombrePaquete>.*;
```

Las sentencias `import` en un archivo fuente deben preceder a todas las declaraciones de clases incorporadas en el archivo.

Así pues, si tenemos una clase `C` en un paquete `xxx.yyy.zzz` y debemos utilizarla en otra clase, tenemos dos opciones:

* Escribir `xxx.yyy.zzz.C` cada vez que debamos referirnos a la clase `C`.
* Utilizar la sentencia `import xxx.yyy.zzz.C` antes de ninguna declaración de clase y utilizar directamente el nombre `C` para referirnos a la clase.

### Ejemplo de definición

Consideramos las clases diseñadas en el siguiente archivo:

```java
//Fichero xxx/yyy/zzz/ClaseC1.java
package xxx.yyy.zzz;

public class ClaseC1 {
  int mc1=10;
}

class ClaseC1Bis {
  int mc1=20;
}
```

Vemos que este archivo define las clases `ClaseC1` y `ClaseC1Bis` dentro de un paquete llamado `xxx.yyy.zzz`. Fijémonos en que una de ellas tiene el modificador `public` para que se pueda acceder desde fuera del paquete, y recordemos que en un archivo `.java` sólo puede haber una clase pública.

Consideramos un nuevo archivo `.java` que crea más clases en el mismo paquete `xxx.yyy.zzz`: `ClaseC2.java`

```java
//Fichero xxx/yyy/zzz/ClasseC2.java
package xxx.yyy.zzz;

public class ClaseC2 {
  int mc2=10;
}

class ClaseC2Bis {
  int mc2=20;
}
```

Veamos, en primer lugar, que cualquier clase de un paquete tiene acceso a todas las clases del mismo paquete  y a los miembros de las que no hayan sido declaradas `private`. Vamos:

```java
//Fichero: xxx/yyy/zzz/AccesIntern.java
package xxx.yyy.zzz;

class AccesoInterno {
  public static void main (String args[]) {
   ClaseC1 c1 = new ClaseC1();
   ClaseC1Bis c1b = new ClaseC1Bis();
   ClaseC2 c2 = new ClaseC2();
   ClaseC2Bis c2b = new ClaseC2Bis();
   System.out.println ("c1.mc1 = " + c1.mc1);
   System.out.println ("c1b.mc1 = " + c1b.mc1);
   System.out.println ("c2.mc2 = " + c2.mc2);
   System.out.println ("c2b.mc2 = " + c2b.mc2);
  }
}
```

Si procedemos a ejecutar el programa obtenemos:

```
c1.mc1 = 10
c1b.mc1 = 20
c2.mc2 = 10
c2b.mc2 = 20
```

Vemos que la clase `AccesoInterno` tiene acceso a todas las clases del mismo paquete y sus datos miembros, ya que no se habían definido como `private`.

Comprobamos ahora qué hacer para acceder a las clases del paquete `xxx.yyy.zzz` desde una clase de otro paquete. Comprobaremos que no podemos acceder a las clases no públicas del paquete `xxx.yyy.zzz` ni a los miembros no públicos de las clases públicas. Para realizar estas comprobaciones, consideramos la clase `AccesoExterno` siguiente:

```java
//Fitxer AccesoExterno.java
package externo;

import xxx.yyy.zzz.*;

class AccesExtern {
   public static void main (String args[]) {
      ClaseC1 c1 = new ClaseC1();
      //ClaseC1Bis c1b = new ClaseC1Bis();    // No es clase pública
      ClaseC2 c2 = new ClaseC2();
      //ClaseC2Bis c2b = new ClaseC2Bis();    // No es clase pública
      //System.out.println ("c1.mc1 = " + c1.mc1); // No son miembros públicps
      //System.out.println ("c2.mc2 = " + c2.mc2); // No son miembros públicos
   }
}
```

Vemos que las instrucciones comentadas darían error por los siguientes motivos:

* Las clases `ClaseC1Bis` y `ClaseC2Bis` no son públicas y, por tanto, no se tiene acceso desde fuera del paquete “`xxx.yyy.zzz`”.
* El miembro `mc1` de la clase `ClaseC1` y el miembro `mc2` de la clase `ClaseC2` no son públicos y, por tanto, no se tiene acceso desde fuera del paquete `xxx.yyy.zzz`.

En el desarrollo de aplicaciones en Java es necesario tener especial cuidado en utilizar nombres que sean únicos y así poder asegurar su reutilización en una gran organización y, más aún, en cualquier lugar del mundo. Esto puede ser una tarea difícil en una gran organización y absolutamente imposible en la comunidad de Internet. Por eso se propone que toda organización utilice el nombre de su dominio, invertido, como prefijo para todas las clases. Es decir, los paquetes de clases desarrollados el IES El Caminàs, que tiene el dominio "ieselcaminas.org", podrían empezar por "org.ieselcaminas".

----
Adaptado de los siguientes materiales

* [https://avansti.github.io/TI1.1-OGP0-OGP1-Lesmateriaal/subjects/object-oriented-programming/](https://avansti.github.io/TI1.1-OGP0-OGP1-Lesmateriaal/subjects/object-oriented-programming/)
* [https://www3.ntu.edu.sg/home/ehchua/programming/java/J3b_OOPInheritancePolymorphism.html](https://www3.ntu.edu.sg/home/ehchua/programming/java/J3b_OOPInheritancePolymorphism.html)

