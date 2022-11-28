import java.io.*;
import java.util.*;

public class CountCountries {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Map<String,Integer> map = new HashMap<String, Integer>();

		BufferedReader reader = new BufferedReader(new FileReader("files/Colfuturo-Seleccionados.csv"));
		String line;
		String[] splittedLine;
		
		line = reader.readLine();
		while ((line = reader.readLine())!=null) {
			splittedLine = line.split(",");
			//el 7º del csv guarda el país del alumno
			Integer freq = map.get(splittedLine[6]);
			map.put(splittedLine[6],freq==null ? 1: freq+1);
		}
		reader.close();
		for (String s: map.keySet()) {
			System.out.println(s + " : " + map.get(s));
		}
	}
}