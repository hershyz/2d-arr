import java.util.Scanner;

public class Square {

    //Square 2D array:
    public int[][] square;

    //Constructor, sets dimensions of square:
    public Square(int size) {
        square = new int[size][size];
    }

    //Sum of a row:
    public int sumRow(int index) {

        int sum = 0;
        int[] row = square[index];
        for (int x : row) {
            sum += x;
        }

        return sum;
    }

    //Sum of a column:
    public int sumColumn(int index) {

        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][index];
        }

        return sum;
    }

    //Sum of main diagonal (top left to bottom right):
    public int sumMainDiag() {

        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[i][i];
        }

        return sum;
    }

    //Sum of other diagonal (top right to bottom left):
    public int sumOtherDiag() {

        int sum = 0;
        int col = square.length - 1;
        for (int row = 0; row < square.length; row++) {
            sum += square[row][col];
            col--;
        }

        return sum;
    }

    //Read square from standard input:
    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++)
            for (int col = 0; col < square.length; col ++)
                square[row][col] = scan.nextInt();
    }

    //Prints the square:
    public void printSquare() {

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                System.out.print(square[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    //Determines if the square is 'magic' or not:
    public boolean magic() {

        int sum = sumRow(0);

        for (int i = 0; i < square.length; i++) {
            if (sumRow(i) != sum || sumColumn(i) != sum) {
                return false;
            }
        }

        if (sumMainDiag() != sum || sumOtherDiag() != sum) {
            return false;
        }

        return true;
    }
}
