import java.util.Arrays;

public class Vampiros {
    public boolean esVampiro(int num){
        String n = Integer.toString(num);
        int primerNumero, segundoNumero;
        int primerTermino, segundoTermino;
        
        for (int i = 0; i < n.length(); i++){
            primerNumero = Integer.parseInt("" + n.charAt(i));
            for (int j = 0; j < n.length(); j++) {
                //Combinarlo con el resto de dígitos excepto él mismo
                if (j == i) continue;
                
                segundoNumero = Integer.parseInt("" + n.charAt(j));
                primerTermino = Integer.parseInt(Integer.toString(primerNumero) +  Integer.toString(segundoNumero));

                //Comprobar que el número es divisible entre primerTermino
                if (num % primerTermino == 0){
                    //Es un candidato
                    //Comprobar que es menor que 100
                    segundoTermino = num / primerTermino;
                    if (segundoTermino < 100){
                        //Ahora comprobar que los dígitos son distintos a primerTermino
                        char[] n2 = (Integer.toString(segundoTermino) + Integer.toString(primerTermino)).toCharArray();
                        Arrays.sort(n2);
                        char[] n3= n.toCharArray();
                        Arrays.sort(n3);
                        if (Arrays.equals(n2, n3))
                            return true;
                    }
                   
                }
            }
        }
        return false;
    }
}
