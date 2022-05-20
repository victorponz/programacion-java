import java.util.ArrayList;
public class Altura {
    public static int numeroAlumnos(){
        return Utilidades.leerEntero("Cuántos alumnos? ");
    }
    public static double calcularMedia(ArrayList<Double> alturas){
        Double suma = 0D;
        for (Double altura: alturas){
            suma+= altura;
        }
        return suma / alturas.size();
    }
    public static int calcularAlumnosAlturaSuperior(ArrayList<Double> alturas, Double media){
        int total = 0;
        for (Double altura: alturas){
            if (altura > media)
                total++;
        }
        return total;
    }
    public static int calcularAlumnosAlturainferior(ArrayList<Double> alturas, Double media){
        int total = 0;
        for (Double altura: alturas){
            if (altura < media)
                total++;
        }
        return total;
    }
        
    public static void mostrarResultados(ArrayList<Double> alturas){
        Double media = calcularMedia(alturas);
        int superior = calcularAlumnosAlturaSuperior(alturas, media);
        int inferior = calcularAlumnosAlturainferior(alturas, media);
        System.out.println("Las alturas son las siguientes:");
        for(Double altura: alturas)
            System.out.print(altura + ", ");
        System.out.println("");
        System.out.printf("La altura media es %f%n", media);
        System.out.printf("El número de alummos con una altura superior es %d%n", superior);
        System.out.printf("El número de alummos con una altura inferior es %d%n", inferior);
    }
    public static ArrayList<Double> leerAlturas(int numAlumnos){
        ArrayList<Double> alturas = new ArrayList<Double>(); 
        System.out.printf("Introduzca las %d alturas", numAlumnos);
        for (int i = 1; i <= numAlumnos; i++){
            alturas.add(Utilidades.leerDoble(""));
        }
        return alturas;
    }
    public static void main(String[] args) {
        int numAlumnos = numeroAlumnos();
        ArrayList<Double> alturas = leerAlturas(numAlumnos);
        mostrarResultados(alturas);
    }

}