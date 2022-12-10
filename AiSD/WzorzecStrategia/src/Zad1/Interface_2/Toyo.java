package Zad1.Interface_2;

import java.util.Random;

public class Toyo implements Tires{
    Random generator = new Random();
    int toyoCondition;

    public void changeTires() {
        System.out.println("Guma zostala zmieniomna na Toyo !");
        toyoCondition = 100;
    }
    public int tiresCondition() {
        toyoCondition = generator.nextInt(101);
        return toyoCondition;
    }
}
