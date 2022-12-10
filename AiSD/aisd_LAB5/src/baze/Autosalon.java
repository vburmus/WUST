package baze;
import Listy.FullStackException;
import Listy.ListStack;
import Listy.TwoWayCycledListWithSentinel;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class Autosalon {

    private TwoWayCycledListWithSentinel baze;
    public Autosalon(){
        baze = new TwoWayCycledListWithSentinel();
    }

    public void addSamochod(Samochod car){
        Iterator<Samochod> iterator = baze.iterator();
        while(iterator.hasNext()) {
            Samochod arrayCar = iterator.next();
            if (car.getNr_silnika() < arrayCar.getNr_silnika()) {
                baze.add(baze.indexOf(arrayCar), car);
                break;
            }
            else if(car.getNr_silnika() == arrayCar.getNr_silnika() ) {
                baze.add(baze.indexOf(arrayCar), car);
                break;
            }
            else if(!iterator.hasNext()) {
                baze.add(car);
                break;
            }
        }
        if(baze.isEmpty())
            baze.add(car);
    }
    public void wyswietl(){
        Iterator<Samochod> iter = baze.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    public void wyswietlSamochod(int car){
        Iterator<Samochod> iter = baze.iterator();
        Samochod arrCar;
        while (iter.hasNext()){
            arrCar = iter.next();
            if(arrCar.getNr_silnika()==car)
                System.out.println(arrCar);
        }
    }
    public void wyswietlMarka(String marka){
        Iterator<Samochod> iter = baze.iterator();
        Samochod arrCar;
        while (iter.hasNext()){
            arrCar = iter.next();
            if(marka.equals(arrCar.getMarka()))
                System.out.println(arrCar);
        }
    }
    public void wyswietlRok(int rok){
        Iterator<Samochod> iter = baze.iterator();
        Samochod arrCar;
        while (iter.hasNext()){
            arrCar = iter.next();
            if(rok == arrCar.getData())
                System.out.println(arrCar);
        }
    }
    public void wyswietlCena(int x){
        Iterator<Samochod> iter = baze.iterator();
        Samochod arrCar;
        while (iter.hasNext()){
            arrCar = iter.next();
            if(x > arrCar.getCena())
                System.out.println(arrCar);
        }
    }
    public void usuniecie(int car){
        Iterator<Samochod> iter = baze.iterator();
        Samochod arrCar;
        while (iter.hasNext()){
            arrCar = iter.next();
            if(car == (arrCar.getNr_silnika()))
               baze.remove(arrCar);
        }
    }
    public void zapisz(String plikName){
        Iterator<Samochod> iter  = baze.iterator();
        Samochod car;
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(plikName))) {

                while (iter.hasNext()) {
                    car = iter.next();
                    oos.writeObject(car);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public boolean sprawdzicNrSilnika(int numer){
        Iterator<Samochod> iter = baze.iterator();
        Samochod arrCar;
        while (iter.hasNext()){
            arrCar = iter.next();
            if(numer == arrCar.getNr_silnika())
                return false;
        }
        return  true;
        }
    public void odzcyt(String plikName){

       baze.clear();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(plikName))) {

            Samochod car;

            int n = 0;
            while((car = (Samochod) ois.readObject())!=null) {
                baze.add(car);
                System.out.println(car);
            }


        } catch (ClassNotFoundException e) {

        } catch (EOFException e){

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void aktualizuj(int numerAuta) {
        Scanner scan = new Scanner(System.in);
        Iterator<Samochod> iter = baze.iterator();
        Samochod samochod = null;
        while (iter.hasNext()) {
            samochod = iter.next();
            if (numerAuta == (samochod.getNr_silnika()))
                break;
        }
        if (samochod != null) {
            int num = 1;
            while (num != 0) {
                System.out.println("Parametr do aktualizowania:\n1. Cena\n2.Kolor \n3.Skladowanie\n0.Koniec");
                switch (num = scan.nextInt()) {
                    case 1:
                        System.out.print("Cena = ");
                        samochod.setCena(scan.nextInt());
                        samochod.setSkladowanie(samochod.getSkladowanie());
                        break;
                    case 2:
                        System.out.print("Kolor = ");
                        samochod.setKolor(scan.next());
                        break;
                    case 3:
                        System.out.println("Skladowanie = ");
                        samochod.setSkladowanie(scan.nextInt());
                        break;

                }
            }
        }
    }
    public void parking(int numerAuta) throws FullStackException {
    ListStack<Samochod> table = new ListStack<>();
    Iterator<Samochod> iter = baze.iterator();
    Samochod car = iter.next();
        System.out.println("Wyjechali:");
    while(numerAuta!=car.getNr_silnika()) {
        table.push(car);
        System.out.println(car.getMarka() + " " + car.getNr_silnika());
        car = iter.next();
    }
        System.out.println("Kupiona :" + car);
    baze.remove(car);
    System.out.println("Zajechali:");
    while (!table.isEmpty()){
        System.out.println(table.pop());
    }

    }
}
