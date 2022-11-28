import java.util.*;

public class Frequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> m = new HashMap<String, Integer>();
        String s;
        System.out.println("Write some words:");
        // Initialize frequency table
        do{
            s = input.nextLine();
            Integer freq = m.get(s);
            m.put(s, (freq == null) ? 1 : freq + 1);
        }while(!s.equals(""));

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
        input.close();
    }
}