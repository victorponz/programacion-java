package strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Palabras4 {
	
	public static String leerFichero(){
        BufferedReader br = null;
        String everything = "";
        try {
            br = new BufferedReader(new FileReader("./src/strings/palabras.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return everything;
	}
	public static int contarPalabras(String cadena){
		/*
		 * En este programa realizamos el siguiente algoritmo:
		 * Primero buscamos un carácter que no sea blanco.
		 * Cuando lo encontramos, ahora buscamos hasta encontrar un blanco.
		 * Eso significa que hay una palabra.
		 * Y repetimos el proceso hasta llegar al final
		 */
		int numPalabras = 0;
		int largo = cadena.length();
		
		boolean  buscoBlanco = false;
		for (int i = 0;  i < largo; i++){
			if (buscoBlanco){
				//Si estoy buscando un blanco y lo encuentro
				if (cadena.charAt(i) == ' '){
					buscoBlanco = !buscoBlanco;
					//Pasamos a buscar un carácter que no sea blanco
				}
			}else{
				//Si estoy buscando un carácter no blanco
				if (cadena.charAt(i) != ' '){
					//y lo encuentro, significa que hay una palabra y ahora volvemos a empezar a buscar un blanco
					buscoBlanco = !buscoBlanco;
					numPalabras++;
				}
			}
		}
		return numPalabras;
	}
	public static void main(String[] args) {
		
		String cadena = leerFichero();
	    long startTime = System.currentTimeMillis();
	 
	     
		System.out.println("El texto tiene " + contarPalabras(cadena) + " palabras"); 
	    long endTime = System.currentTimeMillis();
	    long tiempoPrimero = endTime - startTime;
	    System.out.println(tiempoPrimero + " milisegundos");
	}

}
