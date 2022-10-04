import java.util.Scanner;

public class Ejemplo7 {
    public static void main(String[] args)
    {	
		String[] cadenas = new String[5];
		Scanner miScanner = new Scanner(System.in);
		int maxLength = 0;
		
		//Pedir las cadenas y calcular la máxima longitud
		System.out.println("Introduce " + cadenas.length + " cadenas");
		for (int i = 0; i < cadenas.length; i++){
			cadenas[i] = miScanner.nextLine();			
		}
		miScanner.close();
		
		// Calcular la longitud de la máxima cadena
		// Se hubiera podido calcular también en el for anterior
		for (String cadena : cadenas){			
			if (cadena.length() > maxLength){
				maxLength = cadena.length();
			}
		}
		
		//Imprimir la primera línea de asteriscos
		for (int i = 0; i < maxLength + 4; i++) {
			System.out.print("*");
		}
		System.out.println("");
	
		//Imprimir cada una de las cadenas
		for (int i = 0; i < cadenas.length; i++){
			System.out.print("* ");
			System.out.print(cadenas[i]);
			for (int j = cadenas[i].length(); j <= maxLength; j++){
				System.out.print(" ");
			}
			System.out.println("*");
		}
		
		//Otra forma de hacerlo es así
		/*
		for (String palabraActual : cadenas){
			while (palabraActual.length() < maxLength){
				palabraActual = palabraActual + " ";
			}
			System.out.println("* " + palabraActual + " *");
		}
		*/
		
		//Imprimir la  última línea de asteriscos
		for (int i = 0; i < maxLength + 4; i++) {
			System.out.print("*");
		}
    }

}
