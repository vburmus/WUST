import java.util.Objects;

public class Student implements  Comparable<Student>{
    private String surname;
    private String name;
    public Student(String surname, String name){
        this.surname = surname;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String toString() {
        return  surname + " " + name ;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof Student){
            Student std = (Student) o;
            if (name == std.name && surname == std.surname) return true;
            else return false;
        }
        return false;
    }


    public int compareTo(Student o) {
        return (this.toString()).compareTo(o.toString());
    }
}

