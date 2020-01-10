package baekjoon.back;

import java.util.Scanner;

/**
 * 백트래킹 단계별
 * N-Queen
 */
public class p9663 {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        solve(new int[N], 0);
        System.out.println(count);
    }

    private static void solve(int[] column, int row) {
        if(row == column.length) {
            count++;
            return;
        }

        for (int i = 0; i < column.length; i++) {
            column[row] = i;
            if(isPossible(column, row)) {
                solve(column, row + 1);
            }
        }
    }

    private static boolean isPossible(int[] column, int row) {
        for (int j = 0; j < row; j++) {
            if(column[row] == column[j] || Math.abs(j - row) == Math.abs(column[j] - column[row])) {
                return false;
            }
        }
        return true;
    }
}
