import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

// Reciever
public class ShoppingCart {
    private List<Product> items;
    private Product currentItem;
    private double discount = 0;

    public ShoppingCart() {
        this.items = new ArrayList<Product>();
    }

    public void setAffectedProduct(Product item) {
        this.currentItem = item;
    }

    public void setDiscount(double discount) {
        if(discount < 0 || discount > 1) {
            System.out.println("Invalid discount. Must be between 0 and 1");
            return;
        }
        this.discount = discount;
    }

    public void addItemToCart() {
        System.out.println("Adding an item " + currentItem + " to the cart");
        items.add(currentItem);
    }

    public void removeItemFromCart() {
        System.out.println("Removing an item from the cart");
        items.remove(currentItem);
    }

    public void applyDiscountToCart() {
        System.out.println("Adding discount to products");
        for (Product item : items) {
            double priceBefore = item.getPrice();
            item.setPrice(item.getPrice() - (item.getPrice() * discount));
            System.out.println(item + " went from " + priceBefore + " CHF to " + item.getPrice() + " CHF");
        }
    }

    public void checkOut() {
        System.out.println("Checking out the cart");
    }
}
