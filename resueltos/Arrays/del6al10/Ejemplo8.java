import java.util.Scanner;

public class Ejemplo8 {
    public static void main(String[] args)
    {
        int[] numeros = new int[10];
        int sumaPositivos = 0;
        int sumaNegativos = 0;
		Scanner miScanner = new Scanner(System.in);
		
		System.out.println("Introduce " + numeros.length + " números");
		for (int i = 0; i < numeros.length; i++){
			numeros[i] = miScanner.nextInt();			
		}
		miScanner.close();

        for (int numero: numeros){
            if (numero > 0 )
                sumaPositivos += numero;
            else
                sumaNegativos += numero;
        }
        System.out.printf("Los positivos suman %d y los negativos %d %n", sumaPositivos, sumaNegativos);
		
    }
}
