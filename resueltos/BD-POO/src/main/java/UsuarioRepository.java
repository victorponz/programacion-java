import java.sql.*;
import java.util.HashSet;

public class UsuarioRepository {
    static java.sql.Connection con = DatabaseConnection.getInstance().getConnection();

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
}
