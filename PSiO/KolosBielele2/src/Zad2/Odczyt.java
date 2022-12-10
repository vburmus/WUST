package Zad2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Odczyt {
    public static void main(String[] args) {
        Scanner read =  new Scanner(System.in);
        String newFileOdczytu = read.nextLine();
        String newFileZapisu = read.nextLine();
        ArrayList<String[]> lista = new ArrayList<>();
        String[] arr;
        ArrayList<String> listaSR = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(newFileOdczytu))){
            String line;
            br.readLine();
            br.readLine();
            while((line = br.readLine())!=null){
                arr = line.split("\\s+") ;
                double srednia = (Double.parseDouble(arr[4])+Double.parseDouble(arr[5])+Double.parseDouble(arr[6]))/3;
                listaSR.add(String.valueOf(srednia));
                lista.add(arr);
            }
        }catch(FileNotFoundException fnfE){
            fnfE.printStackTrace();
        }catch(IOException ioE){
            ioE.printStackTrace();
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(newFileZapisu,true))) {
            String nadglowek = "     Lista studentow kierunku Informatyka\n" +
                    "Lp  Nr_indeksu  Nazwisko    Imie    Ocena1  Ocena2  Ocena3 Srednia\n";
            bw.write(nadglowek);
            for(int i =0; i< lista.size();i++){
                bw.write(lista.get(i)[0] + "  " + lista.get(i)[1] + "  " + lista.get(i)[2]
                        + "  " +lista.get(i)[3] + "  " +lista.get(i)[4] + "  " +lista.get(i)[5] + "  " +
                        lista.get(i)[6] + "  " +listaSR.get(i) +"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
