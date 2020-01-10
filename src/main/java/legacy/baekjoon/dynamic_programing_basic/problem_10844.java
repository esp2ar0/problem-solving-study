package legacy.baekjoon.dynamic_programing_basic;

import java.util.Scanner;

public class problem_10844 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] dp = new int[N + 1][10 + 1];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if(j == 0) dp[i][j] = dp[i-1][j+1];
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                dp[i][j] %= 1000000000;
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i];
            sum %= 1000000000;
        }

        System.out.println(sum);
    }
}
