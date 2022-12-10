package Metody;

import Card.Card;
import OneWayLinkedListWithHead.OneWayLinkedListWithHead;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Methods {
    public static void menu() {
        System.out.println("""
                -------------------------------------------------
                1. Utworzenie listy
                2. Wyświetlanie listy (karty zakryte drukuj jako parę nawiasów „( )”
                3. Wyświetlanie liczby elementów listy oraz ile jest kart zakrytych i ile odkrytych
                4. Wyświetlanie kart o podanej wartości
                5. Wyświetlanie kart o podanym kolorze
                6. Usuwanie kart zakrytych
                0. Wyjscie
                -------------------------------------------------""");
    }
    public static OneWayLinkedListWithHead<Card> utworzListe(){
        OneWayLinkedListWithHead<Card> deck = new OneWayLinkedListWithHead<Card>();
        Random randomNum = new Random();

        int value,color;
        value = randomNum.nextInt(0,15);
        color = randomNum.nextInt(3);
        while(value!=0){
            Card newCard = new Card(value,color);
            Iterator<Card> iterator = deck.iterator();
            while(iterator.hasNext()) {
                Card arrayCard = iterator.next();
                if (newCard.getWartosc() < arrayCard.getWartosc()) {
                    deck.add(deck.indexOf(arrayCard), newCard);
                    break;
                }
                else if(newCard.getWartosc() == arrayCard.getWartosc() && arrayCard.getKolor() > newCard.getKolor()) {
                    deck.add(deck.indexOf(arrayCard), newCard);
                    break;
                }
                else if(!iterator.hasNext()) {
                    deck.add(newCard);
                    break;
                }
            }

            if(deck.isEmpty())
                deck.add(newCard);

            value = randomNum.nextInt(15);
            color = randomNum.nextInt(4);
        }


        return deck;
    }
    public static void bezPowt(OneWayLinkedListWithHead<Card> array){
        boolean[] tab = new boolean[52];
        for(int i = 0; i < array.size();i++){
            if(array.get(i)!=null && array.get(i).isZnacznik() )
                switch (array.get(i).getKolor()){
                    case 0:
                        if(tab[array.get(i).getWartosc()-1]) {
                            array.remove(i);
                            i--;
                        }
                        else
                        tab[array.get(i).getWartosc()-1]= true;
                        break;
                    case 1:
                        if(tab[array.get(i).getWartosc()+12]) {
                            array.remove(i);
                        i--;
                        }
                        else
                            tab[array.get(i).getWartosc()+12] = true;

                        break;
                    case 2:
                        if(tab[array.get(i).getWartosc()+25]) {
                            array.remove(i);
                            i--;
                        }
                        else
                            tab[array.get(i).getWartosc()+25] = true;

                        break;
                    case 3:
                        if(tab[array.get(i).getWartosc()+38]) {
                            array.remove(i);
                            i--;
                        }
                        else
                            tab[array.get(i).getWartosc()+38] = true;

                        break;
                }
        }
    }
    public static void wyswietlListe(OneWayLinkedListWithHead<Card> arr){
        System.out.printf("|%10s|%10s|\n", "WARTOSC", "KOLOR");
        for(int i = 0; i <arr.size();i++)
            System.out.println(arr.get(i).toString());

    }
    public static void ileElementow(OneWayLinkedListWithHead<Card> array){
        System.out.println("Elementow - " + array.size());
        int sum = 0;
        for (int i = 0; i < array.size(); i++ )
            if(array.get(i).getWartosc()==14) sum++;
        System.out.println("Elementow zakrytych - " + sum);
        System.out.println("Elementow odkrytych - " + (array.size()-sum));
    }
    public static void wyswietlWgWartosci(OneWayLinkedListWithHead<Card> arr,int n){
        System.out.printf("%10s%5d\n|%10s|%10s|\n","WEDLUG WARTOSCI",n, "WARTOSC", "KOLOR");
        for(int i = 0; i <arr.size();i++){
            if(arr.get(i).getWartosc()==n)
            System.out.println(arr.get(i).toString());
        }
    }
    public static void wyswietlWgKoloru(OneWayLinkedListWithHead<Card> arr,int n){
        System.out.printf("%10s%5d\n|%10s|%10s|\n","WEDLUG KOLORU",n,"WARTOSC", "KOLOR");
        for(int i = 0; i <arr.size();i++){
            if(arr.get(i).getKolor()==n)
                System.out.println(arr.get(i).toString());
        }
    }
    public static void usuwanieZakrytych(OneWayLinkedListWithHead<Card> arr){
           for(int i = 0; i < arr.size();i++){
            if(arr.get(i).getWartosc()==14) {
                arr.remove(i);
                i--;
            }
        }
    }
}
