public class Circulo implements IArea {
    private int radio;
    public Circulo(int radio) {
        this.radio = radio;
    }

    @Override
    public int area(){
        return  (int) (Math.PI * Math.pow(this.radio, 2));
    }
}
