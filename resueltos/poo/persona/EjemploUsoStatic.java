//Fichero EjemploUsoStatic.java

public class EjemploUsoStatic {
   private static int contador = 0;
   private int numeroSerie;

   static { System.out.println ("Iniciador \"static\" que se ejecuta al cargar la clase"); }
   
   { System.out.println ("Iniciador que se ejecuta al crear un objeto"); }
   
   public EjemploUsoStatic () {
      contador++;
      numeroSerie = contador;
      System.out.println ("Se acaba de crear el objeto número " + numeroSerie);
   }

   public static int nombreObjectesCreats () {
      return contador;
   }
   
   public static void main(String args[]) {
    EjemploUsoStatic d1 = new EjemploUsoStatic();
    EjemploUsoStatic d2;
      d2 = new EjemploUsoStatic();
      System.out.println("Número de serie de d1 = " + d1.numeroSerie);
      System.out.println("Número de serie de d2 = " + d2.numeroSerie);
      System.out.println("Objetos creados: " + nombreObjectesCreats());
   }
}