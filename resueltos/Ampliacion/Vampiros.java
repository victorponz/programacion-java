public class Vampiros {
    public static boolean esVampiro(int num){
        String n = Integer.toString(num);
        int primerNumero, segundoNumero;
        int primerTermino, segundoTermino;
        
        for (int i = 0; i < n.length(); i++){
            primerNumero = Integer.parseInt("" + n.charAt(i));
            for (int j = 0; j < n.length(); j++) {
                if (j == i) continue;
                segundoNumero = Integer.parseInt("" + n.charAt(j));
                primerTermino = Integer.parseInt(Integer.toString(primerNumero) +  Integer.toString(segundoNumero));
                System.out.println(primerTermino);
                //Comprobar que el número es divisible entre primerTermino
                if (num % primerTermino == 0){
                    //Es un candidato
                    //Comprobar que es menor que 100
                    segundoTermino = num / primerTermino;
                    if (segundoTermino < 100){
                        //Ahora comprobar que los dígitos son distintos a primerTermino
                        String n2 = Integer.toString(segundoTermino);
                        
                        System.out.println("sÍ" + segundoTermino);
                    }
                   
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        boolean b = esVampiro(1260);
    }
}
