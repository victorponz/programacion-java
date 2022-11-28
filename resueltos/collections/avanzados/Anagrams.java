import java.io.*;
import java.util.*;

public class Anagrams {

	public static void main(String[] args) throws IOException {
		int minGroupSize = 5;

        // Read words from file and put them 
		 // into a simulated multimap
        Map<String, List<String>> m = new 
				HashMap<String, List<String>>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("files/spanish-dict.txt"));
            String word;
            while ((word=reader.readLine())!=null) {
                String alpha = alphabetize(word);
                List<String> l = m.get(alpha);
                if (l == null)
                    m.put(alpha, l=new ArrayList<String>());
                l.add(word);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        } finally {
        	reader.close();
        }

        // Print all permutation groups above size threshold
        for (List<String> l : m.values())
            if (l.size() >= minGroupSize)
                System.out.println(l.size() + ": " + l);
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }


}