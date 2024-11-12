public class RemoveFromCart implements UserCommand {
    private ShoppingCart cart;

    public RemoveFromCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.removeItemFromCart();
    }

    @Override
    public void undo() {
        cart.addItemToCart();
    }
}
