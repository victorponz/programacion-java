import java.util.HashMap;
import java.util.Map;

public class Botin {

    public static void main(String[] args) {
       System.out.println(repartir(2, 10, 20, 50, 200, 500));
       System.out.println(repartir(3, 50, 20, 100, 200, 500, 10, 50));
    }
    public static String repartir(int participantes, int ... billetes){

        Map<Integer, String> reparto = new HashMap<Integer, String>();
        for (int i = 0; i < billetes.length; i++) {
            String botin = reparto.get(i % participantes);
            if (botin ==  null){
                reparto.put(i % participantes, billetes[i] + " ");
            }else{
                reparto.put(i % participantes, botin + " " + billetes[i]);
            }
        }
        return reparto.toString();
    }
}