package Zad1.Vehicles;
import Zad1.Vehicle.*;

import java.util.Scanner;

public  class Car extends Vehicle {

    protected String carType;

    public Car() {
        vehicleColor = null;
        vehicleEngine = 0;
        vehicleModel = null;
        vehicleName = null;
        vehicleSuspension = null;
        carType = null;
    }
    public Car(String vehicleName, String vehicleModel, double vehicleEngine, String vehicleColor, String vehicleSuspension, String carType) {
        super(vehicleName, vehicleModel, vehicleEngine, vehicleColor, vehicleSuspension);
        this.carType = carType;
    }

    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void engineCheck() {
        Scanner read = new Scanner(System.in);
        if (engineOperation != null) {
            if (engineOperation.engineCondition() < 50) {
                System.out.println("Silnik ma mniej niz 50% od stanu poczatkowego. Czy chcialbys zmienic  silnik?");
                System.out.println("[1] Tak");
                System.out.println("[2] Nie");
                switch (read.nextInt()) {
                    case 1:
                        this.engineOperation.changeEngine();
                        break;
                    case 2:
                        System.out.println("Silnik nie zmieniony!");
                        break;
                    default:
                        System.out.println("Blad!");
                        break;
                }
            }
        } else {
            System.out.println("Zainstaluj silnik !");
        }

    }
    public void tiresCheck() {
        Scanner read = new Scanner(System.in);
        if (tiresOperation != null) {
            if (tiresOperation.tiresCondition() < 70) {
                System.out.println("Guma ma mniej niz 70% od stanu poczatkowego. Czy chcialbys zmienic gume?");
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
    public String toString() {
        return getNum() + " Samochod " + super.toString() + " " + carType;
    }
}
