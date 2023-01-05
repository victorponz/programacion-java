---
typora-copy-images-to: ../assets/img/poo/
typora-root-url: ../../
layout: post
title: Introducción a la POO
categories: poo
conToc: true
permalink: poo-introduccion
---

## Objetos, métodos de instancia y variables de instancia

La programación orientada a objetos (POO) representa un intento de hacer que los programas modelen más de cerca la forma en que las personas piensan y tratan el mundo. En los estilos de programación más antiguos, un programador que se enfrenta a algún problema debe identificar una tarea informática que debe realizarse para resolver el problema. Entonces, la programación consiste en encontrar una secuencia de instrucciones que lleven a cabo esa tarea. Pero en el corazón de la programación orientada a objetos, en lugar de tareas, encontramos **objetos: entidades que tienen comportamientos, que contienen información y que pueden interactuar entre sí**. La programación consiste en diseñar un conjunto de objetos que de alguna manera modelen el problema en cuestión. Los objetos de software en el programa pueden representar entidades reales o abstractas en el dominio del problema. Se supone que esto hace que el diseño del programa sea más natural y, por lo tanto, más fácil de entender y hacerlo bien.

Hasta cierto punto, OOP es solo un cambio de punto de vista. Podemos pensar en un objeto en términos de programación estándar como nada más que un conjunto de variables junto con algunas subrutinas (métodos) para manipular esas variables. De hecho, es posible utilizar técnicas orientadas a objetos en cualquier lenguaje de programación. Sin embargo, hay una gran diferencia entre un lenguaje que hace posible la programación orientada a objetos y uno que lo soporta activamente. Un lenguaje de programación orientado a objetos como Java incluye una serie de características que lo hacen muy diferente de un lenguaje estándar. Para hacer un uso efectivo de esas funciones, debes "orientar" tu pensamiento correctamente.

### Objetos, Clases e Instancias

Los objetos están estrechamente relacionados con las clases. Ya hemos estado trabajando con clases durante varios capítulos y hemos visto que una clase puede contener variables y métodos (es decir, métodos). Si un objeto también es una colección de variables y métodos, ¿en qué se diferencian de las clases? ¿Y por qué se requiere un tipo diferente de pensamiento para comprenderlos y usarlos de manera efectiva? 

He dicho que las clases "describen" objetos, o más exactamente que las partes no estáticas de las clases describen objetos. Pero probablemente no esté muy claro qué significa esto. La terminología más habitual es decir que los **objetos pertenecen a clases**, pero esto podría no ser mucho más claro. (Existe una escasez real de palabras en español para distinguir adecuadamente todos los conceptos involucrados. Un objeto ciertamente no "pertenece" a una clase de la misma manera que una variable miembro "pertenece" a una clase). Desde el punto de vista de programación, es más exacto decir que las **clases se utilizan para crear objetos**. Una clase es una especie de fábrica, o modelo, para construir objetos. Las partes no estáticas de la clase especifican o describen qué variables y métodos contendrán los objetos. Esto es parte de la explicación de cómo los objetos difieren de las clases: l**os objetos se crean y destruyen a medida que se ejecuta el programa, y puede haber muchos objetos con la misma estructura, si se crean utilizando la misma clase.**

Considera una clase simple cuyo trabajo es agrupar algunas variables miembro estáticas. Por ejemplo, la siguiente clase podría usarse para almacenar información sobre la persona que está usando el programa:

```java
class UserData {
    static String name;
    static int age;
}
```

En un programa que usa esta clase, solo hay una copia de cada una de las variables `UserData.name` y `UserData.age`. Cuando la clase se carga en la computadora, hay una sección de memoria dedicada a la clase, y esa sección de memoria incluye espacio para los valores de las variables `name` y `age`. Podemos imaginar la clase en la memoria con este aspecto:

![the UserData class in memory, with space for name and age](/programacion-java/assets/img/poo/class-userdata.png)

Un punto importante es que las variables miembro estáticas son parte de la representación de la clase en memoria. Sus nombres completos, `UserData.name` y `UserData.age`, usan el nombre de la clase, ya que son parte de la clase. Cuando usamos la clase `UserData` para representar al usuario del programa, solo puede haber un usuario, ya que solo tenemos espacio de memoria para almacenar datos sobre un usuario. Ten en cuenta que la clase, `UserData` y las variables que contiene existen mientras se ejecuta el programa. (Eso es esencialmente lo que significa ser "estático".) Ahora, considere una clase similar que incluya algunas variables no estáticas:

```java
class PlayerData {
   static int playerCount;
   String name;
   int age;
}
```

También he incluido una variable estática en la clase `PlayerData`. Aquí, la variable estática `playerCount` se almacena como parte de la representación de la clase en la memoria. Su nombre completo es `PlayerData.playerCount`, y solo hay uno, que existe mientras se ejecuta el programa. Sin embargo, las otras dos variables en la definición de clase no son estáticas. No existe una variable como `PlayerData.name` o `PlayerData.age`, ya que las variables no estáticas no se convierten en parte de la clase en sí. Pero la clase `PlayerData` se puede usar para crear objetos. Puede haber muchos objetos creados usando la clase, y cada uno tendrá sus propias variables llamadas `name`  y `age`. Esto es lo que significa que las partes no estáticas de la clase sean una plantilla para los objetos: cada objeto obtiene su propia copia de la parte no estática de la clase. Podemos visualizar la situación en la memoria de la computadora después de haber creado varios objetos como este:

![](/programacion-java/assets/img/poo/instance-of-PlayerData.png)



Ten en cuenta que la variable estática `playerCount` es parte de la clase y solo hay una copia. Por otro lado, cada objeto contiene un nombre y una edad. Un objeto que se crea a partir de una clase se denomina **instancia** de esa clase y, como muestra la imagen, cada objeto "sabe" qué clase se utilizó para crearlo. He mostrado que la clase `PlayerData` contiene algo llamado "constructor"; el constructor es una subrutina que crea objetos.

Ahora puede haber muchos "jugadores", porque podemos crear nuevos objetos para representar a nuevos jugadores bajo demanda. Un programa podría usar la clase `PlayerData` para almacenar información sobre múltiples jugadores en un juego. Cada jugador tiene un nombre y una edad. Cuando un jugador se une al juego, se puede crear un nuevo objeto `PlayerData` para representar a ese jugador. Si un jugador abandona el juego, el objeto `PlayerData` que representa a ese jugador puede destruirse. Se utiliza un sistema de objetos en el programa para modelar dinámicamente lo que sucede en el juego. ¡No puedes hacer esto con variables estáticas! "Dinámico" es lo opuesto a "estático".

----

Se dice que un objeto que se crea usando una clase es una **instancia** de esa clase. A veces diremos que el objeto pertenece a la clase. Las variables que contiene el objeto se denominan **variables de instancia**. Los métodos (es decir, subrutinas) que contiene el objeto se denominan **métodos de instancia**. Por ejemplo, si la clase `PlayerData`, como se definió anteriormente, se usa para crear un objeto, entonces ese objeto es una instancia de la clase `PlayerData`, y el nombre y la edad son variables de instancia en el objeto.

Los ejemplos aquí no incluyen ningún método, pero los métodos funcionan de manera similar a las variables. Los métodos estáticos son parte de la clase; los métodos no estáticos o de instancia se convierten en parte de los objetos creados a partir de la clase. No es literalmente cierto que cada objeto contenga su propia copia del código compilado real para un método de instancia. Pero lógicamente un método de instancia es parte del objeto, y continuaré diciendo que el objeto "contiene" el método de instancia.

Ten en cuenta que debe distinguir entre el código fuente de la clase y la clase en sí (en la memoria). El código fuente determina tanto la clase como los objetos que se crean a partir de esa clase. Las definiciones "estáticas" en el código fuente especifican las cosas que son parte de la clase misma (en la memoria de la computadora), mientras que las definiciones no estáticas en el código fuente especifican cosas que se convertirán en parte de cada objeto de instancia que se crea a partir de la clase. Por cierto, las variables de miembros estáticos y las subrutinas de miembros estáticos en una clase a veces se denominan **variables de clase** y **métodos de clase**, ya que pertenecen a la clase en sí, en lugar de a instancias de esa clase.

Como puedes ver, las partes estáticas y no estáticas de una clase son cosas muy diferentes y tienen propósitos muy diferentes. Muchas clases contienen solo miembros estáticos, o solo no estáticos, y veremos solo algunos ejemplos de clases que contienen una combinación de los dos.

### Fundamentos de Objetos

Hasta ahora, hemos estado hablando principalmente de generalidades, y no les hemos dado mucha idea sobre lo que debes poner en un programa si quieren trabajar con objetos. Veamos un ejemplo específico para ver cómo funciona. Considera esta versión extremadamente simplificada de una clase de estudiante, que podría usarse para almacenar información sobre los estudiantes que toman un curso:

```java
public class Student {

   public String name;  // Student's name.
   public double test1, test2, test3;   // Grades on three tests.
   
   public double getAverage() {  // compute average test grade
      return (test1 + test2 + test3) / 3;
   }
   
}  // end of class Student
```

Ninguno de los miembros de esta clase se declara estático, por lo que la clase existe solo para crear objetos. Esta definición de clase dice que cualquier objeto que sea una instancia de la clase `Student` incluirá variables de instancia denominadas `name`, `test1`, `test2` y `test3`, e incluirá un método de instancia denominado `getAverage()`. Los nombres y las calificaciones de las pruebas en diferentes objetos generalmente tendrán valores diferentes. Cuando se llama para un estudiante en particular, el método `getAverage()` calculará un promedio usando las calificaciones de las pruebas de ese estudiante. Diferentes estudiantes pueden tener diferentes promedios. (Nuevamente, esto es lo que significa decir que un método de instancia pertenece a un objeto individual, no a la clase).

En Java, una clase es un tipo, similar a los tipos integrados como **int** y **boolean**. Entonces, un nombre de clase se puede usar para especificar el tipo de una variable en una declaración, o el tipo de un parámetro formal, o el tipo de retorno de una función. Por ejemplo, un programa podría definir una variable llamada `std` de tipo `Student` con la instrucción

```java
Student std;
```

> -alert-Sin embargo, ¡declarar una variable no crea un objeto! Este es un punto importante, que está relacionado con este Hecho Muy Importante:
>
> **En Java, ninguna variable puede contener un objeto.
> Una variable solo puede contener una referencia a un objeto.**

Debe pensar en los objetos como flotando independientemente en la memoria de la computadora. De hecho, hay una parte especial de la memoria llamada `heap` donde viven los objetos. En lugar de contener un objeto en sí mismo, una variable contiene la información necesaria para encontrar el objeto en la memoria. Esta información se denomina **referencia** o **puntero al objeto**. En efecto, una referencia a un objeto es la dirección de la ubicación de memoria donde se almacena el objeto. Cuando usas una variable de tipo objeto, la computadora usa la referencia en la variable para encontrar el objeto real.

En un programa, los objetos se crean utilizando un operador llamado `new`, que crea un objeto y devuelve una referencia a ese objeto. (De hecho, el operador `new` llama a una subrutina especial llamada "constructor" en la clase). Por ejemplo, suponiendo que `std` es una variable de tipo `Student`, declarada como se indicó anteriormente, la declaración de asignación

```java
std = new Student();
```

crearía un nuevo objeto que es una instancia de la clase `Student`, y almacenaría una referencia a ese objeto en la variable `std`. El valor de la variable es una referencia, o puntero, al objeto. El objeto en sí está en algún lugar del `heap`. Entonces, no es del todo cierto decir que el objeto es el "valor de la variable `std`" (aunque a veces es difícil evitar usar esta terminología). La terminología adecuada es que "la variable `std` se refiere o apunta al objeto", y trataré de apegarme a esa terminología tanto como sea posible. Si alguna vez digo algo como "`std` es un objeto", debería leerlo como "`std` es una variable que se refiere a un objeto".

Entonces, suponga que la variable `std` se refiere a un objeto que es una instancia de la clase `Student`. Ese objeto contiene las variables de instancia nombre, `test1`, `test2` y `test3`. Estas variables de instancia se pueden denominar `std.name`, `std.test1`, `std.test2` y `std.test3`. Esto sigue la convención de nomenclatura habitual de que **cuando B es parte de A**, el nombre completo de B es **A.B**. Por ejemplo, un programa podría incluir las líneas

```java
System.out.println("Hello, "  +  std.name  +  ".  Your test grades are:");
System.out.println(std.test1);
System.out.println(std.test2);
System.out.println(std.test3);
```

Esto generaría el nombre y las calificaciones de la prueba del objeto al que se refiere `std`. De manera similar, `std` se puede usar para llamar al método de instancia `getAverage()` en el objeto diciendo `std.getAverage()`. Para imprimir el promedio del estudiante, podría decir:

```java
System.out.println( "Your average is "  +  std.getAverage() );
```

De manera más general, puedes usar `std.name` en cualquier lugar donde una variable de tipo `String` sea legal. Puedes usarlo en expresiones. Puede asignarle un valor. Incluso puede usarlo para llamar a subrutinas de la clase `String`. Por ejemplo, `std.name.length()` es el número de caracteres en el nombre del estudiante.

Es posible que una variable como `std`, cuyo tipo viene dado por una clase, no se refiera a ningún objeto. Decimos en este caso que `std` contiene un **puntero nulo** o una **referencia nula**. El puntero nulo está escrito en Java como: `null`. Puede almacenar una referencia nula en la variable `std` diciendo

```java
std = null;
```

`null` es un valor real que se almacena en la variable, no un puntero a otra cosa. No es correcto decir que la variable "apunta a nulo"; de hecho, la variable es nula. Por ejemplo, puede probar si el valor de `std` es nulo probando

```java
if (std == null) . . .
```

Si el valor de una variable es nulo, entonces, por supuesto, es ilegal referirse a variables de instancia o métodos de instancia a través de esa variable, ya que no hay objeto y, por lo tanto, no hay variables de instancia a las que referirse. Por ejemplo, si el valor de la variable `std` es nulo, sería ilegal referirse a `std.test1`. Si tu programa intenta usar un puntero nulo ilegalmente de esta manera, el resultado es un error llamado excepción de puntero nulo. Cuando esto sucede mientras se ejecuta el programa, se lanza una **excepción** de tipo `NullPointerException`.

Veamos una secuencia de sentencias que funcionan con objetos:

```java
Student std, std1, std2, std3;    //   // Declare four variables of type Student.

std = new Student();     // Create a new object belonging
                         //   to the class Student, and
                         //   store a reference to that
                         //   object in the variable std.

std1 = new Student();    // Create a second Student object
                         //   and store a reference to
                         //   it in the variable std1.

std2 = std1;             // Copy the reference value in std1
                         //   into the variable std2.

std3 = null;             // Store a null reference in the
                         //   variable std3.
                         
std.name = "John Smith";  // Set values of some instance variables.
std1.name = "Mary Jones";

     // (Other instance variables have default
     //    initial values of zero.)
```

Después de que la computadora ejecuta estas declaraciones, la situación en la memoria de la computadora se ve así:

![](/programacion-java/assets/img/poo/objects-in-heap.png)

En esta imagen, cuando una variable contiene una referencia a un objeto, el valor de esa variable se muestra como una flecha que apunta al objeto. Ten en cuenta, por cierto, que las cadenas son objetos. La variable `std3`, con un valor nulo, no apunta a ninguna parte. Las flechas de `std1` y `std2` apuntan al mismo objeto. Esto ilustra un punto muy importante:

> -alert-Cuando se asigna una variable de objeto a otro, sólo se copia una referencia.
> El objeto al que se hace referencia no se copia.

Cuando la asignación `std2 = std1;` se ejecutó, no se creó ningún objeto nuevo. En cambio, `std2` se configuró para referirse al mismo objeto al que se refiere `std1`. Esto es de esperarse, ya que la instrucción de asignación simplemente copia el valor almacenado en `std1` en `std2`, y ese valor es un puntero, no un objeto. Pero esto tiene algunas consecuencias que pueden resultar sorprendentes. Por ejemplo, `std1.name` y `std2.name` son dos nombres diferentes para la misma variable, es decir, la variable de instancia en el objeto al que se refieren tanto `std1` como `std2`. Después de asignar la cadena "Mary Jones" a la variable `std1.name`, también es cierto que el valor de `std2.name` es "Mary Jones". Existe una gran posibilidad de confusión aquí, pero puede ayudar a protegerte si sigue diciéndose a sí mismo: "El objeto no está en la variable. La variable solo sostiene un puntero al objeto".

Puedes probar la igualdad y la desigualdad de los objetos usando los operadores `==` y `!=,` pero aquí nuevamente, la semántica es diferente de lo que está acostumbrado. Cuando realiza una prueba "si (`std1 == std2`)", está probando si los valores almacenados en `std1` y `std2` son los mismos. Pero los valores que está comparando son referencias a objetos; no son objetos. Entonces, está probando si `std1` y `std2` se refieren al mismo objeto. Esto está bien, si es lo que quieres hacer. Pero a veces, lo que desea verificar es si las variables de instancia en los objetos tienen los mismos valores. Para hacerlo, debe preguntar si "`std1.test1 == std2.test1 && std1.test2 == std2.test2 && std1.test3 == std2.test3 && std1.name.equals(std2.name)`".

Las cadenas son objetos y he mostrado las cadenas "Mary Jones" y "John Smith" como objetos en la ilustración anterior. (Las cadenas son objetos especiales, tratados por Java de una manera especial, y no he intentado mostrar la estructura interna real de los objetos `String`). Dado que las cadenas son objetos, una variable de tipo `String` solo puede contener una referencia a una cadena, no la cadena en sí. Esto explica por qué no es una buena idea usar el operador `==` para probar la igualdad de las cadenas. Supongamos que saludo es una variable de tipo `String` y que hace referencia a la cadena "Hola". Entonces, ¿sería cierto el saludo de prueba `== "Hola"?` Bueno, tal vez, tal vez no. La variable saludo y el literal de cadena "Hola" se refieren cada uno a una cadena que contiene los caracteres H-o-l-a. Pero las cadenas aún podrían ser objetos diferentes, que simplemente contienen los mismos caracteres; en ese caso, `saludo == "Hola"` sería falso. La función `saludo.equals("Hola")` comprueba si saludo y "Hola" contienen los mismos caracteres, que es casi seguro que es la pregunta que desea hacer. La expresión `saludo == "Hola"` comprueba si saludo y "Hola" contienen los mismos caracteres almacenados en la misma ubicación de memoria. (Por supuesto, una variable de cadena como saludo también puede contener el valor especial nulo, y tendría sentido usar el operador `==` para probar si "`saludo == nulo`".)

El hecho de que las variables contengan referencias a objetos, no a objetos en sí, tiene un par de otras consecuencias que debe tener en cuenta. Siguen lógicamente, si solo tiene en cuenta el hecho básico de que el objeto no está almacenado en la variable. El objeto está en otra parte; la variable lo apunta.

Supongamos que una variable que hace referencia a un objeto se declara **final**. Esto significa que el valor almacenado en la variable **nunca se puede cambiar,** una vez que se ha inicializado la variable. El valor almacenado en la variable es una referencia al objeto. Entonces, la variable continuará refiriéndose al mismo objeto mientras exista la variable. Sin embargo, esto no impide que cambien los datos del objeto. La variable es final, no el objeto. Es perfectamente legal decir

```java
final Student stu = new Student();

stu.name = "John Doe";  // Change data in the object;
                        // The value stored in stu is not changed!
                        // It still refers to the same object.
```

A continuación, supón que `obj` es una variable que se refiere a un objeto. Consideremos lo que sucede cuando `obj` se pasa como un parámetro real a una subrutina. El valor de `obj` se asigna a un parámetro formal en la subrutina y se ejecuta la subrutina. **La subrutina no tiene poder para cambiar el valor almacenado en la variable `obj`. Sólo tiene una copia de ese valor.** Sin embargo, el valor es una referencia a un objeto. Dado que la subrutina tiene una referencia al objeto, puede cambiar los datos almacenados en el objeto. Después de que finaliza la subrutina, `obj` aún apunta al mismo objeto, pero los datos almacenados en el objeto pueden haber cambiado. Supongamos que `x` es una variable de tipo `int` y `stu` es una variable de tipo `Student`. Comparar:

```java
void dontChange(int z) {                void change(Student s) {
    z = 42;                                  s.name = "Fred";
}                                       }

The lines:                              The lines:

   x = 17;                                 stu.name = "Jane";
   dontChange(x);                          change(stu);
   System.out.println(x);                  System.out.println(stu.name);
 
output the value 17.                    output the value "Fred".
 
The value of x is not                   The value of stu is not
changed by the subroutine,              changed, but stu.name is changed.
which is equivalent to                  This is equivalent to

   z = x;                                  s = stu;
   z = 42;                                 s.name = "Fred";
```

## Gettters y Setters

Al escribir nuevas clases, es una buena idea prestar atención al tema del control de acceso. Recuerda que hacer **público** un miembro de una clase lo hace accesible desde cualquier lugar, incluso desde otras clases. Por otro lado, un miembro **privado** solo puede usarse en la clase donde está definido.

En opinión de muchos programadores, **casi todas las variables miembro deberían declararse privadas**. Esto te da un control completo sobre lo que se puede hacer con la variable. Incluso si la variable en sí es privada, puede permitir que otras clases averigüen cuál es su valor proporcionando un método de acceso público que devuelva el valor de la variable. Por ejemplo, si su clase contiene una variable miembro privada, `title`, de tipo `String`, puedes proporcionar un método

```java
public String getTitle() {
    return title;
}
```

que devuelve el valor del `title`. Por convención, el nombre de un método de acceso para una variable se obtiene poniendo en mayúscula el nombre de la variable y agregando "**get**" delante del nombre. Entonces, para el título de la variable, obtenemos un método de acceso llamado "get" + "Title", o `getTitle()`. Debido a esta convención de nomenclatura, los métodos de acceso se conocen más a menudo como métodos **getters**. Un método getter proporciona "acceso de lectura" a una variable. (A veces, para las variables booleanas, se usa "is" en lugar de "get". Por ejemplo, un getter para una variable miembro booleana llamada **done** podría llamarse `isDone()`).

También es posible que desee permitir el "**acceso de escritura**" a una variable privada. Es decir, es posible que desee hacer posible que otras clases especifiquen un nuevo valor para la variable. Esto se hace con un método **setter** o **mutador**. El nombre de un método setter debe consistir en "set" seguido de una copia en mayúscula del nombre de la variable, y suele tener un parámetro con el mismo tipo que la variable. Se podría escribir un método setter para el título de la variable.

```java
public void setTitle( String newTitle ) {
   title = newTitle;
}
```

**Los setters pueden ser múltiples (o no tener ninguno)**. Por ejemplo, un calefactor al que puedes incrementar, decrementar, y fijar la temperatura tiene 3 setters:

```java
private int temperature;
....
public void increment() {
   temperature++;
}
public void decrement() {
   temperature--;
}
public void setTemperature(int temp) {
   temperature = temp;
}

```

En realidad, es muy común proporcionar un método getter y setter para una variable miembro privada. Dado que esto permite que otras clases vean y cambien el valor de la variable, es posible que te preguntes por qué no hacer pública la variable. La razón es que los getters y setters no están restringidos a simplemente leer y escribir el valor de la variable. De hecho, pueden tomar cualquier acción. Por ejemplo, un método getter podría realizar un seguimiento del número de veces que se ha accedido a la variable:

```java
public String getTitle() {
    titleAccessCount++;  // Increment member variable titleAccessCount.
    return title;
}
```

y un método setter podría comprobar que el valor que se asigna a la variable es legal:

```java
public void setTitle( String newTitle ) {
   if ( newTitle == null )   // Don't allow null strings as titles!
      title = "(Untitled)";  // Use an appropriate default value instead.
   else
      title = newTitle;
}
```

Incluso si no puedes pensar en ninguna tarea adicional para hacer en un método getter o setter, es posible que cambies de opinión en el futuro cuando rediseñes y mejores tu clase. Si usaste getter y setter desde el principio, puede hacer la modificación a su clase sin afectar ninguna de las clases que usan su clase. La variable miembro privada no forma parte de la interfaz pública de su clase; solo lo son los métodos getter y setter públicos, y puede cambiar sus implementaciones sin cambiar la interfaz pública de su clase. Si no ha usado get y set desde el principio, tendrá que ponerse en contacto con todos los que usan su clase y decirles: "Lo siento, tendrán que rastrear cada uso que hayan hecho de esta variable y cambie su código para usar mis nuevos métodos get y set en su lugar".

### Fluent setters

Como hemos visto los setters no tienen valor de retorno. Pero hoy en día es muy común que devuelvan un objeto de la misma clase en el que están definidos.

Vamos a ver un ejemplo, sin fluent:

```java
public class Triangulo {
    private String color;
    private Double angle;
    private int x;
    private int y;
    public void setColor(String color){
        this.color = color;
    }

    public void setAngle(Double angle){
        this.angle = angle;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
        
}
Triangulo triangulo = new Triangulo();
triangulo.setColor("Rojo");
triangulo.setAngle(90);
triangulo.setX(10);
triangulo.setY(20);
```

Y con Fluent:

```java
public class Triangulo {
    private String color;
    private int angle;
    private int x;
    private int y;
    public Triangulo setColor(String color){
        this.color = color;
        return this;
    }

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
Triangulo triangulo = new Triangulo();
triangulo.setColor("Rojo")
         .setAngle(90)
         .setX(10)
         .setY(20);
```

Con los métodos Fluent la escritura de código es más concisa.

## Constructores e inicializadores de objetos

Los tipos de objetos en Java son muy diferentes de los tipos primitivos. Simplemente declarar una variable cuyo tipo se da como una clase no crea automáticamente un objeto de esa clase. Los objetos deben construirse explícitamente. Para la computadora, el proceso de construcción de un objeto significa, primero, encontrar algo de memoria no utilizada en el heap que pueda usarse para contener el objeto y, segundo, completar las variables de instancia del objeto. Como programador, no te importa en qué lugar de la memoria se almacena el objeto, pero normalmente querrás ejercer algún control sobre qué valores iniciales se almacenan en las variables de instancia de un nuevo objeto. En muchos casos, también querrás realizar una inicialización o contabilidad más complicada cada vez que se crea un objeto.

### Inicializar variables de instancia

A una variable de instancia se le puede asignar un valor inicial en su declaración, como cualquier otra variable. Por ejemplo, considere una clase llamada `PairOfDice`. Un objeto de esta clase representará un par de dados. Contendrá dos variables de instancia para representar los números que se muestran en los dados y un método de instancia para tirar los dados:

```java
public class PairOfDice {

    public int die1 = 3;   // Number showing on the first die.
    public int die2 = 4;   // Number showing on the second die.

    public void roll() {
            // Roll the dice by setting each of the dice to be
            // a random number between 1 and 6.
         die1 = (int)(Math.random()*6) + 1;
         die2 = (int)(Math.random()*6) + 1;
    }
    
} // end class PairOfDice
```

Las variables de instancia `die1` y `die2` se inicializan con los valores 3 y 4 respectivamente. Estas inicializaciones se ejecutan cada vez que se construye un objeto `PairOfDice`. Es importante entender cuándo y cómo sucede esto. Puede haber muchos objetos `PairOfDice`. Cada vez que se crea una, obtiene sus propias variables de instancia y las asignaciones `"die1 = 3"` y `"die2 = 4"` se ejecutan para completar los valores de esas variables. Para aclarar esto, considera una variación de la clase `PairOfDice`:

```java
public class PairOfDice {

    public int die1 = (int)(Math.random()*6) + 1;
    public int die2 = (int)(Math.random()*6) + 1;
 
    public void roll() {
         die1 = (int)(Math.random()*6) + 1;
         die2 = (int)(Math.random()*6) + 1;
    }
    
} // end class PairOfDice
```

Aquí, cada vez que se crea un nuevo `PairOfDice`, los dados se inicializan con valores aleatorios, como si se lanzara un nuevo par de dados a la mesa de juego. Dado que la inicialización se ejecuta para cada nuevo objeto, se calculará un conjunto de valores iniciales aleatorios para cada nuevo par de dados. Diferentes pares de dados pueden tener diferentes valores iniciales. Para la inicialización de variables miembro estáticas, por supuesto, la situación es bastante diferente. Solo hay una copia de una variable estática, y la inicialización de esa variable se ejecuta solo una vez, cuando la clase se carga por primera vez.

Si no proporciona ningún valor inicial para una variable de instancia, se proporciona automáticamente un valor inicial predeterminado. Las variables de instancia de tipo numérico (int, double, etc.) se inicializan automáticamente a cero si no proporciona otros valores; las variables booleanas se inicializan en falso; y char variables, al carácter Unicode con número de código cero. Una variable de instancia también puede ser una variable de tipo objeto. Para tales variables, el valor inicial predeterminado es nulo. (En particular, dado que las cadenas son objetos, el valor inicial predeterminado para las variables de cadena es nulo).

### Constructores

Los objetos se crean con el operador `new`. Por ejemplo, un programa que quiera usar un objeto `PairOfDice` podrías decir:

```java
PairOfDice dice;   // Declare a variable of type PairOfDice.

dice = new PairOfDice();  // Construct a new object and store a
                          //   reference to it in the variable.
```

En este ejemplo, "`new PairOfDice()`" es una expresión que asigna memoria para el objeto, inicializa las variables de instancia del objeto y luego devuelve una referencia al objeto. Esta referencia es el valor de la expresión, y ese valor lo almacena la declaración de asignación en la variable dados. Entonces, después de que se ejecuta la declaración de asignación, `dice` se refiere al objeto recién creado. Parte de esta expresión, "`PairOfDice()`", parece una llamada de subrutina, y eso no es casualidad. Es, de hecho, una llamada a un tipo especial de subrutina llamada **constructor**. Esto podría desconcertarlo, ya que no existe tal subrutina en la definición de clase. Sin embargo, cada clase tiene al menos un constructor. Si el programador no escribe una definición de constructor en una clase, el sistema proporcionará un constructor predeterminado para esa clase. Este constructor predeterminado no hace nada más que lo básico: asignar memoria e inicializar variables de instancia. Si deseas que suceda más que eso cuando se crea un objeto, puede incluir uno o más constructores en la definición de clase.

La definición de un constructor se parece mucho a la definición de cualquier otra subrutina, con tres excepciones. Un constructor no tiene ningún tipo de devolución (ni siquiera void). El nombre del constructor debe ser el mismo que el nombre de la clase en la que está definido. Y los únicos modificadores que se pueden usar en una definición de constructor son los modificadores de acceso público, privado y protegido. (En particular, un constructor no puede declararse estático).

Sin embargo, un constructor tiene un cuerpo de subrutina de la forma habitual, un bloque de sentencias. No hay restricciones sobre qué declaraciones se pueden usar. Y un constructor puede tener una lista de parámetros formales. De hecho, la capacidad de incluir parámetros es una de las principales razones para usar constructores. Los parámetros pueden proporcionar datos para ser utilizados en la construcción del objeto. Por ejemplo, un constructor para la clase `PairOfDice` podría proporcionar los valores que se muestran inicialmente en los dados. Así es como se vería la clase en ese caso:

```java
public class PairOfDice {

    public int die1;   // Number showing on the first die.
    public int die2;   // Number showing on the second die.
    
    public PairOfDice(int val1, int val2) {
            // Constructor.  Creates a pair of dice that
            // are initially showing the values val1 and val2.
         die1 = val1;  // Assign specified values 
         die2 = val2;  //           to the instance variables.
    }

    public void roll() {
            // Roll the dice by setting each of the dice to be
            // a random number between 1 and 6.
         die1 = (int)(Math.random()*6) + 1;
         die2 = (int)(Math.random()*6) + 1;
    }
    
} // end class PairOfDice
```

El constructor se declara como `public PairOfDice(int val1, int val2)`, sin tipo de retorno y con el mismo nombre que el nombre de la clase. Así es como el compilador de Java reconoce un constructor. El constructor tiene dos parámetros y los valores de estos parámetros se deben proporcionar cuando se llama al constructor. Por ejemplo, la expresión `new PairOfDice(3,4)` crearía un objeto `PairOfDice` en el que los valores de las variables de instancia die1 y die2 son inicialmente 3 y 4. Por supuesto, en un programa, el valor devuelto por el constructor debe usarse de alguna manera, como en

```java
PairOfDice dice;            // Declare a variable of type PairOfDice.

dice = new PairOfDice(1,1); // Let dice refer to a new PairOfDice
                            //   object that initially shows 1, 1.
```

¡Ahora que hemos agregado un constructor a la clase `PairOfDice`, ya no podemos crear un objeto diciendo `new PairOfDice()`! El sistema proporciona un constructor predeterminado para una clase solo si la definición de la clase aún no incluye un constructor. En esta versión de `PairOfDice`, solo hay un constructor en la clase y requiere dos parámetros reales. Sin embargo, esto no es un gran problema, ya que podemos agregar un segundo constructor a la clase, uno que no tenga parámetros. De hecho, puede tener tantos constructores diferentes como desee, siempre que sus firmas sean diferentes, es decir, siempre que tengan diferentes números o tipos de parámetros formales. En la clase `PairOfDice`, podríamos tener un constructor sin parámetros que produce un par de dados que muestran números aleatorios:

```java
public class PairOfDice {

    public int die1;   // Number showing on the first die.
    public int die2;   // Number showing on the second die.
    
    public PairOfDice() {
            // Constructor.  Rolls the dice, so that they initially
            // show some random values.
        roll();  // Call the roll() method to roll the dice.
    }
    
    public PairOfDice(int val1, int val2) {
            // Constructor.  Creates a pair of dice that
            // are initially showing the values val1 and val2.
        die1 = val1;  // Assign specified values 
        die2 = val2;  //            to the instance variables.
    }

    public void roll() {
            // Roll the dice by setting each of the dice to be
            // a random number between 1 and 6.
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }

} // end class PairOfDice
```

Ahora tenemos la opción de construir un objeto `PairOfDice` con `new PairOfDice()` o con `new PairOfDice(x,y)`, donde `x` e `y` son expresiones con valores enteros.

Esta clase, una vez escrita, se puede utilizar en cualquier programa que necesite trabajar con uno o más pares de dados. Ninguno de esos programas tendrá que usar el conjuro oscuro ç`(int)(Math.random()*6)+1`, porque se hace dentro de la clase `PairOfDice`. Y el programador, una vez que haya entendido bien el asunto de tirar los dados, nunca más tendrá que preocuparse por eso. Aquí, por ejemplo, hay un programa principal que usa la clase `PairOfDice` para contar cuántas veces se lanzan dos pares de dados antes de que los dos pares muestren el mismo valor. Esto ilustra una vez más que puede crear varias instancias de la misma clase:

```java
public class RollTwoPairs {

    public static void main(String[] args) {
                 
        PairOfDice firstDice;  // Refers to the first pair of dice.
        firstDice = new PairOfDice();
        
        PairOfDice secondDice; // Refers to the second pair of dice.
        secondDice = new PairOfDice();
        
        int countRolls;  // Counts how many times the two pairs of
                         //    dice have been rolled.
        
        int total1;      // Total showing on first pair of dice.
        int total2;      // Total showing on second pair of dice.
        
        countRolls = 0;
        
        do {  // Roll the two pairs of dice until totals are the same.
        
            firstDice.roll();    // Roll the first pair of dice.
            total1 = firstDice.die1 + firstDice.die2;   // Get total.
            System.out.println("First pair comes up  " + total1);
            
            secondDice.roll();    // Roll the second pair of dice.
            total2 = secondDice.die1 + secondDice.die2;   // Get total.
            System.out.println("Second pair comes up " + total2);
            
            countRolls++;   // Count this roll.
            
            System.out.println();  // Blank line.
            
        } while (total1 != total2);
        
        System.out.println("It took " + countRolls 
                          + " rolls until the totals were the same.");
        
    } // end main()

} // end class RollTwoPairs
```

Los constructores son subrutinas, pero son subrutinas de un tipo especial. Ciertamente no son métodos de instancia, ya que no pertenecen a objetos. Dado que son responsables de crear objetos, existen antes de que se haya creado cualquier objeto. Son más como subrutinas de miembros estáticos, pero no son y no pueden declararse como estáticas. De hecho, de acuerdo con la especificación del lenguaje Java, ¡técnicamente no son miembros de la clase en absoluto! En particular, los constructores no se denominan "métodos".

A diferencia de otras subrutinas, sólo se puede llamar a un constructor usando el operador `new`, en una expresión que tiene la forma

```
new class-name ( parameter-list )
```

donde `parameter-list` posiblemente esté vacía. Llamo a esto una expresión porque calcula y devuelve un valor, es decir, una referencia al objeto que se construye. La mayoría de las veces, almacenará la referencia devuelta en una variable, pero también es legal usar una llamada de constructor de otras formas, por ejemplo, como parámetro en una llamada de subrutina o como parte de una expresión más compleja. Por supuesto, si no guarda la referencia en una variable, no tendrá forma de referirse al objeto que se acaba de crear.

Una llamada de constructor es más complicada que una subrutina ordinaria o una llamada de función. Es útil comprender los pasos exactos que sigue la computadora para ejecutar una llamada al constructor:

1. Primero, la computadora obtiene un bloque de memoria no utilizada en el heap, lo suficientemente grande como para contener un objeto del tipo especificado.
2. Inicializa las variables de instancia del objeto. Si la declaración de una variable de instancia especifica un valor inicial, ese valor se calcula y almacena en la variable de instancia. De lo contrario, se utiliza el valor inicial predeterminado.
3. Se evalúan los parámetros reales del constructor, si los hay, y los valores se asignan a los parámetros formales del constructor.
4. Se ejecutan las declaraciones en el cuerpo del constructor, si las hay.
5. Se devuelve una referencia al objeto como el valor de la llamada al constructor.

El resultado final de esto es que tiene una referencia a un objeto recién construido.

---

Para otro ejemplo, vamos a crear  la clase `Student`. Agregaré un constructor y también aprovecharé la oportunidad para hacer que la variable de instancia, el nombre, sea privada.

```java
public class Student {

   private String name;                 // Student's name.
   public double test1, test2, test3;   // Grades on three tests.
   
   public Student(String theName) {
        // Constructor for Student objects;
        // provides a name for the Student.
        // The name can't be null.
      if ( theName == null )
          throw new IllegalArgumentException("name can't be null");
      name = theName;
   }
   
   public String getName() {
        // Getter method for reading the value of the private
        // instance variable, name.
      return name;
   }
   
   public double getAverage() { 
        // Compute average test grade.
      return (test1 + test2 + test3) / 3;
   }

}  // end of class Student
```

Un objeto de tipo `Student` contiene información sobre algún estudiante en particular. El constructor de esta clase tiene un parámetro de tipo `String`, que especifica el nombre de ese alumno. Los objetos de tipo `Student` se pueden crear con sentencias como:

```java
std = new Student("John Smith");
std1 = new Student("Mary Jones");
```

En la versión original de esta clase, el valor de nombre tenía que ser asignado por un programa después de crear el objeto de tipo `Student`. No había garantía de que el programador siempre recordaría establecer el nombre correctamente. En la nueva versión de la clase, no hay forma de crear un objeto `Student` excepto llamando al constructor, y ese constructor establece automáticamente el nombre. Además, el constructor hace imposible tener un objeto estudiante cuyo nombre sea nulo. La vida del programador se hace más fácil y hordas enteras de errores frustrantes son aplastados antes de que tengan la oportunidad de nacer.

Otro tipo de garantía es el **modificador privado**. Dado que la variable de instancia, `name`, es privada, no hay forma de que ninguna parte del programa fuera de la clase `Student` obtenga el nombre directamente. El programa establece el valor de nombre, indirectamente, cuando llama al constructor. Proporcioné una función getter, `getName()`, que se puede usar desde fuera de la clase para averiguar el nombre del estudiante. Pero no he proporcionado ningún método setter u otra forma de cambiar el nombre. Una vez que se crea un objeto de estudiante, mantiene el mismo nombre mientras exista.

Tenga en cuenta que sería legal y de buen estilo declarar el nombre de la variable como `final` en esta clase. Una variable de instancia puede ser `final` siempre que se le asigne un valor en su declaración o se le asigne un valor en cada constructor de la clase. Es ilegal asignar un valor a una variable de instancia final, excepto dentro de un constructor.

---

Llevemos este ejemplo un poco más lejos para ilustrar un aspecto más de las clases: ¿Qué sucede cuando mezclas estático y no estático en la misma clase? En ese caso, es legal que un método de instancia en la clase use variables de miembros estáticos o llame a subrutinas de miembros estáticos. Un objeto sabe a qué clase pertenece y puede referirse a miembros estáticos de esa clase. Pero solo hay una copia del miembro estático, en la clase misma. Efectivamente, todos los objetos comparten una copia del miembro estático.

Como ejemplo, considere una versión de la clase `Student` a la que agregué una identificación para cada estudiante y un miembro estático llamado `nextUniqueID`. Aunque hay una variable ID en cada objeto de estudiante, solo hay una variable `nextUniqueID`.

```java
public class Student {

   private String name;                 // Student's name.
   public double test1, test2, test3;   // Grades on three tests.
   
   private int ID;  // Unique ID number for this student.

   private static int nextUniqueID = 0;
             // keep track of next available unique ID number
   
   Student(String theName) {
        // Constructor for Student objects; provides a name for the Student,
        // and assigns the student a unique ID number.
      name = theName;
      nextUniqueID++;
      ID = nextUniqueID;
   }
   
   public String getName() {
        // Getter method for reading the value of the private
        // instance variable, name.
      return name;
   }
   
   public int getID() {
        // Getter method for reading the value of ID.
      return ID;
   }
   
   public double getAverage() {  
        // Compute average test grade.
      return (test1 + test2 + test3) / 3;
   }
   
}  // end of class Student
```

Dado que `nextUniqueID` es una variable estática, la inicialización `nextUniqueID = 0` se realiza solo una vez, cuando la clase se carga por primera vez. Cada vez que se construye un objeto `Student` y el constructor dice `nextUniqueID++;`, siempre es la misma variable miembro estática la que se incrementa. Cuando se crea el primer objeto `Student`, `nextUniqueID` se convierte en 1. Cuando se crea el segundo objeto, `nextUniqueID` se convierte en 2. Después del tercer objeto, se convierte en 3. Y así sucesivamente. El constructor almacena el nuevo valor de `nextUniqueID` en la variable `ID` del objeto que se está creando. Por supuesto, `ID` es una variable de instancia, por lo que cada objeto tiene su propia variable de `ID` individual. La clase está construida para que cada estudiante obtenga automáticamente un valor diferente para su variable `ID`. Además, la variable `ID` es privada, por lo que no hay forma de manipular esta variable después de que se haya creado el objeto. Tiene la garantía, solo por la forma en que está diseñada la clase, de que cada objeto de estudiante tendrá su propio número de identificación único y permanente. Lo cual es genial si lo piensas.

### ¿Qué parámetros *debe* tener un constructor?

Supongamos una clase `Bebe` que almacena información de niños recién nacidos. Estos bebés tienen, un sexo, un nombre, un color de pelo, un peso, una talla. ¿Pero qué parámetros debe tener el constructor? Si lo pensamos detenidamente todos, excepto el nombre -tal vez los padres todavía duden-, son atributos que tiene el bebé nada más nacer por lo que el constructor **debe** incluir todos estos parámetros. Tal vez haya otro constructor para un bebé del que los padres ya han decidido qué nombre ponerle antes de nacer. Pero para aquellos que todavía no lo saben, debe existir un setter para fijar el nombre.

Es decir, los parámetros del constructor **deben** incluir todos aquellos **necesarios** en el momento de la creación. Después hemos de pensar qué otros atributos queremos incluir como no necesarios.

----
Adaptado de los siguientes materiales

* [https://math.hws.edu/javanotes/](https://math.hws.edu/javanotes/)

* [https://github.com/ram8647/javajavajava](https://github.com/ram8647/javajavajava)

* [https://computing.southern.edu/halterman/OOPJ/](https://computing.southern.edu/halterman/OOPJ/)

* [https://cnx.org/contents/QCsgrcAf@37.6:3F9DBM-W@21/](https://cnx.org/contents/QCsgrcAf@37.6:3F9DBM-W@21/)
