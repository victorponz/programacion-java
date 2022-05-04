import java.util.Scanner;
public class Ejemplo27 {
    public static void main(String[] args)
    {	
		int numero;
		// resultado es un acumulador, que se inicializa a "" para las cadenas
		String resultado = "";
		Scanner miScanner = new Scanner(System.in);
		
		System.out.println("Introduce un número entero:");		
		numero = miScanner.nextInt();
		miScanner.close();
		
		for (int i = 1; i <= numero; i++) {
			//Vamos acumulando el resultado:
			// 1 
			// 1 2
			// 1 2 3 
			// ...
			resultado += i + " ";
			System.out.println(resultado);
		}		
    }
}
