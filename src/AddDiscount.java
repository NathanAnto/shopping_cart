public class AddDiscount implements UserCommand {
    private ShoppingCart cart;

    public AddDiscount(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.applyDiscountToCart();
    }
}
