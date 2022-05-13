public class Alfabetica {

	public static boolean esAlfabetica(String cadena) {
		//Fijáos que empieza en 1
		for(int i = 1; i < cadena.length(); i++){
			if(cadena.charAt(i) < cadena.charAt(i-1)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String palabra = Utilidades.leerCadena("Introduce una palabra");
		if ( palabra.length() > 0) {
			if(esAlfabetica(palabra)) {
				System.out.println("La palabra es alfabética");
			}
			else {
				System.out.println("La palabra no es alfabética");
			}
		} else {
			System.out.println("Introduzca una palabra de más de una letra");
		}
	}
}