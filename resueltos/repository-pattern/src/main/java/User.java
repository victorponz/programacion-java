import java.util.ArrayList;

public class User
{
    private int id;
    private String nombre;
    private String apellidos;
    private ArrayList<String> a;
    /**
     * Constructor for objects of class Usuario
     */
    public User()
    {
        this.nombre = "";
        this.apellidos = "";
        this.id = -1;
    }
    public User(int id, String nombre, String apellidos){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    public User(String nombre, String apellidos)
    {
        this(-1, nombre, apellidos);
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    @Override
    public String toString(){
        return "ID: " + id + " Name: " + nombre + " Lastname: " + apellidos;
    }

}