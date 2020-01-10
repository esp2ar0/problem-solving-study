package baekjoon;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11653
 * 소인수분해
 * 단계별 - 수학3 3번문제
 *
 * 실패.
 * 해법 : 간단하게 생각해야했음.
 * 소수 부분 - 에라토스테네스의 체
 */
public class p11653 {

    private static void solve(int N) {
        for (int i = 2; i*i <= N; i++) {
            if(N % i == 0) {
                System.out.println(i);
                N = N / i;
                i--;
            }
        }
        if(N > 1) {
            System.out.println(N);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        solve(scanner.nextInt());
    }
}
