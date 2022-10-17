public class Orden {
    public static int comprobar(int[] numeros) {
        int orden = 0;
        boolean comparado = false;
        for (int i = 0; i < numeros.length - 1; i++) {
            if (numeros[i+1] > numeros[i]){
                //Si ya hemos comparado y cambia el orden
                if (orden != 1 && comparado){
                    orden = 3;
                    break;
                }
                orden = 1;
                comparado = true;

            }else  if (numeros[i+1] < numeros[i]){
                //Si ya hemos comparado y cambia el orden
                if (orden != 2 && comparado){
                    orden = 3;
                    break;
                }
                orden = 2;
                comparado = true;
            }
        }
        
        return orden; 
    }
}