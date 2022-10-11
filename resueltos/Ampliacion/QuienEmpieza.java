import java.util.ArrayList;

public class QuienEmpieza {
    public int jugar(int jugadores, int saltos){
        int eliminar;
        ArrayList<Integer> juego;
        juego = new ArrayList<>();

        for (int i = 1; i <= jugadores; i++) juego.add(i);

        eliminar = 0;
        while (juego.size() > 1) {
            eliminar += saltos;
            eliminar %= juego.size();
            juego.remove(eliminar);
        }

        return juego.get(0);
    }

}
