import Source.EmptyQueueException;

public class Main {

    public static void main (String [] args) throws EmptyQueueException
    {
        Firma firm = new Firma();
        Store biedronka = new Store("Biedronka");
        Store lidl = new Store("Lidl");
        Store auchan = new Store("Auchan");
        firm.getShops().enqueue(biedronka);
        firm.getShops().enqueue(lidl);
        firm.getShops().enqueue(auchan);

        Customer k1 = new Customer("Bartosz Frej");
        Customer k2 = new Customer("Michal Niezgoda");
        Customer k3 = new Customer("Jan Cebula");
        Customer k4 = new Customer("Krzystof Szmidla");
        Customer k5 = new Customer("Mariusz Kalis");
        Customer k6 = new Customer("Jan Zaludla");
        biedronka.getStoreQueue().enqueue(k1);
        biedronka.getStoreQueue().enqueue(k2);
        lidl.getStoreQueue().enqueue(k3);
        lidl.getStoreQueue().enqueue(k4);
        lidl.getStoreQueue().enqueue(k5);
        auchan.getStoreQueue().enqueue(k6);
        k1.getOrderList().enqueue(new Order("mleko", 3, 3.4));
        k1.getOrderList().enqueue(new Order("masło", 5, 3.22));
        k2.getOrderList().enqueue(new Order("masło", 1, 3.22));
        k2.getOrderList().enqueue(new Order("pomidor", 5, 4.50));
        k2.getOrderList().enqueue(new Order("jaja", 20, 1.2));
        k2.getOrderList().enqueue(new Order("pierniki", 1, 10.65));
        k3.getOrderList().enqueue(new Order("jablka", 7, 3.2));
        k3.getOrderList().enqueue(new Order("papryka", 1, 4.33));
        k4.getOrderList().enqueue(new Order("ogorek", 8, 3.20));
        k4.getOrderList().enqueue(new Order("masło", 2, 3.22));
        k4.getOrderList().enqueue(new Order("pierniki", 11, 10.65));
        k5.getOrderList().enqueue(new Order("pierniki", 5, 10.65));
        k5.getOrderList().enqueue(new Order("jablka", 1, 3.2));
        k5.getOrderList().enqueue(new Order("papryka", 1, 4.33));
        k6.getOrderList().enqueue(new Order("pierniki", 2, 10.65));
        k6.getOrderList().enqueue(new Order("jablka", 12, 3.2));
        k6.getOrderList().enqueue(new Order("papryka", 12, 4.33));
        k6.getOrderList().enqueue(new Order("ogorek", 12, 3.20));
        biedronka.obsluga();
        lidl.obsluga();
        auchan.obsluga();
        firm.przychodyFirmy();























    }
}
