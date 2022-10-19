
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class PersistenciaTest {

    @Test
    public void test() {
        assertEquals(Persistencia.calcular(39), 3);
        assertEquals(Persistencia.calcular(931), 3);
        assertEquals(Persistencia.calcular(245), 2);
    }

}

