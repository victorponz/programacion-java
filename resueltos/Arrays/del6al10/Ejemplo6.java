public class Ejemplo6 {
    public static void main(String[] args)
    {	
    	int[] numeros = {5, 7, 55, 8, 90, 33, 45, 68, 21, 10};
    	int minimo;
    	
        //Suponemos que el mínimo es el primer número
		minimo = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] < minimo) {
				minimo = numeros[i]; 
			}
			
		}
		
		System.out.println("I. El mínimo es : " + minimo);
	
		//Otra forma de hacerlo es asignar a mínimo el mayor posible
		minimo = Integer.MAX_VALUE;
		for (int numero : numeros) {
			if (numero < minimo) {
				minimo = numero; 
			}
			
	    }
		System.out.println("II. El mínimo es : " + minimo);
		
    }
}