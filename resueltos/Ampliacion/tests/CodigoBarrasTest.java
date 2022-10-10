
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class CodigoBarrasTest {

    private CodigoBarras codigoBarras = new CodigoBarras();

    @Test
    public void test() {
        assertEquals(codigoBarras.check("65839522"), true);
        assertEquals(codigoBarras.check("65839521"), false);
        assertEquals(codigoBarras.check("8414533043847"), true);
        assertEquals(codigoBarras.check("5029365779425"), true);
        assertEquals(codigoBarras.check("5129365779425"), false);
    }

}

