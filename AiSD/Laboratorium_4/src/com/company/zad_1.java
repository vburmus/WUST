package com.company;

public class zad_1 {

        public static double S(int n, double x){

            double sum = 0;

            if (x < 0) {

                sum = x;

            } else if (x >= 0 && x <= 2) {

                sum = Math.cos(x) + x;

            } else {
                for(int i = 1; i <= n; i++){
                    sum = sum + Math.pow(x,i)/i;
                }
            }

            return sum;
        }

        public static void main(String[] args){

            System.out.print(S(3, 3));

        }
    }

