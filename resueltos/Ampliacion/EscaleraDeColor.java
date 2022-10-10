import java.util.Arrays;

public class EscaleraDeColor {
    public  int escalera(int c1, int c2, int c3, int c4){
        final int AS = 14;
        int [] ordenadas = {c1, c2, c3, c4};
        int carta = 0;
        
        Arrays.sort(ordenadas);

        //Si no hay nigún hueco
        if (ordenadas[3] - ordenadas[0] == 3){
            //la más alta posible será añadiendo una al final, siempre que no sea ya un As
            if (ordenadas[3] != AS){
                carta = ordenadas[3] + 1;
            }else{
                carta = ordenadas[0] - 1;
            }
        }else if (ordenadas[3] - ordenadas[0] == 4){
            //Sólo se podrá hacer escalera si hay un hueco de sólo una carta
            for (int i = 0; i < ordenadas.length - 1; i++) {
               if (ordenadas[i + 1] - ordenadas[i] == 2){
                    return ordenadas[i] + 1;
                }
            }
        }
        return carta;
    }
}