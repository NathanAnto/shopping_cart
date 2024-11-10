public class Product {
    protected String name;
    protected double price;
    protected ProductCategory category;
    protected int quantity;

    public Product(String name, double price, ProductCategory category, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void order() {
        quantity--;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
