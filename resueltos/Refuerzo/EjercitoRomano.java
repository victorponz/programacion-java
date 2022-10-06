public class EjercitoRomano {

    public int cuantosEscudos(int ejercito) {
        int total, temp;

        total = 0;
        while (true) {
            if (ejercito == 0)
                break;
            if (ejercito < 4) {
                total += ejercito * 5;
                break;
            }
            temp = (int) Math.sqrt(ejercito);
            ejercito -= (temp * temp);
            total += (temp - 2) * (temp - 2); // interior
            total += (((temp - 2) * 4) * 2) + 12; // exterior + esquinas
        }
        return total;
    }

}