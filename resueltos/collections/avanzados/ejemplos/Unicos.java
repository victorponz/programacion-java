import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Unicos {
    public static void printUnique( String ... array) {
		List<String> list = new ArrayList<String>(Arrays.asList(array));
		Set<String> hashSet = new HashSet<String>(list);
		System.out.println(hashSet);
	}

	public static void main(String[] args) {

		printUnique("hola", "adios", "hola", "hola", "tres", "cuatro", "adios");
		
	}
}
