package baekjoon.fs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토
 */

public class p7576 {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int[][] a = new int[N][M];

            for (int i = 0; i < N; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < M; j++) {
                    a[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            solve(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int[][] a) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            if (x + 1 < a.length && a[x + 1][y] == 0) {
                queue.offer(new int[]{x + 1, y});
                a[x + 1][y] = a[x][y] + 1;
            }
            if (y + 1 < a[0].length && a[x][y + 1] == 0) {
                queue.offer(new int[]{x, y + 1});
                a[x][y + 1] = a[x][y] + 1;
            }
            if (x - 1 >= 0 && a[x - 1][y] == 0) {
                queue.offer(new int[]{x - 1, y});
                a[x - 1][y] = a[x][y] + 1;
            }
            if (y - 1 >= 0 && a[x][y - 1] == 0) {
                queue.offer(new int[]{x, y - 1});
                a[x][y - 1] = a[x][y] + 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if(a[i][j] > max) {
                    max = a[i][j];
                }
            }
        }

        System.out.println(--max);
    }
}
