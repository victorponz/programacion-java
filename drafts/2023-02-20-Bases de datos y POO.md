---
typora-copy-images-to: ../programacion-java/programacion-java/assets/img/poo-tablas/img/poo-tablas/
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

[Código Fuente](./programacion-java/assets/img/poo-tablas/javas/DatabaseConnection.java.txt) 

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

![1522916160336](programacion-java/assets/img/poo-tablas/1522916160336.png)



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

### Obtener más de un Usuario

Una vez tenemos los métodos que nos permiten mapear, vamos a crear un repositorio de métodos que hagan consultas la base de datos

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

>-info-Esta forma de trabajar con bases de datos donde tenemos un clase POJO (en esta caso, `Usuario`, y otra clase `UsuarioRepositorio` que centraliza el trabajo para convertir objetos en tablas y viceversa se denomina "**Repository Pattern**" . 
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



## Clase Post

Como vemos en el diagrama entidad-relación de la base de datos ( o en el diagrama UML), los registros de tipo `Post` tienen una clave ajena que referencia a `Usuarios`. Y los registros de tipo `Comentario` tienen una clave ajena hace referencia al `Post` al que comentan. Por tanto, una vez implementada la clase `Usuario` (y repositorio y el servicio), es hora de implementar la clase `Post` y su repositorio y servicio ya que la única clave ajena (`Usuario`) ya está implementada. 

Como antes, creamos una clase típica POO para `Post`.

```java
/**
 * El objeto Post es como hemos hecho los objetos hasta ahora; es decir, campos, setters y getters, ya que toda la lógica esta en PostRepositorio y PostService
 *
 * @author (Víctor Ponz)
 * @version (13/03/2023)
 */
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
public class Post
{
    private Date fecha;
    private int id;
    private String texto;
    private int likes;
    private Usuario usuario;

    /**
     * Constructor for objects of class Post
     */
    public Post()
    {
        this.fecha = null;
        this.id = 0;
        this.texto = "";
        this.likes = 0;
        this.usuario = null;
    }
   
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTexto(){
        return texto;
    }
    public void setTexto(String texto){
        this.texto = texto;
    }
    public Date getFecha(){
        return fecha;
    }    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }    
        
    public int getLikes(){
        return likes;
    }
    public void setLikes(int likes){
        this.likes = likes;
    }
    
    public Usuario getUsuario(){
        return this.usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void like(){
        this.likes++;
    }
    
    public void unlike(){
        this.likes--;
    }
    public void display(){
        /*
         * Formateamos la fecha al locale por defecto del usuario
         */
        DateFormat formatter;
        formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.getDefault());
        System.out.println("ID: " + id + " USUARIO: " + usuario.getNombre() + " " + usuario.getApellidos() + " TEXTO: " + texto + " FECHA: " + formatter.format(fecha) + " LIKES: " + likes);
    }
}

```



![1522923356728](programacion-java/assets/img/poo-tablas/1522923356728.png)

## Clase PostService

Como antes implementamos todos los métodos CRUD en la entidad `Post`



## Clase PostRepositorio

Y ahora creamos la clase `PostRepositorio`, con todos sus métodos también estáticos. En este caso las sentencias SQL las ejecutamos mediante un `PreparedStatement` que es más eficiente que `Statement` como se explica más adelante.

[Código Fuente](./programacion-java/assets/img/poo-tablas/javas/PostRepositorio.java.txt) 

```java

/**
 * Permite añadir, modificar y eliminar posts, así recuperar objetos de tipo Post que cumplan ciertos criterios.
 * El cometido de esta clase es transformar los registros de la base de datos en objetos de clase Post y viceversa. 
 * De esta forma, intentamos corregir el  desfase objeto-relacional 
 * La clase Post es una clase tipica de POO con campos, setters y getters y es en esta clase donde se realiza el mapeo objeto-relacional
 * Todos los métodos de esta clase son estáticos. Además, para que no se pueda instanciar, hacemos el constructor privado. 
 * Esta clase es 'estática' porque no es realmente un objeto sino una clase de ayuda para realizar el mapeo y para devolver objetos de tipo Post.
 * Más adelante veremos, mediante persistencia, que existen métodos que nos permiten solucionar de una forma más cómoda este desfase.
 * 
 * @author (Víctor Ponz)
 * @version (13/03/2018)
 */
import java.util.ArrayList;
import java.sql.*;
public class PostRepositorio
{
      
    //Conectarnos a la base de datos mediante en patrón Singleton.
    static java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
    
    //Importante. Variable estática para almacenar los Post que ya hemos mapeado de la base de datos
    private static ArrayList<Post> postsCached =  new ArrayList<Post>();

    static PreparedStatement insertSt = null;
    static PreparedStatement updateSt = null;
    static PreparedStatement deleteSt = null;
   
    //Creamos las cadenas que nos van a servir de plantilla para las sentencias SQL. Cada ? implica un parámetro
    final static String insertString = "INSERT INTO posts (texto, likes, id_usuario) VALUES(?,?,?)";
    final static String updateString = "UPDATE posts SET texto = ?, likes = ? WHERE id = ?";
    final static String deleteString = "DELETE FROM posts WHERE id = ?";

    //Este bloque de declaración estático permite incluir instrucciones que solo se ejecutarán una vez (recordemos que no tiene constructor!)
    static {
        try {
            /*
             * Crear los preparedStatement para su uso posterior 
             * En el caso de INSERT, hemos de pasarle también el parámetro Statement.RETURN_GENERATED_KEYS para poder recoger el ID auto generado (igual que en UsuarioRepositorio).
             * Ver insertPost
             */ 
            insertSt = con.prepareStatement(insertString, Statement.RETURN_GENERATED_KEYS);
            updateSt = con.prepareStatement(updateString);
            deleteSt = con.prepareStatement(deleteString);
        }catch(SQLException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }
    /**
     * Constructor privado para que no se pueda instanciar la clase
     * De esta forma hacemos toda la clase "estática".
     */
    private  PostRepositorio()
    {
 
    }
  
    /**
     * Permite crear un nuevo post con el texto y el usuario. 
     * El usuario debe estar en el banco de objetos usando UsuarioRepositorio.getOneUserById() y pulsando el botón Obtener
     */
    public static void addPost(String texto, Usuario usuario){
        Post post = new Post();
        post.setTexto(texto);
        post.setUsuario(usuario);
        insertPost(post);
        post.display();
  
    }
    
    /**
     * Permite crear un nuevo post . 
     * El post debe estar en el banco de objetos.
     */
    public static void addPost(Post post){
        insertPost(post);    
    }
    
    /**
     * Los métodos que vienen a continuacion (insertPost, updatePost y deletePost) realizan el mapeo de un objeto en la base de datos. Es decir, a partir de las propiedades de
     * un objeto Post, realizan las operaciones INSERT, UPDATE y DELETE (CRUD: CREATE, read, UPDATE y DELETE);
     * 
     * Inserta el objeto en la base de datos (Crud);
     */
    private static void insertPost(Post post){
        ResultSet rs = null;
        try{
            /*
             * En este caso estamos usando preparedStatement, por lo que hemos de fijar todos los valores con insertSt.set...(índice de parámetro, valor)
             */
            //" INSERT INTO posts (texto, likes, id_usuario) VALUES(?,?,?)";
            insertSt.setString(1, post.getTexto()); //El primer parámetro es de tipo String (campo texto)
            insertSt.setInt(2, post.getLikes()); //El segundo parámetro es de tipo Int (campo likes)
            insertSt.setInt(3, post.getUsuario().getId()); //El tercer parámetro es de tipo Int (campo id_usuario)
            
            //No os olvidéis de ejecutar la sentencia!!
            insertSt.executeUpdate();
           
            //En este caso hemos de recoger el id autogenerado al realizar el insert (ver insertSt más arriba)
            rs = insertSt.getGeneratedKeys();
            //Este ResultSet solo puede contener un registro: el ID autogenerado
            if (rs.next()){
                //Ahora ya sabemos cual es el nuevo id del Post
                post.setId(rs.getInt(1));
                System.out.println("ID Autogenerado:  " + post.getId());
            }
            
        
        }catch(SQLException e){
            System.out.println("Se ha producido un error al insertar el usuario. Mensaje: " + e.getMessage());
        }finally{
            try{
                //Siempre se debe cerrar todo lo abierto
                if (rs != null)
                    rs.close();
               
            }catch(java.sql.SQLException ex){
                 System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }  
    }  
     /**
     * Permite actualizar en la base de datos el Post post. (crUd); 
     * Para poder probarlo en BlueJ, hay que llamar al metodo getOnePostById() y luego pulsar el botón  Obtener, para pasarlo al banco de objetos para pasarle este post
     */
    public static void updatePost(Post post){
        try{
           /*
            * En este caso  estamos usando preparedStatement, por lo que hemos de fijar todos los valores con updateSt.set...(índice de parámetro, valor)
           */

           //"UPDATE posts SET texto = ?, likes = ? WHERE id = ?";
            updateSt.setString(1, post.getTexto());//El primer parámetro es de tipo String (campo texto)
            updateSt.setInt(2, post.getLikes());//El segundo parámetro es de tipo Int (campo likes)
            updateSt.setInt(3, post.getId()); //El tercer parámetro es de tipo Int (campo id)
            // El campo id_usuario NO lo actualizamos ya que se supone que un Post no puede cambiar de usuario
            
            // El método executeUpdate devuelve el número de filas afectadas por la operacion SQL Data Manipulation Language (DML) 
            int filas = updateSt.executeUpdate();
            // Por tanto, si devuelve un valor distinto de 1 es que otro usuario (u otra sesión) ha borrado este post
            if (filas != 1){
                System.out.println("No existe el post con ID " + post.getId());
            }
       
        }catch(SQLException e){
            System.out.println("Se ha producido un error al actualizar el post. Mensaje: " + e.getMessage());
        }  
    }
    /**
     * Elimina de la base de datos el Post post.  (cruD);
     * Para probarlo en el banco de objetos, primero hay que llamar a getOnePostById y pulsar el botón Obtener, para luego 
     * pasarle este objeto a deletePost
     */
    public static void deletePost(Post post){
        try{
           /*
            * En este caso estamos usando preparedStatement, por lo que hemos de fijar todos los valores con deleteSt.set...(índice de parámetro, valor)
           */
            //"DELETE FROM posts WHERE id = ?";
            deleteSt.setInt(1, post.getId());   
            // El método executeUpdate devuelve el número de filas afectadas por la operacion SQL Data Manipulation Language (DML) 
            int filas = deleteSt.executeUpdate();
            // Por tanto, si devuelve un valor distinto de 1 es que otro usuario (u otra sesión) ha borrado este post
            if (filas != 1){
                System.out.println("No existe el post con ID " + post.getId());
            }
        
        }catch(SQLException e){
            System.out.println("Se ha producido un error al eliminar el post. Mensaje: " + e.getMessage());
        }  
    }
     /**
     * Devuelve el Post con dicho id.  (cRud)
     * Este método, realiza el mapeo de la base de datos en objetos. Es decir, convierte un registro de la tabla Posts en un objeto Post
     * Se puede utilizar para incluir dicho Post en el banco de objetos, mediante el botón Obtener
     */
    public static Post getOnePostById(int id){
        for (Post post : postsCached){ 
            if (post.getId() == id){
                return post;
            }
        }
        // Definir la consulta (Statement) y el conjunto de resultados (Resulset)
        java.sql.Statement stmt = null;
        java.sql.ResultSet cdr = null;

        try {
            /*
             * Como no vamos a hacer cambios en los registros de la BD, le pasamos como parametro CONCUR_READ_ONLY 
             * (si se quieren modificar, se se debe pasar CONCUR_UPDATABLE) 
             */
            stmt = con.createStatement(
             java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
             java.sql.ResultSet.CONCUR_READ_ONLY);
            
            //Crear la consulta y ejecutarla, guardando los datos devueltos en un Resulset
            cdr = stmt.executeQuery("SELECT * FROM posts WHERE id = " + id);
            
            //Si la consulta devuelve algún resultado ...
            Post p = null;
            if(cdr.next()){ 
            // ... lo mapeamos a un objeto Post
                p = mapeoBDToPost(cdr.getInt("id"), cdr.getString("texto"), cdr.getInt("likes"), cdr.getTimestamp("fecha"), cdr.getInt("id_usuario"));
                
            }
            
            //Devolver el Post ya mapeado
            return p;
        } catch (java.sql.SQLException ex) {
            System.out.println("Se ha producido un error al conectar: " + ex.getMessage() );
        }finally{
            try{
                //Siempre se debe cerrar todo lo abierto
                if (stmt != null)
                    stmt.close();
                if (cdr != null)
                    cdr.close();
            }catch(java.sql.SQLException ex){
                 System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }
        // Si llega aquí es porque se ha producido algún error
        return null;
    }   
     /**
     * Devuelve el ArrayList de todos los Posts (cRud)
     * Este método, realiza el mapeo de la base de datos en objetos. Es decir, convierte registros de la tabla Posts en objetos Post
     * 
     */
    public static ArrayList<Post> getAllPosts(){
        
        ArrayList<Post> posts = new  ArrayList<Post>();
        // Definir la consulta (Statement) y el conjunto de resultados (Resulset)
        java.sql.Statement stmt = null;
        java.sql.ResultSet cdr = null;

        try {
            /*
             * Como no vamos a hacer cambios en los registros de la BD, le pasamos como parametro CONCUR_READ_ONLY 
             * (si se quieren modificar, se se debe pasar CONCUR_UPDATABLE) 
             */
            stmt = con.createStatement(
             java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
             java.sql.ResultSet.CONCUR_READ_ONLY);
             
            //Ejecutar la consulta, guardando los datos devueltos en un Resulset
            cdr = stmt.executeQuery("SELECT * FROM posts");
            
            //Recorremos todos los resultados devueltos y procedemos como en getOnePostById
            while(cdr.next()){ 
                Post p = null;
                for (Post post : postsCached){ 
                    if (post.getId() == cdr.getInt("id")){
                        p =  post;
                    }
                }
                 //Si no esta en caché, mapearlo
                if (p == null){
                    //Mapeamos el registro de la BD en un Post
                    p = mapeoBDToPost(cdr.getInt("id"), cdr.getString("texto"), cdr.getInt("likes"), cdr.getTimestamp("fecha"), cdr.getInt("id_usuario"));
                }
                //Añadir el post al array de posts
                posts.add(p);
            }
            
        } catch (java.sql.SQLException ex) {
            System.out.println("Se ha producido un error al conectar: " + ex.getMessage() );
        }finally{
            try{
                //Siempre se debe cerrar todo lo abierto
                if (stmt != null)
                    stmt.close();
                if (cdr != null)
                    cdr.close();
            }catch(java.sql.SQLException ex){
                 System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }
        return posts;
    }   
    
    
     /**
     * Devuelve el ArrayList de todos los Posts de un usuario (cRud)
     * Este método, realiza el mapeo de la base de datos en objetos. Es decir, convierte registros de la tabla Posts en objetos Post
     * 
     */
    public static ArrayList<Post> getUserPosts(Usuario usuario){
        //Crear la variable para almacenar los posts del usuairo
        ArrayList<Post> posts = new ArrayList<Post>();
        
        // Definir la consulta (Statement) y el conjunto de resultados (Resulset)
        java.sql.Statement stmt = null;
        java.sql.ResultSet cdr = null;
        
          try {
            /*
             * Como no vamos a hacer cambios en los registros de la BD, le pasamos como parametro CONCUR_READ_ONLY 
             * (si se quieren modificar, se se debe pasar CONCUR_UPDATABLE) 
             */
            stmt = con.createStatement(
             java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
             java.sql.ResultSet.CONCUR_READ_ONLY);
             
            //Ejecutar la consulta, guardando los datos devueltos en un Resulset
            cdr = stmt.executeQuery("SELECT * FROM posts WHERE id_usuario = " + usuario.getId());
            
            while(cdr.next()){ 
                Post p = null;
                for (Post post : postsCached){ 
                    if (post.getId() == cdr.getInt("id")){
                        p =  post;
                    }
                }
                 //Si no esta en caché, mapearlo
                if (p == null){
                    //Mapeamos el registro de la BD en un Post
                    p = mapeoBDToPost(cdr.getInt("id"), cdr.getString("texto"), cdr.getInt("likes"), cdr.getTimestamp("fecha"), usuario);
                }
                //Añadir el post al array de posts
                posts.add(p);
            }
            
        } catch (java.sql.SQLException ex) {
            System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
        }finally{
            try{
                //Siempre se debe cerrar todo lo abierto
                if (stmt != null)
                    stmt.close();
                if (cdr != null)
                    cdr.close();
            }catch(java.sql.SQLException ex){
                 System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }
        return posts;
    }
    
    /**
     *  Este método privado, realiza la conversión de un registro de la tabla Posts en un objeto Poss.
     */
   
    private static Post mapeoBDToPost(int id, String texto, int likes, Timestamp fecha, Usuario usuario){
        // Creamos un nuevo objeto de tipo Post
        Post p = new Post();
        
      	// Lo añadimos a la cache de posts mapeados
        postsCached.add(p);
        
        // Y asignamos los valores con los setters de la clase
        p.setId(id);
      
      
      	p.setTexto(texto);
        p.setLikes(likes);
        p.setUsuario(usuario);
         
        //Convertir el timestamp de SQL a java.util.Date
        java.util.Date date;
        //Timestamp timestamp =  cdr.getTimestamp("fecha");
        date = new java.util.Date(fecha.getTime());
        p.setFecha(date);
       
        return p;
    }
    
    /**
     *  Este método privado, realiza la conversión de un registro de la tabla Posts en un objeto Poss.
     */
    private static Post mapeoBDToPost(int id, String texto, int likes, Timestamp fecha, int idUsuario){
        //Mapeamos el objeto usuario
        Usuario usuario = UsuarioRepositorio.getOneUserById(idUsuario);
        
        // Creamos un nuevo objeto de tipo Post
        Post p = mapeoBDToPost(id, texto, likes, fecha, usuario);
        
        return p;
        
        // En una línea
        // return mapeoBDToPost(id, texto, likes, fecha, new UsuarioRepositorio().getOneUserById(idUsuario));
    }
   
    
    /**
     * Imprime los Posts que se encuentran el ArrayList posts.
     */
    public static void printPosts(){ 
        ArrayList<Post> posts = getAllPosts();
        for(Post p : posts){
            p.display();   
        }
    }

}
```



Esta clase es parecida a `UsuarioRepositorio`, pero hay que fijarse en la función `mapeoBDToPost()`

```java
 private static Post mapeoBDToPost(int id, String texto, int likes, Timestamp fecha, int idUsuario){
        //Mapeamos el objeto usuario
        Usuario usuario = UsuarioRepositorio.getOneUserById(idUsuario);
        
        // Creamos un nuevo objeto de tipo Post
        Post p = mapeoBDToPost(id, texto, likes, fecha, usuario);
        
        return p;
        
        // En una línea
        // return mapeoBDToPost(id, texto, likes, fecha, new UsuarioRepositorio().getOneUserById(idUsuario));
    }
```

Como tenemos implementado el método `getOneUserById()` en la clase `UsuarioRepositorio` que nos devuelve un objeto de tipo Usuario a partir de su **id**, usamos este método para realizar el mapeo objeto-relacional.

Además de hacer los métodos `getOnePostById()` y `getAllPosts()`, también se ha implementado un método `getUserPosts()` que nos devuelve todos los post de un `Usuario` pasado como parámetro. El código es como `getAllPosts()` pero cambiando la sentencia **SELECT** por

```java
 cdr = stmt.executeQuery("SELECT * FROM posts WHERE id_usuario = " + usuario.getId());
```

Este método se usará más adelante para completar la clase `Usuario` y añadirle colección de `Posts` así como la clase `UsuarioRepositorio` para mapear los `Posts` del `Usuario`.

![1522924577192](programacion-java/assets/img/poo-tablas/1522924577192.png)

#### Completar la clase Usuario y UsuarioRepositorio

Ahora ya podemos modificar estas dos clases para mostrar la parte *n* de la relación `Usuario-Post` ya que un `Usuario` pueder tener más de un `Post`.
Esto lo conseguimos modificando la clase `Usuario` para añadirle una nueva propiedad de tipo colección.

```java
import java.util.ArrayList;
public class Usuario
{
    private int id;
    private String nombre;
    private String apellidos;
    private ArrayList<Post> posts;
    
    /**
     * Constructor for objects of class Usuario
     */
    public Usuario()
    {
        this.nombre = "";
        this.apellidos = "";
        this.posts = new ArrayList<Post>();
        this.id = -1;
    }
   	/*Setters y getters */
	// .....

    public ArrayList<Post> getPosts(){
       return posts; 
    }
    
    public void setPosts(ArrayList<Post> posts){
       this.posts = posts; 
    }
    
    public void display(){
        System.out.println("ID: " + id + " NOMBRE: " + nombre + " APELLIDOS: " + apellidos);
        System.out.println("POSTS");
        displayPosts();
    }
    public void displayPosts(){
        for(Post p : posts){
            p.display();   
        }
    
    }
    
}
```

Y modificando la clase `UsuarioRepositorio` para que llame al método `setPosts()` del `Usuario`.

```java
/**
     * Este método privado, realiza la conversión de un registro de la tabla Usuarios en un objeto Usuario.
     */
    private static Usuario mapeoBDToUsuario(int id, String nombre, String apellidos){
       // Creamos un nuevo objeto de tipo Usuario
       Usuario u = new Usuario();
       // Lo añadimos a la caché de usuarios mapeados
       usuariosCached.add(u);
       u.setId(id);
       u.setNombre(nombre);
       u.setApellidos(apellidos);
       //Ahora ya podemos obtener todos los Posts del usuario
       u.setPosts(PostRepositorio.getUserPosts(u));
       
       return u;
    }
    
```



## Clase Comentario

Ahora que ya tenemos implementadas las clases `Usuario` y `Post`, ya podemos implementar la clase `Comentario`, que tiene una clave ajena a `Post` y otra a `Usuario`.

Empezamos por crear la clase `Comentario`:

[Código Fuente](./programacion-java/assets/img/poo-tablas/javas/Comentario.java.txt) 

```java

/**
 * @author (Víctor Ponz) 
 * @version (13/03/2018)
 */
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
public class Comentario
{
    private Date fecha;
    private int id;
    private String texto;
    private Usuario usuario;
    private Post post;
    /**
     * Constructor for objects of class Comentario
     */
    public Comentario()
    {
     
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setTexto(String texto){
        this.texto = texto;
    }
    public String getTexto(){
        return this.texto;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public Usuario getUsuario(){
        return this.usuario;
    }
    public void setPost(Post post){
        this.post = post;
    }
    public Post getPost(){
       return this.post;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public Date getFecha(){
        return this.fecha;
    }
}

```



Como en `Usuario` y `Post`, esta es la clase típica de POO, donde hemos transformado la clave ajena en dos propiedades de tipo objeto: `Usuario` y `Post`.

![1523286748570](programacion-java/assets/img/poo-tablas/1523286748570.png)



## Clase ComentarioRepositorio

Procedemos de la misma manera que en `UsuarioRepositorio` y `PostRepositorio`:

[Código Fuente](./programacion-java/assets/img/poo-tablas/javas/ComentarioRepositorio.java.txt) 

```java

/**
 * @author (Víctor Ponz) 
 * @version (13/03/2018)
 */
import java.util.ArrayList;
import java.sql.*;
public class ComentarioRepositorio
{
     //Conectarnos a la base de datos mediante en patrón Singleton.
    static java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
     //Importante. Variable estática para almacenar los Post que ya hemos mapeado de la base de datos
    private static ArrayList<Comentario> comentariosCached =  new ArrayList<Comentario>();
    
    static PreparedStatement insertSt = null;
    //Creamos las cadenas que nos van a servir de plantilla para las sentencias SQL. Cada ? implica un parámetro
    final static String insertString = "INSERT INTO comentarios (texto, id_usuario, id_post) VALUES(?,?,?)";
 
    //Este bloque de declaración estático permite incluir instrucciones que solo se ejecutarán una vez (recordemos que no tiene constructor!)
    static {
        try {
            /*
             * Crear los preparedStatement para su uso posterior 
             * En el caso de INSERT, hemos de pasarle también el parámetro Statement.RETURN_GENERATED_KEYS para poder recoger el ID auto generado (igual que en UsuarioRepositorio).
             * Ver insertPost
             */ 
            insertSt = con.prepareStatement(insertString, Statement.RETURN_GENERATED_KEYS);
            
        }catch(SQLException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }

   /**
     * Constructor privado para que no se pueda instanciar la clase
     * De esta forma hacemos toda la clase "estática".
     */
    private ComentarioRepositorio()
    {
    
    }
    
    /**
     * Inserta el objeto en la base de datos
     */
    public static void addComentario(Comentario comentario){
        ResultSet rs = null;
        try{
            /*
             * En este caso estamos usando preparedStatement, por lo que hemos de fijar todos los valores con insertSt.set...(índice de parámetro, valor)
             */
            // "INSERT INTO comentarios (texto, id_usuario, id_post) VALUES(?,,?,?)";
            insertSt.setString(1, comentario.getTexto()); //El primer parámetro es de tipo String (campo texto)
            insertSt.setInt(2, comentario.getUsuario().getId()); //El segundo parámetro es de tipo Int (campo id_usuario)
            insertSt.setInt(3, comentario.getPost().getId()); //El tercer parámetro es de tipo Int (campo id_post)
            //No os olvidéis de ejecutar la sentencia!!
            insertSt.executeUpdate();
           
            //En este caso hemos de recoger el id autogenerado al realizar el insert (ver insertSt más arriba)
            rs = insertSt.getGeneratedKeys();
            //Este ResultSet solo puede contener un registro: el ID autogenerado
            if (rs.next()){
                //Ahora ya sabemos cual es el nuevo id del Post
                comentario.setId(rs.getInt(1));
                System.out.println("ID Autogenerado:  " + comentario.getId());
            }
        
        }catch(SQLException e){
            System.out.println("Se ha producido un error al insertar el comentario. Mensaje: " + e.getMessage());
        }finally{
            try{
                //Siempre se debe cerrar todo lo abierto
                
                if (rs != null)
                    rs.close();
            }catch(java.sql.SQLException ex){
                 System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }
    }  
    
    /**
     * Devuelve todos los comentarios de un post
     */
    public static ArrayList<Comentario> getComments(Post post){
        //Crear la variable para almacenar los posts del usuairo
        ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
        
        // Definir la consulta (Statement) y el conjunto de resultados (Resulset)
        java.sql.Statement stmt = null;
        java.sql.ResultSet cdr = null;
        
          try {
            //Crear la consulta
            stmt = con.createStatement(
             java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
             java.sql.ResultSet.CONCUR_UPDATABLE);
             
            //Ejecutarla, guardando los datos devueltos en un Resulset
            cdr = stmt.executeQuery("SELECT * FROM comentarios WHERE id_post = " + post.getId());
            
            while(cdr.next()){ 
                Comentario c = null;
                for (Comentario comentario : comentariosCached){ 
                    if (comentario.getId() == cdr.getInt("id")){
                        c = comentario;
                    }
                }
                 //Si no esta en caché, mapearlo
                if (c == null){
                    //Mapeo
                    c = mapeoBDToComentario(cdr.getInt("id"), cdr.getString("texto"),  cdr.getTimestamp("fecha"), cdr.getInt("id_usuario"), post);
                }
                comentarios.add(c);
            
            }
           
        } catch (java.sql.SQLException ex) {
            System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
        }finally{
            try{
                //Siempre se debe cerrar todo lo abierto
                if (stmt != null)
                    stmt.close();
                if (cdr != null)
                    cdr.close();
            }catch(java.sql.SQLException ex){
                 System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }
        return comentarios;
    }
    
  /**
     * Devuelve todos los comentarios de un post
     */
    public static Comentario getOneCommentById(int id){
        for (Comentario comentario : comentariosCached){ 
            if (comentario.getId() == id){
                return comentario;
            }
        }
       
        
        // Definir la consulta (Statement) y el conjunto de resultados (Resulset)
        java.sql.Statement stmt = null;
        java.sql.ResultSet cdr = null;
        
          try {
            //Crear la consulta
            stmt = con.createStatement(
             java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
             java.sql.ResultSet.CONCUR_UPDATABLE);
             
            //Ejecutarla, guardando los datos devueltos en un Resulset
            cdr = stmt.executeQuery("SELECT * FROM comentarios WHERE id = " + id);
            Comentario c = null;
            if(cdr.next()){ 
               //Mapeo
                c = mapeoBDToComentario(cdr.getInt("id"), cdr.getString("texto"),  cdr.getTimestamp("fecha"), cdr.getInt("id_usuario"), cdr.getInt("id_post"));
                    
            }
         
            return c;
        } catch (java.sql.SQLException ex) {
            System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
        }finally{
            try{
                //Siempre se debe cerrar todo lo abierto
                if (stmt != null)
                    stmt.close();
                if (cdr != null)
                    cdr.close();
            }catch(java.sql.SQLException ex){
                 System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }
        return null;
    }
    /*
     * Mapea los datos devueltos desde SQL a un objeto Post.
     */
    private static Comentario mapeoBDToComentario(int id, String texto, Timestamp fecha, int idUsuario, Post post){
        // Creamos un nuevo objeto de tipo Post
        Comentario c = new Comentario();
        
        // Lo añadimos a la caché de comentarios mapeados
        comentariosCached.add(c);
      
        // Y asignamos los valores con los setters de la clase
        c.setId(id);
        c.setTexto(texto);
        c.setUsuario(UsuarioRepositorio.getOneUserById(idUsuario));
        c.setPost(post);
        //Convertir el timestamp de SQL a java.util.Date
        java.util.Date date;
        //Timestamp timestamp =  cdr.getTimestamp("fecha");
        date = new java.util.Date(fecha.getTime());
        c.setFecha(date);
       
        return c;
    }
    
     private static Comentario mapeoBDToComentario(int id, String texto, Timestamp fecha, int idUsuario, int idPost){
        //Mapeamos el objeto post
        Post post = PostRepositorio.getOnePostById(idPost);
        return mapeoBDToComentario(id, texto, fecha, idUsuario, post);
    
    }
}

```

![1523288291375](programacion-java/assets/img/poo-tablas/1523288291375.png)

Y por último ya sólo falta modificar la clase `PostRepositorio` para mapear los comentarios de un `Post`, llamando al método `ComentarioRepositorio.getComments(Post post)` así como la clase `Post` para tener una colección de `Comentarios`.

```java
public class Post
{
    private Date fecha;
    private int id;
    private String texto;
    private int likes;
    private Usuario usuario;
    private ArrayList<Comentario> comentarios;
  	//.....
   public ArrayList<Comentario> getComentarios(){
       return comentarios; 
    }
    
    public void setComentarios(ArrayList<Comentario> comentarios){
       this.comentarios = comentarios; 
    }
}
```

```java
public class PostRepositorio
{
 //......
    private static Post mapeoBDToPost(int id, String texto, int likes, Timestamp fecha, Usuario usuario){
        // Creamos un nuevo objeto de tipo Post
        Post p = new Post();
        // Lo añadimos a la cache de posts mapeados
        postsCached.add(c);
        // Y asignamos los valores con los setters de la clase
        p.setId(id);
        p.setTexto(texto);
        p.setLikes(likes);
        p.setUsuario(usuario);
        //Ahora ya podemos fijar los comentarios del Post
        p.setComentarios(ComentarioRepositorio.getComments(p));
         
        //Convertir el timestamp de SQL a java.util.Date
        java.util.Date date;
        //Timestamp timestamp =  cdr.getTimestamp("fecha");
        date = new java.util.Date(fecha.getTime());
        p.setFecha(date);
       
        return p;
    }
}
```



El diagrama de clases final es el siguiente:

![1523288859002](programacion-java/assets/img/poo-tablas/1523288859002.png)

## Clase java.sql.Statement

Para escribir sentencias SQL, JDBC dispone de los objetos `Statement`. Se trata de objetos que se han de crear a partir de `Connection`, los cuales pueden enviar sentencias SQL al SGBD conectado para que se ejecutan con el método `executeQuery` o `executeUpdate`.

Hay una variante del `Statement`, llamada `PreparedStatement` que nos da más versatilidad para poner parámetros y ejecutar la sentencia de otro modo. Lo veremos más adelante en PostRepositorio.

La diferencia entre los dos métodos que ejecutan sentencias SQL es:
* El método `executeQuery` sirve para ejecutar sentencias de las que se espera que vuelven datos, es decir, son consultas **SELECT**.
* En cambio, el método `executeUpdate` sirve específicamente para sentencias que no devuelven datos. Servirán para modificar la Base de Datos conectada (**INSERT**, **DELETE**, **UPDATE**, incluso **CREATE** TABLE).



## Sentencias que no devuelven datos

Las ejecutamos con el método `executeUpdate`. Serán todas las sentencias SQL **excepto el SELECT**, que es la de consulta. Es decir, nos servirá para las siguientes sentencias:

* Sentencias que cambian las estructuras internas de la BD donde se guardan los datos (instrucciones conocidas con las siglas **DDL**, del inglés **Data Definition Language**), como por ejemplo CREATE TABLE, CREATE VIEW, ALTER TABLE, DROP TABLE, ...,
* Sentencias para otorgar permisos a los usuarios existentes o crear otros nuevos (subgrupo de instrucciones conocidas como **DCL** o **Data Control Language**), como por ejemplo GRANT.
* Y también las sentencias para modificar los datos guardados utilizando las instrucciones **INSERT**, **UPDATE** y **DELETE**.

Aunque se trata de sentencias muy dispares, desde el punto de vista de la comunicación con el SGBD se comportan de manera muy similar, siguiendo el siguiente patrón:
1. Instanciación del `Statement` a partir de una conexión activa.
2. Ejecución de una sentencia SQL pasada por parámetro al método `executeUpdate`.
3. Cierre del objeto `Statement` instanciado.


## Sentencias que devuelven datos

Las ejecutamos con el método `executeQuery`. Servirá para la sentencia **SELECT**, que es la de consulta. Los datos que nos devuelva esta sentencia las tendremos que guardar en un objeto de la clase `ResultSet`, es decir conjunto de resultado. Por lo tanto, la ejecución de las consultas tendrá un forma similar a la siguiente:

```java
java.sql.Statement stmt;
java.sql.ResultSet cdr;

stmt = con.createStatement(
  java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
  java.sql.ResultSet.CONCUR_READ_ONLY);

cdr = stmt.executeQuery("SELECT * FROM usuarios ORDER BY nombre);
                        
while(cdr.next()){ 
	//Imprimir el registro
    System.out.println("ID: " + cdr.getInt("id") + " Nombre: " +  cdr.getString("nombre") + " Apellidos: " + cdr.getString("apellidos"));  
}

//Siempre se debe cerrar todo lo abierto
stmt.close();
cdr.close();
```



El objeto `ResultSet` contiene el resultado de la consulta organizado por filas, por lo que en cada momento se puede consultar una fila. Para ir visitando todas las filas de una a una, iremos llamando el método `next()` del objeto `ResultSet`, ya que cada vez que se ejecute `next()` avanzará a la siguiente fila. Inmediatamente después de una ejecución, el `ResultSet` se encuentra posicionado justo antes de la primera fila, por lo tanto para acceder a la primera fila será necesario ejecutar `next()` una vez. Cuando las filas se acaban, el método `next()` devolverá **falso**.

Desde cada fila se podrá acceder al valor de sus columnas con ayuda de varios métodos `get` disponibles según el tipo de datos a devolver y pasando por parámetro el número de columna que deseamos obtener. El nombre de los métodos comienza por **get seguido del nombre del tipo de datos**. Así, si queremos recuperar la segunda columna, sabiendo que es un dato de tipo **String** habrá que ejecutar:

```java
cdr.getString(2);
```

### No reutilización de Statement ni ResultSet

Es un error bastante habitual por inesperado el hecho de intentar reutilizar un mismo `ResultSet` para recoger más de una consulta. . Y lo mismo con el Statement. Bien sea por una mala implementación o un bug o lo que sea, el comportamiento puede ser imprevisible. Y por lo tanto no vale la pena arriesgarse.

Os aconsejo que si en una aplicación tiene más de una consulta de las que devuelven datos, utilices un `Statement` y un `ResultSet` diferentes para cada una.

No hay problema en utilizar el mismo `Statement` para muchas consultas de las que no devuelven datos.

### Asegurar la liberación de recursos

Las instancias de `Connection` y las de `Statement` guardan, en memoria, mucha información relacionada con las ejecuciones realizadas. Además, mientras continúan activas mantienen en el **SGBD** una sesión abierta, que supondrá un conjunto importante de recursos abiertos, destinados a servir de forma eficiente las peticiones de los clientes. Es importante cerrar estos objetos para liberar recursos tanto del cliente como del servidor.

Si en un mismo método debemos cerrar un objeto `Statement` y el `Connection` a partir del cual la hemos creado, se deberá cerrar primero el `Statement` y después el `Connection`. Si lo hacemos al revés, cuando intentamos cerrar el `Statement` nos saltará una excepción de tipo `SQLException`, ya que el cierre de la conexión le habría dejado inaccesible.

Además de respetar el orden, asegurar la liberación de los recursos situando las operaciones de cierre dentro de un bloque `finally`. De este modo, aunque se produzcan errores, no se dejarán de ejecutar las instrucciones de cierre.

Hay que tener en cuenta todavía un detalle más cuando sea necesario realizar el cierre de varios objetos a la vez. En este caso, aunque las situamos una tras otra, todas las instrucciones de cierre dentro del bloque finally, no sería suficiente garantía para asegurar la ejecución de todos los cierres, ya que, si mientras se produce el cierre de un los objetos se lanza una excepción, los objetos invocados en una posición posterior a la del que se ha producido el error no se cerrarán.

La solución de este problema pasa por evitar el lanzamiento de cualquier excepción durante el proceso de cierre. Una posible forma es encapsular cada cierre entre sentencias `try-catch` dentro del `finally`.

```java
 java.sql.Statement stmt = null;
        java.sql.ResultSet cdr = null;
        try {
             
            stmt = con.createStatement(
             java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
             java.sql.ResultSet.CONCUR_READ_ONLY);
            
            cdr = stmt.executeQuery("SELECT * FROM usuarios WHERE id = " + id);
            
          	// ....
            
        } catch (java.sql.SQLException ex) {
            System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
        }finally{
            try{
                //Siempre se debe cerrar todo lo abierto
                if (stmt != null)
                    stmt.close();
                if (cdr != null)
                    cdr.close();
            }catch(java.sql.SQLException ex){
                 System.out.println("Se ha producido un error al conectar: " + ex.getMessage());
            }
        }
```



## Clase java.sql.PreparedStatement

Cuando trabajamos con una base de datos es posible que haya sentencias SQL que tengamos que ejecutar varias veces durante la sesión, aunque sea con distintos parámetros. 
Por ejemplo, durante una sesión con base de datos podemos querer insertar varios registros en una tabla. Cada vez los datos que insertamos serán distintos, pero la sentencia SQL será la misma: Un INSERT sobre determinada tabla que será siempre igual, salvo los valores concretos que queramos insertar.
En este caso, todas las acciones que realizan modificaciones, vamos a realizarlas con `PreparedStatement`, ya que la sintaxis es más sencilla, más eficiente y nos protege de errores en la introducción de datos. Con `PreparedStatement`, los datos variables se identifican con un ? y después se mapean con los datos reales. Ver insertPost, updatePost y deletePost.
Es importante guardar los `PreparedStatement` en una campo disponible para toda la clase (en este caso lo hemos hecho con una propiedad estática). Si cada vez que usamos un `PreparedStatement` lo tenemos que generar, tampoco se consigue mejorar la eficiencia.
Precisamente por esta forma de meter los datos, conseguimos una pequeña ventaja en el tema de seguridad. Imagínate que el nombre viene de un campo de texto que el usuario rellena. Si el usuario pone, por ejemplo, un nombre como *"O'Donnell"*, con una comilla simple entre medias, nos estropearía una `Statement` normal que montásemos a base de concatenar cadenas:

```java
String sql = "INSERT INTO person VALUES (edad + ",'" + nombre + "','" + apellido + "')";
```


Hemos ido sumando cadenas y hemos metido la variable nombre entre comillas simples, pero como nombre a su vez tiene comillas simples, el resultado de todo esto sería un String así 

```SQL
INSERT INTO person VALUES (23, 'O'Donnell', 'Perez')
```

que dará un error al usarlo, porque la comilla de *O'Donnell* se interpreta con fin de la cadena nombre y detrás debería ir, en una SQL correctamente formada, una coma para separar el campo apellido, y no una D mayúscula. Es más, un usuario con conocimientos y mal intencionado, podría incluso conseguir que se ejecutase un trozo de SQL malicioso. Si usamos `Statement` normal y componemos nosotros las SQL, es nuestra responsabilidad revisar las cadenas que nos llegan desde el usuario y "escapar" anteponiendo un \ en todos aquellos caracteres susceptibles de estropearnos la sentencia SQL. 

Esto no pasa, sin embargo, con los `PreparedStatement`. Al crear el `PreparedStatement`, ya indicamos cómo es la consulta SQL y qué campos tiene. Al meter dichos campos con métodos específicos, `setInt()`, `setString()`, etc, el `PreparedStatement`  ya sabe cuales son exactamente los valores de los campos y cual exactamente la SQL, por lo que el nombre *"O'Donnell"* nos nos causaría ningún problema en la inserción.
