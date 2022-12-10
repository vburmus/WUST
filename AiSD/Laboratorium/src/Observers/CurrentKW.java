package Observers;

import Obseravable.Car;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CurrentKW implements Observer{
    public int HP;
    public Car carCond;
    private static double coef = 1.34;
    public CurrentKW(Car carCond){
        this.carCond = carCond;
        this.carCond.registerObserver(this);
    }
    public double kw(){
        return Math.round(HP*coef*100)/100;
    }
    public void display(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Plik.txt",true))) {
            bw.write("\n KW: " + kw());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, " Blad", "", JOptionPane.ERROR_MESSAGE);
        }

    }
    @Override
    public void update(int tiresCondition, int HP, String EngineType, int fuelLevel,int engineCapacity,int fuelCapacity) {
        this.HP = HP;
        display();
    }
}

