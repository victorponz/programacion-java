import java.util.Scanner;

//Diseña un algoritmo que recibe horas, minutos y segundos y 
// muestra horas, minutos y segundos resultantes de la adición de un segundo.
public class Ejemplo18 {
	public static void main(String argv[]) {
		int horas;
		int minutos;
		int segundos;
		Scanner miScanner = new Scanner(System.in);
		
		System.out.println("Introduce las horas:");
		horas = miScanner.nextInt();
		
		System.out.println("Introduce los minutos:");
		minutos = miScanner.nextInt();
		
		System.out.println("Introduce los segundos:");
		segundos = miScanner.nextInt();
		miScanner.close();

		//Añadimos un segundo
		segundos = segundos + 1; // o segundos++
		
		//Si al sumar un segundo, llegamos a 60 significa que hemos de aumentar un minuto
		if (60 == segundos) {
			minutos++; 
			segundos = 0;
			//Si ahora los minutos son 60, hemos de aumentar una hora		
			if (60 == minutos) {
				horas++;
				minutos = 0;
				//Si ahora las horas son 24, la ponemos a 0 (ha pasado un día)
				if (24 == horas) {
					horas = 0;
				}
			}
		}
		
		System.out.printf("Ahora son %d:%d:%d %n", horas, minutos, segundos);
	}
}
