import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<IArea> l = new ArrayList<>();
        l.add(new Circulo(2));
        l.add(new Cuadrado(5));
        l.add(new Cuadrado(6));
        System.out.println(new SumCalculatorOutputter(new AreaCalculator(l)).toJSON());
        System.out.println(new SumCalculatorOutputter(new AreaCalculator(l)).toHTML());
    }
}
