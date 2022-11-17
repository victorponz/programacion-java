import java.util.Arrays;

public class Kaprekar {
    public static int descendente(int num){
        char[] numChar = Integer.toString(num).toCharArray();
        String res = "";
        Arrays.sort(numChar);
        for (int i = numChar.length - 1; i >= 0; i--) {
            res += numChar[i];            
        }
        //Poner 0 a la derecha si hace falta
        for (int i = numChar.length; i <= 4; i++)
            res += "0";

        return Integer.parseInt(res);
        //Otra forma de hacerlo sin bucle:
        // StringBuilder s =  new StringBuilder();
        // //Convertimos a StringBuilder para poder hace reverse
        // String inverso = s.append((Integer.toString(num))).reverse().toString();
        // //Rellenamos con 0's por la izquierda
        // return Integer.parseInt(String.format("%1$-4s", inverso).replace(' ', '0'));
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
            descendente = descendente(num);
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
