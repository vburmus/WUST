import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Lista imp {
    ArrayList<Zaliczenie> listaZaliczen = new ArrayList<>();

    public void addStudent(String name, String surname) {
        Student student = new Student(surname, name);
        Zaliczenie zaliczenie = new Zaliczenie(student);
        listaZaliczen.add(zaliczenie);
    }

    public void wpisanieZaliczenia(Student student, String przedmiot, double ocena) {
        for (int i = 0; i < listaZaliczen.size(); i++) {
            if (student.equals(listaZaliczen.get(i).getStudent())) {
                listaZaliczen.get(i).addZaliczenie(przedmiot, ocena);
            }
        }
    }

    public void wyswietlStudentow() {

        Collections.sort(listaZaliczen);
        for (int i = 0; i < listaZaliczen.size(); i++) {
            System.out.println(listaZaliczen.get(i).getStudent());
        }
    }



}
