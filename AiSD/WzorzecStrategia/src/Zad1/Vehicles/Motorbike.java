package Zad1.Vehicles;
import Zad1.Vehicle.*;

import java.util.Scanner;

public  class Motorbike extends Vehicle {

    protected String motoType;

    public Motorbike() {
        vehicleColor = null;
        vehicleEngine = 0;
        vehicleModel = null;
        vehicleName = null;
        vehicleSuspension = null;
        motoType = null;
    }
    public Motorbike(String vehicleName, String vehicleModel, double vehicleEngine, String vehicleColor, String vehicleSuspension, String motoType) {
        super(vehicleName, vehicleModel, vehicleEngine, vehicleColor, vehicleSuspension);
        this.motoType = motoType;
    }

    public String getMotoType() {
        return motoType;
    }
    public void setMotoType(String motoType) {
        this.motoType = motoType;
    }

    public void engineCheck() {
        Scanner read = new Scanner(System.in);
        if (this.engineOperation.engineCondition() > 30) {
            System.out.println("Czy chcialbys zmienic  silnik?");
            System.out.println("[1] Tak");
            System.out.println("[2] Nie");
            switch (read.nextInt()) {
                case 1:
                    this.engineOperation.changeEngine();
                case 2:
                    System.out.println("Silnik nie zmieniony!");
                default:
                    System.out.println("Blad!");
            }
        }

    }
    public void tiresCheck() {
        Scanner read = new Scanner(System.in);
        if (tiresOperation != null) {
            if (tiresOperation.tiresCondition() < 900) {
                System.out.println("Guma ma mniej niz 90% od stanu poczatkowego. Czy chcialbys zmienic gume?");
                System.out.println("[1] Tak");
                System.out.println("[2] Nie");
                switch (read.nextInt()) {
                    case 1:
                        this.tiresOperation.changeTires();
                        break;
                    case 2:
                        System.out.println("Guma nie zmieniona!");
                        break;
                    default:
                        System.out.println("Blad!");
                        break;
                }
            }
        } else {
            System.out.println("Zainstaluj gume !");
        }
    }
    public String toString()    {
        return getNum() + " Motocykl "+ super.toString()  + " " + motoType;
    }
}