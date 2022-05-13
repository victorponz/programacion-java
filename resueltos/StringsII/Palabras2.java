package strings;

import java.util.Scanner;
/*
 * Realiza el mismo programa pero no se pueden usar ninguna de las funciones relacionadas con cadenas. 
 * Sólo se puede usar charAt();
 */
public class Palabras2 {

	static Scanner inputValue = new Scanner(System.in);
	public static String leerCadena(String mensaje){
		System.out.println(mensaje);
	    return inputValue.nextLine();  
	}
	public static int contarPalabras(String cadena){
		/*
		 * En este programa realizamos el siguiente algoritmo:
		 * Primero buscamos un carácter que no sea blanco.
		 * Cuando lo encontramos, ahora buscamos hasta encontrar un blanco.
		 * Eso significa que hay una palabra.
		 * Y repetimos el proceso hasta llegar al final
		 */
		int numPalabras = 0;
		int largo = cadena.length();
		
		boolean  buscoBlanco = false;
		for (int i = 0;  i < largo; i++){
			if (buscoBlanco){
				//Si estoy buscando un blanco y lo encuentro
				if (cadena.charAt(i) == ' '){
					buscoBlanco = !buscoBlanco;
					//Pasamos a buscar un carácter que no sea blanco
				}
			}else{
				//Si estoy buscando un carácter no blanco
				if (cadena.charAt(i) != ' '){
					//y lo encuentro, significa que hay una palabra y ahora volvemos a empezar a buscar un blanco
					buscoBlanco = !buscoBlanco;
					numPalabras++;
				}
			}
		}
		return numPalabras;
	}
	public static void main(String[] args){   
		
	    String cadena = leerCadena("Introduce una cadena");
		
			 
		System.out.println("El texto tiene " + contarPalabras(cadena)+ " palabras"); 
	}


}
