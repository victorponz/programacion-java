import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EvaluarExpresion {
    private boolean esNumero(String num){
        //Vamos a suponer que la expresión aritmética está bien formada
        return Character.isDigit(num.charAt(0));
    }
    public String pila(String expresionAritmetica) {
        String[] expresion = expresionAritmetica.split(" ");
        Stack<Integer> pila;
        int n1, n2 = 0;

        pila = new Stack<>();

        for (int i = 0; i < expresion.length; i++) {
            if (esNumero(expresion[i])) {
                int num = Integer.parseInt(expresion[i]);
                pila.push(num);
            } else {
                switch (expresion[i]) {
                    case "+":
                        n2 = pila.pop();
                        n1 = pila.pop();
                        pila.push(n1 + n2);
                        break;
                    case "-":
                        n2 = pila.pop();
                        n1 = pila.pop();
                        pila.push(n1 - n2);
                        break;
                    case "/":
                        try {
                            n2 = pila.pop();
                            n1 = pila.pop();
                            pila.push(n1 / n2);
                        } catch (ArithmeticException e) {
                            return "ERROR";
                        }
                        break;
                    case "*":
                        n2 = pila.pop();
                        n1 = pila.pop();
                        pila.push(n1 * n2);
                        break;
                }
            }
        }
        return String.valueOf(pila.pop());

    }

    public String cola(String expresionAritmetica) {

        String[] expresion = expresionAritmetica.split(" ");
        Queue<Integer> cola;
        int n1, n2 = 0;
        cola = new LinkedList<>();

        for (int i = 0; i < expresion.length; i++) {
            if (esNumero(expresion[i])) {
                int num = Integer.parseInt(expresion[i]);
                cola.add(num);
            } else {
                switch (expresion[i]) {
                    case "+":
                        n2 = cola.poll();
                        n1 = cola.poll();
                        cola.add(n1 + n2);
                        break;
                    case "-":
                        n2 = cola.poll();
                        n1 = cola.poll();
                        cola.add(n1 - n2);
                        break;
                    case "/":
                        try {
                            n2 = cola.poll();
                            n1 = cola.poll();
                            cola.add(n1 / n2);
                        } catch (ArithmeticException e) {
                            return "ERROR";
                        }
                        break;
                    case "*":
                        n2 = cola.poll();
                        n1 = cola.poll();
                        cola.add(n1 * n2);
                }
            }
        }

        return String.valueOf(cola.poll());
    }
}
