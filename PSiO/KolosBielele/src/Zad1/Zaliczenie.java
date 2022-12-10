package Zad1;

import java.util.TreeMap;

public class Zaliczenie implements Comparable<Zaliczenie>{
    private Student student;
    private TreeMap<String,Double> zaliczenie = new TreeMap<>();
    public  Zaliczenie(Student student){
        this.student = student;
    }
    public void dodacZaliczenie(String przedmiot, double ocena){
        zaliczenie.put(przedmiot,ocena);
    }

    public TreeMap<String, Double> getZaliczenie() {
        return zaliczenie;
    }

    public Student getStudent() {
        return student;
    }

    public void setZaliczenie(TreeMap<String, Double> zaliczenie) {
        this.zaliczenie = zaliczenie;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public int compareTo(Zaliczenie o) {
        return this.getStudent().compareTo(o.getStudent());
    }
}
