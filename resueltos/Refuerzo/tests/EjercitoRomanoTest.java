
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class EjercitoRomanoTest {

    private EjercitoRomano ejercitoRomano = new EjercitoRomano();

    @Test
    public void test() {
        assertEquals(ejercitoRomano.cuantosEscudos(35), 71);
        assertEquals(ejercitoRomano.cuantosEscudos(20), 44);
        assertEquals(ejercitoRomano.cuantosEscudos(10), 26);
    }

}

