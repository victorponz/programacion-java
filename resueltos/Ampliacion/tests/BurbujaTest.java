import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;
public class BurbujaTest {
 
    @Test
    public void test(){
        int[] a1 = {3, 56, 4, 5, 8, 98, 45, 220, 1};
        int[] a2 = {1, 3, 4, 5, 8, 45, 56, 98, 220};
        Burbuja.ordenar(a1);
        assertArrayEquals(a2, a1);
    } 
}
