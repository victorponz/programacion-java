public class Invertida {
	public static String invertir(String[] palabras){
		String invertida = "";
		for(int i = palabras.length - 1 ; i >= 0; i--){
			invertida = invertida + palabras[i] +" ";
		}
		return invertida;
	}
	public static void main(String[] args) {
		String invertida = invertir(Utilidades.dividirEnPalabras(Utilidades.leerCadena("Introduce texto")));
		System.out.println(invertida);
	}
}