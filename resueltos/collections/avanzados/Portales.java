import java.util.ArrayList;
import java.util.List;
public class Portales {

    public static void main(String[] args) {

        System.out.println(repartir(0, 2, 4));
        System.out.println(repartir(3, 2, 5, 1));
        System.out.println(repartir(3, 2, 4, 7));
       
    }

    public static String repartir(int aterriza, Integer ... portales) {
        List<Integer> portals = new ArrayList<Integer>();
        String result = "";
        int  temp, index = -1;
        int actual = aterriza;
        int diff, min;
        
        for (int i = 0; i < portales.length; i++) {
            portals.add(portales[i]);
        }
        while (!portals.isEmpty()) {
            min = Integer.MAX_VALUE;
            temp = 0;
            for (int i = 0; i < portals.size(); i++) {
                //Calcular el mínimo desde el actual
                diff = Math.abs(portals.get(i) - actual);
                if (diff <= min ){
                    min = diff;
                    temp = portals.get(i);
                    index = i;
                }
            }
            result += temp + " ";
            portals.remove(index);
        }
        return result;
    }

}
