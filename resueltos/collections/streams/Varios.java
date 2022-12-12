import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Varios {
    public static boolean mayorDeCinco(int numero) {
        return numero > 5;
    }
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        
        numeros.add(25);
        numeros.add(2);
        numeros.add(20);
        Long mayoresDeCinco = numeros.stream()
                    .filter(numero -> mayorDeCinco(numero))
                    .count();
        //System.out.printf("Los mayores de cinco son %d%n", mayoresDeCinco);
        
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(4);
        list.add(2);
        list.add(6);

        // List<Integer> values = list.stream()
        //     .filter(value -> value > 5)
        //     .map(value -> value * 2)
        //     .collect(Collectors.toList());
        
        // System.out.println(values);

        List<Integer> values = new ArrayList<>();
        values.add(3);
        values.add(2);
        values.add(17);
        values.add(6);
        values.add(8);

        System.out.println("Cuántos: " + values.stream().filter(n -> n > 5).count());
            
    }
}
