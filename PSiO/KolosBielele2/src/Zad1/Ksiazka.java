package Zad1;

public class Ksiazka {
    private Autor autor;
    private String tytul;
    private int liczbaStron;
    private static int numer = 0;
    public Ksiazka(Autor autor, String tytul,int liczbaStron){
        this.autor = autor;
        this.tytul = tytul;
        this.liczbaStron = liczbaStron;
        this.numer = numer++;

    }

    public int getNumer() {
        return numer;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getLiczbaStron() {
        return liczbaStron;
    }

    public String getTytul() {
        return tytul;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setLiczbaStron(int liczbaStron) {
        this.liczbaStron = liczbaStron;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }


    public String toString() {
        return autor + " " + tytul + " " + liczbaStron + " " + numer ;
    }
}
