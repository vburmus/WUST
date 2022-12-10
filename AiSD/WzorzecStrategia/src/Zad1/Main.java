package Zad1;

import Zad1.Vehicle.Vehicle;
import Zad1.Vehicles.Car;
import Zad1.Vehicles.Motorbike;

import java.io.*;
import java.util.Scanner;

public class Main {
     static Vehicle[] vehicleTab = new Vehicle[9];

     public static void insertVehicles(){
         vehicleTab[free()] = new Car("BMW","4-series",3.0,"czarny","sport","coupe");
         vehicleTab[free()] = new Motorbike("BMW","GS",1.2,"bialy","comfort","turystyczny");
         System.out.println("\nWstawiono\n");
         System.out.println("____________________________________________________________________________________");

     }
     public static void outputVehicles(){
         for(int i = 0; i < vehicleTab[0].getNumer(); i++){
             if(vehicleTab[i]!=null){
                 System.out.println(vehicleTab[i].toString());
             }
         }
         System.out.println("____________________________________________________________________________________");

     }
     public static void checkEngineByNumer(){
         Scanner reader = new Scanner(System.in);
         System.out.println("Jaki pojazd chcesz sprawdzic?");
         int changeByNumer = reader.nextInt();
         vehicleTab[changeByNumer-1].engineCheck();
         System.out.println("____________________________________________________________________________________");

     }
     public static void installEngineByNumer( ){
         Scanner reader = new Scanner(System.in);
         System.out.println("Jaki pojazd chcesz zmienic?");
         int installByNumer = reader.nextInt();
         System.out.println("Jaki silnik chcesz wstawic(1 - diesel, 2 - benzyna)?");
         int whichEngine = reader.nextInt();
         System.out.println("Wpisz numer pojazdu:");
         vehicleTab[installByNumer-1].installEngine(whichEngine);
         System.out.println("____________________________________________________________________________________");

     }
     public static void uninstallEngineByNumer(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Silnik jakiego pojazdu chcesz usunac?");
        int uninstallByNumer = reader.nextInt();

        vehicleTab[uninstallByNumer-1].uninstallEngine();
        System.out.println("____________________________________________________________________________________");

    }
     public static void checkTiresByNumer(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Gumu jakiego pojazdu chcesz sprawdzic?");
        int check = reader.nextInt();
        vehicleTab[check-1].tiresCheck();
        System.out.println("____________________________________________________________________________________");


    }
     public static void installTiresByNumer(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Jaki pojazd chcesz zmienic?");
        int installByNumer = reader.nextInt();
        System.out.println("Jaka gume chcesz ustawic(1-michelin,2-toyo)?");
        int whichTires = reader.nextInt();
        vehicleTab[installByNumer-1].installTires(whichTires);
        System.out.println("____________________________________________________________________________________");

    }
     public static void uninstallTiresByNumer( ){
        Scanner reader = new Scanner(System.in);

        System.out.println("Gume jakiego pojazdu chcesz usunac?");
        int uninstallByNumer = reader.nextInt();
        vehicleTab[uninstallByNumer-1].uninstallTires();
        System.out.println("____________________________________________________________________________________");

    }
     public static int free(){
        for (int i = 0; i < vehicleTab.length;i++){
            if(vehicleTab[i] == null)
                return i;
        }
        return -1;
    }
     public static void createNewVehicle() {
        Scanner read = new Scanner(System.in);
        String name;
        String model;
        double engineCapacity;
        String color;
        String suspension;
        String typ;
        System.out.println("Wybierz co chcesz utworzyc:");
        System.out.println("[1] Samochod");
        System.out.println("[2] Motocykl");
        int numVechicle = read.nextInt();
        read.nextLine();
        System.out.println("Wpisz marke:");
        name = read.nextLine();
        System.out.println("Wpisz model:");
        model = read.nextLine();
        System.out.println("Wpisz pojemnosc:");
        engineCapacity = read.nextDouble();
        System.out.println("Wpisz kolor:");
        read.nextLine();
        color = read.nextLine();
        System.out.println("Wpisz zawieszenie:");
        suspension = read.nextLine();
        System.out.println("Wpisz typ:");
        typ = read.nextLine();
        int index = free();
        if(index!=-1) {
            switch (numVechicle) {
                case 1:

                    vehicleTab[index] = new Car(name, model, engineCapacity, color, suspension, typ);
                    System.out.println("Samochod zostal utworzony!");

                    break;
                case 2:

                        vehicleTab[free()] = new Motorbike(name, model, engineCapacity, color, suspension, typ);
                        System.out.println("Motocykl zostal utworzony!");
                    break;
                default:
                    System.out.println("Blad!");
                    break;
            }
        } else
            System.out.println("Nie ma wolnego miejsca!");

        System.out.println("____________________________________________________________________________________");
    }
     public static void countOfCars(){
         int count = 0;
             for(int i = 0; i < vehicleTab[0].getNumer();i++)
                 if(vehicleTab[i] instanceof Car) count++;
             System.out.println("Ilosc samochodow - " + count);
        System.out.println("____________________________________________________________________________________");

    }
     public static void countOfMoto(){
        int counter = 0;
        for(int i = 0; i < vehicleTab[0].getNumer();i++)
            if(vehicleTab[i] instanceof Motorbike) counter++;
        System.out.println("Ilosc motocyklow - " + counter);
        System.out.println("____________________________________________________________________________________");

    }
    public static void write(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("vehicles.ser"))){
            for(int i =0; i < vehicleTab[0].getNumer();i++ )
                oos.writeObject(vehicleTab[i]);

            System.out.println("Przeczytano");
            System.out.println("____________________________________________________________________________________");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void read(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("vehicles.ser"))){
            for(int i =0;i<vehicleTab[0].getNumer();i++){
                Object ob = ois.readObject();
                Vehicle v = (Vehicle) ob;
                System.out.println(v.toString());
            }
            System.out.println("____________________________________________________________________________________");

        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
     public static void menuSklepu() {

        System.out.println("(1) Wstawianie do tablicy kilka pojazdow");
        System.out.println("(2) Wyświetlenie utworzonych pojazdow");
        System.out.println("(3) Wstawienie silnika za numerem pojazdu");
        System.out.println("(4) Usuniecie silnika za numerem pojazdu");
        System.out.println("(5) Sprawdzenie stanu silnika za numerem pojazdu");
        System.out.println("(6) Ustalenie gumy za numerem pojazdu");
        System.out.println("(7) Usuniecie gumy za numerem pojazdu");
        System.out.println("(8) Sprawdzenie stanu gumy za numerem pojazdu");
        System.out.println("(9) Utworzenie nowego pojazdu");
        System.out.println("(10) Ile samochodow?");
        System.out.println("(11) Ile motocyklow?");
        System.out.println("(12) Zapicac obj. ");
        System.out.println("(13) Wyswitlic obj.");
        System.out.println("(0) Wyjscie");
        System.out.println("____________________________________________________________________________________");
        System.out.print("Wpisz numer metody ---> ");
    }

     public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);

        int numer=-1;

        while(numer!=0) {
            menuSklepu();
            numer = reader.nextInt();
            System.out.println("____________________________________________________________________________________" );
            switch (numer){
                case 1:
                    insertVehicles();
                    break;
                case 2:
                    outputVehicles();
                    break;
                case 3:
                    installEngineByNumer();
                    break;
                case 4:
                    uninstallEngineByNumer();
                    break;
                case 5:
                    checkEngineByNumer();
                    break;
                case 6:
                    installTiresByNumer();
                    break;
                case 7:
                     uninstallTiresByNumer();
                    break;
                case 8:
                    checkTiresByNumer();
                    break;
                case 9:
                    createNewVehicle();
                    break;
                case 10:
                    countOfCars();
                    break;
                case 11:
                    countOfMoto();
                    break;
                case 12:
                    write();
                    break;
                case 13:
                    read();
                    break;
            }
        }
        reader.close();


    }

}
