import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num, category, staz, godzin;
        long pesel;
        double etat, stawka;
        String nazwisko, imie, stanowisko;

        Scanner scan = new Scanner(System.in);
        System.out.print("Liczba pracownikow: ");
        num = scan.nextInt();
        Employee[] arr = new Employee[num];
        arr[0] = new EmployeeFT();
        arr[1] = new EmployeePT();
        for(int i = 2; i < num; i++ ){
            System.out.print("Wybierz typ pracownika ( 1 - etatowy, 2 - godzinowy, 0 - wyjscie): ");
            category = scan.nextInt();
            if(category == 1 || category == 2) {
                System.out.print("Wprowadz nazwisko: ");
                scan.nextLine();
                nazwisko = scan.nextLine();
                System.out.print("Wprowadz imie: ");
                imie = scan.nextLine();
                System.out.print("Wprowadz  Pesel: ");
                pesel = scan.nextLong();
                System.out.print("Wprowadz stanowisko: ");
                scan.nextLine();
                stanowisko = scan.nextLine();
                System.out.print("Wprowadz staz: ");
                staz = scan.nextInt();

                if(category==1){
                    System.out.print("Wprowadz etat: ");
                    etat = scan.nextDouble();
                    System.out.print("Wprowadz stawke: ");
                    stawka = scan.nextDouble();
                    arr[i] = new EmployeeFT(nazwisko,imie,pesel,stanowisko,staz,etat,stawka);
                }else{
                    System.out.print("Wprowadz ilosc godzin: ");
                    godzin = scan.nextInt();
                    System.out.print("Wprowadz stawke: ");
                    stawka = scan.nextDouble();
                    arr[i] = new EmployeePT(nazwisko,imie,pesel,stanowisko,staz,godzin,stawka);
                }
            }
        }

        Employee emp;
        TableIterator<Employee> iter = new TableIterator(arr);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Employee.txt"))) {
          oos.writeObject("Liczba pracownikow - "+ arr.length);
            while (iter.hasNext()) {
                emp = iter.next();
                oos.writeObject(emp);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        Employee[] newTab = new Employee[num];
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Employee.txt"))) {
            System.out.println(ois.readObject());
            Employee employee;
            iter = new TableIterator(arr);
            int n = 0;
            while(n < num) {
                newTab[n] = iter.next();
                n++;
            }


        } catch (ClassNotFoundException e) {

        } catch (EOFException e){

        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.println(String.format("|%-10s|%-10s|%-15s|%-10s|%-10s|%-10s|", "Nazwisko", "Imie", "Pesel", "Stanowisko", "Staz", "Pensja"));
        System.out.println("------------------------------------------------------------------------");
        iter = new TableIterator(arr);
        while (iter.hasNext()) {
            emp = iter.next();
            emp.showEmployee();
        }
        System.out.println("------------------------------------------------------------------------");


    }
}