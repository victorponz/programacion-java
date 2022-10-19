public class Burbuja {
    public static void ordenar(int[] numeros) {
        int aux;      
        for (int i = 0; i < numeros.length; i++) {            
            for (int j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j] > numeros[j+1]) {
                    aux = numeros[j];
                    numeros[j] = numeros[j+1];
                    numeros[j+1] = aux;
                }
            }
        }
    }

}
