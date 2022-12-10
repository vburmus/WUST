package Zad1.Interface_1;
import java.util.Random;

public class Diesel implements Engine {
    Random generator = new Random();
    int dieseCondition;

    public int engineCondition(){
      dieseCondition = generator.nextInt(101);
        return dieseCondition;
    }
    public void changeEngine(){
        System.out.println("Silnik zostal zmieniony na dieselowy !");
       dieseCondition = 100;
    }
}
