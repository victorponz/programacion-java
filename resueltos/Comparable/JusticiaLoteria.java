import java.util.*;

/**
 * @author Rubén Saiz
 * 23/10/2019
 */

class Localidad implements Comparable<Localidad>{
    int vecinos, premios;
    Localidad(int v, int p){
        vecinos = v;
        premios = p;
    }
    public String toString() {
        return vecinos + " " + premios;
    }
    @Override
    public int compareTo(Localidad other){
        if (this.vecinos == other.vecinos) return other.premios - this.premios;
        return other.vecinos - this.vecinos;
    }
}

public class JusticiaLoteria {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int localidades;
        boolean justo;
        ArrayList<Localidad> listaLocalidades = new ArrayList<>();
       
        while (true) {

            localidades = s.nextInt();
            if (localidades == 0) break;

            justo = true;
            for (int i = 0; i < localidades; i++)
                listaLocalidades.add(new Localidad(s.nextInt(), s.nextInt()));

            Collections.sort(listaLocalidades);

            for (int i = 0; i < listaLocalidades.size() - 1 && justo; i++) {
                Localidad actual = listaLocalidades.get(i);
                Localidad next   = listaLocalidades.get(i + 1);
                if (actual.vecinos == next.vecinos)
                    justo = actual.premios >= next.premios;
                else
                    justo = actual.premios > next.premios;
            }

            listaLocalidades.clear();
            System.out.println( (justo) ? "SI" : "NO" );
        }

    }

}
