public class Product {
    private String productName;
    private int productPrice;
    private ProductCategory category;
    private int quantity;

    public Product() {}

    public void order() {
        quantity--;
    }
}
