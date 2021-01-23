import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TwoD_Boolean {

    boolean[][] data;

    public TwoD_Boolean(String filepath) throws IOException {

        Path p = Paths.get(filepath);
        List<String> lines = Files.readAllLines(p);
        data = new boolean[lines.size()][lines.size()];

        for (int i = 0; i < data.length; i++) {
            boolean[] row = new boolean[data.length];
            String[] split = lines.get(i).split(",");
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("0")) {
                    row[j] = false;
                }
                else {
                    row[j] = true;
                }
            }
            data[i] = row;
        }
    }

    public void print() {
        for (boolean[] x : data) {
            System.out.println(Arrays.toString(x));
        }
    }

    public int pairs() {
        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j]) {
                    counter++;
                }
            }
        }
        counter /= 2;
        return counter;
    }

    public static boolean common(int i, int j, boolean[][] arr) {

        for (int x = 0; x < arr[0].length; x++) {
            if (arr[i][x] == true && arr[j][x] == true && x != i && x != j) {
                return true;
            }
        }

        return false;
    }
}
