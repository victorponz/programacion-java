
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class AfortunadosTest {

     @Test
    public void test() {
        assertEquals(Afortunados.calcular(3), "2 3");
        assertEquals(Afortunados.calcular(10), "4 6 10 ");
        assertEquals(Afortunados.calcular(30), "10 12 18 22 30 ");
        assertEquals(Afortunados.calcular(100), "30 34 42 48 58 60 78 82 ");
        
    }

}

