import Source.EmptyQueueException;
import Source.ListQueue;

import java.util.ArrayList;

public class Firma {

    public ListQueue<Store> shops;


    public Firma()
    {
        this.shops = new ListQueue<>();
    }

    public ListQueue<Store> getShops() {
        return shops;
    }



    public void przychodyFirmy() throws EmptyQueueException {
        double przychody = 0;

        while(!getShops().isEmpty())
            przychody+= getShops().dequeue().getOrderSum();

        System.out.println("Przychody firmy: " + String.format("%1.2f",przychody) + " zł");
    }
}

