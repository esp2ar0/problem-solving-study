package baekjoon.back;

import java.util.Scanner;

/**
 * 백트래킹 단계별 3
 */
public class p15651 {
    private static int[] permutation;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        permutation = new int[M];
        stringBuilder = new StringBuilder();

        solve(N, 0, M);
        System.out.println(stringBuilder);
    }

    private static void solve(int N, int index, int M) {
        if(index == M) {
            for (int i = 0; i < M; i++) {
                stringBuilder.append(permutation[i] + " ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            permutation[index] = i;
            solve(N, index + 1, M);
        }
    }
}
