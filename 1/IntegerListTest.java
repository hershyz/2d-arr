import java.util.Scanner;

public class IntegerListTest {

    static IntegerList list = new IntegerList(10);
    static Scanner scn = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("\n Menu ");
        System.out.println(" ====");
        System.out.println("0: Quit");
        System.out.println("1: Create a new list (** do this first!! **)");
        System.out.println("2: Print the list");
        System.out.println("3: Add an element");
        System.out.println("4: Remove first value");
        System.out.println("5: Remove all value");
        System.out.print("\nEnter your choice: ");
    }

    public static void dispatch(int choice) {
        int loc;
        switch(choice) {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                System.out.println("How big should the list be?");
                int size = scn.nextInt();
                list = new IntegerList(size);
                list.randomize();
                break;
            case 2:
                list.print();
                break;
            case 3:
                System.out.println("Element:");
                int element = scn.nextInt();
                list.addElement(element);
                break;
            case 4:
                System.out.println("Value:");
                int val = scn.nextInt();
                list.removeFirst(val);
                break;
            case 5:
                System.out.println("Value:");
                int _val = scn.nextInt();
                list.removeAll(_val);
                break;
            default:
                System.out.println("Sorry, invalid choice");
        }
    }
}
