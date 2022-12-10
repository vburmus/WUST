package Zad2;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Cz2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // String nazwaPlk = read.nextLine();
        File newFile = new File("Plik2.txt");
        File newFile2 = new File("PlikZerowy.txt");
        TreeMap<Double,String[]> map = new TreeMap<>(Collections.reverseOrder());
        TreeMap<String,String[]> map2 = new TreeMap<>();
        int numer=0;
        int numer2 =0;
        try (BufferedReader br = new BufferedReader(new FileReader("Plik.txt"))) {
            String[] arr = new String[3];
            br.readLine();
            br.readLine();
            String s;

            while ((s = br.readLine()) != null) {
                arr = s.split("\\s+");
                double cena = parseDouble(arr[2]);
                int ilosc = parseInt(arr[1]);
                if(ilosc==0){
                    map2.put(arr[0],arr);
                }else
                    map.put(cena*ilosc,arr);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))){

            bw.write("L.p        Nazwa           Ilosc          Cena        Wartoscc\n");
        } catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(newFile2))){

            bw2.write("L.p.      Nazwa        Cena\n");
        }catch (IOException e){
            e.printStackTrace();
        }


        Iterator<Double> i = map.keySet().iterator();
        Iterator<String> k = map2.keySet().iterator();

        while(i.hasNext()){
            numer++;
            double key = i.next();
                try(BufferedWriter bw3 = new BufferedWriter(new FileWriter(newFile,true))) {
                    bw3.write(String.format("%d%15s%15s%15s%15.2f%s",numer,map.get(key)[0],map.get(key)[1],map.get(key)[2],key,"\n" ));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        while(k.hasNext()){
            numer2++;
            String key = k.next();
            try(BufferedWriter bw4 = new BufferedWriter(new FileWriter(newFile2,true))) {
                bw4.write(String.format("%d %15s %15s %s",numer2,map2.get(key)[0],map2.get(key)[2],"\n" ));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


}
