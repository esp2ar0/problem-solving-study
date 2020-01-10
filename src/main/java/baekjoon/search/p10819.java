package baekjoon.search;

import java.util.Scanner;
import java.util.StringTokenizer;

public class p10819 {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] array = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        solve(array, 0);

        System.out.println(max);
    }

    private static void solve(int[] array, int i) {
        if (i == array.length - 1) {
            int result = calculate(array);
            if (result > max) {
                max = result;
            }
        }

        for (int j = i; j < array.length; j++) {
            swap(array, i, j);
            solve(array, i + 1);
            swap(array, i, j);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int calculate(int[] array) {
        int result = 0;

        for (int i = 1; i < array.length ; i++) {
            result += Math.abs(array[i - 1] - array[i]);
        }
        return result;
    }
}
