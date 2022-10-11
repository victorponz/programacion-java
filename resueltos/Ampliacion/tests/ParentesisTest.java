import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParentesisTest {

    private Parentesis parentesis = new Parentesis();

    @Test
    public void test() {
        assertTrue("Error", parentesis.esBalancenado("[{[(hola)]}]"));
        assertFalse("Error", parentesis.esBalancenado("{(hola)]}]"));
    }

}

