import java.util.ArrayList;
import java.util.List;

public class Suma {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
      
        numeros.add(25);
        numeros.add(-5);
        numeros.add(20);
        numeros.add(-10);
        numeros.add(-5);
        Long positivos = numeros.stream()
                    .filter(numero -> numero > 0)
                    .count();
        Long negativos = numeros.stream()
                    .filter(numero -> numero < 0)
                    .count();
        System.out.printf("Los positivos son %d y los negativos son %d%n", positivos, negativos);
    }
}
