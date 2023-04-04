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
import java.sql.*;

public class UsuarioService
{

    //Almacenar la conexión a la base de datos
    static java.sql.Connection con = DatabaseConnection.getInstance().getConnection();

    private UsuarioService () { // Constructor privado para que no se pueda instanciar!!

    }


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
    public static Usuario mapeoBDToUsuario(int id, String nombre, String apellidos){
        return new Usuario(id, nombre, apellidos);
    }
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

    public static void deleteUser(Usuario usuario) throws SQLException{
        if (usuario == null) return;
        PreparedStatement st = null;

        //Crer la consulta en sí
        st = con.prepareStatement("DELETE FROM usuarios WHERE id = ?");
        st.setInt(1, usuario.getId());
        int filas = st.executeUpdate();
        if (filas != 1){
            System.out.println("No existe el usuario con ID " + usuario.getId());
        }
    }
}