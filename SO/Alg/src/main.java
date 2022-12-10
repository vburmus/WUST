import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class main {

    public static class ArrivalSort implements Comparator<Process>{
        public int compare(Process o1, Process o2) {
            return o1.getArrivalTime() - o2.getArrivalTime();
        }
    }
    static void findWaitingTime(ArrayList<Process> processes, int n, int quantum) {
        int[] bt = new int[n];
        int remain_bt[] = new int[n];
        for(int i =0; i< n;i++){
            bt[i] = processes.get(i).getBurstTime();
            remain_bt[i] =  bt[i];
        }

        int t = 0;
        while(true)
        {
            boolean done = true;
            for (int i = 0 ; i < n; i++)
            {
                if (remain_bt[i] > 0)
                {
                    done = false;
                    if (remain_bt[i] > quantum)
                    {
                        t += quantum;
                        remain_bt[i] -= quantum;
                    }
                    else
                    {
                        t = t + remain_bt[i];
                        processes.get(i).setWaitingTime( t - bt[i]);
                        remain_bt[i] = 0;
                    }
                }
            }
            if (done)
                break;
        }
    }
    static void findTurnAroundTime(ArrayList<Process> processes, int n) {
        for (int i = 0; i < n ; i++)
            processes.get(i).setTurnAroundTime(  processes.get(i).getBurstTime()+processes.get(i).getWaitingTime());
    }
    public static void FCFS(ArrayList<Process> processes,int num){
        int time = 0,arrival;
        double avgWaitingTime = 0,avgTurnArround = 0;
        for(int i =0; i < processes.size();i++){
            arrival = processes.get(i).getArrivalTime();
            if(time < arrival){
                processes.get(i).setStartTime(arrival);
                time = processes.get(i).getBurstTime() + arrival;
            }else{
                processes.get(i).setStartTime(time);
                time+= processes.get(i).getBurstTime();
            }
            processes.get(i).setFinishTime(time);
            processes.get(i).setTurnAroundTime(time- arrival);
            processes.get(i).setWaitingTime(time - arrival - processes.get(i).getBurstTime());
            avgWaitingTime+= processes.get(i).getWaitingTime();
            avgTurnArround+= processes.get(i).getTurnAroundTime();
        }
        showProcesses(processes,"FCFS.txt");
        System.out.printf("%s%25s%10.3f,%25s%10.3f\n","|FCFS|" , "Sr czas oczekiwania - " , avgWaitingTime/num , "sr czas zycia - " , avgTurnArround/num);
    }
    public static void SJF(ArrayList<Process> processes,int num){
        boolean[] completedArr = new boolean[processes.size()];
        int time = 0,completed = 0;
        double avgWaitingTime = 0,avgTurnArround = 0;

            while(true){
                int index = completedArr.length,min = 999;
                if( completed == completedArr.length)
                    break;
                for(int i = 0;i < completedArr.length;i++) {
                    int bt = processes.get(i).getBurstTime();
                    int at = processes.get(i).getArrivalTime();
                    if ((at <= time) && (completedArr[i] == false) && (bt < min)) {
                        min = bt;
                        index = i;
                    }
                }
                    if(index == completedArr.length) {
                        time++;
                    }else{
                        int bt = processes.get(index).getBurstTime();
                        int at = processes.get(index).getArrivalTime();
                        processes.get(index).setFinishTime(time + bt);
                        processes.get(index).setTurnAroundTime(time + bt - at);
                        processes.get(index).setWaitingTime(time - at);
                        time+= bt;
                        completedArr[index] = true;
                        completed++;
                        avgWaitingTime+= processes.get(index).getWaitingTime();
                        avgTurnArround+= processes.get(index).getTurnAroundTime();
                    }
        }
        showProcesses(processes,"SJF.txt");
        System.out.printf("%s%25s%10.3f,%25s%10.3f\n","|SJF |" , "Sr czas oczekiwania - " , avgWaitingTime/num , "sr czas zycia - " , avgTurnArround/num);
    }
    public static void SRTF(ArrayList<Process> processes, int num) {
        boolean[] checkedArr = new boolean[processes.size()];
        int time = 0,completed = 0;
        double avgWaitingTime = 0,avgTurnArround = 0;
        int[] btTable = new int[processes.size()];
        for(int i = 0;i< btTable.length;i++){
            btTable[i] = processes.get(i).getBurstTime();
        }
        while(true) {
            int index = checkedArr.length, min = 999;

            if (completed == checkedArr.length)
                break;
            for (int i = 0; i < checkedArr.length; i++) {
                int bt = processes.get(i).getBurstTime();
                int at = processes.get(i).getArrivalTime();
                if ((at <= time) && (checkedArr[i] == false) && (bt < min)) {
                    min = btTable[i];
                    index = i;
                }
            }
            if(index == checkedArr.length) {
                time++;
            }else{
                btTable[index]--;
                time++;
                if(btTable[index] == 0){
                    processes.get(index).setFinishTime(time);
                    checkedArr[index] = true;
                    completed++;
                }

            }
        }
        for(int i = 0;i < processes.size() ;i++) {
            int bt = processes.get(i).getBurstTime();
            int at = processes.get(i).getArrivalTime();
            int ft = processes.get(i).getFinishTime();
            processes.get(i).setTurnAroundTime(ft - at);
            processes.get(i).setWaitingTime(ft - at - bt);
            avgWaitingTime += processes.get(i).getWaitingTime();
            avgTurnArround += processes.get(i).getTurnAroundTime();
        }
        showProcesses(processes,"SRTF.txt");
        System.out.printf("%s%25s%10.3f,%25s%10.3f\n","|SRTF|" , "Sr czas oczekiwania - " , avgWaitingTime/num , "sr czas zycia - " , avgTurnArround/num);
    }
    public static void RR(ArrayList<Process> processes, int num, int quantum,String name) {
        findWaitingTime(processes, num, quantum);
        findTurnAroundTime(processes, num);
        double avgWaitingTime=0,avgAroundTime=0;
        for(int i =0; i < num; i++ ){
            avgAroundTime+=processes.get(i).getTurnAroundTime();
            avgWaitingTime+=processes.get(i).getWaitingTime();
        }
        showProcesses(processes,name);
        System.out.printf("%s%25s%10.3f,%25s%10.3f\n","| RR |" , "Sr czas oczekiwania - " , avgWaitingTime/num , "sr czas zycia - " , avgAroundTime/num);

    }
    public static ArrayList<Process> generateProcesses(int number){
        ArrayList<Process> list = new ArrayList<>();
        for(int i = 0 ; i < number; i++){
            Process newProcess = new Process(i);
            list.add( newProcess);
        }
        return list;
    }
    public static void showProcesses(ArrayList<Process> list,String name){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
            bw.write(String.format("%s\n|%10s|%10s|%10s|%10s|%10s|%10s|%10s|\n%s\n", "------------------------------------------------------------------------------", "Name", "Arrival", "Burst", "Start", "Finish", "Waiting", "TurnAround",
                    "------------------------------------------------------------------------------"));
            for (int i = 0; i < list.size(); i++) {
                bw.write(String.format("|%10s|%10d|%10d|%10d|%10d|%10d|%10d|\n", list.get(i).getName(), list.get(i).getArrivalTime(), list.get(i).getBurstTime(), list.get(i).getStartTime(), list.get(i).getFinishTime(), list.get(i).getWaitingTime(), list.get(i).getTurnAroundTime()));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int num = 1000;
        ArrayList<Process> arr = generateProcesses(num);
        ArrivalSort comp = new ArrivalSort();
        Collections.sort(arr,comp);
        FCFS(arr,num);
        SJF(arr,num);
        SRTF(arr,num);
        RR(arr,num,1000,"RR.txt");

    }
}
