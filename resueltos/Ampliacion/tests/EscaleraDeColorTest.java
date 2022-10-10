
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class EscaleraDeColorTest {

    private EscaleraDeColor escaleraDeColor = new EscaleraDeColor();

    @Test
    public void test() {
        assertEquals(escaleraDeColor.escalera(11, 12,13 ,14), 10);
        assertEquals(escaleraDeColor.escalera(10, 12,13 ,14), 11);
        assertEquals(escaleraDeColor.escalera(5, 6,7 ,8), 9);
        assertEquals(escaleraDeColor.escalera(9, 12,13 ,14), 0);
    }

}

