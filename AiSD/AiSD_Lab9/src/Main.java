import Drzewo.BST;
import ONP.ONP;
import Pomocnicze.EmptyQueueException;
import Pomocnicze.EmptyStackException;
import Pomocnicze.FullStackException;

import java.util.Scanner;

public class Main {
    public static boolean sprawdzNawiasy(String s){
        int count1 = 0;

        for(int i = 0 ;i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i)==')')
                count1++;

        }
        if(count1%2!=0)
            return false;
        return true;
    }
    public static void main (String [] args) throws FullStackException, EmptyStackException, EmptyQueueException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wyrażenie arytmetyczne (pamiętaj o nawiasach!)");
        String wyrazenie ="12+(3*2+6)";
        //12+(3*2+6)
        //(10+2)*(5+15)

        if(sprawdzNawiasy(wyrazenie)) {
            ONP onp = new ONP(wyrazenie);
            String wyrazenieONP = onp.utworz();
            BST drzewo = ONP.utworzDrzewoZONP(wyrazenieONP);
            drzewo.wartoscWyrazenia();
            drzewo.wyswietlInfiks();
            drzewo.wyswietlPostfiks();
            drzewo.liczbaLisci();
            drzewo.liczbaWezlow();
            drzewo.wysokoscDrzewa();
            drzewo.przechodzenieWszerz();
        }
        else{
            System.out.println("Blad");
        }
        }
}
