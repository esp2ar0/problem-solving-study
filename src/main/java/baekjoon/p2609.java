package baekjoon;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2609
 * 최대공약수와 최소공배수
 * 단계별 - 수학3 4번문제
 */
public class p2609 {

    private static void solve(int a, int b) {
        int lcm = a * b;
        if(a < b) {
            int temp = b;
            b = a;
            a = temp;
        }

        while(a % b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int gcd = b;
        lcm = lcm / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] splitLine = scanner.nextLine().split(" ");

        solve(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));

    }

}
