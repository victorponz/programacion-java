public class Ejemplo29 {	
    public static void main(String[] args)
    {	
		boolean esPrimo;
		for (int numero = 3; numero <=100; numero+=2) {
			//En este caso la bandera se inicializa en cada iteración
			esPrimo = true;
		    //Sólo lo dividimos por los impares, hasta la mitad del número.
			//Es una versión simplificada del algoritmo de los números primos
		    for(int i=3; i <= (numero / 2); i+=2) {
		        if(numero %i ==0){
		        	esPrimo = false;
		        	break;
		        }
		    }
		    if (esPrimo) {
		    	System.out.println(numero);
		    }
		}
    }
}
