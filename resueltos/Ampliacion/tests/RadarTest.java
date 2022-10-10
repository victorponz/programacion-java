
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RadarTest {
    private static Radar radar = new Radar();
    @Test
    public void test() {
        assertEquals(radar.esMulta(9165, 110, 300), false);
        assertEquals(radar.esMulta(9165, 110, 299), true);
        assertEquals(radar.esMulta(12000, 100, 433), false);
        assertEquals(radar.esMulta(12000, 100, 431), true);

    }

}
