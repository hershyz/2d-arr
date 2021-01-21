import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SquareTest {

    public static void test() throws IOException {

        Scanner scan = new Scanner(new File("magicdata.txt"));
        int count = 1;
        int size = scan.nextInt();

        while (size != -1) {

            Square s = new Square(size);
            s.readSquare(scan);
            System.out.println("\n******** Square " + count + " ********");
            s.printSquare();

            //Print row sums:
            for (int i = 0; i < s.square.length; i++) {
                System.out.println("row " + i + ": " + s.sumRow(i));
            }

            //Print col sums:
            for (int i = 0; i < s.square.length; i++) {
                System.out.println("col " + i + ": " + s.sumColumn(i));
            }

            //Print diag sums:
            System.out.println("diag 1: " + s.sumMainDiag());
            System.out.println("diag 2: " + s.sumOtherDiag());

            //Print if is magic:
            System.out.println("magic: " + s.magic());
            System.out.println("");

            size = scan.nextInt();
            count++;
        }
    }
}
