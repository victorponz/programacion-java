import java.util.Scanner;
/*
 * Escribe un programa que pida al usuario n números y que muestre cuántos son 
 * positivos (para acabar el programa, el usuario debe introducir el número 0)
 * 
 */
public class Ejemplo23 {
    public static void main(String[] args)
    {	
		int dato;
		/*
		 * Las dos variables siguientes son de tipo "contador"
		 */
		int positivos = 0;
		int cuantos = 0;
		Scanner miScanner = new Scanner(System.in);
		
		System.out.println("Introduce números enteros (para acabar introduce un 0)");
		//Como de entrada no sabemos cuántas veces se va a hacer el bucle, usamos un do ... while
		do{
			dato = miScanner.nextInt();
			if (dato != 0){
				if (dato > 0){
					positivos++;
				}
				cuantos++;
			}

		}while ( dato != 0);
		miScanner.close();

		System.out.println("Ha introducido " + positivos + " números positivos");
		System.out.println("Ha introducido " + (cuantos - positivos) + " números negativos");
    }
}
