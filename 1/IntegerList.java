public class IntegerList {

    //Class list:
    int[] list;

    //Constructor, sets starting size:
    public IntegerList(int size) {
        list = new int[size];
    }

    //Fills the array with random numbers from 1 - 100 (inclusive):
    public void randomize() {
        for (int i = 0; i < list.length; i++) {
            list[i] = (int)(Math.random() * 100) + 1;
        }
    }

    //Prints all values in the array:
    public void print() {
        for (int i = 0; i < list.length; i++) {
            System.out.println(i + ":\t" + list[i]);
        }
    }

    //Increase size:
    public void increaseSize(int increment) {

        //Generates new temporary array:
        int[] temp = new int[list.length + increment];
        for (int i = 0; i < list.length; i++) {
            temp[i] = list[i];
        }

        //Assign list array to new temporary array:
        list = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            list[i] = temp[i];
        }
    }

    //Add element:
    public void addElement(int element) {

        boolean found = false;

        //Looks for an existing empty space:
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 0 && !found) {
                list[i] = element;
                found = true;
            }
        }

        //If there is no empty space, we must increase the size of the array by 1 and then put the new element in the last place:
        if (!found) {
            increaseSize(1);
            list[list.length - 1] = element;
        }
    }

    //Remove first:
    public void removeFirst(int val) {

        //Generates temporary array:
        int[] temp = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            temp[i] = list[i];
        }

        //Finds first occurrence of the value:
        int occurIndex = -1;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == val) {
                occurIndex = i;
            }
        }

        //If the value is not found in the list, nothing happens:
        if (occurIndex == -1) {
            return;
        }

        //If the value is found in the list and the array is only one element long, it is cleared entirely:
        if (list.length == 1) {
            list = new int[0];
            return;
        }

        //If the value is the last value in the list, it is simply set to zero:
        if (occurIndex == list.length - 1) {
            list[list.length - 1] = 0;
            return;
        }

        //If the value is found in the list, everything becomes shifted down by one index:
        for (int i = occurIndex; i < temp.length - 1; i++) {
            temp[i] = list[i + 1];
        }
        temp[temp.length - 1] = 0;

        //Assigns array to temp:
        list = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            list[i] = temp[i];
        }
    }

    //Remove all:
    public void removeAll(int val) {

        //Remove first occurrence until the value no longer exists in the list:
        while (contains(val)) {
            removeFirst(val);
        }
    }

    //Contains (diagnostic function):
    public boolean contains(int val) {
        for (int x : list) {
            if (x == val) {
                return true;
            }
        }
        return false;
    }
}
