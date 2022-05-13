public class Desencriptar {
	
	public static String desencriptar(String palabra, int cod){
		String desencriptada="";
		char c=' ';

		for (char letra : palabra.toCharArray()) {
			if(Character.isLowerCase(letra)){
                //26 caracteres a partir del 97
				c = (char) ((26 + ((letra - 97 - (cod % 26)))) % 26 + 97);
			} else if(Character.isUpperCase(letra)){
                //26 caracteres a partir del 65
				c = (char) ((26 + ((letra- 65 -(cod % 26)))) % 26 + 65);
			} else if(Character.isDigit(letra)){
                //10 caracteres a partir del 48
				c = (char) ((10 + (letra - 48 -(cod % 10))) % 10 + 48);
			} else {
				c = letra;
			}
			desencriptada += c;
		}
		return desencriptada;
	}
	public static void main(String[] args) {
		String cad1 = Utilidades.leerCadena("Introduce una palabra encriptada");

		int cod = Utilidades.leerEntero("Introduce el código de encriptación");
		
		System.out.println(desencriptar(cad1,cod));
	}

}