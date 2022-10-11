import java.util.Set;
import java.util.TreeSet;

public class Cubifinito {

    public boolean esCubifinito(int num){
        int  digito;
        String temp;
        int suma;
        Set<Integer> set;
        set = new TreeSet<>();
        set.add(num);

        if (num == 1) 
            return true;
        else {
            while (true) {

                suma = 0;
                temp = String.valueOf(num);
                for (int i = temp.length()-1; i >= 0; i--) {
                    digito = Integer.parseInt(""+temp.charAt(i));
                    suma += digito * digito * digito;
                }

                if (suma == 1)  {
                    return true;
                }else if (set.contains(suma)) {
                    //La suma se repite, ya no es cubifinito
                    return false;
                }else {
                    //Lo añadimos porque si vuelve a dar la misma cifra ya no es cubifinito
                    set.add(suma);
                    num = suma;
                }
            }

        }
    }
   }
