public class CuantasMeLlevo {
    public int calcular(int num1, int num2) {
        String str1 = Integer.toString(num1);
        String str2 = Integer.toString(num2);
        int[] n1, n2;
        n1 = new int[Math.max(str1.length(), str2.length())];
        n2 = new int[Math.max(str1.length(), str2.length())];
        for (int i = 0; i < str1.length(); i++) {
            n1[i] = Integer.parseInt(str1.charAt(str1.length() - 1 - i) + "");
        }
        for (int i = 0; i < str2.length(); i++) {
            n2[i] = Integer.parseInt(str2.charAt(str2.length() - 1 - i) + "");
        }
        int ans = 0, carry = 0;
        for (int i = 0; i < n1.length; i++) {
            if ((n1[i] + n2[i] + carry) >= 10) {
                ans++;
                carry = (n1[i] + n2[i] + carry) / 10;
            } else
                carry = 0;
        }

        return ans;
    }
}
