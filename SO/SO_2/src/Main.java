import Disk.Disk;
import Disk.Algorithms;
import Help.OperationsOnList;
import Request.Request;

import java.util.ArrayList;

public class Main {
    private final static int DISC_SIZE = 3000;

    public static void main(String[] args) {

        Disk disk = new Disk(1,4000,DISC_SIZE,"right");
        Algorithms alg = new Algorithms( OperationsOnList.randomiseRequests(disk,10,10,10,1,25,30,50,55,100));
        ArrayList<Request> listFCFS = alg.getRequestsQueue();
        ArrayList<Request> listEDF = alg.getRequestsQueue();
        ArrayList<Request> listSSTF = alg.getRequestsQueue();
        ArrayList<Request> listSCAN = alg.getRequestsQueue();
        ArrayList<Request> listC_SCAN = new ArrayList<>(alg.getRequestsQueue());
        OperationsOnList.toRealTimeTasks(listEDF,10,1000,3000);
        ArrayList<Request> listFD_SCAN = new ArrayList<>(listEDF);

        //requesty nie powtarzają się

        System.out.println("Glowica - " + disk.getArmStartPosition());
        alg.FCFS(listFCFS,disk);
        System.out.println("FCFS - " + disk.getSeekTime());
        disk.setSeekTime(0);
        alg.SSTF(listSSTF,disk);
        System.out.println("SSTF - " + disk.getSeekTime());
        disk.setSeekTime(0);
        alg.SCAN(listSCAN,disk);
        System.out.println("SCAN - " + disk.getSeekTime());
        disk.setSeekTime(0);
        alg.C_SCAN(listC_SCAN,disk);
        System.out.println("C_SCAN - " + disk.getSeekTime());
        disk.setSeekTime(0);
        alg.EDF(listEDF,disk);
        System.out.println("EDF - " + disk.getSeekTime());
        disk.setSeekTime(0);
        alg.FDSCAN(listFD_SCAN,disk);
        System.out.println("FDSCAN - " + disk.getSeekTime());
    }
}
