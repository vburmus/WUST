public class Order {

    private String productName;
    private int productAmount;
    private double productUnitPrice;

    public Order(String productName, int productAmount, double productUnitPrice) {
        this.productName = productName;
        this.productAmount = productAmount;
        this.productUnitPrice = productUnitPrice;
    }

    public String getProductName() {
        return productName;
    }
    public int getProductAmount() {
        return productAmount;
    }
    public double getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }
    public void setProductUnitPrice(double productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    @Override
    public String
    toString() {
        return String.format("%10s%10d",getProductName().toUpperCase(), getProductAmount());
    }
}
