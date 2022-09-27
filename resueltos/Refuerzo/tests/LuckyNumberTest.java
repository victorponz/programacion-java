
import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class LuckyNumberTest {

    private LuckyNumber luckyNumber = new LuckyNumber();

    @Test
    public void test() {
        assertEquals(luckyNumber.luckyNumber(1970, 7, 12), 9);
        assertEquals(luckyNumber.luckyNumber(1971, 9, 3), 3);
    }

}

