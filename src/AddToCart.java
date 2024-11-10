public class AddToCart implements UserCommand {
    private ShoppingCart cart;

    public AddToCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.addItemToCart();
    }
}
