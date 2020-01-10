package legacy.baekjoon.dynamic_programing_basic;

import java.io.*;

public class problem_1149 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int costs[][] = new int[N][3];
            int sum[][] = new int[N][3];

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    costs[i][j] = Integer.parseInt(line[j]);
                }
            }
            for (int i = 0; i < 3; i++) {
                sum[0][i] = costs[0][i];
            } //initialize

            for (int i = 1; i < N; i++) {
                sum[i][0] = Math.min(sum[i-1][1], sum[i-1][2]) + costs[i][0];
                sum[i][1] = Math.min(sum[i-1][0], sum[i-1][2]) + costs[i][1];
                sum[i][2] = Math.min(sum[i-1][0], sum[i-1][1]) + costs[i][2];
            }

            bw.write(Integer.toString(Math.min(Math.min(sum[N-1][0], sum[N-1][1]), sum[N-1][2])));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}