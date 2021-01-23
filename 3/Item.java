public class Item {

    String itemName;
    double itemPrice;
    int quantity;

    public Item(String name, double price, int q) {

        itemName = name;
        itemPrice = price;
        quantity = q;
    }

    public int getQuantity() {
        return quantity;
    }

    public void print() {
        System.out.println("item: " + itemName + ", price: " + itemPrice + ", #: " + quantity);
    }

    public double getItemPrice() {
        return itemPrice;
    }
}
