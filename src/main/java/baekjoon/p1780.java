package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1780
 * 단계별 - 분할정복 3번 문제
 */
public class p1780 {

    private static int[] count = new int[3];

    private static void solve(int[][] array, int columnStart, int rowStart, int length) {
        if(isSameColor(array, columnStart, rowStart, length)) {
            if(array[columnStart][rowStart] == -1) {
                count[0]++;
            } else if(array[columnStart][rowStart] == 0){
                count[1]++;
            } else {
                count[2]++;
            }
        } else {
            int nextLength = length / 3;

            solve(array, columnStart, rowStart, nextLength);
            solve(array, columnStart + nextLength, rowStart, nextLength);
            solve(array, columnStart + nextLength * 2, rowStart, nextLength);

            solve(array, columnStart, rowStart + nextLength, nextLength);
            solve(array, columnStart + nextLength, rowStart + nextLength, nextLength);
            solve(array, columnStart + nextLength * 2, rowStart + nextLength, nextLength);

            solve(array, columnStart, rowStart + nextLength * 2, nextLength);
            solve(array, columnStart + nextLength, rowStart + nextLength * 2, nextLength);
            solve(array, columnStart + nextLength * 2, rowStart + nextLength * 2, nextLength);
        }
    }

    private static boolean isSameColor(int[][] array, int columnStart, int rowStart, int length) {
        if(length == 1) {
            return true;
        }
        int k = array[columnStart][rowStart];
        for (int i = columnStart; i < columnStart + length; i++) {
            for (int j = rowStart; j < rowStart + length; j++) {
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
            solve(array, 0, 0, N);
        } catch(IOException e) {
            e.printStackTrace();
        }

        for (int i : count) {
            System.out.println(i);
        }
    }
}
