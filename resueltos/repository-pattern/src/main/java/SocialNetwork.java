import java.sql.SQLException;
import java.util.Scanner;

public class SocialNetwork {

    public static void main(String[] args) throws SQLException {
        int opcion;
        printBanner();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        try {
            while(!salir) {
                printMenu();
                opcion = selectedOption();
                switch (opcion) {
                    case 0:
                        salir = true;
                        break ;
                    case 1: UserController.prinAllUsers();
                        break;
                    case 2: UserController.addUser();
                        break;
                    case 3: UserController.modifyUser();
                        break;
                    case 4: UserController.deleteUser();
                        break;
                    case 5: UserController.findByName();
                }
                if (opcion != 0){
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                }

                clearTerminal();
            }

        }catch (Exception sqle){
            System.out.println(sqle.getMessage());
        }
    }

    private static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void printBanner(){
        System.out.println(AnsiColor.BLUE.getCode());
        System.out.println("   _____            _       _   _   _      _                      _    ");
        System.out.println("  / ____|          (_)     | | | \\ | |    | |                    | |   ");
        System.out.println(" | (___   ___   ___ _  __ _| | |  \\| | ___| |___      _____  _ __| | __");
        System.out.println("  \\___ \\ / _ \\ / __| |/ _` | | | . ` |/ _ \\ __\\ \\ /\\ / / _ \\| '__| |/ /");
        System.out.println("  ____) | (_) | (__| | (_| | | | |\\  |  __/ |_ \\ V  V / (_) | |  |   < ");
        System.out.println(" |_____/ \\___/ \\___|_|\\__,_|_| |_| \\_|\\___|\\__| \\_/\\_/ \\___/|_|  |_|\\_\\");
        System.out.println(AnsiColor.RESET.getCode());
    }
    public static int selectedOption(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while (true) {
            opcion = sc.nextInt();
            if (opcion <= 5) {
                break;
            }else{
                System.out.println("Incorrect option");
            }
        }
        return opcion;
    }
    public static void printMenu(){
        System.out.println(AnsiColor.BLUE.getCode());
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("0 Exit | " + "1 Print | " + "2 Add | " + "3 Update | " + "4 Delete | " + "5 Search");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(AnsiColor.RESET.getCode());
    }

}
