package Zad1;

public class Student implements Comparable<Student>{
    private String nazwisko;
    private String imie;
    public Student(String nazwisko,String imie){
        this.nazwisko = nazwisko;;
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }
    public String toString() {
        return nazwisko + " " + imie ;
    }
    public boolean equals(Student o){
        if(this==null) return false;
        if(o instanceof Student){
            Student ob = (Student) o;
            if(imie == ob.getImie() && nazwisko == ob.getNazwisko()) return true;
        }
        return false;
    }
    public int compareTo(Student o) {
        return this.toString().compareTo(o.toString());
    }
}
