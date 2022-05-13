/**
 * @author victor
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1v1 {
    public static void main(String[] args) throws IOException {
    	System.out.println("Introduce un directorio:");
        String ent = new BufferedReader(new InputStreamReader(System.in)).readLine();
        File f = new File(ent);
        if (f.exists()){
            if (f.isDirectory()){
                System.out.println("Lista de ficheros y directorios del directorio: " + f.getCanonicalPath());
                System.out.println("---------------------------------------------------");
                for (File e : f.listFiles()){
                	//No imprime los ficheros/directorios ocultos
                	if (!e.isHidden()) {
	                    if (e.isFile())
	                        System.out.println(e.getName() + " " + e.length());
	                    if (e.isDirectory())
	                        System.out.println(e.getName() + " <Directorio>");
                	}
                }
            }
            else{
                System.out.println("No es un directorio");
            }
        }
        else{
            System.out.println("No existe el directorio");
        }
    }
}