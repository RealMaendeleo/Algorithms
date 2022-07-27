package Other;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 35;
        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);

        long result;
        result = fibEffective(n);
        System.out.printf("fib(%d) = %d\n", n, result);

        long startTime = System.currentTimeMillis();
        result = fibEffective(n);
        long endTime = System.currentTimeMillis();
        System.out.printf(" - effective (%dms.)\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        result = fibNaive(n, mem);
        endTime = System.currentTimeMillis();
        System.out.printf(" - naive with memoization (%dms.)\n", endTime - startTime);

        startTime = System.currentTimeMillis();
        result = fibNaive(n);
        endTime = System.currentTimeMillis();
        System.out.printf(" - naive (%dms.)\n", endTime - startTime);
    }

    public static int fibNaive(int n) {
        if (n >= 0 && n <= 1) {
            return n;
        } else {
            return fibNaive(n - 1) + fibNaive(n - 2);
        }
    }

    public static long fibNaive(int n, long[] mem) {
        if (mem[n] != -1) {
            return mem[n];
        }

        if (n >= 0 && n <= 1) {
            return n;
        }
        long result = fibNaive(n - 1, mem) + fibNaive(n - 2, mem);
        mem[n] = result;

        return result;
    }

    public static long fibEffective(int n) {
        long first = 0;
        long second = 1;
        long prevSecond;

        if (n >= 0 && n <= 1) {
            return n;
        }
        for (int i = 1; i < n; i++) {
            prevSecond = second;
            second += first;
            first = prevSecond;
        }
        return second;
    }
}
