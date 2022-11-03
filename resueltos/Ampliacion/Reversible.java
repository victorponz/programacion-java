public class Reversible {
    public static boolean esReversible(int num) {
        int alReves =  Integer.parseInt(new StringBuilder().append((Integer.toString(num))).reverse().toString());
        //Si tienen distinto número de dígitos no continúo
        if (Integer.toString(num).length() != Integer.toString(alReves).length()){
            return false;
        }
        int suma = num + alReves;
        char[] digitos = Integer.toString(suma).toCharArray();
        for (int i = 0; i < digitos.length; i++) {
            if (Integer.parseInt(""+digitos[i]) % 2 == 0){
                return false;
            }
        }
        return true;
    }

}
