public class Persona
{
    private String nombre;
    private String apellidos;
    /**
     * Constructor for objects of class Persona
     */
    public Persona(String nombre, String apellidos)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public String getApellidos(){
        return this.apellidos;
    }
    
    public String getDetails(){
        return ("Nombre: " + nombre + ", Apellidos: " + apellidos);
    }    

    public String atoString(){
        return ("Nombre: " + nombre + ", Apellidos: " + apellidos);
    }    
    

}
