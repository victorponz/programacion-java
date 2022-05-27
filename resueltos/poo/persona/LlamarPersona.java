//Fichero LlamarPersona.java
public class LlamarPersona {
    public static void main(String args[]) {
       Persona p = new Persona();
       p.dni = "--$%#@--";
       p.nombre = "";
       p.edad = -23;
       System.out.println("Visualización de la persona p:");
       p.visualizar();
    }
 }