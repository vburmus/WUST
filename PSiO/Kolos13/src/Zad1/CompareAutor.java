package Zad1;

import java.util.Comparator;

public class CompareAutor implements Comparator<Ksiazka>
{

    public int compare(Ksiazka a1, Ksiazka a2)
    {
        return a1.getAutor().compareTo(a2.getAutor());
    }
}