public class Digitos {
	public static int cuantosSonDigitos(String cadena) {
		int contador = 0;
		for(int i = 0; i < cadena.length(); i++){
			if (Character.isDigit(cadena.charAt(i))){
				contador++;
			}
		}
		return contador;
	}
	
	public static int cuantosSonDigitosDos(String cadena) {
		int contador = 0;
		
		//https://stackoverflow.com/questions/2451650/how-do-i-apply-the-for-each-loop-to-every-character-in-a-string
		for (char ch: cadena.toCharArray()) {
			//En el código ASCII los números van del 48 al 57
			if(ch >= 48 && ch <= 57){
				contador++;
			}
		}

		return contador;
	}
	

	public static int cuantosSonDigitosTres(String cadena) {
		int contador = 0;
		
		for(char letra : cadena.toCharArray()){
			if (Character.isDigit(letra)){
				contador++;
			}
		}
		return contador;
		
	}
	
	public static int cuantosSonDigitosTres(char[] cadenaArray) {
		int contador = 0;
		
		for(char letra : cadenaArray){
			if (Character.isDigit(letra)){
				contador++;
			}
		}
		return contador;
		
	}
	public static void main(String[] args) {
		
		String cadena = Utilidades.leerCadena("Introduce cadena");
		
		System.out.println("I. La cadena '" + cadena + "' tiene " + cuantosSonDigitos(cadena) + " dígitos");
		
		System.out.println("II.- La cadena '" + cadena + "' tiene " + cuantosSonDigitosDos(cadena) + " dígitos");
		
		System.out.println("III.- La cadena '" + cadena + "' tiene " + cuantosSonDigitosTres(cadena) + " dígitos");
		
		System.out.println("IV.- La cadena '" + cadena + "' tiene " + cuantosSonDigitosTres(cadena.toCharArray()) + " dígitos");
	}


}