public class Lychrel {
    private static boolean esCapicua(int numero) {
        String num = Integer.toString(numero);
        int left = 0, right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left) != num.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }
    private static int reverse(int numero){
        return Integer.parseInt(new StringBuilder().append((Integer.toString(numero))).reverse().toString());
    }
    public static int iteraciones(int numero){
        boolean salir = false;
        int iteraciones = 0;
        int n2;
        boolean capicua = false;
        while (!salir && !capicua) {
            iteraciones++;
            n2 = reverse(numero);
            numero += n2;
            salir = numero > 1_000_000_000;
            if (!salir) {
                capicua = esCapicua(numero);
            }
        }
        return (capicua ? iteraciones : -1);
    }
}
