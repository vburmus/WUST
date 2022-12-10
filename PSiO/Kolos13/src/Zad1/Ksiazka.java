package Zad1;

public class Ksiazka {
    private Autor autor;
    private String tytul;
    private int liczbaStron;
    private String wydawnictwo;

    public Ksiazka(Autor autor, String tytul,String wydawnictwo,int liczbaStron){
        this.autor = autor;
        this.tytul = tytul;
        this.liczbaStron = liczbaStron;
        this.wydawnictwo = wydawnictwo;
    }


    public String getWydawnictwo() {
        return wydawnictwo;
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


    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
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

    public boolean equals(Object o) {
        if(this==null) return false;
        if(o instanceof Autor){
            Ksiazka ob = (Ksiazka) o;
            if(this.getWydawnictwo() == ob.getWydawnictwo())return  true;
        }
        return false;
    }

    public String toString() {
        return String.format("%s%15s%15s%15d",autor, tytul , wydawnictwo, liczbaStron) ;
    }
}
