import java.util.HashSet;

public class Increment {
    public static HashSet<Integer> increment( HashSet<Integer> set) {
		HashSet<Integer> newSet = new HashSet<Integer>();
	    for (Integer i: set)
	         newSet.add(i+1);
	    return newSet;
	}

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<Integer>(); 
		set.add(1);
		set.add(4);
		set.add(6);
		set.add(8);
		set.add(2);
		System.out.println(set);
		set = increment(set);
	    System.out.println(set);
		
	}    
}
