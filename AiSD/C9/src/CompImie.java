public class CompImie implements Comparator<Pracownik>{


    public int compare(Pracownik ob1, Pracownik ob2) {
        return ob1.imie.compareTo(ob2.imie);
    }

}
