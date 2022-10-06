
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class ContarPalabrasTest {

    private ContarPalabras contarPalabras = new ContarPalabras();

    @Test
    public void test() {
        assertEquals(contarPalabras.contar("Esto es una cadena que tiene  varios espacios"),8 );
        assertEquals(contarPalabras.contar("Esto es una frase que acaba en un espacio "), 9);
        assertEquals(contarPalabras.contar("Esto es una frase normal"), 5);
    
    }

}

