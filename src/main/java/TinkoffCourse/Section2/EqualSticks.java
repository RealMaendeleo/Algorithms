package TinkoffCourse.Section2;

/**
 * Есть n палок различной длины. Необходимо разделить их
 * на k палок равной длины так, чтобы эта длина была максимальной.
 */

public class EqualSticks {
    public static void main(String[] args) {
        int n = 4;
        int[] sticks = new int[n];
        sticks[0] = 5;
        sticks[1] = 4;
        sticks[2] = 4;
        sticks[3] = 2;
        int minStick = min(sticks);

        int sticksCount = 0;
        for (int i = 0; i < n; i++) {
            sticksCount += sticks[i] / minStick;
        }
        System.out.println(sticksCount);
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
