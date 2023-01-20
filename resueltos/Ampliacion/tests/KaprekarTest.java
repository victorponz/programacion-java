
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class KaprekarTest {

    private Kaprekar kaprekar = new Kaprekar();

    @Test
    public void addition() {
        assertEquals(kaprekar.iterations(3524), 8);
        assertEquals(kaprekar.iterations(1111), 8);
        assertEquals(kaprekar.iterations(1121), 5);
        assertEquals(kaprekar.iterations(3524), 3);
        assertEquals(kaprekar.iterations(1893), 7);
        
    }

}

