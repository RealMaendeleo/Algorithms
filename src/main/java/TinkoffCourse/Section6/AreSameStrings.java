package TinkoffCourse.Section6;

import java.util.Scanner;

import static TinkoffCourse.Section6.SubstringsSearch.getHash;

/**
 * Дан текст s длины n; индексы l1, r1, l2, r2 лежат внутри этого текста.
 * Проверить, одинаковы ли две подстроки s[l1..r1] и s[l2..r2]
 */

public class AreSameStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("String: ");
        String string = scanner.nextLine();

        boolean result = areSameStrings(string, 0, 2, 5, 7);
        System.out.println(result);
    }

    public static boolean areSameStrings(String string, int l1, int r1, int l2, int r2) {
        String sub1 = string.substring(l1, r1 + 1);
        String sub2 = string.substring(l2, r2 + 1);
        if (getHash(sub1) == getHash(sub2)) {
            return true;
        }
        return false;
    }
}
