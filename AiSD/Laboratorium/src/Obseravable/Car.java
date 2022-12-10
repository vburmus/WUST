package Obseravable;
import Observers.*;
public interface Car {
    public void registerObserver(Observer ob);
    public void removeObserver(Observer ob);
    public void notifyObserver();
}
