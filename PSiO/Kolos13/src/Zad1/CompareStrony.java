package Zad1;

import java.util.Comparator;

public class CompareStrony implements Comparator<Ksiazka>
{

    public int compare(Ksiazka a1, Ksiazka a2)
    {
        return a1.getLiczbaStron() - (a2.getLiczbaStron());
    }
}