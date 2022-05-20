import java.util.ArrayList;
import java.util.Collections;
public class Coches {
    public static void main(String[] args) {
        ArrayList<String> coches = new ArrayList<String>(); 
        String coche;
        do{
            coche = Utilidades.leerCadena("Introduzca un coche (cadena vacía para acabar)");
            if (coche.length() != 0)
                coches.add(coche);
        }while (coche.length() != 0);

        Collections.sort(coches);

        for (String cocheActual: coches){
            System.out.println(cocheActual);
        }
    }

}