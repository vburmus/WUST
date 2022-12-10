package com.company;

import java.lang.reflect.Array;
import java.util.Random;

public class Main {


    final static int n = 9;


    public static void main(String[] args) {
        int[][] Tab = new int[n][];
        for (int i = 0; i < n; i++) {
            Tab[i] = new int[n - i];

        }
        Random generator = new Random();

        for (int i = 0; i < Tab.length; i++)
            for (int j = 0; j < Tab[i].length; j++)
                Tab[i][j] = generator.nextInt(9);

        for (int i = 0; i < Tab.length; i++) {
            for (int j = 0; j < Tab[i].length; j++)
                System.out.print(Tab[i][j] + "  ");
            System.out.println();

        }
    }
}



