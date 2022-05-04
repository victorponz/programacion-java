package del1al5;
import java.util.Scanner;
//Un programa que lea dos números enteros y muestre el resultado de sumarlos,
// restarlos, multiplicarlos y dividirlos
public class Ejemplo5 {
    public static void main (String argv[]) {
        int n;
        int m;

        //Leer un carácter como Float desde el teclado
        Scanner inputValue;
        inputValue=new Scanner(System.in);
        
        System.out.println("Introduce el primer número:");
        n = inputValue.nextInt();
        
        System.out.println("Introduce el segundo número:");
        m = inputValue.nextInt();
        
        System.out.printf("El resultado de sumar %d y %d es: %d %n", n, m, (n+m));
        //Equivale a 
        //System.out.println("El resultado de sumar " + n + " y " + m + " es: " +  (n+m));
        
        System.out.printf("El resultado de restar %d y %d es: %d %n", n, m, (n-m));
       
        System.out.printf("El resultado de multiplicar %d y %d es: %d %n", n, m, (n*m));
        
        System.out.printf("El resultado de dividir %d y %d es: %d %n", n, m, (n/m));
        
        inputValue.close();
    }
}