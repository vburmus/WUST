package Help;

import Disk.Disk;
import Request.Request;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class OperationsOnList {
    public static ArrayList<Request> randomiseRequests(Disk disk, int a, int b, int c, int boundA, int bound_A, int boundB, int bound_B, int boundC, int bound_C) {
        Random generateRandomNum = new Random();
        ArrayList<Request> arr = new ArrayList<>();
            if(disk.getDiskSize() < bound_A + bound_B + bound_C){
                System.out.println("Za duzo!");

            }else{
        int cylinderNumber;
        boolean[] antiRepeat = new boolean[boundA + bound_A + boundB + bound_B + boundC + bound_C];
        for (int i = 0; arr.size()!= a+b+c; i++) {
            if (i < a) {
                do {
                    cylinderNumber = generateRandomNum.nextInt(boundA, bound_A +1);
                } while (antiRepeat[cylinderNumber - 1]);
            } else if (i < b+a ) {
                do {
                    cylinderNumber = generateRandomNum.nextInt(boundB , bound_B+1);
                } while (antiRepeat[cylinderNumber - 1]);
            } else {
                do {
                    cylinderNumber = generateRandomNum.nextInt(boundC , bound_C+1);
                } while (antiRepeat[cylinderNumber - 1]);
            }
            antiRepeat[cylinderNumber - 1] = true;
            arr.add(new Request(cylinderNumber));

        }
        return arr;
    }
            return null;
    }
    public static void toRealTimeTasks(ArrayList<Request> arr, int numberOfTasks,int leftDeadlineBound, int rightDeadlineBound){
        Random randomise = new Random();
       boolean[] checkRepeat = new boolean[arr.size()];
       int arrivalTime,deadline,index;
        if(arr.size() < numberOfTasks)
            System.out.println("Blad ilosci");
        for(int i = 0; i < numberOfTasks;i++){

             deadline = randomise.nextInt(leftDeadlineBound,rightDeadlineBound);
            index = randomise.nextInt(arr.size());
            if (!checkRepeat[index]){

                 arr.get(index).setDeadline(deadline);
                 arr.get(index).setIfRealTime(true);
                 checkRepeat[index] = true;
             }else
                 i--;


        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RTRequests.txt")))) {
            bw.write(String.format("%12s%10s%10s%10s\n","Numer", "Cylinder", "RealTime", "Deadline"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Request request: arr)
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("RTRequests.txt"), true))) {
                bw.write(request.toStringEDF());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public static void showRequests(ArrayList<Request> arr, Disk diskDisk){
        for (Request request : arr) {
            System.out.print(request);
        }

    }
}
