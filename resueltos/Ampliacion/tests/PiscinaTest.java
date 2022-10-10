
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class PiscinaTest {

    private Piscina piscina = new Piscina();

    @Test
    public void test() {
        assertEquals(piscina.quienGana(10, 5, 1, 15, 6, 1), 0);
        assertEquals(piscina.quienGana(50, 5, 1, 50, 5, 0), -1);
        assertEquals(piscina.quienGana(50, 5, 1, 50, 5, 6), 1);
    }

}

