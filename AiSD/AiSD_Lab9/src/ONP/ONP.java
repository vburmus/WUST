package ONP;

import Drzewo.BST;
import Drzewo.Node;
import Pomocnicze.ArrayStack;
import Pomocnicze.EmptyStackException;
import Pomocnicze.FullStackException;

public class ONP {


    private String wyrazenie;


    public ONP(String wyrazenie){
        this.wyrazenie = wyrazenie;
    }


    public static int priorytetZnakow(char c){
        if (c=='(')
            return 0;
        if (c=='+' || c=='-')
            return 1;
        if (c=='*' || c=='/')
            return 2;
        else
            return -1;
    }

    public static boolean czyOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    public String utworz() throws FullStackException, EmptyStackException {
        ArrayStack<Character> stos = new ArrayStack<>(wyrazenie.length());
        StringBuilder sb = new StringBuilder();
        StringBuilder wyjscie = new StringBuilder();
        for (int i=0; i<wyrazenie.length(); i++) {
            char element = wyrazenie.charAt(i);
            if (element>='0' && element <= '9') {
                sb.append(element);
            }
            else {
                if (!sb.isEmpty()) {
                    wyjscie.append(sb);
                    wyjscie.append(" ");
                    sb.delete(0, sb.length());
                }
                if (element=='(')
                    stos.push(element);
                if (element==')') {
                    while (stos.top()!='(') {
                        wyjscie.append(stos.pop());
                        wyjscie.append(" ");
                    }
                    if (stos.top()=='(')
                        //zeby posunac topIndex
                        stos.pop();
                }
                if (czyOperator(element)) {
                    while (!stos.isEmpty() && czyOperator(stos.top()) && priorytetZnakow(element)<= priorytetZnakow(stos.top())) {
                        wyjscie.append(stos.pop());
                        wyjscie.append(" ");
                    }
                    stos.push(element);
                }
            }
        }
        if (!sb.isEmpty()) {
            wyjscie.append(sb);
            wyjscie.append(" ");
        }
        while (!stos.isEmpty()) {
            wyjscie.append(stos.pop());
        }
        return wyjscie.toString();
    }

    public static BST utworzDrzewoZONP(String wyrazenie) throws FullStackException, EmptyStackException {
        ArrayStack<Node> stos = new ArrayStack<>(wyrazenie.length());
        String [] onp = wyrazenie.split("[\s]");

        for (String e : onp) {
            if (e.equals("+") || e.equals("-") || e.equals("*") || e.equals("/") || e.equals("%")) {
                Node n = new Node(e);
                n.setRight(stos.pop());
                n.setLeft(stos.pop());
                stos.push(n);
            }
            else {
                stos.push(new Node(e));
            }
        }
        return new BST(stos.pop());
    }
}
