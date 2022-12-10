package Disk;

import java.util.Random;

public class Disk {
    Random random = new Random();
    private int armStartPosition;
    private int seekTime = 0;
    private int diskSize;
    private String vektorDirection;
    public Disk(int startPositionBoundl,int startPositionBoundr, int diskSize,String vektorDirection){
        this.armStartPosition = random.nextInt(startPositionBoundl,startPositionBoundr);
        this.diskSize = diskSize;
        this.vektorDirection = vektorDirection;
    }

    public int getSeekTime() {
        return seekTime;
    }

    public int getArmStartPosition() {
        return armStartPosition;
    }

    public String getVektorDirection() {
        return vektorDirection;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setVektorDirection(String vektorDirection) {
        this.vektorDirection = vektorDirection;
    }

    public void setSeekTime(int seekTime) {
        this.seekTime = seekTime;
    }

    public void moveArm(int seekTime) {
        this.seekTime += seekTime;
    }

    public void setArmStartPosition(int armStartPosition) {
        this.armStartPosition = armStartPosition;
    }
}
