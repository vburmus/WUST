import java.util.HashMap;
public class Nawiasy {
    public static boolean nawiasyZrownowazone(String wyrazenie) throws FullStackException, EmptyStackException {
        char[] list = wyrazenie.toCharArray();
        HashMap<Character, Character> nawias = new HashMap<>();
        nawias.put(')', '(');
        nawias.put('}', '{');
        nawias.put(']', '[');
        ArrayStack<Character> stos = new ArrayStack<>(list.length);
        for (int i = 0; i < list.length; i++) {
            char symbol = list[i];
            if (nawiasOtwierajacy(symbol)) {
                stos.push(symbol);
            } else if (stos.isEmpty()) {
                return false;
            } else if (nawiasZamykajacy(symbol)) {
                char stosSymbol = stos.pop();
                if (nawias.get(symbol) != stosSymbol) {
                    return false;
                }
            }
        }
        if (stos.isEmpty())
            return true;
        else
            return false;
    }
    public static boolean nawiasOtwierajacy(char ch) {
        if ((ch == '[' || ch == '{' || ch == '(')) {
            return true;
        } else
            return false;
    }
    public static boolean nawiasZamykajacy(char ch) {
        if ((ch == ']' || ch == '}' || ch == ')')) {
            return true;
        } else
            return false;
    }
}
