import java.util.HashMap;
import java.util.Map;

public class PaisCapital {

    public static void main(String[] args) {
        String pais = "";
        Map<String, String> capitales = new HashMap<String, String>();
        capitales.put("España", "Madrid");
        capitales.put("Francia", "París");
        capitales.put("Inglaterra", "Londres");
        capitales.put("Italia", "Roma");
        do{
            pais = Utilidades.leerCadena("Introduzca un país (cadena vacía para acabar)");
            if (pais.length() != 0)
                System.out.println(capitales.getOrDefault(pais, "No existe ese país en la base de datos"));

        }while (pais.length() != 0);
    }
}