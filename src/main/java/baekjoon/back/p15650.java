package baekjoon.back;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백트래킹 단계별 2
 */

public class p15650 {
    private static int[] permutation;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        permutation = new int[M];

        solve(N, new boolean[N + 1], 0, M);
    }

    private static void solve(int N, boolean[] visited, int index, int M) {
        if(index == M) {
            int[] temp = new int[M];
            for (int i = 0; i < M; i++) {
                temp[i] = permutation[i];
            }

            Arrays.sort(temp);
            for (int i = 0; i < M; i++) {
                if(temp[i] != permutation[i]) {
                    return;
                }
            }

            for (int i : permutation) {
                System.out.print(i + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 1; i <= N; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            permutation[index] = i;
            solve(N, visited, index + 1, M);
            visited[i] = false;
        }
    }
}
