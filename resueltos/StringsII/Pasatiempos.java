public class Pasatiempos {
	public static String crearPasatiempo(String frase) {
		//Se puede hacer de muchas formas
		String pasatiempo = "";
		for (int i = 0; i < frase.length(); i++) {
			if ("aeiouAEIOUáéíóúÁÉÍÓÚàèìòùÀÈÌÒÙäëïöüÄËÏÖÜ".contains("" + frase.charAt(i))) {
				pasatiempo = pasatiempo + ".";
			} else {
				pasatiempo = pasatiempo + frase.charAt(i);
			}
		}
		return pasatiempo;
	}

	public static void main(String[] args) {
		String cadena = Utilidades.leerCadena("Introduce cadena");
		String solucion = crearPasatiempo(cadena);
		System.out.println(solucion);
	}

}