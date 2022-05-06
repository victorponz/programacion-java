
public class Ejemplo33 {
	public static void main(String[] args) {
		
		int n1 = 1;
		int n2= 1;
		int fibonacci;
		
		for (int i = 0; i < 40; i++) {
			fibonacci = n1 + n2;
            //Como queremos realizar una operación con decimales,
            //hacemos un cast a double
			System.out.println((double)fibonacci / (double)n2);
			n1 = n2;
			n2 = fibonacci;
		}

	}

}