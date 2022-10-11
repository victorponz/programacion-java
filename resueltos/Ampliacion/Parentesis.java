import java.util.LinkedList;

public class Parentesis {

    public boolean esBalancenado(String cadena){
        boolean balanced;
        LinkedList<Character> cola = new LinkedList<>();
        balanced = true;
        char c;

        for (int i = 0; i < cadena.length(); i++) {
            c = cadena.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                cola.addLast(c);
            }
            else if (c == ']' || c == '}' || c == ')') {
                if (cola.isEmpty()) {
                    return false;
                }
                else {
                    Character removed = cola.removeLast();
                    switch (c) {
                        case '}':
                            balanced = removed == '{';
                            break;
                        case ')':
                            balanced = removed == '(';
                            break;
                        case ']':
                            balanced = removed == '[';
                            break;
                        default:
                            balanced = false;
                    }
                    if (!balanced)
                        return false;
                }
            }
        }
        return cola.isEmpty();
    }

}
