public class Anyo2013 {
    public int primeroSerie(int num){
        int temp_num;
        boolean repetido, temp;
        int left;
        repetido = getState(String.valueOf(num));

        temp = repetido;
        temp_num = num;

        left = 0;
        while (temp == repetido) {
            temp = getState(String.valueOf(temp_num));
            if (temp == repetido) {
                temp_num--;
                left++;
            }
        }

        left--;
        
        return (num - left);
    }
    static boolean getState(String n) {
        for (int i = 0; i < n.length() - 1; i++) {
            for (int j = i + 1; j < n.length(); j++) {
                if (n.charAt(i) == n.charAt(j)) return true;
            }
        }
        return false;
    }
}
