package baekjoon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class p10974 {
    private static List<String> permutation = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = i+1;
        }

        solve(array, 0);

        Collections.sort(permutation);
        for (String s : permutation) {
            System.out.println(s);
        }
    }

    private static void solve(int[] array, int i) {
        if (i == array.length - 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < array.length; j++) {
                stringBuilder.append(array[j] + " ");
            }
            permutation.add(stringBuilder.toString());
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
}
