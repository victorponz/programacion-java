import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Duplicates {
	
	public static void printDuplicates( String ... array) {
		List<String> list = new ArrayList<String>(Arrays.asList(array));
		Set<String> hashSet = new HashSet<String>(list);
		
		for (String s: hashSet) {
			list.remove(s);
		}
		Set<String> duplicates = new HashSet<String>(list);
		System.out.println(duplicates);
	}

	public static void main(String[] args) {
			printDuplicates("hola", "adios", "hola", "hola", "tres", "cuatro", "adios");
		
	}

}
