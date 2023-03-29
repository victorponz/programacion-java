---
typora-copy-images-to: ../assets/img/datos
typora-root-url: ../../
layout: post
title: Acceso a datos
categories: bd
conToc: true
permalink: acceso-a-datos
---

Para escribir sentencias SQL, JDBC dispone de los objetos `Statement`. Se trata de objetos que se han de crear a partir de `Connection`, los cuales pueden enviar sentencias SQL al SGBD conectado para que se ejecutan con el método `executeQuery` o `executeUpdate`.

Hay una variante del `Statement`, llamada `PreparedStatement` que nos da más versatilidad para poner parámetros y ejecutar la sentencia de otro modo. Lo veremos más adelante.

La diferencia entre los dos métodos que ejecutan sentencias SQL es:
* El método `executeQuery` sirve para ejecutar sentencias de las que se espera que devuelven datos, es decir, son consultas **SELECT**.
* En cambio, el método `executeUpdate` sirve específicamente para sentencias que no devuelven datos. Servirán para modificar la Base de Datos conectada (**INSERT**, **DELETE**, **UPDATE**, incluso **CREATE** TABLE).



## Sentencias que no devuelven datos

Las ejecutamos con el método `executeUpdate`. Serán todas las sentencias SQL **excepto el SELECT**, que es la de consulta. Es decir, nos servirá para las siguientes sentencias:

* Sentencias que cambian las estructuras internas de la BD donde se guardan los datos (instrucciones conocidas con las siglas **DDL**, del inglés **Data Definition Language**), como por ejemplo `CREATE TABLE`, `CREATE VIEW`, `ALTER TABLE`, `DROP TABLE`, ...,
* Sentencias para otorgar permisos a los usuarios existentes o crear otros nuevos (subgrupo de instrucciones conocidas como **DCL** o **Data Control Language**), como por ejemplo `GRANT`.
* Y también las sentencias para modificar los datos guardados utilizando las instrucciones `INSERT`, `UPDATE` y `DELETE`.

Aunque se trata de sentencias muy dispares, desde el punto de vista de la comunicación con el SGBD se comportan de manera muy similar, siguiendo el siguiente patrón:
1. Instanciación del `Statement` a partir de una conexión activa.
2. Ejecución de una sentencia SQL pasada por parámetro al método `executeUpdate`.
3. Cierre del objeto `Statement` instanciado.

Miremos este ejemplo, en el que vamos a crear una tabla muy sencilla en la Base de Datos MySql/network 

> **Nota** En este enlace tenéis la clase [DatabaseConnection](https://gist.github.com/victorponz/34e36ad0ff5585d91952e0edeb23fa49)

![1558006429758](/programacion-java/assets/img/datos/1558006429758.png)

## Sentencias que devuelven datos

Las ejecutamos con el método `executeQuery`. Servirá para la sentencia **SELECT**, que es la de consulta.
Los datos que nos devuelva esta sentencia las tendremos que guardar en un objeto de la clase `java.sql.ResultSet`, es decir conjunto de resultado. Por lo tanto, la ejecución de las consultas tendrá un forma similar a la siguiente:

```java
ResultSet rs = st.executeQuery(sentenciaSQL);
```

El objeto `ResultSet` contiene el resultado de la consulta organizado por filas, por lo que en cada momento se puede consultar una fila. Para ir visitando todas las filas de una a una, iremos llamando el método `next()` del objeto `ResultSet`, ya que cada vez que se ejecute `next` avanzará a la siguiente fila. Inmediatamente después de una ejecución, el `ResultSet` se encuentra posicionado justo antes de la primera fila, por lo tanto para acceder a la primera fila será necesario ejecutar `next` una vez. Cuando las filas se acaban, el método `next` devolverá falso.

Desde cada fila se podrá acceder al valor de sus columnas con ayuda de varios métodos `get` disponibles según el tipo de datos a devolver y pasando por parámetro el número de columna que deseamos obtener. El nombre de los métodos comienza por `get` seguido del nombre del tipo de datos. Así, si queremos recuperar la segunda columna, sabiendo que es un dato de tipo `String` habrá que ejecutar:

```java
rs.getInt(1);
```

Las columnas se empiezan a contar a partir del **valor 1** (no cero). La mayor parte de los SGDB soportan la posibilidad de pasar por parámetro el nombre de la columna, pero no todos, así que normalmente se opta por el parámetro numérico.

Por ejemplo MySql sí que deja acceder por nombre, por tanto, suponiendo que el campo 1 se llama ID, también se puede hacer:

```java
rs.getInt("ID");
```

En este ejemplo accedemos a la tabla usuarios y mostramos todos sus registros

![1558006455182](/programacion-java/assets/img/datos/1558006455182.png)

## Asegurar la liberación de recursos

Las instancias de `Connection` y las de `Statement` guardan, en memoria, mucha información relacionada con las ejecuciones realizadas. Además, mientras continúan activas mantienen en el SGBD una sesión abierta, que supondrá un conjunto importante de recursos abiertos, destinados a servir de forma eficiente las peticiones de los clientes. Es importante cerrar estos objetos para liberar recursos tanto del cliente como del servidor.

Si en un mismo método debemos cerrar un objeto `Statement` y el `Connection` a partir del cual la hemos creado, se deberá cerrar primero el `Statement` y después el `Connection`. Si lo hacemos al revés, cuando intentamos cerrar el `Statement` nos saltará una excepción de tipo `SQLException`, ya que el cierre de la conexión le habría dejado inaccesible.

Además de respetar el orden, asegurar la liberación de los recursos situando las operaciones de cierre dentro de un bloque `finally`. De este modo, aunque se produzcan errores, no se dejarán de ejecutar las instrucciones de cierre.

Hay que tener en cuenta todavía un detalle más cuando sea necesario realizar el cierre de varios objetos a la vez. En este caso, aunque las situamos una tras otra, todas las instrucciones de cierre dentro del bloque `finally`, no sería suficiente garantía para asegurar la ejecución de todos los cierres, ya que, si mientras se produce el cierre de un los objetos se lanza una excepción, los objetos invocados en una posición posterior a la del que se ha producido el error no se cerrarán.

La solución de este problema pasa por evitar el lanzamiento de cualquier excepción durante el proceso de cierre. Una posible forma es encapsular cada cierre entre sentencias `try-catch` dentro del `finally`

Aquí tenéis un ejemplo completo:

![1558006483816](/programacion-java/assets/img/datos/1558006483816.png)



## Ejemplos

El siguiente ejemplo permite insertar un usuario en la base de datos:

![1558006506490](/programacion-java/assets/img/datos/1558006506490.png)

Y este sería el mismo método pero pasándole los parámetros nombre y apellidos:

![1558006521344](/programacion-java/assets/img/datos/1558006521344.png)

Como se puede observar, hemos de construir la cadena sql concatenado datos, alternando comillas simples con dobles. Vamos, que si hemos de realizar una consulta con muchos campos, resulta bastante complejo crear la cadena sql y, además, puede llevarnos a errores.

## Sentencias predefinidas

Para solucionar el problema de crear sentencias sql complejas, se utiliza `PreparedStatement`. 

JDBC dispone de un objeto derivado del `Statement` que se llama `PreparedStatement`,  al que se le pasa la sentencia SQL en el momento de crearlo, no en el momento de ejecutar la sentencia (como pasaba con `Statement`). Y además esta sentencia puede admitir parámetros, lo que nos puede ir muy bien en determinadas ocasiones.

De cualquier modo, `PreparedStatement` presenta ventajas sobre su antecesor `Statement` cuando nos toque trabajar con sentencias que se hayan de ejecutar varias veces. La razón es que cualquier sentencia SQL, cuando se envía al SGBD será compilada antes de ser ejecutada.

* Utilizando un objeto `Statement`, cada vez que hacemos una ejecución de una sentencia, ya sea vía `executeUpdate` o bien vía `executeQuery`, el SGBD la compilará, ya que le llegará en forma de cadena de caracteres.
* En cambio, al `PreparedStament` la sentencia nunca varía y por lo tanto se puede compilar y guardar dentro del mismo objeto, por lo que las siguientes veces que se ejecute no habrá que compilarse. Esto reducirá sensiblemente el tiempo de ejecución.

En algunos sistemas gestores, además, usar `PreparedStatements` puede llegar a suponer más ventajas, ya que utilizan la secuencia de bytes de la sentencia para detectar si se trata de una sentencia nueva o ya se ha servido con anterioridad. De esta manera se propicia que el sistema guarde las respuestas en la memoria caché, de manera que se puedan entregar de forma más rápida.

La principal diferencia de los objetos `PreparedStatement` en relación a los `Statement`, es que en los primeros se les pasa la sentencia SQL predefinida en el momento de crearlo. Como la sentencia queda predefinida, ni los métodos `executeUpdate` ni `executeQuery` requerirán ningún parámetro. Es decir, justo al revés que en el `Statement`.

Los parámetros de la sentencia se marcarán con el símbolo de interrogación (?) Y se identificarán por la posición que ocupan en la sentencia, empezando a contar desde la izquierda a partir del número 1. El valor de los parámetros se asignará utilizando el método específico, de acuerdo con el tipo de datos a asignar. El nombre empezará por `set` y continuará con el nombre del tipo de datos (ejemplos: `setString`, `setInt`, `setLong`, `setBoolean` ...). Todos estos métodos siguen la misma sintaxis:

```java
setXXXX(<posiciónEnLaSentenciaSQL>, <valor>);
```

Este es el mismo método para insertar un usuario pero usando `PreparedStatement`:

![1558006558042](/programacion-java/assets/img/datos/1558006558042.png)

Fijaos que ahora, además, la sentencia sql es mucho más fácil de escribir. 

## Trabajar con Sqlite

Para poder trabajar en casa, vamos a utilizar Sqlite que es un una base de datos sencilla que se guarda en un único archivo en disco.

Lo primero es instalar SQLite, en Ubuntu

```
sudo apt-get install sqlite
```

Si queréis hacerlo en Windows, podéis seguir las instrucciones en http://www.sqlitetutorial.net/download-install-sqlite/

Para poder trabajar en java, hemos de descargar también el conector, desde

http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/

Lo primero que hemos de hacer es crear una base de datos, desde la línea de comandos. Para ello nos situamos en el directorio del proyecto y la creamos en el directorio `bd` mediante el siguiente comando:

```
cd directorio-del-proyecto
mkdir bd
cd bd
sqlite network.bd
```

Mediante estos comandos creamos una base de datos en disco llamada **network.bd**.

Ahora podemos crear las tablas mediante Eclipse, añadiendo una nueva `DataBaseConnection`, al igual que hicimos con MySql (previamente hemos de crear el `Driver Definition`).

![1558285490693](/programacion-java/assets/img/datos/1558285490693.png)

Y ahora podemos crear las tablas mediante Scrapbook

![1558285576032](/programacion-java/assets/img/datos/1558285576032.png)

<script src="https://gist.github.com/victorponz/a8cc553b166f9d903ce3ddedc8536ae9.js"></script>

Y vamos a añadir el jar que hemos descargado al Build path. 

> Nota. No sé por qué motivo pero no funciona si lo hago igual que para MySql

Así que elegimos el jar desde Build Path -> Libraries -> Add External JARs.

![1558285819653](/programacion-java/assets/img/datos/1558285819653.png)

Finalmente pulsamos Apply and Close.

En IntelliJ procedemos de la misma manera que hicimos para instalar el driver de MySql.

```xml
<!-- https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc -->
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.40.0.0</version>
</dependency>
```

Y ahora modificamos `DatabaseConnection`

```java
 String host = "jdbc:sqlite:./bd/network.bd";
 con = java.sql.DriverManager.getConnection( host);
```

Y hacemos una prueba para ver si funciona:

![1558290614137](/programacion-java/assets/img/datos/1558290614137.png)

Y este debe ser el resultado:

```
Conexión realizada
1	Janet	Espinosa
```

### Ejemplos

Vamos a crear una pequeña base de datos para Empleados en Sqlite:

| **Num** | **Nom**bre | **Depart**amento | **Edad** | **Sueldo** |
| ------- | ---------- | ---------------- | -------- | ---------- |
| 1       | Andreu     | 10               | 32       | 1000.00    |
| 2       | Bernat     | 20               | 28       | 1200.00    |
| 3       | Claudia    | 10               | 26       | 1100.00    |
| 4       | Damià      | 10               | 40       | 1500.00    |

Primero creamos un nuevo Proyecto en Eclipse llamado `EmpleadosBD` y le añadimos la librería sqlite al build path.

Creamos también la base de datos mediante la línea de comandos:

```
cd directorio-del-proyecto
mkdir bd
cd bd
sqlite empleados.bd
```

Copiamos el archivo `DatabaseConnection.java` del anterior proyecto y modificamos la cadena de conexión:

```java
String host = "jdbc:sqlite:./bd/empleados.bd";
con = java.sql.DriverManager.getConnection( host);
```

#### Crear tabla 

Creamos una clase `CreateTable` para poder crear la tabla:

![1558290594573](/programacion-java/assets/img/datos/1558290594573.png)



#### Insertar datos

Y creamos otra para insertar datos. Esta vez lo haremos con `PreparedStatement`:

![1558290468365](/programacion-java/assets/img/datos/carbon.png)



Esta es la versión con `Statement`:

![1558290468365](/programacion-java/assets/img/datos/1558290468365.png)

#### Consultar datos

Creamos  una clase `getAllEmpleados` que nos devuelva todos los empleados:

![1558290433130](/programacion-java/assets/img/datos/1558290433130.png)

#### Modificar datos

Ahora modificamos los datos. Simplemente aumentamos el sueldo un 5% y modificamos el departamento del empleado 3, poniéndole el departamento 3.

![1558290448718](/programacion-java/assets/img/datos/1558290448718.png)

