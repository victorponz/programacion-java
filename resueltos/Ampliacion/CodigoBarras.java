public class CodigoBarras {
    public boolean check(String codigo) {
        int calculo, codigoControl, len, n;

        len = codigo.length();

        if (len < 14) {
            calculo = 0;

            for (int i = len - 2; i >= 0; i--) {
                n = Integer.parseInt("" + codigo.charAt(i));
                if (i % 2 != 0) {
                    calculo += n * 3;
                } else {
                    calculo += n;
                }
            }

            codigoControl = Integer.parseInt("" + codigo.charAt(len - 1));

            if ((codigoControl + calculo) % 10 == 0) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }
}