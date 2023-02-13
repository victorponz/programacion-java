public class Articulo{
    private static int numSerie = 0;
    private int ID;
    private String nombre;

    Articulo(String nombre){
        this.nombre = nombre;
        this.ID = numSerie++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
