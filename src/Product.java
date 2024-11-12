public class Product {
    protected String name;
    protected double price;
    protected double discountedPrice;
    protected ProductCategory category;
    protected int quantity;

    public Product(String name, double price, ProductCategory category, int quantity) {
        this.name = name;
        this.price = price;
        this.discountedPrice = price;
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

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setPrice(double price) {
        if(this.price != price)
            this.discountedPrice = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void itemBought() {
        quantity--;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
