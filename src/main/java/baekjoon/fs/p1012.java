package baekjoon.fs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1012 {
    private static int count = 0;

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < T; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int M = Integer.parseInt(stringTokenizer.nextToken());
                int N = Integer.parseInt(stringTokenizer.nextToken());
                int K = Integer.parseInt(stringTokenizer.nextToken());
                int[][] a = new int[N][M];

                for (int j = 0; j < K; j++) {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                    int x = Integer.parseInt(stringTokenizer.nextToken());
                    int y = Integer.parseInt(stringTokenizer.nextToken());
                    a[y][x] = 1;
                }

                solve(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(a[i][j] == 1) {
                    f(a, i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        count = 0;
    }

    private static void f(int[][] a, int i, int j) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] != 1) {
            return;
        }
        a[i][j] = -1;

        f(a, i-1, j);
        f(a, i+1, j);
        f(a, i, j-1);
        f(a, i, j+1);
    }
}
