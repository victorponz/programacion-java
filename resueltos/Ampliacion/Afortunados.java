import java.util.ArrayList;
public class Afortunados {
    public static String calcular(int num){
        ArrayList<Integer> numeros = new ArrayList<Integer>(); 
        String res = "";
        int cuantos = 2;
        for (int i = 1; i <= num; i++) {
            numeros.add(i);
        }
        int max = numeros.size();
        while(cuantos < numeros.size()){
            for (int i = 0; i < max; i+=cuantos) {
                numeros.remove(i);
                i--;
                max--;
            }
            cuantos++;
        }
        for (int i = 0; i < numeros.size(); i++) {
            res += numeros.get(i) + " ";
        }
        return res;
    }
}
