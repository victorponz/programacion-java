import java.util.Scanner;
public class Ejemplo28 {
    public static void main(String[] args)
    {	
		int numero;
		boolean esPrimo = true;
		Scanner inputValue = new Scanner(System.in);
		
		System.out.println("Introduce un número entero positivo:");
		numero = inputValue.nextInt();
		inputValue.close();

		if ((numero == 1) || ((numero != 2 ) && (numero % 2 == 0))) {
			esPrimo = false;
		}else{
			//Sólo lo dividimos por los impares, hasta la mitad del número
		    for(int i=3; i <= (numero / 2); i+=2) {
				//Si el resto de la multiplicación es 0 es divisible
		        if(numero %i ==0){ 
		        	esPrimo = false;
					//Una vez sabemos que no es primo ya podemos salir del bucle
		        	break;
		        }
		    }
		}
	    if (esPrimo) {
	    	System.out.println("El número " + numero + " es primo");
	    }else {
	    	System.out.println("El número " + numero + " NO es primo");
	    }
    }
}
