public class IndexOf {
	public static int primeraPosicion(String cadena1, String cadena2) {
		return cadena1.indexOf(cadena2);
	}

	public static void main(String[] args) {

		String cadena1 = Utilidades.leerCadena("Introduce cadena1");
		String cadena2 = Utilidades.leerCadena("Introduce cadena2");

		int resultado = primeraPosicion(cadena1, cadena2);

		if (resultado > 0) {
			System.out.println("La primera posición de '" + cadena2 + "' en '" + cadena1 + "' es: " + resultado);
		} else {
			System.out.println("La cadena '" + cadena2 + "' NO está contenida en '" + cadena1 + "'");
		}
	}
}