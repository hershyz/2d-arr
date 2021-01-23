import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {

    public static void start() {

        List<Item> cart = new ArrayList<>();
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        double totalPrice = 0;
        String keepShopping = "y";

        while (keepShopping.equals("y")) {

            Scanner scan = new Scanner(System.in);

            System.out.print ("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();

            // *** create a new item and add it to the cart
            item = new Item(itemName, itemPrice, quantity);
            int n = item.getQuantity();
            for (int i = 0; i < n; i++) {
                cart.add(item);
            }
            // *** print the contents of the cart object using println
            System.out.println("Cart:");
            for (Item x : cart) {
                x.print();
                totalPrice += item.getItemPrice();
            }
            System.out.println("Current Total Price: $" + totalPrice);

            System.out.println("");
            System.out.print("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();
            keepShopping = scan.nextLine();
        }
    }
}
