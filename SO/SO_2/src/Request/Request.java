package Request;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Request {
    private static int requestsAmount = 1;
    private int requestID;
    private int cylinderNumber;
    private int arrivalTime;
    private boolean ifRealTime = false;
    private int deadline;
    private boolean checked;
    public Request(int cylinderNumber){
        this.cylinderNumber = cylinderNumber;
        this.requestID = requestsAmount;
        requestsAmount++;
        this.checked = false;

    }


    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getCylinderNumber() {
        return cylinderNumber;
    }

    public int getDeadline() {
        return deadline;
    }

    public boolean isIfRealTime() {
        return ifRealTime;
    }

    public int getRequestID() {
        return requestID;
    }

    public static int getRequestsAmount() {
        return requestsAmount;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public void setIfRealTime(boolean ifRealTime) {
        this.ifRealTime = ifRealTime;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setCylinderNumber(int cylinderNumber) {
        this.cylinderNumber = cylinderNumber;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public static void setRequestsAmount(int requestsAmount) {
        Request.requestsAmount = requestsAmount;
    }

    @Override
    public String toString() {
        return String.format("%10d%10d%10b\n",requestID , cylinderNumber,ifRealTime);
    }
    public String toStringEDF() {
        return String.format("%10d%10d%10b%10d\n",requestID , cylinderNumber,ifRealTime,deadline);
    }
}
