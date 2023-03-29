---
typora-copy-images-to: ..//programacion-java/assets/img/BD/img/BD/
typora-root-url: ../../
layout: post
title: Introducción a las bases de datos en java
categories: bd
conToc: true
permalink: introduccion-bases-de-datos-java
---

## 1 Introducción

Hoy en día, la mayoría de aplicaciones informáticas necesitan almacenar y gestionar gran cantidad de datos.

Esos datos, se suelen guardar en **bases de datos relacionales**, ya que éstas son las más extendidas actualmente.

Las bases de datos relacionales permiten organizar los datos en **tablas** y esas tablas y datos se relacionan mediante campos clave. Además se trabaja con el lenguaje estándar conocido como **SQL**, para poder realizar las consultas que deseemos a la base de datos.

Una base de datos relacional se puede definir de una manera simple como aquella que presenta la información en tablas con filas y columnas.

Una tabla es una serie de **filas** y **columnas** , en la que cada fila es un **registro** y cada columna es un **campo**. Un campo representa un dato de los elementos almacenados en la tabla (NSS, nombre, etc.). Cada registro representa un elemento de la tabla (el equipo Real Madrid, el equipo Real Murcia, etc.)

No se permite que pueda aparecer dos o más veces el mismo registro, por lo que uno o más campos de la tabla forman lo que se conoce como **clave primaria** (atributo que se elige como identificador en una tabla, de manera que no haya dos registros iguales, sino que se diferencien al menos en esa clave. Por ejemplo, en el caso de una tabla que guarda datos de personas, el número de la seguridad social, podría elegirse como clave primaria, pues sabemos que aunque haya dos personas llamadas, por ejemplo, Juan Pérez Pérez, estamos seguros de que su número de seguridad social será distinto).

El sistema gestor de bases de datos, en inglés conocido como: **Database Management System (DBMS)** , gestiona el modo en que los datos se almacenan, mantienen y recuperan.

En el caso de una base de datos relacional, el sistema gestor de base de datos se denomina: **Relational Database Management System (RDBMS)**.

Tradicionalmente, la programación de bases de datos ha sido como una Torre de Babel: gran cantidad de productos de bases de datos en el mercado, y cada uno "hablando" en su lenguaje privado con las aplicaciones.

Java, mediante **JDBC** ( Java Database Connectivity, API que permite la ejecución de operaciones sobre bases de datos desde el lenguaje de programación Java, independientemente del sistema operativo donde se ejecute o de la base de datos a la cual se accede), permite simplificar el acceso a base de datos , proporcionando un lenguaje mediante el cual las aplicaciones pueden comunicarse con motores de bases de datos. Sun desarrolló este API para el acceso a bases de datos, con tres objetivos principales en mente:

* Ser un API con soporte de SQL: poder construir sentencias SQL e insertarlas dentro de llamadas al API de Java,
* Aprovechar la experiencia de los APIs de bases de datos existentes,
* Ser sencillo.

## 2 El desfase objeto-relacional

El desfase objeto‐relacional, también conocido como impedancia objeto‐relacional, consiste en la diferencia de aspectos que existen entre la programación orientada a objetos y la base de datos.
Estos aspectos se puede presentar en cuestiones como:

* **Lenguaje de programación**: El programador debe conocer el lenguaje de programación orientada a objetos (POO) y el lenguaje de acceso a datos.

* **Tipos de datos**: en las bases de datos relacionales siempre hay restricciones en cuanto a los tipos de datos que se pueden usar, que suelen ser sencillos, mientras que la programación orientada a objetos utiliza tipos de datos más complejos.

* **Paradigma de programación** (una propuesta tecnológica, un modelo, adoptada por una comunidad de programadores que unívocamente trata de resolver uno o varios problemas claramente delimitados. Tiene una estrecha relación con la formalización de determinados lenguajes en su momento de definición. Un paradigma de programación está delimitado en el tiempo en cuanto a aceptación y uso ya que nuevos paradigmas aportan nuevas o mejores soluciones que la sustituyen parcial o totalmente ). En el proceso de diseño y construcción del software se tiene que hacer una traducción del modelo orientado a objetos de clases al modelo Entidad‐Relación (E/R) puesto que el primero maneja objetos y el segundo maneja tablas y tuplas o filas, lo que implica que se tengan que diseñar dos diagramas diferentes para el diseño de la aplicación.

El modelo relacional trata con relaciones y conjuntos debido a su naturaleza matemática. Sin embargo, el modelo de Programación Orientada a Objetos trata con objetos y las asociaciones entre ellos. Por esta razón, el problema entre estos dos modelos surge en el momento de querer persistir los objetos de negocio

La escritura (y de manera similar la lectura) mediante JDBC implica: abrir una conexión, crear una sentencia en SQL y copiar todos los valores de las propiedades de un objeto en la sentencia, ejecutarla y así almacenar el objeto. Esto es sencillo para un caso simple, pero trabajoso si el objeto posee muchas propiedades, o bien se necesita almacenar un objeto que a su vez posee una colección de otros elementos. Se necesita crear mucho más código, además del tedioso trabajo de creación de sentencias SQL.

Este problema es lo que denominábamos **impedancia Objeto‐Relacional** , o sea, el conjunto de dificultades técnicas que surgen cuando una base de datos relacional se usa en conjunto con un programa escrito con lenguajes de Programación Orientada a Objetos.

Veremos este desfase a lo largo de las actividades.

## 3 Conexión a las BD: Conectores

Dejemos de momento de lado el desfase Objeto-Relacional y centrémonos ahora en el acceso a Base de Datos Relacionales desde los lenguajes de programación. Lo razonaremos en general y lo aplicaremos a Java.

Desde la década de los 80 que existen a pleno rendimiento las bases de datos relacionales. Casi todos los Sistemas Gestores de Bases de Datos (excepto los más pequeños como Access o Base de LibreOffice) utilizan la arquitectura cliente-servidor. Esto significa que hay un ordenador central donde está instalado el Sistema Gestor de Bases de Datos Relacional que actúa como servidor, y habrá muchos clientes que se conectarán al servidor haciendo peticiones sobre la Base de Datos.

Los Sistemas Gestores de Bases de Datos inicialmente disponían de lenguajes de programación propios para poder hacer los accesos desde los clientes. Era muy consistente, pero a base de ser muy poco operativo:

- La empresa desarrolladora del SGBD debían mantener un lenguaje de programación, que resultaba necesariamente muy costoso, si no querían que quedara desfasado.
- Las empresas usuarias del SGBD, que se conectaban como clientes, se encontraban muy ligadas al servidor para tener que utilizar el lenguaje de programación para acceder al servidor, lo que no siempre se ajustaba a sus necesidades. Además, el plantearse cambiar de servidor, significaba que había que rehacer todos los programas, y por tanto una tarea de muchísima envergadura.

Para poder ser más operativos, había que desvincular los lenguajes de programación de los Sistemas Gestores de Bases de Datos utilizando unos estándares de conexión.



## 4 JDBC

**JDBC** es un **API** Java que hace posible ejecutar sentencias **SQL**.

De JDBC podemos decir que:
* Consta de un conjunto de clases e interfaces escritas en Java.
* Proporciona un API estándar para desarrollar aplicaciones de bases de datos con un API Java pura.

Con JDBC , no hay que escribir un programa para acceder a una base de datos Access, otro programa distinto para acceder a una base de datos Oracle, etc., sino que podemos escribir un único programa con el API JDBC y el programa se encargará de enviar las sentencias SQL a la base de datos apropiada. Además, y como ya sabemos, una aplicación en Java puede ejecutarse en plataformas distintas.

En el desarrollo de JDBC, y debido a la confusión que hubo por la proliferación de API's propietarios de acceso a datos, Sun buscó los aspectos de éxito de un API de este tipo, ODBC ( Open Database Connectivity. API de acceso a datos, desarrollado por Microsoft. con la idea de tener un estándar para el acceso a bases de datos en entorno Windows ).

Aunque la industria ha aceptado ODBC como medio principal para acceso a bases de datos en Windows, ODBC no se introduce bien en el mundo Java, debido a la complejidad que presenta ODBC, y que entre otras cosas ha impedido su transición fuera del entorno Windows.

El nivel de abstracción ( Uno de los objetivos fundamentales de una base de datos es proporcionar a los usuarios una visión abstracta de los datos. Es decir, el sistema oculta ciertos detalles relativos a la forma en que se almacenan y mantienen los datos. Esto se logra definiendo tres niveles de abstracción en los que puede considerarse la base de datos: físico, conceptual y de visión ) al que trabaja JDBC es alto en comparación con ODBC, la intención de Sun fue que supusiera la base de partida para crear librerías de más alto nivel.

JDBC intenta ser tan simple como sea posible, pero proporcionando a los desarrolladores la máxima flexibilidad.

>  JDBC es la versión de ODBC para Java.


### Instalación controlador MySql

El primer paso es descargar desde https://www.mysql.com/products/connector/ el conector apropiado.

![1557844973343](/programacion-java/assets/img/BD/1557844973343.png)

![1557845207905](/programacion-java/assets/img/BD/1557845207905.png)

Haced clic en el enlace **Looking for previous GA versions?**

![1557847453096](/programacion-java/assets/img/BD/1557847453096.png)

Haced clic en Donwload y seleccionad la opción **No thanks, just start download**![1557845061814](/programacion-java/assets/img/BD/1557845061814.png)

Descomprimid el archivo y os quedará la siguiente estructura de directorio:

![1557847524903](/programacion-java/assets/img/BD/1557847524903.png)

Ahora copiad el archivo `mysql-connector-java-5.1.47.jar` en directorio de instalación de Eclipse.

El siguiente paso es configurar Eclipse para que se comunique con **MySql**. En primer lugar hay que haber descargado el archivo `mysql-connector-java-5.1.47.jar`. 

El siguiente paso es crear un **New Driver Definition**, desde `Window -> Preferences -> Data Management -> Connectivity -> Driver Definitions` y pulsamos el botón **Add**.

<video controls="controls" src="/programacion-java/assets/img/BD/DriverDefinition.m4v" ></video>


### Agregar la librería a un proyecto Eclipse

Una vez creado el proyecto, hemos de añadir el conector como una **librería externa**, configurando el Build Path

![1557845704969](/programacion-java/assets/img/BD/1557845704969.png)

<video  controls="controls" src="/programacion-java/assets/img/BD/ConfProyecto.m4v" ></video>

Y ya tenemos instalada la librería.

![1557848175572](/programacion-java/assets/img/BD/1557848175572.png)

###  Instalar driver en IntelliJ

En el caso de IntelliJ lo instalaremos como una dependencia el archivo `pom.xml` que se encuentra en raíz del proyecto, donde añadimos las siguientes líneas:
```xml
<dependencies>
	<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
	<dependency>
	    <groupId>mysql</groupId>
	    <artifactId>mysql-connector-java</artifactId>
	    <version>8.0.32</version>
	</dependency>
</dependencies>
```

Después pulsamos botón derecho sobre el archivo `pom.xml` y elegimos `maven -> Reload project`


### Instalar driver en BlueJ

En el caso de **BlueJ**, se añaden las librerías desde *Herramientas -> Preferencias -> Librerías*

![1520962274001](/programacion-java/assets/img/BD/1520962274001.png)

### Carga del controlador JDBC y conexión con la BD

El primer paso para conectarnos a una base de datos mediante JDBC es cargar el controlado apropiado. Estos controladores se distribuyen en un archivo `.jar` que provee el fabricante del SGBD y deben estar accesibles por la aplicación, bien porque están en el `CLASSPATH` de java o porque lo tenemos en el mismo directorio que la aplicación.

Para cargar el controlador se usan las siguientes sentencias:

```java
import java.sql.*;
public class ConnectToMySql {
  public static void main(String[] av) {
    try {
      // Dependiendo de a qué tipo de SGBD queramos conectar cargaremos un controlador u otro
      // Intentar cargar el driver de MySQL
      Class<?> c = Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Cargado " + c.getName());
      //Definir la url de conexión y los parámetros de usuario y contraseña
      String host = "jdbc:mysql://localhost:3306/network";
      String username = "root";
      String password = "sa";
      Connection con = DriverManager.getConnection(host, username, password);
      System.out.println("Conexión completada");
      con.close();
    } catch (ClassNotFoundException cnfe) {
      System.out.println(cnfe.getMessage());
	} catch (SQLException ex) {
      System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
    }
  }
}
```



Observamos las siguientes cuestiones:

- Como ya hemos comentado alguna vez, la sentencia `Class.forName()` no sería necesaria en muchas aplicaciones. Pero nos asegura que hemos cargado el driver, y por tanto el `DriverManager` la sabrá manejar 

- El `DriverManager` es capaz de encontrar el driver adecuado a través de la url proporcionada (sobre todo si el driver está cargado en memoria), y es quien nos proporciona el objeto `Connection` por medio del método `getConnection()`. Hay otra manera de obtener el `Connection` por medio del objeto `Driver`, como veremos más adelante, pero también será pasando indirectamente por `DriverManager`.

- Si no se encuentra la clase del driver (por no tenerlo en las librerías del proyecto, o haber escrito mal su nombre) se producirá la excepción `ClassNotFoundException`. Es conveniente tratarla con `try ... catch`.

- Si no se puede establecer la conexión por alguna razón se producirá la excepción `SQLException`. Al igual que en el caso anterior, es conveniente tratarla con `try ... catch`.

- El objeto `Connection` mantendrá una conexión con la Base de Datos desde el momento de la creación hasta el momento de cerrarla con `close()`. Es muy importante cerrar la conexión, no sólo para liberar la memoria de nuestro ordenador (que al cerrar la aplicación liberaría), sino sobre todo para cerrar la sesión abierta en el Servidor de Bases de Datos.



>  -warning-. Para que este programa funcione, los jar's de los drivers deben estar en alguna ruta definida en el `CLASSPATH` de java.

Una manera de conectar alternativa a las anteriores es utilizando el objeto `Driver`. La clase `java.sql.Driver` pertenece a la **API JDBC**, pero no es instanciable, y tan sólo es una interfaz, para que las clases `Driver` de los contenedores hereden de ella e implementen la manera exacta de acceder al SGBD correspondiente. Como no es instanciable (no podemos hacer new Driver()) la manera de crearlo es a través del método `getDriver()` del `DriverManager`, que seleccionará el driver adecuado a partir de la url. Ya sólo quedarán definir algunas propiedades, como el usuario y la contraseña, y obtener el `Connection` por medio del método `connect()`

La manera de conectar a través de un objeto `Driver` es más larga, pero más completa ya que se podrían especificar más cosas. Y quizás ayude a entender el montaje de los controladores de los diferentes SGBD en Java.

```java
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectToMySqlDriver {

    public static void main(String[] args)  {
        String url="jdbc:mysql://localhost:3306/network";
        String username = "root";
        String password = "sa";
		
		try{
		    Driver driver = DriverManager.getDriver(url);

		    Properties properties = new Properties();
		    properties.setProperty("user", username);
		    properties.setProperty("password", password);

		    Connection con = driver.connect(url, properties);
		    System.out.println("Conexión completada a través de Driver");
		    con.close();
		} catch (SQLException ex) {
      		System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
    	}
    }
}
```

> -info-En este caso, sólo funcionará si el driver se encuentra en el `CLASSPATH` o hemos añadido la librería a nuestro IDE

### Carga del controlador y de la conexión mediante el patrón Singleton

Este patrón de diseño está diseñado para restringir la creación de objetos pertenecientes a una clase. Su intención consiste en garantizar que  una clase sólo tenga una instancia y proporcionar un punto de acceso global a ella.
El patrón `Singleton` se implementa creando en nuestra clase un método que crea una instancia del objeto sólo si todavía no existe alguna. 
Para asegurar que la clase no puede ser instanciada nuevamente se regula el alcance del constructor haciéndolo privado.
Las situaciones más habituales de aplicación de este patrón son aquellas en las que dicha clase ofrece un conjunto de utilidades comunes para todas las capas (como puede ser el sistema de log, conexión a la base de datos, ...) o cuando cierto tipo de datos debe estar disponible para todos los demás objetos de la aplicación (en java no hay variables globales)
El patrón Singleton provee una única instancia global gracias a que:

- La propia clase es responsable de crear la única instancia.

- Permite el acceso global a dicha instancia mediante un método de clase.

- Declara el constructor de clase como privado para que no sea instanciable directamente.

```java

/**
 * @see <a href="https://stackoverflow.com/questions/6567839/if-i-use-a-singleton-class-for-a-database-connection-can-one-user-close-the-con">Stackoverflow Singleton</a>
 * Patron Singleton
 * ================
 * Este patrón de diseño está diseñado para restringir la creación de objetos pertenecientes a una clase. Su intención consiste en garantizar que
 * una clase sólo tenga una instancia y proporcionar un punto de acceso global a ella.
 * El patrón Singleton se implementa creando en nuestra clase un método que crea una instancia del objeto sólo si todavía no existe alguna.
 * Para asegurar que la clase no puede ser instanciada nuevamente se regula el alcance del constructor haciéndolo privado.
 * Las situaciones más habituales de aplicación de este patrón son aquellas en las que dicha clase ofrece un conjunto de utilidades comunes
 * para todas las capas (como puede ser el sistema de log, conexión a la base de datos, ...)
 * o cuando cierto tipo de datos debe estar disponible para todos los demás objetos de la aplicación.
 * El patrón Singleton provee una única instancia global gracias a que:
 * - La propia clase es responsable de crear la única instancia.
 * - Permite el acceso global a dicha instancia mediante un método de clase.
 * - Declara el constructor de clase como privado para que no sea instanciable directamente.
 */
public class DatabaseConnection
{
    private static DatabaseConnection dbInstance; //Variable para almacenar la unica instancia de la clase
    private static java.sql.Connection con;

    private DatabaseConnection() {
      // El Constructor es privado!!
    }

    public static DatabaseConnection getInstance(){
        //Si no hay ninguna instancia...
        if(dbInstance==null){
            dbInstance= new DatabaseConnection();
        }
        return dbInstance;
    }

    public  java.sql.Connection getConnection(){

        if(con==null){
            try {
                String host = "jdbc:mysql://localhost:3306/network";
                String username = "root";
                String password = "sa";
                con = java.sql.DriverManager.getConnection( host, username, password );
                System.out.println("Conexión realizada");
            } catch (java.sql.SQLException ex) {
                System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }

        return con;
    }
}
```

![1557849184617](/programacion-java/assets/img/BD/1557849184617.png)

Vamos a crear una nueva clase para probar la conexión.

```java
import java.sql.*;
public class Test
{
    static java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
    public Test(){
        //De momento no hace nada
    }
}
```

![1557849470525](/programacion-java/assets/img/BD/1557849470525.png)

