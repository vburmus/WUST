package Zad1.Interface_1;

import java.util.Random;

public class Petrol implements Engine {
    Random generator = new Random();
    int petrolCondition;

    public int engineCondition(){
        petrolCondition = generator.nextInt(101);  ;
        return petrolCondition;
    }
    public void changeEngine(){

        System.out.println("Silnik zostal zmieniony na benzynowy !");

        petrolCondition = 100;
    }
}
