import java.util.List;
public class AreaCalculator {
    private List<IArea> l;
    public AreaCalculator(List<IArea> l) {
        this.l = l;
    }
    public int sum(){
        int area = 0;
        for (IArea o:l) {
            area += o.area();
        }
        return area;
    }

    @Override
    public String toString(){
        return "Área: " + this.sum();
    }
}