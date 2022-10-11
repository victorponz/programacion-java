import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class Anyo2013Test {

    private Anyo2013 anyo2013 = new Anyo2013();

    @Test
    public void test(){
        assertEquals(anyo2013.primeroSerie(1990), 1988);
        assertEquals(anyo2013.primeroSerie(2015), 2013);
        assertEquals(anyo2013.primeroSerie(2025), 2020);        

    }
    
}
