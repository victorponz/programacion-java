import java.util.*;
public class AddAll {
    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        l.add("uno");
        l.add("dos");
        l.add("tres");
        List<String> ll = new ArrayList<String>();
        ll.add("cuatro");
        ll.add("cinco");
        ll.add("seis");
        //Añadimos toda la lista l a la ll
        ll.addAll(l);
        System.out.println(ll);
    }
}
