package Zad1;

import java.util.Comparator;

public class CompareTytul implements Comparator<Ksiazka>
{

    public int compare(Ksiazka a1, Ksiazka a2)
    {
        return a1.getTytul().compareTo(a2.getTytul());
    }
}