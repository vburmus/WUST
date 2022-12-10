package Observers;
import Obseravable.Car;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CurrentFuelLevel implements Observer{
    public int fuelLevel;
    public int fuelCapacity;
    private Car carCondition;
    public CurrentFuelLevel(Car carCondition){
        this.carCondition = carCondition;
        this.carCondition.registerObserver(this);
    }
    public int fuel(){
        return(fuelCapacity*fuelLevel/100);
    }
    public void display(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Plik.txt",true))) {
            bw.write("\n Pozostalo paliwa: " + fuel() +" l.\n----------------------------------------------------------------------");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, " Blad", "", JOptionPane.ERROR_MESSAGE);
        }

    }
    @Override
    public void update(int tiresCondition, int HP, String EngineType, int fuelLevel,int engineCapacity,int fuelCapacity) {
        this.fuelLevel = fuelLevel;
        this.fuelCapacity = fuelCapacity;
        display();
    }
}
