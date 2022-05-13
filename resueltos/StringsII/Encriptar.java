public class Encriptar {

	public static String encriptar(String cad1, int cod) {
		String encriptada = "";
		char c = ' ';

		for (int i = 0; i < cad1.length(); i++) {			
			if (Character.isLowerCase(cad1.charAt(i))) {
                //Hay 26 caracteres y empiezan en el 97
				c = (char) ((cad1.charAt(i) - 97 + cod) % 26 + 97);
			} else if (Character.isUpperCase(cad1.charAt(i))) {
                //Hay 26 caracteres y empiezan en el 65
				c = (char) ((cad1.charAt(i) - 65 + cod) % 26 + 65);				
			} else if (Character.isDigit(cad1.charAt(i))) {
                //Hay 10 caracteres y empiezan en el 48
				c = (char) ((cad1.charAt(i) - 48 + cod) % 10 + 48);
			} else {
                //Lo dejamos tal cual
				c = cad1.charAt(i);
			}
			encriptada += c;
		}
		return encriptada;
	}
	public static void main(String[] args) {
		String cad1 = Utilidades.leerCadena("Introduce una palabra");
		int cod = Utilidades.leerEntero("Introduce el código de encriptación: ");
		System.out.println("La cadena encriptada es: " + encriptar(cad1, cod));
	}
}