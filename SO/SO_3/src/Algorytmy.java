import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Algorytmy {
    private int liczbaBrakowStron;
    private  int sum = 0;
    private Queue<Strona> aktywne;
    private int LRU(ArrayList<Strona> listaStron, int ramki){
        liczbaBrakowStron = 0;
        Queue<Strona> aktywneRamki = new LinkedList<>();


            for (int i = 0; i < listaStron.size(); i++) {
                if (ramki == aktywneRamki.size()) {
                    if (!aktywneRamki.contains(listaStron.get(i))) {
                        liczbaBrakowStron++;
                        ArrayList<Strona> obliczenieWywol = new ArrayList<>();

                        for(int k = 0; k < ramki;k++) {
                            Strona stronaZRamki = aktywneRamki.remove();
                            stronaZRamki.setNextOdwolanie(0);
                            int countPrzewid = 0;

                            for(int poczStr = i ; poczStr >= 0;poczStr--){
                                if (stronaZRamki.getId() != listaStron.get(poczStr).getId())
                                    countPrzewid++;
                                else
                                    break;
                            }
                            stronaZRamki.setNextOdwolanie(countPrzewid);
                            obliczenieWywol.add(stronaZRamki);
                        }
                        max(obliczenieWywol);
                        aktywneRamki.addAll(obliczenieWywol);
                        aktywneRamki.add(listaStron.get(i));
                    }


                } else {
                    if (!aktywneRamki.contains(listaStron.get(i))) {
                        liczbaBrakowStron++;
                        aktywneRamki.add(listaStron.get(i));
                    }
                }

            }
            aktywne = aktywneRamki;
            aktywneRamki.clear();


        return  liczbaBrakowStron;
    }
    private int LRU2(ArrayList<Strona> listaStron, int ramki){
        liczbaBrakowStron = 0;
        Queue<Strona> aktywneRamki = new LinkedList<>();
        if(!aktywne.isEmpty()){
            aktywneRamki = aktywne;
        }

        for (int i = 0; i < listaStron.size(); i++) {
            if (ramki == aktywneRamki.size()) {
                if (!aktywneRamki.contains(listaStron.get(i))) {
                    liczbaBrakowStron++;
                    ArrayList<Strona> obliczenieWywol = new ArrayList<>();

                    for(int k = 0; k < ramki;k++) {
                        Strona stronaZRamki = aktywneRamki.remove();
                        stronaZRamki.setNextOdwolanie(0);
                        int countPrzewid = 0;

                        for(int poczStr = i ; poczStr >= 0;poczStr--){
                            if (stronaZRamki.getId() != listaStron.get(poczStr).getId())
                                countPrzewid++;
                            else
                                break;
                        }
                        stronaZRamki.setNextOdwolanie(countPrzewid);
                        obliczenieWywol.add(stronaZRamki);
                    }
                    max(obliczenieWywol);
                    aktywneRamki.addAll(obliczenieWywol);
                    aktywneRamki.add(listaStron.get(i));
                }


            } else {
                if (!aktywneRamki.contains(listaStron.get(i))) {
                    liczbaBrakowStron++;
                    aktywneRamki.add(listaStron.get(i));
                }
            }

        }
        aktywne = aktywneRamki;
        aktywneRamki.clear();


        return  liczbaBrakowStron;
    }



    public ArrayList<Strona> max(ArrayList<Strona> arr) {
        int max = Integer.MIN_VALUE;
        Strona helpStrona = new Strona(1);
        for (Strona s : arr) {
            if(s.getNextOdwolanie() >= max) {
                max = s.getNextOdwolanie();
                helpStrona = s;
            }
        }
        arr.remove(helpStrona);
        return  arr;
    }

    public void zapiszLRU (ArrayList<Strona> listaStron, int frames,String fileName){
       int wynik =  LRU(listaStron, frames);
        sum += wynik;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName), true))){

                bw.write("Result : " + wynik + "\n\n");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void zapiszLRU2 (ArrayList<Strona> listaStron, int frames,String fileName){
        int wynik =  LRU2(listaStron, frames);
        sum += wynik;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName), true))){

            bw.write("Result : " + wynik + "\n\n");

        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public void PR(int numOfFrames,ArrayList<Process> listOfProcesses){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("PR.txt")))){

            bw.write("Resultaty" + "\n\n");

        }catch(IOException e){
            e.printStackTrace();
        }
        int framesForEach = numOfFrames/listOfProcesses.size();
        int reminder = numOfFrames - framesForEach*listOfProcesses.size();
        for (int i = 0; i < listOfProcesses.size();i++){
            listOfProcesses.get(i).setAvaliableFrames(framesForEach);
        }
        if(reminder!=0){
            for (int i = 0; reminder > 0; reminder--, i++)
                listOfProcesses.get(i).setAvaliableFrames(listOfProcesses.get(i).getAvaliableFrames() + 1);
        }
        for(int i = 0; i < listOfProcesses.size();i++){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("PR.txt"), true))){
                bw.write("_________________________________________________________________________________" + "\n\n");
                bw.write("Process № " + (i+1) + ": " + "ilosc odwolan - " +listOfProcesses.get(i).getKolejkaOdwolan().size() + " ilosc ramek - " + listOfProcesses.get(i).getAvaliableFrames() + "\n\n");

            }catch(IOException e){
                e.printStackTrace();
            }
            zapiszLRU(listOfProcesses.get(i).getKolejkaOdwolan(),listOfProcesses.get(i).getAvaliableFrames(),"PR.txt");
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("PR.txt"), true))){
            bw.write("_________________________________________________________________________________" + "\n\n");
            bw.write("Suma bledow - " + sum  + "\n\n");

        }catch(IOException e){
            e.printStackTrace();
        }
        sum = 0;
        liczbaBrakowStron = 0;
    }
    public void PP(int numOfFrames,ArrayList<Process> listOfProcesses){
        int reminder = 0;
        int S = 0;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("PP.txt")))){
            bw.write("Resultaty" + "\n\n");
        }catch(IOException e){
            e.printStackTrace();
        }

        for(int i =0; i < listOfProcesses.size();i++)
            S+= listOfProcesses.get(i).getCountOfCalls();

        for (int i = 0; i < listOfProcesses.size();i++){
            int framesForProcess = (listOfProcesses.get(i).getCountOfCalls() * numOfFrames)/S;
            listOfProcesses.get(i).setAvaliableFrames(framesForProcess);
            reminder += framesForProcess;
        }

        reminder = numOfFrames - reminder;
        int size = listOfProcesses.size()-1;
        listOfProcesses.get(size).setAvaliableFrames(listOfProcesses.get(size).getAvaliableFrames()+reminder);

        for(int i = 0; i < listOfProcesses.size();i++){

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("PP.txt"), true))){
                bw.write("_________________________________________________________________________________" + "\n\n");
                bw.write("Process № " + (i+1) + ": " + "ilosc odwolan - " +listOfProcesses.get(i).getKolejkaOdwolan().size()+ " ilosc ramek - " + listOfProcesses.get(i).getAvaliableFrames()  + "\n\n");
            }catch(IOException e){
                e.printStackTrace();
            }

            zapiszLRU(listOfProcesses.get(i).getKolejkaOdwolan(),listOfProcesses.get(i).getAvaliableFrames(),"PP.txt");
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("PP.txt"), true))){
            bw.write("_________________________________________________________________________________" + "\n\n");
            bw.write("Suma bledow - " + sum  + "\n\n");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void SCBS(int numOfFrames, ArrayList<Process> listOfProcesses,int dzielnNaRowne,int poczRamki,int min,int max) {

            sum = 0;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("SCBS.txt")))) {

                bw.write("Resultaty : " + "\n\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
            int bufer = 0;
            for (int i = 0; i < listOfProcesses.size(); i++) {

                int buferProc = 0;
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("SCBS.txt"), true))) {
                    bw.write("_________________________________________________________________________________" + "\n\n");
                    bw.write("Process № " + (i + 1) + ": " + "ilosc odwolan - " + listOfProcesses.get(i).getKolejkaOdwolan().size() + "\n\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int temp = poczRamki;
                ArrayList<ArrayList<Strona>> listOfParts = new ArrayList<>();
                Process cur = listOfProcesses.get(i);
                ArrayList<Strona> curList = cur.getKolejkaOdwolan();
                int czesc = curList.size() / dzielnNaRowne;
                int lim = 0;
                while (lim <= curList.size()) {

                    ArrayList<Strona> list = new ArrayList<>();
                    for (int j = 0; j < czesc; j++) {
                        if (lim + j < curList.size())
                            list.add(curList.get(j + lim));
                    }
                    if (list.size() != 0)
                        listOfParts.add(list);

                    lim += czesc;

                }
                int wynik = 0;

                for (int j = 0; j < listOfParts.size(); j++) {

                    wynik = LRU2(listOfParts.get(j), poczRamki);

                    if (wynik > max) {
                        poczRamki += dzielnNaRowne*2;
                        if (poczRamki > numOfFrames) {
                            poczRamki = numOfFrames;
                        }

                    } else if (wynik <= min) {
                        poczRamki -= dzielnNaRowne/2;
                        if (poczRamki <= 0) {
                            poczRamki = 1;
                        }
                    }

                    bufer += wynik;
                    sum += wynik;
                    buferProc += wynik;

                }
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("SCBS.txt"), true))) {

                    bw.write("Resultat : " + buferProc + "\n\n");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                poczRamki = temp;
                min *= 2;
                max *= 2;
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("SCBS.txt"), true))) {
                bw.write("_________________________________________________________________________________" + "\n\n");
                bw.write("Suma bledow - " + sum + "\n\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void PS(int numOfFrames,ArrayList<Process> listOfProcesses,int strefa,int poczRamki){


            int zmienionaStrefa = strefa;
            sum = 0;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("PS.txt")))) {

                bw.write("Resultaty : " + "\n\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < listOfProcesses.size(); i++) {

                int wynik = 0;
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("PS.txt"), true))) {
                    bw.write("_________________________________________________________________________________" + "\n\n");
                    bw.write("Process № " + (i + 1) + ": " + "ilosc odwolan - " + listOfProcesses.get(i).getKolejkaOdwolan().size() + "\n\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int minPrzedzial = 0;
                Process cur = listOfProcesses.get(i);
                ArrayList<Strona> curList = cur.getKolejkaOdwolan();

                for(int k = 0; k < curList.size();k+=strefa) {
                    ArrayList<Strona> strefaList = new ArrayList<>();
                    for (int j = 0; j < strefa; j++) {
                        if(j+minPrzedzial<curList.size())
                        strefaList.add(curList.get(j+minPrzedzial));
                    }
                    minPrzedzial+=strefa;
                    wynik += LRU(strefaList, poczRamki);
                    poczRamki = unique(strefaList);
                    if (poczRamki > numOfFrames){
                        poczRamki = numOfFrames;
                    }
                }
                zmienionaStrefa+=strefa;
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("PS.txt"), true))) {

                    bw.write("Resultat : " + wynik + "\n\n");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                sum+=wynik;

            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("PS.txt"), true))) {
                bw.write("_________________________________________________________________________________" + "\n\n");
                bw.write("Suma bledow - " + sum + "\n\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
            }

    public int unique(ArrayList<Strona> list){
        HashSet<Strona> map = new HashSet<>();
        map.addAll(list);
        return map.size();
    }
    }

