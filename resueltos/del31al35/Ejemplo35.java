import java.util.Scanner;

public class Ejemplo35 {
    public static void main(String[] args)
    {	
    	Scanner miScanner = new Scanner(System.in);
    	
    	int dividendo;
		int divisor;
		
		System.out.println("Introduce el dividendo");
		dividendo = miScanner.nextInt();
		
		System.out.println("Introduce el divisor");
		divisor = miScanner.nextInt();
		
		miScanner.close();
		
		//Resto también es un acumulador, aunque vamos restando
		int resto = dividendo;
		while(resto >= divisor){
			resto -= divisor;
		}
		System.out.printf("El resto de dividir %d entre %d es %d", dividendo, divisor, resto);
	}

}