public class Siglas {
	/*
	 * Realiza un programa que lea un frase y la convierta en unas siglas. Por
	 * ejemplo, Escuela Oficial de Idiomas, se convierte en EOI.
	 */
	public static String siglas(String[] palabras) {
		String siglas = "";

		for (String palabra : palabras) {
			char letra = palabra.charAt(0);
			if (Character.isUpperCase(letra)) {
				siglas = siglas + letra;
			}

		}
		return siglas;
	}
	public static void main(String[] args) {
    	String solucion = siglas(Utilidades.dividirEnPalabras(Utilidades.leerCadena("Introduce texto")));
		System.out.println(solucion);
	}
}