public class ContarPalabras {
    public int contar(String cadena){
        int palabras = 0;
		int largo = cadena.length();
		boolean  buscoBlanco = false;
		for (int i = 0;  i < largo; i++){
			if (buscoBlanco){
				if (cadena.charAt(i) == ' '){
					buscoBlanco = !buscoBlanco;
				}
			}else{
				if (cadena.charAt(i) != ' '){
					buscoBlanco = !buscoBlanco;
					palabras++;
				}
			}

		}
        return palabras;
    }
}
