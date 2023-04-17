import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserController {

    /**
     * Imprime por pantalla todos los usuarios
     * @throws SQLException
     */
    public static void prinAllUsers() throws SQLException {
        System.out.println(AnsiColor.RED.getCode());
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        List<User> users = userRepository.findAll();
        for (User user : users){
            System.out.println(user);
        }
        System.out.println(AnsiColor.RESET.getCode());
    }

    public static void findByName() throws SQLException {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        Scanner sc = new Scanner(System.in);
        System.out.print(AnsiColor.BLUE.getCode());
        System.out.print("Name: ");
        String name = sc.nextLine();
        List<User> users = userRepository.findByName(name);
        System.out.print(AnsiColor.RESET.getCode());
        for (User user : users){
            System.out.println(user);
        }
    }

    /**
     * Muestra una interfaz  de usuario para añadir un usuario
     * @throws SQLException
     */
    public static void addUser() throws SQLException{
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        Scanner sc = new Scanner(System.in);
        System.out.print(AnsiColor.BLUE.getCode());
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Lastname: ");
        String lastName = sc.nextLine();
        System.out.print(AnsiColor.RESET.getCode());
        User user = new User(name, lastName);
        userRepository.save(user);
    }

    /**
     * Muestra la UI para modificar un usuario
     * @throws SQLException
     */
    public static void modifyUser() throws SQLException{
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        prinAllUsers();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User id to modify: ");
        int userId = sc.nextInt();
        sc.nextLine();
        System.out.print("New name: ");
        String name = sc.nextLine();
        System.out.print("New lastname: ");
        String lastName = sc.nextLine();
        userRepository.save(new User(userId, name, lastName));
    }

    /**
     * Muestra la UI para borrar un usuario.
     * @throws SQLException
     */
    public static void deleteUser() throws SQLException{
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        prinAllUsers();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user id to delete: ");
        User user = userRepository.findById(sc.nextInt());
        userRepository.delete(user);
    }
}