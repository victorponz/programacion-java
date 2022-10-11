import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CubifinitoTest {
    private Cubifinito cubifinito = new Cubifinito();
    @Test
    public void test() {
        assertTrue("Error", cubifinito.esCubifinito(1));
        assertTrue("Error", cubifinito.esCubifinito(10));
        assertTrue("Error", cubifinito.esCubifinito(1243));
        assertTrue("Error", cubifinito.esCubifinito(87418));        
        assertFalse("Error", cubifinito.esCubifinito(513));
    }
    
}