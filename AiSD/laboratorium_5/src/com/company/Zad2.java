package com.company;

import java.lang.reflect.Array;
import java.util.Random;

public class Zad2 {

        /*
Napisz program, w którym utwórz n-elementową tablicę jednowymiarową liczb typu int.
Wygeneruj losowe wartości tablicy (wykorzystaj klasę Random).

Zdefiniuj i zaprezentuj metody statyczne:

- wyświetlanie wszystkich elementów tablicy

- wyszukanie wartości maksymalnej w tablicy

- obliczanie średniej arytmetycznej

- obliczanie ile jest liczb parzystych
        */

        //zmienne
      static class array {
          static int n;
          static int [] Tab;
          //konstruktor
          public array(int n){
              this.n = n;
              for(int i = 0; i < n; i++){
                  this.Tab[i] = (int) (Math.random()*10);
              }
          }
          //Metody
          public static void wyswietl(){
              for(int i = 0; i <= n; i++ ){
                  System.out.println("Tab[" + i + "] = " + Tab[i]);

              }
          }

    }
    public static void main(String[] args) {
        array array1 = new array(4);
        array1.wyswietl();

    }
}