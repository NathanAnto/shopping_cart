import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shop {
    private static volatile Shop instance;
    private User activeUser;

    private Shop() {}

    public static Shop getInstance() {
        if (instance == null) {
            synchronized (Shop.class) {
                if (instance == null) {
                    instance = new Shop();
                }
            }
        }
        return instance;
    }

    public void setActiveUser(User user) {
        this.activeUser = user;
    }
}
