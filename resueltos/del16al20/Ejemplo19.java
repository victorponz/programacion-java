import java.util.Scanner;
public class Ejemplo19 {
	public static void main(String argv[]) {
		int horas;
		float precio;
		float bruto;
		float impuestos;
		Scanner miScanner = new Scanner(System.in);
		/* Habitualmente, los programas se dividen en 3 partes:
		 * 1.- Recoger datos
		 * 2.- Procesarlos
		 * 3.- Imprimir resultados
		 * Estas 3 partes deben estar diferenciadas, es decir, en la parte de proceso no
		 * imprimimos nada, sólo hacemos cálculos
		 */
		
		/*
		 * 1.- RECOGER DATOS 
		 */
		//Suponemos que el usuario introduce datos correctos
		System.out.println("Introduce las horas:");
		horas = miScanner.nextInt();
		
		System.out.println("Introduce el precio por hora:");
		precio = miScanner.nextFloat();
		miScanner.close();
	
		/*
		 * 2.- PROCESAR DATOS 
		 */
		
		/*
		 *  Primero calculamos el pago bruto.
		 *  Las primeras 35 horas se pagan al precio normal por hora
		 *  Las horas que exceden esas 35 horas se pagan 1,5 veces el precio normal.
		 */
		if (horas <= 35) {
			bruto = horas * precio;
		}else {
			//Las primeras 35 se pagan normal
			bruto = 35 * precio;
			//Las siguientes se pagan a 1,5 veces el precio normal
			bruto += (horas - 35) * precio * 1.5;
		}
		/*
		 * Ahora calculamos los impuestos:
		 *   Los primeros 500 € son libres de impuestos.
		 *   los próximos 400 € tienen un impuesto del 25%
		 *   Y el resto una tasa de impuestos del 45%.
		 */
		if (bruto <= 500) {
			impuestos = 0;
		}else if (bruto <= 900){
			//Cobra entre 500 y 900, de los primeros 500 no paga nada
			impuestos = (bruto - 500) * 0.25f;
		}else {
			//Si cobra más de 900
			impuestos = (400 * 0.25f) + (bruto - 500 - 400) * 0.45f;
		}
		
		/*
		 * 3.- IMPRIMIR RESULTADOS
		 */
		
		System.out.println("Pago bruto: " + bruto);
		System.out.println("Salario neto: " + (bruto - impuestos));
		System.out.println("Impuestos: " + impuestos);
		
	}
}
