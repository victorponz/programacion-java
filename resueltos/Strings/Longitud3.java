public class Longitud3 {
	public static boolean todasSonCortas(String[] palabras, int longitud) {
		for (String palabra : palabras) {
			if (palabra.length() >= longitud) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String cadena = Utilidades.leerCadena("Introduce un texto");
		String palabras[] = Utilidades.dividirEnPalabras(cadena);
		int longitud = Utilidades.leerEntero("¿todas las palabras son de longitud menor que k? ");
		
		if (todasSonCortas(palabras, longitud)) {
			System.out.println("Todas las cadenas son cortas");
		}else {
			System.out.println("Hay alguna palabra larga");
		}
	}

}