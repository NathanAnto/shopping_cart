public class Checkout implements UserCommand {
    private ShoppingCart cart;

    public Checkout(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        this.cart.checkOut();
    }

    @Override
    public void undo() {
        System.out.println("Checkout cannot be undone");
    }
}
