package Obseravable;
import Observers.*;

import java.util.ArrayList;

public class ConditionData implements Car {
    ArrayList<Observer> observerList = new ArrayList<Observer>();
    public int tiresCondition;
    public int HP;
    public String engineType;
    public int fuelLevel;
    public int engineCapacity;
    public int fuelCapacity;
    @Override
    public void registerObserver(Observer ob){
        observerList.add(ob);
    }
    public void removeObserver(Observer ob){
        observerList.remove(ob);
    }
    public void notifyObserver(){
        for(int i = 0; i<observerList.size(); i++)
            observerList.get(i).update(tiresCondition,HP,engineType,fuelLevel,engineCapacity,fuelCapacity);
    }
    public void conditionChanged(){
        notifyObserver();
    }
    public void setCondition(int tiresCondition, int HP, String engineType, int fuelLevel, int engineCapacity, int fuelCapacity){
        this.tiresCondition = tiresCondition;
        this.HP = HP;
        this.engineType = engineType;
        this.fuelLevel = fuelLevel;
        this.engineCapacity = engineCapacity;
        this.fuelCapacity = fuelCapacity;
        conditionChanged();
    }
}
