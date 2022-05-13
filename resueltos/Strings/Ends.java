public class Ends {
	public static boolean acabaEn(String cadena1, String cadena2) {
		return cadena1.endsWith(cadena2);
	}
	public static void main(String[] args) {
		String cadena1 = Utilidades.leerCadena("Introduce cadena1");
		String cadena2 = Utilidades.leerCadena("Introduce cadena2");
		
		if(acabaEn(cadena1, cadena2)){
			System.out.println("'" + cadena1 + "' acaba en '" + cadena2 + "'");
		}
		else {
			System.out.println("'" + cadena1 + "' NO acaba en '" + cadena2 + "'");
		}
	}


}