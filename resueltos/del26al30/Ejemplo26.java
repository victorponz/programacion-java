import java.util.Scanner;
public class Ejemplo26 {
    public static void main(String[] args)
    {	
		int numero;		
		Scanner inputValue = new Scanner(System.in);
		
		System.out.println("Introduce un número entero entre el 1 y el 9:");
		numero = inputValue.nextInt();
		inputValue.close();
		
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d x %d = %d %n", numero, i, (numero * i));
		}
    }
}