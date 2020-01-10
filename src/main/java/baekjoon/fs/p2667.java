package baekjoon.fs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 단지번호붙이기
 */
public class p2667 {
    private static int count = 0;
    private static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[][] a = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = bufferedReader.readLine();
                for (int j = 0; j < N; j++) {
                    a[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }

            solve(a);

            System.out.println(list.size());
            Collections.sort(list);
            for (Integer integer : list) {
                System.out.println(integer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    f(a, i, j);
                    list.add(count);
                    count = 0;
                }
            }
        }
    }

    private static void f(int[][] a, int i, int j) {
        if (i < 0 || j < 0 || i >= a.length || j >= a.length || a[i][j] != 1) {
            return;
        }

        a[i][j] = -1;
        count++;

        f(a, i - 1, j);
        f(a, i + 1, j);
        f(a, i, j - 1);
        f(a, i, j + 1);
    }
}
