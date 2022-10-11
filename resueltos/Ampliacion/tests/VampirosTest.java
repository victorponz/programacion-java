import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VampirosTest {

    private Vampiros vampiros = new Vampiros();

    @Test
    public void test() {
        assertTrue("Error", vampiros.esVampiro(1260));
        assertTrue("Error", vampiros.esVampiro(1395));
        assertTrue("Error", vampiros.esVampiro(1435));
        assertTrue("Error", vampiros.esVampiro(1530));
        assertTrue("Error", vampiros.esVampiro(1827));
        assertTrue("Error", vampiros.esVampiro(2187));
        assertTrue("Error", vampiros.esVampiro(6880));
        assertFalse("Error", vampiros.esVampiro(6881));

    }

}

