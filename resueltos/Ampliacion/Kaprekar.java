import java.util.Arrays;

public class Kaprekar {
    public static int descendente(int num){
        StringBuilder s =  new StringBuilder();
        //Convertimos a StringBuilder para poder hace reverse
        String inverso = s.append((Integer.toString(num))).reverse().toString();
        //Rellenamos con 0's por la izquierda
        return Integer.parseInt(String.format("%1$-4s", inverso).replace(' ', '0'));
    }
    public static int ascendente(int num){
        char[] numChar = Integer.toString(num).toCharArray();
        Arrays.sort(numChar);
        return Integer.parseInt(new String(numChar));
    }
    public static int iterations(int num){
        int ascendente, descendente;
        int contador = 1;
        final int KAPREKAR =  6174;

        while (contador < 8 ){
            ascendente = ascendente(num);
            descendente = descendente(ascendente);
            num =  descendente - ascendente;
            if (num == KAPREKAR){
                break;
            }
            contador++;
        }
        return contador;

    }
    public static void main(String[] args) {
        System.out.println(iterations(1998));
    }
}
