import java.util.Scanner;

public class Metody {
    public static boolean czyPalindrom(String wyrazenie) throws FullStackException, EmptyStackException {
        ArrayStack<Character> stos = new ArrayStack<>(wyrazenie.length());
        ArrayStack<Character> revStos = new ArrayStack<>(wyrazenie.length());
        char[] list = wyrazenie.toCharArray();
        for (int i = 0; i < list.length; i++) {
            char symbol = list[i];
            stos.push(symbol);
            revStos.push(symbol);
        }
        revStos.odwracanie();
        while (!revStos.isEmpty()){
            if(stos.pop() != revStos.pop())
                return false;
        }
        return true;
    }
    public static void przenies1(ArrayStack<Character> arr, ArrayStack<Character> arr2) throws EmptyStackException, FullStackException {
        ArrayStack<Character> pomoc  = new ArrayStack<>(arr.size());
        while(!arr.isEmpty())
            pomoc.push(arr.pop());
        pomoc.odwracanie();
        while(!pomoc.isEmpty())
            arr2.push(pomoc.pop());

    }
    public static void przenies2(ArrayStack<Character> s, ArrayStack<Character> t) throws EmptyStackException, FullStackException {
        if (!s.isEmpty()) {
            char item = s.pop();
            t.push(item);
            przenies2(s, t);
        }
    }
    public static void  sprawdzicNawiasy(String wyrazenie) throws EmptyStackException, FullStackException {
        if(Nawiasy.nawiasyZrownowazone(wyrazenie)){
            System.out.println("Nawiasy zrownowazone");
        }else{
            System.out.println("Nawiasy nie zrownowazone");
        }
    }
    public static String odczyt(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Wprowadz wyrazenie:");
        return scan.next();
    }
    public static void  sprawdzicPalindrom(String wyrazenie) throws EmptyStackException, FullStackException {

        if (Metody.czyPalindrom(wyrazenie)) {
            System.out.println("Palindrom");
        } else {
            System.out.println("Nie palindrom");
        }
    }
    public static void metoda1(String wyrazenie) throws FullStackException, EmptyStackException {
        char[] list = wyrazenie.toCharArray();
        ArrayStack<Character> stos = new ArrayStack<>(wyrazenie.length());
        ArrayStack<Character> stos2 = new ArrayStack<>(wyrazenie.length());
        ArrayStack<Character> stos3 = new ArrayStack<>(wyrazenie.length());
        ArrayStack<Character> stosCopy = new ArrayStack<>(wyrazenie.length());
        for (int i = 0; i < list.length; i++) {
            char symbol = list[i];
            stos.push(symbol);
            stosCopy.push(symbol);
        }
        Metody.przenies1(stos,stos2);
        System.out.println("S2");
        while(!stos2.isEmpty()){
            System.out.println(stos2.pop());
        }
        Metody.przenies2(stosCopy,stos3);
        System.out.println("S3");
        while(!stos3.isEmpty()){
            System.out.println(stos3.pop());
        }
    }
}
