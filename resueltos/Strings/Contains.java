
public class Contains {

	public static boolean contiene(String cadena1, String cadena2) {
		return cadena1.contains(cadena2);
	}
	public static void main(String[] args) {
		String cadena1 = Utilidades.leerCadena("Introduce cadena1");
		String cadena2 = Utilidades.leerCadena("Introduce cadena2");

		if (contiene(cadena1, cadena2)) {
			System.out.println("'" + cadena2 + "' está contenida en '" + cadena1 + "'");
		} else {
			System.out.println("'" + cadena2 + "' NO está contenida en '" + cadena1 + "'");
		}
	}

}