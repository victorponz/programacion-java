
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class EvaluarExpresionesTest {

    private EvaluarExpresion evaluarExpresion = new EvaluarExpresion();

    @Test
    public void test() {
        assertEquals(evaluarExpresion.pila("2453/*+"), "6");
        assertEquals(evaluarExpresion.pila("6"), "6");
        assertEquals(evaluarExpresion.pila("811-/"), "ERROR");
        assertEquals(evaluarExpresion.pila("11-8/"), "0");
        assertEquals(evaluarExpresion.pila("00/"), "ERROR");

        assertEquals(evaluarExpresion.cola("2453/*+"), "17");
        assertEquals(evaluarExpresion.cola("6"), "6");
        assertEquals(evaluarExpresion.cola("811-/"), "-7");
        assertEquals(evaluarExpresion.cola("11-8/"), "ERROR");
        assertEquals(evaluarExpresion.cola("00/"), "ERROR");

    }

}

