package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1992
 * 쿼드트리
 * 단계별 - 분할정복 2번문제
 */
public class p1992 {
    static StringBuilder stringBuilder = new StringBuilder();

    private static void solve(int[][] array, int columnStart, int columnEnd, int rowStart, int rowEnd) {
        if(isSameColor(array, columnStart, columnEnd, rowStart, rowEnd)) {
            if(array[columnStart][rowStart] == 0) {
                stringBuilder.append("0");
            } else {
                stringBuilder.append("1");
            }
        } else {
            stringBuilder.append("(");
            int columnMid = (columnStart + columnEnd) / 2;
            int rowMid = (rowStart + rowEnd) / 2;
            solve(array, columnStart, columnMid, rowStart, rowMid);
            solve(array, columnStart, columnMid, rowMid + 1, rowEnd);
            solve(array, columnMid + 1, columnEnd, rowStart, rowMid);
            solve(array, columnMid + 1, columnEnd, rowMid + 1, rowEnd);
            stringBuilder.append(")");
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
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    array[i][j] = line.charAt(j) - '0';
                }
            }

            solve(array, 0, N - 1, 0, N - 1);

        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder.toString());
    }
}
