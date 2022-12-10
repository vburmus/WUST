package Zad2;

import java.io.*;
import java.util.*;

public class Odczyt {
    public static void main(String[] args) {
        Scanner read =  new Scanner(System.in);
       // String newFileOdczytu = read.nextLine();
      //  String newFileZapisu = read.nextLine();
        ArrayList<String[]> lista = new ArrayList<>();
        TreeMap<Double,String[]> listaPos = new TreeMap<>();
        TreeMap<Double,String[]> listaNeg = new TreeMap<>();
        String[] arr;
        try(BufferedReader br = new BufferedReader(new FileReader("Text.txt"))) {
            String line;
            br.readLine();
            while((line = br.readLine())!=null){
                arr = line.split("\\s+") ;
                lista.add(arr);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i =0; i< lista.size();i++){
            if(Double.parseDouble(lista.get(i)[3]) > 3){
                listaPos.put(Double.parseDouble(lista.get(i)[3]),lista.get(i));
            }else{
                listaNeg.put(Double.parseDouble(lista.get(i)[3]),lista.get(i));
            }
        }


            if(listaPos.size()!=0){

                Iterator<Double> it = listaPos.keySet().iterator();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("Wiecej3.txt", true))) {
                        bw.write("Grupa 1 - zaliczenia pozytywne\n");
                        bw.write(String.format("%s%15s%15s%15s%15s", "Lp", "Index", "Nazwisko", "Imie", "Ocena\n"));
                        int numer = 0;
                        while(it.hasNext()) {
                            numer++;
                            double key = it.next();
                            bw.write(String.format("%d%15s%15s%15s%15s%s", numer, listaPos.get(it)[2], listaPos.get(it)[1], listaPos.get(it)[0], listaPos.get(it)[3], "\n"));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }
            if(listaNeg.size()!=0){
                Iterator<Double> at = listaPos.keySet().iterator();

                try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("Wiecej3.txt", true))) {
                        bw2.write("Grupa 1 - zaliczenia negatywne\n");
                        bw2.write(String.format("%s%15s%15s%15s%15s", "Lp", "Index", "Nazwisko", "Imie", "Ocena\n"));
                        int numer = 0;
                        while(at.hasNext()) {
                            numer++;
                            double key = at.next();
                            bw2.write(String.format("%d%15s%15s%15s%15s%s", numer, listaNeg.get(at)[2], listaNeg.get(at)[1], listaNeg.get(at)[0], listaNeg.get(at)[3], "\n"));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();

                }
            }
        }
    }

