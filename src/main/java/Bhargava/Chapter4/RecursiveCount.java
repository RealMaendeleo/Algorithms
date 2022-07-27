package Bhargava.Chapter4;

import java.util.Arrays;

public class RecursiveCount {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };
        int result = count(array);
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println("\ncount = " + result);
    }

    public static int count(int[] array) {
        if (array.length == 1)
            return 1;
        else
            return 1 + count(Arrays.copyOfRange(array, 1, array.length));
    }
}
