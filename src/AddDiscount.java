import java.util.ArrayList;
import java.util.List;

public class AddDiscount implements UserCommand {
    private ShoppingCart cart;
    private final List<Double> discountValues;

    public AddDiscount(ShoppingCart cart) {
        this.cart = cart;
        this.discountValues = new ArrayList<>();
    }

    @Override
    public void execute() {
        cart.applyDiscountToCart();
        discountValues.add(cart.getDiscount());
    }

    @Override
    public void undo() {
        double prevDiscount = cart.getDiscount();
        if (discountValues.size() <= 1) {
            cart.setDiscount(0);
        } else {
            cart.setDiscount(discountValues.get(discountValues.size() - 1));
        }
        cart.applyDiscountToCart();
        System.out.println("Undoing discount. Previous discount: " + prevDiscount + " New discount: " + cart.getDiscount());
    }
}
