import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class LastnameFrequencySorted {

	public static void main(String[] args) throws IOException{
		BufferedReader inputFile = null;
		PrintWriter oututFile = null;
		String line;
		HashMap<String, Integer> map = new HashMap<String, Integer>(100000);
		try {
			inputFile = new BufferedReader(new FileReader(new File("files/LastnameFrequencies.csv")));
			oututFile = new PrintWriter(new File("files/SortedLastnameFrequencies.csv"));
			while ((line = inputFile.readLine())!=null) {
				String[] s = line.split(",");
				if (s.length==2) {
					map.put(s[0], Integer.parseInt((s[1].replaceAll("\\.", ""))));
				}
								
			}
			//
			List<String> list = new ArrayList<String>(map.keySet());
			Collections.sort(list);
			for (String s: list) {
				System.out.println(s);
				String line2 = s+","+map.get(s);
				oututFile.println(line2);
			}
		} finally {
			inputFile.close();
			oututFile.close();
		}


	}

}
