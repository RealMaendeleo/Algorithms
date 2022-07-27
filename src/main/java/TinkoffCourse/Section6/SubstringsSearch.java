package TinkoffCourse.Section6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Дан текст t длиной n и паттерн p длиной m.
 * Проверить, является ли паттерн p подстрокой строки t
 */

public class SubstringsSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("String: ");
        String string = scanner.nextLine();
        System.out.print("Pattern: ");
        String pattern = scanner.nextLine();

        int[] indexes = naiveSearch(string, pattern);
        printMatches(indexes);

//        int[] indexes = hashSearch(string, pattern);
//        printMatches(indexes);
    }

    // возвращает массив позиций, откуда начинается каждое вхождение
    public static int[] naiveSearch(String string, String pattern) {
        int n = string.length();
        int m = pattern.length();
        List<Integer> startIndexes = new ArrayList<>();

        for (int i = 0; i < n - m; i++) {
            if (string.substring(i, i + m).equals(pattern)) {
                startIndexes.add(i);
            }
        }
        if (startIndexes.isEmpty()) {
            return new int[]{-1};
        }
        return startIndexes.stream().mapToInt(i->i).toArray();
    }

    // Алгоритм Рабина-Карпа
    public static int[] hashSearch(String string, String pattern) {
        int n = string.length();
        int m = pattern.length();
        List<Integer> startIndexes = new ArrayList<>();

        for (int i = 0; i < n - m; i++) {
            String substring = string.substring(i, i + m);
            if (getHash(pattern) == getHash(substring)) {
                startIndexes.add(i);
            }
        }
        return startIndexes.stream().mapToInt(i->i).toArray();
    }

    public static int getHash(String string) {
        int n = string.length();
        int prime = 31;
        int[] primePowers = new int[n];

        for (int i = 0; i < n; i++) {
            primePowers[i] = (int) Math.pow(prime, i);
        }

        int hash = 0;
        for (int i = 0; i < n; i++) {
            hash += (primePowers[i] * string.charAt(i)) % 1e8;
        }
        return hash;
    }

    public static void printMatches(int[] indexes) {
        if (indexes[0] == -1) {
            System.out.println("Pattern doesn't match string");
        } else {
            System.out.print("Pattern occurs in string at indexes:");
            for (int index : indexes) {
                System.out.print(" " + index);
            }
        }
    }
}
