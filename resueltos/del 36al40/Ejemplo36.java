import java.util.Scanner;

public class Ejemplo36 {

	public static void main(String[] args) {
		Scanner miScanner = new Scanner(System.in);
		int numero, digito;
		//binario es de tipo acumulador
		String binario = "";
		System.out.println("Introduce un número entero >= 0: ");
		numero = miScanner.nextInt();
        miScanner.close();

		while (numero != 0) {
            //Cogemos el resto de la división para saber si 
            //el resultado es el bit 0 o 1
			digito = numero % 2;
			binario = digito + binario;
            //El siguiente número será el cociente
            //de la división entera
			numero = numero / 2;
		}
		System.out.printf("Binario: %s", binario);
	}
}