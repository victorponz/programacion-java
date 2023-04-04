---
typora-copy-images-to: ../assets/img/poo-tablas/
typora-root-url: ../../
layout: post
title: Bases de datos y POO
categories: bd
conToc: true
permalink: bases-de-datos-y-poo
---

En este tema vamos a aprender a añadir a un proyecto orientado a objetos la persistencia en base de datos, sin usar ninguna tecnología como Hibernate (que lo veremos posteriormente).

Partimos de una aplicación en la que los usuarios pueden escribir Posts y comentar Post hechos por otros usuarios. Por lo que existen tres entidades: Usuarios, Posts y Comentarios. En la siguiente imagen se muestran estas entidades representadas en una base de datos.

![1522912364266](programacion-java/assets/img/poo-tablas/1522912364266.png)

## Clase Usuario

El primer paso es encontrar la entidad-objeto más fácil de implementar. En nuestro caso esta entidad es `Usuario` ya que no tiene ninguna clave ajena.

Para esta entidad, creamos sus propiedades junto con sus `setters` y `getters`.

```java
public class Usuario
{
    private int id;
    private String nombre;
    private String apellidos;

    /**
     * Constructor for objects of class Usuario
     */
    public Usuario()
    {
        this.nombre = "";
        this.apellidos = "";
        this.id = -1;
    }
    public Usuario(int id, String nombre, String apellidos){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    public Usuario(String nombre, String apellidos)
    {
        this(-1, nombre, apellidos);
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    @Override
    public String toString(){
        return "ID: " + id + " NOMBRE: " + nombre + " APELLIDOS: " + apellidos;
    }

}
```

![1522913290308](programacion-java/assets/img/poo-tablas/1522913290308.png)

Usaremos para conectarnos a la base de datos un patrón **singleton** para compartir la conexión con todos los objetos de nuestra aplicación.

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

    public java.sql.Connection getConnection(){

        if(con==null){
            try {
                String host = "jdbc:sqlite:src/main/resources/network";
                con = java.sql.DriverManager.getConnection( host );
                System.out.println("Conexión realizada");
            } catch (java.sql.SQLException ex) {
                System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }

        return con;
    }
}
```



![1522913318953](programacion-java/assets/img/poo-tablas/1522913318953.png)

## Clase UsuarioService

![image-20230404081604932](/programacion-java/assets/img/poo-tablas/image-20230404081604932.png)

Una vez creada la clase `Usuario`, creamos una clase de ayuda que nos permitirá realizar la transformación entre los objetos y la base de datos. El cometido de esta clase es transformar los registros de la base de datos en objetos de clase `Usuario` y viceversa. De esta forma, intentamos corregir el  **desfase objeto-relacional**. La clase `Usuario` es una clase típica de POO con campos, setters y getters y es en la clase `UsuarioRepositorio` donde se realiza el mapeo objeto-relacional. Todos los métodos de esta clase son estáticos. Además, para que no se pueda instanciar, hacemos el constructor privado. Esta clase es 'estática' porque no es realmente un objeto sino una clase de ayuda para realizar el mapeo y para devolver objetos de tipo `Usuario`. Más adelante veremos, mediante persistencia, que existen métodos que nos permiten solucionar de una forma más cómoda este desfase.

En un primer paso, sólo vamos a implementar la inserción de datos (convertir objetos en registros) y la recuperación de un Usuario de la base de datos (convertir registros en objetos). De esta forma, ya podemos insertar y recuperar un Usuario.

Este es el stub de la clase `UsuarioService`

```java
/**
 * Permite añadir, modificar y eliminar usuarios, así como mostrarlos por pantalla
 * El cometido de esta clase es transformar los registros de la base de datos en objetos de clase Usuario y viceversa, siguiendo el patrón de desarrollo Repository Pattern
 * De esta forma, intentamos corregir el  desfase objeto-relacional 
 * La clase Usuario es una clase típica de POO con campos, setters y getters y es en esta clase donde se realiza el mapeo objeto-relacional
 * Todos los métodos de esta clase son estáticos. Además, para que no se pueda instanciar, hacemos el constructor privado. 
 * Esta clase es 'estática' porque no es realmente un objeto sino una clase de ayuda para realizar el mapeo y para devolver objetos de tipo Usuario.
 * Más adelante veremos, mediante persistencia, que existen métodos que nos permiten solucionar de una forma más cómoda este desfase.
 * 
 * @author (Víctor Ponz)
 * @version (13/03/2023)
 */
import java.util.ArrayList;
import java.sql.*;

public class UsuarioService
{
  
    //Almacenar la conexión a la base de datos
    static java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
  
    private UsuarioService () { // Constructor privado para que no se pueda instanciar!!
        
    }
}
```

### Insertar Usuario (Crud - Create)

El primer método a implementar será el que nos permita insertar un `Usuario` en la base de datos: partimos de una instancia de un objeto `Usuario` y lo mapeamos en un registro en la base de datos:

> -alert-Para hacer más legible el código, no tratamos las excepciones porque esperamos que todo funcione correctamente. Evidentemente en una aplicación real hemos de tratar todas las excepciones.

```java
public static void insertUser(Usuario usuario) throws SQLException {
    if (usuario.getId() != -1){
        System.out.println("El usuario ya existe");
        return;
    }
    PreparedStatement st = null;

    String query = "INSERT INTO usuarios (nombre, apellidos) VALUES (?, ?)";
    st = con.prepareStatement(query);
    st.setString(1, usuario.getNombre());
    st.setString(2, usuario.getApellidos());

    st.executeUpdate();

    System.out.println("Usuario insertado");
    st.close();
}
```

Simplemente, estamos creando la cadena SQL para insertar un registro en la base de datos a partir de una instancia de `Usuario`.

Vamos a crear una clase de ayuda para ir probando. Insertamos un `Usuario`

```java
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException{
        Usuario usuario = new Usuario("Pepe", "Viyuela");
        UsuarioService.insertUser(usuario);
    }
}
```

Pero, en el caso de la tabla `usuarios` de nuestra base de datos, el campo ID es automático. ¿Cómo sabemos qué id le ha autogenerado? Usando `prepareStatement()` con un segundo parámetro con el valor de `Statement.RETURN_GENERATED_KEYS` y luego recuperándolo mediante una llamada a `getGeneratedKeys()`

```java
public static void insertUser(Usuario usuario) throws SQLException {
    if (usuario.getId() != -1){
        System.out.println("El usuario ya existe");
        return;
    }
    ResultSet rs;
    PreparedStatement st = null;

    String query = "INSERT INTO usuarios (nombre, apellidos) VALUES (?, ?)";
    //Fijáos en Statement.RETURN_GENERATED_KEYS. Permite recuperar el campo ID autogenerado por MySql
    st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

    st.setString(1, usuario.getNombre());
    st.setString(2, usuario.getApellidos());

    st.executeUpdate();

    //Recuperar el id autogenerado
    rs = st.getGeneratedKeys();
    //Este ResultSet solo puede contener un registro: el ID autogenerado

    if (rs.next()){
        //Ahora ya sabemos cuál es el nuevo id del Usuario
        usuario.setId(rs.getInt(1));
        System.out.println("ID Autogenerado:  " + usuario.getId());
    }
    System.out.println("Usuario insertado");
    st.close();
}
```

### Obtener un Usuario (cRud - Read)

Ahora vamos a realizar el mapeo contrario: seleccionamos un usuario de la base de datos y lo convertimos en una entidad de la clase `Usuario`.

```java
public static Usuario getOneUserById(int id) throws SQLException{
    PreparedStatement st = con.prepareStatement("SELECT * FROM usuarios WHERE id = ? ");
    st.setInt(1, id);

    ResultSet rs = st.executeQuery();
    Usuario u = null;
    //Si la consulta devuelve algún resultado ...
    if (rs.next()){
        // ... lo mapeamos a un objeto Usuario
        u = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"));
    }
    //Devolvemos el Usuario ya mapeado
    return u;
}
```

Vamos a comprobar que funciona en `main`

```java
public static void main(String[] args) throws SQLException{
    Usuario usuario = UsuarioService.getOneUserById(15);
    if (usuario != null)
        System.out.println(usuario);
}
```

Cuya salida es:

```
ID: 15 NOMBRE: Pedro APELLIDOS: Martínez
```

Como el mapeo vamos a usarlo en más sitios, refactorizamos:

```java
public static Usuario mapeoBDToUsuario(int id, String nombre, String apellidos){
    return new Usuario(id, nombre, apellidos);
}
```

Y ahora lo usamos en `getOneUserById`

```java
public static Usuario getOneUserById(int id) throws SQLException{
    PreparedStatement st = con.prepareStatement("SELECT * FROM usuarios WHERE id = ? ");
    st.setInt(1, id);

    ResultSet rs = st.executeQuery();
    Usuario u = null;
    //Si la consulta devuelve algún resultado ...
    if (rs.next()){
        // ... lo mapeamos a un objeto Usuario
        u = mapeoBDToUsuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"));
    }
    //Devolvemos el Usuario ya mapeado
    return u;
}
```

### Actualizar un Usuario (crUd - Update)

El siguiente paso será poder actualizar

```java
public static void updateUser(Usuario usuario) throws SQLException{
    if (usuario == null) return;
    PreparedStatement st = null;

    String query = "UPDATE usuarios SET nombre = ?, apellidos = ?  WHERE id = ?";
    st = con.prepareStatement(query);
    st.setString(1, usuario.getNombre());
    st.setString(2, usuario.getApellidos());
    st.setInt(3, usuario.getId());
    /*
     * Además, executeUpdate devuelve el número de filas afectadas.
     * Por tanto, si devuelve un valor distinto de 1 es que otro usuario (u otra sesión) ha borrado este usuario
     */
    int filas = st.executeUpdate();
    if (filas != 1){
        System.out.println("No existe el usuario con ID " + usuario.getId());
    }
}
```

Vamos a comprobar que funciona

```java
public static void main(String[] args) throws SQLException{
    Usuario usuario = UsuarioService.getOneUserById(15);
    if (usuario != null) {
        System.out.println(usuario);
        usuario.setApellidos("García");
        UsuarioService.updateUser(usuario);
        usuario = null;
        //Vamos a comprobar que realmente lo ha guardado en la bd;
        usuario = UsuarioService.getOneUserById(15);
        System.out.println(usuario);
    }
}
```

Y esta es la salida:

```
ID: 15 NOMBRE: Pedro APELLIDOS: Martínez
ID: 15 NOMBRE: Pedro APELLIDOS: García
```

### Eliminar un Usuario (cruD - Delete)

Y el último paso será eliminar un usuario:

```java
public static void deleteUser(Usuario usuario) throws SQLException{
    if (usuario == null) return;
    PreparedStatement st = con.prepareStatement("DELETE FROM usuarios WHERE id = ?");
    st.setInt(1, usuario.getId());
    int filas = st.executeUpdate();
    if (filas != 1){
        System.out.println("No existe el usuario con ID " + usuario.getId());
    }
}
```

## Clase UsuarioRepository

Una vez tenemos los métodos que nos permiten mapear, vamos a crear un repositorio de métodos que hagan consultas la base de datos.

![image-20230404081842202](/programacion-java/assets/img/poo-tablas/image-20230404081842202.png)

### Obtener más de un Usuario

Vamos a crear un método que nos permita obtener todos los usuarios de la base de datos.

Los usuarios que nos devuelva la consulta **SELECT** los guardaremos en un `HashSet` después de haberlos convertido en instancias de la clase `Usuario`.

```java
public static HashSet<Usuario> getAllUsers() throws SQLException {

    HashSet<Usuario> usuarios = new HashSet<>();

    Statement st = con.createStatement();
    //Ejecutar la consulta, guardando los datos devueltos en un Resulset
    ResultSet rs = st.executeQuery("SELECT * FROM usuarios ORDER BY apellidos, nombre");

    while(rs.next()){
        //Mapeamos el registro de la BD en un Usuario
        Usuario u = UsuarioService.mapeoBDToUsuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"));
        //Añadir el Usuario al conjunto de usuarios
        usuarios.add(u);
    }
    return usuarios;
}
```

Como se puede comprobar, es muy sencillo crear métodos que nos devuelvan `Usuarios` que cumplan cierto criterio, simplemente añadiendo una cláusula `WHERE`

>-info-Esta forma de trabajar con bases de datos donde tenemos un clase POJO (en esta caso, `Usuario`, y otra clase `UsuarioRepository` que centraliza el trabajo para convertir objetos en tablas y viceversa se denomina "**Repository Pattern**" . 
>Nosotros vamos a implementar una versión sencilla de este patrón. El original está basado en Interfaces y clases abstractas

```java
public static void main(String[] args) throws SQLException{
    HashSet<Usuario> usuarios = UsuarioRepositorio.getAllUsers();
    for(Usuario usuario: usuarios){
        System.out.println(usuario);
    }
}
```

Y este es el resultado:

```
ID: 14 NOMBRE: Juan APELLIDOS: Imedio
ID: 13 NOMBRE: Pepe APELLIDOS: Viyuela
ID: 7 NOMBRE: Maria APELLIDOS: Gallardo
ID: 5 NOMBRE: Pepe APELLIDOS: Ponz
ID: 3 NOMBRE: Andrés APELLIDOS: García
ID: 9 NOMBRE: Victor APELLIDOS: Ponz
ID: 4 NOMBRE: Janet APELLIDOS: Espinosa
```

> -reto-Crea un nuevo método en el repositorio que permita obtener aquellos usuarios que contengan una determinada cadena


