public class Main {
    public static void main(String[] args) {
        System.out.println("Hello shopping cart!");

        ShoppingCart cart1 = new ShoppingCart();
        User user1 = new User("Nathan", cart1);

        Shop shop = Shop.getInstance();
        shop.setActiveUser(user1);

        // Create products
        Product shirt = new Product("Shirt", 10.0, ProductCategory.clothing, 20);
        Product pants = new Product("Pants", 20.0, ProductCategory.clothing, 10);

        user1.addProductToCart(shirt);
        user1.addProductToCart(pants);

        user1.showCartProducts();
        // user1.undo();

        user1.applyDiscountToCart(0.1);
        // user1.undo();

        user1.showCartProducts();
        user1.showUserHistory();
    }
}
