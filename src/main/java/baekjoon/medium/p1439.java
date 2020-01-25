package baekjoon.medium;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1439
 * 뒤집기
 */
public class p1439 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        int count[] = new int[2];

        if (S.charAt(0) == '0') {
            count[0]++;
        } else {
            count[1]++;
        }

        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) != S.charAt(i)) {
                count[S.charAt(i) - '0']++;
            }
        }

        System.out.println(Math.min(count[0], count[1]));
    }
}
