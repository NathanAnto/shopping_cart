import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Invoker
public class Shop {
    private HashMap<UserAction, UserCommand> userCommands;
    private HashMap<Integer, UserCommand> commandHistory;
    private UserCommand currentCommand;

    private int historyIndex = -1;

    public Shop(ShoppingCart cart) {
        userCommands = new HashMap<>();
        commandHistory = new HashMap<>();

        // adding commands
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

    public void setCurrentCommand(UserAction action) {
        this.currentCommand = userCommands.get(action);
    }

    public void interaction() {
        historyIndex++;
        commandHistory.put(historyIndex, currentCommand);
        currentCommand.execute();
    }
}
