import java.util.HashMap;

// Invoker
public class User {
    private String username;
    private ShoppingCart cart;

    private final HashMap<UserAction, UserCommand> userCommands;
    private final HashMap<Integer, UserCommand> commandHistory;
    private UserCommand currentCommand;

    private int historyIndex = -1;

    private Shop shop = Shop.getInstance();

    public User(String name, ShoppingCart cart) {
        this.username = name;
        this.cart = cart;

        userCommands = new HashMap<>();
        commandHistory = new HashMap<>();

        for (UserAction action : UserAction.values()) {
            switch (action) {
                case add_to_cart:
                    userCommands.put(action, new AddToCart(cart));
                    break;
                case remove_from_cart:
                    userCommands.put(action, new RemoveFromCart(cart));
                    break;
                case add_discount:
                    userCommands.put(action, new AddDiscount(cart));
                    break;
                case checkout:
                    userCommands.put(action, new Checkout(cart));
                    break;
            }
        }
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCurrentCommand(UserAction action) {
        this.currentCommand = userCommands.get(action);
    }

    public void interaction() {
        historyIndex++;
        commandHistory.put(historyIndex, currentCommand);
        currentCommand.execute();
    }

    public void addProductToCart(Product product) {
        setCurrentCommand(UserAction.add_to_cart);
        cart.setAffectedProduct(product);

        interaction();
    }

    public void removeProductFromCart(Product product) {
        setCurrentCommand(UserAction.remove_from_cart);
        cart.setAffectedProduct(product);
        interaction();
    }

    public void applyDiscountToCart(double discount) {
        setCurrentCommand(UserAction.add_discount);
        cart.setDiscount(discount);
        interaction();
    }

    public void showUserHistory() {


    }
}
