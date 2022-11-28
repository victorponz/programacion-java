import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class LastNameFrequency {

	private static Map<String,Integer> generate() throws IOException {
		Map<String,Integer> map = new HashMap<String,Integer>();
		BufferedReader reader = null;
		
		reader = new BufferedReader(new FileReader("files/LastnameFrequencies.csv"));
		String line;
		String[] elements;
		while ((line = reader.readLine())!=null) {
			elements = line.split(",");
			if (elements.length==2) {
				map.put(elements[0], 
						Integer.parseInt(elements[1].replaceAll("\\.", "")));
			}
		}
		reader.close();
		
		return map;
	}
	public static void main(String[] args) throws IOException  {
		
		Map<String,Integer> map  = generate();
		// Read lastnames from keyboard
		String lastname;
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Enter lastname: ");
			lastname = input.nextLine().toUpperCase();
			if (!lastname.equals("")) {
				if (map.get(lastname) == null) {
					System.out.println("last name does not exist");
				} else {
					System.out.println("frequency = " + map.get(lastname));
				}
			}
			
		} while (!lastname.equals(""));
		
		input.close();

	}

}
