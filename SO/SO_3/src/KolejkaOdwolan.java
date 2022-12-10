import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class KolejkaOdwolan {

    public static final int INT = 0;
    ArrayList<Strona> listaOdwolan;
    ArrayList<Process> listOfProcesses;
    public int iloscSysStron;
    public KolejkaOdwolan(int iloscSysStron){
        listaOdwolan = new ArrayList<>();
        this.iloscSysStron = iloscSysStron;
    }
    public KolejkaOdwolan(int[] arr){
        ArrayList<Strona> help = new ArrayList<>();
        for(int i = 0 ; i < arr.length; i++){
            help.add(new Strona(arr[i]));
        }
        listaOdwolan = help;

    }

    public void wypelnij( int zakresCzasowejLokalnosci,int a, int boundA,int iloscSysStron){
        int id = 0, iloscStron  = 0;
        int[] czasowaLokalnosc = new int[zakresCzasowejLokalnosci];
        Random generateRandomNum = new Random();

        if(a < INT){
            System.out.println("Wpisz wiecej elementów");
        }else{
            id = generateRandomNum.nextInt(0 , 10);

                iloscStron++;

            listaOdwolan.add(new Strona(id));
            for(int i = 0; i < zakresCzasowejLokalnosci; i++)
                czasowaLokalnosc[i] = id;

            for (int i = 1,count = 0; listaOdwolan.size()!= a; i++, count++) {
                if (i < a) {
                id = Math.max(generateRandomNum.nextInt( Math.max(listaOdwolan.get(i-1).getId() - boundA,0) , Math.min(boundA + listaOdwolan.get(i-1).getId(),iloscSysStron)),czasowaLokalnosc[count]);
            }

                if(!listaOdwolan.contains(new Strona(id))) {
                    iloscStron++;
                }
                listaOdwolan.add(new Strona(id));
            czasowaLokalnosc[count] = id;
            if(count==zakresCzasowejLokalnosci-1)
                count = -1;

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Strony.txt"), true))) {
                bw.write(listaOdwolan.get(i).toString() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Strony.txt"), true))) {
                bw.write("lICZBA STRON "+ iloscStron+"\n\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public ArrayList<Process> makeListOfProcesses(int num,int zakres,int bound,int countIndex){
        listOfProcesses = new ArrayList<>();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Strony.txt")))) {
            bw.write("Lista odwolan" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 1; i <= num; i++){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Strony.txt"), true))) {
                bw.write("Process " + i +"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            listOfProcesses.add(new Process(i,i * countIndex,iloscSysStron,zakres,bound));
        }
        return listOfProcesses;
    }

    public ArrayList<Strona> getListaOdwolan() {
        return listaOdwolan;
    }

    public ArrayList<Process> getListOfProcesses() {
        return listOfProcesses;
    }

    public int getIloscSysStron() {
        return iloscSysStron;
    }
}
