import java.util.Scanner;

public class Ejemplo9 {
    public static void main(String[] args)
    {
        int[] numeros = new int[10];
        int pares = 0;
        Scanner miScanner = new Scanner(System.in);

        System.out.println("Introduce " + numeros.length + " números");
        for (int i = 0; i < numeros.length; i++){
            numeros[i] = miScanner.nextInt();			
        }
        miScanner.close();

        for (int numero: numeros){
            if (numero % 2 == 0 )
                pares++;
        }
        System.out.printf("Hay %d números pares y %d números impares %n", pares, numeros.length - pares);
		
    }
}
