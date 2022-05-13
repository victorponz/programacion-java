public class Criptografia {
    public static void main(String[] args) {
        String cad1= Utilidades.leerCadena("Introduce una frase");
        int cod = Integer.parseInt(Utilidades.leerCadena("Introduce el código de encriptación"));
        
        System.out.println("Encriptada:    " + Encriptar.encriptar(cad1, cod));
        System.out.println("Desencriptada: " + Desencriptar.desencriptar(Encriptar.encriptar(cad1, cod), cod));
    }
}