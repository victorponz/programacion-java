import java.util.Scanner;

public class AlReves {
    public static void main(String[] args) {
        int num;
        int dm, um, c, d, u;
        Scanner teclado = new Scanner(System.in);
        // 9 9 . 9 9 9 a nombramos cada dígito así:
        // dm um c d u: dm (decenas de millar), um:(unidades de millar)
        // c: (centenas), d: (decenas), u: (unidades)
        System.out.print("Introduzca un número entre 0 y 99.999: ");
        num = teclado.nextInt();
        teclado.close();
        
        // unidad
        u = num % 10;
        num = num / 10;
        // decenas
        d = num % 10;
        num = num / 10;
        // centenas
        c = num % 10;
        num = num / 10;
        // unidades de millar
        um = num % 10;
        num = num / 10;
        // decenas de millar
        dm = num;

        // mostramos:
        System.out.println(u + " " + d + " " + c + " " + um + " " + dm);
        // otra forma de hacerlo es utilizando el polinomio:
        num = 10000 * u + 1000 * d + 100 * c + 10 * um + dm;
        System.out.println(num);
    }
}