import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class Tarea implements Comparable<Tarea>{
    int prioridad, duracion;
    Tarea(int p, int d) {
        this.prioridad = p;
        this.duracion = d;
    }
    @Override
    public int compareTo(Tarea other){
        if (this.prioridad == other.prioridad) return this.duracion - other.duracion;
        
        return other.prioridad - this.prioridad;
    }
}

public class Felipe {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);

        LinkedList<Tarea> tareas = new LinkedList<>();
        
        while (true) {
            int n = s.nextInt();
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                tareas.add(new Tarea(s.nextInt(), s.nextInt()));
            }
            Collections.sort(tareas);
            for (Tarea tarea : tareas) {
                System.out.println(tarea.prioridad + " " + tarea.duracion);
            }
            System.out.println("---");
            tareas.clear();
        }

    }

}
