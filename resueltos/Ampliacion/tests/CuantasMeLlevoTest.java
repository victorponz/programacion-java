
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class CuantasMeLlevoTest {

    private CuantasMeLlevo cuantasMeLlevo = new CuantasMeLlevo();

    @Test
    public void test() {
        assertEquals(cuantasMeLlevo.calcular(123, 456), 0);
        assertEquals(cuantasMeLlevo.calcular(555, 555), 3);
        assertEquals(cuantasMeLlevo.calcular(123, 594), 1);
    }

}

