package com.company;

import java.lang.reflect.Array;
import java.util.Random;

public class Table2D_example {


final static int n = 3;
    public void wypelnijMacierz(double [][] T)
    {
        Random generator = new Random();
        for(int i=0; i<T.length; i++)
            for(int j=0; j<T[i].length; j++)
                T[i][j] = generator.nextDouble()*10;
    }
    public void drukujMacierz(double [][] T)
    {
        for(int i=0; i<T.length; i++)
        {
            for(int j=0; j<T[i].length; j++)
                System.out.print("Tab[" + i + "]" + "[" + j + "]" + "=" + T[i][j] + "\t" );
            System.out.println();
        }
    }



    public static void main(String[] args) {
       double [][] Tab = new double[n][];
       for(int i = 0;i<=n; i++){
           Tab[i] = new double [n-i];
           Table2D_example obT = new Table2D_example();
           obT.wypelnijMacierz(Tab);
           obT.drukujMacierz(Tab);
       }


    }
}


