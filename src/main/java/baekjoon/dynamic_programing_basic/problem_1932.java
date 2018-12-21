package baekjoon.dynamic_programing_basic;

import java.io.*;
import java.util.Arrays;

public class problem_1932 {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            String[] numbers;
            int t[][] = new int[n][n];

            for (int i = 0; i < n; i++) {
                numbers = br.readLine().split(" ");
                for (int j = 0; j < i + 1; j++) {
                    t[i][j] = Integer.parseInt(numbers[j]);
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if(j == 0) t[i][j] += t[i-1][j];
                    else if(j == i) t[i][j] += t[i-1][j-1];
                    else t[i][j] += Math.max(t[i-1][j-1], t[i-1][j]);
                }
            }
            Arrays.sort(t[n-1]);

            bw.write(Integer.toString(t[n-1][n-1]));
            bw.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
