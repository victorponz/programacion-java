import sun.misc.Signal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class UserController {

    public static void prinAllUsers() throws SQLException {
        UserRepositoryImpl usuarioRepository = new UserRepositoryImpl();
        List<User> users = usuarioRepository.findAll();
        for (User user : users){
            System.out.println(user);
        }

    }

    public static void addUser() throws SQLException{
        UserRepositoryImpl usuarioRepository = new UserRepositoryImpl();
        Scanner sc = new Scanner(System.in);
        System.out.print(AnsiColor.BLUE.getCode());
        System.out.print("Name: ");
        String nombre = sc.nextLine();
        System.out.print("Lastname: ");
        String apellidos = sc.nextLine();
        System.out.print(AnsiColor.RESET.getCode());
        User user = new User(nombre, apellidos);
        usuarioRepository.save(user);

    }

    public static void modifyUser() throws SQLException{
        UserRepositoryImpl usuarioRepository = new UserRepositoryImpl();
        prinAllUsers();
        Scanner sc = new Scanner(System.in);
        System.out.print("User id: ");
        int idUsuario = sc.nextInt();
        sc.nextLine();
        System.out.print("New name: ");
        String nombre = sc.nextLine();
        System.out.print("New lastname: ");
        String apellidos = sc.nextLine();
        usuarioRepository.save(new User(idUsuario, nombre, apellidos));
    }

    public static void deleteUser() throws SQLException{
        UserRepositoryImpl usuarioRepository = new UserRepositoryImpl();
        prinAllUsers();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el ID del usuario");
        int idUsuario = sc.nextInt();
        usuarioRepository.deleteById(idUsuario);
    }
}
