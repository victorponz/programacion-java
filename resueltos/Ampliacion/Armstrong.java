public class Armstrong {
    public static boolean armstrong(int numero) {
        int cifra1 = numero / 100;
        int cifra2 = (numero - 100 * cifra1) / 10;
        int cifra3 = numero - 100 * cifra1 - 10 * cifra2;
        double dat = Math.pow(cifra1, 3) + Math.pow(cifra2, 3) + Math.pow(cifra3, 3);

        return dat == numero;
    }

    public static void main(String[] args) {
        //370, 371, 407, 100
    }
}
