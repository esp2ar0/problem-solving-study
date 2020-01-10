package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 외판원순회
 */
public class p2098 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[][] W = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < N; j++) {
                    W[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            boolean[] visited = new boolean[N];
            solve(W, visited, 0, 0, 0, 0);

            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int[][] W, boolean[] visited, int count, int sum, int start, int v) {
        if (count == W.length && W[v][start] != 0) {
            sum += W[v][start];
            if(sum < min) {
                min = sum;
            }
        }

        for (int i = 0; i < W.length; i++) {
            if(count == 0) {
                start = i;
            }
            if(visited[i] || (W[v][i] == 0 && count != 0)) {
                continue;
            }
            visited[i] = true;
            sum += W[v][i];
            solve(W, visited, count + 1, sum, start, i);
            visited[i] = false;
            sum -= W[v][i];
        }
    }
}
