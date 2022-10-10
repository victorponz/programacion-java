public class LuckyNumber {
    public static int luckyNumber(int aaaa, int mm, int dd){
     
        int cifra = aaaa + mm + dd;
        int suma = 0;

        // sumar los dígitos de la cifra resultante

        for (int i = 1; i <= 4; i++) {
            suma = suma + (cifra % 10);
            cifra = cifra / 10;
        }

        if (cifra == 0 && suma > 9) {
            // reducir lo dos digitos de la suma a uno solo
            cifra = suma;
            suma = cifra % 10;
            cifra = cifra / 10;
            suma = suma + cifra;
        }
       
        return suma;
    }
    public static void main(String[] args) {
        int aaaa, mm, dd;

        aaaa = 1970;
        mm = 7;
        dd = 12;

        System.out.println("Tu número de la suerte es: " + luckyNumber(aaaa, mm, dd));
    }

}
