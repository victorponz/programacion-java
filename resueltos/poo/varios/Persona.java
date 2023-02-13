public class Persona {
    private String nombre;
    private String DNI;
    public static final char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };

    public Persona(String nombre, String DNI) {
        this.nombre = nombre;
        if (checkDNI(DNI))  this.DNI = DNI;
        else  this.DNI = "";

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDNI() {
        return DNI;
    }

    private static boolean checkDNI(String DNIAComprobar){
        if (DNIAComprobar.length() != 9) return false;
        else{
            int numero = Integer.parseInt(DNIAComprobar.substring(0, 8));
            char letra = DNIAComprobar.charAt(8);
            if ( letra != letras[numero % 23]) return false;
        }
        return true;
    }
    
}
