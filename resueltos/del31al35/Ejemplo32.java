public class Ejemplo32 {
	public static void main(String[] args) {
		int fibonacci= 0;
		
		int n1 = 1;
		int n2 = 1;
		System.out.printf("1 %n1 %n");
		for (int i = 0; i < 40; i++) {
			fibonacci = n1 + n2;
			System.out.println(fibonacci);
			n1 = n2;
			n2 = fibonacci;
		}
	}

}