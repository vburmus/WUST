package Zad2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cz1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Wprowadz nazwe:");
        String nazwaPlk = read.nextLine();
        File newFile = new File(nazwaPlk);
        String line = null;
        System.out.println("Wprowadz dane:");
        do{
            line = read.nextLine();
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(newFile,true))) {
                bw.write(line);
                bw.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }while(line!="");
        read.close();
    }
}
