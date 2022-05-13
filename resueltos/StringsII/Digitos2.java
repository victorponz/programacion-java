public class Digitos2 {
	public static int contarNumeros(String[] palabras) {
		int numeros = 0;
		boolean esNumero;
		// ahora recorremos cada palabra para comprobar si son todo números
		for (String palabra : palabras) {
            //Suponemos que sí que lo es
			esNumero = true;
			for (int i = 0; i < palabra.length(); i++) {
				if (!(Character.isDigit(palabra.charAt(i)))) {
                    //Probamos que no lo es
					esNumero = false;
					break;
				}
			}
			if (esNumero) {
				numeros++;
			}
		}
		return numeros;
	}

	public static int contarNumeros(String cadena) {
		boolean posibleNumero = true;
		int numeros = 0;
		int largo = cadena.length();
		// Este programa es una variante de contar palabras
		boolean buscoBlanco = false;
		for (int i = 0; i < largo; i++) {
			if (buscoBlanco) {
				// Si estoy buscando un blanco y lo encuentro
				if (cadena.charAt(i) == ' ') {
					// Pasamos a buscar un carácter que no sea blanco
					buscoBlanco = false;
					if (posibleNumero) {
						numeros++;
					}
				}
				// Marcar siempre cuando no sea dígito
				if (!(Character.isDigit(cadena.charAt(i)))) {
					posibleNumero = false;
				}
			} else {
				// Si estoy buscando un carácter no blanco
				if (cadena.charAt(i) != ' ') {
					// y lo encuentro, significa que hay una palabra y ahora volvemos a empezar a
					// buscar un blanco
					buscoBlanco = true;
					// Marcar siempre cuando no sea dígito
					if (!(Character.isDigit(cadena.charAt(i)))) {
						posibleNumero = false;
					} else
						posibleNumero = true;
				}
			}
		}
		// tal vez quede el último por contar
		if (posibleNumero) {
			numeros++;
		}
		return numeros;
	}

	public static void main(String[] args) {
		String frase = Utilidades.leerCadena("Introduce una frase");
		String[] palabras = Utilidades.dividirEnPalabras(frase);
		
		System.out.println("I.- Hay " + contarNumeros(palabras) + " números en esta frase");
		System.out.println("II.- Hay " + contarNumeros(frase) + " números en esta frase");
	}

}