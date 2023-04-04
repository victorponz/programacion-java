import java.sql.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws SQLException{
        HashSet<Usuario> usuarios = UsuarioRepository.getAllUsers();
        for(Usuario usuario: usuarios){
            System.out.println(usuario);
        }
    }
}

