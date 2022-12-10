package Help;

import Comparators.CompareByCylinder;
import Comparators.CompareByDeadline;
import Disk.Disk;
import Request.Request;

import java.util.ArrayList;
import java.util.Comparator;

public class Help {
    public int shortestRouteElement(ArrayList<Request> arr, Disk disk) {
        int minElement = 0;
        int minRoute = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if(!arr.get(i).isChecked()) {
                if (Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber()) <= minRoute) {
                    minElement = i;
                    minRoute = Math.abs(disk.getArmStartPosition() - arr.get(i).getCylinderNumber());
                }
            }
        }
        arr.get(minElement).setChecked(true);
        return minElement;
    }
    public int nearestBiggerEllement(ArrayList<Request> arr, Disk disk){
        Comparator<Request> compareCylinder = new CompareByCylinder();
        arr.sort(compareCylinder);
        if(arr.get(0).getCylinderNumber() > disk.getArmStartPosition())
            return 0;
        if(arr.get(arr.size()-1).getCylinderNumber() < disk.getArmStartPosition() &&arr.size()!=1)
            return arr.size()-1;
        for (int i = 1; i < arr.size()-1;i++) {
            if (arr.get(i).getCylinderNumber() >= disk.getArmStartPosition())
                if(disk.getVektorDirection().equals("right") || (nearestElement(arr,disk) == "r" && nearestElement(arr,disk)==(null)))
                    return i;
                else
                    return i-1;
        }

        return 0;
    }
    public int nearestElementAfterArm(ArrayList<Request> arr, Disk disk){
        Comparator<Request> compareCylinder = new CompareByCylinder();
        arr.sort(compareCylinder);
        for (int i = 0; i < arr.size();i++) {
            if (arr.get(i).getCylinderNumber() >= disk.getArmStartPosition())
                return i;
        }


        return -1;
        }
    public int nearestElementBeforeArm(ArrayList<Request> arr, Disk disk){
        Comparator<Request> compareCylinder = new CompareByCylinder();
        arr.sort(compareCylinder);
        for (int i = arr.size()-1; i >=0;i--) {
            if (arr.get(i).getCylinderNumber() <= disk.getArmStartPosition())
                return i;
        }


        return -1;
    }
    public Object nearestElementToArm(ArrayList<Request> arr, Disk disk){

        if(nearestElement(arr,disk).equals("r")) {
            Comparator<Request> compareCylinder = new CompareByCylinder();
            arr.sort(compareCylinder);
            for (int i = 0; i < arr.size()-1;i++) {
                if (arr.get(i).getCylinderNumber() >= disk.getArmStartPosition())
                    return arr.get(i);
            }
        }else if(nearestElement(arr, disk).equals("l")){
            Comparator<Request> compareCylinder = new CompareByCylinder();
            arr.sort(compareCylinder);
            for (int i = arr.size()-1; i > 0;i--) {
                if (arr.get(i).getCylinderNumber() <= disk.getArmStartPosition())
                    return arr.get(i);
            }
        }

    return -1;
    }
    public String nearestElement(ArrayList<Request> arr, Disk disk){

        Comparator<Request> compareCylinder = new CompareByCylinder();
        arr.sort(compareCylinder);
        if(nearestRTDeadline(arr) != -1) {
            if (arr.get(nearestRTDeadline(arr)).getCylinderNumber() < disk.getArmStartPosition())
                return "l";
            else return "r";
        }
        return null;
    }
    public int nearestRTDeadline(ArrayList<Request> arr){
        Comparator<Request> compareDeadline = new CompareByDeadline();
        arr.sort(compareDeadline);
        Request minRequest = new Request(Integer.MAX_VALUE);
        minRequest.setDeadline(Integer.MAX_VALUE);
        for(Request request: arr){
            if(request.isIfRealTime() && !request.isChecked()) {
                if (request.getDeadline() < minRequest.getDeadline())
                    minRequest = request;
            }
        }
        if(minRequest.isIfRealTime())
        return arr.indexOf(minRequest);

        else
            return -1;
    }
}
