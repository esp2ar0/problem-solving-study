package baekjoon;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/3036
 * 링
 * 단계 - 수학3
 */
public class p3036 {

    private static void solve(int a, int b) {
        int aClone = a;
        int bClone = b;

        while(a % b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int gcd = b;

        System.out.println(aClone / gcd + "/" + bClone / gcd);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        String[] splitLine = scanner.nextLine().split(" ");

        int a = Integer.parseInt(splitLine[0]);

        for (int i = 1; i < N; i++) {
            solve(a, Integer.parseInt(splitLine[i]));
        }
    }
}
