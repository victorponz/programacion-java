import java.util.Arrays;

public class Ejemplo5 {

    public static void main(String[] args)
    {	
    	int[] numeros = {5, 7, 55, 8, 90, 33, 45, 68, 21, 10};
    	int maximo;
    	
		//Antes de empezar a trabajar con el array lo imprimimos (por no hacer un bucle)
		System.out.println("Array : " + Arrays.toString(numeros));
		
		//Suponemos que el máximo es el primer número del array
		maximo = numeros[0];
		
		for (int i = 1; i < numeros.length; i++) {
			//Si el número actual es mayor que el máximo, este número es el nuevo máximo
			if (numeros[i] > maximo) {
				maximo = numeros[i]; 
			}
		}
		
		System.out.println("I. El máximo es : " + maximo);
	
		//Otra forma de hacerlo es asignar a máximo el valor más pequeño posible
		maximo = Integer.MIN_VALUE;
		for (int numero : numeros) {
			if (numero > maximo) {
				maximo = numero; 
			}
	    }
		System.out.println("II. El máximo es : " + maximo);
		
    }
}