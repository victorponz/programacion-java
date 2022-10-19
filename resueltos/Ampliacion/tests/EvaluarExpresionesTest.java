
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class EvaluarExpresionesTest {

    private EvaluarExpresion evaluarExpresion = new EvaluarExpresion();

    @Test
    public void test() {
        assertEquals(evaluarExpresion.pila("5 1 2 + 4 * + 3 -"), "14");
        assertEquals(evaluarExpresion.pila("2 4 5 3 / * +"), "6");
        assertEquals(evaluarExpresion.pila("6"), "6");
        assertEquals(evaluarExpresion.pila("3 5 4 + *"), "27");
       
        assertEquals(evaluarExpresion.pila("8 1 1 - /"), "ERROR");
        assertEquals(evaluarExpresion.pila("1 1 - 8 /"), "0");
        assertEquals(evaluarExpresion.pila("0 0 /"), "ERROR");

        assertEquals(evaluarExpresion.cola("2 4 5 3 / * +"), "17");
        assertEquals(evaluarExpresion.cola("6"), "6");
        assertEquals(evaluarExpresion.cola("8 1 1 - /"), "-7");
        assertEquals(evaluarExpresion.cola("1 1 - 8 /"), "ERROR");
        assertEquals(evaluarExpresion.cola("0 0 /"), "ERROR");

    }

}

