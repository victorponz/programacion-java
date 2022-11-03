import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LychretTest {
    
    @Test
    public void test(){
        assertEquals(2,Lychrel.iteraciones(91));
        assertEquals(-1,Lychrel.iteraciones(196));
        assertEquals(-1,Lychrel.iteraciones(4994));
        assertEquals(4,Lychrel.iteraciones(5445));
    }
}
