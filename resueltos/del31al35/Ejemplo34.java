import java.util.Scanner;

public class Ejemplo34 {
    public static void main(String[] args)
    {	
    	Scanner miScanner = new Scanner(System.in);
		int x;
		int y;
		
		System.out.println("Introduce un número");
		x = miScanner.nextInt();
		
		System.out.println("Introduce otro número");
		y = miScanner.nextInt();
		
		miScanner.close();

		//La variable mul es un acumulador, inicializado en este caso al primer número
		int mul = x;
		
		for (int i = 1; i < y; i++) {
			//Vamos sumando tantas veces como indique `y` (es decir, multiplicando)
			mul += x;
		}
		System.out.printf("%d x %d = %d", x, y, mul);
	}

}