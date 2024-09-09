public class Cuadrado implements IArea {
    private int lado;

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    @Override
    public int area(){
        return lado * lado;
    }
}
