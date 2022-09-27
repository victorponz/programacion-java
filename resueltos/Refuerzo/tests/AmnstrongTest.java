
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class AmnstrongTest {
    private static Armstrong amstrong = new Armstrong();
    @Test
    public void test() {
        assertEquals(amstrong.armstrong(370), true);
        assertEquals(amstrong.armstrong(371), true);
        assertEquals(amstrong.armstrong(407), true);
        assertEquals(amstrong.armstrong(698), false);

    }

}
