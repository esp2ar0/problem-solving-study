package baekjoon.dynamic_programing_basic;

import java.util.Scanner;

public class problem_1463 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int[] DP = new int[X + 1];

        DP[1] = 0;

        for (int i = 2; i <= X; i++) {
            DP[i] = DP[i-1] + 1;
            if(i % 2 == 0) DP[i] = Math.min(DP[i], DP[i / 2] + 1);
            if(i % 3 == 0) DP[i] = Math.min(DP[i], DP[i / 3] + 1);
        }

        System.out.println(DP[X]);
    }
}