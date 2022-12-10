package com.company;

import java.lang.reflect.Array;
import java.util.Random;

public class Main {

    /*
Napisz program, w którym utwórz n-elementową tablicę jednowymiarową liczb typu int.
Wygeneruj losowe wartości tablicy (wykorzystaj klasę Random).

Zdefiniuj i zaprezentuj metody statyczne:

- wyświetlanie wszystkich elementów tablicy

- wyszukanie wartości maksymalnej w tablicy

- obliczanie średniej arytmetycznej

- obliczanie ile jest liczb parzystych
    */
    final static int n = 3;

    public static void fillArr(int [] Tab){
        for(int i = 0; i < n; i++){
            Tab[i] = (int) (Math.random()*10);
        }
    }
    public static void wyswietlArr(int [] Tab) {
        for (int i = 0; i < n; i++) {
            System.out.println("Tab[" + i + "] = " + Tab[i]);
        }
    }

    public static void srednia(int [] Tab){
        double sArytm = 0;
        for (int i = 0; i < n; i++) {
            sArytm = sArytm + Tab[i];
        }
        System.out.printf("%s %1.3f %n","Srednia arytmetyczna = ", (sArytm/n));
    }
    public static void maxWartosc(int [] Tab){
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(Tab[i]>max) max = Tab[i];
        }
        System.out.println("Wartosc maksymalna = " + max);
    }
    public static void ileParzystych(int [] Tab){
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(Tab[i] % 2 == 0) count++;
        }
        System.out.println("Liczb parzystych - " + count);
    }
    public static void main(String[] args) {
        int [] Tab = new int [n];
        fillArr(Tab);
        wyswietlArr(Tab);
        maxWartosc(Tab);
        srednia(Tab);
        ileParzystych(Tab);
    }
}


}