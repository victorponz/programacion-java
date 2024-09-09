public class SumCalculatorOutputter {
    private AreaCalculator areaCalculator;

    public SumCalculatorOutputter(AreaCalculator areaCalculator) {
        this.areaCalculator = areaCalculator;
    }
    public String toJSON(){
        return "{\"area\": \"" + this.areaCalculator.sum()+ "\"}";
    }
    public String toHTML(){
        return "<p>" + this.areaCalculator.sum()+ "</p>";
    }
}
