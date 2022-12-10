package Zad1.Vehicle;

import Zad1.Interface_1.Diesel;
import Zad1.Interface_1.Engine;
import Zad1.Interface_1.Petrol;
import Zad1.Interface_2.Michelin;
import Zad1.Interface_2.Tires;
import Zad1.Interface_2.Toyo;

import java.io.Serializable;

public abstract class Vehicle implements Serializable {

    protected static int numer;
    protected int num;
    protected String vehicleName;
    protected String vehicleModel;
    protected double vehicleEngine;
    protected String vehicleColor;
    protected String vehicleSuspension;
    protected Engine engineOperation;
    protected Tires tiresOperation;
    protected int condition;

    public Vehicle(){

        num = numer++;
        vehicleName = null;
        vehicleModel = null;
        vehicleColor = null;
        vehicleEngine = 0;
        vehicleSuspension = null;

    }
    public Vehicle(String vehicleName, String vehicleModel, double vehicleEngine, String vehicleColor, String vehicleSuspension){
        numer++;
        this.num = numer;
        this.vehicleName = vehicleName;
        this.vehicleModel = vehicleModel;
        this.vehicleEngine = vehicleEngine;
        this.vehicleSuspension = vehicleSuspension;
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }
    public String getVehicleName() {
        return vehicleName;
    }
    public double getVehicleEngine() {
        return vehicleEngine;
    }
    public String getVehicleColor() {
        return vehicleColor;
    }
    public String getVehicleSuspension() {
        return vehicleSuspension;
    }
    public Engine getEngineOperation() {
        return engineOperation;
    }
    public Tires getTiresOperation() {
        return tiresOperation;
    }
    public int getNum() {
        return num;
    }
    public static int getNumer() {
        return numer;
    }
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
    public void setVehicleEngine(double vehicleEngine) {
        this.vehicleEngine = vehicleEngine;
    }
    public void setVehicleSuspension(String vehicleSuspension) {
        this.vehicleSuspension = vehicleSuspension;
    }
    public void setEngineOperation(Engine engineOperation) {
        this.engineOperation = engineOperation;
    }
    public void setTiresOperation(Tires tiresOperation) {
        this.tiresOperation = tiresOperation;
    }
    public static void setNumer(int numer) {
        Vehicle.numer = numer;
    }
    public void setNum(int num) {
        this.num = num;
    }

    abstract public void engineCheck();
    abstract public void tiresCheck();
    public void installEngine(int n) {

            switch (n) {
                case 1:
                    engineOperation = new Diesel();
                    System.out.println("Diesylowy silnik zostal zainstalowany");
                    condition = engineOperation.engineCondition();
                    break;
                case 2:
                    engineOperation = new Petrol();
                    System.out.println("Benzynowy silnik zostal zainstalowany");
                    condition = engineOperation.engineCondition();
                    break;
                default:
                    System.out.println("Blad!");
                    break;
            }

    }
    public void uninstallEngine(){
            if(engineOperation!=null) {
            engineOperation = null;
            System.out.println("Silnik zostal usuniety !");
            }else{
                System.out.println("Nie ma silnika!");
            }
            }
    public void installTires(int n) {
        switch (n) {
            case 1:
                tiresOperation = new Michelin();
                System.out.println("Guma michelin zostala zainstalowana");
                condition = tiresOperation.tiresCondition();
                break;
            case 2:
                tiresOperation = new Toyo();
                System.out.println("Guma toyo zostala zainstalowana");
                condition = tiresOperation.tiresCondition();
                break;
            default:
                System.out.println("Blad!");
                break;
        }
    }
    public void uninstallTires(){
        if(tiresOperation!=null){
        tiresOperation = null;
        System.out.println("Guma zostala usunieta !");
    }else{
        System.out.println("Nie ma silnika!");
    }
    }



    public String toString(){
             return  vehicleName + " " + vehicleModel + " " + vehicleEngine + " " + vehicleColor ;
         }


}
