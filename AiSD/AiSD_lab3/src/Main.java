import Card.Card;
import OneWayLinkedListWithHead.OneWayLinkedListWithHead;

import java.util.Scanner;

import static Metody.Methods.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        menu();
        OneWayLinkedListWithHead<Card> list = new OneWayLinkedListWithHead<Card>();
    list = utworzListe();
    bezPowt(list);
      String n;
        while (!(n = scan.nextLine()).equals("0")) {

            switch (n) {
                case "1":
                        list = utworzListe();
                    menu();
                    break;
                case "2":
                    bezPowt(list);
                    wyswietlListe(list);
                    menu();
                    break;
                case "3":
                        ileElementow(list);
                    menu();
                    break;
                case "4":
                    System.out.println("Wprowadz wartosc:");
                    int w = scan.nextInt();
                        wyswietlWgWartosci(list,w);
                    menu();
                    break;
                case "5":
                    System.out.println("Wprowadz kolor:");
                    int k = scan.nextInt();
                    wyswietlWgKoloru(list,k);
                    menu();
                    break;
                case "6":
                    usuwanieZakrytych(list);
                    menu();
                    break;

            }
        }
    }
    }

