import java.util.ArrayList;
import java.util.List;
public class Statistics{
    public static void main(String[] args) {
        List<String> numeros = new ArrayList<>();
        int n;
        int suma = 0;
        int cuantos = 0;
        numeros.add("25");
        numeros.add("30");
        numeros.add("20");
        for(String numero : numeros){
            n = Integer.parseInt(numero);
            suma += n;
            if (n % 3 == 0)
                cuantos++;
        }
        System.out.printf("Hay %d números múltiplos de 3 y la media es %f%n", cuantos, (float)suma/(float)numeros.size());

    }
}