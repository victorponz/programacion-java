package del1al5;
//Un programa que calcula y muestra el área de un cuadrado de lado 5
public class Ejemplo3 {

    public static void main(String[] args) {

        int lado = 5;
        int area = lado * lado;

        System.out.println("El área del cuadrado es: " + area);
        // O también
        System.out.printf("El área del cuadrado es: %d %n", area);
    }

}