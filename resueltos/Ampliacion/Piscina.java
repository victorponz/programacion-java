public class Piscina {

    public int quienGana(int piscinaA, int barrenyoA, int pierdeA, int piscinaB, int barrenyoB, int pierdeB){
        int yo     = getViajes(piscinaA, barrenyoA, pierdeA);
        int vecino = getViajes(piscinaB, barrenyoB, pierdeB);

        /*if (yo == -1 && vecino == -1) {
            yo = 0;
            vecino = 0;
        }*/

        if (yo == vecino) 
            return 0;
        else 
            return (yo > vecino ? -1 : 1);

    } 
    private static int getViajes(int piscina, int barreno, int pierde) {
        if (pierde >= barreno && barreno < piscina) return Integer.MAX_VALUE;
        else if (barreno >= piscina) return 1;
        int viajes = 0, aux, rest;
        while (piscina > 1) {
            aux = piscina / barreno;
            rest = aux * pierde;
            piscina = (piscina - (aux * barreno)) + rest;
            viajes += aux;
            if (piscina != 0 && piscina <= barreno) {
                viajes++; 
                break;
            }
        }
        return viajes;
    }


}
