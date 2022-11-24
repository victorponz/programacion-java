//https://gyansetu-core-java-for-java.gitbook.io/project/collections-framework-part-2/sets
// Java code for demonstrating union, intersection and difference 
// on Set 
import java.util.HashSet;
import java.util.Set; 
public class SetExample 
{ 
	public static void main(String args[]) 
	{ 
		Set<Integer> a = new HashSet<Integer>(); 
		a.add(1);
		a.add(3);
		a.add(2);
		a.add(4);
		a.add(8);
		a.add(9);
		a.add(0);
		Set<Integer> b = new HashSet<Integer>(); 
		b.add(1);
		b.add(3);
		b.add(7);
		b.add(5);
		b.add(4);
		b.add(0);
		b.add(7);
		a.add(5);
		
		// To find union 
		Set<Integer> union = new HashSet<Integer>(a); 
		union.addAll(b); 
		System.out.print("Union of the two Set"); 
		System.out.println(union); 

		// To find intersection 
		Set<Integer> intersection = new HashSet<Integer>(a); 
		intersection.retainAll(b); 
		System.out.print("Intersection of the two Set"); 
		System.out.println(intersection); 

		// To find the symmetric difference 
		Set<Integer> difference = new HashSet<Integer>(a); 
		difference.removeAll(b); 
		System.out.print("Difference of the two Set"); 
		System.out.println(difference); 
	} 
} 
