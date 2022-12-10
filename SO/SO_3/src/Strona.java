import java.util.Objects;

public class Strona {

    private int id;
    private int nextOdwolanie;

    public Strona(int id){
        this.id = id;
        this.nextOdwolanie = 0;

    }

    //* get set

    public int getNextOdwolanie() {
        return nextOdwolanie;
    }
    public int getId() {
        return id;
    }
    public void setNextOdwolanie(int nextOdwolanie) {
        this.nextOdwolanie = nextOdwolanie;
    }


    //* metody pomocnicze

    @Override
    public String toString() {
        return  ""+id;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null ) return false;
        if(o instanceof Strona) {
            Strona strona = (Strona) o;
            if(this.id == strona.id)
                return true;
        }
        return false;

    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
