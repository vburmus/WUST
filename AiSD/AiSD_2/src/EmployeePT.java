public class EmployeePT extends Employee {
    private double rate;
    private int hours;

    public EmployeePT(String surname, String name, long pesel, String emplacement,int experience, int hours, double rate){
        super(surname, name, pesel, emplacement, experience);
        this.hours = hours;
        this.rate = rate;
    }
    public EmployeePT(){
        surname = "Sas";
        name = "Jan";
        pesel = 34012144401L;
        emplacement = "Informatyk";
        experience = 6;
        rate = 1000;
        hours = 30;
    }

    public double getRate() {
        return rate;
    }
    public int getHours() {
        return hours;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }

    public double salary(){
        return rate*hours;
    }
    public String toString(){
        return super.toString() + String.format("%d,%f,%10.2f" , hours,rate,salary());
    }

}
