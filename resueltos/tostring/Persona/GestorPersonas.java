import java.util.ArrayList;

public class GestorPersonas
{
   // An ArrayList for storing music tracks.
    private ArrayList<Persona> personas;
    /**
     * Constructor for objects of class GestorPersonas
     */
    public GestorPersonas()
    {
        personas = new ArrayList<>();
        addSamplePersons();
    }

    public void addPersona(Persona persona){
        personas.add(persona);
    }
    /**
     * Añade personas de ejemplo
     */
    public void addSamplePersons(){
        Persona pepe;
        pepe = new Persona("Pepe", "M");
        addPersona(pepe);
        Persona juan;
        juan = new Persona("Juan", "J");
        addPersona(juan);
        
    }
    public void printAll(){
        for(Persona p : personas){
            System.out.println(p);
        }
    }
}
