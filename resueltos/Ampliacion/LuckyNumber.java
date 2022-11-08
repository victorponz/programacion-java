public class LuckyNumber {
    public static int luckyNumber(int aaaa, int mm, int dd){
     
        String digitos = String.valueOf(aaaa) + String.valueOf(mm) + String.valueOf(dd);
        int luckyNumber = 0;

        // sumar los dígitos de la cifra resultante
        for (int i = 0; i < digitos.length(); i++) {
            luckyNumber += Integer.parseInt("" + digitos.charAt(i));
        }

        if (luckyNumber > 9) {
            // reducir los dos digitos de la suma a uno solo
            digitos = String.valueOf(luckyNumber);
            luckyNumber = Integer.parseInt("" + digitos.charAt(0)) + Integer.parseInt("" + digitos.charAt(1));
        }

        return luckyNumber;
    }
    public static void main(String[] args) {
        int aaaa, mm, dd;

        aaaa = 1971;
        mm = 9;
        dd = 3;

        System.out.println("Tu número de la suerte es: " + luckyNumber(aaaa, mm, dd));
    }

}

