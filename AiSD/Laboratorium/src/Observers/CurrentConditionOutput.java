package Observers;

import AdditionActions.*;

import Obseravable.Car;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CurrentConditionOutput implements Observer, DisplayEngineType, DisplayTiresInKm {
    private String engineType;
    private int tiresCondition;
    private int HP;
    private int fuelLevel;
    private int engineCapacity;
    private int fuelCapacity;
    private Car carCond;
    public CurrentConditionOutput(Car carCond){
        this.carCond = carCond;
        this.carCond.registerObserver(this);
    }
    @Override
    public void displayTires() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Plik.txt",true))) {
            bw.write("\n Gumy wystarchy na: " + tiresCondition*100 + " km");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, " Blad", "", JOptionPane.ERROR_MESSAGE);
        }
    }
    @Override
    public void outEngineType() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Plik.txt",true))) {
            bw.write("\n Typ silnika: " + engineType) ;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, " Blad", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void display(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Plik.txt",true))) {
            bw.write("\n Stan biezacy: " + HP + "k.m.;  Stan gumy: " + tiresCondition + "%  , pojemnosc: "+ engineCapacity + "l.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        displayTires();
        outEngineType();

    }
    @Override
    public void update(int tiresCondition, int HP, String engineType, int fuelLevel,int engineCapacity,int fuelCapacity) {
        this.HP = HP;
        this.tiresCondition = tiresCondition;
        this.fuelLevel = fuelLevel;
        this.engineCapacity = engineCapacity;
        this.fuelCapacity = fuelCapacity;
        this.engineType = engineType;
        display();
    }
}
