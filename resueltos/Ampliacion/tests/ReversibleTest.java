import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class ReversibleTest {

    @Test
    public void test(){
        assertTrue("ERROR", Reversible.esReversible(63));
        assertTrue("ERROR", Reversible.esReversible(43));
        assertFalse("ERROR", Reversible.esReversible(1010));

    }
    
}
