package Bhargava.Chapter4;

import java.util.Arrays;

public class RecursiveMax {
    public static void main(String[] args) {
        int[] array = { 1, 3, 2 , 25, 8};
        int result = max(array);
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println("\nmax = " + result);
    }

    public static int max(int[] array) {
        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }
        else {
            return Math.max(array[0], max( Arrays.copyOfRange(array, 1, array.length) ));
        }
    }
}
