import Source.ListQueue;

public class Customer {

    private String customerName;
    private ListQueue<Order> order;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.order = new ListQueue<>();
    }

    public String getCustomerName() {
        return customerName;
    }
    public ListQueue<Order> getOrderList() {
        return order;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }
    public void setOrderList(ListQueue<Order> order) {
        this.order = order;
    }

}
