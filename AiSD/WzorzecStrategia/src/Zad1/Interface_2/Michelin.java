package Zad1.Interface_2;

import java.util.Random;

public class Michelin implements Tires{
    Random generator = new Random();
    int michelinCondition;

    public void changeTires() {
        System.out.println("Guma zostala zmieniona na Michelin !");
        michelinCondition = 100;
    }
    public int tiresCondition() {
        michelinCondition = generator.nextInt(101);
        return michelinCondition;
    }
}
