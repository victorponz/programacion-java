import java.rmi.server.RemoteRef;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Kid implements Comparable<Kid>{
    int bueno, peso;
    Kid(int b, int p) {
        bueno = b;
        peso  = p;
    }
    public String toString() {
        return bueno + " " + peso;
    }
    @Override
    public int compareTo(Kid other){
        if (this.bueno == other.bueno) return other.peso - this.peso;
        return this.bueno - other.bueno;
    }
}

public class NinosBuenos {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        int ninyos;
        ArrayList<Kid> listaNinyos = new ArrayList<>();
        while (true) {

            ninyos = s.nextInt();
            if (ninyos == 0) break;

            for (int i = 0; i < ninyos; i++) {
                int b = s.nextInt();
                int p = s.nextInt();
                listaNinyos.add(new Kid(b, p));
            }

            Collections.sort(listaNinyos);

            for (int i = listaNinyos.size() - 1; i >= 0; i--)
                System.out.println(listaNinyos.get(i));

            listaNinyos.clear();
            System.out.println();
        }

    }

}
