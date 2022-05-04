import java.util.Scanner;
//Un programa que calcula y muestra el área de un cuadrado cuyo lado se introduce por pantalla
public class Ejemplo4 {
    public static void main (String argv[]) {
        float lado;
        float areaCuadrado;

        System.out.println("Introduce el lado:");

        //Leer un carácter como Float desde el teclado
        Scanner miScanner;
        miScanner = new Scanner(System.in);
        lado = miScanner.nextFloat();

        areaCuadrado = lado * lado;
        
        System.out.println("El área del cuadrado es: " + areaCuadrado);
        
        // O también
        System.out.printf("El área del cuadrado es: %f %n", areaCuadrado);
        
        miScanner.close();
    }
}