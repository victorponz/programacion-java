import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OrdenTest {
    @Test
    public void test() {
        int [] numeros = {1,5,7,9};
        assertEquals(Orden.comprobar(numeros) , 1);
        int [] numeros2 = {9, 5, 4, 3};
        assertEquals(Orden.comprobar(numeros2) , 2);
        int [] numeros3 = {9, 5, 7, 3};
        assertEquals(Orden.comprobar(numeros3) , 3);
        int [] numeros4 = {9, 9, 9, 9};
        assertEquals(Orden.comprobar(numeros4) , 0);

    }
        
}
