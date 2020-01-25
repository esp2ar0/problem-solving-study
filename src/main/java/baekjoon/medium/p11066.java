package baekjoon.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11066
 * 파일 합치기
 *
 * DP문제
 *
 * dp[1][5] =
 * min {
 *     dp[1][1] + dp[2][5]
 *     dp[1][2] + dp[3][5]
 *     dp[1][3] + dp[4][5]
 *     dp[1][4] + dp[5][5]
 * }
 * +
 * sum(1, 5) {
 *     weight[1]
 *     weight[2]
 *     weight[3]
 *     weight[4]
 *     weight[5]
 * }
 *
 */
public class p11066 {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < T; i++) {
                int K = Integer.parseInt(bufferedReader.readLine());
                String[] splitLine = bufferedReader.readLine().split(" ");
                int[] weight = new int[K];

                for (int j = 0; j < K; j++) {
                    weight[j] = Integer.parseInt(splitLine[j]);
                }
                solve(K, weight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int K, int[] weight) {
        int[][] dp = new int[K][K];

        for (int i = 1; i < K; i++) {
            for (int j = 0; j < K - i; j++) {
                dp[j][j + i] = min(dp, j, j + i) + sum(weight, j, j + i);
            }
        }
        System.out.println(dp[0][K - 1]);
    }

    private static int min(int[][] dp, int start, int end) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < end - start; i++) {
            min = Math.min(min, dp[start][start + i] + dp[start + i + 1][end]);
        }
        return min;
    }

    private static int sum(int[] weight, int start, int end) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += weight[i];
        }
        return sum;
    }
}
