public class SumarBinario {
	public static String sumaBinario(String cad1, String cad2){
	    String numeroLargo, numeroCorto;
        //Los números pueden ser de distinta longitud
        if (cad1.length() > cad2.length()) {
            numeroLargo = cad1;
            numeroCorto = cad2;
        }
        else {
            numeroLargo = cad2;
            numeroCorto = cad1;
        }
        //Caculamos en cuántos dígitos se diferencian
        int diferenciaDigitos = numeroLargo.length() - numeroCorto.length();
        String resultado = "";
        int acarreo = 0;
        int a, b;
        
        //Empezamos por el último dígito del número más largo
        for (int i = numeroLargo.length() -1; i >= 0; i--) {
            if (i - diferenciaDigitos >= 0) {
                //El segundo dígito a sumar es el correspondiente al número corto
                b = Integer.parseInt("" + numeroCorto.charAt(i - diferenciaDigitos));
            }
            else {
                //En este caso el segundo dígito es siempre 0, porque ya no quedan
                b = 0; 
            }
            
            //El primer número a sumar siempre es el del número más largo
            a = Integer.parseInt("" + numeroLargo.charAt(i));
            //Sumamos y comprobamos el acarreo
            int suma = acarreo + a + b;

            resultado = ((suma % 2 == 0) ? "0" : "1") + resultado; 
            acarreo = (suma > 1 ? 1 : 0) ;
            /* Lo de arriba es una forma resumida de:
            * if (suma == 0) {
                acarreo = 0;
                resultado = 0 + resultado;
              }
              else if (suma == 1) {
                acarreo = 0;
                resultado = 1 + resultado;
              }
              else if (suma == 2) {
                acarreo = 1;
                resultado =  0 + resultado;
              }
              else if (suma == 3) {
                acarreo = 1;
                resultado = 1 + resultado;
              }
                */
            
        }
	      //Si la última suma ha producido acarreo le añadimos un 1 al resultado
	      if (1 == acarreo) {
	    	  resultado = "1" + resultado;
	      }
	      return resultado;
	}
	
	public static void main(String[] args) {		
		String cad1 = Utilidades.leerCadena("Introduce el primer número binario");
		String cad2 = Utilidades.leerCadena("Introduce el segundo número binario");
		System.out.println("La suma es: " + sumaBinario(cad1,cad2));
	}
}