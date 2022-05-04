
import java.util.Scanner;
public class Ejemplo30 {
    public static void main(String[] args)
    {
    	boolean esPalindromo = true;
    	Scanner miScanner = new Scanner(System.in);
    	
    	System.out.println("Introduzca una cadena:");
    	   	
        String cadena = miScanner.nextLine();
        miScanner.close();
        
	    for (int i = 0; i < (cadena.length() / 2); i++) {
	    	//Recorremos la mitad de la cadena y comparamos el valor primer valor con el último
	    	//el segundo con el penúltimo, etc
	    	//En el momento que alguno no coincida ya podemos parar porque la palabra no es palíndroma
	    	if (cadena.charAt(i) != cadena.charAt(cadena.length() - i - 1)) {
	    		esPalindromo = false;
	    		break;
	    	}
	    }
	    if (esPalindromo) {
	    	System.out.println("La cadena es palíndroma");
	    }else {
	    	System.out.println("La cadena NO es palíndroma");
	    }
    }
}