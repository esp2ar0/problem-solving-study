package baekjoon;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11051
 * 이항계수2
 * 단계별 수학3
 */
public class p11051 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splitLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int k = Integer.parseInt(splitLine[1]);
        int[][] array = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == i || j == 0){
                    array[i][j] = 1;
                }
                else {
                    array[i][j] = array[i-1][j-1] + array[i-1][j];
                }
                array[i][j] %= 10007;
            }
        }

        System.out.println(array[n][k]);
    }
}
