package Disk;

import Comparators.CompareByCylinder;
import Comparators.CompareByDeadline;
import Disk.Disk;
import Help.Help;
import Request.Request;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Algorithms{

    Help help = new Help();
    private ArrayList<Request> requestsQueue;

    public Algorithms(ArrayList<Request> queue){
        this.requestsQueue = queue;
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Requests.txt")))) {
            bw.write(String.format("%12s%10s%10s%10s\n","Numer", "Cylinder", "RealTime", "Deadline"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Request request: queue)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Requests.txt"), true))) {
            bw.write(request.toStringEDF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Request> getRequestsQueue() {
        return requestsQueue;
    }



    public void FCFS(ArrayList<Request> arr, Disk disk){
        String PLIK_TXT = "fcfs.txt";
        int startPos = disk.getArmStartPosition();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT)))) {
            bw.write(String.format("%12s%10s%10s\n","Numer", "Cylinder", "RealTime"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Request request : arr) {
            int path = Math.abs(disk.getArmStartPosition() - request.getCylinderNumber());
            disk.moveArm(path);
            disk.setArmStartPosition(request.getCylinderNumber());
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT),true))) {
                bw.write(request.toString() );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        disk.setArmStartPosition(startPos);

    }
    public void SSTF(ArrayList<Request> arr, Disk disk){

        int SSTFarr;
        int startPos = disk.getArmStartPosition();
        String PLIK_TXT = "sstf.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT)))) {
            bw.write(String.format("%12s%10s%10s\n","Numer", "Cylinder", "RealTime"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Request request:arr){
            int count = help.shortestRouteElement(arr, disk);
            disk.moveArm(Math.abs(disk.getArmStartPosition() - arr.get(count).getCylinderNumber()));
            disk.setArmStartPosition(arr.get(count).getCylinderNumber());
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT),true))) {
                bw.write(arr.get(count).toString() );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        disk.setArmStartPosition(startPos);
    }
    public void SCAN(ArrayList<Request> arr, Disk disk) {
        int startPos = disk.getArmStartPosition();
        if(help.nearestBiggerEllement(arr, disk)!=-1) {
            int count = help.nearestBiggerEllement(arr, disk);

            String PLIK_TXT = "scan.txt";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT)))) {
                bw.write(String.format("%12s%10s%10s\n", "Numer", "Cylinder", "RealTime"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (disk.getVektorDirection().equals("right")) {
                if (count == arr.size() - 1) {
                    disk.moveArm(Math.abs(disk.getArmStartPosition() - disk.getDiskSize()));
                    disk.setArmStartPosition(disk.getDiskSize());

                } else {
                    int a = 0;
                    for (int i = count; i < arr.size(); i++) {
                        disk.moveArm(Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber()));
                        disk.setArmStartPosition(arr.get(i).getCylinderNumber());
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {
                            bw.write(arr.get(i).toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        a = i;
                    }
                    count = a;
                    disk.moveArm(disk.getDiskSize() - disk.getArmStartPosition());
                    disk.setArmStartPosition(disk.getDiskSize());
                    disk.moveArm(disk.getDiskSize() - arr.get(count - 1).getCylinderNumber());
                    disk.setArmStartPosition(arr.get(count - 1).getCylinderNumber());
                    count--;
                }
                for (int i = count; i >= 0; i--) {
                    disk.moveArm(Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber()));
                    disk.setArmStartPosition(arr.get(i).getCylinderNumber());
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {
                        bw.write(arr.get(i).toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } else if (disk.getVektorDirection().equals("left")) {
                if (count == 0) {
                    disk.moveArm(disk.getArmStartPosition() - 1);
                    disk.setArmStartPosition(1);
                } else {

                    for (int i = count; i >= 0; i--) {
                        disk.moveArm(Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber()));
                        disk.setArmStartPosition(arr.get(i).getCylinderNumber());
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {
                            bw.write(arr.get(i).toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    disk.moveArm(count + 1);
                    disk.setArmStartPosition(count + 1);
                    count++;
                }

                for (int i = count; i < arr.size(); i++) {
                    disk.moveArm(Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber()));
                    disk.setArmStartPosition(arr.get(i).getCylinderNumber());
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {
                        bw.write(arr.get(i).toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        disk.setArmStartPosition(startPos);
    }
    public void C_SCAN(ArrayList<Request> arr, Disk disk){

        String PLIK_TXT = "c-scan.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT)))) {
            bw.write(String.format("%12s%10s%10s\n","Numer", "Cylinder", "RealTime"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int count = help.nearestBiggerEllement(arr, disk);
        int startPos = disk.getArmStartPosition();
        if (disk.getVektorDirection().equals("right")) {
            if(count == arr.size()-1) {
                disk.moveArm(Math.abs(disk.getArmStartPosition()- disk.getDiskSize())+ disk.getDiskSize());
                disk.setArmStartPosition(1);
            }else {
                for (int i = count; i < arr.size(); i++) {
                    disk.moveArm(Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber()));
                    disk.setArmStartPosition(arr.get(i).getCylinderNumber());
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT),true))) {
                        bw.write(arr.get(i).toString() );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                disk.moveArm(disk.getDiskSize() - disk.getArmStartPosition());
                disk.setArmStartPosition(disk.getDiskSize());
                disk.moveArm(disk.getDiskSize());
                disk.setArmStartPosition(1);
                count--;
            }
            for (int i = 0; i <= count  ; i++) {
                disk.moveArm(Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber()));
                disk.setArmStartPosition(arr.get(i).getCylinderNumber());
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT),true))) {
                    bw.write(arr.get(i).toString() );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }else if(disk.getVektorDirection().equals("left") ){
            if(count==0){
                disk.moveArm(disk.getArmStartPosition()-1+ disk.getDiskSize());
                disk.setArmStartPosition(disk.getDiskSize());
            }else {
                for (int i = count; i >= 0; i--) {
                    disk.moveArm(Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber()));
                    disk.setArmStartPosition(arr.get(i).getCylinderNumber());
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT),true))) {
                        bw.write(arr.get(i).toString() );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                disk.moveArm(disk.getDiskSize());
                disk.setArmStartPosition(disk.getDiskSize());
                count++;
            }
            for(int i = count  ; i < arr.size();i++){
                disk.moveArm(Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber()));
                disk.setArmStartPosition(arr.get(i).getCylinderNumber());
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT),true))) {
                    bw.write(arr.get(i).toString() );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        disk.setArmStartPosition(startPos);
    }
    public void EDF(ArrayList<Request> mainArr, Disk disk){
        ArrayList<Request> arr = new ArrayList<>(mainArr);
        Collections.copy(mainArr,arr);
        String PLIK_TXT = "edf.txt";
        int startPos = disk.getArmStartPosition();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT)))) {
            bw.write(String.format("%12s%10s%10s%10s\n","Numer", "Cylinder", "RealTime", "Deadline"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       int failedTasks = 0;
       ArrayList<Request> realTimeTasks = new ArrayList<>();
        for(int i = 0; i < arr.size();i++){
           if(arr.get(i).isIfRealTime()) {
               realTimeTasks.add(arr.get(i));
               arr.remove(i);
               i--;
           }
        }
        realTimeTasks.sort(new CompareByDeadline());
        for (Request request : realTimeTasks) {
            int path = Math.abs(disk.getArmStartPosition() - request.getCylinderNumber());
            disk.moveArm(path);
            disk.setArmStartPosition(request.getCylinderNumber());
            if (request.getDeadline() < disk.getSeekTime()) {
                failedTasks++;
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {
                bw.write(request.toStringEDF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(Request request:arr){
            int path = Math.abs(disk.getArmStartPosition() - request.getCylinderNumber());
            disk.moveArm(path);
            disk.setArmStartPosition(request.getCylinderNumber());
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT),true))) {
                bw.write(request.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT),true))) {
            bw.write("\nFailed - " + failedTasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
        disk.setArmStartPosition(startPos);
      //  Help.OperationsOnList.showRequests(arr,disk);
    }
    public void FDSCAN(ArrayList<Request> mainArr, Disk disk){
        String PLIK_TXT = "fdscan.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT)))) {
            bw.write(String.format("          %12s%10s%10s%10s\n","Numer", "Cylinder", "RealTime", "Deadline"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Request request: mainArr){
            request.setChecked(false);
        }
        Comparator<Request> compareCylinder = new CompareByCylinder();
        mainArr.sort(compareCylinder);
        int failedTasks = 0;
        ArrayList<Request> arr = new ArrayList<>(mainArr);
        ArrayList<Request> uncheckedRequests = new ArrayList<>();
        Collections.copy(mainArr,arr);
        for(int j = 0; j < mainArr.size();j++) {

            if (help.nearestRTDeadline(arr) != -1) {
                Request minDeadlineRequest = arr.get(help.nearestRTDeadline(arr));

                if ((minDeadlineRequest.getDeadline() < (disk.getSeekTime() + Math.abs(disk.getArmStartPosition() - minDeadlineRequest.getCylinderNumber())))   ) {
                    arr.remove(minDeadlineRequest);
                    failedTasks++;
                    minDeadlineRequest.setChecked(true);
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {

                        bw.write("nie udalo "+minDeadlineRequest.toStringEDF() );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (!minDeadlineRequest.isChecked() ) {
                    if (help.nearestElement(arr, disk).equals("r")) {
                        for (int i = mainArr.indexOf(help.nearestElementToArm(arr, disk)); i <= mainArr.indexOf(minDeadlineRequest); i++) {
                            if (!mainArr.get(i).isChecked()) {
                                if((mainArr.get(i).isIfRealTime()) && (mainArr.get(i).getDeadline() < (disk.getSeekTime() +Math.abs(disk.getArmStartPosition() - mainArr.get(i).getCylinderNumber())))) {
                                    failedTasks++;
                                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {

                                        bw.write("nie udalo " + mainArr.get(i).toStringEDF());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                int path = Math.abs(disk.getArmStartPosition() - mainArr.get(i).getCylinderNumber());
                                disk.moveArm(path);
                                disk.setArmStartPosition(mainArr.get(i).getCylinderNumber());
                                mainArr.get(i).setChecked(true);
                                try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {
                                    bw.write("          "+mainArr.get(i).toStringEDF());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } else if (help.nearestElement(arr, disk).equals("l")) {
                        for (int i = mainArr.indexOf(help.nearestElementToArm(arr, disk)); i >= mainArr.indexOf(minDeadlineRequest); i--) {
                            if (!mainArr.get(i).isChecked()) {
                                if(mainArr.get(i).isIfRealTime() && mainArr.get(i).getDeadline() < (disk.getSeekTime() +Math.abs(disk.getArmStartPosition() - mainArr.get(i).getCylinderNumber()))&& mainArr.get(i).getDeadline()!=0) {
                                    failedTasks++;
                                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {

                                        bw.write("nie udalo " + mainArr.get(j).toStringEDF());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                int path = Math.abs(disk.getArmStartPosition() - mainArr.get(i).getCylinderNumber());
                                disk.moveArm(path);
                                disk.setArmStartPosition(mainArr.get(i).getCylinderNumber());
                                mainArr.get(i).setChecked(true);
                                try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {
                                    bw.write("          "+mainArr.get(i).toStringEDF());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < mainArr.size(); i++){
            if(!mainArr.get(i).isChecked())
                uncheckedRequests.add(mainArr.get(i));
        }
        if(uncheckedRequests.size()!=0) {
            int count = help.nearestElementAfterArm(uncheckedRequests, disk);
            int count1 = help.nearestElementBeforeArm(uncheckedRequests, disk);
            int a = disk.getArmStartPosition();
            for (int i = count; i < uncheckedRequests.size() && count != -1; i++) {
                disk.moveArm(Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber()));
                disk.setArmStartPosition(arr.get(i).getCylinderNumber());
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {
                    bw.write("          "+uncheckedRequests.get(i).toStringEDF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (count1 != -1) {
                disk.moveArm(disk.getDiskSize() - disk.getArmStartPosition());
                disk.setArmStartPosition(disk.getDiskSize());
                disk.moveArm(disk.getDiskSize() - uncheckedRequests.get(0).getCylinderNumber());
                disk.setArmStartPosition(uncheckedRequests.get(0).getCylinderNumber());
            }
            for (int i = 0; i <= count1 && count1 != -1; i++) {
                disk.moveArm(Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber()));
                disk.setArmStartPosition(arr.get(i).getCylinderNumber());
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {
                    bw.write("          "+uncheckedRequests.get(i).toStringEDF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PLIK_TXT), true))) {
            bw.write(""+failedTasks);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
