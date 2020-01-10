package baekjoon.back;

import java.util.Scanner;

/**
 * 백트래킹 단계별 1번
 */
public class p15649 {
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
