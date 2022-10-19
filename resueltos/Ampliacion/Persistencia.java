public class Persistencia {

    public static int calcular(int num){
        int iteraciones = 0;
        String aux;

        aux = String.valueOf(num);
        while (aux.length() != 1) {
            iteraciones++;
            num = Integer.parseInt(""+aux.charAt(0));
            for (int i = 1; i < aux.length(); i++) {
                num *= Integer.parseInt(""+aux.charAt(i));
            }
            aux = String.valueOf(num);
        }
        return iteraciones;
    }

}
