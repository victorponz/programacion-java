
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuienEmpiezaTest {

    private QuienEmpieza quienEmpieza = new QuienEmpieza();

    @Test
    public void test(){
        assertEquals(quienEmpieza.jugar(4, 1), 1);
        assertEquals(quienEmpieza.jugar(7, 2), 4);
        assertEquals(quienEmpieza.jugar(10, 2), 4);

    }
    
}
