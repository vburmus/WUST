import java.util.Objects;
import java.util.Random;

public class Process {
    private static long id = 0;

    private final long name;

    private int arrivalTime,burstTime,startTime,finishTime,turnAroundTime,waitingTime;
    Random randomise = new Random();
    public Process(int n){
        id++;
        this.name = id;
        this.arrivalTime = randomise.nextInt(n,n + 100);
        this.burstTime = randomise.nextInt(1,500);
        startTime = 0;
        finishTime = 0;
        turnAroundTime = 0;
        waitingTime = 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public static long getId() {
        return id;
    }

    public long getName() {
        return name;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public static void setId(long id) {
        Process.id = id;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Process process = (Process) o;
        return name == process.name && Double.compare(process.arrivalTime, arrivalTime) == 0 && Double.compare(process.burstTime, burstTime) == 0 && Double.compare(process.startTime, startTime) == 0 && Double.compare(process.finishTime, finishTime) == 0 && Double.compare(process.turnAroundTime, turnAroundTime) == 0 && Double.compare(process.waitingTime, waitingTime) == 0;
    }


    public int hashCode() {
        return Objects.hash(name, arrivalTime, burstTime, startTime, finishTime, turnAroundTime, waitingTime);
    }
}
