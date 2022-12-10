package Zad2;

import java.util.Random;

public class Tablica {
    private double[][] Tab;
    private double z;
    int w;
    int k;
    public Tablica(int w,int k){
         Tab = new double[w][k];
    }
    public void wypelnij(double z){
        Random generator = new Random();
            for (int i =0; i < Tab.length;i++){
                for (int j =0; j < Tab[i].length;j++){
                    Tab[i][j] = generator.nextDouble(1) * z;
                }
            }
    }
    public void drukuj(){
        for (int i =0; i < Tab.length;i++){
            for (int j =0; j < Tab[i].length;j++){
               System.out.printf("%10.3f",Tab[i][j]);
            }
            System.out.println();
        }


    }
    public void srednia(){
        for (int i = 0; i < Tab.length;i++){
            double sr = 0;
            for (int j = 0; j < Tab[i].length;j++){
                sr += Tab[j][i];

            }
            System.out.println("Srednia kolumny = " + sr/ Tab[i].length);
        }

    }
}
