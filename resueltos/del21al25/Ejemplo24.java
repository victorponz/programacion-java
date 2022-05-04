import java.util.Scanner;
/*
 * Diseña un algoritmo que lea un conjunto de notas del teclado hasta 
 * que se introduzca -1 y muestre la nota media y si había un 10 o no. 
 */
public class Ejemplo24 {
    public static void main(String[] args)
    {	
		int nota;
		/* Esta variable es un contador */
		int cuantasNotas = 0;
		/* sumaNotas es un acumulador, que se inicializa a 0 para la suma, a 1 para la multiplicación
		 */
		int sumaNotas = 0;
		/*
		 * hayUnDiez es una variable de tipo bandera
		 */
		boolean hayUnDiez = false;
		Scanner miScanner = new Scanner(System.in);
		
		System.out.println("Introduce las notas (enteros) (para acabar introduce un -1)");
		//Como de entrada no sabemos cuántas veces se va a hacer el bucle, usamos un do ... while
		do{
			nota = miScanner.nextInt();
			if (nota != -1){
				sumaNotas += nota; //Equivale a sumaNotas = sumaNotas + nota;
				cuantasNotas++;
				if (10 == nota) {
					//cambiamos el valor de la bandera
					hayUnDiez = true;
				}
			}
		}while ( nota != -1);
		miScanner.close();
		
		System.out.println("La nota media es " + ((float)sumaNotas / (float)cuantasNotas));
		
		if (hayUnDiez) {
			System.out.println("Había al menos un 10 en las notas");
		}
    }
}
