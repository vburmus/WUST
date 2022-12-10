import java.io.Serializable;

public abstract class Employee implements Serializable {

    protected String surname;
    protected String name;
    protected long pesel;
    protected String emplacement;
    protected int experience;

    public Employee(){
        surname = " Dudek";
        name = " Pichwa";
        pesel = 0401214440;
        emplacement = "matematyk";
        experience = 10;
    }
    public Employee(String surname, String name, long pesel, String emplacement, int experience){
        this.surname = surname;
        this.name = name;
        this.pesel = pesel;
        this.emplacement = emplacement;
        this.experience = experience;
    }

    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public int getExperience() {
        return experience;
    }
    public long getPesel() {
        return pesel;
    }
    public String getEmplacement() {
        return emplacement;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPesel(long pesel) {
        this.pesel = pesel;
    }
    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void showEmployee(){
        System.out.printf("|%-10s|%-10s|%-15d|%-10s|%10d|%10.2f|\n",surname,name,pesel,emplacement,experience,salary());
    }
    public String toString(){
        return String.format( "%s,%s,%d,%s,%d", surname , name , pesel , emplacement , experience);
    }

    public abstract double salary();


}
