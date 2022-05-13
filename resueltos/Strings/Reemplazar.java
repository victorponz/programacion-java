public class Reemplazar {
	public static String reemplazar(String cadena, String buscar, String reemplazar) {
		return cadena.replace(buscar, reemplazar);
	}
	public static void main(String[] args) {
		String cadena = Utilidades.leerCadena("Introduce una cadena");
		String buscar = Utilidades.leerCadena("Introduce carácter/es a buscar:");
		String sustituir = Utilidades.leerCadena("Introduce carácter/es a reemplazar:");

		System.out.println("Cadena resultante: " + reemplazar(cadena, buscar, sustituir));
	}

}