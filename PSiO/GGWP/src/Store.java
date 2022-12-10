import Source.EmptyQueueException;
import Source.ListQueue;

public class Store {

    private ListQueue<Customer> storeQueue;
    private double orderSum;
    private String storeName;
    public Store(String name) {
        this.storeQueue = new ListQueue<>();
        this.orderSum = 0;
        this.storeName = name;
    }

    public ListQueue<Customer> getStoreQueue() {
        return storeQueue;
    }
    public double getOrderSum() {
        return orderSum;
    }
    public String getStoreName() {
        return storeName;
    }

    public void obsluga() throws EmptyQueueException {
        if (this.storeQueue.isEmpty())
            System.out.println("Brak zamówień w magazynie!");
        else
        {
            double suma = 0;
            System.out.println("__________________________\n\nSKLEP: " + this.getStoreName() + "\n..........................");
            while (!this.storeQueue.isEmpty())
            {
                Customer obslugiwany = this.storeQueue.dequeue();
                double kwota = 0;
                while (!obslugiwany.getOrderList().isEmpty())
                {
                    Order aktualne = obslugiwany.getOrderList().dequeue();
                    kwota+=(double)(aktualne.getProductUnitPrice()*aktualne.getProductAmount());
                    System.out.println(aktualne);
                }
                System.out.println(".........................\n\nZlecenie zrealizowane: " + obslugiwany.getCustomerName() + "\n" + "Do zapłaty: " + String.format("%1.2f",kwota) + " zł"+ "\n.........................." );
                this.orderSum += kwota;
                suma += kwota;
            }
            System.out.println( "Suma kwot za zamówienia: " +String.format("%1.2f",suma) + " zł" + "\n");
        }
    }
}
