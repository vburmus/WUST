package Zad2;

import java.util.Random;

public class Main {


    public static int[][] utworz(int n){
        Random generator = new Random();
        int[][] arr = new int[n][];
        for(int i = 0; i<arr.length;i++){
            arr[i] = new int[generator.nextInt(9)+1];
        }
        for(int i = 0; i<arr.length;i++){
            for(int j = 0; j<arr[i].length;j++){
                arr[i][j] = generator.nextInt(8)+1;
            }
        }


        return arr;
    }
    public static int[][] wypelnij(int[][] arr){
        int k = 0;
        for(int i = 0; i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i].length > k) k = arr[i].length;
            }
        }
        int[][] arr2 = new int[arr.length][k];
        for(int i = 0; i<arr.length;i++){
            for(int j = 0; j<arr[i].length;j++){
                arr2[i][j] = arr[i][j];
            }

        }
        for(int i = 0; i<arr2.length;i++){
            for(int j = 0; j<arr2[i].length;j++) {
              if(arr2[i][j] == 0) arr2[i][j] = -1;
            }
        }
        return arr2;

    }
    public static void wyswietlij(int[][] arr){
        for(int i = 0; i<arr.length;i++){
            for(int j = 0; j<arr[i].length;j++) {
                System.out.printf("%2d",arr[i][j] , " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {

        int[][] arr3 = utworz(5);
        wyswietlij(arr3);
        System.out.println();
        wyswietlij(wypelnij(arr3));

    }
}
