package strings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Palabras3 {
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
		//Le quitamos los espacios al principio y al final
		 cadena = cadena.trim();
		 //Reemplazamos uno o más blancos por un sólo blanco
	     cadena = cadena.replaceAll(" +", " ");
	     //Dividimos la cadena por los espacios en blanco
	     String cadenaEnArray[]=cadena.split(" ");
	     //Y devolvemos la longitud de este array
	     return cadenaEnArray.length;
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
