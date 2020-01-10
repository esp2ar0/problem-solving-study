package baekjoon.fs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로찾기
 * 내가 원했던 문제다
 * 전 단계처럼 DFS로 했으나 오답.
 * BFS로 풀었어야 했다.
 * DP처럼 풀리기도 한다.
 */

public class p2178 {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            int[][] a = new int[N][M];

            for (int i = 0; i < N; i++) {
                String s = bufferedReader.readLine();
                for (int j = 0; j < s.length(); j++) {
                    a[i][j] = Character.getNumericValue(s.charAt(j));
                }
            }

            solve(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int[][] a) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[a.length][a[0].length];

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int x;
        int y;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            x = temp[0];
            y = temp[1];

            if (x == a.length - 1 && y == a[0].length - 1) {
                break;
            }

            if (x + 1 < a.length && a[x + 1][y] == 1 && !visited[x + 1][y]) {
                queue.offer(new int[]{x + 1, y});
                visited[x + 1][y] = true;
                a[x+1][y] += a[x][y];
            }
            if (y + 1 < a[0].length && a[x][y + 1] == 1 && !visited[x][y + 1]) {
                queue.offer(new int[]{x, y + 1});
                visited[x][y + 1] = true;
                a[x][y+1] += a[x][y];
            }
            if (x - 1 >= 0 && a[x - 1][y] == 1 && !visited[x - 1][y]) {
                queue.offer(new int[]{x - 1, y});
                visited[x - 1][y] = true;
                a[x-1][y] += a[x][y];
            }
            if (y - 1 >= 0 && a[x][y - 1] == 1 && !visited[x][y - 1]) {
                queue.offer(new int[]{x, y - 1});
                visited[x][y - 1] = true;
                a[x][y-1] += a[x][y];
            }
        }

        System.out.println(a[a.length - 1][a[0].length - 1]);
    }
}
