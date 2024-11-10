public class Main {
    public static void main(String[] args) {
        System.out.println("Hello shopping cart!");
        ShoppingCart cart1 = new ShoppingCart();
        Shop shop = new Shop(cart1);
        shop.setCurrentCommand(UserAction.add_to_cart);

        Product shirt = new Product("Shirt", 10.0, ProductCategory.clothing, 20);

        cart1.setAffectedProduct(shirt);
        shop.interaction();

        shop.setCurrentCommand(UserAction.add_discount);
        cart1.setDiscount(0.1); // 10%
        shop.interaction();
    }
}
