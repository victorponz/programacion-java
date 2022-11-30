import java.util.Map;
import java.util.HashMap;

public class Sorteo {
    public static void main(String[] args) {
        System.out.println(calcular("00004", "03847", "39804"));
        System.out.println(calcular("58975", "25894", "52985", "98598"));
        
        
    }
    public static String calcular(String ... boletos){

        Map<Integer,Integer> terminaciones = new HashMap<Integer,Integer>();
        int terminacion;
        Integer actual;
        for (String boleto : boletos) {
            terminacion = Integer.parseInt("" + boleto.charAt(boleto.length()-1));
            actual = terminaciones.get(terminacion);
            if (actual == null)
                terminaciones.put(terminacion, 1);
            else
                terminaciones.put(terminacion, ++actual);
        }
        
        return terminaciones.toString();
        
    }
}
