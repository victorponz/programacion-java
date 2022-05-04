import java.util.Scanner;

//Realiza un programa que lea dos números enteros y 
// dependiendo de la operación que indique el usuario (+, -, * , /) muestre el resultado
public class Ejemplo16 {
	public static void main(String argv[]) {
		int n;
		int m;
		String operacion;
		String cadena; 
		Scanner inputValue  = new Scanner(System.in);


		// Leer un carácter como int desde el teclado
		System.out.println("Introduce un número entero:");
		n = inputValue.nextInt();

		System.out.println("Introduce otro número entero:");
		m = inputValue.nextInt();
		
		System.out.println("Introduce la operación a realizar (+, -, *, /):");
		operacion = inputValue.next();
		switch (operacion) {
			/* Fíjate que usamos dobles comillas " porque es de tipo String */
		case "+":			
			System.out.printf("El resultado de sumar %d y %d es: %d %n", n, m, n+m);
			break;
		case "-":
			System.out.printf("El resultado de restar %d y %d es: %d %n", n, m, n-m);
			break;
		case "*":
			System.out.printf("El resultado de multiplicar %d y %d es: %d %n", n, m, n*m);
			break;
		case "/":
			System.out.printf("El resultado de dividir %d y %d es: %d %n", n, m, n/m);
			break;
		default:
			System.out.println("Operación incorrecta");
		}
		//También se puede hacer así. Leyendo sólo el primer carácter de la cadena
		char op;
		
		System.out.println("Introduce la operación a realizar (+, -, *, /):");
		//Leemos toda una cadena
		cadena = inputValue.next();
		// y nos quedamos con el carácter 0 (el primero)
		op = cadena.charAt(0);
		 
		switch (op) {
			/* Fíjate que usamos comilla simple ` porque es de tipo char */
		case '+':
			System.out.printf("El resultado de sumar %d y %d es: %d %n", n, m, n+m);
			break;
		case '-':
			System.out.printf("El resultado de restar %d y %d es: %d %n", n, m, n-m);
			break;
		case '*':
			System.out.printf("El resultado de multiplicar %d y %d es: %d %n", n, m, n*m);
			break;
		case '/':
			System.out.printf("El resultado de dividir %d y %d es: %d %n", n, m, n/m);
			break;
		default:
			System.out.println("Operación incorrecta");
		}

		// Y también se puede hacer con un bloque if-else-if
		if ('+' == op)
			System.out.printf("El resultado de sumar %d y %d es: %d %n", n, m, n+m);
		else if ('-' == op)
			System.out.printf("El resultado de restar %d y %d es: %d %n", n, m, n-m);
		else if ('*' == op)
			System.out.printf("El resultado de multiplicar %d y %d es: %d %n", n, m, n*m);
		else if ('/' == op)
			System.out.printf("El resultado de dividir %d y %d es: %d %n", n, m, n/m);
		else 
			System.out.println("Operación incorrecta");

		inputValue.close();
	}
}
