import java.util.Scanner;

public class Ejemplo37 {
	 public static void main(String[] args){
		 	Scanner miScanner = new Scanner(System.in);
		   	int decimal = 0;
		    int potencia = 0;
		    
		    /*
		     * En este primera versión deñ algoritmo 
             * vamos a leer en número como una cadena
		     */
		    System.out.println("Introduce un número binario ");
		    
		   	String binario = miScanner.next();
		   	miScanner.close();
		   	
		   	char bit;
            //Empezamos por el bit menos significativo (el último)
		   	for (int i = binario.length() - 1; i >= 0; i--) {
                /* El último bit se eleva a 0,
				 * el antepenúltimo a 1, ...
                 */
		   		bit = binario.charAt(i);
		   		potencia = (binario.length() - 1) - i;
		   		if (bit == '1') {
		   			decimal += Math.pow(2, potencia);
		   		}
		   		
		   		//El siguiente código comentado es sin usar variables
		   		/*
		   		if (binario.charAt(i) == '1') {
		   			decimal += Math.pow(2, (binario.length() - 1) - i);	
		   		}
		   		*/
		   		
		   	}
		   	System.out.printf("Método I.- El número %s en binario es %d %n", binario, decimal);
		   	
		  
		   	/*
		   	 * En este segundo método, ahora el binario está en formato decimal (int)
		   	 * o con binarioEntero = miScaner.nextInt()
		   	 */
		    int binarioEntero =  Integer.parseInt(binario);
	       
	        decimal = 0;
	        potencia = 0;
	        while (binarioEntero != 0) {
	        	//En ultimoDigito tenemos un 0 o un 1
	            int ultimoDigito = binarioEntero % 10;
	            //Lo elevamos a la potencia actual
	            decimal += ultimoDigito * Math.pow(2, potencia);
	            //Aumentamos la potencia
	            potencia++;
	            //Dividimos el número entre 10 (división entera) por lo le quitamos el últmo dígito
	            binarioEntero = binarioEntero / 10;
	        }
	        System.out.printf("Método II.- El número %s en binario es %d %n", binario, decimal);
	 }
}