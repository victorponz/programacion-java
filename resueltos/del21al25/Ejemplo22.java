import java.util.Scanner;
/*
 * Escribe un programa que pida al usuario 10 números y que muestre cuántos son positivos
 */
public class Ejemplo22 {
    public static void main(String[] args)
    {	
		int numero;
		/*
		 * La variable "positivos" es un "contador" que se inicializa a 0
		 */
		int positivos = 0;
		Scanner miScanner = new Scanner(System.in);
		
		System.out.println("Introduce 10 números enteros");
		
		for (int i = 0; i < 10; i++) {
			numero = miScanner.nextInt();
			
			if (numero >= 0){
				//Cuando encuentro un positivo, se aumenta la variable de tipo "contador"
				positivos++;
			}
		
		}
		miScanner.close();
		
		System.out.println("Ha introducido " + positivos + " números positivos");
		System.out.println("Ha introducido " + (10 - positivos) + " números negativos");
		
		
    }
}
