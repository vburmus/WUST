public class EmployeeFT extends Employee{

    private double position;
    private double rate;

    public EmployeeFT(String surname, String name, long pesel, String emplacement,int experience, double position, double rate){
        super(surname, name, pesel, emplacement, experience);
        this.position = position;
        this.rate = rate;
    }
    public EmployeeFT(){
        surname = "Hordiyenko";
        name = "Jan";
        pesel = 12212144401L;
        emplacement = "Informatyk";
        experience = 6;
        rate = 1000;
        position = 0.3;
    }

    public double getRate() {
        return rate;
    }
    public double getPosition() {
        return position;
    }
    public void setPosition(double position) {
        this.position = position;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }

    public double salary(){
        return rate*position;
    }
    public String toString(){
        return super.toString() + String.format("%f,%f,%10.2f", position,rate,salary());
    }


}
