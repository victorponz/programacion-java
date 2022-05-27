public class Persona {
    final static char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 
                        'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
    private String dni;
    private String nombre;
    private short edad;

    public void setDni(String nuevoDni) {
        if (chequeaDNI(nuevoDni))
            dni = nuevoDni;
        else
            throw new IllegalArgumentException();
    }
    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public void setEdad(int nuevaEdad) {
        if (nuevaEdad < 0 || nuevaEdad > 150)
            throw new IllegalArgumentException();

        edad = (short)nuevaEdad;
    }
    private boolean chequeaDNI(String DNI){
        char letra;
        String numeros;
        int numero;

        if (DNI.length()<8)
            return false;
        letra = DNI.charAt(DNI.length()-1);
        numeros = DNI.substring(0, DNI.length()-1);   
        try{
            numero = Integer.valueOf(numeros);
        }catch(NumberFormatException nfe){
            return false;
        }
        int res = numero % 23;
        if (letra != letras[res])
            return false;

        return true;
    }
    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public short getEdad() { return edad; }

    public void visualizar() {
        System.out.println("Dni...........:" + dni);
        System.out.println("Nombre...........:" + nombre);
        System.out.println("Edad..........:" + edad);
    }

    public static void main(String args[]) {
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        p1.setDni("34748804J");
        p1.setNombre("Pepe Gotera");
        p1.setEdad(30);
        System.out.println("Visualización de persona p1:");
        p1.visualizar();
        System.out.println("El dni de p1 es " + p1.getDni());
        System.out.println("El nombre de p1 es " + p1.getNombre());
        System.out.println("La edad de p1 es " + p1.getEdad());
        System.out.println("Visualización de persona p2:");
        p2.visualizar();
    }
}