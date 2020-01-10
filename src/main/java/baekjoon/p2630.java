package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2630
 * 색종이 만들기
 * 단계별 - 분할정복 1번문제
 */
public class p2630 {
    static int whiteCount = 0;
    static int blueCount = 0;

    private static void solve(int[][] array, int columnStart, int columnEnd, int rowStart, int rowEnd) {
        if(isSameColor(array, columnStart, columnEnd, rowStart, rowEnd)) {
            if(array[columnStart][rowStart] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
        } else {
            int columnMid = (columnStart + columnEnd) / 2;
            int rowMid = (rowStart + rowEnd) / 2;
            solve(array, columnStart, columnMid, rowStart, rowMid);
            solve(array, columnStart, columnMid, rowMid + 1, rowEnd);
            solve(array, columnMid + 1, columnEnd, rowStart, rowMid);
            solve(array, columnMid + 1, columnEnd, rowMid + 1, rowEnd);
        }
    }

    private static boolean isSameColor(int[][] array, int columnStart, int columnEnd, int rowStart, int rowEnd) {
        if(columnStart == columnEnd) {
            return true;
        }
        int k = array[columnStart][rowStart];
        for (int i = columnStart; i <= columnEnd; i++) {
            for (int j = rowStart; j <= rowEnd; j++) {
                if(array[i][j] != k) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[][] array = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] splitLine = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    array[i][j] = Integer.parseInt(splitLine[j]);
                }
            }
            solve(array, 0, N - 1, 0, N - 1);
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }
}
