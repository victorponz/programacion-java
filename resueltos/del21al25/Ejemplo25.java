import java.util.Scanner;
/*
 * Diseña un programa que calcule el factorial de un número
 */
public class Ejemplo25 {

	
    public static void main(String[] args)
    {	
		int numero;
		// factorial es un acumulador, que se inicializa a 1 para la multiplicación 
		int factorial = 1;
		
		Scanner inputValue = new Scanner(System.in);
		
		System.out.println("Introduce un número entero:");
		numero = inputValue.nextInt();
		inputValue.close();
		
		//No hace falta empezar en 1, pues 1 * 1 = 1!!
		for (int i = 2; i <= numero; i++) {
			//Vamos acumulando el resultado
			factorial *= i;
		}
		
		System.out.printf("El factorial de %d es %d", numero, factorial);
		
		
    }
}
