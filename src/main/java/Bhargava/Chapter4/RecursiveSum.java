package Bhargava.Chapter4;

import java.util.Arrays;

public class RecursiveSum {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };
        int result = sum(array);
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println("\nsum = " + result);
    }

    public static int sum(int[] array) {
        if (array.length == 1)
            return array[0];
        else
            return array[0] + sum(Arrays.copyOfRange(array, 1, array.length));
    }
}
