package Bhargava.Chapter1;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = { 1, 3, 8, 25, 74, 80, 85, 90, 101, 140 };
        int item = 10;
        int index = find(array, item);

        if (index == -1)
            System.out.println("There is no such element in array");
        else
            System.out.println("Element " + item + " at index " + index);
    }

    public static int find(int[] array, int item) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (array[mid] == item) {
                return mid;
            } else if (array[mid] > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
