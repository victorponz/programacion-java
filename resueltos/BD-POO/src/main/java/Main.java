import java.sql.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws SQLException{

        final String ANSI_BLACK = "\u001B[38;2;255;0;0m";
        final String ANSI_BLUE = "\u001B[34m";
        System.out.println(ANSI_BLACK + "This text is red!");
        HashSet<Usuario> usuarios = UsuarioRepository.getAllUsers();
        for(Usuario usuario: usuarios){
           // System.out.println(usuario);
        }
    }

}

